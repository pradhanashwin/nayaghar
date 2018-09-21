package com.example.ashwin.nayaghar;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import java.sql.Blob;
import java.util.ArrayList;


public class Dogadopt extends AppCompatActivity {
    LoginDataBaseAdapter loginDataBaseAdapter;

    private ArrayList<DogModel> dogArrayList = new ArrayList<>();
    private DogListAdapter adapter;
    private RecyclerView recyclerview;
    private DOG dog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogadopt);


        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        recyclerview = (RecyclerView) findViewById(R.id.activity_dogadopt_recycler_view);

         recyclerview.setLayoutManager(new LinearLayoutManager(this));
//         recyclerview.setLayoutManager(new GridLayoutManager(this, 2));
//      recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

//
//        dogArrayList.add(new DogModel("Hello", "Hello"));
//        dogArrayList.add(new DogModel("Hello", "Hello"));

        Cursor cursor = loginDataBaseAdapter.getListContents("SELECT PHOTO, DNAME, Vaccination," +
                "AGE, GENDER, BREED, DESCRIPTION FROM DOGDB");
        while (cursor.moveToNext()) {
//            Blob b = new javax.sql.rowset.serial.SerialBlob(String.getPHOTO());




            dogArrayList.add(new DogModel(
                    cursor.getString(cursor.getColumnIndex("DNAME")),
                    cursor.getString(cursor.getColumnIndex("PHOTO")),
                    cursor.getString(cursor.getColumnIndex("AGE")),
                    cursor.getString(cursor.getColumnIndex("Vaccination")),
                    cursor.getString(cursor.getColumnIndex("GENDER")),
                    cursor.getString(cursor.getColumnIndex("BREED")),
                    cursor.getString(cursor.getColumnIndex("DESCRIPTION"))
            ));
        }
        adapter = new DogListAdapter(getApplicationContext(), dogArrayList);
        recyclerview.setAdapter(adapter);


    }

}
