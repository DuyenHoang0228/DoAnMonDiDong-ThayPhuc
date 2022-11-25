package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class SpaActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] address = {"669 Quốc Lộ 1A, quận Thủ Đức", "435 Dương Quảng Hàm, quận Gò Vấp"};
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spa2);

        spinner = findViewById(R.id.spinner_choncoso);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, address);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(ad);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}