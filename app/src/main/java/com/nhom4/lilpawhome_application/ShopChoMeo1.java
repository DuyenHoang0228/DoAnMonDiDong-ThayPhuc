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
    ImageView imvTimKiem;
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

        createDb();
        loadData();
        loadThucAn();
        loadDoDung();
        loadDoChoi();
        loadPhuKien();
        loadChuongLong();
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