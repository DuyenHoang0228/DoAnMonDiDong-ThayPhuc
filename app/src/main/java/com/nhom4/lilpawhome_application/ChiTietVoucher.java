package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4.view.adapters.AdapterVoucher;
import com.nhom4.lilpawhome_application.databinding.ActivityChiTietVoucherBinding;

import java.util.Locale;

public class ChiTietVoucher extends AppCompatActivity {

    ActivityChiTietVoucherBinding binding;
    AdapterVoucher adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChiTietVoucherBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_chi_tiet_voucher);
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadData();
        addEvent();
    }

    private void loadData() {
        //hinh voucher
        Intent intent = getIntent();
        String chuTrongAnhVoucher = intent.getStringExtra("ChuTrongAnhVoucher");
        String titleOfVoucher = intent.getStringExtra("TitleOfVoucher");
        String HSD = intent.getStringExtra("HSDVoucher");
        int maxValue = intent.getIntExtra("MaxOfValue", 0);
        boolean isLimited = intent.getBooleanExtra("isLimited", true);

        binding.txtChutronganhvoucher.setText(chuTrongAnhVoucher);
        binding.txtTenvoucher.setText(titleOfVoucher);
        binding.txtHsdvoucher.setText(HSD);
        binding.txtVouchertoida.setText(String.valueOf(maxValue));
        if(isLimited){
            binding.txtSoluongcohan.setText("Số lượng có hạn");
        }else{
            binding.txtSoluongcohan.setVisibility(View.INVISIBLE);
        }
        //noi dung ben duoi voucher
        binding.txtNoidunguudai.setText(chuTrongAnhVoucher + " | " + titleOfVoucher);
        String[] hsd = HSD.split("/");
        int ngay = Integer.parseInt(hsd[0]) - 5;
        binding.txtNoidunghieuluc.setText(ngay + "/" + hsd[1] + "/" + hsd[2] + " - " + HSD);
        binding.txtNoidungphuongthucthanhtoan.setText("Mọi phương thức thanh toán");
        binding.txtDieukiensudungvoucher.setText("Sử dụng mã " + titleOfVoucher.toLowerCase(Locale.ROOT) + " cho đơn hàng bất kì thỏa mãn điều kiện ưu đãi của Lilpaw Home\n \n" + "Giảm tối đa " + maxValue +"K trên giá trị tổng của đơn hàng\n \n" + "Chỉ áp dụng cho khách hàng nhận được thông báo ưu đãi\n" +
                "\n" +
                "Số lượt sử dụng có hạn, chương trình và mã có thể kết thúc khi hết lượt ưu đãi hoặc khi hết hạn ưu đãi, tùy điều kiện nào đến trước");
    }

    private void addEvent() {
        binding.btnDungngayvoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChiTietVoucher.this, DungNgayVoucher.class);

                intent.putExtra("ChuTrongAnhVoucher", binding.txtChutronganhvoucher.getText());
                intent.putExtra("TitleOfVoucher", binding.txtTenvoucher.getText());
                intent.putExtra("HSDVoucher", binding.txtHsdvoucher.getText());
                intent.putExtra("MaxOfValue", Integer.parseInt(binding.txtVouchertoida.getText().toString()));
                intent.putExtra("isLimited", binding.txtSoluongcohan.getText());
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
            Dialog dialog = new Dialog(ChiTietVoucher.this);
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
            Intent intent = new Intent(ChiTietVoucher.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChiTietVoucher.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChiTietVoucher.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChiTietVoucher.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChiTietVoucher.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChiTietVoucher.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ChiTietVoucher.this, BlogActivity.class);
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