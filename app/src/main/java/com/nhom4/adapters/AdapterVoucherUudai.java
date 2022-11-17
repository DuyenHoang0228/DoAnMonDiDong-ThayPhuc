package com.nhom4.adapters;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.VoucherUuDai;

import java.util.List;

public class AdapterVoucherUudai extends BaseAdapter {

    Context c;
    Activity activity;
    int item_layout;
    List<VoucherUuDai> vouchers;

    public AdapterVoucherUudai(Activity activity, int item_layout, List<VoucherUuDai> vouchers){
        this.activity = activity;
        this.item_layout = item_layout;
        this.vouchers = vouchers;
    }


    @Override
    public int getCount() {
        return vouchers.size();
    }

    @Override
    public Object getItem(int position) {
        return vouchers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(item_layout, null);
        }

        TextView txt_tieudevoucher = convertView.findViewById(R.id.txt_tieudevoucher);
        TextView txt_tieudephuvoucher = convertView.findViewById(R.id.txt_tieudephuvoucher);

        VoucherUuDai v = vouchers.get(position);
        txt_tieudevoucher.setText(v.getVouchertitle());
        txt_tieudephuvoucher.setText(v.getVouchersubtitle());

        return convertView;
    }
}
