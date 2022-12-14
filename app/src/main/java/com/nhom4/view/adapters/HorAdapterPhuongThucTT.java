package com.nhom4.view.adapters;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.PhuongThucTT;

import java.util.List;

public class HorAdapterPhuongThucTT extends RecyclerView.Adapter<HorAdapterPhuongThucTT.MyView> {

    List<PhuongThucTT> phuongThucTTList;

    public class MyView extends RecyclerView.ViewHolder {
        ImageView iconphuongthuc;
        TextView txttenphuongthuc, txttenphuphuongthuc;
        LinearLayout itemhorphuongthuctt;

        public MyView(@NonNull View itemView) {
            super(itemView);

            iconphuongthuc = itemView.findViewById(R.id.icon_phuongthuc);
            txttenphuongthuc = itemView.findViewById(R.id.txt_tenphuongthuc);
            txttenphuphuongthuc = itemView.findViewById(R.id.txt_tenphuphuongthuc);
            itemhorphuongthuctt = itemView.findViewById(R.id.item_horphuongthuctt);
        }
    }

    public HorAdapterPhuongThucTT(List<PhuongThucTT> phuongThucTTList) {
        this.phuongThucTTList = phuongThucTTList;
    }

    @NonNull
    @Override
    public HorAdapterPhuongThucTT.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horphuongthuctt_id, parent, false);

        return new HorAdapterPhuongThucTT.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HorAdapterPhuongThucTT.MyView holder, int position) {
        PhuongThucTT p = phuongThucTTList.get(position);
        holder.iconphuongthuc.setImageResource(p.getIconphuongthuc());
        holder.txttenphuongthuc.setText(p.getTenphuongthuc());
        holder.txttenphuphuongthuc.setText(p.getTenphuphuongthuc());
        if (p.isSelected){
            holder.itemhorphuongthuctt.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFADD1")));
        } else {
            holder.itemhorphuongthuctt.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D8D8D8")));
        }
        holder.itemhorphuongthuctt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i <= phuongThucTTList.size()-1; i++){
                    phuongThucTTList.get(i).setSelected(false);
                }
                phuongThucTTList.get(holder.getAdapterPosition()).setSelected(true);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return phuongThucTTList.size();
    }


}
