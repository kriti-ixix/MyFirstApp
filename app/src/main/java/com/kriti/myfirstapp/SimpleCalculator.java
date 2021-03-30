package com.kriti.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SimpleCalculator extends AppCompatActivity {

    Double one, two; EditText editText1, editText2;
    Button add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);

        editText1 = findViewById(R.id.editTextFirst);
        editText2 = findViewById(R.id.editTextSecond);

        add = findViewById(R.id.buttonAdd);
        sub = findViewById(R.id.buttonSub);
        mul = findViewById(R.id.buttonMul);
        div = findViewById(R.id.buttonDiv);

        one = Double.parseDouble(editText1.getText().toString());
        two = Double.parseDouble(editText2.getText().toString());

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}