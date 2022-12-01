package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpaActivity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // create array of Strings
    // and store name of courses
    String[] pets = {"Gạo", "Mây", "Miu", "Nếp"};
    Spinner spinner;
    TextView banggia;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spa1);

        //Spinner Adapter
        spinner = findViewById(R.id.spinner_chonthucung);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, pets);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(ad);

        //Underline
        banggia = findViewById(R.id.txt_banggiathamkhao);
        String banggiaS = banggia.getText().toString();
        SpannableString s = new SpannableString(banggiaS);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        s.setSpan(underlineSpan, 0,18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        banggia.setText(s);


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