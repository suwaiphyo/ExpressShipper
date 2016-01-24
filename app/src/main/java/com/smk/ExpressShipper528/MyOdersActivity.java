package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyOdersActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private Button btn_cancel;
    private LinearLayout layout_pending_list;
    private LinearLayout layout_progressing_list;
    private LinearLayout layout_delivered_list;
    private TextView txt_pending_totalQty;
    private TextView txt_progess_totalQty;
    private TextView txt_delivered_totalQty;
    private Button btn_update_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        layout_pending_list = (LinearLayout)findViewById(R.id.layout_pending_list);
        layout_progressing_list = (LinearLayout)findViewById(R.id.layout_progressing_list);
        layout_delivered_list = (LinearLayout)findViewById(R.id.layout_delivered_list);

        txt_pending_totalQty = (TextView)findViewById(R.id.txt_pending_totalQty);
        txt_progess_totalQty = (TextView)findViewById(R.id.txt_progess_totalQty);
        txt_delivered_totalQty = (TextView)findViewById(R.id.txt_delivered_totalQty);

        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_update_profile = (Button) findViewById(R.id.btn_update_profile);

        layout_pending_list.setOnClickListener(clickListener);
        layout_progressing_list.setOnClickListener(clickListener);
        layout_delivered_list.setOnClickListener(clickListener);
        btn_cancel.setOnClickListener(clickListener);
        btn_update_profile.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == layout_pending_list){
                startActivity(new Intent(MyOdersActivity.this, MyPendingCargoActivity.class));
            }
            if (v == layout_progressing_list){
                startActivity(new Intent(MyOdersActivity.this, MyProgressingCargoActivity.class));
            }
            if (v == layout_delivered_list){
                startActivity(new Intent(MyOdersActivity.this, MyDeliveredCargoActivity.class));
            }
            if (v == btn_cancel) {
                finish();
            }
            if (v == btn_update_profile) {
                startActivity(new Intent(MyOdersActivity.this, UpdateProfileActivity.class));
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
