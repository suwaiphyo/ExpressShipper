package com.smk.ExpressShipper528;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.smk.ExpressShipper528.R;
import java.util.ArrayList;
import java.util.List;

public class CargoReceivePlaceActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;
    private Spinner spn_cargo_division;
    private Spinner spn_cargo_township;
    private Button btn_back;
    private Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_receive_place);

        toolbar = (Toolbar) findViewById(R.id.toolbar_title);
        //toolbar.setTitle(R.string.strmm_register_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spn_cargo_division = (Spinner)findViewById(R.id.spn_cargo_division);
        spn_cargo_township = (Spinner)findViewById(R.id.spn_cargo_township);
        btn_back = (Button)findViewById(R.id.btn_back);
        btn_continue = (Button)findViewById(R.id.btn_continue);

        // Cargo Divsion DropDown
        List<String> divisions = new ArrayList<String>();
        divisions.add(getResources().getString(R.string.strmm_cargoreceive_division));
        divisions.add("Yangon");
        divisions.add("Mandalay");
        divisions.add("Ayeyarwaddy");
        divisions.add("Sakaing");

        ArrayAdapter<String> divisionAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, divisions);
        spn_cargo_division.setAdapter(divisionAdapter);

        // Cargo Township DropDown
        List<String> townships = new ArrayList<String>();
        townships.add(getResources().getString(R.string.strmm_cargoreceive_township));
        townships.add("Yankin");
        townships.add("Bahan");
        townships.add("Kyimyintine");
        townships.add("Lathar");

        ArrayAdapter<String> townshipAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, townships);
        spn_cargo_township.setAdapter(townshipAdapter);

        btn_back.setOnClickListener(clickListener);
        btn_continue.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_back){
                finish();
            }
            if (v == btn_continue){
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
