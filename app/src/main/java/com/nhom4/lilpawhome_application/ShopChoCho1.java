package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.nhom4.view.adapters.SanPhamAdapterLilPawHome;
import com.nhom4.databases.DBHelperSanPham;
import com.nhom4.lilpawhome_application.databinding.ActivityShopChoCho1Binding;
import com.nhom4.models.SanPhamLilPawHome;

import java.util.ArrayList;

public class ShopChoCho1 extends AppCompatActivity {
    ActivityShopChoCho1Binding binding;
    SanPhamAdapterLilPawHome adapter;
    ArrayList<SanPhamLilPawHome> sanPhamArrayList;
    DBHelperSanPham dbHelperSanPham;

    ImageView imvTimKiem;
    EditText edtTimKiem;



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
                adapter=new SanPhamAdapterLilPawHome(ShopChoCho1.this,R.layout.list_sanpham_id,sanPhamArrayList);
                binding.gvOptionchocho.setAdapter(adapter);
                hideKeyboard(ShopChoCho1.this);

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
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME);
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
        return super.onOptionsItemSelected(item);
    }
}