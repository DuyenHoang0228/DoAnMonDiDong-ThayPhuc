package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.nhom4.lilpawhome_application.databinding.ActivityManhinhkhoidongBinding;

public class manhinhkhoidong extends AppCompatActivity {

    ActivityManhinhkhoidongBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityManhinhkhoidongBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(manhinhkhoidong.this, gioithieuapp1.class);
                startActivity(intent);
                finish();

            }
            //delay 2s
        },2000);
    }
}