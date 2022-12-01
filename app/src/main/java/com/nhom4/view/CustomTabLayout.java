package com.nhom4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

public class CustomTabLayout extends TabLayout {
    public CustomTabLayout(@NonNull Context context) {
        super(context);
    }

    public CustomTabLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTabLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //Custom tablayout sao cho kích thước của các tab khi hiển thị trên màn hình nhỏ không bị xuống dòng
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        ViewGroup tabLayout = (ViewGroup) getChildAt(0);
        int childCount = tabLayout.getChildCount(); //Đếm số tab có trong tabLayout
        if (childCount != 0) {
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();//Lấy kích thước của màn hình
            int tabMinWidth = displayMetrics.widthPixels/childCount; //Lấy chiều ngang màn hình đơn vị Pixel và chia cho số tab

            //Chạy vòng lặp để set chiều rộng nhỏ nhất phù hợp cho từng tab
            for (int i = 0; i < childCount; ++i) {
                tabLayout.getChildAt(i).setMinimumWidth(tabMinWidth);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
