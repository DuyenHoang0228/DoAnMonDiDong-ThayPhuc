package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
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
import com.nhom4.view.adapters.Danhmuc1Adapter;
import com.nhom4.view.adapters.HorSanPhamAdapter;
import com.nhom4.view.adapters.SanphamAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityMainBinding;
import com.nhom4.models.DanhMuc1;
import com.nhom4.models.GioHang;
import com.nhom4.models.SanPham;
import com.nhom4.models.SanPhamLilPawHome;
import com.nhom4.view.ExpandableHeightGridView;
import com.nhom4.view.adapters.Danhmuc1Adapter;
import com.nhom4.view.adapters.SanPhamAdapterLilPawHome;
import com.nhom4.adapters.HorAdapterSanphamLilPawHome;
import com.nhom4.databases.DBHelperSanPham;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Danhmuc1Adapter adapter;
    ArrayList<DanhMuc1> danhmuc;

    ArrayList<SanPhamLilPawHome> sanPhamgiamgia, sanPhamsBanchay, sanPhamDexuathome, sanphamchocho,sanphamchomeo;
    HorAdapterSanphamLilPawHome adapter2;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    LinearLayoutManager Horizontallayout;
    SanPhamAdapterLilPawHome adapter3;
    DBHelperSanPham dbHelperSanPham;
    public static ArrayList<GioHang> manggiohang; //Khai báo mảng giỏ hàng public để làm mảng toàn cục, luôn xuất hiện ở màn hình khác


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
        createCart();//Tạo function thực hiện tạo giỏ hàng nếu không có mảng giỏ hàng nào tồn tại
    }

    private void createCart() {
        if (manggiohang == null) {
            manggiohang = new ArrayList<>();
        }
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
                        intent =new Intent(MainActivity.this,ShopChoMeo1.class);
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
        binding.gvSpdexuat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, TrangSanPhamActivity.class);
                SanPhamLilPawHome spitem = sanPhamDexuathome.get(i);
                intent.putExtra("IDsanpham",spitem.getIdSanPham());

                startActivity(intent);
            }
        });

    }


    private void loadData() {
        createDb();
        loadDanhmuc();
        loadSPgiamgia();
        loadSPbanchay();
        loadSPdexuat();
        loadSPchocho();
        loadSPchomeo();


    }




    private void createDb() {
        dbHelperSanPham=new DBHelperSanPham(MainActivity.this);
        dbHelperSanPham.createSampleData();
    }
    private void loadSPchomeo() {
        recyclerView = (RecyclerView) findViewById(R.id.rcv_spchoMeo);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);
        //add sp
        sanphamchomeo = new ArrayList<>();

        //truy vấn
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
                " WHERE "+ DBHelperSanPham.COL_CATE1+" like '%chomeo' ");
        while(c.moveToNext())
        {
            sanphamchomeo.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter2=new HorAdapterSanphamLilPawHome(MainActivity.this, sanphamchomeo, new HorAdapterSanphamLilPawHome.ItemClickListener() {
            @Override
            public void onItemClick(SanPhamLilPawHome details) {
                Intent intent = new Intent(MainActivity.this, TrangSanPhamActivity.class);
                intent.putExtra("IDsanpham",details.getIdSanPham());

                startActivity(intent);
            }
        });
        // truyen du lieu
        Horizontallayout=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(Horizontallayout);
        recyclerView.setAdapter(adapter2);
    }

    private void loadSPchocho() {
        recyclerView = (RecyclerView) findViewById(R.id.rcv_spchoCho);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);
        //add sp
        sanphamchocho = new ArrayList<>();

        //truy vấn
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
                " WHERE "+ DBHelperSanPham.COL_CATE1+" like '%chocho' ");
        while(c.moveToNext())
        {
            sanphamchocho.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter2=new HorAdapterSanphamLilPawHome(MainActivity.this, sanphamchocho, new HorAdapterSanphamLilPawHome.ItemClickListener() {
            @Override
            public void onItemClick(SanPhamLilPawHome details) {
                Intent intent = new Intent(MainActivity.this, TrangSanPhamActivity.class);
                intent.putExtra("IDsanpham",details.getIdSanPham());

                startActivity(intent);
            }
        });
        // truyen du lieu
        Horizontallayout=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(Horizontallayout);
        recyclerView.setAdapter(adapter2);
    }

    private void loadSPdexuat() {
        binding.gvSpdexuat.setExpanded(true);
        sanPhamDexuathome=new ArrayList<>();

        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
                " WHERE "+ DBHelperSanPham.COL_NEWPRICE+" < "+" 150000 ");
        while(c.moveToNext())
        {
            sanPhamDexuathome.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter3=new SanPhamAdapterLilPawHome(MainActivity.this,R.layout.list_sanpham_id,sanPhamDexuathome);
        binding.gvSpdexuat.setAdapter(adapter3);

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
        sanPhamgiamgia = new ArrayList<>();

        //truy vấn
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
                " WHERE "+ DBHelperSanPham.COL_DISCOUNT+" > 0.25 ");
        while(c.moveToNext())
        {
            sanPhamgiamgia.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter2=new HorAdapterSanphamLilPawHome(MainActivity.this, sanPhamgiamgia, new HorAdapterSanphamLilPawHome.ItemClickListener() {
            @Override
            public void onItemClick(SanPhamLilPawHome details) {
                Intent intent = new Intent(MainActivity.this, TrangSanPhamActivity.class);
                intent.putExtra("IDsanpham",details.getIdSanPham());

                startActivity(intent);
            }
        });
        // truyen du lieu
        Horizontallayout=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(Horizontallayout);
        recyclerView.setAdapter(adapter2);
    }
    private void loadSPbanchay(){
//        recyclerView = (RecyclerView) findViewById(R.id.rcv_spBanchay);
//        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(RecyclerViewLayoutManager);
//        //add sp
//        sanPhamsBanchay = new ArrayList<>();
//        sanPhamsBanchay.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
//        sanPhamsBanchay.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
//        sanPhamsBanchay.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
//        sanPhamsBanchay.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));
//        sanPhamsBanchay.add(new SanPham(R.drawable.hinhsanpham, "Thức ăn cho mèo Felipro 500g - Giảm sỏi mật - Vị hải sản", 32000, 36000, "Hãng: Felipiro", "Mèo", "Thức ăn"));

        // truyen du lieu
//        adapter2= new HorSanPhamAdapter(sanPhamsBanchay);
//        Horizontallayout=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
//        recyclerView.setLayoutManager(Horizontallayout);
//        recyclerView.setAdapter(adapter2);*/
        recyclerView = (RecyclerView) findViewById(R.id.rcv_spBanchay);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);
        //add sp
        sanPhamsBanchay = new ArrayList<>();

        //truy vấn
        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
                " WHERE "+ DBHelperSanPham.COL_CATE3+" = 'banchay' ");
        while(c.moveToNext())
        {
            sanPhamsBanchay.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
        }
        c.close();
        adapter2=new HorAdapterSanphamLilPawHome(MainActivity.this, sanPhamsBanchay, new HorAdapterSanphamLilPawHome.ItemClickListener() {
            @Override
            public void onItemClick(SanPhamLilPawHome details) {
                Intent intent = new Intent(MainActivity.this, TrangSanPhamActivity.class);
                intent.putExtra("IDsanpham",details.getIdSanPham());

                startActivity(intent);
            }
        });
        // truyen du lieu
        Horizontallayout=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(Horizontallayout);
        recyclerView.setAdapter(adapter2);

    }

}
