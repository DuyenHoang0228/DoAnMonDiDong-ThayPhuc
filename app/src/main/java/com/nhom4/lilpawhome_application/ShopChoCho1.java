package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.app.Activity;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.nhom4.view.adapters.SanPhamAdapterLilPawHome;
import com.nhom4.view.adapters.SanphamAdapter;
import com.nhom4.databases.DBHelperSanPham;
import com.nhom4.lilpawhome_application.databinding.ActivityShopChoCho1Binding;
import com.nhom4.models.SanPham;
import com.nhom4.models.SanPhamLilPawHome;

import java.util.ArrayList;
import java.util.Iterator;

public class ShopChoCho1 extends AppCompatActivity {
    ActivityShopChoCho1Binding binding;
    SanPhamAdapterLilPawHome adapter;
    ArrayList<SanPhamLilPawHome> sanPhamArrayList;
    DBHelperSanPham dbHelperSanPham;

    ImageView imvTimKiem;
    EditText edtTimKiem;
    ImageView imvGiohang, imvTrove;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shop_cho_cho1);

        binding=ActivityShopChoCho1Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_shopchocho12);
        imvTimKiem=findViewById(R.id.imv_timkiem);
        edtTimKiem=findViewById(R.id.edt_timkiem);
        imvTrove=findViewById(R.id.imv_trove);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#ffffff")));
        setContentView(binding.getRoot());





        createDb();
        loadData();
        addEvents();

        //Cố định scroll của gridview

        //Intent qua màn hình giỏ hàng
        ImageView imvgiohang = findViewById(R.id.imv_giohang);
        imvgiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopChoCho1.this, GioHangActivity.class);
                startActivity(intent);
            }
        });

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
                adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
                binding.gvOptionchocho.setAdapter(adapter);
                hideKeyboard(ShopChoCho1.this);

            }
        });
        binding.gvOptionchocho.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ShopChoCho1.this, TrangSanPhamActivity.class);
                SanPhamLilPawHome spitem = sanPhamArrayList.get(i);
                intent.putExtra("IDsanpham",spitem.getIdSanPham());

                startActivity(intent);
            }
        });
        imvTrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
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


    private void createDb() {
        dbHelperSanPham=new DBHelperSanPham(ShopChoCho1.this);
        dbHelperSanPham.createSampleData();
    }
    private void loadData() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+DBHelperSanPham.COL_CATE1+" LIKE "+"'%chocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);
        binding.imvBannerthucanchocho.setImageResource(R.drawable.bannershopchochoedited);

        //Set sự kiện click vào ô sản phẩm thì chuyển đến trang sản phẩm chi tiết
        binding.gvOptionchocho.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ShopChoCho1.this, TrangSanPhamActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadChuongLong() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" = "+"'chuonglongchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);
    }

    private void loadPhuKien() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" = "+"'phukienchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);
    }

    private void loadDoChoi() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" = "+"'dochoichocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }

    private void loadDoDung() {
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" = "+"'dodungchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }

    private void loadThucAn() {

        //thứ tự các cột xem trong dbhelper, muốn lấy sản phẩm nào thì select thuộc tính như câu ở dưới
        //
        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE1+" = "+"'thucanchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadHat() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'hatchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }

    private void loadPate() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'hatchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadSua() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'hatchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadDinhDuong() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'hatchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadSnack() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'hatchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadKhay() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'khaychocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadChenAn() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'chenanchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadLongMong() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'longmongchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadTaiMat() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'taimatchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }

    private void loadSuaTam() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'suatamchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadXuong() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'xuongchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadGoi() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'goibongchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadBanhBong() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'banhbongchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadCaoMong() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'caomongchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadVongCo() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'vongcochocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadDayDat() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'daydatchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }

    private void loadRoMom() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'romomchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }

    private void loadQuanAo() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'quanaochocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }

    private void loadNem() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'nemchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadBaloVanChuyen() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'balochocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }
    private void loadLongVanChuyen() {

        sanPhamArrayList=new ArrayList<>();
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME+
                " WHERE "+ DBHelperSanPham.COL_CATE2+" = "+"'longvanchuyenchocho'");
        while(c.moveToNext())
        {
            sanPhamArrayList.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvOptionchocho.setAdapter(adapter);

    }










    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.shopchocho1_option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId()==R.id.mn_thucanchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochothucan);
            loadThucAn();
        }
        if (item.getItemId()==R.id.mn_dodungchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochododung);
            loadDoDung();
        }
        if (item.getItemId()==R.id.mn_dochoichocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochodochoi);
            loadDoChoi();
        }
        if (item.getItemId()==R.id.mn_phukienchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochophukien);
            loadPhuKien();
        }
        if (item.getItemId()==R.id.mn_chuonglongchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochochuong);
            loadChuongLong();
        }
        if (item.getItemId()==R.id.mn_hatchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochothucan);
            loadHat();
        }
        if (item.getItemId()==R.id.mn_patechocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochothucan);
            loadPate();
        }
        if (item.getItemId()==R.id.mn_suachocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochothucan);
            loadSua();
        }
        if (item.getItemId()==R.id.mn_dinhduongchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochothucan);
            loadDinhDuong();
        }
        if (item.getItemId()==R.id.mn_snackchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochothucan);
            loadSnack();
        }
        if (item.getItemId()==R.id.mn_khayvesinhchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochododung);
            loadKhay();
        }
        if (item.getItemId()==R.id.mn_chenanchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochododung);
            loadChenAn();
        }
        if (item.getItemId()==R.id.mn_longmongchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochododung);
            loadLongMong();
        }
        if (item.getItemId()==R.id.mn_taimatmiengchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochododung);
            loadTaiMat();
        }
        if (item.getItemId()==R.id.mn_suatamchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochododung);
            loadSuaTam();
        }
        if (item.getItemId()==R.id.mn_xuongchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochodochoi);
            loadXuong();
        }
        if (item.getItemId()==R.id.mn_caomongchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochodochoi);
            loadCaoMong();
        }
        if (item.getItemId()==R.id.mn_goichocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochodochoi);
            loadGoi();
        }
        if (item.getItemId()==R.id.mn_banhbongchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochodochoi);
            loadBanhBong();
        }
        if (item.getItemId()==R.id.mn_vongcochocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochophukien);
            loadVongCo();
        }
        if (item.getItemId()==R.id.mn_daydatchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochophukien);
            loadDayDat();
        }
        if (item.getItemId()==R.id.mn_quanaochocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochophukien);
            loadQuanAo();
        }
        if (item.getItemId()==R.id.mn_romomchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochophukien);
            loadRoMom();
        }

        if (item.getItemId()==R.id.mn_nemochocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochochuong);
            loadNem();
        }
        if (item.getItemId()==R.id.mn_longvanchuyenchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochochuong);
            loadLongVanChuyen();
        }
        if (item.getItemId()==R.id.mn_balovanchuyenchocho)
        {
            binding.imvBannerthucanchocho.setImageResource(R.drawable.shopchochochuong);
            loadBaloVanChuyen();
        }


        return super.onOptionsItemSelected(item);
    }




}