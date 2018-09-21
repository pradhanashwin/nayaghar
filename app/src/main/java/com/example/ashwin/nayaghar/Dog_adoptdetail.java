package com.example.ashwin.nayaghar;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Dog_adoptdetail extends AppCompatActivity {
    LoginDataBaseAdapter loginDataBaseAdapter;
    private ArrayList<AdoptionModel> dogArrayList = new ArrayList<>();
    private DogDetailAdapter adapter;
    private RecyclerView recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_adoptdetail);

        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        recyclerview = (RecyclerView) findViewById(R.id.activity_dogadopt_recycler_view);
        recyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        Cursor cursor = loginDataBaseAdapter.getListContents("SELECT PHOTO, DNAME, Vaccination," +
                " AGE, GENDER, BREED, DESCRIPTION FROM DOGDB");

        while (cursor.moveToNext()) {

            dogArrayList.add(new AdoptionModel(
                    cursor.getString(cursor.getColumnIndex("DNAME")),
                    cursor.getString(cursor.getColumnIndex("PHOTO")),
                            cursor.getString(cursor.getColumnIndex("AGE")),
                            cursor.getString(cursor.getColumnIndex("Vaccination")),
                                    cursor.getString(cursor.getColumnIndex("GENDER")),
                                    cursor.getString(cursor.getColumnIndex("BREED")),
                                            cursor.getString(cursor.getColumnIndex("DESCRIPTION"))
            ));
        }
        adapter = new DogDetailAdapter(getApplicationContext(), dogArrayList);
     // recyclerview.setAdapter(adapter);
    }
}
