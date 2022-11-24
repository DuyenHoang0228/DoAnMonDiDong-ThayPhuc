package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.nhom4.lilpawhome_application.databinding.ActivitySubHelp2Binding;

public class SubHelpActivity2 extends AppCompatActivity {
    ActivitySubHelp2Binding binding;
    String [] helpContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
         helpContent = getResources().getStringArray(R.array.helpContent);
        String helpTittle = intent.getStringExtra("helpTittle");
        binding.txtHelpTittle.setText(helpTittle);
        String cont = helpContent[index];
        binding.txtHelpContent.setText(cont);


    }

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