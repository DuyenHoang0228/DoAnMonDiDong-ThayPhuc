package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.nhom4.adapters.ThuonghieuAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityThuongHieuBinding;
import com.nhom4.models.ThuongHieu;

import java.util.ArrayList;

public class ThuongHieuActivity extends AppCompatActivity {
    ActivityThuongHieuBinding binding;
    ThuonghieuAdapter adapter;
    ArrayList<ThuongHieu> thuongHieuArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_thuong_hieu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_thuonghieu);

        binding=ActivityThuongHieuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
    }

    private void addEvents() {
        binding.gvThuonghieu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent();
                //đẩy dữ liệu qua bên sản phẩm theo thương hiệu, string thuonghieu, qua bên kia lấy string đó rồi thiết lập điều kiện
            }
        });
    }

    private void loadData() {
    thuongHieuArrayList=new ArrayList<>();
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.eight_in1_brand,"8 in 1"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.a_pro_iq_formula_brand,"A Pro IQ Formula"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.ag_science_brand,"AG SCIENCE BRAND"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.alkin_tbrandjpg,"Alkin TBrand"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.genki_brand,"Genky Brand"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.maneki_neko_brand,"Maneki Neko Brand"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.o3vit_brand,"O3VIT Brand"));

    adapter=new ThuonghieuAdapter(ThuongHieuActivity.this,R.layout.thuonghieu_list,thuongHieuArrayList);
    binding.gvThuonghieu.setAdapter(adapter);

    }
}