package com.nhom4.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.Product;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

public class AdapterSanPham extends RecyclerView.Adapter<AdapterSanPham.MyView>{

    // List with String type
    private List<Product> products;

    // View Holder class which
    // extends RecyclerView.ViewHolder
    public class MyView extends RecyclerView.ViewHolder {

        // Text View
        ImageView imvhinhsanpham;
        TextView txttensanpham, txtbrandsanpham, txtgiasanphamchuagiam, txtgiasanphamdagiam;

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        public MyView(View view)
        {
            super(view);

            // initialise TextView with id
            txttensanpham = (TextView)view.findViewById(R.id.txt_tensanpham);
            txtbrandsanpham = (TextView)view.findViewById(R.id.txt_brandsanpham);
            txtgiasanphamchuagiam = (TextView)view.findViewById(R.id.txt_giasanphamchuagiam);
            txtgiasanphamdagiam = (TextView)view.findViewById(R.id.txt_giasanphamdagiam);
            imvhinhsanpham = (ImageView) view.findViewById(R.id.imv_hinhsanpham);
        }
    }

    public AdapterSanPham(List<Product> products) {
        this.products = products;
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent,
                                     int viewType)
    {

        // Inflate item.xml using LayoutInflator
        View itemView
                = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_sanpham_id,
                        parent,
                        false);

        // return itemView
        return new MyView(itemView);
    }

    // Override onBindViewHolder which deals
    // with the setting of different data
    // and methods related to clicks on
    // particular items of the RecyclerView.
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