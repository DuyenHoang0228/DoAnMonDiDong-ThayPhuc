package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.databinding.ActivitySpa2Binding;
import com.nhom4.models.LichHen;


public class SpaActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] address = {"669 Quốc Lộ 1A, quận Thủ Đức", "435 Dương Quảng Hàm, quận Gò Vấp"};
    Spinner spinner;
    ActivitySpa2Binding binding;
    String dichvu, thucung, giong, coso, date, gio="";
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
        //0 la chua dat
        //1 la da dat
        //2 la chon tam thoi
        if(MainActivity.TinhTrang[0]=="0") {
            binding.btn730.setBackgroundColor(Color.parseColor("#FFA0CA"));
        }else if(MainActivity.TinhTrang[0] == "1") {
            binding.btn730.setBackgroundColor(Color.parseColor("#D9D9D9"));
        }else{
            binding.btn730.setBackgroundColor(Color.parseColor("#FF2E8A"));
        }
        if(MainActivity.TinhTrang[1]=="0") {
            binding.btn830.setBackgroundColor(Color.parseColor("#FFA0CA"));
        }else if(MainActivity.TinhTrang[1] == "1") {
            binding.btn830.setBackgroundColor(Color.parseColor("#D9D9D9"));
        }else{
            binding.btn830.setBackgroundColor(Color.parseColor("#FF2E8A"));
        }
        if(MainActivity.TinhTrang[2]=="0") {
            binding.btn930.setBackgroundColor(Color.parseColor("#FFA0CA"));
        }else if(MainActivity.TinhTrang[2] == "1") {
            binding.btn930.setBackgroundColor(Color.parseColor("#D9D9D9"));
        }else{
            binding.btn930.setBackgroundColor(Color.parseColor("#FF2E8A"));
        }
        if(MainActivity.TinhTrang[3]=="0") {
            binding.btn1030.setBackgroundColor(Color.parseColor("#FFA0CA"));
        }else if(MainActivity.TinhTrang[3] == "1") {
            binding.btn1030.setBackgroundColor(Color.parseColor("#D9D9D9"));
        }else{
            binding.btn1030.setBackgroundColor(Color.parseColor("#FF2E8A"));
        }
        if(MainActivity.TinhTrang[4]=="0") {
            binding.btn1330.setBackgroundColor(Color.parseColor("#FFA0CA"));
        }else if(MainActivity.TinhTrang[4] == "1") {
            binding.btn1330.setBackgroundColor(Color.parseColor("#D9D9D9"));
        }else{
            binding.btn1330.setBackgroundColor(Color.parseColor("#FF2E8A"));
        }
        if(MainActivity.TinhTrang[5]=="0") {
            binding.btn1430.setBackgroundColor(Color.parseColor("#FFA0CA"));
        }else if(MainActivity.TinhTrang[5] == "1") {
            binding.btn1430.setBackgroundColor(Color.parseColor("#D9D9D9"));
        }else{
            binding.btn1430.setBackgroundColor(Color.parseColor("#FF2E8A"));
        }
        if(MainActivity.TinhTrang[6]=="0") {
            binding.btn1530.setBackgroundColor(Color.parseColor("#FFA0CA"));
        }else if(MainActivity.TinhTrang[6] == "1") {
            binding.btn1530.setBackgroundColor(Color.parseColor("#D9D9D9"));
        }else{
            binding.btn1530.setBackgroundColor(Color.parseColor("#FF2E8A"));
        }if(MainActivity.TinhTrang[7]=="0") {
            binding.btn1630.setBackgroundColor(Color.parseColor("#FFA0CA"));
        }else if(MainActivity.TinhTrang[7] == "1") {
            binding.btn1630.setBackgroundColor(Color.parseColor("#D9D9D9"));
        }else {
            binding.btn1630.setBackgroundColor(Color.parseColor("#FF2E8A"));
        }
    }
    private void creatLichHen(){
        dichvu = "";
        if(binding.cbTamvesinh.isChecked()){
            dichvu = binding.cbTamvesinh.getText().toString();
        }
        if(binding.cbCattialong.isChecked()){
            dichvu = dichvu + " \n " + binding.cbCattialong.getText().toString();
        }
        if(binding.cbDuonglong.isChecked()){
            dichvu = dichvu + " \n " +binding.cbDuonglong.getText().toString();
        }
        if(binding.cbTamvesinh.isChecked()) {
            dichvu = dichvu + " \n " + binding.cbDuonglong.getText().toString();
        }
        if(dichvu=="") {
            Toast.makeText(SpaActivity2.this, "Bạn chưa chọn dịch vụ", Toast.LENGTH_SHORT).show();
        }else {
            if(binding.txtNgaydatlich.getText().toString().equals("Chọn ngày")){
                Toast.makeText(this, "Bạn chưa chọn ngày", Toast.LENGTH_SHORT).show();
            }else {
                date = binding.txtNgaydatlich.getText().toString();
                if(gio.equals("")){
                    Toast.makeText(this, "Bạn chưa chọn giờ", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = getIntent();
                    thucung = intent.getStringExtra("ThuCung");
                    giong = intent.getStringExtra("giong");
                    String cannang = intent.getStringExtra("cannang");
                    String gioitinh = intent.getStringExtra("gioitinh");
                    coso = binding.spinnerChoncoso.getSelectedItem().toString();
                    MainActivity.lichhenST.add(new LichHen("Dịch vụ: " + dichvu,"Thú cưng: " + thucung,"Giống: " + giong, "Cơ sở: " + coso,date,gio));
                    for(int j = 0; j<8; j++){
                        //đổi tình trạng chọn tạm thời sang đã được đặt
                        if(MainActivity.TinhTrang[j]=="2"){
                            MainActivity.TinhTrang[j]="1";
                        }
                    }
                    loadData();
                    Toast.makeText(this, "Đặt lịch thành công", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(SpaActivity2.this, DSLichhenActivity.class);
                    intent1.putExtra("gioitinh",gioitinh);
                    intent1.putExtra("cannang",cannang);
                    startActivity(intent1);
                }
            }
        }


    }
    private void addEvent() {
        binding.btn730.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int j =0; j<8; j++){
                    if(j!=0 && MainActivity.TinhTrang[j]=="2"){
                        MainActivity.TinhTrang[j] = "0";
                    }
                }
                if(MainActivity.TinhTrang[0]=="1"){
                    Toast.makeText(SpaActivity2.this, "Bạn hãy chọn giờ khác", Toast.LENGTH_SHORT).show();
                }else {
                    MainActivity.TinhTrang[0] ="2";
                    gio = "7:30";
                    loadData();
                }
            }

        });
        binding.btn830.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int j =0; j<8; j++){
                    if(j!=1 && MainActivity.TinhTrang[j]=="2"){
                        MainActivity.TinhTrang[j] = "0";
                    }
                }
                if(MainActivity.TinhTrang[1]=="1"){
                    Toast.makeText(SpaActivity2.this, "Bạn hãy chọn giờ khác", Toast.LENGTH_SHORT).show();
                }else {
                    MainActivity.TinhTrang[1] ="2";
                    gio = "8:30";
                    loadData();
                }
            }
        });
        binding.btn930.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int j =0; j<8; j++){
                    if(j!=2 && MainActivity.TinhTrang[j]=="2"){
                        MainActivity.TinhTrang[j] = "0";
                    }
                }
                if(MainActivity.TinhTrang[2]=="1"){
                    Toast.makeText(SpaActivity2.this, "Bạn hãy chọn giờ khác", Toast.LENGTH_SHORT).show();
                }else {
                    MainActivity.TinhTrang[2] ="2";
                    gio = "9:30";
                    loadData();
                }
            }
        });
        binding.btn1030.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int j =0; j<8; j++){
                    if(j!=3 && MainActivity.TinhTrang[j]=="2"){
                        MainActivity.TinhTrang[j] = "0";
                    }
                }
                if(MainActivity.TinhTrang[3]=="1"){
                    Toast.makeText(SpaActivity2.this, "Bạn hãy chọn giờ khác", Toast.LENGTH_SHORT).show();
                }else {
                    MainActivity.TinhTrang[3] ="2";
                    gio = "10:30";
                    loadData();
                }
            }
        });
        binding.btn1330.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int j =0; j<8; j++){
                    if(j!=4 && MainActivity.TinhTrang[j]=="2"){
                        MainActivity.TinhTrang[j] = "0";
                    }
                }
                if(MainActivity.TinhTrang[4]=="1"){
                    Toast.makeText(SpaActivity2.this, "Bạn hãy chọn giờ khác", Toast.LENGTH_SHORT).show();
                }else {
                    MainActivity.TinhTrang[4] = "2";
                    gio = "13:30";
                    loadData();
                }
            }
        });
        binding.btn1430.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int j =0; j<8; j++){
                    if(j!=5 && MainActivity.TinhTrang[j]=="2"){
                        MainActivity.TinhTrang[j] = "0";
                    }
                }
                if(MainActivity.TinhTrang[5]=="1"){
                    Toast.makeText(SpaActivity2.this, "Bạn hãy chọn giờ khác", Toast.LENGTH_SHORT).show();
                }else {
                    MainActivity.TinhTrang[5] = "2";
                    gio = "14:30";
                    loadData();
                }
            }
        });
        binding.btn1530.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int j =0; j<8; j++){
                    if(j!=6 && MainActivity.TinhTrang[j]=="2"){
                        MainActivity.TinhTrang[j] = "0";
                    }
                }
                if(MainActivity.TinhTrang[6]=="1"){
                    Toast.makeText(SpaActivity2.this, "Bạn hãy chọn giờ khác", Toast.LENGTH_SHORT).show();
                }else {
                    MainActivity.TinhTrang[6] = "2";
                    gio = "15:30";
                    loadData();
                }
            }
        });
        binding.btn1630.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int j =0; j<8; j++){
                    if(j!=7 && MainActivity.TinhTrang[j]=="2"){
                        MainActivity.TinhTrang[j] = "0";
                    }
                }
                if(MainActivity.TinhTrang[7]=="1"){
                    Toast.makeText(SpaActivity2.this, "Bạn hãy chọn giờ khác", Toast.LENGTH_SHORT).show();
                }else {
                    MainActivity.TinhTrang[7] = "2";
                    gio = "16:30";
                    loadData();
                }
            }
        });
        binding.btnXacnhandatlich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creatLichHen();
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
                        binding.txtNgaydatlich.setText(day +"-"+ (month + 1) +"-"+ year);
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