package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;

import com.nhom4.adapters.AdapterBannerUudai;
import com.nhom4.adapters.AdapterVoucherUudai;
import com.nhom4.lilpawhome_application.databinding.ActivityUuDaiMainBinding;
import com.nhom4.lilpawhome_application.databinding.SliderLayoutBanneruudaiBinding;
import com.nhom4.models.VoucherUuDai;
import com.nhom4.view.ExpandableHeightGridView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

public class UuDaiMain extends AppCompatActivity {

    Context context = this;
    SliderView sliderView;
    int[] images = {R.drawable.banneruudai1, R.drawable.banneruudai2};
    ArrayList<VoucherUuDai> voucherNewUser, voucherMuaNhieu, voucherThuongHieu;
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
        gridViewnewuser = findViewById(R.id.gv_vouchernguoidungmoi);
        gridViewmuanhieu = findViewById(R.id.gv_vouchermuanhieu);
        gridViewthuonghieu = findViewById(R.id.gv_voucherthuonghieu);
        gridViewnewuser.setExpanded(true);
        gridViewmuanhieu.setExpanded(true);
        gridViewthuonghieu.setExpanded(true);

        loadData();
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
}