package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditMessage extends AppCompatActivity {
    TextView dateText;
    TextView message1;
    TextView message2;
    TextView message3;

    Button back;
    Button delete;

    String date;
    String text1;
    String text2;
    String text3;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_message);

        Bundle bundle = getIntent().getExtras().getBundle("myMessage");
        date = bundle.getString("date");
        text1 = bundle.getString("message1");
        text2 = bundle.getString("message2");
        text3 = bundle.getString("message3");
        position = bundle.getInt("position");

        back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(5);
                finish();
            }
        });
        delete = findViewById(R.id.deleteJournal);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("position",position);
                intent.putExtra("text1",text1);
                intent.putExtra("text2",text2);
                intent.putExtra("text3",text3);
                setResult(10, intent);
                finish();
            }
        });

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