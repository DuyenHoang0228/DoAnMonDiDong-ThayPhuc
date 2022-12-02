package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nhom4.adapters.AdapterSanPhamTT;
import com.nhom4.adapters.HorAdapterPhuongThucTT;
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
    }
}