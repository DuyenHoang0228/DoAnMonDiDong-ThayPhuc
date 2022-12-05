package com.nhom4.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.DiaChi_tt;

import java.util.ArrayList;
import java.util.List;

public class AdapterDiaChiTT extends RecyclerView.Adapter<AdapterDiaChiTT.MyView> {

    ArrayList<DiaChi_tt> diaChi_ttList;
    boolean isFirstNewRadioButtonChecked = true;
    int lastCheckedPosition = 0;

    public class MyView extends RecyclerView.ViewHolder{

        TextView txttennguoinhan, txtsodienthoai, txtdiachi, txtmacdinh;
        RadioButton rbtndiachi;
        LinearLayout itemdiachitt;

        public MyView(@NonNull View itemView) {
            super(itemView);
            txttennguoinhan = itemView.findViewById(R.id.txt_tennguoinhan);
            txtsodienthoai = itemView.findViewById(R.id.txt_sodienthoai);
            txtdiachi = itemView.findViewById(R.id.txt_diachi);
            rbtndiachi = itemView.findViewById(R.id.rbtn_diachinhanhang);
            itemdiachitt = itemView.findViewById(R.id.item_diachitt);
            txtmacdinh = itemView.findViewById(R.id.txt_macdinh);

            rbtndiachi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isFirstNewRadioButtonChecked){
                        handleFirstRadiobuttonChecks(getAdapterPosition());
                        isFirstNewRadioButtonChecked = false;
                    }else{
                        handleRadiobuttonChecks(getAdapterPosition());
                    }

                }
            });
            itemdiachitt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isFirstNewRadioButtonChecked){
                        handleFirstRadiobuttonChecks(getAdapterPosition());
                        isFirstNewRadioButtonChecked = false;
                    }else{
                        handleRadiobuttonChecks(getAdapterPosition());
                    }
                }
            });
        }
    }

    private void handleFirstRadiobuttonChecks(int adapterPosition) {
        for (int i = 0; i <= diaChi_ttList.size()-1; i++){
            if (diaChi_ttList.get(i).isMacdinh() == true){
                lastCheckedPosition = i;
            }
        }
        diaChi_ttList.get(lastCheckedPosition).setSelected(false);
        diaChi_ttList.get(adapterPosition).setSelected(true);
        lastCheckedPosition = adapterPosition;//gán vị trí item vừa mới click
        notifyDataSetChanged();//Thông báo cho recyclerview rằng có sự thay đổi về trong data - cụ thể ở đây là giá trị true/false của radio button
    }


    private void handleRadiobuttonChecks(int adapterPosition) {
        diaChi_ttList.get(lastCheckedPosition).setSelected(false);//Set giá trị radio button ở item đã đánh trước đó thành false = bỏ tick radio button trước đó
        diaChi_ttList.get(adapterPosition).setSelected(true);//Set giá trị radio button ở item vừa được click thành true = tick radio button vừa được click
        lastCheckedPosition = adapterPosition;//gán vị trí item vừa mới click
        notifyDataSetChanged();//Thông báo cho recyclerview rằng có sự thay đổi về trong data - cụ thể ở đây là giá trị true/false của radio button
    }

    public AdapterDiaChiTT(ArrayList<DiaChi_tt> diaChi_ttList) {
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
        holder.rbtndiachi.setChecked(d.isSelected());
    }

    @Override
    public int getItemCount() {
        return diaChi_ttList.size();
    }


}
