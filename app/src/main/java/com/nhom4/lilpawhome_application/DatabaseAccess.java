package com.nhom4.lilpawhome_application;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    static DatabaseAccess instance;
    Cursor c = null;

    //Khai báo constructor bằng private để tạo class kín trong activity
    private DatabaseAccess(Context context){
        this.openHelper = new Utils_Spa(context, Utils_Spa.DB_NAME, null, Utils_Spa.DB_VERSION);
    }


    //Nếu db trong activity không có bất kì quan sát (dòng dữ liệu) nào thì bắt đầu thực hiện function DatabaseAccess thiết lập đường dẫn và cách thức đọc db
    public static DatabaseAccess getInstance(Context context) {
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;//Nếu có quan sát thì trả về dòng dữ liệu có trong db
    }

    //Thực hiện đọc db nhờ các thiết lập từ DatabaseAccess
    public SQLiteDatabase open() {
        this.db = openHelper.getWritableDatabase();
        return this.db;
    }

    //Đóng kết nối đến db sau khi đọc xong
    public void close(){
        if(db != null){
            this.db.close();
        }
    }



}
