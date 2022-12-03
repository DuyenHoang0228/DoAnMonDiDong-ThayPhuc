package com.nhom4.lilpawhome_application;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nhom4.view.adapters.ThongbaoAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityNoticeBinding;
import com.nhom4.models.ThongBao;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity {
    ActivityNoticeBinding binding;
    ThongbaoAdapter adapter;
    ArrayList<ThongBao> thongbao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = ActivityNoticeBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        loadData();
        addEvent();

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.nav_action_thongbao);
        navigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_action_thongbao:
                        return true;
                    case  R.id.nav_action_danhmuc:
                        Intent intent1 =new Intent(getApplicationContext(),DanhmucActivity.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent1);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.nav_action_home:
                        Intent intent2 =new Intent(getApplicationContext(),MainActivity.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.nav_action_taikhoan:
                        Intent intent3 =new Intent(getApplicationContext(),UserActivity.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent3);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.nav_action_qr:
                        Dialog dialog = new Dialog(NoticeActivity.this);
                        dialog.setContentView(R.layout.qr_user);
                        dialog.show();
                        return true;
                }
                return false;
            }
    });}

    private void addEvent() {
        binding.lvThongbao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch (i){
                    case 0:
                        intent =new Intent(NoticeActivity.this,DSLichhenActivity.class);
                        break;

                    case 1:
                        intent =new Intent(NoticeActivity.this,KhoVoucher.class);
                        break;
                    case 2:
                        intent =new Intent(NoticeActivity.this,DsDonmuaActivity.class);
                        break;

                    case 3:
                        intent =new Intent(NoticeActivity.this,ThuongHieuActivity.class);
                        break;

                    case 4:
                        intent =new Intent(NoticeActivity.this,UuDaiMain.class);
                        break;

                    case 5:
                        intent =new Intent(NoticeActivity.this,GioHangActivity.class);
                        break;

                }
                startActivity(intent);

            }
        });
    }

    private void loadData() {
        thongbao = new ArrayList<>();
        thongbao.add(new ThongBao(R.drawable.icon_clock,"Lịch hẹn sắp đến","Bạn sắp có lịch hẹn chăm sóc thú cưng tại Lilpaw Home, đừng bỏ lỡ nhé \uD83D\uDC31\uD83D\uDC31"));
        thongbao.add(new ThongBao(R.drawable.icon_khuyen_mai_moi,"Bạn có khuyến mãi mới","Mã giảm giá các sản phẩm trong shop cho mèo \uD83D\uDE09\uD83D\uDE09"));
        thongbao.add(new ThongBao(R.drawable.icon_clock,"Đơn hàng đang được giao","Hiện đang có đơn hàng sắp đến, hãy chú ý điện thoại nhé ☎ ☎ ⏱\uD83D\uDE9A"));
        thongbao.add(new ThongBao(R.drawable.icon_khuyen_mai_moi,"Có khuyến mãi sốc","Khuyến mãi 50% tất cả sản phẩm trong ngày 11/11 \uD83C\uDF89\uD83C\uDF8A"));
        thongbao.add(new ThongBao(R.drawable.icon_bell_black,"Sản phẩm trong giỏ","Hiện đang có 12 sản phẩm trong giỏ hàng của bạn đấy, nhanh tay đặt đi thôi ‼‼"));

        adapter = new ThongbaoAdapter(NoticeActivity.this, R.layout.thongbao_list,thongbao);
        binding.lvThongbao.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {case android.R.id.home: onBackPressed();
            return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}