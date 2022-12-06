package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.databinding.ActivityDanhGiaCuaToiBinding;
import com.nhom4.models.DanhGiaSanPhamM;
import com.nhom4.models.DonHang;
import com.nhom4.view.ExpandableHeightGridView;
import com.nhom4.view.adapters.AdapterDSDonmua;
import com.nhom4.view.adapters.AdapterDanhGiaSanPham;
import com.nhom4.view.adapters.AdapterSanPhamDaDanhGia;
import com.nhom4.view.adapters.ChuaDanhGiaAdapter;
import com.nhom4.view.adapters.ChuaDanhGiaAdapter2;

import java.util.ArrayList;
import java.util.List;

public class DanhGiaCuaToi extends AppCompatActivity {

    ActivityDanhGiaCuaToiBinding binding;
    TabHost tabHost;
    ArrayList<DanhGiaSanPhamM> dsDanhGiaSanPham;
    AdapterSanPhamDaDanhGia adapter;
    ArrayList<DonHang> donHangs;
    ChuaDanhGiaAdapter adapter2;
    ChuaDanhGiaAdapter2 adapter3;
    String[] madonhang = {"DH00001", "DH00002", "DH00003"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_danh_gia_cua_toi);

        binding = ActivityDanhGiaCuaToiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        creatTabHost();
        loadData();
        addEvent();
    }

    private void loadData() {
        //đã đánh giá
        dsDanhGiaSanPham = new ArrayList<>();
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"littlemermaid@user", 5, "Đóng gói sản phẩm cẩn thận, sản phẩm đẹp lắm, bé chó nhà mình thích mê", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "28/11/2022"));
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"littlemermaid@user", 4, "Mua lần đầu có hơi lo lắng, tới lúc nhận được sản phẩm bất ngờ quá chừng, tại nó cũng bình thường chứ không xuất sắc như mình đã nghĩ", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "20/11/2022"));
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"littlemermaid@user", 4, "Tại dư tiền thích mua sắm vậy thôi, chứ chó thì mình chưa nuôi", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "02/01/2022"));
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"littlemermaid@user", 5 ,"Đừng mua, mua về xài rồi không bỏ được đâu", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "28/07/2022"));
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"littlemermaid@user", 3, "Con chó nhà mình nó khen là hàng đẹp quá, kêu mình lần sau có khuyến mãi thì nhớ mua nhiều nhiều để dành nó xài từ từ", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "09/09/2022"));

        adapter = new AdapterSanPhamDaDanhGia(DanhGiaCuaToi.this, R.layout.dadanhgia_layout, dsDanhGiaSanPham);
        ExpandableHeightGridView grDadanhgia = findViewById(R.id.gv_dadanhgia);
        grDadanhgia.setExpanded(true);
        grDadanhgia.setAdapter(adapter);

        //sản phẩm trong đơn
        donHangs = new ArrayList<>();
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "3", "190000"));
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "3", "190000"));
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "3", "190000"));
        //adapter2 = new ChuaDanhGiaAdapter(DanhGiaCuaToi.this, R.layout.sanphamtrongdondamua_layout, donHangs);
        //ExpandableHeightGridView grSanPhamTrongDonHang = findViewById(R.id.gr_sanphamtrongdondamua);
        //grSanPhamTrongDonHang.setAdapter(adapter2);
        //chưa đánh giá
        adapter3 = new ChuaDanhGiaAdapter2(DanhGiaCuaToi.this, R.layout.chuadanhgia_layout, madonhang, donHangs);
        ExpandableHeightGridView grChuaDanhGia = findViewById(R.id.gv_chuadanhgia);
        grChuaDanhGia.setExpanded(true);
        grChuaDanhGia.setAdapter(adapter3);

    }

    private void addEvent() {

    }

    private void creatTabHost() {
        tabHost = binding.thDanhgiacuatoi;
        tabHost.setup();
        //Tạo tab 1
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setContent(R.id.tab_chuadanhgia);
        tab1.setIndicator("Chưa đánh giá");
        tabHost.addTab(tab1);

        //Tạo tab 2
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setContent(R.id.tab_dadanhgia);
        tab2.setIndicator("Đã đánh giá");
        tabHost.addTab(tab2);
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
            Dialog dialog = new Dialog(DanhGiaCuaToi.this);
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
            Intent intent = new Intent(DanhGiaCuaToi.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DanhGiaCuaToi.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DanhGiaCuaToi.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DanhGiaCuaToi.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DanhGiaCuaToi.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DanhGiaCuaToi.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DanhGiaCuaToi.this, BlogActivity.class);
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