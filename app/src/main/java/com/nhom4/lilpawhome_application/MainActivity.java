package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.nhom4.adapters.Danhmuc1Adapter;
import com.nhom4.lilpawhome_application.databinding.ActivityMainBinding;
import com.nhom4.models.DanhMuc1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Danhmuc1Adapter adapter;
    ArrayList<DanhMuc1> danhmuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // setContentView(binding.getRoot());
        View view = binding.getRoot();
        setContentView(view);
        
        loadData();
    }

    private void loadData() {
        danhmuc = new ArrayList<>();
        danhmuc.add(new DanhMuc1(R.drawable.icon_shopchocho_home,"Shop cho Chó"));
        danhmuc.add(new DanhMuc1(R.drawable.icon_shopchomeo_home,"Shop cho Mèo"));
        danhmuc.add(new DanhMuc1(R.drawable.icon_spa_home,"Spa"));
        danhmuc.add(new DanhMuc1(R.drawable.icon_thuonghieu_home,"Thương Hiệu"));
        danhmuc.add(new DanhMuc1(R.drawable.icon_uudai_home,"Ưu đãi"));
        danhmuc.add(new DanhMuc1(R.drawable.icon_blog_home,"Blog"));

        adapter = new Danhmuc1Adapter(MainActivity.this,R.layout.danhmuc1_list,danhmuc);
        binding.gvDanhmuchome.setAdapter(adapter);
    }
}