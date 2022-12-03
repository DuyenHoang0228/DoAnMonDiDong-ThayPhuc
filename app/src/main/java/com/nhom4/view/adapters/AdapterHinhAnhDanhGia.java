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

import java.util.List;

public class AdapterHinhAnhDanhGia extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<DanhGiaSanPhamM> dsDanhGiaSanPham;

    public AdapterHinhAnhDanhGia(Activity activity, int item_layout, List<DanhGiaSanPhamM> dsDanhGiaSanPham) {
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

            holder.imvHinhAnhDanhGia = view.findViewById(R.id.imv_hinhanhdanhgia);
            holder.rbHinhAnhDanhGia =view.findViewById(R.id.rb_hinhanhdanhgia);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();

        }
        DanhGiaSanPhamM dgsp = dsDanhGiaSanPham.get(i);
        holder.imvHinhAnhDanhGia.setImageResource(dgsp.getImvFeedbackImage1());
        holder.rbHinhAnhDanhGia.setRating(dgsp.getPawRate());

        return view;
    }

    public static class ViewHolder{
        ImageView imvHinhAnhDanhGia;
        RatingBar rbHinhAnhDanhGia;
    }
}
