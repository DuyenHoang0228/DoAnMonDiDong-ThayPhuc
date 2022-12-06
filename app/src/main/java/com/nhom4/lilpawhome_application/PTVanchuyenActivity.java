package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nhom4.lilpawhome_application.databinding.ActivityPtvanchuyenBinding;

public class PTVanchuyenActivity extends AppCompatActivity {

    ActivityPtvanchuyenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ptvanchuyen);
        binding = ActivityPtvanchuyenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.itemVanchuyennhanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("Hinhthuc", binding.txtVanchuyennhanh.getText().toString());
                bundle.putString("Gia", binding.txtGiavanchuyennhanh.getText().toString());
                bundle.putString("Ngaygiao", binding.txtNgaynhanhangnhanh.getText().toString());
                intent.putExtras(bundle);
                intent.setAction("fromVanchuyen");
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
        binding.itemVanchuyentietkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("Hinhthuc", binding.txtVanchuyentietkiem.getText().toString());
                bundle.putString("Gia", binding.txtGiavanchuyentietkiem.getText().toString());
                bundle.putString("Ngaygiao", binding.txtNgaynhanhangtietkiem.getText().toString());
                intent.putExtras(bundle);
                intent.setAction("fromVanchuyen");
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}