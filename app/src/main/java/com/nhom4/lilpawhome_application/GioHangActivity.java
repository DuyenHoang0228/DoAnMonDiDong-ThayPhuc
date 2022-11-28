package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nhom4.adapters.AdapterGioHang;
import com.nhom4.lilpawhome_application.databinding.ActivityGioHangBinding;
import com.nhom4.models.GioHang;

import java.util.ArrayList;

public class GioHangActivity extends AppCompatActivity {

    ActivityGioHangBinding binding;
    AdapterGioHang adapter;
    ArrayList<GioHang> gioHangs;
    LinearLayoutManager VerticalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gio_hang);
        binding = ActivityGioHangBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();

        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvGiohang.setLayoutManager(RecyclerViewLayoutManager);

        adapter = new AdapterGioHang(gioHangs);

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
    }

    private void loadData() {
        gioHangs = new ArrayList<>();
        gioHangs.add(new GioHang(R.drawable.giohang_sp1, 1, getString(R.string.brand_sp, "Virbac"),
                "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "SHOP CHO CHÓ", 190000.0, 249000.0));
        gioHangs.add(new GioHang(R.drawable.giohang_sp2, 1, getString(R.string.brand_sp, "Smartheart"),
                "[COMBO 5 GÓI] Thức Ăn Cho Chó Trưởng Thành Smartheart 400g", "SHOP CHO CHÓ", 100000.0, 190000.0));
        gioHangs.add(new GioHang(R.drawable.giohang_sp3, 1, getString(R.string.brand_sp, "Me-o"),
                "[CAO CẤP] Hạt Cho Mèo Me-O Gold Indoor 1.2kg – Giảm Mùi Chất Thải", "SHOP CHO MÈO", 133000.0, 169000.0));
        gioHangs.add(new GioHang(R.drawable.giohang_sp4, 1, getString(R.string.brand_sp, "Bioline"),
                "Bộ Trồng Cỏ Mèo Tươi Bioline 12g – Bổ Sung Chất Xơ, Giảm Stress", "SHOP CHO MÈO", 50000.0, 109000.0));
        gioHangs.add(new GioHang(R.drawable.giohang_sp5, 1, getString(R.string.brand_sp, "Beaphar"),
                "Vòng Cổ Cho Mèo Giảm Căng Thẳng Beaphar Collar", "SHOP CHO MÈO", 221000.0, 269000.0));
        gioHangs.add(new GioHang(R.drawable.giohang_sp6, 1, getString(R.string.brand_sp, "All for Paws"),
                "Đồ Chơi Siêu Âm Hình Sóc AFP Ultrasonic", "SHOP CHO CHÓ", 450000.0, 539000.0));
    }
}