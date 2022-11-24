package com.nhom4.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom4.lilpawhome_application.R;
import com.nhom4.models.Blog;

import java.util.List;

public class AdapterBlog extends RecyclerView.Adapter<AdapterBlog.MyView> {

    List<Blog> blogs;

    // Tạo MyView class từ Adapter để mở rộng sang class ViewHolder
    public class MyView extends RecyclerView.ViewHolder {

        ImageView imvhinhblog;
        TextView txtblogtitle, txtblogcategory1, txtblogcategory2, txtblogsubtitle;

        public MyView(@NonNull View itemView) {
            super(itemView);

            // Tìm các thuộc tính có trong file layout list sản phẩm
            imvhinhblog = itemView.findViewById(R.id.imv_hinhblog);
            txtblogtitle = itemView.findViewById(R.id.txt_blogtitle);
            txtblogcategory1 = itemView.findViewById(R.id.txt_blogcategory1);
            txtblogcategory2 = itemView.findViewById(R.id.txt_blogcategory2);
            txtblogsubtitle = itemView.findViewById(R.id.txt_blogsubtitle);
        }
    }

    public AdapterBlog(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Nạp layout của file blog_id vào LayoutInflater
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_id, parent, false);

        // Xuất layout ra màn hình
        return new MyView(itemView);
    }

    // Binding dữ liệu
    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {

        Blog b = blogs.get(position);
        holder.imvhinhblog.setImageResource(b.getBlogImage());
        holder.txtblogtitle.setText(b.getBlogTitle());
        holder.txtblogcategory1.setText(b.getBlogCategory1());
        holder.txtblogcategory2.setText(b.getBlogCategory2());
        holder.txtblogsubtitle.setText(b.getBlogSubtitle());

    }

    @Override
    public int getItemCount() {
        return blogs.size();
    }


}
