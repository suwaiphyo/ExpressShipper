package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_receive_place);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        //toolbar.setTitle(R.string.strmm_register_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

<<<<<<< HEAD
        spn_cargo_division = (Spinner) findViewById(R.id.spn_cargo_division);
        spn_cargo_township = (Spinner) findViewById(R.id.spn_cargo_township);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_continue = (Button) findViewById(R.id.btn_continue);
=======
        spn_cargo_division = (Spinner)findViewById(R.id.spn_cargo_division);
        spn_cargo_township = (Spinner)findViewById(R.id.spn_cargo_township);
        btn_back = (Button)findViewById(R.id.btn_back);
        btn_continue = (Button)findViewById(R.id.btn_continue);

        // CargoParam Divsion DropDown
        List<String> divisions = new ArrayList<String>();
        divisions.add(getResources().getString(R.string.strmm_cargoreceive_division));
        divisions.add("Yangon");
        divisions.add("Mandalay");
        divisions.add("Ayeyarwaddy");
        divisions.add("Sakaing");

        ArrayAdapter<String> divisionAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, divisions);
        spn_cargo_division.setAdapter(divisionAdapter);

        // CargoParam Township DropDown
        List<String> townships = new ArrayList<String>();
        townships.add(getResources().getString(R.string.strmm_cargoreceive_township));
        townships.add("Yankin");
        townships.add("Bahan");
        townships.add("Kyimyintine");
        townships.add("Lathar");

        ArrayAdapter<String> townshipAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, townships);
        spn_cargo_township.setAdapter(townshipAdapter);
>>>>>>> b4a23945818853959715bda3b94e595a964ca315

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
    }

    private AdapterView.OnItemSelectedListener cityItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ArrayAdapter<Township> townshipAdapter = new ArrayAdapter<Township>(CargoReceivePlaceActivity.this, R.layout.support_simple_spinner_dropdown_item, city_list.get(position).getTownship());
            spn_cargo_township.setAdapter(townshipAdapter);
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
                startActivity(new Intent(CargoReceivePlaceActivity.this, CargoInfoActivity.class));
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
