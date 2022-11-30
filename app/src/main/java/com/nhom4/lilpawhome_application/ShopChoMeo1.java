package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nhom4.adapters.SanphamAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityShopChoMeo1Binding;
import com.nhom4.models.SanPham;

import java.util.ArrayList;

public class ShopChoMeo1 extends AppCompatActivity {
    ActivityShopChoMeo1Binding binding;
    SanphamAdapter adapter;
    ArrayList<SanPham> sanPhamArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shop_cho_meo1);
        binding=ActivityShopChoMeo1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    private void loadData() {
        sanPhamArrayList=new ArrayList<>();
        sanPhamArrayList.add(new SanPham(R.drawable.sphatcho,"Hạt cho mèo",120000,200000,
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

        adapter=new SanphamAdapter(ShopChoMeo1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchomeo.setAdapter(adapter);

    }
    private void loadData2() {
        sanPhamArrayList=new ArrayList<>();
        sanPhamArrayList.add(new SanPham(R.drawable.sphatcho,"Hạt cho chó",120000,200000,
                "Thương hiệu 1","thucanchocho","hatchocho"));
        sanPhamArrayList.add(new SanPham(R.drawable.sppatecho,"Pate cho chó",350000,400000,
                "Thương hiệu 1","thucanchocho","patechocho"));
        sanPhamArrayList.add(new SanPham(R.drawable.spsuacho,"Sữa tắm chó",250000,300000,
                "Thương hiệu 2","thucanchocho","suacho"));
        sanPhamArrayList.add(new SanPham(R.drawable.spvongcocho,"Vòng cổ chó cute",60000,80000,
                "Thương hiệu 3","phukiencho","vongcocho"));

        adapter=new SanphamAdapter(ShopChoMeo1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchomeo .setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.shopchomeo1_option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId()==R.id.mn_thucanchomeo)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchochothucan);
            loadData();
        }
        if (item.getItemId()==R.id.mn_dodungchomeo)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchochododung);
            loadData2();
        }
        return super.onOptionsItemSelected(item);
    }
}