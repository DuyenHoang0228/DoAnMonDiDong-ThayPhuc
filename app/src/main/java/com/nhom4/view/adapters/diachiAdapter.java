package com.nhom4.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.nhom4.lilpawhome_application.R;
import com.nhom4.lilpawhome_application.diachi;
import com.nhom4.models.DiaChi;
import com.nhom4.models.TaikhoanNH;

import java.util.List;

public class diachiAdapter extends BaseAdapter {
    diachi activity;
    int item_layout;
    List<DiaChi> address;

    public diachiAdapter(diachi activity, int item_layout, List<DiaChi> address) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.address = address;
    }

    public List<DiaChi> getAddress() {
        return address;
    }

    public void setAddress(List<DiaChi> address) {
        this.address = address;
    }

    @Override
    public int getCount() {
        return address.size();
    }

    @Override
    public Object getItem(int i) {
        return address.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view==null){
            holder=new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.txtten = view.findViewById(R.id.txt_tennguoimua);
            holder.txtsdt=view.findViewById(R.id.txt_sdtnguoimua);
            holder.txtdiachi=view.findViewById(R.id.txt_diachinguoimua);
            view.setTag(holder);
        }else{
            DiaChi dc = address.get(i);
            holder = (diachiAdapter.ViewHolder) view.getTag();
            holder.txtten.setText(dc.getTen());
            holder.txtsdt.setText(dc.getSdt());
            holder.txtdiachi.setText(dc.getDiachi());
        }
        return view;
    }
    public static class ViewHolder{
        TextView txtten, txtsdt, txtdiachi;
    }
}
