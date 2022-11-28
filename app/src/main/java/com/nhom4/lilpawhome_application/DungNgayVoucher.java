package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nhom4.lilpawhome_application.databinding.ActivityDungNgayVoucherBinding;

public class DungNgayVoucher extends AppCompatActivity {

    ActivityDungNgayVoucherBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDungNgayVoucherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_dung_ngay_voucher);
    }
}