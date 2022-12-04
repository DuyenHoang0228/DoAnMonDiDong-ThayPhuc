package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class nhaplaimatkhau extends AppCompatActivity {
    Button tieptuc;
    EditText nhapmatkhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_nhaplaimatkhau);
        tieptuc=findViewById(R.id.btn_tieptucmatkhau);
        nhapmatkhau=findViewById(R.id.edt_nhapmatkhauhientai);
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
        tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nhapmk = nhapmatkhau.getText().toString();
                int dodaichuoi1 = nhapmk.length();
                if(dodaichuoi1==0){
                    Toast.makeText(nhaplaimatkhau.this, "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(nhaplaimatkhau.this, datlaimatkhau.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}