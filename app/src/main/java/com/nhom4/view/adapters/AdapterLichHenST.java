package com.nhom4.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.Blog;
import com.nhom4.models.LichHen;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterLichHenST extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<LichHen> lichhens;

    public AdapterLichHenST(Activity activity, int item_layout, List<LichHen> lichhens) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.lichhens = lichhens;
    }
    @Override
    public int getCount() {
        return lichhens.size();
    }

    @Override
    public Object getItem(int i) {
        return lichhens.get(i);
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

            // Tìm các thuộc tính có trong file layout list lịch hẹn
            holder.txtDichVu = view.findViewById(R.id.txt_dichvu);
            holder.txtthucung = view.findViewById(R.id.txt_thucung);
            holder.txtgiong = view.findViewById(R.id.txt_giong);
            holder.txtcoso = view.findViewById(R.id.txt_coso);
            //txtday = view.findViewById(R.id.txt_day);
            holder.txtdate = view.findViewById(R.id.txt_date);
            holder.txtgio = view.findViewById(R.id.txt_gio);
            view.setTag(holder);
        }
    else {
        holder = (ViewHolder) view.getTag();
    }
        LichHen l = lichhens.get(i);
        holder.txtDichVu.setText(l.getDichvu());
        holder.txtthucung.setText(l.getThucung());
        holder.txtgiong.setText(l.getGiong());
        holder.txtcoso.setText(l.getCoso());
        //holder.txtday.setText(l.getDay());
        holder.txtdate.setText(l.getDate());
        holder.txtgio.setText(l.getGio());
        return view;
    }
    public static class ViewHolder{
        TextView txtdate, txtcoso, txtDichVu, txtthucung, txtgio, txtgiong;
    }

}
