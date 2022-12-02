package com.nhom4.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.GioHang;

import java.util.List;

public class AdapterSanPhamTT extends RecyclerView.Adapter<AdapterSanPhamTT.MyView>{
    List<GioHang> gioHangList;

    // Tạo MyView class từ Adapter để mở rộng sang class ViewHolder
    public class MyView extends RecyclerView.ViewHolder {

        ImageView imvhinhsanpham;
        TextView txttensanpham, txtgiasanphamdagiam, txtgiasanphamchuagiam, txtsoluongsp;

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        public MyView(View view)
        {
            super(view);

            // Tìm các thuộc tính có trong file layout list sản phẩm
            txttensanpham = (TextView)view.findViewById(R.id.txt_tensanpham);
            txtgiasanphamchuagiam = (TextView)view.findViewById(R.id.txt_giasanphamchuagiam);
            txtgiasanphamdagiam = (TextView)view.findViewById(R.id.txt_giasanphamdagiam);
            imvhinhsanpham = (ImageView) view.findViewById(R.id.imv_hinhsanpham);
            txtsoluongsp = (TextView) view.findViewById(R.id.txt_soluongsp);
        }
    }

    public AdapterSanPhamTT(List<GioHang> gioHangList) {
        this.gioHangList = gioHangList;
    }

    @Override
    public AdapterSanPhamTT.MyView onCreateViewHolder(ViewGroup parent,
                                                       int viewType)
    {

        // Nạp layout của file list_sanpham_id vào LayoutInflater
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sanpham_tt_id, parent, false);

        return new AdapterSanPhamTT.MyView(itemView);
    }

    // Binding dữ liệu
    @Override
    public void onBindViewHolder(final AdapterSanPhamTT.MyView holder,
                                 final int position)
    {
        GioHang g = gioHangList.get(position);
        holder.txttensanpham.setText(g.getTenSanPham());
        holder.txtgiasanphamchuagiam.setText(String.format("%.0f VNĐ",g.getGiaCuSanPham()));
        holder.txtgiasanphamdagiam.setText(String.format("%.0f VNĐ",g.getGiaMoiSanPham()));
        holder.imvhinhsanpham.setImageResource(g.getIdAnhSanPham());
        holder.txtsoluongsp.setText(String.valueOf("x"+g.getSoluongsp()));
    }

    // Override getItemCount which Returns
    // the length of the RecyclerView.
    @Override
    public int getItemCount()
    {
        return gioHangList.size();
    }
}
