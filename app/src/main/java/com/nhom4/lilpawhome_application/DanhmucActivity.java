package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TabHost;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nhom4.adapters.Danhmuc1Adapter;
import com.nhom4.adapters.ExpandableDMAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityDanhmucBinding;
import com.nhom4.lilpawhome_application.databinding.ActivityMainBinding;
import com.nhom4.models.GroupDanhmuc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DanhmucActivity extends AppCompatActivity {
    ActivityDanhmucBinding binding;
    ArrayList<GroupDanhmuc> listGroup1, listGroup2;
    Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> listItemGr1, listItemGr2;
    ExpandableDMAdapter expandableDMAdapter1, expandableDMAdapter2;
    ExpandableListView expandableListView1,expandableListView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_danhmuc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = ActivityDanhmucBinding.inflate(getLayoutInflater());
        // setContentView(binding.getRoot());
        View view = binding.getRoot();
        setContentView(view);

        expandableListView1 = findViewById(R.id.lv_danhmucchocho);
        listItemGr1 = getListitemscho();
        listGroup1 = new ArrayList<>(listItemGr1.keySet());
        expandableDMAdapter1 = new ExpandableDMAdapter(DanhmucActivity.this,listGroup1,listItemGr1);
        expandableListView1.setAdapter(expandableDMAdapter1);

        expandableListView2 = findViewById(R.id.lv_danhmucchomeo);

        listItemGr2 = getListitemsmeo();

        listGroup2 = new ArrayList<>(listItemGr2.keySet());

        expandableDMAdapter2 = new ExpandableDMAdapter(DanhmucActivity.this,listGroup2,listItemGr2);

        expandableListView2.setAdapter(expandableDMAdapter2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custon_actionbar_danhmuc);
        getSupportActionBar().setBackgroundDrawable(
         new ColorDrawable(Color.parseColor("#ffffff")));
        setContentView(binding.getRoot());



        LoadData();
        addEvent();
        //setup

    }

    private void LoadData() {

    }

    private void addEvent() {
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        //set cái icon
        navigationView.setSelectedItemId(R.id.nav_action_danhmuc);
        navigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_action_danhmuc:
                        return true;
                    case  R.id.nav_action_home:
                        Intent intent1 =new Intent(getApplicationContext(),MainActivity.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent1);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.nav_action_thongbao:
                        Intent intent2 =new Intent(getApplicationContext(),NoticeActivity.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.nav_action_taikhoan:
                        Intent intent3 =new Intent(getApplicationContext(),UserActivity.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent3);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.nav_action_qr:
                        Dialog dialog = new Dialog(DanhmucActivity.this);
                        dialog.setContentView(R.layout.qr_user);
                        dialog.show();
                        return true;

                }
                return true;
            }
        });
        ImageView chat = findViewById(R.id.imv_chat);
        ImageView giohang = findViewById(R.id.imv_giohang);

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DanhmucActivity.this,ChatActivity.class);

                startActivity(intent);
            }
        });

        giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DanhmucActivity.this,GioHangActivity.class);

                startActivity(intent);
            }
        });


    }

    private Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> getListitemscho(){
        Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> listMap = new LinkedHashMap<>();

        GroupDanhmuc groupThucancho = new GroupDanhmuc(R.drawable.thucanchocho,1,"Thức ăn");
        GroupDanhmuc groupDodungcho = new GroupDanhmuc(R.drawable.dodungchocho,2,"Đồ dùng");
        GroupDanhmuc groupDochoicho = new GroupDanhmuc(R.drawable.dochoi,3,"Đồ chơi");
        GroupDanhmuc groupPhukiencho = new GroupDanhmuc(R.drawable.phukien,4,"Phụ kiện");
        GroupDanhmuc groupChuonglongcho = new GroupDanhmuc(R.drawable.chuongnha,5,"Chuồng, lồng");
      //  GroupDanhmuc groupThucanmeo = new GroupDanhmuc(R.drawable.thucanchomeo,6,"Thức ăn");
        //GroupDanhmuc groupDodungmeo = new GroupDanhmuc(R.drawable.dodungchomeo,7,"Đồ dùng");
       // GroupDanhmuc groupDochoimeo = new GroupDanhmuc(R.drawable.dochoi,8,"Đồ chơi");
       // GroupDanhmuc groupPhukienmeo = new GroupDanhmuc(R.drawable.phukien,9,"Phụ kiện");
      //  GroupDanhmuc groupChuonglongmeo = new GroupDanhmuc(R.drawable.chuongnha,10,"Chuồng, lồng");
      //  GroupDanhmuc groupdanhmuc2 = new GroupDanhmuc(R.drawable.icon_blog_home,1,"Thức ăn");
       // GroupDanhmuc groupdanhmuc3 = new GroupDanhmuc(R.drawable.icon_blog_home,1,"Thức ăn");

        ArrayList<GroupDanhmuc> listItemgr1 = new ArrayList<>();
        listItemgr1.add((new GroupDanhmuc(R.drawable.sphatcho,1,"Hạt")));
        listItemgr1.add((new GroupDanhmuc(R.drawable.sppatecho,2,"Pate")));
        listItemgr1.add((new GroupDanhmuc(R.drawable.spsuacho,3,"Sữa")));
        listItemgr1.add((new GroupDanhmuc(R.drawable.spsnackcho,1,"Snack, bánh thưởng")));
        listItemgr1.add((new GroupDanhmuc(R.drawable.spdinhduongcho,1,"Sản phẩm dinh dưỡng")));



        ArrayList<GroupDanhmuc> listItemgr2 = new ArrayList<>();
        listItemgr2.add((new GroupDanhmuc(R.drawable.spkhay,1,"Khay vệ sinh")));
        listItemgr2.add((new GroupDanhmuc(R.drawable.spchenan,2,"Chén ăn, bình nước")));
        listItemgr2.add((new GroupDanhmuc(R.drawable.splongmong,3,"Vệ sinh lông móng")));
        listItemgr2.add((new GroupDanhmuc(R.drawable.sptaimatmiengcho,4,"Vệ sinh tai, mắt, miệng")));
        listItemgr2.add((new GroupDanhmuc(R.drawable.spsuacho,5,"Sữa tắm, dầu gội")));



        ArrayList<GroupDanhmuc> listItemgr3 = new ArrayList<>();
        listItemgr3.add((new GroupDanhmuc(R.drawable.spxuongcho,1,"Xương đồ chơi")));
        listItemgr3.add((new GroupDanhmuc(R.drawable.spgoiomcho,2,"Gối ôm")));
        listItemgr3.add((new GroupDanhmuc(R.drawable.spcaomong,3,"Đồ cào móng")));
        listItemgr3.add((new GroupDanhmuc(R.drawable.spbong,4,"Banh bóng")));



        ArrayList<GroupDanhmuc> listItemgr4 = new ArrayList<>();
        listItemgr4.add((new GroupDanhmuc(R.drawable.spvongcocho,1,"Vòng cỏ")));
        listItemgr4.add((new GroupDanhmuc(R.drawable.spquanao,2,"Quần áo")));
        listItemgr4.add((new GroupDanhmuc(R.drawable.spdaydatvayem,3,"Dây dắt và yểm")));
        listItemgr4.add((new GroupDanhmuc(R.drawable.spromom,4,"Rõ mõm")));



        ArrayList<GroupDanhmuc> listItemgr5 = new ArrayList<>();
        listItemgr5.add((new GroupDanhmuc(R.drawable.balo,1,"Balo vận chuyển")));
        listItemgr5.add((new GroupDanhmuc(R.drawable.chuongnha,2,"Chuồng nệm")));
        listItemgr5.add((new GroupDanhmuc(R.drawable.splongvanchuyen,3,"Lồng vận chuyển")));

        listMap.put(groupThucancho, listItemgr1);
        listMap.put(groupDodungcho, listItemgr2);
        listMap.put(groupDochoicho, listItemgr3);
        listMap.put(groupPhukiencho, listItemgr4);
        listMap.put(groupChuonglongcho, listItemgr5);



        return listMap;
    }

    private Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> getListitemsmeo(){
        Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> listMap2 = new LinkedHashMap<>();

          GroupDanhmuc groupThucanmeo = new GroupDanhmuc(R.drawable.thucanchomeo,6,"Thức ăn");
        GroupDanhmuc groupDodungmeo = new GroupDanhmuc(R.drawable.dodungchomeo,7,"Đồ dùng");
         GroupDanhmuc groupDochoimeo = new GroupDanhmuc(R.drawable.dochoi,8,"Đồ chơi");
         GroupDanhmuc groupPhukienmeo = new GroupDanhmuc(R.drawable.phukien,9,"Phụ kiện");
          GroupDanhmuc groupChuonglongmeo = new GroupDanhmuc(R.drawable.chuongnha,10,"Chuồng, lồng");
          GroupDanhmuc groupdanhmuc2 = new GroupDanhmuc(R.drawable.icon_blog_home,1,"Thức ăn");
         GroupDanhmuc groupdanhmuc3 = new GroupDanhmuc(R.drawable.icon_blog_home,1,"Thức ăn");

        ArrayList<GroupDanhmuc> listItemgr6 = new ArrayList<>();
        listItemgr6.add((new GroupDanhmuc(R.drawable.sphatmeo,1,"Hạt")));
        listItemgr6.add((new GroupDanhmuc(R.drawable.sppatemeo,2,"Pate")));
        listItemgr6.add((new GroupDanhmuc(R.drawable.spsuameo,3,"Sữa")));
        listItemgr6.add((new GroupDanhmuc(R.drawable.spsnackmeo,1,"Snack, bánh thưởng")));
        listItemgr6.add((new GroupDanhmuc(R.drawable.spdinhduongmeo,1,"Sản phẩm dinh dưỡng")));



        ArrayList<GroupDanhmuc> listItemgr7 = new ArrayList<>();
        listItemgr7.add((new GroupDanhmuc(R.drawable.spkhaymeo,1,"Khay vệ sinh")));
        listItemgr7.add((new GroupDanhmuc(R.drawable.spcat,6,"Cát vệ sinh")));
        listItemgr7.add((new GroupDanhmuc(R.drawable.spchenan,2,"Chén ăn, bình nước")));
        listItemgr7.add((new GroupDanhmuc(R.drawable.splongmong,3,"Vệ sinh lông móng")));
        listItemgr7.add((new GroupDanhmuc(R.drawable.sptaimatmiengmeo,4,"Vệ sinh tai, mắt, miệng")));
        listItemgr7.add((new GroupDanhmuc(R.drawable.spsuatammeo,5,"Sữa tắm, dầu gội")));
        listItemgr7.add((new GroupDanhmuc(R.drawable.spcomeo,7,"Cỏ mèo")));



        ArrayList<GroupDanhmuc> listItemgr8 = new ArrayList<>();
        listItemgr8.add((new GroupDanhmuc(R.drawable.spcancau,1,"Cần câu mèo")));
        listItemgr8.add((new GroupDanhmuc(R.drawable.spgoiommeo,2,"Gối ôm")));
        listItemgr8.add((new GroupDanhmuc(R.drawable.spcaomong,3,"Đồ cào móng")));
        listItemgr8.add((new GroupDanhmuc(R.drawable.spbong,4,"Banh bóng")));



        ArrayList<GroupDanhmuc> listItemgr9 = new ArrayList<>();
        listItemgr9.add((new GroupDanhmuc(R.drawable.spvongcomeo,1,"Vòng cỏ")));
        listItemgr9.add((new GroupDanhmuc(R.drawable.spquanao,2,"Quần áo")));





        ArrayList<GroupDanhmuc> listItemgr10 = new ArrayList<>();
        listItemgr10.add((new GroupDanhmuc(R.drawable.balo,1,"Balo vận chuyển")));
        listItemgr10.add((new GroupDanhmuc(R.drawable.chuongnha,2,"Chuồng nệm")));
        listItemgr10.add((new GroupDanhmuc(R.drawable.splongvanchuyen,3,"Lồng vận chuyển")));

        listMap2.put(groupThucanmeo, listItemgr6);
        listMap2.put(groupDodungmeo, listItemgr7);
        listMap2.put(groupDochoimeo, listItemgr8);
        listMap2.put(groupPhukienmeo, listItemgr9);
        listMap2.put(groupChuonglongmeo, listItemgr10);



        return listMap2;
    }

}
