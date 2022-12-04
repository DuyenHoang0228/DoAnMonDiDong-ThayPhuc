package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import com.nhom4.lilpawhome_application.databinding.ActivityThuongHieuBinding;
import com.nhom4.models.ThuongHieu;
import com.nhom4.view.adapters.ThuonghieuAdapter;

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
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.custom_actionbar_thuonghieu);

        binding=ActivityThuongHieuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        loadData();
        addEvents();
    }

    private void addEvents() {
        binding.gvThuonghieu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ThuongHieu th= (ThuongHieu) adapter.getItem(i);
                Intent intent=new Intent(ThuongHieuActivity.this,SanPhamTheoThuongHieuActivity.class);
                intent.putExtra("tenthuonghieu",th.getTenThuongHieu().toString());
                startActivity(intent);


                //đẩy dữ liệu qua bên sản phẩm theo thương hiệu, string thuonghieu, qua bên kia lấy string đó rồi thiết lập điều kiện
            }
        });

    }

    private void loadData() {
    thuongHieuArrayList=new ArrayList<>();
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.eight_in1_brand,"eightin1"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.furminator,"furminator"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.ferplast,"ferplast"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.mon_ami,"mon_ami"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.monge,"monge"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.thuonghieukhac,"thuonghieukhac"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.catsrang,"Catstrang"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.kong,"kong"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.catbest,"catbest"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.ciao,"Ciao"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.nekko,"nekko"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.ag_science_brand,"agscience"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.pawise,"pawise"));
    thuongHieuArrayList.add(new ThuongHieu(R.drawable.genki_brand,"genki"));

    adapter=new ThuonghieuAdapter(ThuongHieuActivity.this,R.layout.thuonghieu_list,thuongHieuArrayList);
    binding.gvThuonghieu.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        if (item_id == R.id.item_timkiem2) {
            Toast.makeText(this, "Tìm kiếm", Toast.LENGTH_SHORT).show();
            Dialog dialog = new Dialog(ThuongHieuActivity.this);
            dialog.setContentView(R.layout.dialog_thanhtimkiem);
            dialog.show();
            ImageButton thoat;
            thoat = dialog.findViewById(R.id.btn_exittk);
            thoat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        } else if (item_id == R.id.item_shopchocho2) {
            Toast.makeText(this, "Shop cho chó", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThuongHieuActivity.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThuongHieuActivity.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThuongHieuActivity.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThuongHieuActivity.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThuongHieuActivity.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThuongHieuActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThuongHieuActivity.this, BlogActivity.class);
            startActivity(intent);
        }
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return true;
    }
}