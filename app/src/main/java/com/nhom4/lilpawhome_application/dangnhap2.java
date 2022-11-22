package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.databinding.ActivityDangnhap2Binding;

public class dangnhap2 extends AppCompatActivity {

    ActivityDangnhap2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDangnhap2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        underline();
        addEvent();
    }

    private void addEvent() {
        binding.imvThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(dangnhap2.this, khachhangbac.class);
                 startActivity(intent);
            }
        });
        binding.btnDangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap2.this, dangky.class);
                startActivity(intent);
            }
        });
        binding.txtQuenmatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap2.this, quenmatkhau1.class);
                startActivity(intent);
            }
        });
    }

    private void underline() {
        TextView txt_quenmatkhau = findViewById(R.id.txt_quenmatkhau);
        txt_quenmatkhau.setPaintFlags(txt_quenmatkhau.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }

}