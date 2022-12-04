package com.nhom4.lilpawhome_application;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nhom4.fragment.ChoxacnhanFragment;
import com.nhom4.lilpawhome_application.databinding.ActivityDanhmucBinding;
import com.nhom4.lilpawhome_application.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {
    ActivityUserBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_danhmuc);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        // setContentView(binding.getRoot());
        View view = binding.getRoot();
        setContentView(view);

        showActionBar();
        addEvent();
    }

    private void addEvent() {
        binding.lnDonmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,DsDonmuaActivity.class);

                startActivity(intent);
            }
        });
        binding.imvLichhenspa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,DSLichhenActivity.class);

                startActivity(intent);
            }
        });
        binding.imvHosothucung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,ChonHosoActivity.class);

                startActivity(intent);
            }
        });
        binding.lnKhovoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,KhoVoucher.class);

                startActivity(intent);
            }
        });
        binding.lnSanphamyeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,SanPhamYeuThich.class);
                startActivity(intent);
            }
        });
        binding.lnDanhgiacuatoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,DanhGiaCuaToi.class);

                startActivity(intent);
            }
        });
        binding.lnTrogiup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,HelpActivity.class);

                startActivity(intent);
            }
        });
        binding.lnTrochuEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,ChatActivity.class);

                startActivity(intent);
            }
        });
        binding.lnThietlaptaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,thietlaptaikhoan.class);

                startActivity(intent);
            }
        });
        binding.lnKhachhangthanthiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,khachhangthanthiet.class);
                startActivity(intent);
            }
        });
        binding.lnCholayhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,DsDonmuaActivity.class);
                startActivity(intent);
            }
        });
        binding.lnChoxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,DsDonmuaActivity.class);
                startActivity(intent);
            }
        });
        binding.lnDanggiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,DsDonmuaActivity.class);
                startActivity(intent);
            }
        });
        binding.lnDanhgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this,DanhGiaCuaToi.class);

                startActivity(intent);
            }
        });
    }

    private void showActionBar() {
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.nav_action_taikhoan);
        navigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_action_taikhoan:
                        return true;
                    case R.id.nav_action_danhmuc:
                        Intent intent1 = new Intent(getApplicationContext(), DanhmucActivity.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent1);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_action_home:
                        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_action_thongbao:
                        Intent intent3 = new Intent(getApplicationContext(), NoticeActivity.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent3);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_action_qr:
                        Dialog dialog = new Dialog(UserActivity.this);
                        dialog.setContentView(R.layout.qr_user);
                        dialog.show();
                        return true;
                }
                return false;
            }
        });

    }

    ;
}