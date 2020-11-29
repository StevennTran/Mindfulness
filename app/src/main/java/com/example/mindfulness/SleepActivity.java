package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class SleepActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    static TextView sleepTime;
    @SuppressLint("StaticFieldLeak")
    static TextView wakeTime;
    TextView label_sleepTime;
    TextView label_wakeTime;
    TextView label_hoursOfSleep;
    static int sleepOrWake = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        sleepTime = findViewById(R.id.sleepTime);
        wakeTime = findViewById(R.id.wakeTime);
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            if (sleepOrWake == 0)
            {
                sleepTime.setText(hourOfDay + ":" + minute);
            }
            else if(sleepOrWake == 1)
            {
                wakeTime.setText(hourOfDay + ":" + minute);
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