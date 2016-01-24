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

public class UpdateProfileActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private EditText name, email, password, phone;
    private ZProgressHUD dialog;
    private EditText password_new;
    private Button btn_update;
    private Button btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_update = (Button) findViewById(R.id.btn_update);

        name = (EditText) findViewById(R.id.edt_name);
        email = (EditText) findViewById(R.id.edt_email);
        password = (EditText) findViewById(R.id.edt_password);
        password_new = (EditText) findViewById(R.id.edt_password_new);
        phone = (EditText) findViewById(R.id.edt_phone);

        //btn_cancel.setOnClickListener(clickListener);
        //btn_update.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_cancel) {
                finish();
            }
            if (v == btn_update) {
                if (checkField()) {
                    //PostUser();
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
        if (!password.getText().toString().equals(password_new.getText().toString())) {
            password.setError(getResources().getString(R.string.password_donotmatch));
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
