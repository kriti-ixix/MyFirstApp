package com.kriti.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayPref extends AppCompatActivity implements View.OnClickListener{

    TextView pref; Button logout;
    SharedPreferences sp; SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_pref);

        pref = findViewById(R.id.textViewPref);
        logout = findViewById(R.id.buttonLogOut);

        sp = getSharedPreferences("mypref", MODE_PRIVATE);
        String s = sp.getString("data", "Not found");
        pref.setText(s);
    }

    @Override
    public void onClick(View v)
    {
        editor.remove("data");
        editor.apply();

        if (sp.contains("data"))
        {
            Toast.makeText(this, "Error logging out", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent in = new Intent(this, MyPreferences.class);
            startActivity(in);
        }
    }
}