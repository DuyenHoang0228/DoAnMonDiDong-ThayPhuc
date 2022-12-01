package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.databinding.ActivityQuenmatkhau2Binding;

public class quenmatkhau2 extends AppCompatActivity {

    ActivityQuenmatkhau2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityQuenmatkhau2Binding.inflate(getLayoutInflater());
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
        binding.btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matkhau = binding.edtNhapmatkhau.getText().toString();
                String nhaplaimatkhau = binding.edtNhaplaimatkhau.getText().toString();
                int dodaichuoi1 = matkhau.length();
                int dodaichuoi2 = nhaplaimatkhau.length();
                if(dodaichuoi1==0 || dodaichuoi2==0){
                    Toast.makeText(quenmatkhau2.this, "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    if(dodaichuoi1 == dodaichuoi2){
                        String[] kituchuoi1 = matkhau.split("");
                        String[] kituchuoi2 = nhaplaimatkhau.split("");
                        int count = 0, dif =0;
                        for (int i = 0; i < dodaichuoi1; i++) {
                            if (kituchuoi1[i].equals(" ")) {
                                count++;
                            }
                            if(!kituchuoi1[i].equals(kituchuoi2[i])){
                                dif ++;
                            }
                        }
                        if (count ==0 && dif ==0){
                            Toast.makeText(quenmatkhau2.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(quenmatkhau2.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else if (count > 0) {
                            Toast.makeText(quenmatkhau2.this, "Mật khẩu không được chứa kí tự trống", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(quenmatkhau2.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(quenmatkhau2.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}