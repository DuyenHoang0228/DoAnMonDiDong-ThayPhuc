package com.nhom4.lilpawhome_application;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.nhom4.adapters.ThongbaoAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityNoticeBinding;
import com.nhom4.models.ThongBao;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity {
    ActivityNoticeBinding binding;
    ThongbaoAdapter adapter;
    ArrayList<ThongBao> thongbao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);

        binding = ActivityNoticeBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        loadData();
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