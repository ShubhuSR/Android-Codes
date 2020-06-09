package com.shubh.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bplay, bpause, bstop;
    MediaPlayer mediaPlayer;
    int currentposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bplay = (Button) findViewById(R.id.btn_play);
        bpause = (Button) findViewById(R.id.btn_pause);
        bstop = (Button) findViewById(R.id.btn_stop);

        bplay.setOnClickListener(this);
        bpause.setOnClickListener(this);
        bstop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_play:
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.faded);
                    mediaPlayer.start();
                } else if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(currentposition);
                    mediaPlayer.start();
                }
                break;
            case R.id.btn_pause:
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    currentposition = mediaPlayer.getCurrentPosition();
                }
                break;
            case R.id.btn_stop:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
                break;


        }
    }
}