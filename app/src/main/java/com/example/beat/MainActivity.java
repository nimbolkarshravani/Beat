package com.example.beat;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
    MediaPlayer mediaPlayer,player;
    SoundPool soundPool;
    int xplode = 0;
    Random crazy =new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   setContentView(R.layout.activity_main);

        View v = new View(this);
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        v.setOnTouchListener(this);
        setContentView(v);
        mediaPlayer = MediaPlayer.create(this, R.raw.backgroundmusic);
        mediaPlayer.start();
        player= MediaPlayer.create(this,R.raw.soundtrack);
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        xplode = soundPool.load(this, R.raw.explosion, 1);
        v.setBackgroundColor(Color.rgb(crazy.nextInt( 256),crazy.nextInt(56 ),crazy.nextInt(25 )));
    }

    @Override
    public void onClick(View v) {
if(xplode!=0)
{
    soundPool.play(xplode,1,1,1,0,1);
}
    }

    @Override
    public boolean onLongClick(View v) {
        mediaPlayer.stop();

        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        player.start();
        v.setBackgroundColor(Color.rgb(crazy.nextInt( 56),crazy.nextInt(156 ),crazy.nextInt(205 )));

        return false;
    }
}
