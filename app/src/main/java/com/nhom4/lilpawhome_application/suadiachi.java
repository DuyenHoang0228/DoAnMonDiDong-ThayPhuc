package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class suadiachi extends AppCompatActivity {
    Button xoadiachi, hoanthanh;
    EditText suaten, suasodienthoai, suatinh, suanha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_suadiachi);
        hoanthanh=findViewById(R.id.btn_suahoanthanh);
        xoadiachi=findViewById(R.id.btn_xoadiachi);
        addEvents();
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

    private void addEvents() {
        hoanthanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(suadiachi.this, thietlaptaikhoan.class);
                startActivity(intent);
                Toast.makeText(suadiachi.this, "Sửa địa chỉ thành công!", Toast.LENGTH_SHORT).show();
            }
        });
        xoadiachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}