package com.example.bailt2.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bailt2.DBhelper;
import com.example.bailt2.Model_User;

import java.util.ArrayList;
import java.util.List;

public class DAO_User {
    DBhelper dBhelper ;

    public DAO_User(Context context) {
        dBhelper =new DBhelper(context);
        SQLiteDatabase sqLiteDatabase= dBhelper.getWritableDatabase();

    }
    public void Delete(int id){
    SQLiteDatabase db  = dBhelper.getWritableDatabase();
    db.delete("User","ID" + id,null);
    }

    public void them_user(Model_User user){
    SQLiteDatabase db =dBhelper.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
    contentValues.put("ID",user.getID());
    contentValues.put("Username",user.getUsername());
    contentValues.put("Pass",user.getPassword());
    contentValues.put("Fullname",user.getFullname());
    contentValues.put("Phone",user.getPhone());
    contentValues.put("Birth",user.getBirth());
    contentValues.put("ID_Group",user.getID_group());
    db.insert("User",null,contentValues);
    }
    public void Update_user(Model_User user){
        SQLiteDatabase db =dBhelper.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put("ID",user.getID());
        contentValues.put("Username",user.getUsername());
        contentValues.put("Pass",user.getPassword());
        contentValues.put("Fullname",user.getFullname());
        contentValues.put("Phone",user.getPhone());
        contentValues.put("Birth",user.getBirth());
        contentValues.put("ID_Group",user.getID_group());

    }
    public List<Model_User> userList(){
        ArrayList<Model_User> arrayList = new ArrayList<>();
        SQLiteDatabase db = dBhelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from User",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            int ID = cursor.getInt(0);
            String Username =  cursor.getString(1);
            String Password = cursor.getString(2);
            String Fullname = cursor.getString(3);
            int Phone = cursor.getInt(4);
            String Birth =  cursor.getString(5);
            int ID_Group = cursor.getInt(6);

            arrayList.add(new Model_User(ID,Username,Password,Fullname,Phone,Birth,ID_Group));
            cursor.moveToNext();
        }
        cursor.close();


        return arrayList;
    }
    
}
