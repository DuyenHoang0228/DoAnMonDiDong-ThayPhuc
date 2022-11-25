package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nhom4.lilpawhome_application.databinding.ActivityGioithieuapp2Binding;

public class gioithieuapp2 extends AppCompatActivity {

    ActivityGioithieuapp2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGioithieuapp2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvent();
    }

    private void addEvent() {
        binding.btnTieptheo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(gioithieuapp2.this, dangnhap1.class);
                startActivity(intent);
            }
        });
    }
}