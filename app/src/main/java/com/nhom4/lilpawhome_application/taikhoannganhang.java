package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.nhom4.models.TaikhoanNH;
import com.nhom4.view.adapters.TKNH_Adapter;

import java.util.ArrayList;

public class taikhoannganhang extends AppCompatActivity {
    Button themtaikhoan;
    ListView tknh_list;
    TKNH_Adapter adapter;
    ArrayList<TaikhoanNH> nganhang_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_taikhoannganhang);
        themtaikhoan=findViewById(R.id.btn_themtaikhoan);
        tknh_list=findViewById(R.id.lv_tknh);
        addEvents();
        loadData();

    }

    private void loadData() {
        nganhang_list=new ArrayList<>();
        nganhang_list.add(new TaikhoanNH("BIDV"));
        adapter = new TKNH_Adapter(taikhoannganhang.this, R.layout.taikhoannh_list, nganhang_list);
        tknh_list.setAdapter(adapter);

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
        themtaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(taikhoannganhang.this, themtaikhoannganhang.class);
                startActivity(intent);
            }
        });
    }
}