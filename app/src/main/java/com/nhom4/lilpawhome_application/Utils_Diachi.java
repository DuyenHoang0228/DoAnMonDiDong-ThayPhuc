package com.nhom4.lilpawhome_application;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Utils_Diachi extends SQLiteOpenHelper {
    public static final String DB_NAME = "diachi.db";
    public static final String DB_PATH_SUFFIX = "/databases/";
    public static final int DB_VERSION = 1;


    public static final String TBL_NAME = "Diachi";
    public static final String COL_ID = "ID";
    public static final String COL_NAME = "Hoten";
    public static final String COL_TYPE = "LoaiDiaChi";
    public static final String COL_PHONE = "Sodienthoai";
    public static final String COL_TINH = "Tinh";
    public static final String COL_QUAN = "Quan_Huyen";
    public static final String COL_PHUONG = "Phuong";
    public static final String COL_DUONG = "Duong";
    public static final String COL_MacDinh = "MacDinh";

    public Utils_Diachi(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
