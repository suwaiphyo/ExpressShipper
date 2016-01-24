package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

public class MyOdersActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private Button btn_cancel;
    private Button btn_my_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_my_order = (Button) findViewById(R.id.btn_my_order);

        btn_cancel.setOnClickListener(clickListener);
        btn_my_order.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_cancel) {
                finish();
            }
            if (v == btn_my_order) {
                Intent intent = new Intent(MyOdersActivity.this, ThankYouActivity.class);
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
