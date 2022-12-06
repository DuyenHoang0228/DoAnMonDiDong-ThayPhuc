package com.nhom4.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.HosoChoDetailActivity;
import com.nhom4.lilpawhome_application.HosoMeoDetailActivity;
import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.HoSo;
import com.nhom4.models.ThuCung;

import java.util.ArrayList;
import java.util.List;

public class AdapterChonHoso extends BaseAdapter {

    List<HoSo> hoSoList;
    Activity activity;
    int item_layout;

    public AdapterChonHoso(List<HoSo> hoSoList, Activity activity, int item_layout) {
        this.hoSoList = hoSoList;
        this.activity = activity;
        this.item_layout = item_layout;
    }

    @Override
    public int getCount() {
        return hoSoList.size();
    }

    @Override
    public Object getItem(int i) {
        return hoSoList.get(i);
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
            view = inflater.inflate(item_layout, null);

            holder.txtbecung = view.findViewById(R.id.txt_becung);
            view.setTag(holder);

        }else {
            holder = (ViewHolder) view.getTag();
        }
        HoSo h = hoSoList.get(i);
        holder.txtbecung.setText(h.getBecung());

        return view;
    }


   public static class ViewHolder{
        TextView txtbecung;
   }
}
