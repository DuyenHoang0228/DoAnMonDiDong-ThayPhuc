package com.nhom4.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.DanhGiaSanPhamM;
import com.nhom4.models.DonHang;

import java.util.List;

public class AdapterSanPhamDaDanhGia extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<DanhGiaSanPhamM> dsDanhGia;


    public AdapterSanPhamDaDanhGia(Activity activity, int item_layout, List<DanhGiaSanPhamM> dsDanhGia) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.dsDanhGia = dsDanhGia;
    }

    @Override
    public int getCount() {
        return dsDanhGia.size();
    }

    @Override
    public Object getItem(int i) {
        return dsDanhGia.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.imvAvatar = view.findViewById(R.id.imv_avatar_danhgiacuatoi);
            holder.txtUserName = view.findViewById(R.id.txt_tenkhachhang_danhgiacuatoi);
            holder.txtFeedback = view.findViewById(R.id.txt_noidungdanhgiasanpham_dgct);
            holder.txtProductName = view.findViewById(R.id.txt_tensp_dgct);
            holder.imvAnhdg1 = view.findViewById(R.id.imv_anhdanhgia1_dgct);
            holder.imvAnhdg2 = view.findViewById(R.id.imv_anhdanhgia2_dgct);
            holder.imvAnhdg3 = view.findViewById(R.id.imv_anhdanhgia3_dgct);
            holder.ratingBar = view.findViewById(R.id.rb_ratingdanhgiacuatoi);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();

        }
        DanhGiaSanPhamM dh = dsDanhGia.get(i);
        holder.imvAvatar.setImageResource(dh.getAvatar());
        holder.txtUserName.setText(dh.getUserName());
        holder.txtFeedback.setText(dh.getFeedback());
        holder.imvAnhdg1.setImageResource(dh.getImvFeedbackImage1());
        holder.imvAnhdg2.setImageResource(dh.getImvFeedbackImage2());
        holder.imvAnhdg3.setImageResource(dh.getImvFeedbackImage3());
        holder.ratingBar.setRating(dh.getPawRate());

        return view;
    }

    public static class ViewHolder {
        ImageView imvAvatar, imvAnhdg1, imvAnhdg2, imvAnhdg3;
        TextView txtUserName, txtFeedback, txtProductName;
        RatingBar ratingBar;
    }
}
