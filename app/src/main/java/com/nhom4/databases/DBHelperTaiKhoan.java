package com.nhom4.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperTaiKhoan extends SQLiteOpenHelper {
    public static final String DB_NAME="SanPhamLilPawHome.sqlite";
    public static final int DB_VERSION=1;

    public static final String TBL_NAME="TaiKhoan";
    public static final String COL_USERID="IDKhachhang";
    public static final String COL_NAME="TenKhachhang";
    public static final String COL_EMAIL="EmailKhachhang";
    public static final String COL_PHONENUMBER="SoDienthoai";
    public static final String COL_PASSWORD="Password";
    public static final String COL_ADDRESS="Diachi";
    public static final String COL_DATECREATED="Ngaytao";
    public static final String COL_AWARD="Danhhieu";
    public DBHelperTaiKhoan(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE IF NOT EXISTS " + TBL_NAME +
                " ("+COL_USERID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME+" TEXT, "
                +COL_EMAIL+" NCHAR(20), "
                +COL_PHONENUMBER+" NCHAR(10), "
                +COL_AWARD+" NVARCHAR(20), "
                +COL_PASSWORD+" VARCHAR(6), "
                +COL_ADDRESS+" NCHAR(10) "+ ")";
        sqLiteDatabase.execSQL(sql);
    }
    public Cursor getData(String sql)
    {
        SQLiteDatabase db=getReadableDatabase();
        return db.rawQuery(sql,null);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void createSampleData(){
        if(numbOfRows()==0){
            exeSql("INSERT INTO "+TBL_NAME+" VALUES(null, 'Thảo Duyên','duyenhnt20411@st.uel.edu.vn','012345678','Khách hàng Bạc','123456', 19000)");
        }
    }

    private void exeSql(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    private int numbOfRows() {
        Cursor cursor= getData(" SELECT * FROM "+ TBL_NAME);
        int count=cursor.getCount();
        cursor.close();
        return count;
    }
}
