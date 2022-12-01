package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.nhom4.adapters.AdapterViewPagerDSDonmua;

public class DsDonmuaActivity extends AppCompatActivity {

    TabLayout mTabLayout;
    ViewPager2 mViewPager;
    AdapterViewPagerDSDonmua adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_donmua);

        //Ánh xạ TabLayout và Viewpager
        mTabLayout = findViewById(R.id.tablayout_dsdonmua);
        mViewPager = findViewById(R.id.viewpager_dsdonmua);

        //Khởi tạo adapter cho View Pager và xác định context của fragmentActivity là this
        adapterViewPager = new AdapterViewPagerDSDonmua(this);
        mViewPager.setAdapter(adapterViewPager);

        //Tạo TabLayoutMediator như cầu nối giữa TabLayout và ViewPager - bấm vào tab thì viewpager trả fragment dựa trên tab và ngược lại
        new TabLayoutMediator(mTabLayout, mViewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Chờ xác nhận");
                    break;
                case 1:
                    tab.setText("Đang giao");
                    break;
                case 2:
                    tab.setText("Đã giao");
                    break;
                case 3:
                    tab.setText("Đã hủy");
                    break;
            }
        }).attach();//bắt đầu tham chiếu từ fragment đến activity để chuẩn bị khởi tạo fragment
    }
}