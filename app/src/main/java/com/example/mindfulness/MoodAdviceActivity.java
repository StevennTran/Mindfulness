package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MoodAdviceActivity extends AppCompatActivity {

    ArrayList<String> adviceList = new ArrayList<>();
    String dialogText = new String();
    String category = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_advice);
        adviceList.add("Meditation");
        adviceList.add("Hydration");
        adviceList.add("Staying grounded");
        adviceList.add("Walking");
        dialogText = "default message";
        category = "default category";
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , adviceList);
        ListView adviceList = (ListView) findViewById(R.id.mood_list);
        adviceList.setAdapter(arrayAdapter);
        adviceList.setClickable(true);
        adviceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                switch(i)
                {
                    case(0):
                        dialogText = "Use the meditation section of the app to help!";
                        category = "Tips on meditating: ";
                        break;
                    case(1):
                        dialogText = "Hydration tip: You should at least have 15.5 cups of water! Track your intake in the app!";
                        category = "Hydration is important!";
                        break;
                    case(2):
                        dialogText = "Grounded tip";
                        category = "Practicing remaining grounded:";
                        break;
                    case(3):
                        dialogText = "Walking tips";
                        category = "Go for a nice walk!";
                    default:
                        dialogText = "Error, default selected";
                        category = "Error, default category";
                        break;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MoodAdviceActivity.this);
// 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage(dialogText) //Add a dialog message to strings.xml

                        .setTitle(category)
                        .setPositiveButton("I got this!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                                Snackbar.make(view, "Yeah, you got this!", Snackbar.LENGTH_SHORT).setAction("Oop", null).show();
                            }
                        })
                        .setNegativeButton("I'll try my best!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                                Snackbar.make(view, "Keep trying, you're going to improve.", Snackbar.LENGTH_SHORT).setAction("lol", null).show();
                            }
                        })
                        .show();
            }
        });
    }
}