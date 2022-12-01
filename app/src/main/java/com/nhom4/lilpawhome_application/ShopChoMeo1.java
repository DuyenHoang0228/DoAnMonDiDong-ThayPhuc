package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nhom4.adapters.SanPhamAdapterLilPawHome;
import com.nhom4.adapters.SanphamAdapter;
import com.nhom4.databases.DBHelperSanPham;
import com.nhom4.lilpawhome_application.databinding.ActivityShopChoCho1Binding;
import com.nhom4.lilpawhome_application.databinding.ActivityShopChoMeo1Binding;
import com.nhom4.models.SanPham;
import com.nhom4.models.SanPhamLilPawHome;

import java.util.ArrayList;

public class ShopChoMeo1 extends AppCompatActivity {
    ActivityShopChoMeo1Binding binding;
    SanPhamAdapterLilPawHome adapter;
    ArrayList<SanPhamLilPawHome> sanPhamArrayList;
    DBHelperSanPham dbHelperSanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shop_cho_meo1);
        binding=ActivityShopChoMeo1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_shopchomeo12);
        binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeothucan);


        createDb();
        loadData();
        loadThucAn();
        loadDoDung();
        loadDoChoi();
        loadPhuKien();
        loadChuongLong();

    }

    private void loadChuongLong() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
        " WHERE "+ DBHelperSanPham.COL_CATE1+" = "+"'chuonglongchomeo'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoMeo1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchomeo.setAdapter(adapter);
    }

    private void loadPhuKien() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" = "+"'phukienchomeo'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoMeo1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchomeo.setAdapter(adapter);
    }

    private void loadDoChoi() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" = "+"'dochoichomeo'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoMeo1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchomeo.setAdapter(adapter);

    }

    private void loadDoDung() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" = "+"'dodungchomeo'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoMeo1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchomeo.setAdapter(adapter);

    }

    private void loadThucAn() {

        //thứ tự các cột xem trong dbhelper, muốn lấy sản phẩm nào thì select thuộc tính như câu ở dưới
        //
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" = "+"'thucanchomeo'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoMeo1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchomeo.setAdapter(adapter);

    }

    private void createDb() {
        dbHelperSanPham=new DBHelperSanPham(ShopChoMeo1.this);
        dbHelperSanPham.createSampleData();

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
        adapter=new SanPhamAdapterLilPawHome(ShopChoMeo1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchomeo.setAdapter(adapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.shopchomeo1_option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId()==R.id.mn_thucanchomeo)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchochothucan);
            loadThucAn();
        }
        if (item.getItemId()==R.id.mn_dodungchomeo)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeothucan);
            loadDoDung();
        }
        if (item.getItemId()==R.id.mn_dochoichomeo)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeodochoi);
            loadDoChoi();
        }
        if (item.getItemId()==R.id.mn_phukienchomeo)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeophukien);
            loadPhuKien();
        }
        if (item.getItemId()==R.id.mn_chuonglongchomeo)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeochuong);
            loadChuongLong();
        }
        return super.onOptionsItemSelected(item);
    }
}