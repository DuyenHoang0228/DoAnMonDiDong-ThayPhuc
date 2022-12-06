package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.databinding.ActivityTaikhoanvabaomatBinding;
import com.nhom4.lilpawhome_application.databinding.ActivityThietlaptaikhoanBinding;

public class taikhoanvabaomat extends AppCompatActivity {
ActivityTaikhoanvabaomatBinding binding;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // setContentView(R.layout.activity_taikhoanvabaomat);
        binding = ActivityTaikhoanvabaomatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvent();
    }

    private void addEvent() {
       //GetExtra từ đổi tên

        //Intent qua đổi tên
       binding.txtNameofaccount.setOnClickListener(new View.OnClickListener() {
           @Override
          public void onClick(View view) {
             Intent intent = new Intent(taikhoanvabaomat.this, Doitentaikhoan.class);
             startActivity(intent);
             Intent y=getIntent();
             String tenmoi=y.getStringExtra("doiten");
             binding.txtNameofaccount.setText(tenmoi);
          }
       });
        binding.btnSodienthoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(taikhoanvabaomat.this, sodienthoai.class);
                startActivity(intent);
            }
        });
        binding.btnEmailnhanhoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(taikhoanvabaomat.this, email.class);
                startActivity(intent);
            }
        });
        binding.btnEmailnhanhoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(taikhoanvabaomat.this, email.class);
                startActivity(intent);
            }
        });
        binding.btnDoimatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(taikhoanvabaomat.this, nhaplaimatkhau.class);
                startActivity(intent);
            }
        });
    }
}