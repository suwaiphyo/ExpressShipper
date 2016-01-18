package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import com.smk.ExpressShipper528.R;

public class RegisterActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private Button btn_login_back;
    private Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        toolbar.setTitle(R.string.strmm_register_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_login_back = (Button)findViewById(R.id.btn_login_back);
        btn_submit = (Button)findViewById(R.id.btn_submit);

        btn_login_back.setOnClickListener(clickListener);
        btn_submit.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_login_back){
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
            if (v == btn_submit){
                startActivity(new Intent(RegisterActivity.this, CargoPlaceActivity.class));
            }
        }
    };

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        finish();
        return super.getSupportParentActivityIntent();
    }
}
