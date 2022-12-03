package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class thongtintaikhoannganhang extends AppCompatActivity {
    Button xoataikhoan;
    EditText tennganhang, tenchinhanh, sotaikhoan, tenchukhoan;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_thongtintaikhoannganhang);
        xoataikhoan=findViewById(R.id.btn_xoataikhoan);
        tennganhang=findViewById(R.id.txt_thongtinnganhang);
        tenchinhanh=findViewById(R.id.txt_thongtinchinhanh);
        sotaikhoan=findViewById(R.id.txt_thongtinsotaikhoan);
        tenchukhoan=findViewById(R.id.txt_thongtinchutaikhoan);
        addEvents();
    }

    private void addEvents() {
        xoataikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(thongtintaikhoannganhang.this, "Xóa tài khoản ngân hàng thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(thongtintaikhoannganhang.this, thietlaptaikhoan.class);
                startActivity(intent);
            }
        });
    }
}