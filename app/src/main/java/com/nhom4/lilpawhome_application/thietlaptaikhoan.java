package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.databinding.ActivityDangkyBinding;
import com.nhom4.lilpawhome_application.databinding.ActivityThietlaptaikhoanBinding;

public class thietlaptaikhoan extends AppCompatActivity {
    ActivityThietlaptaikhoanBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      //  setContentView(R.layout.activity_thietlaptaikhoan);
        binding = ActivityThietlaptaikhoanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvent();
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

    private void addEvent() {
        binding.btnTaikhoanvabaomat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thietlaptaikhoan.this, taikhoanvabaomat.class);
                startActivity(intent);
            }
        });
        binding.btnDiachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thietlaptaikhoan.this, diachi.class);
                startActivity(intent);
            }
        });
        binding.btnTaikhoanvathenganhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thietlaptaikhoan.this, taikhoannganhang.class);
                startActivity(intent);
            }
        });
        binding.btnTaikhoanvathenganhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thietlaptaikhoan.this, taikhoannganhang.class);
                startActivity(intent);
            }
        });
        binding.btnCaidatthongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thietlaptaikhoan.this, caidatthongbao.class);
                startActivity(intent);
            }
        });
        binding.btnTrungtamhotro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thietlaptaikhoan.this, HelpActivity.class);
                startActivity(intent);
            }
        });
        binding.btnHuytaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(thietlaptaikhoan.this);
                dialog.setContentView(R.layout.dialog_yeucauhuytaikhoan);
                dialog.show();
                //Xóa bg dialog
                Window window = dialog.getWindow();
                if(window==null){
                    return;
                }
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //
                ImageButton thoat;
                thoat = dialog.findViewById(R.id.btn_exithtk);
                thoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                Button dongy;
                dongy=dialog.findViewById(R.id.btn_dongyhuytk);
                dongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(thietlaptaikhoan.this, "Xóa tài khoản thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(thietlaptaikhoan.this, dangnhap1.class);
                        startActivity(intent);
                        finish();
                    }
                });
                binding.btnDangxuat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Dialog dialog = new Dialog(thietlaptaikhoan.this);
                        dialog.setContentView(R.layout.dialog_dangxuat);
                        dialog.show();

                        //Xóa bg dialog
                        Window window = dialog.getWindow();
                        if(window==null){
                            return;
                        }
                        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                        ImageButton thoatdx;
                        thoatdx = dialog.findViewById(R.id.btn_exitdx);
                        thoatdx.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                        Button dangxuat;
                        dangxuat=dialog.findViewById(R.id.btn_dangx);
                        dangxuat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(thietlaptaikhoan.this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(thietlaptaikhoan.this, dangnhap1.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }
                });
            }
        });
    }
}