package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.nhom4.adapters.AdapterBannerUudai;
import com.nhom4.adapters.AdapterVoucherUudai;
import com.nhom4.lilpawhome_application.databinding.ActivityUuDaiMainBinding;
import com.nhom4.lilpawhome_application.databinding.SliderLayoutBanneruudaiBinding;
import com.nhom4.models.VoucherUuDai;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class UuDaiMain extends AppCompatActivity {

    SliderView sliderView;
    int[] images = {R.drawable.banneruudai1, R.drawable.banneruudai2};
    ArrayList<VoucherUuDai> voucherList;
    AdapterVoucherUudai adapterVoucherUudai;
    GridView gridViewnewuser;

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
        loadData();
    }

    private void loadData() {
        voucherList = new ArrayList<>();
        gridViewnewuser = findViewById(R.id.gv_vouchernguoidungmoi);
        voucherList.add(new VoucherUuDai("Giảm 15K", "Đơn hàng từ 100K"));
        voucherList.add(new VoucherUuDai("Giảm 35K", "Đơn hàng từ 200K"));
        voucherList.add(new VoucherUuDai("Giảm 55K", "Đơn hàng từ 300K"));
        voucherList.add(new VoucherUuDai( "Giảm 155K", "Đơn hàng từ 500K"));
        voucherList.add(new VoucherUuDai( "Giảm 205K", "Đơn hàng từ 700K"));
        adapterVoucherUudai = new AdapterVoucherUudai(UuDaiMain.this, R.layout.voucher_uudai_id, voucherList);
        gridViewnewuser.setAdapter(adapterVoucherUudai);

    }
}