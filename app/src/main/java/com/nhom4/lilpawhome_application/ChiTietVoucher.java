package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.nhom4.adapters.AdapterVoucher;
import com.nhom4.lilpawhome_application.databinding.ActivityChiTietVoucherBinding;
import com.nhom4.models.Voucher;

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

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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