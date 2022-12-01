package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;

import com.nhom4.adapters.AdapterLichHenHT;
import com.nhom4.adapters.AdapterLichHenST;
import com.nhom4.adapters.AdapterVoucherTT;
import com.nhom4.lilpawhome_application.databinding.ActivityVoucherTtBinding;
import com.nhom4.models.LichHen;
import com.nhom4.models.VoucherTT;

import java.util.ArrayList;

public class VoucherTTActivity extends AppCompatActivity {

    ActivityVoucherTtBinding binding;
    AdapterVoucherTT adapterVC, adapterMH;
    ArrayList<VoucherTT> voucherTTVC, voucherTTMH;
    LinearLayoutManager VerticalLayoutVC, VerticalLayoutMH;
    RecyclerView.LayoutManager RecyclerViewLayoutManagerVC, RecyclerViewLayoutManagerMH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_voucher_tt);
        binding = ActivityVoucherTtBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadDataVC();

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

        String chuthich = binding.txtChuthichvoucher.getText().toString();
        SpannableString s = new SpannableString(chuthich);
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#FFA0CA")), 23, chuthich.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.txtChuthichvoucher.setText(s);
    }

    private void loadDataMH() {
        voucherTTMH = new ArrayList<>();
        voucherTTMH.add(new VoucherTT(R.drawable.voucher_giam_gia1, "Giảm giá 15% đơn từ 50K", "Tối đa 20K", "HSD: 10/12/2022", false));
        voucherTTMH.add(new VoucherTT(R.drawable.voucher_giam_gia1, "Giảm giá 15% đơn từ 50K", "Tối đa 20K", "HSD: 10/12/2022", false));
        voucherTTMH.add(new VoucherTT(R.drawable.voucher_giam_gia1, "Giảm giá 15% đơn từ 50K", "Tối đa 20K", "HSD: 10/12/2022", false));
    }

    private void loadDataVC() {
        voucherTTVC = new ArrayList<>();
        voucherTTVC.add(new VoucherTT(R.drawable.voucher_van_chuyen1, "Tất cả các hình thức thanh toán", "Tối đa 15K", "Sắp hết hạn: Còn 2 ngày", false));
        voucherTTVC.add(new VoucherTT(R.drawable.voucher_van_chuyen1, "Tất cả các hình thức thanh toán", "Tối đa 15K", "Sắp hết hạn: Còn 2 ngày", false));
        voucherTTVC.add(new VoucherTT(R.drawable.voucher_van_chuyen1, "Tất cả các hình thức thanh toán", "Tối đa 15K", "Sắp hết hạn: Còn 2 ngày", false));
    }
}