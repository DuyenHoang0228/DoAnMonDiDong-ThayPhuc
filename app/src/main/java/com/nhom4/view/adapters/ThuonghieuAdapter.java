package com.nhom4.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.ThuongHieu;

import java.util.List;

public class ThuonghieuAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<ThuongHieu> thuongHieuList;

    public ThuonghieuAdapter(Activity activity, int item_layout, List<ThuongHieu> thuongHieuList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.thuongHieuList = thuongHieuList;
    }

    @Override
    public int getCount() {
        return thuongHieuList.size();
    }

    @Override
    public Object getItem(int i) {
        return thuongHieuList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //khởi tạo đối tượng viewholder
        ViewHolder holder;
        if(view==null)
        {
            holder=new ViewHolder();
            LayoutInflater layoutInflater= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(item_layout,null);
            //fvb
            holder.imvThuongHieu=view.findViewById(R.id.imv_thuonghieu);
            holder.txtThuongHieu=view.findViewById(R.id.txt_thuonghieu);

            view.setTag(holder);


        }
        else
        {
            holder= (ViewHolder) view.getTag();
        }

        ThuongHieu th=thuongHieuList.get(i);
        holder.imvThuongHieu.setImageResource(th.getAnhThuongHieu());
        holder.txtThuongHieu.setText(th.getTenThuongHieu());
        return view;
    }
    public static class ViewHolder
    {
        ImageView imvThuongHieu;
        TextView txtThuongHieu;

    }

}
