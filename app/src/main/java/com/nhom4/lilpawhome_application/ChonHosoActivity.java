package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.nhom4.adapters.AdapterChonHoso;
import com.nhom4.adapters.AdapterLichHenHT;
import com.nhom4.adapters.AdapterLichHenST;
import com.nhom4.lilpawhome_application.databinding.ActivityChonHosoBinding;
import com.nhom4.lilpawhome_application.databinding.ActivityDslichhenBinding;
import com.nhom4.models.HoSo;
import com.nhom4.models.LichHen;

import java.util.ArrayList;

public class ChonHosoActivity extends AppCompatActivity {

    ActivityChonHosoBinding binding;
    AdapterChonHoso adapter;
    LinearLayoutManager VerticalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    ArrayList<HoSo> hoSoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chon_hoso);
        binding = ActivityChonHosoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvHosothucung.setLayoutManager(RecyclerViewLayoutManager);

        adapter = new AdapterChonHoso(hoSoList);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvHosothucung.setLayoutManager(VerticalLayout);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(binding.rvHosothucung.getContext(),
                VerticalLayout.getOrientation());
        binding.rvHosothucung.addItemDecoration(dividerItemDecoration1);
        dividerItemDecoration1.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider));

        binding.rvHosothucung.setAdapter(adapter);
    }

    private void loadData() {
        hoSoList = new ArrayList<>();
        hoSoList.add(new HoSo(getString(R.string.be_cung, "Lily")));
        hoSoList.add(new HoSo("Bé cưng Love"));
        hoSoList.add(new HoSo(getString(R.string.be_cung, "Leo")));
        hoSoList.add(new HoSo(getString(R.string.be_cung, "Leon")));
        hoSoList.add(new HoSo(getString(R.string.be_cung, "Loid")));
        hoSoList.add(new HoSo(getString(R.string.be_cung, "Lego")));

    }
}