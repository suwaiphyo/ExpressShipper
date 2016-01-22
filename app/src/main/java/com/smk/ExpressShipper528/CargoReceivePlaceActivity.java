package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.smk.clients.NetworkEngine;
import com.smk.model.City;
import com.smk.model.Township;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CargoReceivePlaceActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private Spinner spn_cargo_division;
    private Spinner spn_cargo_township;
    private Button btn_back;
    private Button btn_continue;
    private List<City> city_list;
    private Bundle bundle;
    private EditText edt_cargo_receive_name, edt_cargo_receive_email, edt_cargo_receive_phone, edt_cargo_receive_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_receive_place);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        //toolbar.setTitle(R.string.strmm_register_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_cargo_receive_name = (EditText) findViewById(R.id.edt_cargo_receive_name);
        edt_cargo_receive_email = (EditText) findViewById(R.id.edt_cargo_receive_email);
        edt_cargo_receive_phone = (EditText) findViewById(R.id.edt_cargo_receive_phone);
        edt_cargo_receive_address = (EditText) findViewById(R.id.edt_cargo_receive_address);
        spn_cargo_division = (Spinner) findViewById(R.id.spn_cargo_division);
        spn_cargo_township = (Spinner) findViewById(R.id.spn_cargo_township);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_continue = (Button) findViewById(R.id.btn_continue);

        NetworkEngine.getInstance().getCity(new Callback<List<City>>() {
            @Override
            public void success(List<City> cities, Response response) {
                // String result = "";
                city_list = cities;
                ArrayAdapter<City> divisionAdapter = new ArrayAdapter<City>(CargoReceivePlaceActivity.this, R.layout.support_simple_spinner_dropdown_item, cities);
                spn_cargo_division.setAdapter(divisionAdapter);
                spn_cargo_division.setOnItemSelectedListener(cityItemSelectedListener);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        btn_back.setOnClickListener(clickListener);
        btn_continue.setOnClickListener(clickListener);
        bundle = getIntent().getExtras();

    }

    private Integer cargoTownship;
    private Integer cargoDivision;
    private AdapterView.OnItemSelectedListener cityItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ArrayAdapter<Township> townshipAdapter = new ArrayAdapter<Township>(CargoReceivePlaceActivity.this, R.layout.support_simple_spinner_dropdown_item, city_list.get(position).getTownship());
            spn_cargo_township.setAdapter(townshipAdapter);
            spn_cargo_township.setOnItemSelectedListener(townshipItemSelectedListener);
            cargoDivision = city_list.get(position).getId();
            citySelectedPosition = position;
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private int citySelectedPosition;
    private AdapterView.OnItemSelectedListener townshipItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //   ArrayAdapter<Township> townshipAdapter = new ArrayAdapter<Township>(CargoPlaceActivity.this, R.layout.support_simple_spinner_dropdown_item, city_list.get(position).getTownship());
            //spn_cargo_township.setAdapter(townshipAdapter);
            cargoTownship = city_list.get(citySelectedPosition).getTownship().get(position).getId();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_back) {
                finish();
            }


            if (v == btn_continue) {
                if (checkField()) {
                    Intent intent = new Intent(CargoReceivePlaceActivity.this, CargoInfoActivity.class);
                    String cargoReceiveName = edt_cargo_receive_name.getText().toString();
                    String cargoReceiveEmail = edt_cargo_receive_email.getText().toString();
                    String cargoReceivePhone = edt_cargo_receive_phone.getText().toString();
                    String cargoReceiveAddress = edt_cargo_receive_address.getText().toString();

                    bundle.putString("CargoReceiveName", cargoReceiveName);
                    bundle.putString("CargoReceiveEmail", cargoReceiveEmail);
                    bundle.putString("CargoReceivePhone", cargoReceivePhone);
                    bundle.putString("CargoReceiveAddress", cargoReceiveAddress);
                    bundle.putInt("CargoReceiveDivision", cargoDivision);
                    bundle.putInt("CargoReceiverTownship", cargoTownship);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        }
    };

    private boolean checkField() {
        if (edt_cargo_receive_name.getText().length() == 0) {
            edt_cargo_receive_name.setError(getResources().getString(R.string.invalid_message));
            edt_cargo_receive_name.requestFocus();
            return false;
        }
        if (edt_cargo_receive_email.getText().length() == 0) {
            edt_cargo_receive_email.setError(getResources().getString(R.string.invalid_message));
            edt_cargo_receive_email.requestFocus();
            return false;
        }
        if (edt_cargo_receive_phone.getText().length() == 0) {
            edt_cargo_receive_phone.setError(getResources().getString(R.string.invalid_message));
            edt_cargo_receive_phone.requestFocus();
            return false;
        }
        if (edt_cargo_receive_address.getText().length() == 0) {
            edt_cargo_receive_address.setError(getResources().getString(R.string.invalid_message));
            edt_cargo_receive_address.requestFocus();
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
