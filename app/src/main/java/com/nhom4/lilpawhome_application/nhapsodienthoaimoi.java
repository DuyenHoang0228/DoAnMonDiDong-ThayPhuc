package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class nhapsodienthoaimoi extends AppCompatActivity {
   Button tieptuc;
   EditText sdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_nhapsodienthoaimoi);
        tieptuc=findViewById(R.id.btn_tieptucsdt);
        sdt=findViewById(R.id.edt_nhapsodienthoaimoi);
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
                int dodaichuoi1 = sdt.length();
                if(dodaichuoi1==0){
                    Toast.makeText(nhapsodienthoaimoi.this, "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    OTPVetification_Dialog_Sdt otpVetification_dialog_sdt= new OTPVetification_Dialog_Sdt(nhapsodienthoaimoi.this,sdt.getText().toString());
                    otpVetification_dialog_sdt.setCancelable(false);
                    otpVetification_dialog_sdt.show();
                }

            }
        });

    }
}