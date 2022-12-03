package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.nhom4.lilpawhome_application.databinding.ActivityDungNgayVoucherBinding;

public class DungNgayVoucher extends AppCompatActivity {

    ActivityDungNgayVoucherBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDungNgayVoucherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_dung_ngay_voucher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_shopchocho12);
        EditText editTimKiem = findViewById(R.id.edt_timkiem);
        editTimKiem.setHint("Voucher");
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#ffffff")));
        loadData();
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.shopchocho1_option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void loadData() {
        Intent intent = getIntent();
        String chuTrongAnhVoucher = intent.getStringExtra("ChuTrongAnhVoucher");
        String titleOfVoucher = intent.getStringExtra("TitleOfVoucher");
        String HSD = intent.getStringExtra("HSDVoucher");
        int maxValue = intent.getIntExtra("MaxOfValue", 0);
        boolean isLimited = intent.getBooleanExtra("isLimited", true);

        binding.txtChutronganhvoucher.setText(chuTrongAnhVoucher);
        binding.txtTenvoucher.setText(titleOfVoucher);
        binding.txtHsdvoucher.setText(HSD);
        binding.txtVouchertoida.setText(String.valueOf(maxValue));
        if(isLimited){
            binding.txtSoluongcohan.setText("Số lượng có hạn");
        }else{
            binding.txtSoluongcohan.setVisibility(View.INVISIBLE);
        }
    }
}