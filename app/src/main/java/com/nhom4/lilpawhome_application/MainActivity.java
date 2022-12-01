package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nhom4.adapters.Danhmuc1Adapter;
import com.nhom4.adapters.HorSanPhamAdapter;
import com.nhom4.adapters.SanphamAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityMainBinding;
import com.nhom4.models.DanhMuc1;
import com.nhom4.models.SanPham;
import com.nhom4.view.ExpandableHeightGridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Danhmuc1Adapter adapter;
    ArrayList<DanhMuc1> danhmuc;
    ArrayList<SanPham> sanPhams;
    ArrayList<SanPham> sanPhamsBanchay;
    ArrayList<SanPham> sanPhamDexuathome;
    HorSanPhamAdapter adapter2;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    LinearLayoutManager Horizontallayout;
    ExpandableHeightGridView SPdexuat;
    SanphamAdapter adapter3;



    private ImageSlider imageSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // setContentView(binding.getRoot());
        View view = binding.getRoot();
        setContentView(view);

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.nav_action_home);
        navigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_action_home:
                       return true;
                    case  R.id.nav_action_danhmuc:
                        Intent intent1 =new Intent(getApplicationContext(),DanhmucActivity.class);
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
                        Dialog dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.qr_user);
                        dialog.show();
                        return true;
                }
                return false;
            }
        });
        loadBanner();

        loadData();
        addEvent();

    }

    private void addEvent() {
        binding.imvChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ChatActivity.class);

                startActivity(intent);
            }
        });
        binding.gvDanhmuchome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch (i){
                    case 0:
                         intent =new Intent(MainActivity.this,ShopChoCho1.class);
                        break;

                    case 1:
                        intent =new Intent(MainActivity.this,ShopChoMeo2.class);
                        break;
                    case 2:
                       intent =new Intent(MainActivity.this,SpaActivity1.class);
                        break;

                    case 3:
                        intent =new Intent(MainActivity.this,ThuongHieuActivity.class);
                        break;

                    case 4:
                         intent =new Intent(MainActivity.this,UuDaiMain.class);
                        break;

                    case 5:
                        intent =new Intent(MainActivity.this,BlogActivity.class);
                        break;

                }
                startActivity(intent);

            }
        });
        binding.imvGiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GioHangActivity.class);

                startActivity(intent);
            }
        });
    }


    private void loadData() {
        loadDanhmuc();
        loadSPgiamgia();
        loadSPbanchay();
        loadSPdexuat();



    }

    private void loadSPdexuat() {
        SPdexuat=findViewById(R.id.gv_spdexuat);
        SPdexuat.setExpanded(true);
        sanPhamDexuathome =new ArrayList<>();
        sanPhamDexuathome.add(new SanPham(R.drawable.sphatcho,"Hạt cho chó",120000,200000,
                "Thương hiệu 1","thucanchocho","hatchocho"));
        sanPhamDexuathome.add(new SanPham(R.drawable.sppatecho,"Pate cho chó",350000,400000,
                "Thương hiệu 1","thucanchocho","patechocho"));
        sanPhamDexuathome.add(new SanPham(R.drawable.spsuacho,"Sữa tắm chó",250000,300000,
                "Thương hiệu 2","thucanchocho","suacho"));
        sanPhamDexuathome.add(new SanPham(R.drawable.spsuatamcho,"Sữa tắm chó",120000,320000,
                "Thương hiệu 2","dodungcho","suatamcho"));
        sanPhamDexuathome.add(new SanPham(R.drawable.spxuongcho,"Xương chó đồ chơi",20000,50000,
                "Thương hiệu 3","dochoicho","xuongcho"));
        sanPhamDexuathome.add(new SanPham(R.drawable.spdinhduongcho,"Sữa dinh dưỡng cho chó",360000,500000,
                "Thương hiệu 3","thucanchocho","dinhduongchocho"));
        sanPhamDexuathome.add(new SanPham(R.drawable.sptaimatmiengcho,"Cây chà răng chó",25000,40000,
                "Thương hiệu 4","dodungcho","taimatcho"));

        adapter3=new SanphamAdapter(MainActivity.this,R.layout.list_sanpham_id,sanPhamDexuathome);
        SPdexuat.setAdapter(adapter3);
    }

    private void loadBanner(){
        imageSlider = findViewById(R.id.image_slider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.lilpawhomebn,ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.khuyenmai20,ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.trangchushopchocho,ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.trangchushopchomeo,ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.trangchutintuc,ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.trangchuuudai,ScaleTypes.FIT));

        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

    }
    private void loadDanhmuc(){
        danhmuc = new ArrayList<>();
        danhmuc.add(new DanhMuc1(R.drawable.icon_shopchocho_home,"Shop cho Chó"));
        danhmuc.add(new DanhMuc1(R.drawable.icon_shopchomeo_home,"Shop cho Mèo"));
        danhmuc.add(new DanhMuc1(R.drawable.icon_spa_home,"Spa"));
        danhmuc.add(new DanhMuc1(R.drawable.icon_thuonghieu_home,"Thương Hiệu"));
        danhmuc.add(new DanhMuc1(R.drawable.icon_uudai_home,"Ưu đãi"));
        danhmuc.add(new DanhMuc1(R.drawable.icon_blog_home,"Blog"));

        adapter = new Danhmuc1Adapter(MainActivity.this,R.layout.danhmuc1_list,danhmuc);
        binding.gvDanhmuchome.setAdapter(adapter);

    }
    private void loadSPgiamgia(){
        recyclerView = (RecyclerView) findViewById(R.id.rcv_spgiamgia);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);
        //add sp
        sanPhams = new ArrayList<>();
        sanPhams.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        sanPhams.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        sanPhams.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        sanPhams.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        sanPhams.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));

        // truyen du lieu
        adapter2= new HorSanPhamAdapter(sanPhams);
        Horizontallayout=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(Horizontallayout);
        recyclerView.setAdapter(adapter2);

    }
    private void loadSPbanchay(){
        recyclerView = (RecyclerView) findViewById(R.id.rcv_spBanchay);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);
        //add sp
        sanPhamsBanchay = new ArrayList<>();
        sanPhamsBanchay.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        sanPhamsBanchay.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        sanPhamsBanchay.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        sanPhamsBanchay.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
        sanPhamsBanchay.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));

        // truyen du lieu
        adapter2= new HorSanPhamAdapter(sanPhamsBanchay);
        Horizontallayout=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(Horizontallayout);
        recyclerView.setAdapter(adapter2);

    }


}