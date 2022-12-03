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

import com.nhom4.view.adapters.AdapterLichHenHT;
import com.nhom4.view.adapters.AdapterLichHenST;
import com.nhom4.lilpawhome_application.databinding.ActivityDslichhenBinding;
import com.nhom4.models.LichHen;

import java.util.ArrayList;

public class DSLichhenActivity extends AppCompatActivity {

    ActivityDslichhenBinding binding;
    AdapterLichHenST adapterST;
    AdapterLichHenHT adapterHT;
    ArrayList<LichHen> lichhenST, lichhenHT;
    LinearLayoutManager VerticalLayoutST, VerticalLayoutHT;
    RecyclerView.LayoutManager RecyclerViewLayoutManagerST, RecyclerViewLayoutManagerHT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //setContentView(R.layout.activity_dslichhen);

        binding = ActivityDslichhenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadDataST();

        RecyclerViewLayoutManagerST = new LinearLayoutManager(getApplicationContext());
        binding.rvLichsaptoi.setLayoutManager(RecyclerViewLayoutManagerST);

        adapterST = new AdapterLichHenST(lichhenST);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayoutST = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvLichsaptoi.setLayoutManager(VerticalLayoutST);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(binding.rvLichsaptoi.getContext(),
                VerticalLayoutST.getOrientation());
        binding.rvLichsaptoi.addItemDecoration(dividerItemDecoration1);
        dividerItemDecoration1.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider));

        binding.rvLichsaptoi.setAdapter(adapterST);

        RecyclerViewLayoutManagerHT = new LinearLayoutManager(getApplicationContext());
        binding.rvLichhoantat.setLayoutManager(RecyclerViewLayoutManagerHT);

        loadDataHT();
        adapterHT = new AdapterLichHenHT(lichhenHT);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayoutHT = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvLichhoantat.setLayoutManager(VerticalLayoutHT);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration2 = new DividerItemDecoration(binding.rvLichhoantat.getContext(),
                VerticalLayoutHT.getOrientation());
        binding.rvLichhoantat.addItemDecoration(dividerItemDecoration2);
        dividerItemDecoration2.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider));

        binding.rvLichhoantat.setAdapter(adapterHT);
    }

    private void loadDataST() {
        lichhenST = new ArrayList<>();
        lichhenST.add(new LichHen("Dịch vụ: Tắm rửa", "Thú cưng: Mèo", "Giống: Mướp", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "Thứ bảy", "05/11/2022", "7:30 - 8:30"));
        lichhenST.add(new LichHen("Dịch vụ: Tắm rửa", "Thú cưng: Chó", "Giống: Husky", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "Thứ bảy", "05/11/2022", "7:30 - 8:30"));
        lichhenST.add(new LichHen("Dịch vụ: Tắm rửa", "Thú cưng: Chó", "Giống: Husky", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "Chủ Nhật", "06/11/2022", "7:30 - 8:30"));
    }

    private void loadDataHT() {
        lichhenHT = new ArrayList<>();
        lichhenHT.add(new LichHen("Dịch vụ: Tắm rửa", "Thú cưng: Mèo", "Giống: Mướp", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "Thứ bảy", "05/11/2022", "7:30 - 8:30"));
        lichhenHT.add(new LichHen("Dịch vụ: Tắm rửa", "Thú cưng: Chó", "Giống: Husky", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "Thứ bảy", "05/11/2022", "7:30 - 8:30"));
        lichhenHT.add(new LichHen("Dịch vụ: Tắm rửa", "Thú cưng: Chó", "Giống: Husky", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "Thứ bảy", "05/11/2022", "7:30 - 8:30"));
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
            Dialog dialog = new Dialog(DSLichhenActivity.this);
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
            Intent intent = new Intent(DSLichhenActivity.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DSLichhenActivity.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DSLichhenActivity.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DSLichhenActivity.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DSLichhenActivity.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DSLichhenActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DSLichhenActivity.this, BlogActivity.class);
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