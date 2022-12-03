package com.nhom4.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.PhuongThucTTChild;

import java.util.List;

public class AdapterPhuongThucTTNested extends RecyclerView.Adapter<AdapterPhuongThucTTNested.NestedViewHolder> {
    List<PhuongThucTTChild> cList;

    public AdapterPhuongThucTTNested(List<PhuongThucTTChild> cList){
        this.cList = cList;
    }

    public class NestedViewHolder extends RecyclerView.ViewHolder{

        TextView txtchild;
        ImageView iconchild;

        public NestedViewHolder(@NonNull View itemView) {
            super(itemView);
            txtchild = itemView.findViewById(R.id.txt_child);
            iconchild = itemView.findViewById(R.id.icon_child);
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
    }

    @Override
    public int getItemCount() {
        if (cList != null) {
            return cList.size();
        }
        return 0;
    }
}
