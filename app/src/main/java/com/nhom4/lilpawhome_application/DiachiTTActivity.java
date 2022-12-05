package com.nhom4.lilpawhome_application;

import static com.nhom4.lilpawhome_application.Utils_Diachi.DB_NAME;
import static com.nhom4.lilpawhome_application.Utils_Diachi.DB_PATH_SUFFIX;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4.models.DiaChi;
import com.nhom4.view.adapters.AdapterDiaChiTT;
import com.nhom4.lilpawhome_application.databinding.ActivityDiachiTtBinding;
import com.nhom4.models.DiaChi_tt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DiachiTTActivity extends AppCompatActivity {

    ActivityDiachiTtBinding binding;
    AdapterDiaChiTT adapter;
    LinearLayoutManager VerticalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    ArrayList<DiaChi_tt> diaChi_tts;
    public SQLiteDatabase db;
    int IDdiachi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_diachi_tt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = ActivityDiachiTtBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        addEvents();
    }

    private void addEvents() {
        binding.btnThemdiachimoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiachiTTActivity.this, themdiachi.class);
                startActivity(intent);
            }
        });
        binding.btnXacnhandiachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                int iddiachi = 0;
                for (int i = 0; i <= diaChi_tts.size()-1; i++){
                    if (diaChi_tts.get(i).isSelected()){
                        iddiachi = diaChi_tts.get(i).getIddiachi();
                    }
                }
                intent.putExtra("IDdiachi", iddiachi);
                intent.setAction("fromDiachi");
                setResult(Activity.RESULT_OK, intent);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);//quay lại màn hình thanh toán đã được tạo (không gọi onCreate bên màn hình thanh toán)
//                startActivityForResult(intent, 123);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        loadData();
        super.onResume();
    }

    private void loadData() {
        Intent intent = getIntent();
        IDdiachi = intent.getIntExtra("IDdiachi", 0);

        diaChi_tts = new ArrayList<>();
        db = openOrCreateDatabase(Utils_Diachi.DB_NAME, MODE_PRIVATE,null);
        Cursor c = db.query(Utils_Diachi.TBL_NAME, null,null,
                null,null,null,null);
        while (c.moveToNext()){
            String tinh = c.getString(3);
            String quan = c.getString(4);
            String phuong = c.getString(5);
            String duong = c.getString(6);
            String diachi = duong + ", " + phuong + ", " + quan + ", " + tinh;

            //Biện luận nếu địa chỉ là mặc định thì sẽ luôn được tick đầu tiên
            boolean isSelected = false;
            boolean macdinh = false;
            if (c.getInt(8) == 1){
                macdinh = true;
            }
            diaChi_tts.add(new DiaChi_tt(c.getInt(0), c.getString(1), c.getString(2), diachi, isSelected, macdinh));
        }
        c.close();

        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvDiachitt.setLayoutManager(RecyclerViewLayoutManager);

        adapter = new AdapterDiaChiTT(diaChi_tts);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvDiachitt.setLayoutManager(VerticalLayout);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(binding.rvDiachitt.getContext(),
                VerticalLayout.getOrientation());
        binding.rvDiachitt.addItemDecoration(dividerItemDecoration1);
        dividerItemDecoration1.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider_pink));

        binding.rvDiachitt.setAdapter(adapter);
        for (int i = 0; i <= diaChi_tts.size()-1; i++){
            if (diaChi_tts.get(i).getIddiachi() == IDdiachi){//Lấy địa chỉ từ màn hình thanh toán và set tick cho checkbox địa chỉ này
                diaChi_tts.get(i).setSelected(true);
                adapter.notifyDataSetChanged();
            }
        }
        binding.rvDiachitt.setNestedScrollingEnabled(false);
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
            Dialog dialog = new Dialog(DiachiTTActivity.this);
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
            Intent intent = new Intent(DiachiTTActivity.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DiachiTTActivity.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DiachiTTActivity.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DiachiTTActivity.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DiachiTTActivity.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DiachiTTActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DiachiTTActivity.this, BlogActivity.class);
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