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
                        intent =new Intent(NoticeActivity.this,UuDaiMain.class);
                        break;

                    case 4:
                        intent =new Intent(NoticeActivity.this,GioHangActivity.class);
                        break;

                }
                startActivity(intent);

            }
        });
    }

    private void loadData() {
        thongbao = new ArrayList<>();
        thongbao.add(new ThongBao(R.drawable.icon_clock,"L???ch h???n s???p ?????n","B???n s???p c?? l???ch h???n ch??m s??c th?? c??ng t???i Lilpaw Home, ?????ng b??? l??? nh?? \uD83D\uDC31\uD83D\uDC31"));
        thongbao.add(new ThongBao(R.drawable.icon_khuyen_mai_moi,"B???n c?? khuy???n m??i m???i","M?? gi???m gi?? c??c s???n ph???m trong shop cho m??o \uD83D\uDE09\uD83D\uDE09"));
        thongbao.add(new ThongBao(R.drawable.icon_clock,"????n h??ng ??ang ???????c giao","Hi???n ??ang c?? ????n h??ng s???p ?????n, h??y ch?? ?? ??i???n tho???i nh?? ??? ??? ???\uD83D\uDE9A"));
        thongbao.add(new ThongBao(R.drawable.icon_khuyen_mai_moi,"C?? khuy???n m??i s???c","Khuy???n m??i 50% t???t c??? s???n ph???m trong ng??y 11/11 \uD83C\uDF89\uD83C\uDF8A"));
        thongbao.add(new ThongBao(R.drawable.icon_bell_black,"S???n ph???m trong gi???","Hi???n ??ang c?? 12 s???n ph???m trong gi??? h??ng c???a b???n ?????y, nhanh tay ?????t ??i th??i ??????"));

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