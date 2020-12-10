package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.time.Duration;

import java.time.LocalTime;
import java.util.Date;
import java.text.SimpleDateFormat;
import android.widget.TimePicker;
import java.time.Duration;

import java.util.Calendar;

public class SleepActivity extends AppCompatActivity
{

    @SuppressLint("StaticFieldLeak")
    static TextView sleepTime;
    @SuppressLint("StaticFieldLeak")
    static TextView wakeTime;
    TextView label_sleepTime;
    TextView label_wakeTime;
    static TextView label_hoursOfSleep;
    static TextView tot;
    static int sleepOrWake = -1;
    static int sleepHour;
    static int sleepMinute;
    static LocalTime st;
    static LocalTime wt;
    static LocalTime tt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        sleepTime = findViewById(R.id.sleepTime);
        wakeTime = findViewById(R.id.wakeTime);
        label_hoursOfSleep = findViewById(R.id.label_hoursOfSleep);
        tot = findViewById(R.id.totalHrs);
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener
    {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState)
        {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute)
        {
            if (sleepOrWake == 0)
            {
                String sleepyTime = "";
                if(hourOfDay>=0 && hourOfDay<10)
                {
                    sleepyTime = "0" + Integer.toString(hourOfDay) + ":" + Integer.toString(minute);
                }
                else
                {
                    sleepyTime = Integer.toString(hourOfDay) + ":" + Integer.toString(minute);
                }
                st = LocalTime.parse(sleepyTime);
                sleepTime.setText(sleepyTime);
                sleepHour = hourOfDay;
                sleepMinute = minute;
            }
            else if(sleepOrWake == 1)
            {
                String wakeyTime = "";
                if(hourOfDay>=0 && hourOfDay<10)
                {
                    wakeyTime = "0" + Integer.toString(hourOfDay) + ":" + Integer.toString(minute);
                }
                else
                {
                    wakeyTime = Integer.toString(hourOfDay) + ":" + Integer.toString(minute);
                }
                wakeTime.setText(wakeyTime);
                wt = LocalTime.parse(wakeyTime);
                tt = wt.minus(Duration.ofHours(st.getHour()));
                tot.setText(tt.toString());
            }
        }
    }
    public void showTimePickerDialogSleep(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
        sleepOrWake = 0;
    }
    public void showTimePickerDialogWake(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
        sleepOrWake = 1;
    }
}