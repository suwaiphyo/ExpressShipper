package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.smk.ExpressShipper528.R;
import com.smk.adapter.DeliveryCompanyLvAdapter;

import java.util.ArrayList;
import java.util.List;

public class DeliveryCompanyActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private Button btn_back;
    private Button btn_send;
    private ListView lv_delivery_company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_company);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv_delivery_company = (ListView)findViewById(R.id.lv_delivery_company);
        btn_back = (Button)findViewById(R.id.btn_back);
        btn_send = (Button)findViewById(R.id.btn_send);

        btn_back.setOnClickListener(clickListener);
        btn_send.setOnClickListener(clickListener);

        List<String> listCompany = new ArrayList<String>();
        listCompany.add("Love Company");
        listCompany.add("Hate Company");
        listCompany.add("Cute Company");
        listCompany.add("Ugly Company");
        listCompany.add("Funny Company");

        lv_delivery_company.setDividerHeight(0);
        lv_delivery_company.setAdapter(new DeliveryCompanyLvAdapter(DeliveryCompanyActivity.this, listCompany));

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_back){
                finish();
            }
            if (v == btn_send){
                // startActivity(new Intent(CargoPlaceActivity.this, LoginActivity.class));
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
