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

import com.nhom4.view.adapters.AdapterDiaChiTT;
import com.nhom4.lilpawhome_application.databinding.ActivityDiachiTtBinding;
import com.nhom4.models.DiaChi_tt;

import java.util.ArrayList;

public class DiachiTTActivity extends AppCompatActivity {

    ActivityDiachiTtBinding binding;
    AdapterDiaChiTT adapter;
    LinearLayoutManager VerticalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    ArrayList<DiaChi_tt> diaChi_tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_diachi_tt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = ActivityDiachiTtBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
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
        binding.rvDiachitt.setNestedScrollingEnabled(true);
    }

    private void loadData() {
        diaChi_tts = new ArrayList<>();
        diaChi_tts.add(new DiaChi_tt("Thảo Duyên", "(+84) 12345678", "Số 106, khu phố 3, Linh Xuân, Thủ Đức, TP.HCM "));
        diaChi_tts.add(new DiaChi_tt("Thảo Duyên", "(+84) 12345678", "Số 106, khu phố 3, Linh Xuân, Thủ Đức, TP.HCM "));
        diaChi_tts.add(new DiaChi_tt("Thảo Duyên", "(+84) 12345678", "Số 106, khu phố 3, Linh Xuân, Thủ Đức, TP.HCM "));
        diaChi_tts.add(new DiaChi_tt("Thảo Duyên", "(+84) 12345678", "Số 106, khu phố 3, Linh Xuân, Thủ Đức, TP.HCM "));

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