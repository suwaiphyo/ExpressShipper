package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.smk.adapter.DeliveryCompanyLvAdapter;
import com.smk.clients.NetworkEngine;
import com.smk.model.CargoParam;
import com.smk.model.Shipping;
import com.smk.model.User;
import com.smk.util.StoreUtil;
import com.thuongnh.zprogresshud.ZProgressHUD;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DeliveryCompanyActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private Button btn_back;
    private Button btn_send;
    private ListView lv_delivery_company;
    private Bundle bundle;
    private ZProgressHUD dialog;
    private Integer CargoDiv, CargoTownship, CargoReceiveDivision, CargoReceiverTownship;
    private String CargoAddress, CargoReceiveName, CargoReceiveEmail, CargoReceivePhone, CargoReceiveAddress, CargoInfoName, CargoInfoQty, CargoInfoLength, CargoInfoWidth, CargoInfoHeight;
    private List<CargoParam> cargoParamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_company);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv_delivery_company = (ListView) findViewById(R.id.lv_delivery_company);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_send = (Button) findViewById(R.id.btn_send);

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

        bundle = getIntent().getExtras();
        CargoAddress = bundle.getString("CargoAddress");
        CargoDiv = bundle.getInt("CargoDiv");
        CargoTownship = bundle.getInt("CargoTownship");

        CargoReceiveName = bundle.getString("CargoReceiveName");
        CargoReceiveEmail = bundle.getString("CargoReceiveEmail");
        CargoReceivePhone = bundle.getString("CargoReceivePhone");
        CargoReceiveAddress = bundle.getString("CargoReceiveAddress");
        CargoReceiveDivision = bundle.getInt("CargoTownship");
        CargoReceiverTownship = bundle.getInt("CargoReceiverTownship");

        CargoInfoName = bundle.getString("CargoInfoName");
        CargoInfoQty = bundle.getString("CargoInfoQty");
        CargoInfoLength = bundle.getString("CargoInfoLength");
        CargoInfoWidth = bundle.getString("CargoInfoWidth");
        CargoInfoHeight = bundle.getString("CargoInfoHeight");

        CargoParam cargoParam = new CargoParam();
        cargoParam.setItemName(CargoInfoName);
        cargoParam.setUnite("kg");
        cargoParam.setQty(Integer.valueOf(CargoInfoQty));
        cargoParam.setWeight(Integer.valueOf(1));
        cargoParam.setLength(Integer.valueOf(CargoInfoLength));
        cargoParam.setWidth(Integer.valueOf(CargoInfoWidth));
        cargoParam.setHeight(Integer.valueOf(CargoInfoHeight));

        cargoParamList = new ArrayList<>();
        cargoParamList.add(cargoParam);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_back) {
                finish();
            }
            if (v == btn_send) {
                PostShipping();
                // startActivity(new Intent(CargoPlaceActivity.this, LoginActivity.class));
            }
        }
    };

    private void PostShipping() {
        dialog = new ZProgressHUD(this);
        dialog.show();
        Log.i("Error", cargoParamList.toString());
        User user = StoreUtil.getInstance().selectFrom("users");
        NetworkEngine.getInstance().postShipping(user.getId(), CargoAddress, CargoDiv, CargoTownship, CargoReceiveName, CargoReceiveEmail, CargoReceivePhone, CargoReceiveAddress, CargoReceiveDivision, CargoReceiverTownship, cargoParamList.toString(), 1, new Callback<Shipping>() {
            @Override
            public void success(Shipping shipping, Response response) {
                dialog.dismissWithSuccess();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                dialog.dismissWithFailure();

            }
        });
    }

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        finish();
        return super.getSupportParentActivityIntent();
    }

}
