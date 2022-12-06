package com.nhom4.lilpawhome_application;



import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class OTPVetification_Dialog_Dangky extends Dialog {
    private EditText otp1, otp2, otp3, otp4;
    private TextView resend;
    private Button xacnhan;
    private ImageButton thoat;
    private int resendTime = 30;
    private boolean resendEnable = false;
    private int selectedETPosition = 0;
    private final String sdttxt;
    public OTPVetification_Dialog_Dangky(@NonNull Context context, String sdt ) {
        super(context);
        this.sdttxt=sdt;
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(android.R.color.transparent)));
        setContentView(R.layout.dialog_nhapmaotpdangky);
        otp1 = findViewById(R.id.edt_otpdangky1);
        otp2 = findViewById(R.id.edt_otpdangky2);
        otp3 = findViewById(R.id.edt_otpdangky3);
        otp4 = findViewById(R.id.edt_otpdangky4);
        xacnhan = findViewById(R.id.btn_xacnhanotpdangky);
        resend = findViewById(R.id.txt_guilaiotpdangky);
        thoat = (ImageButton)findViewById(R.id.btn_exitotpdangky);
        final TextView sdt=findViewById(R.id.txt_dangkyotp);
        otp1.addTextChangedListener(textWatcher);
        otp2.addTextChangedListener(textWatcher);
        otp3.addTextChangedListener(textWatcher);
        otp4.addTextChangedListener(textWatcher);
        addEvent();
        showKeyboard(otp1);
        startcoundownTime();
        sdt.setText(sdttxt);
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (resendEnable) {
                    startcoundownTime();
                }
            }
        });
        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getOTP = otp1.getText().toString() + otp2.getText().toString() + otp3.getText().toString() + otp4.getText().toString();
                if (getOTP.length() == 4) {
                    Toast.makeText(view.getContext(), "Xác nhận mã OTP thành công!",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), thongbaodangkythanhcong.class);
                    view.getContext().startActivity(intent);
                     cancel();
                    }
                }
        });
}

    private void addEvent() {
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), dangky.class);
                view.getContext().startActivity(intent);

            }
        });
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                if (selectedETPosition == 0) {
                    selectedETPosition = 1;
                    showKeyboard(otp2);
                } else if (selectedETPosition == 1) {
                    selectedETPosition = 2;
                    showKeyboard(otp3);
                } else if (selectedETPosition == 2) {
                    selectedETPosition = 3;
                    showKeyboard(otp4);
                } else {
                    xacnhan.setBackgroundColor(R.drawable.customshapeborder);
                    xacnhan.setTextColor(getContext().getResources().getColor(R.color.white));
                    }
                }
            }

    };

    private void showKeyboard(EditText otp) {
        otp.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(otp, InputMethodManager.SHOW_IMPLICIT);
    }

    private void startcoundownTime() {
        resendEnable = false;
        new CountDownTimer(resendTime * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                resend.setText("Gửi lại mã OTP (" + millisUntilFinished / 1000 + ")");
            }

            @Override
            public void onFinish() {
                resendEnable = true;
                resend.setText("Gửi lại mã OTP");
                resend.setTextColor(getContext().getResources().getColor(R.color.FFA0CA));
            }
        }.start();
    }

    @Override
    public boolean onKeyUp(int keyCode, @NonNull KeyEvent event) {
        if (keyCode == event.KEYCODE_DEL) {
            if (selectedETPosition == 3) {
                selectedETPosition = 2;
                showKeyboard(otp3);
            }
            else if (selectedETPosition == 2) {
                selectedETPosition = 1;
                showKeyboard(otp2);
            }
            else if (selectedETPosition == 1) {
                selectedETPosition = 0;
                showKeyboard(otp1);
            }
            xacnhan.setBackgroundResource(R.drawable.customshapeborderpinkfillwhite);
            xacnhan.setTextColor(getContext().getResources().getColor(R.color.black));
            return true;
        } else {
            return super.onKeyUp(keyCode, event);
        }
    }
}
