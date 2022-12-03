package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4.view.adapters.AdapterChonHoso;
import com.nhom4.lilpawhome_application.databinding.ActivityChonHosoBinding;
import com.nhom4.models.HoSo;

import java.util.ArrayList;

public class ChonHosoActivity extends AppCompatActivity {

    ActivityChonHosoBinding binding;
    AdapterChonHoso adapter;
    LinearLayoutManager VerticalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    ArrayList<HoSo> hoSoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chon_hoso);
        binding = ActivityChonHosoBinding.inflate(getLayoutInflater());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(binding.getRoot());

        loadData();
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvHosothucung.setLayoutManager(RecyclerViewLayoutManager);

        adapter = new AdapterChonHoso(hoSoList);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvHosothucung.setLayoutManager(VerticalLayout);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(binding.rvHosothucung.getContext(),
                VerticalLayout.getOrientation());
        binding.rvHosothucung.addItemDecoration(dividerItemDecoration1);
        dividerItemDecoration1.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider));

        binding.rvHosothucung.setAdapter(adapter);
        binding.rvHosothucung.setNestedScrollingEnabled(true);
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