package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;

import com.nhom4.view.adapters.SanPhamAdapterLilPawHome;
import com.nhom4.databases.DBHelperSanPham;
import com.nhom4.lilpawhome_application.databinding.ActivityShopChoMeo1Binding;
import com.nhom4.models.SanPhamLilPawHome;

import java.util.ArrayList;

public class    ShopChoMeo1 extends AppCompatActivity {
    ActivityShopChoMeo1Binding binding;
    SanPhamAdapterLilPawHome adapter;
    ArrayList<SanPhamLilPawHome> sanPhamArrayList;
    DBHelperSanPham dbHelperSanPham;
    ImageView imvTimKiem, imvTroVe, imv;
    EditText edtTimKiem;
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
        imvTimKiem=findViewById(R.id.imv_timkiem);
        edtTimKiem=findViewById(R.id.edt_timkiem);
        imvTroVe=findViewById(R.id.imv_trove);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#ffffff")));
        setContentView(binding.getRoot());

        createDb();
        loadData();
        addEvents();
    }

    private void addEvents() {
        imvTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=edtTimKiem.getText().toString();
                sanPhamArrayList=new ArrayList<>();
                Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME
                        +" WHERE "+ DBHelperSanPham.COL_NAME+" LIKE "+"'%"+s+"%'"+" AND "+DBHelperSanPham.COL_CATE1+
                        " LIKE "+"'%chocho'");
                while(c.moveToNext())
                {
                    sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                            c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                            c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
                }
                c.close();
                adapter=new SanPhamAdapterLilPawHome(ShopChoMeo1.this,R.layout.list_sanpham_id,sanPhamArrayList);
                binding.gvOptionchomeo.setAdapter(adapter);
                hideKeyboard(ShopChoMeo1.this);

            }
        });
        binding.gvOptionchomeo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ShopChoMeo1.this, TrangSanPhamActivity.class);
                SanPhamLilPawHome spitem = sanPhamArrayList.get(i);
                intent.putExtra("IDsanpham",spitem.getIdSanPham());
                startActivity(intent);
            }
        });
        imvTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //Intent qua màn hình giỏ hàng
        ImageView imvgiohang = findViewById(R.id.imv_giohang);
        imvgiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopChoMeo1.this, GioHangActivity.class);
                startActivity(intent);
            }
        });

    }
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
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
        binding.imvBannerthucanchomeo.setImageResource(R.drawable.bannershopchomeoedited);
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

    private void loadHat() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'hatchomeo'");
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

    private void loadPate() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'hatchomeo'");
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
    private void loadSua() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'hatchomeo'");
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
    private void loadDinhDuong() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'dinhduongchomeo'");
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
    private void loadSnack() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'snackchomeo'");
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
    private void loadKhay() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'khaychomeo'");
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
    private void loadChenAn() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'chenanchomeo'");
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
    private void loadLongMong() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'longmongchomeo'");
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
    private void loadTaiMat() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'taimatchomeo'");
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

    private void loadSuaTam() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'suatamchomeo'");
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
    private void loadXuong() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'xuongchomeo'");
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
    private void loadGoi() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'goibongnchomeo'");
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
    private void loadBanhBong() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'banhbongchomeo'");
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
    private void loadCaoMong() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'caomongchomeo'");
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
    private void loadVongCo() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'vongcochomeo'");
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







    private void loadQuanAo() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'quanaochomeo'");
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

    private void loadNem() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'nemchomeo'");
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
    private void loadBaloVanChuyen() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'balochomeo'");
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
    private void loadLongVanChuyen() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'longvanchuyenchomeo'");
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
    private void loadCoMeo() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'comeo'");
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
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeododung);
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

        if (item.getItemId()==R.id.mn_hatchocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeothucan);
            loadHat();
        }
        if (item.getItemId()==R.id.mn_patechocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeothucan);
            loadPate();
        }
        if (item.getItemId()==R.id.mn_suachocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeothucan);
            loadSua();
        }
        if (item.getItemId()==R.id.mn_dinhduongchocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeothucan);
            loadDinhDuong();
        }
        if (item.getItemId()==R.id.mn_snackchocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeothucan);
            loadSnack();
        }
        if (item.getItemId()==R.id.mn_khayvesinhchocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeododung);
            loadKhay();
        }
        if (item.getItemId()==R.id.mn_chenanchocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeododung);
            loadChenAn();
        }
        if (item.getItemId()==R.id.mn_longmongchocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeododung);
            loadLongMong();
        }
        if (item.getItemId()==R.id.mn_taimatmiengchocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeododung);
            loadTaiMat();
        }
        if (item.getItemId()==R.id.mn_suatamchocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeododung);
            loadSuaTam();
        }
        if (item.getItemId()==R.id.mn_xuongchocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeodochoi);
            loadXuong();
        }
        if (item.getItemId()==R.id.mn_caomongchocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeodochoi);
            loadCaoMong();
        }
        if (item.getItemId()==R.id.mn_goichocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeodochoi);
            loadGoi();
        }
        if (item.getItemId()==R.id.mn_banhbongchocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeodochoi);
            loadBanhBong();
        }
        if (item.getItemId()==R.id.mn_vongcochomeo)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeophukien);
            loadVongCo();
        }

        if (item.getItemId()==R.id.mn_quanaochocho)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeophukien);
            loadQuanAo();
        }
        if (item.getItemId()==R.id.mn_comeo)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeododung);
            loadCoMeo();
        }

        if (item.getItemId()==R.id.mn_nemochomeo)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeochuong);
            loadNem();
        }
        if (item.getItemId()==R.id.mn_longvanchuyenchomeo)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeochuong);
            loadLongVanChuyen();
        }
        if (item.getItemId()==R.id.mn_balovanchuyenchomeo)
        {
            binding.imvBannerthucanchomeo.setImageResource(R.drawable.shopchomeochuong);
            loadBaloVanChuyen();
        }
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
        if (item.getItemId()==R.id.mn_giatangdan)
        {

            loadGiaTangDan();
        }
        if (item.getItemId()==R.id.mn_giagiamdan)
        {

            loadGiaGiamDan();
        }
        if (item.getItemId()==R.id.mn_luotmuatangdan)
        {

            loadLuotMuaTangDan();
        }
        if (item.getItemId()==R.id.mn_luotmuagiamdan)
        {

            loadLuotMuaGiamDan();
        }
        if (item.getItemId()==R.id.mn_danhgiacao)
        {

            loadDanhGiaCao();
        }


        return super.onOptionsItemSelected(item);
    }
    private void loadDanhGiaCao() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" LIKE "+"'%chomeo'" +" AND "+DBHelperSanPham.COL_RATE+" > "+4);
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

    private void loadLuotMuaGiamDan() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" LIKE "+"'%chomeo'" +" ORDER BY "+DBHelperSanPham.COL_NUMORDER+" DESC ");
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

    private void loadLuotMuaTangDan() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" LIKE "+"'%chomeo'" +" ORDER BY "+DBHelperSanPham.COL_NUMORDER+" ASC ");
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

    private void loadGiaGiamDan() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" LIKE "+"'%chomeo'" +" ORDER BY "+DBHelperSanPham.COL_NEWPRICE+" DESC ");
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

    private void loadGiaTangDan() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" LIKE "+"'%chomeo'" +" ORDER BY "+DBHelperSanPham.COL_NEWPRICE+" ASC ");
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

    private void loadMoiNhat() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE3+" = "+"'moinhat'"+" AND " +DBHelperSanPham.COL_CATE1+" LIKE "+"'%chomeo'");
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

    private void loadHiem() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE3+" = "+"'hiem'"+" AND " +DBHelperSanPham.COL_CATE1+" LIKE "+"'%chomeo'");
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

    private void loadBanChay() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE3+" = "+"'banchay'"+" AND " +DBHelperSanPham.COL_CATE1+" LIKE "+"'%chomeo'");
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
}