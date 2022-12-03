package com.nhom4.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.DanhMuc1;

import java.util.List;

public class Danhmuc1Adapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<DanhMuc1> Danhmuc;

    public Danhmuc1Adapter(Activity activity, int item_layout, List<DanhMuc1> danhmuc) {
        this.activity = activity;
        this.item_layout = item_layout;
        Danhmuc = danhmuc;
    }

    @Override
    public int getCount() {
        return Danhmuc.size();
    }

    @Override
    public Object getItem(int i) {
        return Danhmuc.get(i);
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

        holder.imvDanhmuc = view.findViewById(R.id.imv_danhmuc1);
        holder.txtDanhmucName = view.findViewById(R.id.txt_danhmuc1);
        
        view.setTag(holder);


    } else {
        holder = (ViewHolder) view.getTag();


    }
        //binding data
        DanhMuc1 dm =Danhmuc.get(i);
        holder.imvDanhmuc.setImageResource(dm.getDanhmucThumb());
        holder.txtDanhmucName.setText(dm.getDanhmucName());

        return view;
    }

    public static class ViewHolder {
        ImageView imvDanhmuc;
        TextView txtDanhmucName;
}}
