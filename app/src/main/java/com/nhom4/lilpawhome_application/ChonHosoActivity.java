package com.nhom4.lilpawhome_application;

import static com.nhom4.lilpawhome_application.Utils_Spa.DB_NAME;
import static com.nhom4.lilpawhome_application.Utils_Spa.DB_PATH_SUFFIX;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4.models.ThuCung;
import com.nhom4.view.adapters.AdapterChonHoso;
import com.nhom4.lilpawhome_application.databinding.ActivityChonHosoBinding;
import com.nhom4.models.HoSo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ChonHosoActivity extends AppCompatActivity {

    ActivityChonHosoBinding binding;
    AdapterChonHoso adapter;
    LinearLayoutManager VerticalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    ArrayList<HoSo> hoSoList;

    ArrayList<ThuCung> thuCungs;
    SQLiteDatabase dbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chon_hoso);
        binding = ActivityChonHosoBinding.inflate(getLayoutInflater());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(binding.getRoot());
        copyDB();
        loadData();

        binding.rvHosothucung.setExpanded(true);
        adapter = new AdapterChonHoso(hoSoList, ChonHosoActivity.this, R.layout.hoso_button_id);
        binding.rvHosothucung.setAdapter(adapter);

        addIntent();
        //addEvent();
        //loadDB();
    }

    private void addEvent() {
        binding.rvHosothucung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


           }
        });
    }

    private void loadDB() {
        thuCungs = new ArrayList<>();
        dbb = openOrCreateDatabase(DB_NAME, MODE_PRIVATE,null);

        Cursor c = dbb.query(Utils_Spa.TBL_NAME, null,null,
                null,null,null,null);
        while (c.moveToNext()){
            thuCungs.add(new ThuCung(c.getInt(0), c.getString(1), c.getInt(2), c.getInt(3), c.getString(4), c.getDouble(5)));
        }
        c.close();
    }

    private void addIntent() {
        binding.btnThemthucung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChonHosoActivity.this, TaoHosoActivity.class);
                startActivity(intent);
            }
        });
    }
    private void copyDB() {
        File dbPath = getDatabasePath(DB_NAME);
        if(!dbPath.exists()) {
            if(copyDBFromAssets()){
                Toast.makeText(ChonHosoActivity.this,
                        "Copy database successful!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(ChonHosoActivity.this, "Copy database fail!", Toast.LENGTH_LONG).show();
            }
        }
    }

    protected void onResume() {
        loadDB();
        super.onResume();
    }
    private boolean copyDBFromAssets() {
        String dbPath = getApplicationInfo().dataDir + DB_PATH_SUFFIX + DB_NAME;

        //Directory database in folder assets

        try {
            InputStream inputStream = getAssets().open(DB_NAME);
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists()){
                f.mkdir();
            }
            OutputStream outputStream = new FileOutputStream(dbPath);
            byte[] buffer = new byte[1024]; int length;
            while ((length=inputStream.read(buffer))>0){
                outputStream.write(buffer,0,length);
            }
            outputStream.flush(); outputStream.close(); inputStream.close();
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    private void loadData() {
        hoSoList = new ArrayList<>();
        hoSoList.add(new HoSo(getString(R.string.be_cung, "Lily")));
        hoSoList.add(new HoSo("Bé cưng Love"));
        hoSoList.add(new HoSo(getString(R.string.be_cung, "Leo")));
        hoSoList.add(new HoSo(getString(R.string.be_cung, "Leon")));
        hoSoList.add(new HoSo(getString(R.string.be_cung, "Loid")));
        hoSoList.add(new HoSo(getString(R.string.be_cung, "Lego")));

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
            Dialog dialog = new Dialog(ChonHosoActivity.this);
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
            Intent intent = new Intent(ChonHosoActivity.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChonHosoActivity.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChonHosoActivity.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChonHosoActivity.this, SpaActivity1.class);
           startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
             Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChonHosoActivity.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChonHosoActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChonHosoActivity.this, BlogActivity.class);
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