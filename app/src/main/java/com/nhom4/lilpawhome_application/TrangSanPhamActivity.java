package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.nhom4.adapters.AdapterDanhGiaSanPham;
import com.nhom4.adapters.SanphamAdapter;
import com.nhom4.lilpawhome_application.databinding.ActivityTrangSanPhamBinding;
import com.nhom4.models.DanhGiaSanPhamM;
import com.nhom4.models.SanPham;
import com.nhom4.view.ExpandableHeightGridView;

import java.util.ArrayList;

public class TrangSanPhamActivity extends AppCompatActivity {
    ActivityTrangSanPhamBinding binding;
    SanphamAdapter adapter;
    ArrayList<SanPham> sanPhamArrayList;

    AdapterDanhGiaSanPham adapterDanhGiaSanPham;
    ArrayList<DanhGiaSanPhamM> dsDanhGiaSanPham;

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
        loadData();
        addEvents();
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
}