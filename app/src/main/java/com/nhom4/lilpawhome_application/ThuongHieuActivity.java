package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;

import com.nhom4.adapters.ThuonghieuAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityThuongHieuBinding;
import com.nhom4.models.ThuongHieu;

import java.util.ArrayList;

public class ThuongHieuActivity extends AppCompatActivity {
    ActivityThuongHieuBinding binding;
    ThuonghieuAdapter adapter;
    ArrayList<ThuongHieu> thuongHieuArrayList;
    ImageView imvTimKiem;
    EditText edtTimKiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_thuong_hieu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_thuonghieu);

        binding=ActivityThuongHieuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        imvTimKiem=findViewById(R.id.imv_timkiem);
        edtTimKiem=findViewById(R.id.edt_timkiem);

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

    thuongHieuArrayList.add(new ThuongHieu(R.drawable.furminator,"furminator"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.ferplast,"ferplast"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.mon_ami,"mon_ami"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.monge,"monge"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.thuonghieukhac,"thuonghieukhac"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.catsrang,"catstrang"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.kong,"kong"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.catbest,"catsbest"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.ciao,"ciao"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.nekko,"nekko"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.ag_science_brand,"AG SCIENCE BRAND"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.pawise,"pawise"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.genki_brand,"Genky Brand"));
    adapter=new ThuonghieuAdapter(ThuongHieuActivity.this,R.layout.thuonghieu_list,thuongHieuArrayList);
    binding.gvThuonghieu.setAdapter(adapter);

    }
}