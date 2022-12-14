package com.nhom4.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nhom4.lilpawhome_application.MainActivity;
import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.GioHang;
import com.nhom4.models.SanPham;
import com.nhom4.models.SanPhamLilPawHome;

import java.util.List;

public class SanPhamAdapterLilPawHome extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<SanPhamLilPawHome> sanPhamLilPawHomes;

    public SanPhamAdapterLilPawHome(Activity activity, int item_layout, List<SanPhamLilPawHome> sanPhamLilPawHomes) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.sanPhamLilPawHomes = sanPhamLilPawHomes;
    }

    @Override
    public int getCount() {
        return sanPhamLilPawHomes.size();
    }

    @Override
    public Object getItem(int i) {
        return sanPhamLilPawHomes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null)
        {
            holder= new ViewHolder();
            LayoutInflater layoutInflater= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(item_layout,null);
            holder.imvAnhSanPham=view.findViewById(R.id.imv_hinhsanpham);
            holder.txtTenSanPham=view.findViewById(R.id.txt_tensanpham);
            holder.txtTenThuongHieu=view.findViewById(R.id.txt_brandsanpham);
            holder.txtGiaMoi=view.findViewById(R.id.txt_giasanphamdagiam);
            holder.txtGiaCu=view.findViewById(R.id.txt_giasanphamchuagiam);
            holder.imvAnhGioHang=view.findViewById(R.id.imv_gioHang);
            holder.txtloaiSanPham1 = view.findViewById(R.id.txt_loaisanpham1);
            holder.txtidsanpham = view.findViewById(R.id.txt_idsanpham);
            holder.txtstringhinhsp = view.findViewById(R.id.txt_stringhinhsp);
            holder.txttongtiensp = view.findViewById(R.id.txt_tongtiensp);
            view.setTag(holder);

        }else
        {
            holder= (ViewHolder) view.getTag();
        }
        SanPhamLilPawHome sp=sanPhamLilPawHomes.get(i);

        holder.txtTenSanPham.setText(sp.getTenSanPham());
        holder.txtTenThuongHieu.setText(sp.getThuongHieuSanPham());
        holder.txtGiaMoi.setText(String.format("%.0f??",sp.getGiaMoiSanPham()));
        holder.txtGiaCu.setText(String.format("%.0f??",sp.getGiaCuSanPham()));
        holder.txtloaiSanPham1.setText(sp.getLoaiSanPham1());
        holder.txtidsanpham.setText(String.valueOf(sp.getIdSanPham()));
        holder.txtstringhinhsp.setText(sp.getIdAnhSanPham());
        holder.txttongtiensp.setText(String.format("%.0f??", sp.getGiaMoiSanPham()));

        //g???i t??n ???nh trong drawable
        int img_id=activity.getResources().getIdentifier(
                sanPhamLilPawHomes.get(i).getIdAnhSanPham(),"drawable",activity.getPackageName()
        );

        //truy???n id v??o
        holder.imvAnhSanPham.setImageResource(img_id);


        //set s??? ki???n cho n??t gi??? h??ng
        holder.imvAnhGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), String.format("???? th??m s???n ph???m %s v??o gi??? h??ng.", holder.txtTenSanPham.getText()), Toast.LENGTH_LONG).show();
                int soluong = 1;
                double Giamoi = Double.parseDouble(holder.txtGiaMoi.getText().toString().replaceAll("??",""));
                double Giacu = Double.parseDouble(holder.txtGiaCu.getText().toString().replaceAll("??",""));
                String Tensanpham = holder.txtTenSanPham.getText().toString();
                int Idsanpham = Integer.parseInt(holder.txtidsanpham.getText().toString());
                String stringhinhsp = holder.txtstringhinhsp.getText().toString();
                String Loaisanpham1 = holder.txtloaiSanPham1.getText().toString();
                String Tenthuonghieu = holder.txtTenThuongHieu.getText().toString();
                double Tongtiensp = Double.parseDouble(holder.txttongtiensp.getText().toString().replace("??",""));

                int img_id = activity.getResources().getIdentifier(
                        stringhinhsp,"drawable",activity.getPackageName()
                );
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
                                img_id, Loaisanpham1, Tenthuonghieu, soluong, Tongtiensp, false));
                    }
                }else{
                    MainActivity.manggiohang.add(new GioHang(Idsanpham, Tensanpham, Giamoi, Giacu,
                            img_id, Loaisanpham1, Tenthuonghieu, soluong, Tongtiensp, false));
                }
            }
        });

        return view;
    }


    public static class ViewHolder
    {
        ImageView imvAnhSanPham, imvAnhGioHang;
        TextView txtTenSanPham, txtTenThuongHieu, txtGiaMoi, txtGiaCu, txtloaiSanPham1, txtidsanpham, txtstringhinhsp, txttongtiensp;


    }
}
