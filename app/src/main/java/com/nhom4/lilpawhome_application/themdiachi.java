package com.nhom4.lilpawhome_application;

import static com.nhom4.lilpawhome_application.Utils_Diachi.COL_DUONG;
import static com.nhom4.lilpawhome_application.Utils_Diachi.COL_MacDinh;
import static com.nhom4.lilpawhome_application.Utils_Diachi.COL_PHONE;
import static com.nhom4.lilpawhome_application.Utils_Diachi.COL_PHUONG;
import static com.nhom4.lilpawhome_application.Utils_Diachi.COL_QUAN;
import static com.nhom4.lilpawhome_application.Utils_Diachi.COL_TINH;
import static com.nhom4.lilpawhome_application.Utils_Diachi.COL_TYPE;
import static com.nhom4.lilpawhome_application.Utils_Diachi.DB_NAME;
import static com.nhom4.lilpawhome_application.Utils_Diachi.TBL_NAME;
import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.nhom4.view.adapters.diachiAdapter;

//import com.nhom4.lilpawhome_application.databinding.ActivityThemdiachiBinding;

public class themdiachi extends AppCompatActivity {
//ActivityThemdiachiBinding binding;
    String chonquanhuyen, chontinh;
    Button themdiachi;
    diachiAdapter adapter;
    public static SQLiteDatabase db;
    EditText hovaten, sdt, phuong, duong;
    Spinner tinhspinner,quanhuyenspinner;
    RadioButton office, home;
    CheckBox macdinh;
    ArrayAdapter<CharSequence> tinhAdapter,quanhuyenAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_themdiachi);
      //  binding = ActivityThemdiachiBinding.inflate(getLayoutInflater());
      //  setContentView(binding.getRoot());
        //Ánh xạ
        tinhspinner=findViewById(R.id.spn_tinhtdc);
        quanhuyenspinner=findViewById(R.id.spn_quanhuyentdc);
        sdt = findViewById(R.id.edt_sodienthoai);
        hovaten = findViewById(R.id.edt_hovaten);
        phuong = findViewById(R.id.edt_tinhquanphuong);
        duong = findViewById(R.id.edt_duongnha);
        office = findViewById(R.id.rad_office);
        home = findViewById(R.id.rad_home);
        macdinh = findViewById(R.id.chk_defaultaddress);

        tinhAdapter= ArrayAdapter.createFromResource(this,R.array.array_tinh, R.layout.spinnerlayout);
        addEvents();
        addToDB();
    }

    private void addToDB() {
        themdiachi= findViewById(R.id.btn_hoanthanh);
        themdiachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertDB();
                finish();
                Toast.makeText(themdiachi.this, "Thêm địa chỉ thành công!", Toast.LENGTH_SHORT).show();
            }

            private void insertDB() {
                db = openOrCreateDatabase(DB_NAME, MODE_PRIVATE,null);
                ContentValues values = new ContentValues();
                values.put(Utils_Diachi.COL_NAME, hovaten.getText().toString());
                values.put(COL_PHONE, sdt.getText().toString());
                values.put(COL_TINH, tinhspinner.getSelectedItem().toString());
                values.put(COL_QUAN, quanhuyenspinner.getSelectedItem().toString());
                values.put(COL_PHUONG, phuong.getText().toString());
                values.put(COL_DUONG, duong.getText().toString());
                int type = 1;
                int MacDinh = 0;

                if (office.isChecked()) {
                    type = 0;
                }
                if (macdinh.isChecked()){
                    MacDinh = 1;
                }

                values.put(COL_TYPE, type);
                values.put(COL_MacDinh, MacDinh);
                long newRow = db.insert(TBL_NAME, null, values);
            }
        });
    }


    private void addEvents() {
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
                    quanhuyenspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            chonquanhuyen=quanhuyenspinner.getSelectedItem().toString();
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