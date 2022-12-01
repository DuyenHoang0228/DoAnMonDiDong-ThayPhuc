package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nhom4.adapters.AdapterDiaChiTT;
import com.nhom4.lilpawhome_application.databinding.ActivityDiachiTtBinding;
import com.nhom4.models.DiaChi_tt;

import java.util.ArrayList;

public class DiachiTTActivity extends AppCompatActivity {

    ActivityDiachiTtBinding binding;
    AdapterDiaChiTT adapter;
    LinearLayoutManager VerticalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    ArrayList<DiaChi_tt> diaChi_tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_diachi_tt);

        binding = ActivityDiachiTtBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvDiachitt.setLayoutManager(RecyclerViewLayoutManager);

        adapter = new AdapterDiaChiTT(diaChi_tts);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvDiachitt.setLayoutManager(VerticalLayout);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(binding.rvDiachitt.getContext(),
                VerticalLayout.getOrientation());
        binding.rvDiachitt.addItemDecoration(dividerItemDecoration1);
        dividerItemDecoration1.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider_pink));

        binding.rvDiachitt.setAdapter(adapter);
        binding.rvDiachitt.setNestedScrollingEnabled(true);
    }

    private void loadData() {
        diaChi_tts = new ArrayList<>();
        diaChi_tts.add(new DiaChi_tt("Thảo Duyên", "(+84) 12345678", "Số 106, khu phố 3, Linh Xuân, Thủ Đức, TP.HCM "));
        diaChi_tts.add(new DiaChi_tt("Thảo Duyên", "(+84) 12345678", "Số 106, khu phố 3, Linh Xuân, Thủ Đức, TP.HCM "));
        diaChi_tts.add(new DiaChi_tt("Thảo Duyên", "(+84) 12345678", "Số 106, khu phố 3, Linh Xuân, Thủ Đức, TP.HCM "));
        diaChi_tts.add(new DiaChi_tt("Thảo Duyên", "(+84) 12345678", "Số 106, khu phố 3, Linh Xuân, Thủ Đức, TP.HCM "));
    }
}