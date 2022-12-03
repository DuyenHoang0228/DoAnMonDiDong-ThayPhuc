package com.nhom4.view.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.nhom4.fragment.ChoxacnhanFragment;
import com.nhom4.fragment.DagiaoFragment;
import com.nhom4.fragment.DahuyFragment;
import com.nhom4.fragment.DanggiaoFragment;

public class AdapterViewPagerDSDonmua extends FragmentStateAdapter {
    public AdapterViewPagerDSDonmua(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public AdapterViewPagerDSDonmua(@NonNull Fragment fragment) {
        super(fragment);
    }

    public AdapterViewPagerDSDonmua(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //Biện luận fragment trả về dựa trên vị trí
        switch (position) {
            case 0: //Nếu vị trí fragment là 0 - bấm tab đầu tiên thì nạp fragment danh sách đơn chờ xác nhận
                return new ChoxacnhanFragment();

            case 1:
                return new DanggiaoFragment();

            case 2:
                return new DagiaoFragment();

            case 3:
                return new DahuyFragment();

            default://Mặc định fragment đầu tiên được nạp là danh sách đơn hàng chờ xác nhận
                return new ChoxacnhanFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;//số tab xuất hiện
    }
}
