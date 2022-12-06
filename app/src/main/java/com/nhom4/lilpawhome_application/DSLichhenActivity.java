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
import android.widget.AdapterView;
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
    public static ArrayList<LichHen>  lichhenHT;
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

        binding.rvLichsaptoi.setExpanded(true);
        adapterST = new AdapterLichHenST(DSLichhenActivity.this, R.layout.lichhen_saptoi_id, MainActivity.lichhenST);
        binding.rvLichsaptoi.setAdapter(adapterST);



        loadDataHT();
        binding.rvLichhoantat.setExpanded(true);
        adapterHT = new AdapterLichHenHT(DSLichhenActivity.this, R.layout.lichhen_hoantat_id, lichhenHT);
        binding.rvLichhoantat.setAdapter(adapterHT);
        addEvent();

    }

    private void addEvent() {
        binding.rvLichsaptoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DSLichhenActivity.this, LichhenDetailActivity.class);
                intent.putExtra("stt", i);
                startActivity(intent);
            }
        });
        binding.rvLichhoantat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DSLichhenActivity.this, LichhenDetailActivity.class);
                intent.putExtra("ht", i);
                startActivity(intent);
            }
        });
    }


    private void loadDataST() {

    }

    private void loadDataHT() {
        lichhenHT = new ArrayList<>();
        lichhenHT.add(new LichHen("Dịch vụ: Tắm, vệ sinh", "Thú cưng: Mèo", "Giống: Mướp", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "05/11/2022", "7:30"));
        lichhenHT.add(new LichHen("Dịch vụ: Cắt tỉa lông móng", "Thú cưng: Chó", "Giống: Husky", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "05/11/2022", "9:30"));
        lichhenHT.add(new LichHen("Dịch vụ: Tắm, vệ sinh", "Thú cưng: Chó", "Giống: Husky", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "05/11/2022", "15:30"));
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