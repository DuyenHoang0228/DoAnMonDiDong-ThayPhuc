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
import com.nhom4.models.DonHang;

import java.util.List;

public class AdapterDSDonmua extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<DonHang> donHangList;

    public AdapterDSDonmua(Activity activity, int item_layout, List<DonHang> donHangList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.donHangList = donHangList;
    }

    @Override
    public int getCount() {
        return donHangList.size();
    }

    @Override
    public Object getItem(int position) {
        return donHangList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(item_layout, null);
            holder.imvhinhsanpham = convertView.findViewById(R.id.imv_hinhsanpham);
            holder.txtbrandsanpham = convertView.findViewById(R.id.txt_brandsanpham);
            holder.txttensanpham = convertView.findViewById(R.id.txt_tensanpham);
            holder.txttongsoluong = convertView.findViewById(R.id.txt_tongsoluongsp);
            holder.txtthanhtien = convertView.findViewById(R.id.txt_thanhtien);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        //Link views and binding data
        //Binding data
        DonHang b = donHangList.get(position);
        holder.imvhinhsanpham.setImageResource(b.getHinhsanpham());
        holder.txtbrandsanpham.setText(b.getBrandsanpham());
        holder.txttensanpham .setText(b.getTensanpham());
        holder.txttongsoluong.setText(b.getTongsoluong());
        holder.txtthanhtien.setText(b.getThanhtien());
        return convertView;
    }

    public static class ViewHolder{
        ImageView imvhinhsanpham;
        TextView txtbrandsanpham, txttensanpham, txttongsoluong, txtthanhtien;
    }
}
