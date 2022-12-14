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

public class nhapemailmoi extends AppCompatActivity {
    Button tieptuc;
    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_nhapemailmoi);
        tieptuc=findViewById(R.id.btn_tieptucemail);
        email=findViewById(R.id.edt_nhapemailmoi);
        addEvents();
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {case android.R.id.home: onBackPressed();
            return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void addEvents() {
        tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dodaichuoi1 = email.length();
                if(dodaichuoi1==0){
                    Toast.makeText(nhapemailmoi.this, "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    OTPVetification_Dialog_Email otpVetification_dialog_email= new OTPVetification_Dialog_Email(nhapemailmoi.this,email.getText().toString());
                    otpVetification_dialog_email.setCancelable(false);
                    otpVetification_dialog_email.show();

                    //CHUYỀN EMAIL MỚI QUA EMAIL
                    String emailmoi=email.getText().toString();
                    Intent z =new Intent(nhapemailmoi.this, email.class);
                    z.putExtra("emailmoi",emailmoi);
                }
            }
        });

    }
}