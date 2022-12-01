package com.nhom4.lilpawhome_application;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Utils_Spa extends SQLiteOpenHelper {
    public static final String DB_NAME = "thucung_info.db";
    public static final String DB_PATH_SUFFIX = "/databases/";
    public static final int DB_VERSION = 1;


    public static final String TBL_NAME = "Thucung";
    public static final String COL_ID = "ID";
    public static final String COL_NAME = "Pet_name";
    public static final String COL_TYPE = "Pet_type";
    public static final String COL_GENDER = "Gender";
    public static final String COL_SPECIES = "Specices";
    public static final String COL_WEIGHT = "Weight";

    //Constructor


    public Utils_Spa(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
