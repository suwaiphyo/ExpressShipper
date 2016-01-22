package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.smk.clients.NetworkEngine;
import com.smk.model.User;
import com.smk.util.StoreUtil;
import com.thuongnh.zprogresshud.ZProgressHUD;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends BaseAppCompatActivity {

    private static final String TAG = "Make Money";
    private EditText edt_username, edt_password;
    private Button btn_login;
    private ZProgressHUD dialog;
    private CheckBox chk_remember;
    private Toolbar toolbar;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        toolbar.setTitle(R.string.strmm_login_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_password = (EditText) findViewById(R.id.edt_password);
        chk_remember = (CheckBox) findViewById(R.id.chk_remember_account);

        User user = StoreUtil.getInstance().selectFrom("users");
        if (user != null) {
            Intent i = new Intent(LoginActivity.this, CargoPlaceActivity.class);
            startActivity(i);
        }
/*        AccessToken accessToken = StoreUtil.getInstance().selectFrom("users");
        if (accessToken != null) {
            getAccessToken(accessToken.getUser().getEmail(), MCrypt.getInstance().decrypt(accessToken.getUser().getPassword()));
            edt_username.setText(accessToken.getUser().getEmail());
            edt_password.setText(MCrypt.getInstance().decrypt(accessToken.getUser().getPassword()));
            chk_remember.setChecked(true);
        }*/

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_login.setOnClickListener(clickListener);
        btn_register.setOnClickListener(clickListener);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        finish();
        return super.getSupportParentActivityIntent();
    }

    private void LoginUser() {
        dialog = new ZProgressHUD(this);
        dialog.show();
        NetworkEngine.getInstance().postLogin(edt_username.getText().toString(), edt_password.getText().toString(), new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                dialog.dismissWithSuccess();
                if (chk_remember.isChecked()) {
                    StoreUtil.getInstance().saveTo("users", user);
                }
                Intent i = new Intent(LoginActivity.this, CargoPlaceActivity.class);
                startActivity(i);
            }

            @Override
            public void failure(RetrofitError error) {
                dialog.dismissWithFailure();
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v == btn_login) {
                if (checkField()) {
                    LoginUser();
                }
            }
            if (v == btn_register) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        }
    };

    private boolean checkField() {


        //String email = edt_username.getText().toString().trim();
        //String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (edt_username.getText().length() == 0) {
            edt_username.setError(getResources().getString(R.string.invalid_username));
            return false;
        }

        if (edt_password.getText().length() == 0 && edt_password.getText().length() < 6) {
            edt_password.setError(getResources().getString(R.string.invalid_password));
            edt_password.requestFocus();
            return false;
        }
        return true;
    }
}
