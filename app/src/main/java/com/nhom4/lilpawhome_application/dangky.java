package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.databinding.ActivityDangkyBinding;

public class dangky extends AppCompatActivity {

    ActivityDangkyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDangkyBinding.inflate(getLayoutInflater());
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
        binding.btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matkhau = binding.edtNhapmatkhau.getText().toString();
                String nhaplaimatkhau = binding.edtNhaplaimatkhau.getText().toString();
                String tendangnhap = binding.edtNhapsdt.getText().toString();
                //CHUYỀN SDT QUA TÊN, SDT
                Intent z =new Intent(dangky.this, sodienthoai.class);
                z.putExtra("sodienthoai",tendangnhap);

                //
                int dodaichuoi1 = matkhau.length();
                int dodaichuoi2 = nhaplaimatkhau.length();
                int dodaichuoi3 = tendangnhap.length();
                if(dodaichuoi1==0 || dodaichuoi2==0 || dodaichuoi3==0){
                    Toast.makeText(dangky.this, "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    String[] kituchuoi3 = tendangnhap.split("");
                    int sokitutrong =0;
                    for (int m = 0; m<dodaichuoi3; m++){
                        if(kituchuoi3[m].equals(" ")){
                            sokitutrong ++;
                        }
                    }
                    if(sokitutrong > 0){
                        Toast.makeText(dangky.this, "Số điện thoại không được chứa kí tự trống", Toast.LENGTH_SHORT).show();
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
                                if(!binding.cbDongydieukhoan.isChecked()){
                                    Toast.makeText(dangky.this, "Bạn cần đồng ý với các điều khoản", Toast.LENGTH_SHORT).show();
                                }else {
                                    //Hiện dialog nhập otp
                                    //Hiện dialog nhập otp
                                    OTPVetification_Dialog_Dangky otpVetification_dialog_dangky= new OTPVetification_Dialog_Dangky(dangky.this,binding.edtNhapsdt.getText().toString());
                                    otpVetification_dialog_dangky.setCancelable(false);
                                    otpVetification_dialog_dangky.show();
                                    Toast.makeText(dangky.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();

                                   // Intent intent = new Intent(dangky.this, MainActivity.class);
                                   // startActivity(intent);
                                }
                            }
                            else if (count > 0) {
                                Toast.makeText(dangky.this, "Mật khẩu không được chứa kí tự trống", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(dangky.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(dangky.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });
    }
}