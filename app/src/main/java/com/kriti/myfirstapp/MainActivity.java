package com.kriti.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView; Button button; EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewName);
        button = findViewById(R.id.buttonName);
        editText = findViewById(R.id.editTextName);
        button.setOnClickListener(this);

        Random r = new Random();
        int x = r.nextInt(101);
        Toast.makeText(this, String.valueOf(x), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v)
    {
        String name = editText.getText().toString();
        if (name.equals(""))
        {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
        }

        Intent in = new Intent(this, Currency.class);
        in.putExtra("mydata123", name);
        startActivity(in);
    }
}