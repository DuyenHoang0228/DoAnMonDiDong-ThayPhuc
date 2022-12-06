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

import com.nhom4.view.adapters.AdapterHinhAnhDanhGia;
import com.nhom4.lilpawhome_application.databinding.ActivityHinhAnhDanhGiaSanPhamBinding;
import com.nhom4.models.DanhGiaSanPhamM;

import java.util.ArrayList;

public class HinhAnhDanhGiaSanPham extends AppCompatActivity {

    ActivityHinhAnhDanhGiaSanPhamBinding binding;
    ArrayList<DanhGiaSanPhamM> dsDanhGiaSanPham;
    AdapterHinhAnhDanhGia adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_hinh_anh_danh_gia_san_pham);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = ActivityHinhAnhDanhGiaSanPhamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadData();
    }

    private void loadData() {
        dsDanhGiaSanPham = new ArrayList<>();
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"Kim Hạnh", 5, "Đóng gói sản phẩm cẩn thận, sản phẩm đẹp lắm, bé chó nhà mình thích mê", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "28/11/2022"));
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"Thảo Duyên", 4, "Mua lần đầu có hơi lo lắng, tới lúc nhận được sản phẩm bất ngờ quá chừng, tại nó cũng bình thường chứ không xuất sắc như mình đã nghĩ", R.drawable.spkhay,  R.drawable.splongmong, R.drawable.spkhaymeo, "20/11/2022"));
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"Ngọc Thẩm", 4, "Tại dư tiền thích mua sắm vậy thôi, chứ chó thì mình chưa nuôi",  R.drawable.spkhaymeo, R.drawable.spkhay, R.drawable.splongmong,"02/01/2022"));
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"Hồng Xuân", 5 ,"Đừng mua, mua về xài rồi không bỏ được đâu", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "28/07/2022"));
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"Bảo Thiện", 3, "Con chó nhà mình nó khen là hàng đẹp quá, kêu mình lần sau có khuyến mãi thì nhớ mua nhiều nhiều để dành nó xài từ từ", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "09/09/2022"));

        adapter = new AdapterHinhAnhDanhGia(HinhAnhDanhGiaSanPham.this, R.layout.hinhanhdanhgia_layout, dsDanhGiaSanPham);
        binding.grHinhanhdanhgia.setAdapter(adapter);
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
            Dialog dialog = new Dialog(HinhAnhDanhGiaSanPham.this);
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
            Intent intent = new Intent(HinhAnhDanhGiaSanPham.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HinhAnhDanhGiaSanPham.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HinhAnhDanhGiaSanPham.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HinhAnhDanhGiaSanPham.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HinhAnhDanhGiaSanPham.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HinhAnhDanhGiaSanPham.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HinhAnhDanhGiaSanPham.this, BlogActivity.class);
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