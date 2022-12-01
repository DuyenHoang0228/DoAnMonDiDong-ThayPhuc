package com.nhom4.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.HoSo;

import java.util.List;

public class AdapterChonHoso extends RecyclerView.Adapter<AdapterChonHoso.MyView> {

    List<HoSo> hoSoList;

    public class MyView extends RecyclerView.ViewHolder {

        TextView txtbecung;

        public MyView(@NonNull View itemView) {
            super(itemView);
            txtbecung = itemView.findViewById(R.id.txt_becung);
        }
    }

    public AdapterChonHoso(List<HoSo> hoSoList) {this.hoSoList = hoSoList;}

    @NonNull
    @Override
    public AdapterChonHoso.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoso_button_id, parent, false);

        // Xuất layout ra màn hình
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        HoSo h = hoSoList.get(position);
        holder.txtbecung.setText(h.getBecung());
    }

    @Override
    public int getItemCount() {
        return hoSoList.size();
    }

}
