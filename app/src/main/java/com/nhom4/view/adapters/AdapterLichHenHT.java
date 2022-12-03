package com.nhom4.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.LichHen;

import java.util.List;

public class AdapterLichHenHT extends RecyclerView.Adapter<AdapterLichHenHT.MyView>{

    List<LichHen> lichhens;

    public class MyView extends RecyclerView.ViewHolder {

        TextView txtdichvu, txtthucung, txtgiong, txtcoso, txtday, txtdate, txtgio;

        public MyView(@NonNull View itemView) {
            super(itemView);

            // Tìm các thuộc tính có trong file layout list sản phẩm
            txtdichvu = itemView.findViewById(R.id.txt_dichvu);
            txtthucung = itemView.findViewById(R.id.txt_thucung);
            txtgiong = itemView.findViewById(R.id.txt_giong);
            txtcoso = itemView.findViewById(R.id.txt_coso);
            txtday = itemView.findViewById(R.id.txt_day);
            txtdate = itemView.findViewById(R.id.txt_date);
            txtgio = itemView.findViewById(R.id.txt_gio);
        }
    }

    public AdapterLichHenHT(List<LichHen> lichhens) {
        this.lichhens = lichhens;
    }

    @NonNull
    @Override
    public AdapterLichHenHT.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Nạp layout của file blog_id vào LayoutInflater
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lichhen_hoantat_id, parent, false);

        // Xuất layout ra màn hình
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        LichHen l = lichhens.get(position);
        holder.txtdichvu.setText(l.getDichvu());
        holder.txtthucung.setText(l.getThucung());
        holder.txtgiong.setText(l.getGiong());
        holder.txtcoso.setText(l.getCoso());
        holder.txtday.setText(l.getDay());
        holder.txtdate.setText(l.getDate());
        holder.txtgio.setText(l.getGio());
    }

    @Override
    public int getItemCount() {
        return lichhens.size();
    }
}
