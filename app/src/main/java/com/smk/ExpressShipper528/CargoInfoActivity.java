package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CargoInfoActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private Button btn_back;
    private Button btn_continue;
    private EditText edt_cargoinfo_name, edt_cargoinfo_qty, edt_cargoinfo_length, edt_cargoinfo_width, edt_cargoinfo_height;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_info);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edt_cargoinfo_name = (EditText) findViewById(R.id.edt_cargoinfo_name);
        edt_cargoinfo_qty = (EditText) findViewById(R.id.edt_cargoinfo_qty);
        edt_cargoinfo_length = (EditText) findViewById(R.id.edt_cargoinfo_length);
        edt_cargoinfo_width = (EditText) findViewById(R.id.edt_cargoinfo_width);
        edt_cargoinfo_height = (EditText) findViewById(R.id.edt_cargoinfo_height);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_continue = (Button) findViewById(R.id.btn_continue);

        btn_back.setOnClickListener(clickListener);
        btn_continue.setOnClickListener(clickListener);
        bundle = getIntent().getExtras();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_back) {
                finish();
            }
            if (v == btn_continue) {
                if (checkField()) {
                    Intent intent = new Intent(CargoInfoActivity.this, DeliveryCompanyActivity.class);
                    String cargoInfoName = edt_cargoinfo_name.getText().toString();
                    String cargoInfoQty = edt_cargoinfo_qty.getText().toString();
                    String cargoInfoLength = edt_cargoinfo_length.getText().toString();
                    String cargoInfoWidth = edt_cargoinfo_width.getText().toString();
                    String cargoInfoHeight = edt_cargoinfo_height.getText().toString();

                    bundle.putString("CargoInfoName", cargoInfoName);
                    bundle.putString("CargoInfoQty", cargoInfoQty);
                    bundle.putString("CargoInfoLength", cargoInfoLength);
                    bundle.putString("CargoInfoWidth", cargoInfoWidth);
                    bundle.putString("CargoInfoHeight", cargoInfoHeight);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        }
    };

    private boolean checkField() {
        if (edt_cargoinfo_name.getText().length() == 0) {
            edt_cargoinfo_name.setError(getResources().getString(R.string.invalid_message));
            edt_cargoinfo_name.requestFocus();
            return false;
        }
        if (edt_cargoinfo_qty.getText().length() == 0) {
            edt_cargoinfo_qty.setError(getResources().getString(R.string.invalid_message));
            edt_cargoinfo_qty.requestFocus();
            return false;
        }
        if (edt_cargoinfo_length.getText().length() == 0) {
            edt_cargoinfo_length.setError(getResources().getString(R.string.invalid_message));
            edt_cargoinfo_length.requestFocus();
            return false;
        }
        if (edt_cargoinfo_width.getText().length() == 0) {
            edt_cargoinfo_width.setError(getResources().getString(R.string.invalid_message));
            edt_cargoinfo_width.requestFocus();
            return false;
        }
        if (edt_cargoinfo_height.getText().length() == 0) {
            edt_cargoinfo_height.setError(getResources().getString(R.string.invalid_message));
            edt_cargoinfo_height.requestFocus();
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
