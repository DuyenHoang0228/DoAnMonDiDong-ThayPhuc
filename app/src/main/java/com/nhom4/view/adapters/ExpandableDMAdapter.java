package com.nhom4.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.DanhMuc1;
import com.nhom4.models.GroupDanhmuc;

import java.util.ArrayList;
import java.util.Map;

public class ExpandableDMAdapter extends BaseExpandableListAdapter {
    Activity activity;
    ArrayList<GroupDanhmuc> listGroup;
    Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> listIteminG;

    public ExpandableDMAdapter(Activity activity,ArrayList<GroupDanhmuc> listGroup, Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> listIteminG) {
        this.activity = activity;
        this.listGroup = listGroup;
        this.listIteminG = listIteminG;
    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listIteminG.get(listGroup.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listGroup.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listIteminG.get(listGroup.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {

        GroupDanhmuc grObject = listGroup.get(i);
        return grObject.getDanhmucID();
    }

    @Override
    public long getChildId(int i, int i1) {
        GroupDanhmuc itemObject = listIteminG.get(listGroup.get(i)).get(i1);
        return itemObject.getDanhmucID();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
       if (view == null) {
           LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

           view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.danhmuctittle_list, viewGroup, false);
       }
           ImageView imvGroup = view.findViewById(R.id.imv_danhmucspTittle);
           TextView txtTittle = view.findViewById(R.id.txt_danhmucspTittle);

           GroupDanhmuc groupDanhmuc = listGroup.get(i);
           txtTittle.setText(groupDanhmuc.getDanhmucName());
           imvGroup.setImageResource(groupDanhmuc.getDanhmucThumb());

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.danhmucitemingroup_list, viewGroup, false);
        }
            ImageView imvGroup = view.findViewById(R.id.imv_itemdanhmucspTittle);
            TextView txtTittle = view.findViewById(R.id.txt_imv_itemdanhmucspTittle);

            GroupDanhmuc groupItemDanhmuc = listIteminG.get(listGroup.get(i)).get(i1);
            txtTittle.setText(groupItemDanhmuc.getDanhmucName());
            imvGroup.setImageResource(groupItemDanhmuc.getDanhmucThumb());

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
