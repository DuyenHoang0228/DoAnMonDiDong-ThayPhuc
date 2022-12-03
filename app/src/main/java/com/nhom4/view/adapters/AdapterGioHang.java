package com.nhom4.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.GioHang;

import java.util.List;

public class AdapterGioHang extends RecyclerView.Adapter<AdapterGioHang.MyView> {

    List<GioHang> gioHangList;

    public class MyView extends RecyclerView.ViewHolder{
        ImageView imvspgiohang;
        TextView txtbrandsanpham, txttensanpham, txtphanloaishop, txtgiasanphamdagiam, txtgiasanphamchuagiam, txtsoluongsp;

        public MyView(@NonNull View itemView) {
            super(itemView);

            imvspgiohang = itemView.findViewById(R.id.imv_spgiohang);
            txtbrandsanpham = itemView.findViewById(R.id.txt_brandsanpham);
            txttensanpham = itemView.findViewById(R.id.txt_tensanpham);
            txtphanloaishop = itemView.findViewById(R.id.txt_phanloaishop);
            txtgiasanphamdagiam = itemView.findViewById(R.id.txt_giasanphamdagiam);
            txtgiasanphamchuagiam = itemView.findViewById(R.id.txt_giasanphamchuagiam);
            txtsoluongsp = itemView.findViewById(R.id.txt_soluongsp);
        }
    }

    public AdapterGioHang(List<GioHang> gioHangList) {
        this.gioHangList = gioHangList;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.giohang_id, parent, false);

        return new AdapterGioHang.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        GioHang g = gioHangList.get(position);
        holder.imvspgiohang.setImageResource(g.getHinhsanpham());
        holder.txtbrandsanpham.setText(g.getBrandsanpham());
        holder.txttensanpham.setText(g.getTensanpham());
        holder.txtphanloaishop.setText(g.getPhanloaishop());
        holder.txtgiasanphamdagiam.setText(String.valueOf(g.getGiasanphamdagiam()+"VNĐ"));
        holder.txtgiasanphamchuagiam.setText(String.valueOf(g.getGiasanphamchuagiam()+"VNĐ"));
        holder.txtsoluongsp.setText(String.valueOf("x"+g.getSoluongsp()));
    }

    @Override
    public int getItemCount() {
        return gioHangList.size();
    }

}
