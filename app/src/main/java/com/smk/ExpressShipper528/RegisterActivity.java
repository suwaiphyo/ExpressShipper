package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smk.clients.NetworkEngine;
import com.smk.model.User;
import com.smk.util.StoreUtil;
import com.thuongnh.zprogresshud.ZProgressHUD;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RegisterActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private Button btn_login_back;
    private Button btn_submit;
    private EditText name, email, password, phone;
    private ZProgressHUD dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        toolbar.setTitle(R.string.strmm_register_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_login_back = (Button) findViewById(R.id.btn_login_back);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        name = (EditText) findViewById(R.id.edt_name);
        email = (EditText) findViewById(R.id.edt_email);
        password = (EditText) findViewById(R.id.edt_password);
        phone = (EditText) findViewById(R.id.edt_phone);

        btn_login_back.setOnClickListener(clickListener);
        btn_submit.setOnClickListener(clickListener);
    }

    private void PostUser() {
        dialog = new ZProgressHUD(this);
        dialog.show();
        NetworkEngine.getInstance().postUser(name.getText().toString(), email.getText().toString(), password.getText().toString(), phone.getText().toString(), new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                dialog.dismissWithSuccess();
                StoreUtil.getInstance().saveTo("users", user);
                Intent i = new Intent(RegisterActivity.this, CargoPlaceActivity.class);
                startActivity(i);

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                dialog.dismissWithFailure();

            }
        });
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_login_back) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
            if (v == btn_submit) {
                if (checkField()) {
                    PostUser();
                }
            }
        }
    };

    private boolean checkField() {
        if (name.getText().length() == 0) {
            name.setError(getResources().getString(R.string.invalid_username));
            name.requestFocus();
            return false;
        }
        if (email.getText().length() == 0) {
            email.setError(getResources().getString(R.string.invalid_password));
            email.requestFocus();
            return false;
        }
        if (password.getText().length() < 6) {
            password.setError(getResources().getString(R.string.invalid_password));
            password.requestFocus();
            return false;
        }
        if (phone.getText().length() < 6) {
            password.setError(getResources().getString(R.string.invalid_password));
            password.requestFocus();
            return false;
        }
        return true;
    }


    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        finish();
        return super.getSupportParentActivityIntent();
    }
}
