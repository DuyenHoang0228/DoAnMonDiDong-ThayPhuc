package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.databinding.ActivityHosoMeoDetailBinding;

public class HosoMeoDetailActivity extends AppCompatActivity {

    ActivityHosoMeoDetailBinding binding;
    String[] giongmeo = {"Mướp", "Anh Lông Ngắn", "Anh Lông Dài", "Ba Tư", "Ai Cập (Sphynx)", "Munchkin chân ngắn", "Xiêm", "Ragdoll", "Tai cụp (Scottish)"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hoso_meo_detail);
        binding = ActivityHosoMeoDetailBinding.inflate(getLayoutInflater());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(binding.getRoot());

        ArrayAdapter adapterGiongmeo = new ArrayAdapter(this,android.R.layout.simple_list_item_1,giongmeo);
        binding.autotxtGiongmeo.setAdapter(adapterGiongmeo);
        binding.autotxtGiongmeo.setThreshold(1);
        addEvent();
        getData();

    }

    private void getData() {
        Intent intent = getIntent();
        String giong = intent.getStringExtra("giongcho");
        String ten = intent.getStringExtra("ten");
        int gioitinh = intent.getIntExtra("gioitinh", 0);
        Double cannang = intent.getDoubleExtra("cannang", 0);

        if(gioitinh == 0){
            binding.rbtnDuc.setChecked(true);
        }else {
            binding.rbtnCai.setChecked(true);
        }
        binding.edtCannang.setText(cannang + "");
        binding.edtMotathucung.setHint("Nhập mô tả cho thú cưng");
        binding.autotxtGiongmeo.setText(giong);
        binding.edtTenthucung.setText(ten);
        binding.edtSinhnhatpet.setHint("Thêm sinh nhật cho thú cưng");
    }

    private void addEvent() {
        binding.txtLuuthaydoiHs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HosoMeoDetailActivity.this, "Đã lưu thay đổi", Toast.LENGTH_SHORT).show();
            }
        });
        binding.txtXoaHs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HosoMeoDetailActivity.this);
                builder.setTitle("Xác nhận xóa");
                builder.setIcon(android.R.drawable.ic_dialog_info);
                builder.setMessage("Những thông tin bạn đã điền sẽ không được lưu?");

                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //close activity
                        finish();
                    }
                });
                builder.setNegativeButton("Quay lại", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                Dialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });
        binding.txtSpaHs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HosoMeoDetailActivity.this, SpaActivity1.class);
                startActivity(intent);
            }
        });
    }

    //Thêm menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        if (item_id == R.id.item_timkiem2) {
            Toast.makeText(this, "Tìm kiếm", Toast.LENGTH_SHORT).show();
            Dialog dialog = new Dialog(HosoMeoDetailActivity.this);
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
            Toast.makeText(this, "Shop cho chó", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HosoMeoDetailActivity.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HosoMeoDetailActivity.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HosoMeoDetailActivity.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HosoMeoDetailActivity.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HosoMeoDetailActivity.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HosoMeoDetailActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HosoMeoDetailActivity.this, BlogActivity.class);
            startActivity(intent);
        }
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}