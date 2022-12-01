package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.nhom4.lilpawhome_application.databinding.ActivityTaoHosoBinding;

import java.util.ArrayList;

public class TaoHosoActivity extends AppCompatActivity {

    ActivityTaoHosoBinding binding;
    String[] giongcho = {"Huskey", "Chihuahua", "Corgi", "Cỏ", "Bull Pháp", "Pitbull", "Xúc xích", "Shiba", "Alaska"};
    String[] giongmeo = {"Mướp", "Anh Lông Ngắn", "Anh Lông Dài", "Ba Tư", "Ai Cập (Sphynx)", "Munchkin chân ngắn", "Xiêm", "Ragdoll", "Tai cụp (Scottish)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tao_hoso);
        binding = ActivityTaoHosoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    public void rbtn_setimagedog(View view) {
        binding.rbtnCho.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ava_dog_stroke));
        binding.rbtnMeo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ava_cat));
        ArrayAdapter adapterGiongcho = new ArrayAdapter(this,android.R.layout.simple_list_item_1,giongcho);
        binding.autotxtGiongchomeo.setAdapter(adapterGiongcho);
        binding.autotxtGiongchomeo.setThreshold(1);
    }

    public void rbtn_setimagecat(View view) {
        binding.rbtnMeo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ava_cat_stroke));
        binding.rbtnCho.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ava_dog2));
        ArrayAdapter adapterGiongmeo = new ArrayAdapter(this,android.R.layout.simple_list_item_1,giongmeo);
        binding.autotxtGiongchomeo.setAdapter(adapterGiongmeo);
        binding.autotxtGiongchomeo.setThreshold(1);
    }
}