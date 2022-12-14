package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.nhom4.databases.DBHelperSanPham;
import com.nhom4.models.SanPhamLilPawHome;
import com.nhom4.view.adapters.AdapterVoucher;
import com.nhom4.view.adapters.HorAdapterSanphamLilPawHome;
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
    RecyclerView recyclerView;
    ChiTieuKhachHang chitieu;
    DBHelperSanPham dbHelperSanPham;
    ArrayList<SanPhamLilPawHome> spXemThem;
    HorAdapterSanphamLilPawHome adapter4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityKhachhangthanthietBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createDb();
        loadData();
        addEvent();
        level();
        makeColor();
    }

    private void createDb() {
        dbHelperSanPham=new DBHelperSanPham(khachhangthanthiet.this);
        dbHelperSanPham.createSampleData();
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
            binding.txtUudaithuhang.setText("??U ????I H???NG B???C");
            binding.txtThuhangthanhvien.setText("KH??CH H??NG B???C");
            binding.txtNoidunguudaithuhang.setText("???????c gi???m 5% gi?? tr??? ????n h??ng tr??n 50.000 NVD cho t???t c??? s???n ph???m tr??n gian h??ng Lilpaw Home. ???????c ??u ti??n nh???n c??c m?? gi???m gi?? ?????c quy???n t??? Lilpaw Home");
            vouchers.add(new Voucher("T???t c??? h??nh th???c thanh to??n", "28/02/2022", 15, "Mi???n ph?? v???n chuy???n", false));
            vouchers.add(new Voucher("GI???M 15% ????N T??? 100K", "28/11/2022", 100, "Gi???m 15%", true));
        }
        //hang vang
        if(orders>=20 && orders<30 && spent < 8000000 && spent>=5000000){
            binding.txtTenkhachhang.setText(chitieu.getUserName());
            binding.txtSodonhang.setText(String.valueOf(orders));
            binding.txtChitieu.setText(String.valueOf(spent));
            binding.txtSodonhangcandat.setText("/30");
            binding.txtChitieucandat.setText("/8tr");
            binding.txtUudaithuhang.setText("??U ????I H???NG V??NG");
            binding.txtThuhangthanhvien.setText("KH??CH H??NG V??NG");
            binding.txtNoidunguudaithuhang.setText("???????c gi???m 7% gi?? tr??? ????n h??ng tr??n 50.000 NVD cho t???t c??? s???n ph???m tr??n gian h??ng Lilpaw Home. ???????c ??u ti??n nh???n c??c m?? gi???m gi?? ?????c quy???n t??? Lilpaw Home");
            vouchers.add(new Voucher("GI???M 50K ????N T??? 99K", "20/12/2022", 50, "Gi???m 50K", true));
            vouchers.add(new Voucher("GI???M 15% ????N T??? 100K", "28/02/2022", 100, "Gi???m 15%", true));
        }
        //hang kim cuong
        if(orders>=30 && spent>=8000000){
            binding.txtTenkhachhang.setText(chitieu.getUserName());
            binding.txtSodonhang.setText(String.valueOf(orders));
            binding.txtChitieu.setText(String.valueOf(spent));
            binding.txtSodonhangcandat.setText("/30");
            binding.txtChitieucandat.setText("/8tr");
            binding.txtUudaithuhang.setText("??U ????I H???NG KIM C????NG");
            binding.txtThuhangthanhvien.setText("KH??CH H??NG KIM C????NG");
            binding.txtNoidunguudaithuhang.setText("???????c gi???m 9% gi?? tr??? ????n h??ng tr??n 50.000 NVD cho t???t c??? s???n ph???m tr??n gian h??ng Lilpaw Home. ???????c ??u ti??n nh???n c??c m?? gi???m gi?? ?????c quy???n t??? Lilpaw Home");
            vouchers.add(new Voucher("T???t c??? h??nh th???c thanh to??n", "28/02/2022", 15, "Mi???n ph?? v???n chuy???n", true));
            vouchers.add(new Voucher("GI???M 5% ????N T??? 50K", "30/11/2022", 30, "Gi???m 5%", false));
        }
        adapter = new AdapterVoucher(khachhangthanthiet.this, R.layout.voucher_layout, vouchers);
        binding.lvVoucherdocquyen.setAdapter(adapter);
    }

    private void loadData() {

//        //data recyclerview xem them san pham
//        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
//        binding.rcvXemthemsanpham.setLayoutManager(RecyclerViewLayoutManager);
//        //add sp
//        dsXemThemSanPham = new ArrayList<>();
//        dsXemThemSanPham.add(new SanPham(R.drawable.hinhsanpham, "Th???c ??n cho m??o Felipro 500g - Gi???m s???i m???t - V??? h???i s???n", 32000, 36000, "H??ng: Felipiro", "M??o", "Th???c ??n"));
//        dsXemThemSanPham.add(new SanPham(R.drawable.hinhsanpham, "Th???c ??n cho m??o Felipro 500g - Gi???m s???i m???t - V??? h???i s???n", 32000, 36000, "H??ng: Felipiro", "M??o", "Th???c ??n"));
//        dsXemThemSanPham.add(new SanPham(R.drawable.hinhsanpham, "Th???c ??n cho m??o Felipro 500g - Gi???m s???i m???t - V??? h???i s???n", 32000, 36000, "H??ng: Felipiro", "M??o", "Th???c ??n"));
//        dsXemThemSanPham.add(new SanPham(R.drawable.hinhsanpham, "Th???c ??n cho m??o Felipro 500g - Gi???m s???i m???t - V??? h???i s???n", 32000, 36000, "H??ng: Felipiro", "M??o", "Th???c ??n"));
//        dsXemThemSanPham.add(new SanPham(R.drawable.hinhsanpham, "Th???c ??n cho m??o Felipro 500g - Gi???m s???i m???t - V??? h???i s???n", 32000, 36000, "H??ng: Felipiro", "M??o", "Th???c ??n"));
//
//        // truyen du lieu
//        adapter2= new HorSanPhamAdapter(dsXemThemSanPham);
//        Horizontallayout=new LinearLayoutManager(khachhangthanthiet.this,LinearLayoutManager.HORIZONTAL,false);
//        binding.rcvXemthemsanpham.setLayoutManager(Horizontallayout);
//        binding.rcvXemthemsanpham.setAdapter(adapter2);

        recyclerView = (RecyclerView) findViewById(R.id.rcv_xemthemsanpham);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);
        //add sp
        spXemThem= new ArrayList<>();

        //truy v???n
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
                " WHERE "+ DBHelperSanPham.COL_CATE1+" like '%chomeo' ");
        while(c.moveToNext())
        {
            spXemThem.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter4= new HorAdapterSanphamLilPawHome(khachhangthanthiet.this, spXemThem, new HorAdapterSanphamLilPawHome.ItemClickListener() {
            @Override
            public void onItemClick(SanPhamLilPawHome details) {
                Intent intent = new Intent(khachhangthanthiet.this, TrangSanPhamActivity.class);
                intent.putExtra("IDsanpham",details.getIdSanPham());
                startActivity(intent);
            }
        });

        Horizontallayout=new LinearLayoutManager(khachhangthanthiet.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(Horizontallayout);
        recyclerView.setAdapter(adapter4);

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
