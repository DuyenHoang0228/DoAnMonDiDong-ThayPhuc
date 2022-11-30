package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nhom4.lilpawhome_application.databinding.ActivityDanhGiaCuaToiBinding;

public class DanhGiaCuaToi extends AppCompatActivity {

    ActivityDanhGiaCuaToiBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_danh_gia_cua_toi);

        binding = ActivityDanhGiaCuaToiBinding.inflate(getLayoutInflater());

    }
}