package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nhom4.databases.DBHelperTaiKhoan;
import com.nhom4.lilpawhome_application.databinding.ActivityDangkyBinding;

public class dangky extends AppCompatActivity {

    ActivityDangkyBinding binding;
    public static String tentk;
    public static String sdt;
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDangkyBinding.inflate(getLayoutInflater());

        openHelper = new DBHelperTaiKhoan(this);
        db = openHelper.getWritableDatabase();
        setContentView(binding.getRoot());
        addEvent();
        createDB();
    }

    private void createDB() {
    }

    private void addEvent() {
        binding.imvQuaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangky.this,dangnhap2.class);
                startActivity(intent);
            }
        });
        binding.btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matkhau = binding.edtNhapmatkhau.getText().toString();
                String nhaplaimatkhau = binding.edtNhaplaimatkhau.getText().toString();
                String sodt = binding.edtNhapsdt.getText().toString();
                String tendangnhap = binding.edtNhaptentk.getText().toString();
                tentk=tendangnhap;
                sdt=sodt;
                //CHUYỀN SDT QUA TÊN, SDT
              //  Intent z =new Intent(dangky.this, sodienthoai.class);
             //   z.putExtra("sodienthoai",tendangnhap);

                //
                int dodaichuoi1 = matkhau.length();
                int dodaichuoi2 = nhaplaimatkhau.length();
                int dodaichuoi3 = sodt.length();
                int dodaichuoi4= tendangnhap.length();
                if(dodaichuoi1==0 || dodaichuoi2==0 || dodaichuoi3==0|| dodaichuoi4==0){
                    Toast.makeText(dangky.this, "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    String[] kituchuoi3 = sodt.split("");
                    int sokitutrong =0;
                    for (int m = 0; m<dodaichuoi3; m++){
                        if(kituchuoi3[m].equals(" ")){
                            sokitutrong ++;
                        }
                    }
                    if(sokitutrong > 0){
                        Toast.makeText(dangky.this, "Tên đăng nhập không được chứa kí tự trống", Toast.LENGTH_SHORT).show();
                    }else {
                        int count = 0, dif =0;
                        if(dodaichuoi1 == dodaichuoi2) {
                            if (dodaichuoi1 == 1) {
                                if (!matkhau.equals(nhaplaimatkhau)) {
                                    Toast.makeText(dangky.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                                }else {
                                    insertData(tendangnhap,sodt,matkhau);
                                    OTPVetification_Dialog_Dangky otpVetification_dialog_dangky = new OTPVetification_Dialog_Dangky(dangky.this, binding.edtNhapsdt.getText().toString());
                                    otpVetification_dialog_dangky.setCancelable(false);
                                    otpVetification_dialog_dangky.show();
                                }
                            } else {
                                String[] kituchuoi1 = matkhau.split("");
                                String[] kituchuoi2 = nhaplaimatkhau.split("");
                                for (int i = 0; i < dodaichuoi1; i++) {
                                    if (kituchuoi1[i].equals(" ")) {
                                        count++;
                                    }
                                    if (!kituchuoi1[i].equals(kituchuoi2[i])) {
                                        dif++;
                                    }
                                }
                                if (count == 0 && dif == 0) {
                                    if (!binding.cbDongydieukhoan.isChecked()) {
                                        Toast.makeText(dangky.this, "Bạn cần đồng ý với các điều khoản", Toast.LENGTH_SHORT).show();
                                    } else {
                                        //Hiện dialog nhập otp
                                        insertData(tendangnhap,sodt,matkhau);
                                        OTPVetification_Dialog_Dangky otpVetification_dialog_dangky = new OTPVetification_Dialog_Dangky(dangky.this, binding.edtNhapsdt.getText().toString());
                                        otpVetification_dialog_dangky.setCancelable(false);
                                        otpVetification_dialog_dangky.show();
                                        Toast.makeText(dangky.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();

//                                    Intent intent = new Intent(dangky.this, MainActivity.class);
//                                    startActivity(intent);
                                    }
                                } else if (count > 0) {
                                    Toast.makeText(dangky.this, "Mật khẩu không được chứa kí tự trống", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(dangky.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                                }
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
    //Chuyền data vào sql
    public void insertData(String tendangnhap,String sodt,String matkhau){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelperTaiKhoan.COL_NAME,tendangnhap);
        contentValues.put(DBHelperTaiKhoan.COL_PHONENUMBER,sodt);
        contentValues.put(DBHelperTaiKhoan.COL_PASSWORD,matkhau);
        long id = db.insert(DBHelperTaiKhoan.TBL_NAME,null,contentValues);
    }
}