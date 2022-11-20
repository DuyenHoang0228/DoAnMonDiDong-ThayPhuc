package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nhom4.adapters.MessageAdapter;
import com.nhom4.models.message;

import java.util.ArrayList;
import java.util.List;

import kotlin.contracts.Returns;

public class ChatActivity extends AppCompatActivity {
     RecyclerView rcvchat;
     EditText edMessage;
     Button btnSend;
     MessageAdapter messageAdapter;
     List<message> Listmessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        edMessage = findViewById(R.id.edt_chat);
        btnSend = findViewById(R.id.btn_sendmessage);
        rcvchat = findViewById(R.id.rcv_message);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvchat.setLayoutManager(linearLayoutManager);

        Listmessage = new ArrayList<>();
        messageAdapter= new MessageAdapter();
        messageAdapter.setData(Listmessage);

        rcvchat.setAdapter(messageAdapter);

        addEvent();

    }

    private void addEvent() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendmess();
            }
        });
    }

    private void sendmess() {
        String strMess = edMessage.getText().toString().trim();
        if ( TextUtils.isEmpty(strMess))
        {
            return;
        }
        Listmessage.add((new message(strMess)));
        messageAdapter.notifyDataSetChanged();
        rcvchat.scrollToPosition(Listmessage.size() - 1);
        edMessage.setText("");
    }
}