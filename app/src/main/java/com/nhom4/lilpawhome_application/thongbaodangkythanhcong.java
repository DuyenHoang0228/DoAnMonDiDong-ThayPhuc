package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nhom4.lilpawhome_application.databinding.ActivityDangkyBinding;
import com.nhom4.lilpawhome_application.databinding.ActivityThongbaodangkythanhcongBinding;

public class thongbaodangkythanhcong extends AppCompatActivity {
ActivityThongbaodangkythanhcongBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //
        binding = ActivityThongbaodangkythanhcongBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvent();
    }

    private void addEvent() {
        binding.btnBatdaumuasam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thongbaodangkythanhcong.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}