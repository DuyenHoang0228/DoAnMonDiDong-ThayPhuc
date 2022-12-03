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

import com.nhom4.view.adapters.AdapterSanPhamTT;
import com.nhom4.view.adapters.HorAdapterPhuongThucTT;
import com.nhom4.lilpawhome_application.databinding.ActivityThanhtoanBinding;
import com.nhom4.models.GioHang;
import com.nhom4.models.PhuongThucTT;

import java.util.ArrayList;

public class ThanhtoanActivity extends AppCompatActivity {

    ActivityThanhtoanBinding binding;
    AdapterSanPhamTT adapterSP;
    HorAdapterPhuongThucTT adapterPT;
    ArrayList<GioHang> gioHangs;
    ArrayList<PhuongThucTT> phuongThucTTS;
    LinearLayoutManager VerticalLayout, HorizontalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManagerSP, RecyclerViewLayoutManagerPT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_thanhtoan);
        binding = ActivityThanhtoanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        loadDSSanpham();

        RecyclerViewLayoutManagerSP = new LinearLayoutManager(getApplicationContext());
        binding.rvDssanpham.setLayoutManager(RecyclerViewLayoutManagerSP);

        adapterSP = new AdapterSanPhamTT(gioHangs);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvDssanpham.setLayoutManager(VerticalLayout);

        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(binding.rvDssanpham.getContext(),
                VerticalLayout.getOrientation());
        binding.rvDssanpham.addItemDecoration(dividerItemDecoration1);
        dividerItemDecoration1.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider_gray));

        binding.rvDssanpham.setAdapter(adapterSP);

        //============Adapter Phương thức thanh toán====================
        loadPTThanhtoan();
        RecyclerViewLayoutManagerPT = new LinearLayoutManager(getApplicationContext());
        binding.rvPhuongthucthanhtoan.setLayoutManager(RecyclerViewLayoutManagerPT);

        adapterPT = new HorAdapterPhuongThucTT(phuongThucTTS);

        // Thiết lập phương hướng của RecyclerView (ngang)
        HorizontalLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.rvPhuongthucthanhtoan.setLayoutManager(HorizontalLayout);
        binding.rvPhuongthucthanhtoan.setAdapter(adapterPT);
    }

    private void loadPTThanhtoan() {
        phuongThucTTS = new ArrayList<>();
        phuongThucTTS.add(new PhuongThucTT(R.drawable.icon_cod, "Thanh toán khi nhận hàng", "Thanh toán COD", false));
        phuongThucTTS.add(new PhuongThucTT(R.drawable.icon_atm, "Thẻ ATM nội địa", getString(R.string.internetbanking, "VCB *9705"), false));
        phuongThucTTS.add(new PhuongThucTT(R.drawable.icon_creditcards, "Thẻ tín dụng / Thẻ ghi nợ", getString(R.string.visa_mastercard, "*2055"), false));
        phuongThucTTS.add(new PhuongThucTT(R.drawable.icon_vnpay, "Thanh toán bằng ví VNPAY", "Liên kết ví VNPAY", false));
    }

    private void loadDSSanpham() {
        gioHangs = new ArrayList<>();
        gioHangs.add(new GioHang(R.drawable.giohang_sp2, 1, getString(R.string.brand_sp, "Smartheart"),
                "[COMBO 5 GÓI] Thức Ăn Cho Chó Trưởng Thành Smartheart 400g", "SHOP CHO CHÓ", 100000.0, 190000.0));
        gioHangs.add(new GioHang(R.drawable.giohang_sp3, 1, getString(R.string.brand_sp, "Me-o"),
                "[CAO CẤP] Hạt Cho Mèo Me-O Gold Indoor 1.2kg – Giảm Mùi Chất Thải", "SHOP CHO MÈO", 133000.0, 169000.0));
        gioHangs.add(new GioHang(R.drawable.giohang_sp4, 1, getString(R.string.brand_sp, "Bioline"),
                "Bộ Trồng Cỏ Mèo Tươi Bioline 12g – Bổ Sung Chất Xơ, Giảm Stress", "SHOP CHO MÈO", 50000.0, 109000.0));
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
            Dialog dialog = new Dialog(ThanhtoanActivity.this);
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
            Intent intent = new Intent(ThanhtoanActivity.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThanhtoanActivity.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThanhtoanActivity.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThanhtoanActivity.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThanhtoanActivity.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThanhtoanActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThanhtoanActivity.this, BlogActivity.class);
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