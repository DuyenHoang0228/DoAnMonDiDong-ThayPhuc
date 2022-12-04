package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

//import com.nhom4.lilpawhome_application.databinding.ActivityThemdiachiBinding;

public class themdiachi extends AppCompatActivity {
//ActivityThemdiachiBinding binding;
    String chonquanhuyen, chontinh;
    Button themdiachi;
    EditText sdt;
    Spinner tinhspinner,quanhuyenspinner;
    ArrayAdapter<CharSequence> tinhAdapter,quanhuyenAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_themdiachi);
      //  binding = ActivityThemdiachiBinding.inflate(getLayoutInflater());
      //  setContentView(binding.getRoot());
        tinhspinner=findViewById(R.id.spn_tinhtdc);
        quanhuyenspinner=findViewById(R.id.spn_quanhuyentdc);
        sdt = findViewById(R.id.edt_sodienthoai);
        tinhAdapter= ArrayAdapter.createFromResource(this,R.array.array_tinh, R.layout.spinnerlayout);
        addEvents();
    }



    private void addEvents() {
        themdiachi= findViewById(R.id.btn_hoanthanh);
        themdiachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(themdiachi.this, thietlaptaikhoan.class);
                startActivity(intent);
                Toast.makeText(themdiachi.this, "Thêm địa chỉ thành công!", Toast.LENGTH_SHORT).show();
            }
        });
        tinhAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        tinhspinner.setAdapter(tinhAdapter);

        tinhspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                chontinh= tinhspinner.getSelectedItem().toString();
                int parentId = adapterView.getId();
                if(parentId==R.id.spn_tinhtdc){
                    switch (chontinh){
                        case "Chọn tỉnh": quanhuyenAdapter=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.array_default_quanhuyen, R.layout.spinnerlayout);
                        break;
                        case "Hà Nội": quanhuyenAdapter=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.array_hanoi, R.layout.spinnerlayout);
                        break;
                        case "TP Hồ Chí Minh": quanhuyenAdapter=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.array_hcm, R.layout.spinnerlayout);
                            break;
                        case "An Giang": quanhuyenAdapter=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.array_angiang, R.layout.spinnerlayout);
                            break;
                        case "Bình Định": quanhuyenAdapter=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.array_binhdinh, R.layout.spinnerlayout);
                            break;
                        case "Bình Dương": quanhuyenAdapter=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.array_binhduong, R.layout.spinnerlayout);
                            break;
                        case "Quảng Bình": quanhuyenAdapter=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.array_quangbinh, R.layout.spinnerlayout);
                            break;
                        case "Quảng Nam": quanhuyenAdapter=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.array_quangnam, R.layout.spinnerlayout);
                            break;
                        case "Quảng Ngãi": quanhuyenAdapter=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.array_quangngai, R.layout.spinnerlayout);
                            break;
                        case "Bình Thuận": quanhuyenAdapter=ArrayAdapter.createFromResource(adapterView.getContext(),R.array.array_binhthuan, R.layout.spinnerlayout);
                            break;
                        default:break;
                    }
                    quanhuyenAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    quanhuyenspinner.setAdapter(quanhuyenAdapter);
                    tinhspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            chonquanhuyen= quanhuyenspinner.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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