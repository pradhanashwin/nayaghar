package com.example.ashwin.nayaghar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick1(View view) {
        Intent i;
        i = new Intent(this, Login.class);
        startActivity(i);
    }

    public void onClick2(View view) {
        Intent i;
        i = new Intent(this, Dogadopt.class);
        startActivity(i);
    }
}
