package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.nhom4.lilpawhome_application.databinding.ActivityDanhmucBinding;

public class DanhmucActivity extends AppCompatActivity {
    ActivityDanhmucBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhmuc);


        binding=ActivityDanhmucBinding.inflate(getLayoutInflater());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custon_actionbar_danhmuc);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#ffffff")));
        setContentView(binding.getRoot());

        addEvent();
    }

    private void addEvent() {

    }


}
