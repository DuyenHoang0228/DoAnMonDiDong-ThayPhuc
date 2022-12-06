package com.nhom4.view.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.DiaChi;
import com.nhom4.models.DiaChi_tt;

import java.util.List;

public class diachiAdapter extends RecyclerView.Adapter<diachiAdapter.MyView> {

    List<DiaChi> diaChiList;

    public class MyView extends RecyclerView.ViewHolder{

        TextView txttennguoinhan, txtsodienthoai, txtdiachi;
        LinearLayout itemdiachi;

        public MyView(@NonNull View itemView) {
            super(itemView);
            txttennguoinhan = itemView.findViewById(R.id.txt_tennguoimua);
            txtsodienthoai = itemView.findViewById(R.id.txt_sdtnguoimua);
            txtdiachi = itemView.findViewById(R.id.txt_diachinguoimua);
            itemdiachi = itemView.findViewById(R.id.item_diachi);
        }
    }

    public diachiAdapter(List<DiaChi> diaChiList) {
        this.diaChiList = diaChiList;
    }

    @NonNull
    @Override
    public diachiAdapter.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.diachi_list, parent, false);

        // Xuất layout ra màn hình
        return new diachiAdapter.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull diachiAdapter.MyView holder, int position) {
        DiaChi d = diaChiList.get(position);
        holder.txttennguoinhan.setText(d.getTen());
        holder.txtsodienthoai.setText(d.getSdt());
        holder.txtdiachi.setText(d.getDiachi());
    }

    @Override
    public int getItemCount() {
        return diaChiList.size();
    }


}
