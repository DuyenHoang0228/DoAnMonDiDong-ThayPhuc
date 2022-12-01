package com.nhom4.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.DanhMuc1;
import com.nhom4.models.TroGIup;

import java.util.List;

public class HelpAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<TroGIup> Trogiup;

    public HelpAdapter(Activity activity, int item_layout, List<TroGIup> trogiup) {
        this.activity = activity;
        this.item_layout = item_layout;
        Trogiup = trogiup;
    }

    @Override
    public int getCount() {
        return Trogiup.size();
    }

    @Override
    public Object getItem(int i) {
        return Trogiup.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout,null);
            holder.txthelpTittle = view.findViewById(R.id.txt_tieudetrogiup);

            view.setTag(holder);


        } else {
            holder = (ViewHolder) view.getTag();


        }
        //binding data
        TroGIup dm =Trogiup.get(i);

        holder.txthelpTittle.setText(dm.getTieudeTroGiup());


        return view;
    }
        //return null;


    public static class ViewHolder {

        TextView txthelpTittle;
    }
}
