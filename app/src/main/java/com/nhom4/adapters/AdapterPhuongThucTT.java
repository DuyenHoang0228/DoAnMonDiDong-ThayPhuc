package com.nhom4.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.PhuongThucTTChild;
import com.nhom4.models.PhuongThucTTMother;

import java.util.ArrayList;
import java.util.List;

public class AdapterPhuongThucTT extends RecyclerView.Adapter<AdapterPhuongThucTT.ItemViewHolder> {

    List<PhuongThucTTMother> mList;
    List<PhuongThucTTChild> clist;

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        LinearLayout itemphuongthuc;
        ImageView iconphuongthuc, imvarrowimage;
        TextView txttenphuongthuc, txttenphuphuongthuc;
        RecyclerView itemnestedphuongthuc;
        RelativeLayout expandableLayout;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemphuongthuc = itemView.findViewById(R.id.item_phuongthuc);
            itemnestedphuongthuc = itemView.findViewById(R.id.rv_child);
            txttenphuongthuc = itemView.findViewById(R.id.txt_tenphuongthuc);
            txttenphuphuongthuc = itemView.findViewById(R.id.txt_tenphuphuongthuc);
            iconphuongthuc = itemView.findViewById(R.id.icon_phuongthuc);
            imvarrowimage = itemView.findViewById(R.id.imv_arrowimage);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
        }
    }

    public AdapterPhuongThucTT(List<PhuongThucTTMother> mList){
        this.mList = mList;
    }

    @NonNull
    @Override
    public AdapterPhuongThucTT.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.phuongthuctt_id, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPhuongThucTT.ItemViewHolder holder, int position) {
        PhuongThucTTMother model = mList.get(position);
        holder.txttenphuongthuc.setText(model.getTenphuongthuc());
        holder.txttenphuphuongthuc.setText(model.getTenphuphuongthuc());
        holder.iconphuongthuc.setImageResource(model.getIconphuongthuc());

        boolean isExpandable = model.isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

        if (isExpandable){
            holder.imvarrowimage.setImageResource(R.drawable.arrow_down);
        }else{
            holder.imvarrowimage.setImageResource(R.drawable.arrow_right);
        }

        AdapterPhuongThucTTNested adapter = new AdapterPhuongThucTTNested(clist);
        holder.itemnestedphuongthuc.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.itemnestedphuongthuc.setAdapter(adapter);
        holder.itemphuongthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setExpandable(!model.isExpandable());
                clist = model.getList();
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
