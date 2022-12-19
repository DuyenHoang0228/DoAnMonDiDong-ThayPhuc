package com.nhom4.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nhom4.lilpawhome_application.MainActivity;
import com.nhom4.view.adapters.AdapterDSDonmua;
import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.DonHang;

import java.util.ArrayList;

public class ChoxacnhanFragment extends Fragment {

    AdapterDSDonmua adapter;
    ArrayList<DonHang> donHangs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Nạp layout của fragment
        View rootView = inflater.inflate(R.layout.fragment_choxacnhan, container, false);
        donHangs = new ArrayList<>();
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "Số lượng sản phẩm: 3", "Thành tiền: 190.000 VND"));
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "Số lượng sản phẩm: 3", "Thành tiền: 190.000 VND"));
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "Số lượng sản phẩm: 3", "Thành tiền: 190.000 VND"));
        adapter = new AdapterDSDonmua(getActivity(), R.layout.donhangchoxacnhan_id, donHangs);
        ListView lv = (ListView)rootView.findViewById(R.id.lv_choxacnhan);
        lv.setAdapter(adapter);
        addNewOrder();
        return rootView;
    }

    private void addNewOrder() {
        try {
            Bundle bundle = getActivity().getIntent().getExtras();
            int hinhsp = bundle.getInt("Hinhsp");
            String brand = bundle.getString("Brand");
            String tensp = bundle.getString("Tensp");
            String soluong = String.format("Số lượng sản phẩm: %d", bundle.getInt("Soluong"));
            String thanhtien = bundle.getString("Thanhtien");
            donHangs.add(new DonHang(hinhsp, brand, tensp, soluong, thanhtien));
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
