package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import com.nhom4.databases.DBHelperSanPham;
import com.nhom4.lilpawhome_application.databinding.ActivityTrangSanPhamBinding;
import com.nhom4.models.DanhGiaSanPhamM;
import com.nhom4.models.GioHang;
import com.nhom4.models.SanPham;
import com.nhom4.models.SanPhamLilPawHome;
import com.nhom4.view.ExpandableHeightGridView;
import com.nhom4.view.adapters.AdapterDanhGiaSanPham;
import com.nhom4.view.adapters.SanPhamAdapterLilPawHome;
import com.nhom4.view.adapters.SanphamAdapter;

import java.util.ArrayList;

public class TrangSanPhamActivity extends AppCompatActivity {
    ActivityTrangSanPhamBinding binding;
    SanphamAdapter adapter;
    ArrayList<SanPham> sanPhamArrayList;
    ArrayList<SanPhamLilPawHome> sanPhamLilPawHomes;
    SanPhamAdapterLilPawHome adapterLilPawHome;

    AdapterDanhGiaSanPham adapterDanhGiaSanPham;
    ArrayList<DanhGiaSanPhamM> dsDanhGiaSanPham;
    DBHelperSanPham dbHelperSanPham;
    ImageView imvGioHang, imvTroVe;

    int idhinhsanpham;
    int IDsanpham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_trang_san_pham);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_trangsanpham);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#ffffff")));
        imvGioHang=findViewById(R.id.imv_giohang);
        imvTroVe=findViewById(R.id.imv_trove);
        binding=ActivityTrangSanPhamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnXemthem.setText("Xem th??m");
        binding.txtThongtinsanpham.setMaxLines(3);

        Intent intent = getIntent();
        IDsanpham = intent.getIntExtra("IDsanpham", 0);
        createDb();


        showData();
        loadData();
        addEvents();
        sanPhamDeXuat();
        ktYeuThich();


    }

    private void sanPhamDeXuat() {

    }

    public void intentt(){
        Intent intent = new Intent(TrangSanPhamActivity.this, HinhAnhDanhGiaSanPham.class);
        startActivity(intent);
    }
    private void addEvents() {
        binding.btnXemthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.btnXemthem.getText().toString().equalsIgnoreCase("???n b???t"))
                {
                    binding.txtThongtinsanpham.setMaxLines(3);//your TextView
                    binding.btnXemthem.setText("Xem th??m");
                }else
                {
                    binding.txtThongtinsanpham.setMaxLines(Integer.MAX_VALUE);//your TextView
                    binding.btnXemthem.setText("???n b???t");
                }
            }
        });
        binding.imvAnhdanhgia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentt();
            }
        });
        binding.imvAnhdanhgia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentt();
            }
        });
        binding.imvAnhdanhgia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentt();
            }
        });
        binding.imvAnhdanhgia4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentt();
            }
        });
        binding.txtXemtatcadanhgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangSanPhamActivity.this, DanhGiaSanPham.class);
                startActivity(intent);
            }
        });
        binding.imvTraitim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.imvTraitim.getTag()=="empty")
                {
                    binding.imvTraitim.setImageResource(R.drawable.icon_sp_yeu_thich_full);
                    binding.imvTraitim.setTag("full");
                    addFavorite();
                    Toast.makeText(TrangSanPhamActivity.this, "Th??m s???n ph???m v??o y??u th??ch", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    binding.imvTraitim.setImageResource(R.drawable.icon_sp_yeu_thich);
                    binding.imvTraitim.setTag("empty");
                    removeFavorite();
                    Toast.makeText(TrangSanPhamActivity.this, "B??? y??u th??ch", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.imvChiase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Link s???n ph???m");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, "Chia s??? li??n k???t");
                startActivity(shareIntent);
            }
        });
        binding.btnThemvaogiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), String.format("???? th??m s???n ph???m %s v??o gi??? h??ng.", binding.txtTensanphamTrangsanpham.getText()), Toast.LENGTH_LONG).show();
                addToCart();
            }
        });
        binding.btnMuangay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart();
                Intent intent = new Intent(TrangSanPhamActivity.this, GioHangActivity.class);
                startActivity(intent);
            }
        });
        imvGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangSanPhamActivity.this,GioHangActivity.class);

                startActivity(intent);
            }
        });
        imvTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.gvSanphamdexuat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TrangSanPhamActivity.this, TrangSanPhamActivity.class);
                SanPhamLilPawHome spitem = sanPhamLilPawHomes.get(i);
                intent.putExtra("IDsanpham",spitem.getIdSanPham());

                startActivity(intent);
            }
        });
        binding.txtXemtatcadanhgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangSanPhamActivity.this, DanhGiaSanPham.class);
                startActivity(intent);
            }
        });
        binding.imvAnhdanhgia4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangSanPhamActivity.this, HinhAnhDanhGiaSanPham.class);
                startActivity(intent);
            }
        });
    }
    private  void ktYeuThich(){
        boolean exists = false;
        if (MainActivity.spYeuThich.size() > 0) {
            for (int i = 0; i < MainActivity.spYeuThich.size(); i++) {
                if (MainActivity.spYeuThich.get(i).getIdSanPham() == IDsanpham) {
                    exists = true;
                }
            }
        }
        if(!exists){
            binding.imvTraitim.setImageResource(R.drawable.icon_sp_yeu_thich);
            binding.imvTraitim.setTag("empty");
        }else {
            binding.imvTraitim.setImageResource(R.drawable.icon_sp_yeu_thich_full);
            binding.imvTraitim.setTag("full");
        }
    }
    private void addFavorite(){
            Cursor c = dbHelperSanPham.getData(" SELECT * FROM " + DBHelperSanPham.TBL_NAME +
                    " WHERE " + DBHelperSanPham.COL_ID + " = " + IDsanpham);
            while (c.moveToNext()) {
                MainActivity.spYeuThich.add(new SanPhamLilPawHome(c.getInt(0), c.getString(1), c.getDouble(2), c.getDouble(3),
                        c.getDouble(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9),
                        c.getString(10), c.getDouble(11), c.getDouble(12), c.getDouble(13)));
            }
            c.close();

    }
    private  void removeFavorite() {
        for(int i =0; i< MainActivity.spYeuThich.size(); i++){
            if(MainActivity.spYeuThich.get(i).getIdSanPham()==IDsanpham){
                MainActivity.spYeuThich.remove(MainActivity.spYeuThich.get(i));
            }
        }
    }
    private void addToCart() {
        int soluong = 1;
        double Giamoi = Double.parseDouble(binding.txtGiamoiTrangsanpham.getText().toString().replaceAll("??",""));
        double Giacu = Double.parseDouble(binding.txtGiacu.getText().toString().replaceAll("??",""));
        String Tensanpham = binding.txtTensanphamTrangsanpham.getText().toString();
        int Idsanpham = Integer.parseInt(binding.txtIdsanpham.getText().toString());
        String Loaisanpham1 = binding.txtLoaisanpham1.getText().toString();
        String Tenthuonghieu = binding.txtThuonghieuTrangsanpham.getText().toString();
        String stringhinhsp = binding.txtStringhinhsp.getText().toString();

        if (MainActivity.manggiohang.size()>0) {
            boolean exists = false;
            for (int i = 0; i < MainActivity.manggiohang.size();i++){
                //Iterate trong m???ng gi??? h??ng xem c?? id s???n ph???m tr??ng kh??ng. N???u c?? th?? set s??? l?????ng sp trong m???ng gi??? h??ng +1
                if (MainActivity.manggiohang.get(i).getIdSanPham() == Idsanpham) {
                    MainActivity.manggiohang.get(i).setSoluongsp(MainActivity.manggiohang.get(i).getSoluongsp() + 1);
                    MainActivity.manggiohang.get(i).setTongtiensp(MainActivity.manggiohang.get(i).getSoluongsp() * MainActivity.manggiohang.get(i).getGiaMoiSanPham());
                    MainActivity.manggiohang.get(i).setSelected(false);
                    exists = true;
                }
            }
            //N???u sau khi ch???y v??ng l???p m?? v???n kh??ng t??m th???y s???n ph???m tr??ng trong gi??? h??ng th?? t???o m???i s???n ph???m trong gi??? h??ng
            if (!exists) {
                MainActivity.manggiohang.add(new GioHang(Idsanpham, Tensanpham, Giamoi, Giacu,
                        idhinhsanpham, Loaisanpham1, Tenthuonghieu, soluong, Giamoi, false));
            }
        }else{
            MainActivity.manggiohang.add(new GioHang(Idsanpham, Tensanpham, Giamoi, Giacu,
                    idhinhsanpham, Loaisanpham1, Tenthuonghieu, soluong, Giamoi, false));
        }
    }

    private void loadData() {
//        binding.gvSanphamdexuat.setExpanded(true);
//
//        Intent intent = getIntent();
//        String loaiSP1 = intent.getStringExtra("loaiSP1");
//
//        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
//                " WHERE "+ DBHelperSanPham.COL_CATE1+" = "+ loaiSP1);
//        while(c.moveToNext())
//        {
//            sanPhamLilPawHomes.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
//                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(????,c.getString(9),
//                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
//        }
//        c.close();
//        adapterLilPawHome=new SanPhamAdapterLilPawHome(TrangSanPhamActivity.this,R.layout.list_sanpham_id,sanPhamLilPawHomes);
//        binding.gvSanphamdexuat.setAdapter(adapterLilPawHome);
//        binding.gvSanphamdexuat.setExpanded(true);
//        Intent intent = getIntent();
//        int IDsanpham = intent.getIntExtra("IDsanpham",0);
//        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
//                " WHERE "+ DBHelperSanPham.COL_ID+" = "+ IDsanpham);
//        String loaiSP1=c.getString(6);
//        while(c.moveToNext())
//        {
//            if(c.getString(6)==loaiSP1)
//            {
//                sanPhamLilPawHomes.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
//                        c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(????,c.getString(9),
//                        c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));
//            }
//
//
//        }
//        c.close();
//        adapterLilPawHome=new SanPhamAdapterLilPawHome(TrangSanPhamActivity.this,R.layout.list_sanpham_id,sanPhamLilPawHomes);
//        binding.gvSanphamdexuat.setAdapter(adapterLilPawHome);



        binding.gvDanhgiasanpham.setExpanded(true);
        dsDanhGiaSanPham=new ArrayList<>();
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"Kim H???nh", 5, "????ng g??i s???n ph???m c???n th???n, s???n ph???m ?????p l???m, b?? ch?? nh?? m??nh th??ch m??", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "28/11/2022"));
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"Th???o Duy??n", 4, "Mua l???n ?????u c?? h??i lo l???ng, t???i l??c nh???n ???????c s???n ph???m b???t ng??? qu?? ch???ng, t???i n?? c??ng b??nh th?????ng ch??? kh??ng xu???t s???c nh?? m??nh ???? ngh??", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "20/11/2022"));
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"Ng???c Th???m", 4, "T???i d?? ti???n th??ch mua s???m v???y th??i, ch??? ch?? th?? m??nh ch??a nu??i", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "02/01/2022"));
        adapterDanhGiaSanPham=new AdapterDanhGiaSanPham(TrangSanPhamActivity.this, R.layout.danhgiasanpham_layout,dsDanhGiaSanPham);
        binding.gvDanhgiasanpham.setAdapter(adapterDanhGiaSanPham);

    }
    private void createDb() {
        dbHelperSanPham=new DBHelperSanPham(TrangSanPhamActivity.this);
        dbHelperSanPham.createSampleData();
    }

    private void showData() {
        binding.gvSanphamdexuat.setExpanded(true);
        sanPhamLilPawHomes=new ArrayList<>();

//        Intent intent = getIntent();
//        int IDsanpham = intent.getIntExtra("IDsanpham",0);

        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
                " WHERE "+ DBHelperSanPham.COL_ID+" = "+ IDsanpham);

        String loaiSP1="";

        while(c.moveToNext())
        {
            int resourceId = getResources().getIdentifier(c.getString(5), "drawable", getPackageName());
            idhinhsanpham = resourceId;
            binding.txtTensanphamTrangsanpham.setText(c.getString(1));
            binding.txtGiamoiTrangsanpham.setText(c.getDouble(2)+"??");
            binding.txtGiacu.setText(c.getDouble(3)+"??");
            String giamgia= "Ti???t ki???m "+ Math.round(c.getDouble(4)*100)  +"%";
            binding.txtGiamgia.setText(giamgia);
            binding.txtLoaisanpham1.setText(c.getString(6));
            binding.txtIdsanpham.setText(String.valueOf(c.getInt(0)));
            binding.imvAnhsanpham.setImageResource(resourceId);
            binding.txtThongtinsanpham.setText(c.getString(10));
            binding.txtSosaodanhgia.setText(c.getDouble(11)+"");
            String soluotban = "|S??? l?????t ???? b??n: "+c.getInt(12);
            binding.txtSoluotdaban.setText(soluotban);
            String soluotdanhgia = c.getDouble(11)+"/5 ("+c.getInt(13)+" l?????t ????nh gi??)";
            binding.txtSosaodanhgiaSoluotdaban.setText(soluotdanhgia);
            binding.txtThuonghieuTrangsanpham.setText(c.getString(9));
            loaiSP1=c.getString(6);



            /*sanphamchomeo.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(????,c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));*/
        }
        c.close();




        Cursor c1=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
                " WHERE "+ DBHelperSanPham.COL_CATE1+" = "+ "'"+loaiSP1+"'");
        while (c1.moveToNext())
        {
            sanPhamLilPawHomes.add(new SanPhamLilPawHome(c1.getInt(0),c1.getString(1),c1.getDouble(2), c1.getDouble(3),
                    c1.getDouble(4),c1.getString(5),c1.getString(6),c1.getString(7),c1.getString(8),c1.getString(9),
                    c1.getString(10),c1.getDouble(11),c1.getDouble(12),c1.getDouble(13)));
        }
        c1.close();
        adapterLilPawHome=new SanPhamAdapterLilPawHome(TrangSanPhamActivity.this,R.layout.list_sanpham_id,sanPhamLilPawHomes);
        binding.gvSanphamdexuat.setAdapter(adapterLilPawHome);



       /* int anhSanPham = intent.getIntExtra("anhSanPham",0);
        binding.imvAnhsanpham.setImageResource(anhSanPham);

        String tenSanPham=intent.getStringExtra("tenSanPham");
        binding.txtTensanphamTrangsanpham.setText(tenSanPham);

        double giaMoiSanPham =intent.getDoubleExtra("giaMoiSanPham",0);
        binding.txtGiamoiTrangsanpham.setText(giaMoiSanPham+"");
        double giaCuSanPham =intent.getDoubleExtra("giaCuSanPham",0);
        binding.txtGiacu.setText(giaCuSanPham+"");

        String thuongHieu = intent.getStringExtra("thuongHieu");
        binding.txtThuonghieuTrangsanpham.setText(thuongHieu);

        String loaiSanPham = intent.getStringExtra("loaiSanPham");

        String loaiSanPham2 = intent.getStringExtra("loaiSanPham2");
*/
        // intent.putExtra("anhSanPham",spitem.getIdAnhSanPham());
        //                intent.putExtra("tenSanPham",spitem.getTenSanPham());
        //                intent.putExtra("giaMoiSanPham",spitem.getGiaMoiSanPham());
        //                intent.putExtra("giaCuSanPham",spitem.getGiaCuSanPham());
        //                intent.putExtra("thuongHieu",spitem.getThuongHieuSanPham());
        //                intent.putExtra("loaiSanPham",spitem.getLoaiSanPham1());
        //                intent.putExtra("looaiSanPham2",spitem.getLoaiSanPham2());
        //                intent.putExtra("looaiSanPham3",spitem.getLoaiSanPham3());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.menu_trangsanpham,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int item_id = item.getItemId();
        if (item_id == R.id.item_timkiem2) {
            Toast.makeText(this, "T??m ki???m", Toast.LENGTH_SHORT).show();
            Dialog dialog = new Dialog(TrangSanPhamActivity.this);
            dialog.setContentView(R.layout.dialog_thanhtimkiem);
            dialog.show();
            ImageButton thoat;
            thoat = dialog.findViewById(R.id.btn_exittk);
            thoat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        } else if (item_id == R.id.item_shopchocho2) {
            Toast.makeText(this, "Shop cho ch??", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TrangSanPhamActivity.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho m??o", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TrangSanPhamActivity.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "??u ????i", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TrangSanPhamActivity.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TrangSanPhamActivity.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Th????ng hi???u", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TrangSanPhamActivity.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Tr??? v??? trang ch???", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TrangSanPhamActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TrangSanPhamActivity.this, BlogActivity.class);
            startActivity(intent);
        }

        return true;
    }
}