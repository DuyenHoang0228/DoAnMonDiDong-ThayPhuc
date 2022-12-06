package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.nhom4.view.adapters.ChatAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityChatBinding;
import com.nhom4.models.message;

import java.util.ArrayList;

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
        addEvent();
        Listmessage = new ArrayList<>();
        adapter = new ChatAdapter(ChatActivity.this,R.layout.chat_list,Listmessage);

    }

    private void addEvent() {
        binding.btnSendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message ms = new message(binding.edtChat.getText().toString());
                if(!ms.getMessage().equals("")){
                    Listmessage.add(ms);
                    binding.edtChat.setText("");
                    binding.lvMessage.setAdapter(adapter);
                }else {
                    Toast.makeText(ChatActivity.this, "Hãy nhập thắc mắc của bạn", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


   public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {case android.R.id.home: onBackPressed();
            return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}
