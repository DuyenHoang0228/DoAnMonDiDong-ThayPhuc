package com.nhom4.lilpawhome_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.nhom4.lilpawhome_application.databinding.ActivityBlogDetailBinding;

import java.io.IOException;
import java.io.InputStream;

public class BlogDetailActivity extends AppCompatActivity {

    ActivityBlogDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_blog_detail);
        binding = ActivityBlogDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.wvBlogdetail.loadUrl("file:///android_asset/demo_blog.html");
    }
}