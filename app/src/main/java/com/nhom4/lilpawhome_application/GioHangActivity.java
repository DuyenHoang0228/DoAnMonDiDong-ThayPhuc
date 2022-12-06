package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nhom4.view.adapters.AdapterGioHang;
import com.nhom4.lilpawhome_application.databinding.ActivityGioHangBinding;
import com.nhom4.models.GioHang;

import java.util.ArrayList;

public class GioHangActivity extends AppCompatActivity {

    ActivityGioHangBinding binding;
    AdapterGioHang adapter;
    ArrayList<GioHang> gioHangs;
    LinearLayoutManager VerticalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    public static TextView txttongthanhtoan;
    public static CheckBox cboxtatca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gio_hang);
        binding = ActivityGioHangBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvGiohang.setLayoutManager(RecyclerViewLayoutManager);

        adapter = new AdapterGioHang(MainActivity.manggiohang);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvGiohang.setLayoutManager(VerticalLayout);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(binding.rvGiohang.getContext(),
                VerticalLayout.getOrientation());
        binding.rvGiohang.addItemDecoration(dividerItemDecoration1);
        dividerItemDecoration1.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider));

        resetCheckbox();

        binding.rvGiohang.setAdapter(adapter);

        displaybackground();//Hiện giỏ hàng trống

        txttongthanhtoan = findViewById(R.id.txt_tongthanhtoan);

        cboxtatca = findViewById(R.id.cbox_tatca);
        binding.txtTongthanhtoan.setText("0đ");

        //Set sự kiện cho checkbox tất cả
        binding.cboxTatca.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//Khi ô chekcbox thay đổi trạng thái
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){//nếu nút checkbox true - đã tick
                    for (int i = 0; i <= MainActivity.manggiohang.size()-1; i++){
                        MainActivity.manggiohang.get(i).setSelected(true);
                        adapter.notifyDataSetChanged();
                    }
                }else{//nếu nút checkbox false - chưa tick
                    for (int i = 0; i <= MainActivity.manggiohang.size()-1; i++){
                        MainActivity.manggiohang.get(i).setSelected(false);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

        //Set sự kiện cho nút Mua hàng - chuyển qua màn hình thanh toán
        binding.btnMuahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.manggiohang.size() > 0){//Nếu trong giỏ hàng có sản phẩm
                    Intent intent = new Intent(GioHangActivity.this, ThanhtoanActivity.class);
                    startActivity(intent);
                }else{
                    Dialog dialog = new Dialog(GioHangActivity.this);
                    dialog.setCanceledOnTouchOutside(true);
                    dialog.setContentView(R.layout.dialog_canhbaogiohang);
                    //Xác nhận đã nhận cảnh báo
                    TextView xacnhan = dialog.findViewById(R.id.txt_xacnhancanhbao);
                    xacnhan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            }
        });
    }

    private void resetCheckbox() {
        for (int i = 0; i <= MainActivity.manggiohang.size()-1; i++){
            MainActivity.manggiohang.get(i).setSelected(false);
            adapter.notifyDataSetChanged();
        }
    }

    private void displaybackground() {
        binding.txtEmptycart.setVisibility(MainActivity.manggiohang.size() <= 0 ? View.VISIBLE : View.GONE);
        binding.imvEmptycart.setVisibility(MainActivity.manggiohang.size() <= 0 ? View.VISIBLE : View.GONE);
        binding.rvGiohang.setVisibility(MainActivity.manggiohang.size() > 0 ? View.VISIBLE : View.GONE);
    }

    //Thêm menu
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
            Dialog dialog = new Dialog(GioHangActivity.this);
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
            Intent intent = new Intent(GioHangActivity.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(GioHangActivity.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(GioHangActivity.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(GioHangActivity.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(GioHangActivity.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(GioHangActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(GioHangActivity.this, BlogActivity.class);
            startActivity(intent);
        }
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        binding.txtEmptycart.setVisibility(MainActivity.manggiohang.size() <= 0 ? View.VISIBLE : View.GONE);
        binding.imvEmptycart.setVisibility(MainActivity.manggiohang.size() <= 0 ? View.VISIBLE : View.GONE);
        binding.rvGiohang.setVisibility(MainActivity.manggiohang.size() > 0 ? View.VISIBLE : View.GONE);
        resetCheckbox();
        super.onResume();
    }

}