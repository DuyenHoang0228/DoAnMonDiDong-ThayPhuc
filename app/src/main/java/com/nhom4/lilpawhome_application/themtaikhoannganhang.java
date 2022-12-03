package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class themtaikhoannganhang extends AppCompatActivity {
Button themtaikhoan;
EditText tennganhang, tenchinhanh, sotaikhoan, tenchukhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_themtaikhoannganhang);
        themtaikhoan=findViewById(R.id.btn_themtaikhoannganhang);
        tennganhang=findViewById(R.id.edt_tennganhang);
        tenchinhanh=findViewById(R.id.edt_tenchinhanh);
        sotaikhoan=findViewById(R.id.edt_sotaikhoan);
        tenchukhoan=findViewById(R.id.edt_tenchutaikhoan);
        addEvents();
    }

    private void addEvents() {
        themtaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(themtaikhoannganhang.this, "Thêm tài khoản ngân hàng thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(themtaikhoannganhang.this, thietlaptaikhoan.class);
                startActivity(intent);
            }
        });
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

}