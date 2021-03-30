package com.kriti.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferFile extends AppCompatActivity implements View.OnClickListener {

    Button read, write; EditText content;
    static final String MYFILE = "Example.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffer_file);

        read = findViewById(R.id.bufferRead);
        write = findViewById(R.id.bufferWrite);
        content = findViewById(R.id.editTextFile);

        read.setOnClickListener(this);
        write.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();

        try
        {
            if (id == R.id.bufferRead)
            {
                File file = new File(this.getFilesDir() + "/" + MYFILE);
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String x = "", y;

                while ( (y = br.readLine()) !=null)
                {
                    x += y;
                    x += "\n";
                }

                content.setText(x);

            }
            else if (id == R.id.bufferWrite)
            {
                File file = new File(this.getFilesDir() + "/" + MYFILE);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content.getText().toString());
                bw.flush();
            }
            else
                {
                    Log.i("Checking", "Kya press kiya bhai");
                }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}