package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.nhom4.lilpawhome_application.databinding.ActivityHosoChoDetailBinding;

public class HosoChoDetailActivity extends AppCompatActivity {

    ActivityHosoChoDetailBinding binding;
    String[] giongcho = {"Huskey", "Chihuahua", "Corgi", "Cỏ", "Bull Pháp", "Pitbull", "Xúc xích", "Shiba", "Alaska"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hoso_cho_detail);
        binding = ActivityHosoChoDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter adapterGiongcho = new ArrayAdapter(this,android.R.layout.simple_list_item_1,giongcho);
        binding.autotxtGiongcho.setAdapter(adapterGiongcho);
        binding.autotxtGiongcho.setThreshold(1);
    }
}