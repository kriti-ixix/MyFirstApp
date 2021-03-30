package com.kriti.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MyPreferences extends AppCompatActivity implements View.OnClickListener{

    EditText pref; Button save; CheckBox java, android; RadioButton morning, afternoon, evening;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_preferences);

        pref = findViewById(R.id.editTextPref);
        save = findViewById(R.id.buttonSavePref);
        java = findViewById(R.id.checkBoxJava);
        android = findViewById(R.id.checkBoxAndroid);
        morning = findViewById(R.id.radioMorning);
        afternoon = findViewById(R.id.radioAfternoon);
        evening = findViewById(R.id.radioEvening);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String batch; String subjects;

        if (morning.isChecked())
        {
            batch = "morning batch";
        }
        else if (afternoon.isChecked())
        {
            batch = "afternoon batch";
        }
        else if (evening.isChecked())
        {
            batch = "evening batch";
        }
        else
        {
            batch = "no batch";
        }



        Toast.makeText(this, "You have chosen " + batch, Toast.LENGTH_SHORT).show();

        SharedPreferences sp;
        SharedPreferences.Editor editor;

        sp = getSharedPreferences("mypref", MODE_PRIVATE);
        editor = sp.edit();
        editor.putString("data", pref.getText().toString());
        editor.apply();

        Intent prefin = new Intent(this, DisplayPref.class);
        //prefin.putExtra("mypreference", pref.getText().toString());
        startActivity(prefin);
    }
}