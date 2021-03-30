package com.kriti.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Currency extends AppCompatActivity implements View.OnClickListener{

    EditText editText; Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        Intent in = getIntent();
        String n = in.getStringExtra("mydata123");

        Toast.makeText(this, n, Toast.LENGTH_SHORT).show();

        editText = findViewById(R.id.editTextCurrency);
        button = findViewById(R.id.buttonConvert);
    }

    @Override
    public void onClick(View v)
    {
        Double inr = Double.parseDouble(editText.getText().toString());
    }
}