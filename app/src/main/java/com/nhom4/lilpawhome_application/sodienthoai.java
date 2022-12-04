package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.databinding.ActivityNhapsodienthoaimoiBinding;

public class sodienthoai extends AppCompatActivity {
Button thaydoi;
TextView sodienthoai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_sodienthoai);
        thaydoi=findViewById(R.id.btn_thaydoisodienthoai);
        sodienthoai=findViewById(R.id.txt_sodienthoaihientai);
        addEvents();
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


    private void addEvents() {
        thaydoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sodienthoai.this, nhapsodienthoaimoi.class);
                startActivity(intent);
                LayoutInflater inflater= getLayoutInflater();
                View sdt = inflater.inflate(R.layout.activity_nhapsodienthoaimoi,null);
                sodienthoai= sdt.findViewById(R.id.edt_nhapsodienthoaimoi);
                String dtmoi=sodienthoai.getText().toString();
                sodienthoai.setText(dtmoi);

//               //Lấy dữ liệu từ chỗ đổi sdt
//                Intent y=getIntent();
//                String sdtmoi=y.getStringExtra("sodienthoaimoi");
//                sodienthoai.setText(sdtmoi);
            }
        });
        //Lấy dữ liệu từ chỗ đăng ký
        Intent i=getIntent();
        String sdt=i.getStringExtra("sodienthoai");
        sodienthoai.setText(sdt);

    }
}