package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4.view.adapters.AdapterSanPhamTT;
import com.nhom4.view.adapters.AdapterVoucherTT;
import com.nhom4.view.adapters.HorAdapterPhuongThucTT;
import com.nhom4.lilpawhome_application.databinding.ActivityThanhtoanBinding;
import com.nhom4.models.PhuongThucTT;

import java.util.ArrayList;

public class ThanhtoanActivity extends AppCompatActivity {

    ActivityThanhtoanBinding binding;
    AdapterSanPhamTT adapterSP;
    HorAdapterPhuongThucTT adapterPT;
    ArrayList<PhuongThucTT> phuongThucTTS;
    LinearLayoutManager VerticalLayout, HorizontalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManagerSP, RecyclerViewLayoutManagerPT;
    SQLiteDatabase db;
    int IDdiachi;
    String action, hinhthuc, giavanchuyen, ngaygiao;
    Double discountVC, minordervalueVC, maxdiscountVC;
    Double discountMH, minordervalueMH, maxdiscountMH;
    Double finalordervalue;
    Double giamgia;
    Double giamgiaMH = 0.0, giamgiaVC = 0.0;
    Double tongtienvanchuyen;
    Double ordervalue;
    Bundle bundlediachi, bundlevoucher;
    boolean apmavanchuyen, apmamuahang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_thanhtoan);
        binding = ActivityThanhtoanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        firstLoadAddress();
        loadListSP();
        addEvent();
        //============Adapter Phương thức thanh toán====================
        loadPTThanhtoan();
        loadListPTTT();

        binding.txtTongsotien.setText(String.format("%.0fđ",MainActivity.tongthanhtoan));
        binding.txtTongtienhang.setText(String.format("%.0f VNĐ",MainActivity.tongthanhtoan));
    }

    private void firstLoadAddress() {//Hàm dùng để load địa chỉ mặc định trước cho trang thanh toán
        db = openOrCreateDatabase(Utils_Diachi.DB_NAME, MODE_PRIVATE,null);
        String whereclause = String.format("%s = 1", Utils_Diachi.COL_MacDinh);
        Cursor c = db.query(Utils_Diachi.TBL_NAME, null, whereclause,
                null,null,null,null);
        while (c.moveToNext()){
            String tinh = c.getString(3);
            String quan = c.getString(4);
            String phuong = c.getString(5);
            String duong = c.getString(6);
            String diachi = duong + ", " + phuong + ", " + quan + ", " + tinh;
            String ten = c.getString(1);
            String sodienthoai = c.getString(2);
            IDdiachi = c.getInt(0);
            binding.txtHotensdt.setText(String.format("%1$s | %2$s", ten, sodienthoai));
            binding.txtDiachi.setText(diachi);
        }
        c.close();
    }

    @Override
    protected void onResume() {
        if (action==null){
        } else if (action.equals("fromDiachi")){//Intent từ màn hình địa chỉ
            db = openOrCreateDatabase(Utils_Diachi.DB_NAME, MODE_PRIVATE,null);
            String whereclause = String.format("ID = %d", IDdiachi);
            Cursor c = db.query(Utils_Diachi.TBL_NAME, null,whereclause,
                    null,null,null,null);
            while (c.moveToNext()){
                String tinh = c.getString(3);
                String quan = c.getString(4);
                String phuong = c.getString(5);
                String duong = c.getString(6);
                String diachi = duong + ", " + phuong + ", " + quan + ", " + tinh;
                String ten = c.getString(1);
                String sodienthoai = c.getString(2);
                binding.txtHotensdt.setText(String.format("%1$s | %2$s", ten, sodienthoai));
                binding.txtDiachi.setText(diachi);
            }
            c.close();
        } else if (action.equals("fromVanchuyen")){
            binding.txtHinhthucvc.setText(hinhthuc);
            binding.txtTienvanchuyen.setText(giavanchuyen);
            binding.txtNgaynhanhang.setText(ngaygiao);
        }
        calculateOrderValue();
        super.onResume();
    }

    private void calculateOrderValue() {
        tongtienvanchuyen = Double.parseDouble(binding.txtTienvanchuyen.getText().toString().replace(" VNĐ", ""));
        ordervalue = MainActivity.tongthanhtoan;

        if (apmamuahang && apmavanchuyen){
            binding.txtFreeship.setVisibility(View.VISIBLE);
            binding.txtVouchergiamgia.setVisibility(View.VISIBLE);
            if ((ordervalue < minordervalueMH) && (ordervalue < minordervalueVC)){
                giamgiaMH = 0.0;
                giamgiaVC = 0.0;
                Toast.makeText(ThanhtoanActivity.this, "Không đủ điều kiện áp dụng mã voucher vận chuyển và mua hàng.", Toast.LENGTH_LONG).show();
                binding.txtVouchergiamgia.setText("0đ");
                binding.txtVouchergiamgia.setBackground(getDrawable(R.drawable.backgroundstroke_gray));
                binding.txtFreeship.setBackground(getDrawable(R.drawable.backgroundstroke_gray));
                binding.txtVouchergiamgia.setTextColor(Color.parseColor("#919191"));
                binding.txtFreeship.setTextColor(Color.parseColor("#919191"));
            } else if ((ordervalue >= minordervalueMH) && (ordervalue < minordervalueVC)){
                Toast.makeText(ThanhtoanActivity.this, "Không đủ điều kiện áp dụng mã voucher vận chuyển.", Toast.LENGTH_LONG).show();
                giamgiaMH();
                giamgiaVC = 0.0;
                binding.txtVouchergiamgia.setText(String.format("%.0fđ",giamgiaMH));
                binding.txtVouchergiamgia.setBackground(getDrawable(R.drawable.backgroundstroke));
                binding.txtFreeship.setBackground(getDrawable(R.drawable.backgroundstroke_gray));
                binding.txtVouchergiamgia.setTextColor(Color.parseColor("#9E7E44"));
                binding.txtFreeship.setTextColor(Color.parseColor("#919191"));
            } else if ((ordervalue < minordervalueMH) && (ordervalue >= minordervalueVC)) {
                Toast.makeText(ThanhtoanActivity.this, "Không đủ điều kiện áp dụng mã voucher mua hàng.", Toast.LENGTH_LONG).show();
                giamgiaVC();
                giamgiaMH = 0.0;
                binding.txtVouchergiamgia.setBackground(getDrawable(R.drawable.backgroundstroke_gray));
                binding.txtFreeship.setBackground(getDrawable(R.drawable.backgroundstroke_brown));
                binding.txtVouchergiamgia.setTextColor(Color.parseColor("#919191"));
                binding.txtFreeship.setTextColor(Color.parseColor("#FF2875"));
            } else {
                Toast.makeText(ThanhtoanActivity.this, "Áp dụng cả 2 mã voucher thành công.", Toast.LENGTH_LONG).show();
                giamgiaVC();
                giamgiaMH();
                binding.txtVouchergiamgia.setText(String.format("%.0fđ",giamgiaMH));
                binding.txtVouchergiamgia.setBackground(getDrawable(R.drawable.backgroundstroke));
                binding.txtFreeship.setBackground(getDrawable(R.drawable.backgroundstroke_brown));
                binding.txtVouchergiamgia.setTextColor(Color.parseColor("#FF2875"));
                binding.txtFreeship.setTextColor(Color.parseColor("#9E7E44"));
            }
        } else if (!apmamuahang && apmavanchuyen){
            binding.txtFreeship.setVisibility(View.VISIBLE);
            binding.txtVouchergiamgia.setVisibility(View.GONE);
            if (ordervalue < minordervalueVC){
                giamgiaMH = 0.0;
                giamgiaVC = 0.0;
                binding.txtFreeship.setTextColor(Color.parseColor("#919191"));
                binding.txtFreeship.setBackground(getDrawable(R.drawable.backgroundstroke_gray));
                Toast.makeText(ThanhtoanActivity.this, "Không đủ điều kiện áp dụng mã voucher vận chuyển.", Toast.LENGTH_LONG).show();
            } else {
                giamgiaVC();
                giamgiaMH = 0.0;
                binding.txtFreeship.setTextColor(Color.parseColor("#9E7E44"));
                binding.txtFreeship.setBackground(getDrawable(R.drawable.backgroundstroke_brown));
                Toast.makeText(ThanhtoanActivity.this, "Áp dụng thành công voucher vận chuyển.", Toast.LENGTH_LONG).show();
            }
        } else if (apmamuahang && !apmavanchuyen){
            binding.txtFreeship.setVisibility(View.GONE);
            binding.txtVouchergiamgia.setVisibility(View.VISIBLE);
            if (ordervalue < minordervalueMH){
                giamgiaVC = 0.0;
                giamgiaMH = 0.0;
                binding.txtVouchergiamgia.setText("0đ");
                binding.txtVouchergiamgia.setBackground(getDrawable(R.drawable.backgroundstroke_gray));
                Toast.makeText(ThanhtoanActivity.this, "Không đủ điều kiện áp dụng mã voucher mua hàng.", Toast.LENGTH_LONG).show();
            } else {
                giamgiaMH();
                giamgiaVC = 0.0;
                binding.txtVouchergiamgia.setText(String.format("%.0fđ",giamgiaMH));
                binding.txtVouchergiamgia.setBackground(getDrawable(R.drawable.backgroundstroke));
                binding.txtVouchergiamgia.setTextColor(Color.parseColor("#9E7E44"));
                Toast.makeText(ThanhtoanActivity.this, "Áp dụng thành công voucher mua hàng.", Toast.LENGTH_LONG).show();
            }
        }else {
            binding.txtFreeship.setVisibility(View.GONE);
            binding.txtVouchergiamgia.setVisibility(View.GONE);
        }
        if (tongtienvanchuyen - giamgiaVC < 0){
            giamgiaVC = tongtienvanchuyen;
        }
        giamgia = giamgiaMH + giamgiaVC;

        finalordervalue = ordervalue + tongtienvanchuyen - giamgia;
        binding.txtSotienduocgiam.setText(String.format("%.0f VNĐ", giamgia));
        binding.txtTongthanhtoan.setText(String.format("%.0f VNĐ", finalordervalue));
        binding.txtTongcanthanhtoan.setText(String.format("%.0f VNĐ", finalordervalue));
        binding.txtTongtienvanchuyen.setText(String.format("%.0f VNĐ", tongtienvanchuyen));
    }

    private void giamgiaVC() {
        giamgiaVC = discountVC*1000;
    }

    private void giamgiaMH() {
        if (discountMH < 1.0) {
            if (discountMH * ordervalue < maxdiscountMH){
                giamgiaMH = Double.valueOf(Math.round(discountMH * ordervalue));
            } else {
                giamgiaMH = maxdiscountMH*1000;
            }
        } else {
            giamgiaMH = discountMH*1000;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){//Nếu kết quả dữ liệu được trả về từ màn hình địa điểm nhận hàng thì lấy IDdiachi
            if (resultCode == Activity.RESULT_OK){
                IDdiachi = data.getIntExtra("IDdiachi",0);
                action = data.getAction();
            }
        } else if (requestCode == 2){
            if (resultCode == Activity.RESULT_OK){
                bundlediachi = data.getExtras();
                hinhthuc = bundlediachi.getString("Hinhthuc");
                giavanchuyen = bundlediachi.getString("Gia");
                ngaygiao = bundlediachi.getString("Ngaygiao");
                action = data.getAction();
            }
        } else if (requestCode == 3){
            if (resultCode == Activity.RESULT_OK){
                bundlevoucher = data.getExtras();
                apmamuahang = bundlevoucher.getBoolean("Apmamuahang");
                apmavanchuyen = bundlevoucher.getBoolean("Apmavanchuyen");
                if (apmamuahang){
                    discountMH = bundlevoucher.getDouble("DiscountMH");
                    minordervalueMH = bundlevoucher.getDouble("MinordervalueMH")*1000;
                    maxdiscountMH = bundlevoucher.getDouble("VouchertoidaMH");
                }
                if (apmavanchuyen){
                    discountVC = bundlevoucher.getDouble("DiscountVC");
                    minordervalueVC = bundlevoucher.getDouble("MinordervalueVC")*1000;
                    maxdiscountVC = bundlevoucher.getDouble("VouchertoidaVC");
                }
            }
        }
    }

    private void addEvent() {
        binding.llDiadiemnhanhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThanhtoanActivity.this, DiachiTTActivity.class);
                intent.putExtra("IDdiachi", IDdiachi);
                startActivityForResult(intent, 1);//Intent qua màn hình địa điểm nhận hàng có đính kèm request code
            }
        });
        binding.llPhuongthucvanchuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThanhtoanActivity.this, PTVanchuyenActivity.class);
                startActivityForResult(intent, 2);
            }
        });
        binding.itemVouchertt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThanhtoanActivity.this, VoucherTTActivity.class);
                startActivityForResult(intent, 3);
            }
        });
        binding.itemPhuongthucthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThanhtoanActivity.this, PhuongthucTTActivity.class);
                startActivityForResult(intent, 4);
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
//        intent = getIntent();
//        String action = intent.getAction();
//        if (action==null){
//        } else if (action.equals("fromDiachi")){//Intent từ màn hình địa chỉ
//            IDdiachi = intent.getIntExtra("IDdiachi",0);
//            db = openOrCreateDatabase(Utils_Diachi.DB_NAME, MODE_PRIVATE,null);
//            String whereclause = String.format("ID = %d", IDdiachi);
//            Cursor c = db.query(Utils_Diachi.TBL_NAME, null,whereclause,
//                    null,null,null,null);
//            while (c.moveToNext()){
//                String tinh = c.getString(3);
//                String quan = c.getString(4);
//                String phuong = c.getString(5);
//                String duong = c.getString(6);
//                String diachi = duong + ", " + phuong + ", " + quan + ", " + tinh;
//                String ten = c.getString(1);
//                String sodienthoai = c.getString(2);
//                binding.txtHotensdt.setText(String.format("%1$s | %2$s", ten, sodienthoai));
//                binding.txtDiachi.setText(diachi);
//            }
//            c.close();
//        }
    }

    private void loadListPTTT() {
        RecyclerViewLayoutManagerPT = new LinearLayoutManager(getApplicationContext());
        binding.rvPhuongthucthanhtoan.setLayoutManager(RecyclerViewLayoutManagerPT);

        adapterPT = new HorAdapterPhuongThucTT(phuongThucTTS);

        // Thiết lập phương hướng của RecyclerView (ngang)
        HorizontalLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.rvPhuongthucthanhtoan.setLayoutManager(HorizontalLayout);
        binding.rvPhuongthucthanhtoan.setAdapter(adapterPT);
    }

    private void loadListSP() {
        RecyclerViewLayoutManagerSP = new LinearLayoutManager(getApplicationContext());
        binding.rvDssanpham.setLayoutManager(RecyclerViewLayoutManagerSP);

        adapterSP = new AdapterSanPhamTT(MainActivity.manggiohang);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvDssanpham.setLayoutManager(VerticalLayout);

        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(binding.rvDssanpham.getContext(),
                VerticalLayout.getOrientation());
        binding.rvDssanpham.addItemDecoration(dividerItemDecoration1);
        dividerItemDecoration1.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider_gray));

        binding.rvDssanpham.setAdapter(adapterSP);
    }

    private void loadPTThanhtoan() {
        phuongThucTTS = new ArrayList<>();
        phuongThucTTS.add(new PhuongThucTT(R.drawable.icon_cod, "Thanh toán khi nhận hàng", "Thanh toán COD", false));
        phuongThucTTS.add(new PhuongThucTT(R.drawable.icon_atm, "Thẻ ATM nội địa", getString(R.string.internetbanking, "VCB *9705"), false));
        phuongThucTTS.add(new PhuongThucTT(R.drawable.icon_creditcards, "Thẻ tín dụng / Thẻ ghi nợ", getString(R.string.visa_mastercard, "*2055"), false));
        phuongThucTTS.add(new PhuongThucTT(R.drawable.icon_vnpay, "Thanh toán bằng ví VNPAY", "Liên kết ví VNPAY", false));
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
            Dialog dialog = new Dialog(ThanhtoanActivity.this);
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
            Intent intent = new Intent(ThanhtoanActivity.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThanhtoanActivity.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThanhtoanActivity.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThanhtoanActivity.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThanhtoanActivity.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThanhtoanActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ThanhtoanActivity.this, BlogActivity.class);
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