package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4.view.adapters.AdapterVoucher;
import com.nhom4.lilpawhome_application.databinding.ActivityKhoVoucherBinding;
import com.nhom4.models.Voucher;

import java.util.ArrayList;

public class KhoVoucher extends AppCompatActivity {

    ActivityKhoVoucherBinding binding;
    AdapterVoucher adapter;
    ArrayList<Voucher> vouchers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKhoVoucherBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_kho_voucher);
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addEvent();
        loadData();
    }

    private void loadData() {
        vouchers = new ArrayList<>();
        vouchers.add(new Voucher("Tất cả hình thức thanh toán", "28/02/2022", 15, "Miễn phí vận chuyển", false));
        vouchers.add(new Voucher("GIẢM 15% ĐƠN TỪ 100K", "28/11/2022", 100, "Giảm 15%", true));
        vouchers.add(new Voucher("GIẢM 5% ĐƠN TỪ 50K", "30/11/2022", 30, "Giảm 5%", true));
        vouchers.add(new Voucher("GIẢM 50K ĐƠN TỪ 99K", "20/12/2022", 50, "Giảm 50K", true));
        vouchers.add(new Voucher("GIẢM 15% ĐƠN TỪ 100K", "28/02/2022", 100, "Giảm 15%", true));
        vouchers.add(new Voucher("Tất cả hình thức thanh toán", "28/02/2022", 15, "Miễn phí vận chuyển", true));
        vouchers.add(new Voucher("GIẢM 5% ĐƠN TỪ 50K", "30/11/2022", 30, "Giảm 5%", false));
        adapter = new AdapterVoucher(KhoVoucher.this, R.layout.voucher_layout, vouchers);

        binding.lvKhovoucher.setAdapter(adapter);

    }

    private void addEvent() {
        binding.lvKhovoucher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(KhoVoucher.this, ChiTietVoucher.class);
                Voucher voucher = (Voucher) adapter.getItem(i);
                intent.putExtra("ChuTrongAnhVoucher", voucher.getChuTrongAnhVoucher());
                intent.putExtra("TitleOfVoucher", voucher.getTitleOfVoucher());
                intent.putExtra("HSDVoucher", voucher.getHsdVoucher());
                intent.putExtra("MaxOfValue", voucher.getMaxValue());
                intent.putExtra("isLimited", voucher.isLimited());
                startActivity(intent);
            }
        });
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
            Dialog dialog = new Dialog(KhoVoucher.this);
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
            Intent intent = new Intent(KhoVoucher.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(KhoVoucher.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(KhoVoucher.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(KhoVoucher.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(KhoVoucher.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(KhoVoucher.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(KhoVoucher.this, BlogActivity.class);
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

}