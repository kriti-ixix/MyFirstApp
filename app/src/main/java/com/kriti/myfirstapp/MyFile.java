package com.kriti.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MyFile extends AppCompatActivity implements View.OnClickListener{

    Button read, write;
    public static final String FILENAME = "Demo.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_file);

        read = findViewById(R.id.buttonRead);
        write = findViewById(R.id.buttonWrite);

        read.setOnClickListener(this);
        write.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }

    }

    @Override
    public void onClick(View v)
    {
        try
        {
            int id = v.getId();

            if(id==R.id.buttonRead)
            {
                File file = new File(this.getFilesDir() + "/" + FILENAME);
                FileInputStream fis = new FileInputStream(file);
                String output = "";
                byte[] buffer = new byte[1024];
                int n;

                while ((n = fis.read(buffer)) != -1)
                {
                    output += (new String(buffer, 0, n));
                }
                Toast.makeText(this, output,Toast.LENGTH_LONG).show();
                fis.close();
            }
            else
            {
                File file = new File(this.getFilesDir() + "/" + FILENAME);
                FileOutputStream fos = new FileOutputStream(file);
                String s = "Hello World";

                fos.write(s.getBytes());
                fos.close();

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}