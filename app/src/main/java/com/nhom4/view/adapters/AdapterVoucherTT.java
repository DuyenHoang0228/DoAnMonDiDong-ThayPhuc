package com.nhom4.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.VoucherTT;

import java.util.ArrayList;

public class AdapterVoucherTT extends RecyclerView.Adapter<AdapterVoucherTT.MyView> {

    Context context;
    ArrayList<VoucherTT> voucherTTList;
    boolean isNewRadioButtonChecked = false;
    int lastCheckedPosition = 0;

    public class MyView extends RecyclerView.ViewHolder{

        ImageView imvvoucherthumb;
        TextView txttenvoucher, txtvouchertoida, txthansd;
        RadioButton rbtnvoucher;
        LinearLayout voucherview;

        public MyView(@NonNull View itemView) {
            super(itemView);
            imvvoucherthumb = itemView.findViewById(R.id.imv_voucherThumb);
            txttenvoucher = itemView.findViewById(R.id.txt_tenvoucher);
            txtvouchertoida = itemView.findViewById(R.id.txt_vouchertoida);
            txthansd = itemView.findViewById(R.id.txt_hsdvoucher);
            rbtnvoucher = itemView.findViewById(R.id.rbtn_voucher);
            voucherview = itemView.findViewById(R.id.voucherview); //Khai báo đến từng item voucher trong recyclerview
            
            rbtnvoucher.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleRadiobuttonChecks(getAdapterPosition());
                }
            });
            voucherview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleRadiobuttonChecks(getAdapterPosition());
                }
            });
        }
    }

    private void handleRadiobuttonChecks(int adapterPosition) {
        isNewRadioButtonChecked = true;
        voucherTTList.get(lastCheckedPosition).setSelected(false);//Set giá trị radio button ở item đã đánh trước đó thành false = bỏ tick radio button trước đó
        voucherTTList.get(adapterPosition).setSelected(true);//Set giá trị radio button ở item vừa được click thành true = tick radio button vừa được click
        lastCheckedPosition = adapterPosition;//gán vị trí item vừa mới click
        notifyDataSetChanged();//Thông báo cho recyclerview rằng có sự thay đổi về trong data - cụ thể ở đây là giá trị true/false của radio button
    }

    public AdapterVoucherTT(ArrayList<VoucherTT> voucherTTList){
        this.voucherTTList = voucherTTList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterVoucherTT.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_layout_tt, parent, false);

        return new AdapterVoucherTT.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVoucherTT.MyView holder, int position) {
        VoucherTT v = voucherTTList.get(position);
        holder.imvvoucherthumb.setImageResource(v.getVoucherthumb());
        holder.txttenvoucher.setText(v.getTenvoucher());
        holder.txtvouchertoida.setText(v.getVouchertoida());
        holder.txthansd.setText(v.getHsdvoucher());
        holder.rbtnvoucher.setChecked(v.isSelected());
    }

    @Override
    public int getItemCount() {
        return voucherTTList.size();
    }

}
