package com.nhom4.adapters;

import android.app.Activity;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.SanPham;
import com.nhom4.models.SanPhamLilPawHome;

import java.util.List;

public class HorAdapterSanphamLilPawHome extends RecyclerView.Adapter<HorAdapterSanphamLilPawHome.MyView>{
    Activity activity;

    List<SanPhamLilPawHome> sanPhamLilPawHomes;
    ItemClickListener mItemListener;

    public HorAdapterSanphamLilPawHome(Activity activity, List<SanPhamLilPawHome> sanPhamLilPawHomes, ItemClickListener mItemListener) {
        this.activity = activity;
        this.sanPhamLilPawHomes = sanPhamLilPawHomes;
        this.mItemListener = mItemListener;
    }

    public class MyView extends RecyclerView.ViewHolder {

        ImageView imvhinhsanpham;
        TextView txttensanpham, txtbrandsanpham, txtgiasanphamchuagiam, txtgiasanphamdagiam;

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        public MyView(View view)
        {
            super(view);

            // Tìm các thuộc tính có trong file layout list sản phẩm
            txttensanpham = (TextView)view.findViewById(R.id.txt_tensanpham);
            txtbrandsanpham = (TextView)view.findViewById(R.id.txt_brandsanpham);
            txtgiasanphamchuagiam = (TextView)view.findViewById(R.id.txt_giasanphamchuagiam);
            txtgiasanphamdagiam = (TextView)view.findViewById(R.id.txt_giasanphamdagiam);
            imvhinhsanpham = (ImageView) view.findViewById(R.id.imv_hinhsanpham);
        }
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_sanpham_id, parent, false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HorAdapterSanphamLilPawHome.MyView holder, int position) {
        SanPhamLilPawHome sp = sanPhamLilPawHomes.get(position);
        holder.txttensanpham .setText(sp.getTenSanPham());
        holder.txtbrandsanpham.setText(sp.getThuongHieuSanPham());
        holder.txtgiasanphamdagiam.setText(String.valueOf(sp.getGiaMoiSanPham()));
        holder.txtgiasanphamchuagiam.setText(String.valueOf(sp.getGiaCuSanPham()));
        //gọi tên ảnh trong drawable
        int img_id=activity.getResources().getIdentifier(
                sanPhamLilPawHomes.get(position).getIdAnhSanPham(),"drawable",activity.getPackageName()

        );
        //truyền id vào
        holder.imvhinhsanpham.setImageResource(img_id);
        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(sanPhamLilPawHomes.get(position));
        });


    }

    @Override
    public int getItemCount() {
        return sanPhamLilPawHomes.size();
    }

    public interface ItemClickListener {
        void onItemClick(SanPhamLilPawHome details);
    }
}
