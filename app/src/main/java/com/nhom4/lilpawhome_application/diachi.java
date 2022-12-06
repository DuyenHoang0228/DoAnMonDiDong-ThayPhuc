package com.nhom4.lilpawhome_application;

import static com.nhom4.lilpawhome_application.Utils_Diachi.DB_NAME;
import static com.nhom4.lilpawhome_application.Utils_Diachi.DB_PATH_SUFFIX;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.nhom4.models.DiaChi;
import com.nhom4.models.DiaChi_tt;
import com.nhom4.models.TaikhoanNH;
import com.nhom4.models.ThuCung;
import com.nhom4.view.adapters.AdapterDiaChiTT;
import com.nhom4.view.adapters.TKNH_Adapter;
import com.nhom4.view.adapters.diachiAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class diachi extends AppCompatActivity {
    Button themdiachi;
    RecyclerView rcvdiachi;
    LinearLayoutManager VerticalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    ArrayList<DiaChi> diaChis;
    diachiAdapter adapter;
    public SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_diachi);
        themdiachi=findViewById(R.id.btn_themdiachimoi);
        rcvdiachi= findViewById(R.id.rcv_diachi);

        loadData();
        addEvents();
    }

    @Override
    protected void onResume() {
        loadData();
        super.onResume();
    }

    private void loadData() {
        diaChis = new ArrayList<>();
        db = openOrCreateDatabase(Utils_Diachi.DB_NAME, MODE_PRIVATE,null);
        Cursor c = db.query(Utils_Diachi.TBL_NAME, null,null,
                null,null,null,null);
        while (c.moveToNext()){
            String tinh = c.getString(3);
            String quan = c.getString(4);
            String phuong = c.getString(5);
            String duong = c.getString(6);
            String diachi = duong + ", " + phuong + ", " + quan + ", " + tinh;
            diaChis.add(new DiaChi(c.getString(1), c.getString(2), diachi));
        }
        c.close();
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcvdiachi.setLayoutManager(RecyclerViewLayoutManager);

        adapter = new diachiAdapter(diaChis);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvdiachi.setLayoutManager(VerticalLayout);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(rcvdiachi.getContext(),
                VerticalLayout.getOrientation());
        rcvdiachi.addItemDecoration(dividerItemDecoration1);
        dividerItemDecoration1.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider_pink));

        rcvdiachi.setAdapter(adapter);
        rcvdiachi.setNestedScrollingEnabled(false);
    }

    private void addEvents() {
        themdiachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(diachi.this, com.nhom4.lilpawhome_application.themdiachi.class);
                startActivity(intent);
            }
        });
    }


    //Thêm menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        if (item_id == R.id.item_timkiem2) {
            Toast.makeText(this, "Tìm kiếm", Toast.LENGTH_SHORT).show();
            Dialog dialog = new Dialog(diachi.this);
            dialog.setContentView(R.layout.dialog_thanhtimkiem);
            dialog.show();
            ImageButton thoat;
            thoat = dialog.findViewById(R.id.btn_exittk);
            thoat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        } else if (item_id == R.id.item_shopchocho2) {
            Toast.makeText(this, "Shop cho chó", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(diachi.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(diachi.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(diachi.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(diachi.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(diachi.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(diachi.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(diachi.this, BlogActivity.class);
            startActivity(intent);
        }
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