package com.nhom4.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.lilpawhome_application.taikhoannganhang;

import com.nhom4.models.TaikhoanNH;

import java.util.List;

public class TKNH_Adapter extends BaseAdapter {
    taikhoannganhang activity;
    int item_layout;
    List<TaikhoanNH> tknhs;

    public TKNH_Adapter(taikhoannganhang activity, int item_layout, List<TaikhoanNH> tknhs) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.tknhs = tknhs;
    }

    @Override
    public int getCount() {
        return tknhs.size();
    }

    @Override
    public Object getItem(int i) {
        return tknhs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.txtTknhInfo = view.findViewById(R.id.txt_tennh);
            view.setTag(holder);
        }else{
            TaikhoanNH tknh = tknhs.get(i);
            holder = (ViewHolder) view.getTag();
            holder.txtTknhInfo.setText(tknh.getTaikhoannganhang());
        }
        return view;
    }

    public static class ViewHolder{
        TextView txtTknhInfo;
    }
}
