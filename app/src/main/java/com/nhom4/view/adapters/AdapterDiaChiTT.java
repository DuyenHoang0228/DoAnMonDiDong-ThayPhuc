package com.nhom4.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.DiaChi_tt;

import java.util.List;

public class AdapterDiaChiTT extends RecyclerView.Adapter<AdapterDiaChiTT.MyView> {

    List<DiaChi_tt> diaChi_ttList;

    public class MyView extends RecyclerView.ViewHolder{

        TextView txttennguoinhan, txtsodienthoai, txtdiachi;

        public MyView(@NonNull View itemView) {
            super(itemView);
            txttennguoinhan = itemView.findViewById(R.id.txt_tennguoinhan);
            txtsodienthoai = itemView.findViewById(R.id.txt_sodienthoai);
            txtdiachi = itemView.findViewById(R.id.txt_diachi);
        }
    }

    public AdapterDiaChiTT(List<DiaChi_tt> diaChi_ttList) {
        this.diaChi_ttList = diaChi_ttList;
    }

    @NonNull
    @Override
    public AdapterDiaChiTT.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.diachi_id, parent, false);

        // Xuất layout ra màn hình
        return new AdapterDiaChiTT.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDiaChiTT.MyView holder, int position) {
        DiaChi_tt d = diaChi_ttList.get(position);
        holder.txttennguoinhan.setText(d.getTennguoinhan());
        holder.txtsodienthoai.setText(d.getSodienthoai());
        holder.txtdiachi.setText(d.getDiachinguoinhan());
    }

    @Override
    public int getItemCount() {
        return diaChi_ttList.size();
    }


}
