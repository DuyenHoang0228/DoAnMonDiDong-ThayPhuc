package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.nhom4.adapters.AdapterVoucher;
import com.nhom4.lilpawhome_application.databinding.ActivityChiTietVoucherBinding;
import com.nhom4.models.Voucher;

public class ChiTietVoucher extends AppCompatActivity {

    ActivityChiTietVoucherBinding binding;
    AdapterVoucher adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChiTietVoucherBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_chi_tiet_voucher);
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getIntentData();
        loadData();
        addEvent();
    }

    private void getIntentData() {
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

    private void loadData() {

    }

    private void addEvent() {
        binding.btnDungngayvoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChiTietVoucher.this, DungNgayVoucher.class);

                intent.putExtra("ChuTrongAnhVoucher", binding.txtChutronganhvoucher.getText());
                intent.putExtra("TitleOfVoucher", binding.txtTenvoucher.getText());
                intent.putExtra("HSDVoucher", binding.txtHsdvoucher.getText());
                intent.putExtra("MaxOfValue", Integer.parseInt(binding.txtVouchertoida.getText().toString()));
                intent.putExtra("isLimited", binding.txtSoluongcohan.getText());
                startActivity(intent);
            }
        });
    }

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
}