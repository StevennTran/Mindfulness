package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;


public class WaterActivity extends AppCompatActivity {

    Button waterIncrease;
    Button waterDecrease;
    TextView waterCounter;
    ImageView imgGlass;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        waterIncrease = findViewById(R.id.button_waterCountUp);
        waterDecrease = findViewById(R.id.button_waterCountDown);
        waterCounter = findViewById(R.id.water_counter);
        imgGlass = findViewById(R.id.imageView_glass);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(80);
        progressBar.setVisibility(View.VISIBLE);
    }

    public void waterIncrement(View view)
    {
        Log.i("onClick", "User incremented water intake");
        int count = Integer.parseInt(waterCounter.getText().toString());
        count++;
        waterCounter.setText(Integer.toString(count));
        progressBar.incrementProgressBy(10);
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        imgGlass.startAnimation(shake);
    }

    public void waterDecrement(View view)
    {
        Log.i("onClick", "User decremented water intake");
        int count = Integer.parseInt(waterCounter.getText().toString());
        if(count>=1)
        {
            count--;
            waterCounter.setText(Integer.toString(count));
            progressBar.setProgress(progressBar.getProgress()-10);
        }
        else
        {
            Toast.makeText(this, "You can't have less than 0 glasses of water a day!", Toast.LENGTH_SHORT).show();
        }
    }
}