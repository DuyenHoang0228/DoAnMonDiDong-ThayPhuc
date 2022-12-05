package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.nhom4.view.adapters.AdapterVoucher;
import com.nhom4.view.adapters.HorSanPhamAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityKhachhangthanthietBinding;
import com.nhom4.models.ChiTieuKhachHang;
import com.nhom4.models.SanPham;
import com.nhom4.models.Voucher;

import java.util.ArrayList;

public class khachhangthanthiet extends AppCompatActivity {

    ActivityKhachhangthanthietBinding binding;
    AdapterVoucher adapter;
    ArrayList<Voucher> vouchers;
    ArrayList<SanPham> dsXemThemSanPham;
    HorSanPhamAdapter adapter2;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    LinearLayoutManager Horizontallayout;
    ChiTieuKhachHang chitieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityKhachhangthanthietBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        loadData();
        addEvent();
        level();
        makeColor();
    }

    private void level() {
        //du lieu khach hang
        chitieu = new ChiTieuKhachHang("littlemermaid@user", 25, 6000000);
        int orders = chitieu.getOrders();
        double spent = chitieu.getSpent();

        //data listview voucher
        binding.lvVoucherdocquyen.setExpanded(true);
        vouchers = new ArrayList<>();
        //hang bac
        if(orders>=10 && orders<20 && spent < 5000000 && spent>=2000000){
            binding.txtTenkhachhang.setText(chitieu.getUserName());
            binding.txtSodonhang.setText(String.valueOf(orders));
            binding.txtChitieu.setText(String.valueOf(spent));
            binding.txtSodonhangcandat.setText("/20");
            binding.txtChitieucandat.setText("/5tr");
            binding.txtUudaithuhang.setText("ƯU ĐÃI HẠNG BẠC");
            binding.txtThuhangthanhvien.setText("KHÁCH HÀNG BẠC");
            binding.txtNoidunguudaithuhang.setText("Được giảm 5% giá trị đơn hàng trên 50.000 NVD cho tất cả sản phẩm trên gian hàng Lilpaw Home. Được ưu tiên nhận các mã giảm giá độc quyền từ Lilpaw Home");
            vouchers.add(new Voucher("Tất cả hình thức thanh toán", "28/02/2022", 15, "Miễn phí vận chuyển", false));
            vouchers.add(new Voucher("GIẢM 15% ĐƠN TỪ 100K", "28/11/2022", 100, "Giảm 15%", true));
        }
        //hang vang
        if(orders>=20 && orders<30 && spent < 8000000 && spent>=5000000){
            binding.txtTenkhachhang.setText(chitieu.getUserName());
            binding.txtSodonhang.setText(String.valueOf(orders));
            binding.txtChitieu.setText(String.valueOf(spent));
            binding.txtSodonhangcandat.setText("/30");
            binding.txtChitieucandat.setText("/8tr");
            binding.txtUudaithuhang.setText("ƯU ĐÃI HẠNG VÀNG");
            binding.txtThuhangthanhvien.setText("KHÁCH HÀNG VÀNG");
            binding.txtNoidunguudaithuhang.setText("Được giảm 7% giá trị đơn hàng trên 50.000 NVD cho tất cả sản phẩm trên gian hàng Lilpaw Home. Được ưu tiên nhận các mã giảm giá độc quyền từ Lilpaw Home");
            vouchers.add(new Voucher("GIẢM 50K ĐƠN TỪ 99K", "20/12/2022", 50, "Giảm 50K", true));
            vouchers.add(new Voucher("GIẢM 15% ĐƠN TỪ 100K", "28/02/2022", 100, "Giảm 15%", true));
        }
        //hang kim cuong
        if(orders>=30 && spent>=8000000){
            binding.txtTenkhachhang.setText(chitieu.getUserName());
            binding.txtSodonhang.setText(String.valueOf(orders));
            binding.txtChitieu.setText(String.valueOf(spent));
            binding.txtSodonhangcandat.setText("/30");
            binding.txtChitieucandat.setText("/8tr");
            binding.txtUudaithuhang.setText("ƯU ĐÃI HẠNG KIM CƯƠNG");
            binding.txtThuhangthanhvien.setText("KHÁCH HÀNG KIM CƯƠNG");
            binding.txtNoidunguudaithuhang.setText("Được giảm 9% giá trị đơn hàng trên 50.000 NVD cho tất cả sản phẩm trên gian hàng Lilpaw Home. Được ưu tiên nhận các mã giảm giá độc quyền từ Lilpaw Home");
            vouchers.add(new Voucher("Tất cả hình thức thanh toán", "28/02/2022", 15, "Miễn phí vận chuyển", true));
            vouchers.add(new Voucher("GIẢM 5% ĐƠN TỪ 50K", "30/11/2022", 30, "Giảm 5%", false));
        }
        adapter = new AdapterVoucher(khachhangthanthiet.this, R.layout.voucher_layout, vouchers);
        binding.lvVoucherdocquyen.setAdapter(adapter);
    }

    private void loadData() {

        //data recyclerview xem them san pham
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rcvXemthemsanpham.setLayoutManager(RecyclerViewLayoutManager);
        //add sp
        dsXemThemSanPham = new ArrayList<>();
        dsXemThemSanPham.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        dsXemThemSanPham.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        dsXemThemSanPham.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        dsXemThemSanPham.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        dsXemThemSanPham.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));

        // truyen du lieu
        adapter2= new HorSanPhamAdapter(dsXemThemSanPham);
        Horizontallayout=new LinearLayoutManager(khachhangthanthiet.this,LinearLayoutManager.HORIZONTAL,false);
        binding.rcvXemthemsanpham.setLayoutManager(Horizontallayout);
        binding.rcvXemthemsanpham.setAdapter(adapter2);



    }


    private void addEvent() {
        binding.lvVoucherdocquyen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(khachhangthanthiet.this, ChiTietVoucher.class);
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

    private void makeColor() {
        String Noidunguudaithuhang =binding.txtNoidunguudaithuhang.getText().toString();
        SpannableString s = new SpannableString(Noidunguudaithuhang);
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#EC1313")), 10, 12, 0);
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#EC1313")), 50, 65, 0);
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#EC1313")), 98, 106, 0);
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#EC1313")), 128, 137, 0);
        binding.txtNoidunguudaithuhang.setText(s);
    }

    @Override
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
