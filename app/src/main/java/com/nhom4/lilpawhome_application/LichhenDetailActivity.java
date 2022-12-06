package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.databinding.ActivityLichhenDetailBinding;
import com.nhom4.models.LichHen;
import com.nhom4.models.ThuCung;

import java.util.ArrayList;

public class LichhenDetailActivity extends AppCompatActivity {

    ActivityLichhenDetailBinding binding;
    ArrayList<ThuCung> thuCungs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lichhen_detail);
        binding = ActivityLichhenDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        int stt = intent.getIntExtra("stt",0);
        LichHen l = MainActivity.lichhenST.get(stt);
        binding.txtDichvudatlich.setText(l.getDichvu());
        binding.txtCosodatlich.setText(l.getCoso());
        binding.txtNgaygiolichhen.setText(l.getDate()+  " | " + l.getGio());
        binding.txtTennguoidatlich.setText("Hoàng Ngọc Thảo Duyên");
        binding.txtSdtnguoidatlich.setText("+84 12345678");
        binding.txtThucungdatlich.setText(l.getThucung());
        binding.txtGiongthucungdatlich.setText(l.getGiong());
        binding.txtGioitinhthucungdatlich.setText("...");
        binding.txtCannangthucungdatlich.setText("...");

        Intent intent1 = getIntent();
        int ht = intent1.getIntExtra("ht", 0);
        LichHen ll = DSLichhenActivity.lichhenHT.get(ht);
        binding.txtDichvudatlich.setText(ll.getDichvu());
        binding.txtCosodatlich.setText(ll.getCoso());
        binding.txtNgaygiolichhen.setText(ll.getDate()+  " | " + ll.getGio());
        binding.txtTennguoidatlich.setText("Hoàng Ngọc Thảo Duyên");
        binding.txtSdtnguoidatlich.setText("+84 12345678");
        binding.txtThucungdatlich.setText(ll.getThucung());
        binding.txtGiongthucungdatlich.setText(ll.getGiong());
        binding.txtGioitinhthucungdatlich.setText("...");
        binding.txtCannangthucungdatlich.setText("...");
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
            Dialog dialog = new Dialog(LichhenDetailActivity.this);
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
            Intent intent = new Intent(LichhenDetailActivity.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LichhenDetailActivity.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LichhenDetailActivity.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LichhenDetailActivity.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LichhenDetailActivity.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LichhenDetailActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LichhenDetailActivity.this, BlogActivity.class);
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