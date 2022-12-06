package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.nhom4.models.PhuongThucTT;
import com.nhom4.view.adapters.AdapterPhuongThucTT;
import com.nhom4.lilpawhome_application.databinding.ActivityPhuongthucttBinding;
import com.nhom4.models.PhuongThucTTChild;
import com.nhom4.models.PhuongThucTTMother;

import java.util.ArrayList;

public class PhuongthucTTActivity extends AppCompatActivity {

    ActivityPhuongthucttBinding binding;
    AdapterPhuongThucTT adapter;
    ArrayList<PhuongThucTTMother> mList;
    public static ArrayList<PhuongThucTTChild> cList1, cList2;
    LinearLayoutManager VerticalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_phuongthuctt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = ActivityPhuongthucttBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvThanhtoan.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rvThanhtoan.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mList = new ArrayList<>();
        cList1 = new ArrayList<>();
        cList2 = new ArrayList<>();

        cList1.add(new PhuongThucTTChild(R.drawable.logo_vcb, "Vietcombank (*9705)"));

        //List 2
        cList2.add(new PhuongThucTTChild(R.drawable.icon_visa, "Visa (*2054)"));
        cList2.add(new PhuongThucTTChild(R.drawable.icon_mastercard, "Mastercard (*2055)"));
        mList.add(new PhuongThucTTMother(cList1, R.drawable.icon_atm, "Thẻ ATM nội địa", "(Internet Banking)", false));
        mList.add(new PhuongThucTTMother(cList2, R.drawable.icon_creditcards, "Thẻ tín dụng / Thẻ ngân hàng", "(Visa, Mastercard)", false));

        adapter = new AdapterPhuongThucTT(mList);
        binding.rvThanhtoan.setAdapter(adapter);
        binding.rvThanhtoan.setNestedScrollingEnabled(true);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {case android.R.id.home: onBackPressed();
            return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}