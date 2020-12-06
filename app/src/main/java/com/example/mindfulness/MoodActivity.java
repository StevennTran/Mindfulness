package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

public class MoodActivity extends AppCompatActivity {

    public Spinner moodSpinner;
    ImageView moodImage;
    int positionOfSelectedDataFromSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        moodSpinner = findViewById(R.id.spinner_mood);
        moodImage = findViewById(R.id.imageView_mood);
        moodImage.setImageResource(R.drawable.default_face);
        moodSpinner.setVisibility(View.VISIBLE);
        positionOfSelectedDataFromSpinner = 0;
        ArrayList<String> moodList = new ArrayList<>();
        moodList.add("Calm");
        moodList.add("Happy");
        moodList.add("Overjoyed");
        moodList.add("Sad");
        moodList.add("Stressed");
        moodList.add("Overwhelmed");
        moodList.add("Angry");
        moodList.add("Tired");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, moodList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moodSpinner.setAdapter(arrayAdapter);
        moodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedMood = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "You said you're feeling:  " + selectedMood, Toast.LENGTH_LONG).show();

                switch(selectedMood)
                {
                    case("Calm"):
                        moodImage.setImageResource(R.drawable.peaceful_face);
                        positionOfSelectedDataFromSpinner= position;
                        break;
                    case("Happy"):
                        moodImage.setImageResource(R.drawable.happy_face);
                        positionOfSelectedDataFromSpinner= position;
                        break;
                    case("Overjoyed"):
                        moodImage.setImageResource(R.drawable.overjoyed_face);
                        positionOfSelectedDataFromSpinner= position;
                        break;
                    case("Sad"):
                        moodImage.setImageResource(R.drawable.sad_face);
                        positionOfSelectedDataFromSpinner= position;
                        break;
                    case("Stressed"):
                        moodImage.setImageResource(R.drawable.stressed_face);
                        positionOfSelectedDataFromSpinner= position;
                        break;
                    case("Overwhelmed"):
                        moodImage.setImageResource(R.drawable.exhausted_face);
                        positionOfSelectedDataFromSpinner= position;
                        break;
                    case("Tired"):
                        moodImage.setImageResource(R.drawable.sleepy_face);
                        positionOfSelectedDataFromSpinner= position;
                        break;
                    case("Angry"):
                        moodImage.setImageResource(R.drawable.angry_face);
                        positionOfSelectedDataFromSpinner= position;
                        break;
                    default:
                        moodImage.setImageResource(R.drawable.default_face);
                        positionOfSelectedDataFromSpinner= position;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
    }

    public void onClickMoodAdviceActivity(View view)
    {
        Log.i("onClick", "User clicked mood advice button");
        Intent intent = new Intent(MoodActivity.this, MoodAdviceActivity.class);
        intent.putExtra("position", positionOfSelectedDataFromSpinner);
        startActivity(intent);
    }
}