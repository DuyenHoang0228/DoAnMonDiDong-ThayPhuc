package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nhom4.adapters.AdapterLichHenHT;
import com.nhom4.adapters.AdapterLichHenST;
import com.nhom4.lilpawhome_application.databinding.ActivityDslichhenBinding;
import com.nhom4.models.LichHen;

import java.util.ArrayList;

public class DSLichhenActivity extends AppCompatActivity {

    ActivityDslichhenBinding binding;
    AdapterLichHenST adapterST;
    AdapterLichHenHT adapterHT;
    ArrayList<LichHen> lichhenST, lichhenHT;
    LinearLayoutManager VerticalLayoutST, VerticalLayoutHT;
    RecyclerView.LayoutManager RecyclerViewLayoutManagerST, RecyclerViewLayoutManagerHT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dslichhen);

        binding = ActivityDslichhenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadDataST();

        RecyclerViewLayoutManagerST = new LinearLayoutManager(getApplicationContext());
        binding.rvLichsaptoi.setLayoutManager(RecyclerViewLayoutManagerST);

        adapterST = new AdapterLichHenST(lichhenST);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayoutST = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvLichsaptoi.setLayoutManager(VerticalLayoutST);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(binding.rvLichsaptoi.getContext(),
                VerticalLayoutST.getOrientation());
        binding.rvLichsaptoi.addItemDecoration(dividerItemDecoration1);
        dividerItemDecoration1.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider));

        binding.rvLichsaptoi.setAdapter(adapterST);

        RecyclerViewLayoutManagerHT = new LinearLayoutManager(getApplicationContext());
        binding.rvLichhoantat.setLayoutManager(RecyclerViewLayoutManagerHT);

        loadDataHT();
        adapterHT = new AdapterLichHenHT(lichhenHT);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayoutHT = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvLichhoantat.setLayoutManager(VerticalLayoutHT);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration2 = new DividerItemDecoration(binding.rvLichhoantat.getContext(),
                VerticalLayoutHT.getOrientation());
        binding.rvLichhoantat.addItemDecoration(dividerItemDecoration2);
        dividerItemDecoration2.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider));

        binding.rvLichhoantat.setAdapter(adapterHT);
    }

    private void loadDataST() {
        lichhenST = new ArrayList<>();
        lichhenST.add(new LichHen("Dịch vụ: Tắm rửa", "Thú cưng: Mèo", "Giống: Mướp", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "Thứ bảy", "05/11/2022", "7:30 - 8:30"));
        lichhenST.add(new LichHen("Dịch vụ: Tắm rửa", "Thú cưng: Chó", "Giống: Husky", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "Thứ bảy", "05/11/2022", "7:30 - 8:30"));
        lichhenST.add(new LichHen("Dịch vụ: Tắm rửa", "Thú cưng: Chó", "Giống: Husky", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "Chủ Nhật", "06/11/2022", "7:30 - 8:30"));
    }

    private void loadDataHT() {
        lichhenHT = new ArrayList<>();
        lichhenHT.add(new LichHen("Dịch vụ: Tắm rửa", "Thú cưng: Mèo", "Giống: Mướp", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "Thứ bảy", "05/11/2022", "7:30 - 8:30"));
        lichhenHT.add(new LichHen("Dịch vụ: Tắm rửa", "Thú cưng: Chó", "Giống: Husky", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "Thứ bảy", "05/11/2022", "7:30 - 8:30"));
        lichhenHT.add(new LichHen("Dịch vụ: Tắm rửa", "Thú cưng: Chó", "Giống: Husky", "CS1: Nguyễn Đình Chiểu, Đa Kao, Quận 1.",
                "Thứ bảy", "05/11/2022", "7:30 - 8:30"));
    }
}