package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nhom4.view.adapters.SanphamAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivitySanPhamTheoThuongHieuBinding;
import com.nhom4.models.SanPham;

import java.util.ArrayList;

public class SanPhamTheoThuongHieuActivity extends AppCompatActivity {
    ActivitySanPhamTheoThuongHieuBinding binding;
    SanphamAdapter adapter;
    ArrayList<SanPham> sanPhamArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_san_pham_theo_thuong_hieu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_sanphamtheothuonghieu);
        binding=ActivitySanPhamTheoThuongHieuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData() {
        sanPhamArrayList=new ArrayList<>();
        sanPhamArrayList.add(new SanPham(R.drawable.sphatcho,"Hạt cho chó",120000,200000,
                "Thương hiệu 1","thucanchocho","hatchocho"));
        sanPhamArrayList.add(new SanPham(R.drawable.sppatecho,"Pate cho chó",350000,400000,
                "Thương hiệu 1","thucanchocho","patechocho"));
        sanPhamArrayList.add(new SanPham(R.drawable.spsuacho,"Sữa tắm chó",250000,300000,
                "Thương hiệu 2","thucanchocho","suacho"));
        sanPhamArrayList.add(new SanPham(R.drawable.spsuatamcho,"Sữa tắm chó",120000,320000,
                "Thương hiệu 2","dodungcho","suatamcho"));
        sanPhamArrayList.add(new SanPham(R.drawable.spxuongcho,"Xương chó đồ chơi",20000,50000,
                "Thương hiệu 3","dochoicho","xuongcho"));
        sanPhamArrayList.add(new SanPham(R.drawable.spdinhduongcho,"Sữa dinh dưỡng cho chó",360000,500000,
                "Thương hiệu 3","thucanchocho","dinhduongchocho"));
        sanPhamArrayList.add(new SanPham(R.drawable.sptaimatmiengcho,"Cây chà răng chó",25000,40000,
                "Thương hiệu 4","dodungcho","taimatcho"));

        adapter=new SanphamAdapter(SanPhamTheoThuongHieuActivity.this,R.layout.sanpham_list,sanPhamArrayList);
        binding.gvSanphamtheothuonghieu.setAdapter(adapter);

    }

}