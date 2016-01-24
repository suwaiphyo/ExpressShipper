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

public class CargoPlaceActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private Button btn_my_orders;
    private Button btn_continue;
    private Spinner spn_cargo_division;
    private Spinner spn_cargo_township;
    private EditText edt_cargo_address;
    private List<City> city_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_place);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        //toolbar.setTitle(R.string.strmm_register_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edt_cargo_address = (EditText) findViewById(R.id.edt_cargo_address);
        spn_cargo_division = (Spinner) findViewById(R.id.spn_cargo_division);
        spn_cargo_township = (Spinner) findViewById(R.id.spn_cargo_township);
        btn_my_orders = (Button) findViewById(R.id.btn_my_orders);
        btn_continue = (Button) findViewById(R.id.btn_continue);

        NetworkEngine.getInstance().getCity(new Callback<List<City>>() {
            @Override
            public void success(List<City> cities, Response response) {
                // String result = "";
                city_list = cities;
                ArrayAdapter<City> divisionAdapter = new ArrayAdapter<City>(CargoPlaceActivity.this, R.layout.support_simple_spinner_dropdown_item, cities);
                spn_cargo_division.setAdapter(divisionAdapter);
                spn_cargo_division.setOnItemSelectedListener(cityItemSelectedListener);

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        btn_my_orders.setOnClickListener(clickListener);
        btn_continue.setOnClickListener(clickListener);
    }

    private Integer cargoDivision = 0;
    private int citySelectedPosition;
    private AdapterView.OnItemSelectedListener cityItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ArrayAdapter<Township> townshipAdapter = new ArrayAdapter<Township>(CargoPlaceActivity.this, R.layout.support_simple_spinner_dropdown_item, city_list.get(position).getTownship());
            spn_cargo_township.setAdapter(townshipAdapter);
            spn_cargo_township.setOnItemSelectedListener(townshipItemSelectedListener);
            cargoDivision = city_list.get(position).getId();
            citySelectedPosition = position;
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private Integer cargoTownship = 0;
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
            if (v == btn_my_orders) {
                startActivity(new Intent(CargoPlaceActivity.this, MyOdersActivity.class));
            }
            if (v == btn_continue) {
                if (checkField()) {
                    Intent intent = new Intent(CargoPlaceActivity.this, CargoReceivePlaceActivity.class);
                    String cargoAddress = edt_cargo_address.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("CargoAddress", cargoAddress);
                    bundle.putInt("CargoDivision", cargoDivision);
                    bundle.putInt("CargoTownship", cargoTownship);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        }
    };

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        finish();
        return super.getSupportParentActivityIntent();
    }

    private boolean checkField() {
        if (edt_cargo_address.getText().length() == 0) {
            edt_cargo_address.setError(getResources().getString(R.string.invalid_message));
            edt_cargo_address.requestFocus();
            return false;
        }
        return true;
    }
}

