package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import com.nhom4.adapters.SanPhamAdapterLilPawHome;
import com.nhom4.adapters.SanphamAdapter;
import com.nhom4.databases.DBHelperSanPham;
import com.nhom4.lilpawhome_application.databinding.ActivitySanPhamTheoThuongHieuBinding;
import com.nhom4.models.SanPham;
import com.nhom4.models.SanPhamLilPawHome;

import java.util.ArrayList;

public class SanPhamTheoThuongHieuActivity extends AppCompatActivity {
    ActivitySanPhamTheoThuongHieuBinding binding;

    SanPhamAdapterLilPawHome adapterLilPawHome;
    ArrayList<SanPhamLilPawHome> sanPhamLilPawHomes;
    DBHelperSanPham dbHelperSanPham;
    TextView txtTenThuongHieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_san_pham_theo_thuong_hieu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_sanphamtheothuonghieu);
        txtTenThuongHieu=findViewById(R.id.txt_tenthuonghieu);
        binding=ActivitySanPhamTheoThuongHieuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createDb();
        loadData();
    }
    private void createDb() {
        dbHelperSanPham=new DBHelperSanPham(SanPhamTheoThuongHieuActivity.this);
        dbHelperSanPham.createSampleData();
    }

    private void loadData() {
        sanPhamLilPawHomes=new ArrayList<>();
        //chỗ này mng intent cái tên thương hiệu xong gán nó vào chuỗi s ở dưới nha
        Intent intent=getIntent();

        String s=intent.getStringExtra("tenthuonghieu");
        txtTenThuongHieu.setText(s.toUpperCase());
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_BRAND+" = "+"'"+s+"'");
        while(c.moveToNext())
        {
            sanPhamLilPawHomes.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapterLilPawHome=new SanPhamAdapterLilPawHome(SanPhamTheoThuongHieuActivity.this,R.layout.list_sanpham_id,sanPhamLilPawHomes);
        binding.gvSanphamtheothuonghieu.setAdapter(adapterLilPawHome);

    }
}