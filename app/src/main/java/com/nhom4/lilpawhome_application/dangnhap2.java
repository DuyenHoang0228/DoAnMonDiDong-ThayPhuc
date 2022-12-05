package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nhom4.databases.DBHelperTaiKhoan;
import com.nhom4.lilpawhome_application.databinding.ActivityDangnhap2Binding;

public class dangnhap2 extends AppCompatActivity {

    ActivityDangnhap2Binding binding;
    private SQLiteDatabase db;
    private SQLiteOpenHelper openHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openHelper = new DBHelperTaiKhoan(this);
        binding = ActivityDangnhap2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        underline();
        addEvent();
    }

    private void addEvent() {
        binding.imvThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tendangnhap = binding.edtNhapemailhoacsdt.getText().toString();
                String matkhau = binding.edtPassword.getText().toString();
                int dodaichuoi1 = tendangnhap.length();
                int dodaichuoi2 = matkhau.length();
                if(dodaichuoi1==0 || dodaichuoi2==0){
                    Toast.makeText(dangnhap2.this, "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    String[] kituchuoi1 = tendangnhap.split("");
                    String[] kituchuoi2 = matkhau.split("");
                    int count = 0;
                    for (int i = 0; i < dodaichuoi1; i++) {
                        if (kituchuoi1[i].equals(" ")) {
                            count++;
                        }
                    }
                    for (int j = 0; j < dodaichuoi2; j++) {
                        if (kituchuoi2[j].equals(" ")) {
                            count++;
                        }
                    }
                    if (count > 0) {
                        Toast.makeText(dangnhap2.this, "Tên đăng nhập và mật khẩu không được chứa kí tự trống", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        cursor = db.rawQuery("SELECT *FROM " + DBHelperTaiKhoan.TBL_NAME+ " WHERE( " + DBHelperTaiKhoan.COL_EMAIL + "=? OR " + DBHelperTaiKhoan.COL_PHONENUMBER + "=?) AND " + DBHelperTaiKhoan.COL_PASSWORD + "=?", new String[]{tendangnhap, matkhau});
                        if (cursor != null) {
                            if (cursor.getCount() > 0) {
                                Toast.makeText(dangnhap2.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(dangnhap2.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
        binding.btnDangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap2.this, dangky.class);
                startActivity(intent);
            }
        });
        binding.txtQuenmatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(dangnhap2.this, quenmatkhau1.class);
                    startActivity(intent);
            }
        });
    }

    private void underline() {
        TextView txt_quenmatkhau = findViewById(R.id.txt_quenmatkhau);
        txt_quenmatkhau.setPaintFlags(txt_quenmatkhau.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }

}