package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Adil on 26-02-2018.
 */

public class databasehelper extends SQLiteOpenHelper {

    public databasehelper(Context context) {
        super(context,"login.db",null,1 );
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //sqLiteDatabase.execSQL("CREATE TABLE  user(email text primary key,password text)");
        sqLiteDatabase.execSQL("CREATE TABLE  user ( id INTEGER PRIMARY KEY AUTOINCREMENT,  email  VARCHAR(255) ,password VARCHAR(225))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
    }

    public boolean inssert(String email, String password){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result=db.insert("user",null,contentValues);

        if (result==-1)
            return false;
        else
            return true;
    }
    public Cursor getdata(){

        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from  user";

        Cursor cursor= db.rawQuery(query,null);
        return cursor;
    }

    public boolean checkemail (String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from user where email=?",new String[]{email});
        if (cursor.getCount()>0)
            return false;
        else
            return true;
    }

    public boolean emailpassword(String email, String password){
        SQLiteDatabase dh=this.getReadableDatabase();
        Cursor cursor=dh.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        if (cursor.getCount()>0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public void update(String name, String password){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("password",password);
        db.update("user",cv,"name= '"+name+"'",null);
        db.close();
    }
}


