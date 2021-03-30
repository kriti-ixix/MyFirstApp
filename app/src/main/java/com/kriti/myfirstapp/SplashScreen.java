package com.kriti.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    Handler h; Runnable r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        h = new Handler();
        r = new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(SplashScreen.this, MyListView.class);
                startActivity(in);
                finish();
            }
        };

        h.postDelayed(r, 3000);
    }
}