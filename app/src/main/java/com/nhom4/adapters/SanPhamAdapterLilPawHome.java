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
import com.nhom4.models.SanPham;
import com.nhom4.models.SanPhamLilPawHome;

import java.util.List;

public class SanPhamAdapterLilPawHome extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<SanPhamLilPawHome> sanPhamLilPawHomes;

    public SanPhamAdapterLilPawHome(Activity activity, int item_layout, List<SanPhamLilPawHome> sanPhamLilPawHomes) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.sanPhamLilPawHomes = sanPhamLilPawHomes;
    }

    @Override
    public int getCount() {
        return sanPhamLilPawHomes.size();
    }

    @Override
    public Object getItem(int i) {
        return sanPhamLilPawHomes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        SanphamAdapter.ViewHolder holder;
        if(view==null)
        {
            holder=new SanphamAdapter.ViewHolder();
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
            holder= (SanphamAdapter.ViewHolder) view.getTag();
        }
        SanPhamLilPawHome sp=sanPhamLilPawHomes.get(i);

        holder.txtTenSanPham.setText(sp.getTenSanPham());
        holder.txtTenThuongHieu.setText(sp.getThuongHieuSanPham());
        holder.txtGiaMoi.setText(String.valueOf(sp.getGiaMoiSanPham()));
        holder.txtGiaCu.setText(String.valueOf(sp.getGiaCuSanPham()));
        //gọi tên ảnh trong drawable
        int img_id=activity.getResources().getIdentifier(
                sanPhamLilPawHomes.get(i).getIdAnhSanPham(),"drawable",activity.getPackageName()

        );
        //truyền id vào
        holder.imvAnhSanPham.setImageResource(img_id);

        return view;
    }
    public static class ViewHolder
    {
        ImageView imvAnhSanPham, imvAnhGioHang;
        TextView txtTenSanPham, txtTenThuongHieu, txtGiaMoi, txtGiaCu;


    }
}
