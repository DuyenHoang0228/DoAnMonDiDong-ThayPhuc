package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class datlaimatkhau extends AppCompatActivity{
    Button xacnhan;
    EditText nhapmk,nhaplaimk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_datlaimatkhau);
        xacnhan=findViewById(R.id.btn_xacnhanmk);
        nhapmk=findViewById(R.id.edt_nhapmkmoi);
        nhaplaimk=findViewById(R.id.edt_nhaplaimkmoi);
        addEvents();
    }

    private void addEvents() {
        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matkhau = nhapmk.getText().toString();
                String nhaplaimatkhau = nhaplaimk.getText().toString();
                int dodaichuoi1 = matkhau.length();
                int dodaichuoi2 = nhaplaimatkhau.length();
                if(dodaichuoi1==0 || dodaichuoi2==0){
                    Toast.makeText(datlaimatkhau.this, "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    if (dodaichuoi1 == dodaichuoi2) {
                        String[] kituchuoi1 = matkhau.split("");
                        String[] kituchuoi2 = nhaplaimatkhau.split("");
                        int count = 0, dif = 0;
                        for (int i = 0; i < dodaichuoi1; i++) {
                            if (kituchuoi1[i].equals(" ")) {
                                count++;
                            }
                            if (!kituchuoi1[i].equals(kituchuoi2[i])) {
                                dif++;
                            }
                        }
                        if (count == 0 && dif == 0) {
                            Toast.makeText(datlaimatkhau.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(datlaimatkhau.this, MainActivity.class);
                            startActivity(intent);
                           // onBackPressed();
                        } else if (count > 0) {
                            Toast.makeText(datlaimatkhau.this, "Mật khẩu không được chứa kí tự trống", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(datlaimatkhau.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(datlaimatkhau.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                    }
                }
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
            Dialog dialog = new Dialog(datlaimatkhau.this);
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
            Intent intent = new Intent(datlaimatkhau.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(datlaimatkhau.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(datlaimatkhau.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(datlaimatkhau.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(datlaimatkhau.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(datlaimatkhau.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(datlaimatkhau.this, BlogActivity.class);
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