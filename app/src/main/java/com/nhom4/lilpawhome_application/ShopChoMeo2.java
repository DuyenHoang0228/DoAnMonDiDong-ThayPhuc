package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nhom4.adapters.SanPhamAdapterLilPawHome;
import com.nhom4.adapters.SanphamAdapter;
import com.nhom4.databases.DBHelperSanPham;
import com.nhom4.lilpawhome_application.databinding.ActivityShopChoMeo2Binding;
import com.nhom4.models.SanPham;
import com.nhom4.models.SanPhamLilPawHome;

import java.util.ArrayList;

public class ShopChoMeo2 extends AppCompatActivity {
    ActivityShopChoMeo2Binding binding;
    SanPhamAdapterLilPawHome adapter;
    ArrayList<SanPhamLilPawHome> sanPhamArrayList;
    DBHelperSanPham dbHelperSanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_cho_meo2);
        binding=ActivityShopChoMeo2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
    }

    private void loadData() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME);
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoMeo2.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvShopchomeo2.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shopchomeo2_option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.mn_sanphambanchaychomeo)
        {

            loadBanChay();
        }
        if (item.getItemId()==R.id.mn_sanphamhiemchomeo)
        {

            loadHiem();
        }
        if (item.getItemId()==R.id.mn_sanphammoinhatchomeo)
        {

            loadMoiNhat();
        }
        return super.onOptionsItemSelected(item);
    }
    private void loadMoiNhat() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE3+" = "+"'moinhat'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoMeo2.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvShopchomeo2.setAdapter(adapter);

    }

    private void loadHiem() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE3+" = "+"'hiem'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoMeo2.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvShopchomeo2.setAdapter(adapter);

    }

    private void loadBanChay() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE3+" = "+"'banchay'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoMeo2.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvShopchomeo2.setAdapter(adapter);

    }
}