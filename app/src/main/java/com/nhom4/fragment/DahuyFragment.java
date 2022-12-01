package com.nhom4.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nhom4.adapters.AdapterDSDonmua;
import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.DonHang;

import java.util.ArrayList;

public class DahuyFragment extends Fragment {

    AdapterDSDonmua adapter;
    ArrayList<DonHang> donHangs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dahuy, container, false);
        donHangs = new ArrayList<>();
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "Số lượng sản phẩm: 3", "Thành tiền: 190.000 VND"));
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "Số lượng sản phẩm: 3", "Thành tiền: 190.000 VND"));
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "Số lượng sản phẩm: 3", "Thành tiền: 190.000 VND"));
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "Số lượng sản phẩm: 3", "Thành tiền: 190.000 VND"));
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "Số lượng sản phẩm: 3", "Thành tiền: 190.000 VND"));
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "Số lượng sản phẩm: 3", "Thành tiền: 190.000 VND"));
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "Số lượng sản phẩm: 3", "Thành tiền: 190.000 VND"));
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "Số lượng sản phẩm: 3", "Thành tiền: 190.000 VND"));
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "Số lượng sản phẩm: 3", "Thành tiền: 190.000 VND"));
        donHangs.add(new DonHang(R.drawable.giohang_sp1, "Thương hiệu: Virbac", "Gel Dinh Dưỡng Cho Chó Mèo Còi Cọc Virbac Nutri Plus 120g – Pháp", "Số lượng sản phẩm: 3", "Thành tiền: 190.000 VND"));
        adapter = new AdapterDSDonmua(getActivity(), R.layout.donhangdahuy_id, donHangs);
        ListView lv = (ListView)rootView.findViewById(R.id.lv_dahuy);
        lv.setAdapter(adapter);
        return rootView;
    }
}
