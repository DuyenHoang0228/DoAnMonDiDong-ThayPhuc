package com.nhom4.models;

public class Blog {
    int blogImage;
    String blogTitle, blogCategory1, blogCategory2, blogSubtitle;

    public Blog(int blogImage, String blogTitle, String blogCategory1, String blogCategory2, String blogSubtitle) {
        this.blogImage = blogImage;
        this.blogTitle = blogTitle;
        this.blogCategory1 = blogCategory1;
        this.blogCategory2 = blogCategory2;
        this.blogSubtitle = blogSubtitle;
    }

    public int getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(int blogImage) {
        this.blogImage = blogImage;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogCategory1() {
        return blogCategory1;
    }

    public void setBlogCategory1(String blogCategory1) {
        this.blogCategory1 = blogCategory1;
    }

    public String getBlogCategory2() {
        return blogCategory2;
    }

    public void setBlogCategory2(String blogCategory2) {
        this.blogCategory2 = blogCategory2;
    }

    public String getBlogSubtitle() {
        return blogSubtitle;
    }

    public void setBlogSubtitle(String blogSubtitle) {
        this.blogSubtitle = blogSubtitle;
    }
}
