package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.databinding.ActivityTaoHosoBinding;

import java.util.ArrayList;

public class TaoHosoActivity extends AppCompatActivity {

    ActivityTaoHosoBinding binding;
    String[] giongcho = {"Huskey", "Chihuahua", "Corgi", "Cỏ", "Bull Pháp", "Pitbull", "Xúc xích", "Shiba", "Alaska"};
    String[] giongmeo = {"Mướp", "Anh Lông Ngắn", "Anh Lông Dài", "Ba Tư", "Ai Cập (Sphynx)", "Munchkin chân ngắn", "Xiêm", "Ragdoll", "Tai cụp (Scottish)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tao_hoso);
        binding = ActivityTaoHosoBinding.inflate(getLayoutInflater());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(binding.getRoot());
        addEvent();
    }

    private void addEvent() {
        binding.txtLuuthaydoiHs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TaoHosoActivity.this, "Tạo hồ sơ thành công", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    public void rbtn_setimagedog(View view) {
        binding.rbtnCho.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ava_dog_stroke));
        binding.rbtnMeo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ava_cat));
        ArrayAdapter adapterGiongcho = new ArrayAdapter(this,android.R.layout.simple_list_item_1,giongcho);
        binding.autotxtGiongchomeo.setAdapter(adapterGiongcho);
        binding.autotxtGiongchomeo.setThreshold(1);
    }

    public void rbtn_setimagecat(View view) {
        binding.rbtnMeo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ava_cat_stroke));
        binding.rbtnCho.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ava_dog2));
        ArrayAdapter adapterGiongmeo = new ArrayAdapter(this,android.R.layout.simple_list_item_1,giongmeo);
        binding.autotxtGiongchomeo.setAdapter(adapterGiongmeo);
        binding.autotxtGiongchomeo.setThreshold(1);
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
            Dialog dialog = new Dialog(TaoHosoActivity.this);
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
            Intent intent = new Intent(TaoHosoActivity.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TaoHosoActivity.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TaoHosoActivity.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TaoHosoActivity.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TaoHosoActivity.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TaoHosoActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TaoHosoActivity.this, BlogActivity.class);
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