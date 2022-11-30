package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.nhom4.adapters.AdapterVoucher;
import com.nhom4.lilpawhome_application.databinding.ActivityKhachhangthanthietBinding;
import com.nhom4.models.Voucher;

import java.util.ArrayList;

public class khachhangthanthiet extends AppCompatActivity {

    ActivityKhachhangthanthietBinding binding;
    AdapterVoucher adapter;
    ArrayList<Voucher> vouchers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityKhachhangthanthietBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        makeColor();
        loadData();
        addEvent();
    }

    private void loadData() {
        vouchers = new ArrayList<>();
        vouchers.add(new Voucher("Tất cả hình thức thanh toán", "28/02/2022", 15, "Miễn phí vận chuyển", false));
        vouchers.add(new Voucher("GIẢM 15% ĐƠN TỪ 100K", "28/11/2022", 100, "Giảm 15%", true));
        adapter = new AdapterVoucher(khachhangthanthiet.this, R.layout.voucher_layout, vouchers);
        binding.lvVoucherdocquyen.setAdapter(adapter);

    }


    private void addEvent() {
        binding.lvVoucherdocquyen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    private void makeColor() {
        String Noidunguudaithuhang ="Được giảm 5% giá trị đơn hàng trên 50.000 NVD cho tất cả sản phẩm trên gian hàng Lilpaw Home. Được ưu tiên nhận các mã giảm giá độc quyền từ Lilpaw Home";
        SpannableString s = new SpannableString(Noidunguudaithuhang);
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#EC1313")), 10, 12, 0);
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#EC1313")), 50, 65, 0);
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#EC1313")), 98, 106, 0);
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#EC1313")), 128, 137, 0);
        binding.txtNoidunguudaithuhang.setText(s);
    }

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

}
