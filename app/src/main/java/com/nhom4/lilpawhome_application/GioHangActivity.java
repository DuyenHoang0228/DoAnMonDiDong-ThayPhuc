package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nhom4.adapters.AdapterGioHang;
import com.nhom4.lilpawhome_application.databinding.ActivityGioHangBinding;
import com.nhom4.models.GioHang;

import java.util.ArrayList;

public class GioHangActivity extends AppCompatActivity {

    ActivityGioHangBinding binding;
    AdapterGioHang adapter;
    LinearLayoutManager VerticalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    public static TextView txttongthanhtoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gio_hang);
        binding = ActivityGioHangBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvGiohang.setLayoutManager(RecyclerViewLayoutManager);

        adapter = new AdapterGioHang(MainActivity.manggiohang);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvGiohang.setLayoutManager(VerticalLayout);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(binding.rvGiohang.getContext(),
                VerticalLayout.getOrientation());
        binding.rvGiohang.addItemDecoration(dividerItemDecoration1);
        dividerItemDecoration1.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider));

        binding.rvGiohang.setAdapter(adapter);

        displaybackground();//Hiện giỏ hàng trống
        txttongthanhtoan = findViewById(R.id.txt_tongthanhtoan);
        binding.txtTongthanhtoan.setText("0đ");
    }

    private void displaybackground() {
        binding.txtEmptycart.setVisibility(MainActivity.manggiohang.size() <= 0 ? View.VISIBLE : View.GONE);
        binding.imvEmptycart.setVisibility(MainActivity.manggiohang.size() <= 0 ? View.VISIBLE : View.GONE);
        binding.rvGiohang.setVisibility(MainActivity.manggiohang.size() > 0 ? View.VISIBLE : View.GONE);
    }

    @Override
    protected void onResume() {
        binding.txtEmptycart.setVisibility(MainActivity.manggiohang.size() <= 0 ? View.VISIBLE : View.GONE);
        binding.imvEmptycart.setVisibility(MainActivity.manggiohang.size() <= 0 ? View.VISIBLE : View.GONE);
        binding.rvGiohang.setVisibility(MainActivity.manggiohang.size() > 0 ? View.VISIBLE : View.GONE);
        super.onResume();
    }

}