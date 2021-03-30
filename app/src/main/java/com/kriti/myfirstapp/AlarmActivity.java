package com.kriti.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlarmActivity extends AppCompatActivity implements View.OnClickListener{

    EditText timer; Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        timer = findViewById(R.id.editTextTimer);
        start = findViewById(R.id.startTimer);
        start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        //Getting the time from the user
        int i = Integer.parseInt(timer.getText().toString());

        //Intents to interact with the receiver
        Intent intent = new Intent(this, MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),
                1, intent, 0);

        //Setting the alarm
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i*1000), pendingIntent);

        //Toast to display the timer has been set
        Toast.makeText(this, "Alarm set for " +i+ " seconds", Toast.LENGTH_SHORT).show();
    }
}