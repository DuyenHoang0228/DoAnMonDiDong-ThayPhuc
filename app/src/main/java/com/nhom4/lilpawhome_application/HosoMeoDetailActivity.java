package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.nhom4.lilpawhome_application.databinding.ActivityHosoMeoDetailBinding;

public class HosoMeoDetailActivity extends AppCompatActivity {

    ActivityHosoMeoDetailBinding binding;
    String[] giongmeo = {"Mướp", "Anh Lông Ngắn", "Anh Lông Dài", "Ba Tư", "Ai Cập (Sphynx)", "Munchkin chân ngắn", "Xiêm", "Ragdoll", "Tai cụp (Scottish)"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hoso_meo_detail);
        binding = ActivityHosoMeoDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter adapterGiongmeo = new ArrayAdapter(this,android.R.layout.simple_list_item_1,giongmeo);
        binding.autotxtGiongmeo.setAdapter(adapterGiongmeo);
        binding.autotxtGiongmeo.setThreshold(1);
    }
}