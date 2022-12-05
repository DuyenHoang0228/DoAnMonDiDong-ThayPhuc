package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.databinding.ActivitySpa2Binding;
import com.nhom4.view.adapters.GioDatLichAdapter;

import java.util.Calendar;


public class SpaActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] address = {"669 Quốc Lộ 1A, quận Thủ Đức", "435 Dương Quảng Hàm, quận Gò Vấp"};
    Spinner spinner;
    ActivitySpa2Binding binding;
    String[] Time = {"7:30", "8:30","9:30","10:30","13:30","14:30", "15:30", "16:30"};
    String[] TinhTrang = {"0", "0", "1", "0", "1", "0", "0", "1"};
    GioDatLichAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_spa2);

        binding = ActivitySpa2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        spinner = findViewById(R.id.spinner_choncoso);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, address);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(ad);
        addEvent();
        loadData();
    }

    private void loadData() {
        adapter = new GioDatLichAdapter(SpaActivity2.this, R.layout.giohen_layout, Time, TinhTrang);
        binding.gvDatlich.setAdapter(adapter);
    }

    private void addEvent() {
        binding.btnXacnhandatlich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SpaActivity2.this, "Đặt lịch thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SpaActivity2.this, DSLichhenActivity.class);
                startActivity(intent);
            }
        });
        binding.imvQuaylaispa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.txtNgaydatlich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(SpaActivity2.this);
                dialog.setContentView(R.layout.dialog_chonngaydatlich);

                Button btnChonNgay = dialog.findViewById(R.id.btn_chonngay);
                DatePicker dpChonNgayDatLich = dialog.findViewById(R.id.dp_chonngaydatlich);

                btnChonNgay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int year = dpChonNgayDatLich.getYear();
                        int month = dpChonNgayDatLich.getMonth();
                        int day = dpChonNgayDatLich.getDayOfMonth();
                        Toast.makeText(SpaActivity2.this, "Bạn đã chọn ngày: " + day+"-"+ (month + 1) +"-"+ year, Toast.LENGTH_LONG).show();
                        binding.txtNgaydatlich.setText(day+"-"+ (month + 1) +"-"+ year);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}