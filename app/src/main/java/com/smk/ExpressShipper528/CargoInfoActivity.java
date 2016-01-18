package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class CargoInfoActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private Button btn_back;
    private Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_info);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_back = (Button)findViewById(R.id.btn_back);
        btn_continue = (Button)findViewById(R.id.btn_continue);

        btn_back.setOnClickListener(clickListener);
        btn_continue.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_back){
                finish();
            }
            if (v == btn_continue){
                startActivity(new Intent(CargoInfoActivity.this, DeliveryCompanyActivity.class));
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
