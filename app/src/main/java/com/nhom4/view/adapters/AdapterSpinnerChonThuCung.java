package com.nhom4.view.adapters;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nhom4.lilpawhome_application.R;

public class AdapterSpinnerChonThuCung
        extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    // create array of Strings
    // and store name of courses
    String[] pets = { "Gạo", "Mây", "Miu", "Nếp"};
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Take the instance of Spinner and
        // apply OnItemSelectedListener on it which
        // tells which item of spinner is clicked
        spinner = findViewById(R.id.spinner_chonthucung);
        spinner.setOnItemSelectedListener(this);

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, pets);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spinner.setAdapter(ad);
    }

    // Performing action when ItemSelected
    // from spinner, Overriding onItemSelected method

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),
                        pets[position],
                        Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
