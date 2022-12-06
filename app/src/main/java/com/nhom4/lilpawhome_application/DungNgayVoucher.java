package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;

import com.nhom4.databases.DBHelperSanPham;
import com.nhom4.lilpawhome_application.databinding.ActivityDungNgayVoucherBinding;
import com.nhom4.models.SanPhamLilPawHome;
import com.nhom4.view.adapters.SanPhamAdapterLilPawHome;

import java.util.ArrayList;

public class DungNgayVoucher extends AppCompatActivity {

    ActivityDungNgayVoucherBinding binding;
    ArrayList<SanPhamLilPawHome> spDungVoucher;
    SanPhamAdapterLilPawHome adapter;
    DBHelperSanPham db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDungNgayVoucherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_dung_ngay_voucher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_shopchocho12);
        EditText editTimKiem = findViewById(R.id.edt_timkiem);
        editTimKiem.setHint("Voucher");
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#ffffff")));
        createDB();
        loadData();
        addEvent();
    }

    private void addEvent() {
        ImageView imvgiohang = findViewById(R.id.imv_giohang);
        imvgiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DungNgayVoucher.this, GioHangActivity.class);
                startActivity(intent);
            }
        });
        ImageView imvTroVe=findViewById(R.id.imv_trove);
        imvTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.grSanpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DungNgayVoucher.this, TrangSanPhamActivity.class);
                SanPhamLilPawHome spitem = spDungVoucher.get(i);
                intent.putExtra("IDsanpham",spitem.getIdSanPham());
                startActivity(intent);
            }
        });
    }

    private void createDB() {
        db=new DBHelperSanPham(DungNgayVoucher.this);
        db.createSampleData();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.shopchocho1_option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void loadData() {
        Intent intent = getIntent();
        String chuTrongAnhVoucher = intent.getStringExtra("ChuTrongAnhVoucher");
        String titleOfVoucher = intent.getStringExtra("TitleOfVoucher");
        String HSD = intent.getStringExtra("HSDVoucher");
        int maxValue = intent.getIntExtra("MaxOfValue", 0);
        boolean isLimited = intent.getBooleanExtra("isLimited", true);

        binding.txtChutronganhvoucher.setText(chuTrongAnhVoucher);
        binding.txtTenvoucher.setText(titleOfVoucher);
        binding.txtHsdvoucher.setText(HSD);
        binding.txtVouchertoida.setText(String.valueOf(maxValue));
        if(isLimited){
            binding.txtSoluongcohan.setText("Số lượng có hạn");
        }else{
            binding.txtSoluongcohan.setVisibility(View.INVISIBLE);
        }
        binding.grSanpham.setExpanded(true);
        spDungVoucher = new ArrayList<>();
        Cursor c = db.getData(" SELECT * FROM " + DBHelperSanPham.TBL_NAME +
                " WHERE " + DBHelperSanPham.COL_OLDPRICE + " > 50000" );
        while (c.moveToNext()) {
            spDungVoucher.add(new SanPhamLilPawHome(c.getInt(0), c.getString(1), c.getDouble(2), c.getDouble(3), c.getDouble(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9), c.getString(10), c.getDouble(11), c.getDouble(12), c.getDouble(13)));
        }
        c.close();
        adapter = new SanPhamAdapterLilPawHome(DungNgayVoucher.this, R.layout.list_sanpham_id, spDungVoucher);
        binding.grSanpham.setAdapter(adapter);
    }
}