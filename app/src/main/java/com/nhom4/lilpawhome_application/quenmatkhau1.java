package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ImageButton;

import com.nhom4.lilpawhome_application.databinding.ActivityQuenmatkhau1Binding;

public class quenmatkhau1 extends AppCompatActivity {

    ActivityQuenmatkhau1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuenmatkhau1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvent();
    }

    private void addEvent() {
        binding.imvQuaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.btnTieptheo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tendangnhap = binding.edtNhapemailhoacsdt.getText().toString();
                int dodaichuoi1 = tendangnhap.length();
                if(dodaichuoi1==0){
                    Toast.makeText(quenmatkhau1.this, "Hãy điền email", Toast.LENGTH_SHORT).show();
                }else {
                    String[] kituchuoi1 = tendangnhap.split("");
                    int count = 0;
                    for (int i = 0; i < dodaichuoi1; i++) {
                        if (kituchuoi1[i].equals(" ")) {
                            count++;
                        }
                    }
                    if (count > 0) {
                        Toast.makeText(quenmatkhau1.this, "Tên đăng nhập và mật khẩu không được chứa kí tự trống", Toast.LENGTH_SHORT).show();
                    } else {
                        //Hiện dialog nhận otp
                        OTPVetification_Dialog_Qmk otpVetification_dialog_qmk= new OTPVetification_Dialog_Qmk(quenmatkhau1.this,binding.edtNhapemailhoacsdt.getText().toString());
                        otpVetification_dialog_qmk.setCancelable(false);
                        otpVetification_dialog_qmk.show();
                        Intent intent = new Intent(quenmatkhau1.this, quenmatkhau2.class);
                        startActivity(intent);
                    }
                }
            }
        });


    }
}