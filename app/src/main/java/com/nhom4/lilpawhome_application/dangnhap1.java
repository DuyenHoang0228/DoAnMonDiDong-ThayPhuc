package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.databinding.ActivityDangnhap1Binding;

public class dangnhap1 extends AppCompatActivity {

    ActivityDangnhap1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDangnhap1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        underline();
        addEvent();
    }

    private void underline() {
        TextView txt_dieukhoansudung = findViewById(R.id.txt_dieukhoansudung);
        txt_dieukhoansudung.setPaintFlags(txt_dieukhoansudung.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }

    private void addEvent() {
        binding.txtDieukhoansudung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap1.this, cacdieukhoansudung.class);
                startActivity(intent);
            }
        });
        binding.btnDangnhapbangfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        binding.btnDangnhapbanggoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(dangnhap1.this);
                dialog.setContentView(R.layout.dialog_nhaptaikhoangoogle);
                dialog.show();

                Window window = dialog.getWindow();
                if(window==null){
                    return;
                }
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ImageButton thoatdx;
                thoatdx = dialog.findViewById(R.id.btn_exitntkgg);
                thoatdx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                Button xacnhan;
                xacnhan=dialog.findViewById(R.id.btn_xacnhandcgg);
                xacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Chuyền dữ liệu
                   //     EditText taikhoangg;
                     //   taikhoangg=findViewById(R.id.edt_nhapdcgg);
                       // String tkgg= taikhoangg.getText().toString();
                       // Intent z =new Intent(getApplicationContext(), email.class);
                       // z.putExtra("email",tkgg);
                        //Toast
                        EditText nhapdcgg,nhapmk;
                        nhapdcgg=dialog.findViewById(R.id.edt_nhapdcgg);
                        nhapmk= dialog.findViewById(R.id.edt_nhapmatkhau);
                        int dodaichuoi1 = nhapmk.length();
                        int dodaichuoi2 = nhapdcgg.length();
                        if(dodaichuoi1==0 || dodaichuoi2==0){
                            Toast.makeText(dangnhap1.this, "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(dangnhap1.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(dangnhap1.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                });


            }
        });
        binding.btnDangnhapbanglilpawhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap1.this,dangnhap2.class);
                startActivity(intent);
            }
        });
        binding.txtBoquadangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(dangnhap1.this, MainActivity.class);
                 startActivity(intent);
            }
        });
    }
}