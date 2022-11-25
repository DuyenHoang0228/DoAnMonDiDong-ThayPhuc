package com.nhom4.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.SanPham;

import java.util.List;

public class SanphamAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<SanPham> sanPhamList;

    public SanphamAdapter(Activity activity, int item_layout, List<SanPham> sanPhamList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.sanPhamList = sanPhamList;

    }

    @Override
    public int getCount() {
        return sanPhamList.size();
    }

    @Override
    public Object getItem(int i) {
        return sanPhamList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ViewHolder holder;
        if(view==null)
        {
            holder=new ViewHolder();
            LayoutInflater layoutInflater= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(item_layout,null);

            holder.imvAnhSanPham=view.findViewById(R.id.imv_hinhsanpham);
            holder.txtTenSanPham=view.findViewById(R.id.txt_tensanpham);
            holder.txtTenThuongHieu=view.findViewById(R.id.txt_brandsanpham);
            holder.txtGiaMoi=view.findViewById(R.id.txt_giasanphamchuagiam);
            holder.txtGiaCu=view.findViewById(R.id.txt_giasanphamdagiam);

            view.setTag(holder);

        }else
        {
            holder= (ViewHolder) view.getTag();
        }
        SanPham sp=sanPhamList.get(i);
        holder.imvAnhSanPham.setImageResource(sp.getAnhSanPham());
        holder.txtTenSanPham.setText(sp.getTenSanPham());
        holder.txtTenThuongHieu.setText(sp.getThuongHieu());
        holder.txtGiaMoi.setText(String.valueOf(sp.getGiaMoiSanPham()));
        holder.txtGiaCu.setText(String.valueOf(sp.getGiaCuSanPham()));

        return view;
    }
    public static class ViewHolder
    {
        ImageView imvAnhSanPham, imvAnhGioHang;
        TextView txtTenSanPham, txtTenThuongHieu, txtGiaMoi, txtGiaCu;


    }
}