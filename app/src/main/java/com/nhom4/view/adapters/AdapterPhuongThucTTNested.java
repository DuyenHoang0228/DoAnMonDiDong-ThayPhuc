package com.nhom4.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.PhuongthucTTActivity;
import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.PhuongThucTTChild;

import java.util.List;

public class AdapterPhuongThucTTNested extends RecyclerView.Adapter<AdapterPhuongThucTTNested.NestedViewHolder> {
    List<PhuongThucTTChild> cList;

    public AdapterPhuongThucTTNested(List<PhuongThucTTChild> cList) {
        this.cList = cList;
    }

    public class NestedViewHolder extends RecyclerView.ViewHolder{

        TextView txtchild;
        ImageView iconchild;
        LinearLayout itemnestedphuongthuc;

        public NestedViewHolder(@NonNull View itemView) {
            super(itemView);
            txtchild = itemView.findViewById(R.id.txt_child);
            iconchild = itemView.findViewById(R.id.icon_child);
            itemnestedphuongthuc = itemView.findViewById(R.id.item_nestedphuongthuc);
            itemnestedphuongthuc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    @NonNull
    @Override
    public NestedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nested_phuongthuctt_id, parent, false);
        return new NestedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPhuongThucTTNested.NestedViewHolder holder, int position) {
        PhuongThucTTChild p = cList.get(position);
        holder.txtchild.setText(p.getTxtchild());
        holder.iconchild.setImageResource(p.getIconchild());
        holder.itemnestedphuongthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                if (cList.get(holder.getAdapterPosition()).getTxtchild().contains("bank")){
                    bundle.putString("Phuongthucchinh", "ATM");
                }else {
                    bundle.putString("Phuongthucchinh", "Thetindung");
                }
                bundle.putString("Phuongthuc", cList.get(holder.getAdapterPosition()).getTxtchild());
                bundle.putInt("Icon", cList.get(holder.getAdapterPosition()).getIconchild());
                intent.putExtras(bundle);
                intent.setAction("fromPhuongthucTT");
                ((Activity)v.getContext()).setResult(Activity.RESULT_OK, intent);
                Toast.makeText(v.getContext(), String.format("Đã chọn phương thức %s", cList.get(holder.getAdapterPosition()).getTxtchild()), Toast.LENGTH_LONG);
                ((Activity)v.getContext()).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (cList != null) {
            return cList.size();
        }
        return 0;
    }
}
