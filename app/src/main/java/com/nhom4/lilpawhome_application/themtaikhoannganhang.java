package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class themtaikhoannganhang extends AppCompatActivity {
String chonnganhang;
Button themtaikhoan;
TextView checkthongtin;
EditText tennganhang, tenchinhanh, sotaikhoan, tenchukhoan;
Spinner nganhangspinner;


ArrayAdapter<CharSequence> nganhangAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_themtaikhoannganhang);
        themtaikhoan=findViewById(R.id.btn_themtaikhoannganhang);
        tenchinhanh=findViewById(R.id.edt_tenchinhanh);
        sotaikhoan=findViewById(R.id.edt_sotaikhoan);
        tenchukhoan=findViewById(R.id.edt_tenchutaikhoan);
        checkthongtin=findViewById(R.id.txt_checkthongtin);
        //tennganhang=findViewById(R.id.edt_tennganhang);
        nganhangspinner=findViewById(R.id.spn_chonnganhang);
        nganhangAdapter= ArrayAdapter.createFromResource(this,R.array.array_nganhang, R.layout.spinnerlayout);

        addEvents();
        loadDB();
        //Spinner
       nganhangAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
      nganhangspinner.setAdapter(nganhangAdapter);

    }

    private void loadDB() {

    }

    private void addEvents() {
        themtaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int dodaichuoi1 = sotaikhoan.length();
                    int dodaichuoi2 = tenchukhoan.length();
                    int dodaichuoi3 = tenchinhanh.length();
                    if(dodaichuoi1==0 || dodaichuoi2==0 || dodaichuoi3==0){
                        Toast.makeText(themtaikhoannganhang.this, "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    }else {
                        String stk=sotaikhoan.getText().toString();
                        String tenck=tenchukhoan.getText().toString();
                        String chinhanh= tenchinhanh.getText().toString();
                        //    String nganhang=tennganhang.getText().toString();
                        String chonnh= nganhangspinner.getSelectedItem().toString();

                        //Chuyển dữ liệu qua thông tin nh
                        Intent z =new Intent(themtaikhoannganhang.this, thongtintaikhoannganhang.class);
                        z.putExtra("tenck",tenck);
                        z.putExtra("chinhanh",chinhanh);
                        z.putExtra("stk",stk);
                        z.putExtra("nganhang",chonnh);
                        startActivity(z);
                        Toast.makeText(themtaikhoannganhang.this, "Thêm tài khoản ngân hàng thành công!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
            }
        });

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

}