package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton waterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("onCreate", "MainActivity created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waterButton = findViewById(R.id.water_tracker);
    }

    public void onClickWater(View view)
    {
        Log.i("onClick", "User clicked water tracker button");
        Intent intent = new Intent(MainActivity.this, WaterActivity.class);
        startActivity(intent);
    }

    public void onClickMood(View view)
    {
        Log.i("onClick", "User clicked mood tracker button");
        Intent intent = new Intent(MainActivity.this, MoodActivity.class);
        startActivity(intent);
    }

    public void onClickMeditate(View view)
    {
        Log.i("onClick", "User clicked meditate button");
        Intent intent = new Intent(MainActivity.this, MeditateActivity.class);
        startActivity(intent);
    }

    public void onClickSleep(View view)
    {
        Log.i("onClick", "User clicked sleep button");
        Intent intent = new Intent(MainActivity.this, SleepActivity.class);
        startActivity(intent);
    }

    protected void onResume(){
        super.onResume();

    }

    protected void onStart(){
        super.onStart();

    }


    protected void onPause() {
        super.onPause();

    }

    protected void onStop(){
        super.onStop();

    }

    protected void onDestroy(){
        super.onDestroy();

    }
}
