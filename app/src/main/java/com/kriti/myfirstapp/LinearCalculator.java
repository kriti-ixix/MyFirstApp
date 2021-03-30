package com.kriti.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LinearCalculator extends AppCompatActivity implements View.OnClickListener{

    Button b1, b2; EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_calculator);

        b1 = findViewById(R.id.add);
        b2 = findViewById(R.id.sub);
        e1 = findViewById(R.id.first);
        e2 = findViewById(R.id.second);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        String buttonPressed = v.getTag().toString();
        Double one = Double.parseDouble(e1.getText().toString());
        Double two = Double.parseDouble(e2.getText().toString());

        if (id==R.id.first)
        {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        }
        else if (buttonPressed=="sub")
        {

        }
        else
        {

        }
    }
}