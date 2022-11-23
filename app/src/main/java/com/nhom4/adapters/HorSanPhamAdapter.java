package com.nhom4.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.Product;

import java.util.List;

public class HorSanPhamAdapter extends RecyclerView.Adapter<HorSanPhamAdapter.MyView>{

    List<Product> products;

    // Tạo MyView class từ Adapter để mở rộng sang class ViewHolder
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

    public HorSanPhamAdapter(List<Product> products) {
        this.products = products;
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent,
                                     int viewType)
    {

        // Nạp layout của file list_sanpham_id vào LayoutInflater
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_sanpham_id, parent, false);

        return new MyView(itemView);
    }

    // Binding dữ liệu
    @Override
    public void onBindViewHolder(final MyView holder,
                                 final int position)
    {
        Product p = products.get(position);
        holder.txttensanpham.setText(p.getBrandName());
        holder.txtbrandsanpham.setText(p.getBrandName());
        holder.txtgiasanphamchuagiam.setText(String.valueOf(p.getProductPrice()));
        holder.txtgiasanphamdagiam.setText(String.valueOf(p.getProductPriceDiscounted()));
        holder.imvhinhsanpham.setImageResource(p.getProductImage());
    }

    // Override getItemCount which Returns
    // the length of the RecyclerView.
    @Override
    public int getItemCount()
    {
        return products.size();
    }
}
