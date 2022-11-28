package com.nhom4.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.KhachHang;

import java.util.List;

public class AdapterKhachHang extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<KhachHang> danhsachkhachhang;

    public AdapterKhachHang(Activity activity, int item_layout, List<KhachHang> danhsachkhachhang) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.danhsachkhachhang = danhsachkhachhang;
    }

    @Override
    public int getCount() {
        return danhsachkhachhang.size();
    }

    @Override
    public Object getItem(int i) {
        return danhsachkhachhang.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Link views and binding data
        ViewHolder holder;
        if(view==null){
            //Link views
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.txtUserName = view.findViewById(R.id.txt_tenkhachhang);
            holder.txtLevel = view.findViewById(R.id.txt_thuhangthanhvien);
            holder.txtYourOrder = view.findViewById(R.id.txt_sodonhang);
            holder.txtOrder = view.findViewById(R.id.txt_sodonhangcandat);
            holder.txtYourSpend = view.findViewById(R.id.txt_chitieu);
            holder.txtSpend = view.findViewById(R.id.txt_chitieucandat);
            holder.txtDiscount = view.findViewById(R.id.txt_noidunguudaithuhang);
            holder.txtTitleOfDiscount = view.findViewById(R.id.txt_uudaithuhang);
            holder.lvYourVoucher = view.findViewById(R.id.lv_voucherdocquyen);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();

        }
        KhachHang kh = danhsachkhachhang.get(i);
        holder.txtUserName.setText(kh.getUsername());
        holder.txtYourOrder.setText(kh.getYourOrder());
        holder.txtOrder.setText(kh.getOrder());
        holder.txtYourSpend.setText(kh.getYourSpend()+"");
        holder.txtSpend.setText(kh.getSpend()+"");
        holder.txtTitleOfDiscount.setText("ƯU ĐÃI HẠNG " + kh.getLevel());
        holder.txtDiscount.setText("");
        //holder.lvYourVoucher.set;
        return view;
    }

    public static class ViewHolder {
        TextView txtUserName, txtLevel, txtOrder, txtYourOrder, txtYourSpend, txtSpend, txtDiscount, txtTitleOfDiscount;
        ListView lvYourVoucher;
    }
}
