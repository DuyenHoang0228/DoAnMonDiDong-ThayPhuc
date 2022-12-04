package com.nhom4.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.FormDanhGiaSanPham;
import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.DonHang;
import com.nhom4.view.ExpandableHeightGridView;

import java.util.ArrayList;
import java.util.List;

public class ChuaDanhGiaAdapter2 extends BaseAdapter {
    Activity activity;
    int item_layout;
    String[] madonhang;
    ArrayList<DonHang> donHangs;

    public ChuaDanhGiaAdapter2(Activity activity, int item_layout, String[] madonhang, ArrayList<DonHang> donHangs) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.madonhang = madonhang;
        this.donHangs = donHangs;
    }

    @Override
    public int getCount() {
        return madonhang.length;
    }

    @Override
    public Object getItem(int i) {
        return madonhang[i];
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

            holder.txtMaDonHang = view.findViewById(R.id.txt_madonhang);
            holder.btnDanhGia =view.findViewById(R.id.btn_danhgia_danhgiacuatoi);
            holder.gvSanPham = view.findViewById(R.id.gr_sanphamtrongdondamua);
            holder.txtThanhTien = view.findViewById(R.id.txt_tongthanhtoan);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        ChuaDanhGiaAdapter adapter;
        ArrayList<DonHang> donhang = new ArrayList<>();
        if(i%2 == 0) {
            donhang.add(donHangs.get(i));
        }
        donhang.add(donHangs.get(i));
        if(i%3==0){
            donhang.add(donHangs.get(i));
        }
        adapter = new ChuaDanhGiaAdapter(activity,R.layout.sanphamtrongdondamua_layout, donhang);
        holder.gvSanPham.setExpanded(true);
        holder.gvSanPham.setAdapter(adapter);
        holder.txtMaDonHang.setText(madonhang[i]);
        holder.btnDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, FormDanhGiaSanPham.class);
                activity.startActivity(intent);
            }
        });
        //holder.txtThanhTien.setText(donhang.get(i).getThanhtien());
        return view;
    }
    public static class ViewHolder{
        TextView txtMaDonHang, txtThanhTien;
        Button btnDanhGia;
        ExpandableHeightGridView gvSanPham;
    }
}
