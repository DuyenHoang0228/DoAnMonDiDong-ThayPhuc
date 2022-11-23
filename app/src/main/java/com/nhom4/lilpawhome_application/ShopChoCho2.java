package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nhom4.adapters.SanphamAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityShopChoCho2Binding;
import com.nhom4.models.SanPham;

import java.util.ArrayList;

public class ShopChoCho2 extends AppCompatActivity {
    ActivityShopChoCho2Binding binding;
    SanphamAdapter adapter;
    ArrayList<SanPham> sanPhamArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shop_cho_cho2);
        binding=ActivityShopChoCho2Binding.inflate(getLayoutInflater());
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
        sanPhamArrayList.add(new SanPham(R.drawable.spvongcocho,"Vòng cổ chó cute",60000,80000,
                "Thương hiệu 3","phukiencho","vongcocho"));

        adapter=new SanphamAdapter(ShopChoCho2.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvShopchocho2.setAdapter(adapter);

    }
}