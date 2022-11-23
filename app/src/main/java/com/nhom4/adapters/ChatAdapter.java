package com.nhom4.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.TroGIup;
import com.nhom4.models.message;

import java.util.List;

public class ChatAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<message> messages ;

    public ChatAdapter(Activity activity, int item_layout, List<message> messages) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.messages = messages;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout,null);
            holder.txtMessage = view.findViewById(R.id.txt_message);

            view.setTag(holder);


        } else {
            holder = (ViewHolder) view.getTag();


        }
        //binding data
        message ms= messages.get(i);

        holder.txtMessage.setText(ms.getMessage());

        return view;
        //return null;
    }

    public static class ViewHolder {

        TextView txtMessage;
    }
}
