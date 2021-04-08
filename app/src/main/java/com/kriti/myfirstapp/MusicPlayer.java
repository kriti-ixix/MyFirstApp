package com.kriti.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MusicPlayer extends AppCompatActivity implements View.OnClickListener {

    Button playMusic, pauseMusic;
    SeekBar volume; AudioManager audioManager;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        playMusic = findViewById(R.id.musicPlay);
        pauseMusic = findViewById(R.id.musicPause);
        volume = findViewById(R.id.volumeSeekBar);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        mediaPlayer = MediaPlayer.create(this, R.raw.knock);

        playMusic.setOnClickListener(this);
        pauseMusic.setOnClickListener(this);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        volume.setMax(maxVolume);
        volume.setProgress(currentVolume);

        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();

        if (id==R.id.musicPlay)
        {
            mediaPlayer.start();
            Log.d("Checking", "Music playing");
        }

        if (id==R.id.musicPause)
        {
            mediaPlayer.pause();
            Log.d("Checking", "Music paused");
        }

    }
}