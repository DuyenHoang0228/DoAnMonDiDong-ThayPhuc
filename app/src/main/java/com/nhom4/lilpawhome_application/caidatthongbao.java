package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class caidatthongbao extends AppCompatActivity {
Button thongbao, thongbaoemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_caidatthongbao);
        thongbao=findViewById(R.id.btn_thongbaocd);
        thongbaoemail=findViewById(R.id.btn_thongbaoemailcd);
        addEvents();
    }

    private void addEvents() {
        thongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(caidatthongbao.this, thongbao.class);
                startActivity(intent);
            }
        });
        thongbaoemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(caidatthongbao.this, thongbaoemail.class);
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
            Dialog dialog = new Dialog(caidatthongbao.this);
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
            Intent intent = new Intent(caidatthongbao.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(caidatthongbao.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(caidatthongbao.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(caidatthongbao.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(caidatthongbao.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(caidatthongbao.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(caidatthongbao.this, BlogActivity.class);
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