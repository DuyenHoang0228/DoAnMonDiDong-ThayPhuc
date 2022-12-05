package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.databinding.ActivityFormDanhGiaSanPhamBinding;

public class FormDanhGiaSanPham extends AppCompatActivity {

    ActivityFormDanhGiaSanPhamBinding binding;
    private static final int pic_id = 123;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_form_danh_gia_san_pham);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = ActivityFormDanhGiaSanPhamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvent();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (i%3==1) {
            if (requestCode == pic_id) {
                // BitMap is data structure of image file which store the image in memory
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                // Set the image in imageview for display
                binding.imvAnh2.setImageBitmap(photo);
                i++;
            }
        }
        else if(i%3==2){
            if (requestCode == pic_id) {
                // BitMap is data structure of image file which store the image in memory
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                // Set the image in imageview for display
                binding.imvAnh3.setImageBitmap(photo);
                i++;
            }
        }
        else {
            if (requestCode == pic_id) {
                // BitMap is data structure of image file which store the image in memory
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                // Set the image in imageview for display
                binding.imvAnh1.setImageBitmap(photo);
                i++;
            }
        }
    }

    private void addEvent() {
        binding.rbChatluongsanpham.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(v==5.0){
                    binding.txtChatluongsanpham.setText("Tuyệt vời");
                }else if(v==4.0){
                    binding.txtChatluongsanpham.setText("Hài lòng");
                }else if(v==3.0){
                    binding.txtChatluongsanpham.setText("Bình thường");
                }else if(v==2.0){
                    binding.txtChatluongsanpham.setText("Không hài lòng");
                }else {
                    binding.txtChatluongsanpham.setText("Tệ");
                }
            }
        });
        binding.rbDichvuvanchuyen.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(v==5.0){
                    binding.txtDichvuvanchuyen.setText("Tuyệt vời");
                }else if(v==4.0){
                    binding.txtDichvuvanchuyen.setText("Hài lòng");
                }else if(v==3.0){
                    binding.txtDichvuvanchuyen.setText("Bình thường");
                }else if(v==2.0){
                    binding.txtDichvuvanchuyen.setText("Không hài lòng");
                }else {
                    binding.txtDichvuvanchuyen.setText("Tệ");
                }
            }
        });
        binding.openCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                if(i==0){
                    //Show default dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(FormDanhGiaSanPham.this);
                    builder.setTitle("Thông báo");
                    builder.setIcon(android.R.drawable.ic_dialog_info);
                    builder.setMessage("Cho phép ứng dụng truy cập camera của bạn?");

                    builder.setPositiveButton("Cho phép", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //open camera
                            startActivityForResult(intent,pic_id);
                        }
                    });
                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    Dialog dialog = builder.create();
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                }else {
                    startActivityForResult(intent,pic_id);
                }

            }
        });
        binding.btnDangDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FormDanhGiaSanPham.this, "Cảm ơn bạn đã đánh giá", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FormDanhGiaSanPham.this, DanhGiaCuaToi.class);
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
            Dialog dialog = new Dialog(FormDanhGiaSanPham.this);
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
            Intent intent = new Intent(FormDanhGiaSanPham.this, ShopChoCho1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_shopchomeo2) {
            Toast.makeText(this, "Shop cho mèo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(FormDanhGiaSanPham.this, ShopChoMeo1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_uudai2) {
            Toast.makeText(this, "Ưu đãi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(FormDanhGiaSanPham.this, UuDaiMain.class);
            startActivity(intent);
        } else if (item_id == R.id.item_spa2) {
            Toast.makeText(this, "Spa", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(FormDanhGiaSanPham.this, SpaActivity1.class);
            startActivity(intent);
        } else if (item_id == R.id.item_thuonghieu2) {
            Toast.makeText(this, "Thương hiệu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(FormDanhGiaSanPham.this, ThuongHieuActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_trangchu2) {
            Toast.makeText(this, "Trở về trang chủ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(FormDanhGiaSanPham.this, MainActivity.class);
            startActivity(intent);
        } else if (item_id == R.id.item_blog2) {
            Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(FormDanhGiaSanPham.this, BlogActivity.class);
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