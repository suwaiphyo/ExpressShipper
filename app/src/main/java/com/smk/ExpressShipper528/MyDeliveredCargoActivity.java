package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyDeliveredCargoActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private Button btn_cancel;
    private TextView txt_taker_name;
    private TextView txt_taker_address;
    private TextView txt_taker_phone;
    private TextView txt_cargo_name;
    private TextView txt_cargo_qty;
    private TextView txt_total_weight;
    private TextView txt_total_charges;
    private TextView txt_deliver_date;
    private TextView txt_deliver_status;
    private Button btn_update;
    private TextView txt_deliver_name;
    private TextView txt_deliver_company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_delivered_cargo);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_taker_name = (TextView)findViewById(R.id.txt_taker_name);
        txt_taker_address = (TextView)findViewById(R.id.txt_taker_address);
        txt_taker_phone = (TextView)findViewById(R.id.txt_taker_phone);
        txt_cargo_name = (TextView)findViewById(R.id.txt_cargo_name);
        txt_cargo_qty = (TextView)findViewById(R.id.txt_cargo_qty);
        txt_total_weight = (TextView)findViewById(R.id.txt_total_weight);
        txt_total_charges = (TextView)findViewById(R.id.txt_total_charges);
        txt_deliver_date = (TextView)findViewById(R.id.txt_deliver_date);
        txt_deliver_status = (TextView)findViewById(R.id.txt_deliver_status);
        txt_deliver_name = (TextView)findViewById(R.id.txt_deliver_name);
        txt_deliver_company = (TextView)findViewById(R.id.txt_deliver_company);

        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_update = (Button) findViewById(R.id.btn_update);

        btn_cancel.setOnClickListener(clickListener);
        btn_update.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_cancel) {
                finish();
            }
            if (v == btn_update) {
                /*Intent intent = new Intent(MyOdersActivity.this, ThankYouActivity.class);
                startActivity(intent);*/
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
