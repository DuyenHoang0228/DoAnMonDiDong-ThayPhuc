package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nhom4.adapters.AdapterPhuongThucTT;
import com.nhom4.lilpawhome_application.databinding.ActivityPhuongthucttBinding;
import com.nhom4.models.PhuongThucTTChild;
import com.nhom4.models.PhuongThucTTMother;

import java.util.ArrayList;

public class PhuongthucTTActivity extends AppCompatActivity {

    ActivityPhuongthucttBinding binding;
    AdapterPhuongThucTT adapter;
    ArrayList<PhuongThucTTMother> mList;
    ArrayList<PhuongThucTTChild> cList1, cList2;
    LinearLayoutManager VerticalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_phuongthuctt);

        binding = ActivityPhuongthucttBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvThanhtoan.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rvThanhtoan.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mList = new ArrayList<>();
        cList1 = new ArrayList<>();
        cList2 = new ArrayList<>();

        //List 2
        cList2.add(new PhuongThucTTChild(R.drawable.icon_visa, "Visa (*2054)"));
        cList2.add(new PhuongThucTTChild(R.drawable.icon_mastercard, "Mastercard (*2055)"));
        mList.add(new PhuongThucTTMother(null, R.drawable.icon_atm, "Thẻ ATM nội địa", "(Internet Banking)", false));
        mList.add(new PhuongThucTTMother(cList2, R.drawable.icon_creditcards, "Thẻ tín dụng / Thẻ ngân hàng", "(Visa, Mastercard)", false));

        adapter = new AdapterPhuongThucTT(mList);
        binding.rvThanhtoan.setAdapter(adapter);
        binding.rvThanhtoan.setNestedScrollingEnabled(true);
    }
}