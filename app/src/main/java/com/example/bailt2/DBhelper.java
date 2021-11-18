package com.example.bailt2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public DBhelper(@Nullable Context context) {
        super(context, "Data.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Table_User = "Create table if not exists User(ID integer primary key ,Username text,Password text,Fullname text,Phone integer,Birth text,ID_group integer)";
        db.execSQL(Table_User);
        String Table_Group = "Create table if not exists Groupp(ID integer primary key,Name text)";
        db.execSQL(Table_Group);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql_user = "drop table if exists User";
        db.execSQL(sql_user);
        String sql_group = "drop table if exists Groupp";
        db.execSQL(sql_group);
    }
}
