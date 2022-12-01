package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_shopchocho12);
        binding=ActivityShopChoCho2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
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

    private void loadData() {

        sanPhamArrayList=new ArrayList<>();
        sanPhamArrayList.add(new SanPham(R.drawable.sphatcho,"Hạt cho mèo",120000,200000,
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shopchocho2_option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}