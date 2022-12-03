package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.nhom4.adapters.AdapterDanhGiaSanPham;
import com.nhom4.adapters.SanphamAdapter;
import com.nhom4.databases.DBHelperSanPham;
import com.nhom4.lilpawhome_application.databinding.ActivityTrangSanPhamBinding;
import com.nhom4.models.DanhGiaSanPhamM;
import com.nhom4.models.SanPham;
import com.nhom4.models.SanPhamLilPawHome;
import com.nhom4.view.ExpandableHeightGridView;

import java.util.ArrayList;

public class TrangSanPhamActivity extends AppCompatActivity {
    ActivityTrangSanPhamBinding binding;
    SanphamAdapter adapter;
    ArrayList<SanPham> sanPhamArrayList;

    AdapterDanhGiaSanPham adapterDanhGiaSanPham;
    ArrayList<DanhGiaSanPhamM> dsDanhGiaSanPham;
    DBHelperSanPham dbHelperSanPham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_trang_san_pham);


//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.custom_actionbar_trangsanpham);
        binding=ActivityTrangSanPhamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnXemthem.setText("Xem thêm");
        binding.txtThongtinsanpham.setMaxLines(3);

        createDb();
        loadData();
        addEvents();
        showData();
    }


    private void addEvents() {
        binding.btnXemthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.btnXemthem.getText().toString().equalsIgnoreCase("Ẩn bớt"))
                {
                    binding.txtThongtinsanpham.setMaxLines(3);//your TextView
                    binding.btnXemthem.setText("Xem thêm");
                }else
                {
                    binding.txtThongtinsanpham.setMaxLines(Integer.MAX_VALUE);//your TextView
                    binding.btnXemthem.setText("Ẩn bớt");
                }
            }
        });
    }

    private void loadData() {

        binding.gvSanphamdexuat.setExpanded(true);
        sanPhamArrayList=new ArrayList<>();
        sanPhamArrayList.add(new SanPham(R.drawable.sphatcho,"Hạt cho chó",120000,200000,
                "Thương hiệu 1","thucanchocho","hatchocho"));
        sanPhamArrayList.add(new SanPham(R.drawable.sppatecho,"Pate cho chó",350000,400000,
                "Thương hiệu 1","thucanchocho","patechocho"));
        sanPhamArrayList.add(new SanPham(R.drawable.spsuacho,"Sữa tắm chó",250000,300000,
                "Thương hiệu 2","thucanchocho","suacho"));
        sanPhamArrayList.add(new SanPham(R.drawable.spsuatamcho,"Sữa tắm chó",120000,320000,
                "Thương hiệu 2","dodungcho","suatamcho"));
        sanPhamArrayList.add(new SanPham(R.drawable.spxuongcho,"Xương chó đồ chơi",20000,50000,
                "Thương hiệu 3","dochoicho","xuongcho"));
        sanPhamArrayList.add(new SanPham(R.drawable.spdinhduongcho,"Sữa dinh dưỡng cho chó",360000,500000,
                "Thương hiệu 3","thucanchocho","dinhduongchocho"));
        sanPhamArrayList.add(new SanPham(R.drawable.sptaimatmiengcho,"Cây chà răng chó",25000,40000,
                "Thương hiệu 4","dodungcho","taimatcho"));

        adapter=new SanphamAdapter(TrangSanPhamActivity.this,R.layout.list_sanpham_id,sanPhamArrayList);
        binding.gvSanphamdexuat.setAdapter(adapter);


        binding.gvDanhgiasanpham.setExpanded(true);
        dsDanhGiaSanPham=new ArrayList<>();
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"Kim Hạnh", 5, "Đóng gói sản phẩm cẩn thận, sản phẩm đẹp lắm, bé chó nhà mình thích mê", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "28/11/2022"));
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"Thảo Duyên", 4, "Mua lần đầu có hơi lo lắng, tới lúc nhận được sản phẩm bất ngờ quá chừng, tại nó cũng bình thường chứ không xuất sắc như mình đã nghĩ", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "20/11/2022"));
        dsDanhGiaSanPham.add(new DanhGiaSanPhamM(R.drawable.avatar_concho,"Ngọc Thẩm", 4, "Tại dư tiền thích mua sắm vậy thôi, chứ chó thì mình chưa nuôi", R.drawable.splongmong, R.drawable.spkhaymeo, R.drawable.spkhay, "02/01/2022"));
        adapterDanhGiaSanPham=new AdapterDanhGiaSanPham(TrangSanPhamActivity.this, R.layout.danhgiasanpham_layout,dsDanhGiaSanPham);
        binding.gvDanhgiasanpham.setAdapter(adapterDanhGiaSanPham);

    }
    private void createDb() {
        dbHelperSanPham=new DBHelperSanPham(TrangSanPhamActivity.this);
        dbHelperSanPham.createSampleData();
    }

    private void showData() {
        Intent intent = getIntent();
        int IDsanpham = intent.getIntExtra("IDsanpham",0);

        Cursor c=dbHelperSanPham.getData(" SELECT * FROM "+ DBHelperSanPham.TBL_NAME +
                " WHERE "+ DBHelperSanPham.COL_ID+" = "+ IDsanpham);
        while(c.moveToNext())
        {
            int resourceId = getResources().getIdentifier(c.getString(5), "drawable", getPackageName());
            binding.txtTensanphamTrangsanpham.setText(c.getString(1));
            binding.txtGiamoiTrangsanpham.setText(c.getDouble(2)+"đ");
            binding.txtGiacu.setText(c.getDouble(3)+"đ");
            String giamgia= "Tiêt kiệm "+ c.getDouble(4)*100 +"%";
            binding.txtGiamgia.setText(giamgia);

            binding.imvAnhsanpham.setImageResource(resourceId);
            binding.txtThongtinsanpham.setText(c.getString(10));
            binding.txtSosaodanhgia.setText(c.getDouble(11)+"");
            String soluotban = "|Số lượt đã bán: "+c.getInt(12);
            binding.txtSoluotdaban.setText(soluotban);
            String soluotdanhgia = c.getDouble(11)+"/5 ("+c.getInt(13)+" lượt đánh giá)";
            binding.txtSosaodanhgiaSoluotdaban.setText(soluotdanhgia);
            binding.txtThuonghieuTrangsanpham.setText(c.getString(9));

            /*sanphamchomeo.add(new SanPhamLilPawHome(c.getInt(0),c.getString(1),c.getDouble(2), c.getDouble(3),
                    c.getDouble(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getDouble(11),c.getDouble(12),c.getDouble(13)));*/
        }
        c.close();

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


}