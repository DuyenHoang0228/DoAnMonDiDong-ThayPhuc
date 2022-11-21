package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nhom4.lilpawhome_application.databinding.ActivitySubHelp2Binding;

public class SubHelpActivity2 extends AppCompatActivity {
    ActivitySubHelp2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sub_help2);
        binding = ActivitySubHelp2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        showData();
    }

    private void showData() {
        Intent intent = getIntent();
        int index = intent.getIntExtra("index",0);
        String helpContent = "R.string.help_content"+index;
        String helpTittle = intent.getStringExtra("helpTittle");
        binding.txtHelpTittle.setText(helpTittle);
        binding.txtHelpContent.setText(R.string.help_conten1);


    }
}