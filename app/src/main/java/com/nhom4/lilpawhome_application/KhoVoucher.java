package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.nhom4.adapters.AdapterVoucher;
import com.nhom4.lilpawhome_application.databinding.ActivityKhoVoucherBinding;
import com.nhom4.models.Product;
import com.nhom4.models.Voucher;

import java.util.ArrayList;

public class KhoVoucher extends AppCompatActivity {

    ActivityKhoVoucherBinding binding;
    AdapterVoucher adapter;
    ArrayList<Voucher> vouchers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKhoVoucherBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_kho_voucher);
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addEvent();
        loadData();
    }

    private void loadData() {
        vouchers = new ArrayList<>();
        vouchers.add(new Voucher("Tất cả hình thức thanh toán", "28/02/2022", 15, "Miễn phí vận chuyển", false));
        vouchers.add(new Voucher("GIẢM 15% ĐƠN TỪ 100K", "28/11/2022", 100, "Giảm 15%", true));
        vouchers.add(new Voucher("GIẢM 5% ĐƠN TỪ 50K", "30/11/2022", 30, "Giảm 5%", true));
        vouchers.add(new Voucher("GIẢM 50K ĐƠN TỪ 99K", "20/12/2022", 50, "Giảm 50K", true));
        vouchers.add(new Voucher("GIẢM 15% ĐƠN TỪ 100K", "28/02/2022", 100, "Giảm 15%", true));
        vouchers.add(new Voucher("Tất cả hình thức thanh toán", "28/02/2022", 15, "Miễn phí vận chuyển", true));
        vouchers.add(new Voucher("GIẢM 5% ĐƠN TỪ 50K", "30/11/2022", 30, "Giảm 5%", false));
        adapter = new AdapterVoucher(KhoVoucher.this, R.layout.voucher_layout, vouchers);

        binding.lvKhovoucher.setAdapter(adapter);

    }

    private void addEvent() {
        binding.lvKhovoucher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(KhoVoucher.this, ChiTietVoucher.class);
                Voucher voucher = (Voucher) adapter.getItem(i);
                intent.putExtra("ChuTrongAnhVoucher", voucher.getChuTrongAnhVoucher());
                intent.putExtra("TitleOfVoucher", voucher.getTitleOfVoucher());
                intent.putExtra("HSDVoucher", voucher.getHsdVoucher());
                intent.putExtra("MaxOfValue", voucher.getMaxValue());
                intent.putExtra("isLimited", voucher.isLimited());
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