package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;

import com.nhom4.lilpawhome_application.databinding.ActivityKhachhangthanthietBinding;

public class khachhangthanthiet extends AppCompatActivity {

    ActivityKhachhangthanthietBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityKhachhangthanthietBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        makeColor();
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
