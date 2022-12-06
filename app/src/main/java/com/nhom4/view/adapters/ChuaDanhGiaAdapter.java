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
import com.nhom4.models.DanhGiaSanPhamM;
import com.nhom4.models.DonHang;

import java.util.List;

public class ChuaDanhGiaAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<DonHang> dsDonHang;

    public ChuaDanhGiaAdapter(Activity activity, int item_layout, List<DonHang> dsDonHang) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.dsDonHang = dsDonHang;
    }

    @Override
    public int getCount() {
        return dsDonHang.size();
    }

    @Override
    public Object getItem(int i) {
        return dsDonHang.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout,null);

            holder.imvAnhSP = view.findViewById(R.id.imv_anhsanphamdamua);
            holder.txtDonGia =view.findViewById(R.id.txt_giasanphamdamua);
            holder.txtTenSP = view.findViewById(R.id.txt_tensanphamdamua);
            holder.txtSoLuong = view.findViewById(R.id.txt_soluongsanphamdamua);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();

        }
        DonHang dh= dsDonHang.get(i);
        holder.imvAnhSP.setImageResource(dh.getHinhsanpham());
        holder.txtTenSP.setText(dh.getTensanpham());
        holder.txtSoLuong.setText("x " + dh.getTongsoluong());
        double dongia = Double.parseDouble(dh.getThanhtien()) / Double.parseDouble(dh.getTongsoluong());
        dongia = Math.round(dongia);
        holder.txtDonGia.setText(String.valueOf(dongia));


        return view;
    }

    public static class ViewHolder{
        ImageView imvAnhSP;
        TextView txtTenSP, txtDonGia, txtSoLuong;
    }
}
