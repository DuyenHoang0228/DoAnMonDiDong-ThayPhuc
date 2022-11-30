package com.nhom4.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.ChiTietVoucher;
import com.nhom4.lilpawhome_application.KhoVoucher;
import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.Voucher;

import java.util.List;

public class AdapterVoucher extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<Voucher> vouchers;

    public AdapterVoucher(Activity activity, int item_layout, List<Voucher> vouchers) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.vouchers = vouchers;
    }

    @Override
    public int getCount() {
        return vouchers.size();
    }

    @Override
    public Object getItem(int i) {
        return vouchers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.txtChuTrongAnhVoucher = view.findViewById(R.id.txt_chutronganhvoucher);
            holder.txtTitleOfVoucher = view.findViewById(R.id.txt_tenvoucher);
            holder.txtHSDVoucher = view.findViewById(R.id.txt_hsdvoucher);
            holder.txtMaxValue = view.findViewById(R.id.txt_vouchertoida);
            holder.txtSoLuongCoHan = view.findViewById(R.id.txt_soluongcohan);
            holder.btnDungNgay = view.findViewById(R.id.txt_dungngayvoucher);
            holder.btnDieuKien = view.findViewById(R.id.txt_dieukienvoucher);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        Voucher v = vouchers.get(i);
        holder.txtChuTrongAnhVoucher.setText(v.getChuTrongAnhVoucher());
        holder.txtTitleOfVoucher.setText(v.getTitleOfVoucher());
        holder.txtHSDVoucher.setText(v.getHsdVoucher());
        holder.txtMaxValue.setText(String.valueOf(v.getMaxValue()));
        if(v.isLimited()==true){
            holder.txtSoLuongCoHan.setText("Số lượng có hạn");
        }else{
            holder.txtSoLuongCoHan.setVisibility(View.INVISIBLE);
        }
        holder.btnDieuKien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent qua trang khác mà chưa biết làm
            }
        });
        holder.btnDungNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //như trên
            }
        });

        return view;


    }

    public static class ViewHolder {
        TextView txtTitleOfVoucher, txtHSDVoucher, txtMaxValue, txtChuTrongAnhVoucher, txtSoLuongCoHan;
        TextView btnDungNgay, btnDieuKien;

    }
}
