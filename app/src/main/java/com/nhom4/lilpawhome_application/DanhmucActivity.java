package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TabHost;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.nhom4.lilpawhome_application.databinding.ActivityDanhmucBinding;
import com.nhom4.lilpawhome_application.databinding.ActivityMainBinding;
import com.nhom4.models.GroupDanhmuc;
import com.nhom4.models.SanPhamLilPawHome;
import com.nhom4.view.adapters.ExpandableDMAdapter;

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
        //set c??i icon
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

        binding.lvDanhmucchocho.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                ExpandableDMAdapter customExpandAdapter = (ExpandableDMAdapter) expandableListView1.getExpandableListAdapter();
                if (customExpandAdapter == null) {return;}
                for (int i = 0; i < customExpandAdapter.getGroupCount(); i++) {
                    if (i != groupPosition) {
                        expandableListView1.collapseGroup(i);
                    }
                }
            }
        });
        binding.lvDanhmucchomeo.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                ExpandableDMAdapter customExpandAdapter = (ExpandableDMAdapter) expandableListView2.getExpandableListAdapter();
                if (customExpandAdapter == null) {return;}
                for (int i = 0; i < customExpandAdapter.getGroupCount(); i++) {
                    if (i != groupPosition) {
                        expandableListView2.collapseGroup(i);
                    }
                }
            }
        });
        binding.lvDanhmucchocho.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                Intent intent = new Intent(DanhmucActivity.this, ShopChoCho1.class);
                intent.putExtra("group",i);
                intent.putExtra("child",i1);

                intent = new Intent(DanhmucActivity.this, ShopChoCho1.class);
                startActivity(intent);

                return false;
            }
        });
        binding.lvDanhmucchomeo.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Intent intent = new Intent(DanhmucActivity.this, ShopChoMeo1.class);
                intent.putExtra("group",i);
                intent.putExtra("child",i1);

                intent = new Intent(DanhmucActivity.this, ShopChoCho1.class);
                startActivity(intent);
                return false;
            }
        });

    }

    private Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> getListitemscho(){
        Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> listMap = new LinkedHashMap<>();

        GroupDanhmuc groupThucancho = new GroupDanhmuc(R.drawable.thucanchocho,1,"Th???c ??n");
        GroupDanhmuc groupDodungcho = new GroupDanhmuc(R.drawable.dodungchocho,2,"????? d??ng");
        GroupDanhmuc groupDochoicho = new GroupDanhmuc(R.drawable.dochoi,3,"????? ch??i");
        GroupDanhmuc groupPhukiencho = new GroupDanhmuc(R.drawable.phukien,4,"Ph??? ki???n");
        GroupDanhmuc groupChuonglongcho = new GroupDanhmuc(R.drawable.chuongnha,5,"Chu???ng, l???ng");
        //  GroupDanhmuc groupThucanmeo = new GroupDanhmuc(R.drawable.thucanchomeo,6,"Th???c ??n");
        //GroupDanhmuc groupDodungmeo = new GroupDanhmuc(R.drawable.dodungchomeo,7,"????? d??ng");
        // GroupDanhmuc groupDochoimeo = new GroupDanhmuc(R.drawable.dochoi,8,"????? ch??i");
        // GroupDanhmuc groupPhukienmeo = new GroupDanhmuc(R.drawable.phukien,9,"Ph??? ki???n");
        //  GroupDanhmuc groupChuonglongmeo = new GroupDanhmuc(R.drawable.chuongnha,10,"Chu???ng, l???ng");
        //  GroupDanhmuc groupdanhmuc2 = new GroupDanhmuc(R.drawable.icon_blog_home,1,"Th???c ??n");
        // GroupDanhmuc groupdanhmuc3 = new GroupDanhmuc(R.drawable.icon_blog_home,1,"Th???c ??n");

        ArrayList<GroupDanhmuc> listItemgr1 = new ArrayList<>();
        listItemgr1.add((new GroupDanhmuc(R.drawable.sphatcho,1,"H???t")));
        listItemgr1.add((new GroupDanhmuc(R.drawable.sppatecho,2,"Pate")));
        listItemgr1.add((new GroupDanhmuc(R.drawable.spsuacho,3,"S???a")));
        listItemgr1.add((new GroupDanhmuc(R.drawable.spsnackcho,1,"Snack, b??nh th?????ng")));
        listItemgr1.add((new GroupDanhmuc(R.drawable.spdinhduongcho,1,"S???n ph???m dinh d?????ng")));



        ArrayList<GroupDanhmuc> listItemgr2 = new ArrayList<>();
        listItemgr2.add((new GroupDanhmuc(R.drawable.spkhay,1,"Khay v??? sinh")));
        listItemgr2.add((new GroupDanhmuc(R.drawable.spchenan,2,"Ch??n ??n, b??nh n?????c")));
        listItemgr2.add((new GroupDanhmuc(R.drawable.splongmong,3,"V??? sinh l??ng m??ng")));
        listItemgr2.add((new GroupDanhmuc(R.drawable.sptaimatmiengcho,4,"V??? sinh tai, m???t, mi???ng")));
        listItemgr2.add((new GroupDanhmuc(R.drawable.spsuacho,5,"S???a t???m, d???u g???i")));



        ArrayList<GroupDanhmuc> listItemgr3 = new ArrayList<>();
        listItemgr3.add((new GroupDanhmuc(R.drawable.spxuongcho,1,"X????ng ????? ch??i")));
        listItemgr3.add((new GroupDanhmuc(R.drawable.spgoiomcho,2,"G???i ??m")));
        listItemgr3.add((new GroupDanhmuc(R.drawable.spcaomong,3,"????? c??o m??ng")));
        listItemgr3.add((new GroupDanhmuc(R.drawable.spbong,4,"Banh b??ng")));



        ArrayList<GroupDanhmuc> listItemgr4 = new ArrayList<>();
        listItemgr4.add((new GroupDanhmuc(R.drawable.spvongcocho,1,"V??ng c???")));
        listItemgr4.add((new GroupDanhmuc(R.drawable.spquanao,2,"Qu???n ??o")));
        listItemgr4.add((new GroupDanhmuc(R.drawable.spdaydatvayem,3,"D??y d???t v?? y???m")));
        listItemgr4.add((new GroupDanhmuc(R.drawable.spromom,4,"R?? m??m")));



        ArrayList<GroupDanhmuc> listItemgr5 = new ArrayList<>();
        listItemgr5.add((new GroupDanhmuc(R.drawable.balo,1,"Balo v???n chuy???n")));
        listItemgr5.add((new GroupDanhmuc(R.drawable.chuongnha,2,"Chu???ng n???m")));
        listItemgr5.add((new GroupDanhmuc(R.drawable.splongvanchuyen,3,"L???ng v???n chuy???n")));

        listMap.put(groupThucancho, listItemgr1);
        listMap.put(groupDodungcho, listItemgr2);
        listMap.put(groupDochoicho, listItemgr3);
        listMap.put(groupPhukiencho, listItemgr4);
        listMap.put(groupChuonglongcho, listItemgr5);



        return listMap;
    }

    private Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> getListitemsmeo(){
        Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> listMap2 = new LinkedHashMap<>();

        GroupDanhmuc groupThucanmeo = new GroupDanhmuc(R.drawable.thucanchomeo,6,"Th???c ??n");
        GroupDanhmuc groupDodungmeo = new GroupDanhmuc(R.drawable.dodungchomeo,7,"????? d??ng");
        GroupDanhmuc groupDochoimeo = new GroupDanhmuc(R.drawable.dochoi,8,"????? ch??i");
        GroupDanhmuc groupPhukienmeo = new GroupDanhmuc(R.drawable.phukien,9,"Ph??? ki???n");
        GroupDanhmuc groupChuonglongmeo = new GroupDanhmuc(R.drawable.chuongnha,10,"Chu???ng, l???ng");
        GroupDanhmuc groupdanhmuc2 = new GroupDanhmuc(R.drawable.icon_blog_home,1,"Th???c ??n");
        GroupDanhmuc groupdanhmuc3 = new GroupDanhmuc(R.drawable.icon_blog_home,1,"Th???c ??n");

        ArrayList<GroupDanhmuc> listItemgr6 = new ArrayList<>();
        listItemgr6.add((new GroupDanhmuc(R.drawable.sphatmeo,1,"H???t")));
        listItemgr6.add((new GroupDanhmuc(R.drawable.sppatemeo,2,"Pate")));
        listItemgr6.add((new GroupDanhmuc(R.drawable.spsuameo,3,"S???a")));
        listItemgr6.add((new GroupDanhmuc(R.drawable.spsnackmeo,1,"Snack, b??nh th?????ng")));
        listItemgr6.add((new GroupDanhmuc(R.drawable.spdinhduongmeo,1,"S???n ph???m dinh d?????ng")));



        ArrayList<GroupDanhmuc> listItemgr7 = new ArrayList<>();
        listItemgr7.add((new GroupDanhmuc(R.drawable.spkhaymeo,1,"Khay v??? sinh")));
        listItemgr7.add((new GroupDanhmuc(R.drawable.spcat,6,"C??t v??? sinh")));
        listItemgr7.add((new GroupDanhmuc(R.drawable.spchenan,2,"Ch??n ??n, b??nh n?????c")));
        listItemgr7.add((new GroupDanhmuc(R.drawable.splongmong,3,"V??? sinh l??ng m??ng")));
        listItemgr7.add((new GroupDanhmuc(R.drawable.sptaimatmiengmeo,4,"V??? sinh tai, m???t, mi???ng")));
        listItemgr7.add((new GroupDanhmuc(R.drawable.spsuatammeo,5,"S???a t???m, d???u g???i")));
        listItemgr7.add((new GroupDanhmuc(R.drawable.spcomeo,7,"C??? m??o")));



        ArrayList<GroupDanhmuc> listItemgr8 = new ArrayList<>();
        listItemgr8.add((new GroupDanhmuc(R.drawable.spcancau,1,"C???n c??u m??o")));
        listItemgr8.add((new GroupDanhmuc(R.drawable.spgoiommeo,2,"G???i ??m")));
        listItemgr8.add((new GroupDanhmuc(R.drawable.spcaomong,3,"????? c??o m??ng")));
        listItemgr8.add((new GroupDanhmuc(R.drawable.spbong,4,"Banh b??ng")));



        ArrayList<GroupDanhmuc> listItemgr9 = new ArrayList<>();
        listItemgr9.add((new GroupDanhmuc(R.drawable.spvongcomeo,1,"V??ng c???")));
        listItemgr9.add((new GroupDanhmuc(R.drawable.spquanao,2,"Qu???n ??o")));





        ArrayList<GroupDanhmuc> listItemgr10 = new ArrayList<>();
        listItemgr10.add((new GroupDanhmuc(R.drawable.balo,1,"Balo v???n chuy???n")));
        listItemgr10.add((new GroupDanhmuc(R.drawable.chuongnha,2,"Chu???ng n???m")));
        listItemgr10.add((new GroupDanhmuc(R.drawable.splongvanchuyen,3,"L???ng v???n chuy???n")));

        listMap2.put(groupThucanmeo, listItemgr6);
        listMap2.put(groupDodungmeo, listItemgr7);
        listMap2.put(groupDochoimeo, listItemgr8);
        listMap2.put(groupPhukienmeo, listItemgr9);
        listMap2.put(groupChuonglongmeo, listItemgr10);



        return listMap2;
    }


}
