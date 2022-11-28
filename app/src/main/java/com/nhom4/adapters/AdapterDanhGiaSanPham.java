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
import com.nhom4.models.DanhGiaSanPhamM;

import java.util.List;

public class AdapterDanhGiaSanPham extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<DanhGiaSanPhamM> dsDanhGiaSanPham;

    public AdapterDanhGiaSanPham(Activity activity, int item_layout, List<DanhGiaSanPhamM> dsDanhGiaSanPham) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.dsDanhGiaSanPham = dsDanhGiaSanPham;
    }

    @Override
    public int getCount() {
        return dsDanhGiaSanPham.size();
    }

    @Override
    public Object getItem(int i) {
        return dsDanhGiaSanPham.get(i);
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

            holder.imvAvatar = view.findViewById(R.id.imv_avatar);
            holder.txtUserName = view.findViewById(R.id.txt_tenkhachhang);
            holder.txtFeedback =view.findViewById(R.id.txt_noidungdanhgiasanpham);
            holder.imvFeedbackImage1 = view.findViewById(R.id.imv_anhdanhgia1);
            holder.imvFeedbackImage2 = view.findViewById(R.id.imv_anhdanhgia2);
            holder.imvFeedbackImage3 = view.findViewById(R.id.imv_anhdanhgia3);
            holder.txtDateOfFeedback = view.findViewById(R.id.txt_ngaydanhgia);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();

        }
        DanhGiaSanPhamM dgsp = dsDanhGiaSanPham.get(i);
        holder.imvAvatar.setImageResource(dgsp.getAvatar());
        holder.txtUserName.setText(dgsp.getUserName());
        holder.txtFeedback.setText(dgsp.getFeedback());
        holder.txtDateOfFeedback.setText(dgsp.getDateOfFeedback().toString());
        holder.imvFeedbackImage1.setImageResource(dgsp.getImvFeedbackImage1());
        holder.imvFeedbackImage2.setImageResource(dgsp.getImvFeedbackImage2());
        holder.imvFeedbackImage3.setImageResource(dgsp.getImvFeedbackImage3());
        return view;
    }
    public static class ViewHolder{
        ImageView imvAvatar;
        TextView txtUserName, txtFeedback;
        ImageView imvFeedbackImage1, imvFeedbackImage2,imvFeedbackImage3;
        TextView txtDateOfFeedback;
    }
}
