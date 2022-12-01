package com.nhom4.lilpawhome_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nhom4.adapters.AdapterBlog;
import com.nhom4.adapters.HorSanPhamAdapter;
import com.nhom4.models.Blog;

import java.util.ArrayList;

public class BlogActivity extends AppCompatActivity {

    AdapterBlog adapter;
    ArrayList<Blog> blogs;
    LinearLayoutManager VerticalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        recyclerView = (RecyclerView)findViewById(R.id.rv_blog);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        // Set LayoutManager on Recycler View
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);

        loadData();

        adapter = new AdapterBlog(blogs);

        // Thiết lập phương hướng của RecyclerView (ngang hay dọc)
        VerticalLayout = new LinearLayoutManager(BlogActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(VerticalLayout);

        //Tạo khoảng cách giữa các item trong RecyclerView
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                VerticalLayout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getBaseContext(),
                R.drawable.line_divider));

        recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        blogs = new ArrayList<>();
        blogs.add(new Blog(R.drawable.blog_uongnuoc, "Mèo uống nước bồn cầu có sao không?",
                "Hỏi đáp", "Hành vi mèo", "Cùng chuyên gia của Lilpaw Home giải đáp vấn đề này nhé"));
        blogs.add(new Blog(R.drawable.blog_pate, "Cách làm pate gan cho mèo ú",
                "Vào bếp", "Chăm sóc mèo", "Cách làm pate tại nhà an toàn, vệ sinh, mèo ăn thoải mái vô tư"));
        blogs.add(new Blog(R.drawable.blog_chaymu, "Điều trị chó bị loét da chảy mũ",
                "Cún khỏe", "Cách điều trị","Chó bị loét da chảy mũ là căn bệnh da liễu thường gặp."));
        blogs.add(new Blog(R.drawable.blog_ngodoc, "Chó bị ngộ độc - Nguyên nhân và cách xử lí phải biết",
                "Sơ cứu", "Cún khỏe", "Cùng chuyên gia của Lilpaw Home giải đáp vấn đề này nhé"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.timkiembaidang_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        if (item_id == R.id.item_timkiembaidang) {
            Toast.makeText(this, "Tìm kiếm bài đăng", Toast.LENGTH_SHORT).show();
         //   Intent intent = new Intent(BlogActivity.this, ShopChoCho1.class);
          //  startActivity(intent);
        } else if (item_id == R.id.item_baidangvecho) {
            Toast.makeText(this, "Bài đăng về chó", Toast.LENGTH_SHORT).show();
          //  Intent intent = new Intent(BlogActivity.this, ShopChoCho1.class);
           // startActivity(intent);
        } else if (item_id == R.id.item_baidangvemeo) {
            Toast.makeText(this, "Bài đăng về mèo", Toast.LENGTH_SHORT).show();
          //  Intent intent = new Intent(BlogActivity.this, UuDaiMain.class);
           // startActivity(intent);
        } else if (item_id == R.id.item_chiasekynang) {
            Toast.makeText(this, "Bài đăng chia sẻ kỹ năng", Toast.LENGTH_SHORT).show();
           // Intent intent = new Intent(BlogActivity.this, SpaActivity1.class);
           // startActivity(intent);
        }
        return true;
    }
}