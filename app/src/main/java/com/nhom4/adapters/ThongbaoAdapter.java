package com.nhom4.adapters;

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
import com.nhom4.models.ThongBao;

import java.util.List;

public class ThongbaoAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<ThongBao> Thongbao;

    public ThongbaoAdapter(Activity activity, int item_layout, List<ThongBao> thongbao) {
        this.activity = activity;
        this.item_layout = item_layout;
        Thongbao = thongbao;
    }

    @Override
    public int getCount() {
        return Thongbao.size();
    }

    @Override
    public Object getItem(int i) {
        return Thongbao.get(i);
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


            holder.imvThongbao = view.findViewById(R.id.imv_bieutuong);
            holder.txtThongbao = view.findViewById(R.id.txt_thongbao);
            holder.txtNoidung = view.findViewById(R.id.txt_noidung);

            view.setTag(holder);


        } else {
            holder = (ViewHolder) view.getTag();


        }
        //binding data
        ThongBao tb =Thongbao.get(i);
        holder.imvThongbao.setImageResource(tb.getThongbaoIcon());
        holder.txtThongbao.setText(tb.getThongbaoTittle());
        holder.txtNoidung.setText(tb.getThongbaoContent());

        return view;
    }

    public static class ViewHolder {
        ImageView imvThongbao;
        TextView txtThongbao, txtNoidung;
    }}

