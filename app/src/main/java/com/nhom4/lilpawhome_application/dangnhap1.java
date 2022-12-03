package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.databinding.ActivityDangnhap1Binding;

public class dangnhap1 extends AppCompatActivity {

    ActivityDangnhap1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDangnhap1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        underline();
        addEvent();
    }

    private void underline() {
        TextView txt_dieukhoansudung = findViewById(R.id.txt_dieukhoansudung);
        txt_dieukhoansudung.setPaintFlags(txt_dieukhoansudung.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }

    private void addEvent() {
        binding.txtDieukhoansudung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap1.this, cacdieukhoansudung.class);
                startActivity(intent);
            }
        });
        binding.btnDangnhapbangfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        binding.btnDangnhapbanggoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        binding.btnDangnhapbanglilpawhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap1.this,dangnhap2.class);
                startActivity(intent);
            }
        });
        binding.txtBoquadangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(dangnhap1.this, MainActivity.class);
                 startActivity(intent);
            }
        });
    }
}