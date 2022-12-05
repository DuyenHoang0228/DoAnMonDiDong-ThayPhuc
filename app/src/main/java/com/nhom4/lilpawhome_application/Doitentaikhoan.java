package com.nhom4.lilpawhome_application;



import static com.nhom4.lilpawhome_application.dangky.tentk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nhom4.databases.DBHelperTaiKhoan;
import com.nhom4.lilpawhome_application.databinding.ActivityDoitentaikhoanBinding;

import java.text.BreakIterator;

public class Doitentaikhoan extends AppCompatActivity {
ActivityDoitentaikhoanBinding binding;

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoitentaikhoanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // setContentView(R.layout.activity_doitentaikhoan);
        addEvents();
        EditText tentaik=findViewById(R.id.edt_tenhientai);
        tentaik.setText(tentk);

       openHelper = new DBHelperTaiKhoan(this);
       db = openHelper.getWritableDatabase();
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
        binding.btnThaydoiten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String sdt=dangky.sdt;
               String tenhientai= binding.edtTenhientai.getText().toString();
                //Intent z =new Intent(Doitentaikhoan.this, taikhoanvabaomat.class);
               // z.putExtra("doiten",tenhientai);
                //startActivity(z);

                db.execSQL("UPDATE "+DBHelperTaiKhoan.TBL_NAME+ " SET " +
                             DBHelperTaiKhoan.COL_NAME + " = '"+ tenhientai + "'"+
                        " WHERE " + DBHelperTaiKhoan.COL_PHONENUMBER + "= '"+ sdt+"'");
                finish();
                Toast.makeText(Doitentaikhoan.this, "Tên tài khoản đã thay đổi!", Toast.LENGTH_SHORT).show();
               // Intent intent = new Intent(Doitentaikhoan.this, taikhoanvabaomat.class);
               // startActivity(intent);
            }
        });
    }
}