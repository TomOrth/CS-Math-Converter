package com.cs.converter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.cs.converter.CustomArrayAdapter;
import com.cs.converter.Converter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    //Holds data fields
    ArrayList<String> dataFields = new ArrayList<String>();
    //Criteria
    public String from = "", to = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CS Converter");


        //Array setup
        dataFields.add("Decimal");
        dataFields.add("Binary");
        dataFields.add("Octal");
        dataFields.add("Hexadecimal");

        //Setup spinners
        Spinner spinFrom = (Spinner)findViewById(R.id.spFrom);
        Spinner spinTo = (Spinner)findViewById(R.id.spTo);
        CustomArrayAdapter<CharSequence> spin_adapt = new CustomArrayAdapter (getApplicationContext(), dataFields);
        spinFrom.setAdapter(spin_adapt);
        spinFrom.setOnItemSelectedListener(this);
        spinTo.setAdapter(spin_adapt);
        spinTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to = dataFields.get(position);
                Log.d("DataField", dataFields.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        from = dataFields.get(position);
        Log.d("DataField", dataFields.get(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void calculate(View v){
        TextInputLayout txtInput = (TextInputLayout)this.findViewById(R.id.txtLayout);
        TextView tvFinal = (TextView)this.findViewById(R.id.tvFinal);
        String con = txtInput.getEditText().getText().toString();
        if(from.equals("Hexadecimal") && to.equals("Decimal")){
            tvFinal.setText("Final Value is: " + Converter.hexToDec(con));
        }
        else if(from.equals("Octal") && to.equals("Decimal")){
            tvFinal.setText(Converter.octToDec(con));
        }
        else if(from.equals("Binary") && to.equals("Decimal")){
            tvFinal.setText(Converter.binToDec(con));
        }
        else if(from.equals("Decimal") && to.equals("Binary")){
            tvFinal.setText(Converter.decToBin(con));
        }
        else if(from.equals("Decimal") && to.equals("Octal")){
            tvFinal.setText(Converter.decToOct(con));
        }
        else if(from.equals("Decimal") && to.equals("Hexadecimal")){
            tvFinal.setText(Converter.decToHex(con));
        }
    }
}
