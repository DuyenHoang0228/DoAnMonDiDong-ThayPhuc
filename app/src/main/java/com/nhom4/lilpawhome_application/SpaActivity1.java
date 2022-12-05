package com.nhom4.lilpawhome_application;

import static com.nhom4.lilpawhome_application.Utils_Spa.DB_NAME;
import static com.nhom4.lilpawhome_application.Utils_Spa.DB_PATH_SUFFIX;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;

import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.databinding.ActivitySpa1Binding;
import com.nhom4.models.ThuCung;
import android.text.style.UnderlineSpan;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class SpaActivity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // create array of Strings
    // and store name of courses
    Spinner spinner;
    TextView banggia;
    ActivitySpa1Binding binding;
    ArrayAdapter<String> adapter;
    ArrayList<ThuCung> thuCungs;
    public SQLiteDatabase db;
    ArrayList<String> Petname, Species;
    ArrayList<Integer> Pettype, Gender;
    ArrayList<Double> Weight;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_spa1);
        binding = ActivitySpa1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Underline
        banggia = findViewById(R.id.txt_banggiathamkhao);
        String banggiaS = banggia.getText().toString();
        SpannableString s = new SpannableString(banggiaS);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        s.setSpan(underlineSpan, 0,18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        banggia.setText(s);
        copyDB();
        addEvent();
        //Intent button

        //Dialog bảng giá
        banggia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialog(Gravity.BOTTOM);
            }
        });
    }

    private void addEvent() {
        binding.imvQuaylaispa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SpaActivity1.this, SpaActivity2.class);
                startActivity(intent);
            }
        });
    }

    //Dalog xuất hiện phía dưới, gắn sự kiến bấm ra ngoài mh là mất dialog
    private void openDialog(int gravity){
        final Dialog dialog = new Dialog(SpaActivity1.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_banggia);
        dialog.show();

        Window window = dialog.getWindow();
        if(window==null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity=gravity;
        window.setAttributes(windowAttributes);

        if (Gravity.BOTTOM==gravity){
            dialog.setCancelable(true);
        }
    }

    private void loadData() {
        Petname = new ArrayList<>();
        Pettype = new ArrayList<>();
        Species = new ArrayList<>();
        Gender = new ArrayList<>();
        thuCungs = new ArrayList<>();
        Weight = new ArrayList<>();
        db = openOrCreateDatabase(DB_NAME, MODE_PRIVATE,null);

        Cursor c = db.query(Utils_Spa.TBL_NAME, null,null,
                null,null,null,null);
        while (c.moveToNext()){
            thuCungs.add(new ThuCung(c.getInt(0), c.getString(1), c.getInt(2), c.getInt(3), c.getString(4), c.getDouble(5)));
        }
        c.close();
//        Tạo list và chạy vòng lặp để lấy mỗi tên thú cưng trong db
        createvars();
        Petname.add("Khác");
        adapter = new ArrayAdapter<String>(SpaActivity1.this, android.R.layout.simple_spinner_item, Petname);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerChonthucung.setOnItemSelectedListener(this);
        binding.spinnerChonthucung.setAdapter(adapter);
    }

    private void createvars() {
        for (ThuCung item : thuCungs) {
            Petname.add(item.getPetname());
        }
        for (ThuCung item : thuCungs) {
            Pettype.add(item.getPettype());
        }
        for (ThuCung item : thuCungs) {
            Species.add(item.getSpecies());
        }
        for (ThuCung item : thuCungs) {
            Gender.add(item.getGender());
        }
        for (ThuCung item : thuCungs) {
            Weight.add(item.getWeight());
        }
    }

    // Performing action when ItemSelected
    // from spinner, Overriding onItemSelected method

    private void copyDB() {
        File dbPath = getDatabasePath(DB_NAME);
        if(!dbPath.exists()) {
            if(copyDBFromAssets()){
                Toast.makeText(SpaActivity1.this,
                        "Copy database successful!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(SpaActivity1.this, "Copy database fail!", Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean copyDBFromAssets() {
        String dbPath = getApplicationInfo().dataDir + DB_PATH_SUFFIX + DB_NAME;

        //Directory database in folder assets

        try {
            InputStream inputStream = getAssets().open(DB_NAME);
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists()){
                f.mkdir();
            }
            OutputStream outputStream = new FileOutputStream(dbPath);
            byte[] buffer = new byte[1024]; int length;
            while ((length=inputStream.read(buffer))>0){
                outputStream.write(buffer,0,length);
            }
            outputStream.flush(); outputStream.close(); inputStream.close();
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    protected void onResume() {
        loadData();
        super.onResume();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),
                        Petname.get(position),
                        Toast.LENGTH_LONG)
                .show();
        if (Petname.get(position).toString() != "Khác") {
            String species = Species.get(position).toString();
            Integer pettype = Pettype.get(position);
            Integer gender = Gender.get(position);
            Double weight = Weight.get(position).doubleValue();
            binding.edtGiongchomeo.setText(species);
            binding.edtCannang.setText(String.valueOf(weight));
            switch (pettype) {
                case 0:
                    binding.rbtnCho.setChecked(true);
                    break;
                case 1:
                    binding.rbtnMeo.setChecked(true);
                    break;
            }
            switch (gender) {
                case 0:
                    binding.rbtnDuc.setChecked(true);
                    break;
                case 1:
                    binding.rbtnCai.setChecked(true);
                    break;
            }
        } else {
            binding.edtGiongchomeo.getText().clear();
            binding.edtCannang.getText().clear();
            binding.rbtnMeo.setChecked(false);
            binding.rbtnCho.setChecked(false);
            binding.rbtnDuc.setChecked(false);
            binding.rbtnCai.setChecked(false);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

}