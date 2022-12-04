package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nhom4.databases.DBHelperSanPham;
import com.nhom4.lilpawhome_application.databinding.ActivitySanPhamYeuThichBinding;
import com.nhom4.models.SanPhamLilPawHome;
import com.nhom4.view.adapters.SanPhamAdapterLilPawHome;

import java.util.ArrayList;

public class SanPhamYeuThich extends AppCompatActivity {

    ActivitySanPhamYeuThichBinding binding;
    DBHelperSanPham db;
    //ArrayList<SanPhamLilPawHome> spYeuThich;
    SanPhamAdapterLilPawHome adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_san_pham_yeu_thich);

        binding = ActivitySanPhamYeuThichBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createDb();
        loadData();
    }

    private void createDb() {
        db=new DBHelperSanPham(SanPhamYeuThich.this);
        db.createSampleData();
    }
    private void loadData() {

//        spYeuThich = new ArrayList<>();
//        Cursor c = db.getData(" SELECT * FROM " + DBHelperSanPham.TBL_NAME +
//                    " WHERE " + DBHelperSanPham.COL_OLDPRICE + " > 50000" );
//        while (c.moveToNext()) {
//            spYeuThich.add(new SanPhamLilPawHome(c.getInt(0), c.getString(1), c.getDouble(2), c.getDouble(3), c.getDouble(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9), c.getString(10), c.getDouble(11), c.getDouble(12), c.getDouble(13)));
//            }
//        c.close();
        adapter = new SanPhamAdapterLilPawHome(SanPhamYeuThich.this, R.layout.list_sanpham_id, MainActivity.spYeuThich);
        binding.gvSanphamyeuthich.setAdapter(adapter);

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.shopchocho1_option_menu,menu);
        return super.onCreateOptionsMenu(menu);
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