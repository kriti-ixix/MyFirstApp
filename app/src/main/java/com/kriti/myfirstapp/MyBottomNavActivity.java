package com.kriti.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MyBottomNavActivity extends AppCompatActivity {

    HomeFragment homeFragment = new HomeFragment();
    CategoriesFragment categoriesFragment = new CategoriesFragment();
    FragmentManager fragmentManager = getSupportFragmentManager();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bottom_nav);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        fragmentManager.beginTransaction().replace(R.id.frameLayout, homeFragment).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.miHome:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout, homeFragment).commit();
                        break;
                    case R.id.miCategories:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout, categoriesFragment).commit();
                        break;
                    case R.id.miWorkouts:
                        break;
                    case R.id.miProfile:
                        break;
                }

                return true;
            }
        });
    }
}
