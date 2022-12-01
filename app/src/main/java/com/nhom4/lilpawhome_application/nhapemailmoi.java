package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    private void addEvents() {
        tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OTPVetification_Dialog_Email otpVetification_dialog_email= new OTPVetification_Dialog_Email(nhapemailmoi.this,email.getText().toString());
                otpVetification_dialog_email.setCancelable(false);
                otpVetification_dialog_email.show();
            }
        });
    }
}