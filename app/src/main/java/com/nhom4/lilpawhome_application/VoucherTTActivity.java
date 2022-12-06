package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.nhom4.view.adapters.AdapterVoucherTT;
import com.nhom4.lilpawhome_application.databinding.ActivityVoucherTtBinding;
import com.nhom4.models.VoucherTT;

import java.util.ArrayList;

public class VoucherTTActivity extends AppCompatActivity {

    ActivityVoucherTtBinding binding;
    AdapterVoucherTT adapterVC, adapterMH;
    public static ArrayList<VoucherTT> voucherTTVC, voucherTTMH;
    LinearLayoutManager VerticalLayoutVC, VerticalLayoutMH;
    RecyclerView.LayoutManager RecyclerViewLayoutManagerVC, RecyclerViewLayoutManagerMH;
    public static TextView chuthichvoucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_voucher_tt);
        binding = ActivityVoucherTtBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        loadDataMH();
        loadDataVC();
        rcvMuahang();
        rcvVanchuyen();
        addEvents();
        chuthichvoucher = findViewById(R.id.txt_chuthichvoucher);

        String chuthich = binding.txtChuthichvoucher.getText().toString();
        SpannableString s = new SpannableString(chuthich);
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#FFA0CA")), 23, chuthich.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.txtChuthichvoucher.setText(s);
    }

    private void addEvents() {
        binding.btnApmavoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double discountVC = null, minordervalueVC = null, vouchertoidaVC = null;
                Double discountMH = null, minordervalueMH = null, vouchertoidaMH = null;
                boolean apmavanchuyen = false, apmamuahang = false;
                for (int i = 0; i <= voucherTTVC.size() - 1; i++){
                    if (voucherTTVC.get(i).isSelected()){
                        discountVC = voucherTTVC.get(i).getDiscount();
                        minordervalueVC = voucherTTVC.get(i).getMinordervalue();
                        vouchertoidaVC = voucherTTVC.get(i).getVouchertoida();
                        apmavanchuyen = true;
                    }
                }
                for (int i = 0; i <= voucherTTMH.size() - 1; i++){
                    if (voucherTTMH.get(i).isSelected()){
                        discountMH = voucherTTMH.get(i).getDiscount();
                        minordervalueMH = voucherTTMH.get(i).getMinordervalue();
                        vouchertoidaMH = voucherTTMH.get(i).getVouchertoida();
                        apmamuahang = true;
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                if (apmavanchuyen){
                    bundle.putDouble("DiscountVC", discountVC);
                    bundle.putDouble("MinordervalueVC", minordervalueVC);
                    bundle.putDouble("VouchertoidaVC", vouchertoidaVC);
                    bundle.putBoolean("Apmavanchuyen", apmavanchuyen);
                }
                if (apmamuahang){
                    bundle.putDouble("DiscountMH", discountMH);
                    bundle.putDouble("MinordervalueMH", minordervalueMH);
                    bundle.putDouble("VouchertoidaMH", vouchertoidaMH);
                    bundle.putBoolean("Apmamuahang", apmamuahang);
                }
                intent.putExtras(bundle);
                intent.setAction("fromVoucher");
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        loadDataMH();
        loadDataVC();
        super.onPause();
    }

    private void rcvVanchuyen() {
        RecyclerViewLayoutManagerVC = new LinearLayoutManager(getApplicationContext());
        binding.rvVouchervanchuyen.setLayoutManager(RecyclerViewLayoutManagerVC);

        adapterVC = new AdapterVoucherTT(voucherTTVC);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayoutVC = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvVouchervanchuyen.setLayoutManager(VerticalLayoutVC);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(binding.rvVouchervanchuyen.getContext(),
                VerticalLayoutVC.getOrientation());
        binding.rvVouchervanchuyen.addItemDecoration(dividerItemDecoration1);
        dividerItemDecoration1.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider));

        binding.rvVouchervanchuyen.setAdapter(adapterVC);
        binding.rvVouchervanchuyen.setNestedScrollingEnabled(false);
    }

    private void rcvMuahang() {
        RecyclerViewLayoutManagerMH = new LinearLayoutManager(getApplicationContext());
        binding.rvVouchermuahang.setLayoutManager(RecyclerViewLayoutManagerMH);

        loadDataMH();

        adapterMH = new AdapterVoucherTT(voucherTTMH);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayoutMH = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvVouchermuahang.setLayoutManager(VerticalLayoutMH);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration2 = new DividerItemDecoration(binding.rvVouchermuahang.getContext(),
                VerticalLayoutMH.getOrientation());
        binding.rvVouchermuahang.addItemDecoration(dividerItemDecoration2);
        dividerItemDecoration2.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider));

        binding.rvVouchermuahang.setAdapter(adapterMH);
        binding.rvVouchermuahang.setNestedScrollingEnabled(false);
    }

    private void loadDataMH() {
        voucherTTMH = new ArrayList<>();
        voucherTTMH.add(new VoucherTT(R.drawable.voucher_giam_gia1, "Giảm giá 15% đơn từ 50K", "HSD: 19/12/2022", 0.15, 50, 20, false));
        voucherTTMH.add(new VoucherTT(R.drawable.voucher_giam_gia2, "Giảm giá 10% đơn từ 50K", "HSD: 16/12/2022", 0.10, 50, 15, false));
        voucherTTMH.add(new VoucherTT(R.drawable.voucher_giam_gia3, "Giảm giá 20% đơn từ 150K", "Sắp hết hạn: Còn 2 ngày", 0.2, 150, 40, false));
    }

    private void loadDataVC() {
        voucherTTVC = new ArrayList<>();
        voucherTTVC.add(new VoucherTT(R.drawable.voucher_van_chuyen2, "Tất cả các hình thức thanh toán", "Sắp hết hạn: Còn 2 ngày", 20, 50, 20, false));
        voucherTTVC.add(new VoucherTT(R.drawable.voucher_van_chuyen2, "Tất cả các hình thức thanh toán", "Sắp hết hạn: Còn 3 ngày", 20, 50, 20, false));
        voucherTTVC.add(new VoucherTT(R.drawable.voucher_van_chuyen1, "Tất cả các hình thức thanh toán", "HSD: 16/12/2022", 15, 50, 15, false));
    }
}