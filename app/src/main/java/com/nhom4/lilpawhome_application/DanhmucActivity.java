package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TabHost;

import com.nhom4.adapters.Danhmuc1Adapter;
import com.nhom4.adapters.ExpandableDMAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityDanhmucBinding;
import com.nhom4.lilpawhome_application.databinding.ActivityMainBinding;
import com.nhom4.models.GroupDanhmuc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DanhmucActivity extends AppCompatActivity {
    ActivityDanhmucBinding binding;
    ArrayList<GroupDanhmuc> listGroup;
    Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> listItemGr;
    ExpandableDMAdapter expandableDMAdapter;
    ExpandableListView expandableListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_danhmuc);
        binding = ActivityDanhmucBinding.inflate(getLayoutInflater());
        // setContentView(binding.getRoot());
        View view = binding.getRoot();
        setContentView(view);

        expandableListView = findViewById(R.id.lv_danhmucchocho);
        listItemGr = getListitems();
        listGroup = new ArrayList<>(listItemGr.keySet());
        expandableDMAdapter = new ExpandableDMAdapter(DanhmucActivity.this,listGroup,listItemGr);
        expandableListView.setAdapter(expandableDMAdapter);

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


    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== R.id.imv_chat)
        {
                    Intent intent = new Intent(DanhmucActivity.this,ChatActivity.class);

                    startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    private Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> getListitems(){
        Map<GroupDanhmuc, ArrayList<GroupDanhmuc>> listMap = new HashMap<>();

        GroupDanhmuc groupThucancho = new GroupDanhmuc(R.drawable.thucanchocho,1,"Thức ăn");
        GroupDanhmuc groupDodungcho = new GroupDanhmuc(R.drawable.dodungchocho,2,"Đồ dùng");
        GroupDanhmuc groupDochoicho = new GroupDanhmuc(R.drawable.dochoi,3,"Đồ chơi");
        GroupDanhmuc groupPhukiencho = new GroupDanhmuc(R.drawable.phukien,4,"Phụ kiện");
        GroupDanhmuc groupChuonglongcho = new GroupDanhmuc(R.drawable.chuongnha,5,"Chuồng, lồng");
        GroupDanhmuc groupThucanmeo = new GroupDanhmuc(R.drawable.thucanchomeo,6,"Thức ăn");
        GroupDanhmuc groupDodungmeo = new GroupDanhmuc(R.drawable.dodungchomeo,7,"Đồ dùng");
        GroupDanhmuc groupDochoimeo = new GroupDanhmuc(R.drawable.dochoi,8,"Đồ chơi");
        GroupDanhmuc groupPhukienmeo = new GroupDanhmuc(R.drawable.phukien,9,"Phụ kiện");
        GroupDanhmuc groupChuonglongmeo = new GroupDanhmuc(R.drawable.chuongnha,10,"Chuồng, lồng");
      //  GroupDanhmuc groupdanhmuc2 = new GroupDanhmuc(R.drawable.icon_blog_home,1,"Thức ăn");
       // GroupDanhmuc groupdanhmuc3 = new GroupDanhmuc(R.drawable.icon_blog_home,1,"Thức ăn");

        ArrayList<GroupDanhmuc> listItemgr1 = new ArrayList<>();
        listItemgr1.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));
        listItemgr1.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));
        listItemgr1.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));
        listItemgr1.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));
        listItemgr1.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));



        ArrayList<GroupDanhmuc> listItemgr2 = new ArrayList<>();
        listItemgr2.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));
        listItemgr2.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));
        listItemgr2.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));



        ArrayList<GroupDanhmuc> listItemgr3 = new ArrayList<>();
        listItemgr3.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));
        listItemgr3.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));
        listItemgr3.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));



        ArrayList<GroupDanhmuc> listItemgr4 = new ArrayList<>();
        listItemgr4.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));
        listItemgr4.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));
        listItemgr4.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));



        ArrayList<GroupDanhmuc> listItemgr5 = new ArrayList<>();
        listItemgr5.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));
        listItemgr5.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));
        listItemgr5.add((new GroupDanhmuc(R.drawable.icon_uudai_home,1,"abc")));


        listMap.put(groupDochoicho, listItemgr3);
        listMap.put(groupThucancho, listItemgr1);
        listMap.put(groupPhukiencho, listItemgr4);
        listMap.put(groupChuonglongcho, listItemgr5);
        listMap.put(groupDodungcho, listItemgr2);


        return listMap;
    }

}
