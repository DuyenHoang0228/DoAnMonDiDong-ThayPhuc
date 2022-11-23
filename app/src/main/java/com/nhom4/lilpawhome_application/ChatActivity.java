package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nhom4.adapters.ChatAdapter;
import com.nhom4.adapters.MessageAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityChatBinding;
import com.nhom4.lilpawhome_application.databinding.ActivityHelpBinding;
import com.nhom4.models.message;

import java.util.ArrayList;
import java.util.List;

import kotlin.contracts.Returns;

public class ChatActivity extends AppCompatActivity {
    ActivityChatBinding binding;
     ChatAdapter adapter;
     ArrayList<message> Listmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_chat);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initAdapter();
        addEvent();


    }

    private void initAdapter() {
        Listmessage = new ArrayList<>();
        addEvent();


    }


    private void addEvent() {
        binding.btnSendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message ms = new message(binding.edtChat.getText().toString());

                Listmessage.add(ms);

                binding.edtChat.setText("");
                adapter = new ChatAdapter(ChatActivity.this,R.layout.chat_list,Listmessage);

                binding.lvMessage.setAdapter(adapter);
            }
        });
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