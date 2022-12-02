package com.nhom4.adapters;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.GioHangActivity;
import com.nhom4.lilpawhome_application.MainActivity;
import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.GioHang;

import java.util.ArrayList;

public class AdapterGioHang extends RecyclerView.Adapter<AdapterGioHang.MyView> {

    ArrayList<GioHang> gioHangList;

    public class MyView extends RecyclerView.ViewHolder{
        ImageView imvspgiohang;
        TextView txtbrandsanpham, txttensanpham, txtphanloaishop, txtgiasanphamdagiam, txtgiasanphamchuagiam, txtsoluongsp, txttongtiensp;
        CheckBox cboxchonsp;
        ImageButton btngiamsoluong, btntangsoluong;
        public Double tongthanhtoantemp = 0.0;//Dùng biến này để tính tiền và reset sau mỗi lần bấm chạy hàm onClick check box

        public MyView(@NonNull View itemView) {
            super(itemView);
            imvspgiohang = itemView.findViewById(R.id.imv_spgiohang);
            txtbrandsanpham = itemView.findViewById(R.id.txt_brandsanpham);
            txttensanpham = itemView.findViewById(R.id.txt_tensanpham);
            txtphanloaishop = itemView.findViewById(R.id.txt_phanloaishop);
            txtgiasanphamdagiam = itemView.findViewById(R.id.txt_giasanphamdagiam);
            txtgiasanphamchuagiam = itemView.findViewById(R.id.txt_giasanphamchuagiam);
            txtsoluongsp = itemView.findViewById(R.id.txt_soluongsp);
            txttongtiensp = itemView.findViewById(R.id.txt_tongtiensp);
            cboxchonsp = itemView.findViewById(R.id.cbox_chonspgiohang);
            btngiamsoluong = itemView.findViewById(R.id.btn_giamsoluong);
            btntangsoluong = itemView.findViewById(R.id.btn_tangsoluong);

            //Set sự kiện click cho nút tăng/ giảm số lượng
            btngiamsoluong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleButtonDecrease(getAdapterPosition());
                }
                private void handleButtonDecrease(int adapterPosition) {
                    int soluongsp = MainActivity.manggiohang.get(adapterPosition).getSoluongsp()-1;
                    if (soluongsp > 0) {
                        MainActivity.manggiohang.get(adapterPosition).setSoluongsp(soluongsp);
                        calculateTotalOrder();
                        notifyDataSetChanged();
                    }else{
                        //Show custom dialog
                        Dialog dialog = new Dialog(btngiamsoluong.getContext());
                        dialog.setContentView(R.layout.dialog_xoasanpham);

                        //Ok
                        TextView dongyxoa = dialog.findViewById(R.id.txt_dongyxoa);
                        dongyxoa.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (cboxchonsp.isChecked()) {
                                    cboxchonsp.setChecked(false); //fix bug giữ nguyên check box đã tick của sp xóa cho sp tiếp theo
                                    notifyDataSetChanged();
                                    MainActivity.manggiohang.remove(adapterPosition);
                                }else {
                                    MainActivity.manggiohang.remove(adapterPosition);
                                }
                                calculateTotalOrder();
                                notifyDataSetChanged();
                                dialog.dismiss();
                            }
                        });

                        //Cancel
                        TextView cancel = dialog.findViewById(R.id.txt_khongxoa);
                        cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //Cancel activity
                                dialog.dismiss();
                            }
                        });
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.show();
                    }
                }
            });

            btntangsoluong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleButtonIncrease(getAdapterPosition());
                }
                private void handleButtonIncrease(int adapterPosition) {
                    MainActivity.manggiohang.get(adapterPosition).setSoluongsp(MainActivity.manggiohang.get(adapterPosition).getSoluongsp()+1);
                    notifyDataSetChanged();
                    calculateTotalOrder();
                }
            });

            //Set sự kiện click cho checkbox
            cboxchonsp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleCheckBoxChecks(getAdapterPosition());
                }
                private void handleCheckBoxChecks(int adapterPosition) {
                    if (cboxchonsp.isChecked()) {
                        MainActivity.manggiohang.get(adapterPosition).setSelected(true);
                    }else{
                        MainActivity.manggiohang.get(adapterPosition).setSelected(false);
                    }
                    calculateTotalOrder();
                }
            });
        }

        private void calculateTotalOrder() {
            for (int i = 0; i <= MainActivity.manggiohang.size() - 1; i++){
                if (MainActivity.manggiohang.get(i).isSelected()) {
                    tongthanhtoantemp += MainActivity.manggiohang.get(i).getSoluongsp() * MainActivity.manggiohang.get(i).getGiaMoiSanPham();
                }
            }
            GioHangActivity.txttongthanhtoan.setText(String.format("%.0fđ", tongthanhtoantemp));
            tongthanhtoantemp = 0.0;
        }
    }


    public AdapterGioHang(ArrayList<GioHang> gioHangList) {
        this.gioHangList = gioHangList;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.giohang_id, parent, false);

        return new AdapterGioHang.MyView(itemView);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        GioHang g = gioHangList.get(position);
        holder.imvspgiohang.setImageResource(g.getIdAnhSanPham());
        holder.txtbrandsanpham.setText(g.getThuongHieuSanPham());
        holder.txttensanpham.setText(g.getTenSanPham());
        holder.txtphanloaishop.setText(g.getLoaiSanPham1());
        holder.txtgiasanphamdagiam.setText(String.format("%.0f VNĐ",g.getGiaMoiSanPham()));
        holder.txtgiasanphamchuagiam.setText(String.format("%.0f VNĐ",g.getGiaCuSanPham()));
        holder.txtsoluongsp.setText(String.format("x%d", g.getSoluongsp()));
        holder.txttongtiensp.setText(String.format("%.0fđ",g.getTongtiensp()));
        //DecimalFormat decimalformat = new DecimalFormat("###,###,###");
        //holder.txtgiasanphamchuagiam.setText(decimalformat.format(g.getGiaCuSanPham()+"VNĐ"));
    }

    @Override
    public int getItemCount() {
        return gioHangList.size();
    }

}
