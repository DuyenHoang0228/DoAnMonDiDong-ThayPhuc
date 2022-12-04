package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4.view.adapters.AdapterBannerUudai;
import com.nhom4.view.adapters.HorSanPhamAdapter;
import com.nhom4.view.adapters.AdapterVoucherUudai;
import com.nhom4.models.SanPham;
import com.nhom4.models.VoucherUuDai;
import com.nhom4.view.ExpandableHeightGridView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class UuDaiMain extends AppCompatActivity {

    Context context = this;
    SliderView sliderView;
    RecyclerView recyclerView;
    int[] images = {R.drawable.banneruudai1, R.drawable.banneruudai2};
    ArrayList<VoucherUuDai> voucherNewUser, voucherMuaNhieu, voucherThuongHieu;
    ArrayList<SanPham> sanPhams;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    HorSanPhamAdapter adapter;
    LinearLayoutManager HorizontalLayout;
    AdapterVoucherUudai adapterVoucherNewUser, adapterVoucherMuaNhieu, adapterVoucherThuongHieu;
    ExpandableHeightGridView gridViewnewuser, gridViewmuanhieu, gridViewthuonghieu;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uu_dai_main);

        sliderView = findViewById(R.id.slider_banneruudai);
        AdapterBannerUudai adapterBannerUudai = new AdapterBannerUudai(images);
        sliderView.setSliderAdapter(adapterBannerUudai);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        //Không binding nên phải tìm id của gridview
        gridViewnewuser = findViewById(R.id.gv_vouchernguoidungmoi);
        gridViewmuanhieu = findViewById(R.id.gv_vouchermuanhieu);
        gridViewthuonghieu = findViewById(R.id.gv_voucherthuonghieu);
        //Set gridView về dạng đã mở rộng
        gridViewnewuser.setExpanded(true);
        gridViewmuanhieu.setExpanded(true);
        gridViewthuonghieu.setExpanded(true);

        loadData();

        recyclerView = (RecyclerView)findViewById(R.id.rv_flashsale);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());

        // Set LayoutManager on Recycler View
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);

        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList();

        // calling constructor of adapter with source list as a parameter
        adapter = new HorSanPhamAdapter(sanPhams);

        // Set Horizontal Layout Manager for Recycler view
        HorizontalLayout = new LinearLayoutManager(UuDaiMain.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(HorizontalLayout);

        // Set adapter on recycler view
        recyclerView.setAdapter(adapter);
    }

    private void AddItemsToRecyclerViewArrayList() {
        sanPhams = new ArrayList<>();
        sanPhams.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        sanPhams.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        sanPhams.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        sanPhams.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        sanPhams.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
    }

    private void loadData() {
        voucherNewUser = new ArrayList<>();
        voucherMuaNhieu = new ArrayList<>();
        voucherThuongHieu = new ArrayList<>();
        gridViewnewuser = findViewById(R.id.gv_vouchernguoidungmoi);
        gridViewmuanhieu = findViewById(R.id.gv_vouchermuanhieu);
        gridViewthuonghieu = findViewById(R.id.gv_voucherthuonghieu);
        voucherNewUser.add(new VoucherUuDai(R.drawable.lilpaw, null, "Giảm 20K", "Đơn hàng từ 100K"));
        voucherNewUser.add(new VoucherUuDai(R.drawable.lilpaw, null, "Giảm 50K", "Đơn hàng từ 200K"));
        adapterVoucherNewUser = new AdapterVoucherUudai(UuDaiMain.this, R.layout.voucher_uudai_id, voucherNewUser);
        gridViewnewuser.setAdapter(adapterVoucherNewUser);
        voucherMuaNhieu.add(new VoucherUuDai(R.drawable.lilpaw, null,"Giảm 100K", "Đơn hàng từ 799K"));
        voucherMuaNhieu.add(new VoucherUuDai(R.drawable.lilpaw, null,"Giảm 200K", "Đơn hàng từ 1499K"));
        voucherMuaNhieu.add(new VoucherUuDai(R.drawable.lilpaw, null,"Giảm 500K", "Đơn hàng từ 4299K"));
        voucherMuaNhieu.add(new VoucherUuDai(R.drawable.lilpaw, null,"Giảm 1000K", "Đơn hàng từ 5599K"));
        adapterVoucherMuaNhieu = new AdapterVoucherUudai(UuDaiMain.this, R.layout.voucher_uudai_id, voucherMuaNhieu);
        gridViewmuanhieu.setAdapter(adapterVoucherMuaNhieu);
        voucherThuongHieu.add(new VoucherUuDai(R.drawable.royalcanin, "Royal Canin","Giảm 20K", "Đơn hàng từ 150K"));
        voucherThuongHieu.add(new VoucherUuDai(R.drawable.catbest, "Cat's Best","Giảm 50K", "Đơn hàng từ 399K"));
        voucherThuongHieu.add(new VoucherUuDai(R.drawable.inaba, "INABA","Giảm 30K", "Đơn hàng từ 0Đ"));
        voucherThuongHieu.add(new VoucherUuDai(R.drawable.vegebrand, "VegeBrand","Giảm 30K", "Đơn hàng từ 499K"));
        voucherThuongHieu.add(new VoucherUuDai(R.drawable.inaba, "INABA","Giảm 30K", "Đơn hàng từ 0Đ"));
        voucherThuongHieu.add(new VoucherUuDai(R.drawable.petsoft, "Pet Soft","Giảm 150K", "Đơn hàng từ 599K"));
        adapterVoucherThuongHieu = new AdapterVoucherUudai(UuDaiMain.this, R.layout.voucher_thuonghieu_id, voucherThuongHieu);
        gridViewthuonghieu.setAdapter(adapterVoucherThuongHieu);
    }
    //gắn menu
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
            Dialog dialog = new Dialog(UuDaiMain.this);
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
            Intent intent = new Intent(UuDaiMain.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UuDaiMain.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Bạn đang ở trang Ưu đãi", Toast.LENGTH_SHORT).show();
           // Intent intent = new Intent(UuDaiMain.this, UuDaiMain.class);
           // startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UuDaiMain.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UuDaiMain.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UuDaiMain.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UuDaiMain.this, BlogActivity.class);
            startActivity(intent);
        }
        return true;
    }

}