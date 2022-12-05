package com.nhom4.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.R;

public class GioDatLichAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    String[] Time;
    String[] TinhTrang;

    public GioDatLichAdapter(Activity activity, int item_layout, String[] time, String[] tinhTrang) {
        this.activity = activity;
        this.item_layout = item_layout;
        Time = time;
        TinhTrang = tinhTrang;
    }

    @Override
    public int getCount() {
        return Time.length;
    }

    @Override
    public Object getItem(int i) {
        return Time[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder=new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.btnGioDatLich = view.findViewById(R.id.btn_giodatlich);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.btnGioDatLich.setText(Time[i]);
        if(TinhTrang[i]=="1"){
            holder.btnGioDatLich.setBackgroundColor(Color.parseColor("#D9D9D9"));
        }else {
            holder.btnGioDatLich.setBackgroundColor(Color.parseColor("#FFA0CA"));
        }
        return view;
    }
    public static class ViewHolder{
        TextView btnGioDatLich;
    }
}
