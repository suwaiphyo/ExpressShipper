package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import com.smk.ExpressShipper528.R;

public class FinalConfirmActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private Button btn_back;
    private Button btn_confirm;
    private TextView txt_sender;
    private TextView txt_sender_phone;
    private TextView txt_sender_address;
    private TextView txt_taker;
    private TextView txt_taker_phone;
    private TextView txt_taker_address;
    private TextView txt_cargo_name;
    private TextView txt_total_weight;
    private TextView txt_total_charges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_confirm);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_sender = (TextView)findViewById(R.id.txt_sender);
        txt_sender_phone = (TextView)findViewById(R.id.txt_sender_phone);
        txt_sender_address = (TextView)findViewById(R.id.txt_sender_address);
        txt_taker = (TextView)findViewById(R.id.txt_taker);
        txt_taker_phone = (TextView)findViewById(R.id.txt_taker_phone);
        txt_taker_address = (TextView)findViewById(R.id.txt_taker_address);
        txt_cargo_name = (TextView)findViewById(R.id.txt_cargo_name);
        txt_total_weight = (TextView)findViewById(R.id.txt_total_weight);
        txt_total_charges = (TextView)findViewById(R.id.txt_total_charges);

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_confirm = (Button) findViewById(R.id.btn_confirm);

        btn_back.setOnClickListener(clickListener);
        btn_confirm.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_back) {
                finish();
            }
            if (v == btn_confirm) {
                Intent intent = new Intent(FinalConfirmActivity.this, ThankYouActivity.class);
                startActivity(intent);
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
