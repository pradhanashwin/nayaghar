package com.example.ashwin.nayaghar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class LoginDataBaseAdapter {
    //   static final String DATABASE_NAME = "draft.db";


    //DB PROPERTIES
    static final String DATABASE_NAME = "test3.db";
    // static final String TABLE_NAME = "TABLE1";
    //static final String TABLE_NAMEE = "TABLE2";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;


    //LOGIN is Table name
    static final String DATABASE_CREATE = "create table " + "LOGIN" + "( "
            + "ID" + " integer primary key autoincrement,"
            + "NAME text not null,"
            + "ADDRESS text not null,EMAIL text not null, PASSWORD text not null,"
            + "CONTACT text not null);";


    //DOGDB is Table name
   /* static  final String CREATE_DOGDB="create table "+ "DOGDB"+"( "
            +"DID integer primary key autoincrement, PHOTO BLOB, "
            +"DNAME text not null, Vaccination text, AGE integer not null," +
            " GENDER text, BREED text, DESCRIPTION text not null);";*/

    static final String CREATE_DOGDB = "create table " + "DOGDB" + "( "
            + "DID integer primary key autoincrement,PHOTO text, "
            + "DNAME text not null, Vaccination text, AGE integer not null," +
            " GENDER text, BREED text, DESCRIPTION text not null);";

    static final String TABLE_NAME = "DOGDB";
    public SQLiteDatabase db;
    private final Context context;
    private nayagharDbHelper dbHelper;

    public LoginDataBaseAdapter(Context _context) {
        context = _context;
        dbHelper = new nayagharDbHelper(context, DATABASE_NAME, null,
                DATABASE_VERSION);

    }

    public LoginDataBaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String name, String address, String userName,
                            String password, String contact) {
        ContentValues newValues = new ContentValues();
        newValues.put("NAME", name);
        newValues.put("ADDRESS", address);
        newValues.put("EMAIL", userName);
        newValues.put("PASSWORD", password);
        newValues.put("CONTACT", contact);
        db.insert("LOGIN", null, newValues);

    }

    /*-------------emaik check------- */
    public String checkemail(String username) {
        Cursor cursor = db.query("LOGIN", null, "EMAIL=?",
                new String[]{username}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        if (cursor != null) {
            cursor.moveToFirst();
        }
        cursor.moveToFirst();
        String Username = cursor.getString(cursor.getColumnIndex("EMAIL"));
        cursor.close();
        return Username;
    }

    //public void insertdog(byte[] imageBytes,String age, String Name, String dogVac, String dGender
    public void insertdog(String imageBytes, String age, String Name, String dogVac, String dGender
            , String Breeds, String Des) {

        //SQLiteStatement statement =db.compileStatement(sql);
        ContentValues newValue = new ContentValues();
        newValue.put("PHOTO", imageBytes);
        newValue.put("DNAME", Name);
        newValue.put("AGE", age);
        newValue.put("Vaccination", dogVac);
        newValue.put("GENDER", dGender);
        newValue.put("BREED", Breeds);
        newValue.put("DESCRIPTION", Des);
        // statement.bindBlob(3,)
        db.insert("DOGDB", null, newValue);
    }

  /*  public byte[] retreiveImageFromDB() {
        Cursor cur = mDb.query(true, DOGDB, new String[]{IMAGE,},
                               null, null, null, null,
                               DID + " DESC", "1");
        if (cur.moveToFirst()) {
            byte[] blob = cur.getBlob(cur.getColumnIndex(IMAGE));
            cur.close();
            return blob;
        }
        cur.close();
        return null;
    }*/


    public int deleteEntry(String UserName) {

        String where = "EMAIL=?";
        int numberOFEntriesDeleted = db.delete("LOGIN", where,
                new String[]{UserName});
        return numberOFEntriesDeleted;
    }

    public String getSinlgeEntry(String userName) {
        Cursor cursor = db.query("LOGIN", null, " EMAIL=?",
                new String[]{userName}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public void updateEntry(String userName, String password) {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("EMAIL", userName);
        updatedValues.put("PASSWORD", password);

        String where = "EMAIL = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});
    }


   /* public Cursor getListContents(){
       //SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME"SELECT * FROM " + TABLE_NAME, null);
        return data;
    }*/

    public Cursor getListContents(String sql){
        return db.rawQuery(sql,null);
    }





}
