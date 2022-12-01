package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.databinding.ActivityDanhGiaCuaToiBinding;

public class DanhGiaCuaToi extends AppCompatActivity {

    ActivityDanhGiaCuaToiBinding binding;
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_danh_gia_cua_toi);

        binding = ActivityDanhGiaCuaToiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        creatTabHost();
        addEvent();
    }

    private void addEvent() {

    }

    private void creatTabHost() {
        tabHost = binding.thDanhgiacuatoi;
        tabHost.setup();
        //Tạo tab 1
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setContent(R.id.tab_chuadanhgia);
        tab1.setIndicator("Chưa đánh giá");
        tabHost.addTab(tab1);
        //Tạo tab 2
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setContent(R.id.tab_dadanhgia);
        tab2.setIndicator("Đã đánh giá");
        tabHost.addTab(tab2);


        binding.thDanhgiacuatoi.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {


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