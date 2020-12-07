package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MoodAdviceActivity extends AppCompatActivity {

    ArrayList<String> adviceList = new ArrayList<>();
    String dialogText = new String();
    String category = new String();
    String spinnerText = new String();
    int positionToShowToSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_advice);
        adviceList.add("Meditation");
        adviceList.add("Hydration");
        adviceList.add("Staying grounded");
        adviceList.add("Going for a walk");
        dialogText = "default message";
        category = "default category";

        Bundle bundle = getIntent().getExtras().getBundle("selectedItem");
        spinnerText = bundle.getString("mood");

        switch(spinnerText)
        {
            case("Calm"):
                adviceList.add("Staying calm");
                break;
            case("Happy"):
                adviceList.add("Staying happy");
                adviceList.add("Working on being an optimist");
                break;
            case("Overjoyed"):
                adviceList.add("Channeling excitement into long lasting positivity");
                adviceList.add("Working on being an optimist");
                break;
            case("Sad"):
                adviceList.add("Taking time to vent");
                adviceList.add("Working on being an optimist");
                adviceList.add("Managing negative emotions");
                break;
            case("Stressed"):
                adviceList.add("Managing stress and deadlines");
                adviceList.add("Completing work on time");
                adviceList.add("Meditating for stress relief");
                adviceList.add("Staying calm");
                break;
            case("Overwhelmed"):
                adviceList.add("Staying calm");
                adviceList.add("Practicing mindfulness");
                break;
            case("Tired"):
                adviceList.add("Regulating sleep schedules");
                adviceList.add("Energizing yourself");
                adviceList.add("Incorporating exercise into a daily routine");
                break;
            case("Angry"):
                adviceList.add("Controlling anger and strong emotions");
                adviceList.add("Staying patient");
                adviceList.add("Staying calm");
                break;
            default:
                break;
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , adviceList);
        ListView adviceListView = (ListView) findViewById(R.id.mood_list);
        adviceListView.setAdapter(arrayAdapter);
        adviceListView.setClickable(true);
        adviceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                String adviceText = adviceList.get(i);
                Log.i("val", adviceText);
                switch(adviceText)
                {
                    case("Meditation"):
                        dialogText = "Use the meditation section of the app to help!";
                        category = "Tips on meditating: ";
                        break;
                    case("Hydration"):
                        dialogText = "Hydration tip: You should at least have 15.5 cups of water! Track your intake in the app!";
                        category = "Hydration is important!";
                        break;
                    case("Staying grounded"):
                        dialogText = "Grounded tip";
                        category = "Practicing remaining grounded:";
                        break;
                    case("Going for a walk"):
                        dialogText = "Walking tips";
                        category = "Go for a nice walk!";
                        break;
                    case("Staying calm"):
                        dialogText = "Calm tip";
                        category = "Remaining calm";
                        break;
                    case("Staying happy"):
                        dialogText = "Happy tip";
                        category = "Smile!";
                        break;
                    case("Working on being an optimist"):
                        dialogText = "Optimism tip";
                        category = "Stay cheery!";
                        break;
                    case("Channeling excitement into long lasting positivity"):
                        dialogText = "Optimism tip";
                        category = "Keep the momentum going!";
                        break;
                    case("Taking time to vent"):
                        dialogText = "Venting tip";
                        category = "Let it all out.";
                        break;
                    case("Managing negative emotions"):
                        dialogText = "Managing tip";
                        category = "Be in control.";
                        break;
                    case("Managing stress and deadlines"):
                        dialogText = "Management tip";
                        category = "Staying on top of it...";
                        break;
                    case("Completing work on time"):
                        dialogText = "Deadline tip";
                        category = "Catching up with work...";
                        break;
                    case("Meditating for stress relief"):
                        dialogText = "Stress relief tip";
                        category = "Turn it around!";
                        break;
                    case("Practicing mindfulness"):
                        dialogText = "Mindfulness tip";
                        category = "We're here for that!";
                        break;
                    case("Regulating sleep schedules"):
                        dialogText = "Sleep tip";
                        category = "Six to eight hours minimum.";
                        break;
                    case("Energizing yourself"):
                        dialogText = "Energy tip";
                        category = "Turn it up!";
                        break;
                    case("Incorporating exercise into a daily routine"):
                        dialogText = "Exercise tip";
                        category = "Healthy body, healthy mind.";
                        break;
                    case("Controlling anger and strong emotions"):
                        dialogText = "Anger tip";
                        category = "Simmering down...";
                        break;
                    case("Staying patient"):
                        dialogText = "Patience tip";
                        category = "Good things come to those who wait!";
                        break;
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