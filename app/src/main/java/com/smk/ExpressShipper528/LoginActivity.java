package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.smk.ExpressShipper528.R;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.smk.clients.NetworkEngine;
import com.smk.model.AccessToken;
import com.smk.skalertmessage.SKToastMessage;
import com.smk.util.MCrypt;
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

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_login) {

                startActivity(new Intent(LoginActivity.this, CargoPlaceActivity.class));

                /*if (checkFeild()) {
                    //getAccessToken(edt_username.getText().toString(), edt_password.getText().toString());
                }*/

                NetworkEngine.getInstance().postUser("peterphyo.1999@gmail.com", "ppl4325ppl", new Callback<AccessToken>() {
                    @Override
                    public void success(AccessToken accessToken, Response response) {

                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
            if (v == btn_register){
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }

        }
    };

    public void getAccessToken(String username, String password) {
        dialog = new ZProgressHUD(this);
        dialog.show();
        NetworkEngine.getInstance().getAccessToken("password", "04061990", "PAYMENTSRTCLIENT", "payment-client", username, password, new Callback<AccessToken>() {
            @Override
            public void success(AccessToken accessToken, Response response) {
                dialog.dismissWithSuccess();
                if (chk_remember.isChecked()) {
                    accessToken.getUser().setPassword(MCrypt.getInstance().encrypt(edt_password.getText().toString()));
                    StoreUtil.getInstance().saveTo("users", accessToken);
                }
                //startActivity(new Intent(getApplicationContext(), MainActivity.class).putExtra("access_token", new Gson().toJson(accessToken)));
                finish();
            }

            @Override
            public void failure(RetrofitError error) {
                /*if(error.getResponse() != null)
                    //Log.i(TAG, error.getCause().toString());*/

                if (error.getResponse() != null) {
                    switch (error.getResponse().getStatus()) {
                        case 400:
                            String message1 = (String) error.getBodyAs(String.class);
                            SKToastMessage.showMessage(LoginActivity.this, message1, SKToastMessage.ERROR);
                            break;
                        case 401:
                            String message2 = (String) error.getBodyAs(String.class);
                            SKToastMessage.showMessage(LoginActivity.this, message2, SKToastMessage.ERROR);
                            break;
                        default:
                            break;
                    }
                }
                dialog.dismissWithFailure();
            }
        });
    }

    private boolean checkFeild() {
        if (edt_username.getText().length() == 0) {
            edt_username.setError(getResources().getString(R.string.invalid_username));
            return false;
        }
        if (edt_password.getText().length() == 0) {
            edt_password.setError(getResources().getString(R.string.invalid_password));
            return false;
        }
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        /*client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.smk.makepayment/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);*/
    }

    @Override
    public void onStop() {
        super.onStop();

        /*// ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.smk.makepayment/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();*/
    }
}
