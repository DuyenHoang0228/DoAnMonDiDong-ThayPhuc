package com.nhom4.lilpawhome_application;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.nhom4.lilpawhome_application.databinding.ActivityCacdieukhoansudungBinding;

public class cacdieukhoansudung extends AppCompatActivity {
    ActivityCacdieukhoansudungBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_cacdieukhoansudung);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {case android.R.id.home: onBackPressed();
            return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}