package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class EditMessage extends AppCompatActivity {
    TextView dateText;
    TextView message1;
    TextView message2;
    TextView message3;

    String date;
    String text1;
    String text2;
    String text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_message);

        Bundle bundle = getIntent().getExtras().getBundle("myMessage");
        date = bundle.getString("date");
        text1 = bundle.getString("message1");
        text2 = bundle.getString("message2");
        text3 = bundle.getString("message3");

        dateText = findViewById(R.id.dateField);
        dateText.setText(date);

        message1 = findViewById(R.id.TextA1);
        message1.setText(text1);

        message2 = findViewById(R.id.TextA2);
        message2.setText(text2);

        message3 = findViewById(R.id.TextA3);
        message3.setText(text3);
    }
}