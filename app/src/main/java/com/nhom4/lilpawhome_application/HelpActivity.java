package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.nhom4.view.adapters.HelpAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityHelpBinding;
import com.nhom4.models.TroGIup;

import java.util.ArrayList;

public class HelpActivity extends AppCompatActivity {

    ActivityHelpBinding binding;
    HelpAdapter adapter;
    ArrayList<TroGIup> trogiup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_help);
        binding = ActivityHelpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        loadData();
        addEvent();
    }

    private void addEvent() {
        binding.lvHelp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HelpActivity.this, SubHelpActivity2.class);

                intent.putExtra("helpTittle",trogiup.get(i).getTieudeTroGiup());
                intent.putExtra("index",i);



                startActivity(intent);
            }
        });
    }

    private void loadData() {
        trogiup = new ArrayList<>();

        trogiup.add(new TroGIup("Hướng dẫn đặt hàng",""));
        trogiup.add(new TroGIup("Phương thức thanh toán",""));
        trogiup.add(new TroGIup("Quy định đổi trả sản phẩm",""));
        trogiup.add(new TroGIup("Chính sách giao hàng",""));
        trogiup.add(new TroGIup("Chính sách bảo vệ thông tin người tiêu dùng",""));

        adapter = new HelpAdapter(HelpActivity.this,R.layout.help_list,trogiup);
        binding.lvHelp.setAdapter(adapter);

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