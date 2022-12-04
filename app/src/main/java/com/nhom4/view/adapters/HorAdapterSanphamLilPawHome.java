package com.nhom4.view.adapters;

import android.app.Activity;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.MainActivity;
import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.GioHang;
import com.nhom4.models.SanPham;
import com.nhom4.models.SanPhamLilPawHome;

import java.util.List;

public class HorAdapterSanphamLilPawHome extends RecyclerView.Adapter<HorAdapterSanphamLilPawHome.MyView>{
    Activity activity;

    List<SanPhamLilPawHome> sanPhamLilPawHomes;
    ItemClickListener mItemListener;

    public HorAdapterSanphamLilPawHome(Activity activity, List<SanPhamLilPawHome> sanPhamLilPawHomes, ItemClickListener mItemListener) {
        this.activity = activity;
        this.sanPhamLilPawHomes = sanPhamLilPawHomes;
        this.mItemListener = mItemListener;
    }

    public class MyView extends RecyclerView.ViewHolder {

        ImageView imvhinhsanpham, imvgiohang;
        TextView txttensanpham, txtbrandsanpham, txtgiasanphamchuagiam, txtgiasanphamdagiam, txtloaisp1, txtidsanpham;

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        public MyView(View view)
        {
            super(view);

            // Tìm các thuộc tính có trong file layout list sản phẩm
            txttensanpham = (TextView)view.findViewById(R.id.txt_tensanpham);
            txtbrandsanpham = (TextView)view.findViewById(R.id.txt_brandsanpham);
            txtgiasanphamchuagiam = (TextView)view.findViewById(R.id.txt_giasanphamchuagiam);
            txtgiasanphamdagiam = (TextView)view.findViewById(R.id.txt_giasanphamdagiam);
            imvhinhsanpham = (ImageView) view.findViewById(R.id.imv_hinhsanpham);
            imvgiohang = view.findViewById(R.id.imv_gioHang);
            txtidsanpham = view.findViewById(R.id.txt_idsanpham);
            txtloaisp1 = view.findViewById(R.id.txt_loaisanpham1);
        }
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_sanpham_id, parent, false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HorAdapterSanphamLilPawHome.MyView holder, int position) {
        SanPhamLilPawHome sp = sanPhamLilPawHomes.get(position);
        holder.txttensanpham .setText(sp.getTenSanPham());
        holder.txtbrandsanpham.setText(sp.getThuongHieuSanPham());
        holder.txtgiasanphamdagiam.setText(String.format("%.0fđ",sp.getGiaMoiSanPham()));
        holder.txtgiasanphamchuagiam.setText(String.format("%.0fđ",sp.getGiaCuSanPham()));
        holder.txtidsanpham.setText(String.valueOf(sp.getIdSanPham()));
        holder.txtloaisp1.setText(sp.getLoaiSanPham1());

        //gọi tên ảnh trong drawable
        int img_id=activity.getResources().getIdentifier(
                sanPhamLilPawHomes.get(position).getIdAnhSanPham(),"drawable",activity.getPackageName()
        );

        //truyền id vào
        holder.imvhinhsanpham.setImageResource(img_id);
        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(sanPhamLilPawHomes.get(position));
        });
        holder.imvgiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), String.format("Đã thêm sản phẩm %s vào giỏ hàng.", holder.txttensanpham.getText()), Toast.LENGTH_LONG).show();
                int soluong = 1;
                double Giamoi = Double.parseDouble(holder.txtgiasanphamdagiam.getText().toString().replaceAll("đ",""));
                double Giacu = Double.parseDouble(holder.txtgiasanphamchuagiam.getText().toString().replaceAll("đ",""));
                String Tensanpham = holder.txttensanpham.getText().toString();
                int Idsanpham = Integer.parseInt(holder.txtidsanpham.getText().toString());
                String Loaisanpham1 = holder.txtloaisp1.getText().toString();
                String Tenthuonghieu = holder.txtbrandsanpham.getText().toString();

                if (MainActivity.manggiohang.size()>0) {
                    boolean exists = false;
                    for (int i = 0; i < MainActivity.manggiohang.size();i++){
                        //Iterate trong mảng giỏ hàng xem có id sản phẩm trùng không. Nếu có thì set số lượng sp trong mảng giỏ hàng +1
                        if (MainActivity.manggiohang.get(i).getIdSanPham() == Idsanpham) {
                            MainActivity.manggiohang.get(i).setSoluongsp(MainActivity.manggiohang.get(i).getSoluongsp() + 1);
                            MainActivity.manggiohang.get(i).setTongtiensp(MainActivity.manggiohang.get(i).getSoluongsp() * MainActivity.manggiohang.get(i).getGiaMoiSanPham());
                            MainActivity.manggiohang.get(i).setSelected(false);
                            exists = true;
                        }
                    }
                    //Nếu sau khi chạy vòng lặp mà vẫn không tìm thấy sản phẩm trùng trong giỏ hàng thì tạo mới sản phẩm trong giỏ hàng
                    if (!exists) {
                        MainActivity.manggiohang.add(new GioHang(Idsanpham, Tensanpham, Giamoi, Giacu,
                                img_id, Loaisanpham1, Tenthuonghieu, soluong, Giamoi, false));
                    }
                }else{
                    MainActivity.manggiohang.add(new GioHang(Idsanpham, Tensanpham, Giamoi, Giacu,
                            img_id, Loaisanpham1, Tenthuonghieu, soluong, Giamoi, false));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sanPhamLilPawHomes.size();
    }

    public interface ItemClickListener {
        void onItemClick(SanPhamLilPawHome details);
    }
}
