package com.example.ravin.sqliteravin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by ravin on 16/01/2017.
 */

public class SqlHelper extends SQLiteOpenHelper {
    public static final String DBname="student";
    public static final String TBname="studs";
    public SqlHelper(Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql="create table "+TBname+"(no Text,pwd Text,city Text)";
        db.execSQL(sql);

        Log.e("tb","Table created..");
    }
    public void insertData(MyBean myBean)
    {
        SQLiteDatabase db=getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("no",myBean.getNo());
        values.put("pwd",myBean .getPwd());
        values.put("city",myBean.getCity());
        db.insert(TBname,null,values);
        db.close();
        Log.e("tb","Table Inserted..");
    }

    public ArrayList<MyBean> displayData() {
        ArrayList<MyBean> arrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from "+ TBname;
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            MyBean myBean = new MyBean();
            myBean.setNo(cursor.getString(0));
            myBean.setPwd(cursor.getString(1));
            myBean.setCity(cursor.getString(2));
            arrayList.add(myBean);
        }
        db.close();
        return arrayList;

    }

    public void delete(String name)
    {
        SQLiteDatabase db=getWritableDatabase();
        String sql="delete from "+TBname+" where city='"+name+"'";
     //   db.delete(TBname,"city='"+name+"'",null);

       db.execSQL(sql);

        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="drop database if exists"+DBname;
        db.execSQL(sql);
        onCreate(db);

    }
}
