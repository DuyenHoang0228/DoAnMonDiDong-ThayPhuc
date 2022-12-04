package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.nhom4.databases.DBHelperSanPham;
import com.nhom4.lilpawhome_application.databinding.ActivityHelpBinding;
import com.nhom4.lilpawhome_application.databinding.ActivityXemtatcaSpactivityBinding;
import com.nhom4.models.SanPhamLilPawHome;
import com.nhom4.view.adapters.SanPhamAdapterLilPawHome;

import java.util.ArrayList;

public class xemtatcaSPActivity extends AppCompatActivity {
    ActivityXemtatcaSpactivityBinding binding;
    SanPhamAdapterLilPawHome adapter;
    ArrayList<SanPhamLilPawHome> sanPhamArrayList;
    DBHelperSanPham dbHelperSanPham;
    String info;
    Cursor c;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_xemtatca_spactivity);
        binding = ActivityXemtatcaSpactivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        createDb();
      //  InitData();
        LoadSanPham();
        addEvent();
    }

    private void addEvent() {
        binding.lvXemtatca.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(xemtatcaSPActivity.this, TrangSanPhamActivity.class);
                SanPhamLilPawHome spitem = sanPhamArrayList.get(i);
                intent.putExtra("IDsanpham",spitem.getIdSanPham());

                startActivity(intent);
            }
        });
    }

    private void LoadSanPham() {
        sanPhamArrayList=new ArrayList<>();
        Intent intent = getIntent();
        String loaisanpham = intent.getStringExtra("loaisanpham");
        switch (loaisanpham){
            case "banchay":
                c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
                    " WHERE "+ DBHelperSanPham.COL_CATE3+" = 'banchay' ");

                while(c.moveToNext())
                {
                    sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                            c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                            c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
                }
                c.close();
                adapter=new SanPhamAdapterLilPawHome(xemtatcaSPActivity.this,R.layout.list_sanpham_id,sanPhamArrayList);
                binding.lvXemtatca.setAdapter(adapter);
            case  "giamgia":
                c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
                        " WHERE "+ DBHelperSanPham.COL_DISCOUNT+" > 0.25 ");

                while(c.moveToNext())
                {
                    sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                            c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                            c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
                }
                c.close();
                adapter=new SanPhamAdapterLilPawHome(xemtatcaSPActivity.this,R.layout.list_sanpham_id,sanPhamArrayList);
                binding.lvXemtatca.setAdapter(adapter);

        }

        /*if (loaisanpham == "banchay"){
            Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
                    " WHERE "+ DBHelperSanPham.COL_CATE3+" = 'banchay' ");

        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        }
        if (loaisanpham == "giamgia"){
            Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
                    " WHERE "+ DBHelperSanPham.COL_DISCOUNT+" > 0.25 ");


            while(c.moveToNext())
            {
                sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                        c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                        c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
            }
            c.close();

        }
        adapter=new SanPhamAdapterLilPawHome(xemtatcaSPActivity.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.lvXemtatca.setAdapter(adapter);*/

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
    private void createDb() {
        dbHelperSanPham = new DBHelperSanPham(xemtatcaSPActivity.this);
        dbHelperSanPham.createSampleData();
    }
}