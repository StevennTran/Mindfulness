package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.media.MediaPlayer;

public class MeditateActivity extends AppCompatActivity {

    ImageButton playButton;
    ImageButton pauseButton;
    MediaPlayer meditateMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditate);
        meditateMusic = MediaPlayer.create(
                this, R.raw.meditation_sounds);
    }
    public void onClickPlay(View v)
    {
        meditateMusic.start();
    }

    // Pausing the music
    public void onClickPause(View v)
    {
        meditateMusic.stop();
    }

    protected void onResume(){
        super.onResume();

    }

    protected void onStart(){
        super.onStart();

    }


    protected void onPause() {
        super.onPause();
        meditateMusic.release();

    }

    protected void onStop(){
        super.onStop();
        meditateMusic.release();
    }

    protected void onDestroy(){
        super.onDestroy();
        meditateMusic.release();

    }
}