package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

import java.util.ArrayList;

public class JournalActivity extends AppCompatActivity {

    public ArrayList<String> myEntries = new ArrayList<String>();;
    public ListView myListView;
    public Button submitButton;
    public EditText textA1;
    public EditText textA2;
    public EditText textA3;
    String userID;
    final String LOGINID = "LOGINID";

    private class journalAdapter extends ArrayAdapter<String> {

        public journalAdapter(Context ctx) {
            super(ctx, 0);
        }
        public int getCount(){
            return myEntries.size();
        }

        public String getItem(int position){
            return myEntries.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = JournalActivity.this.getLayoutInflater();
            View result = null;
            result = inflater.inflate(R.layout.journal_entries, null);
            TextView entry = (TextView)result.findViewById(R.id.journal_text);
            entry.setText(   getItem(position)  ); // get the string at position

            return result;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        FragmentManager fragmentMan = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragmentMan.beginTransaction();
        final journalAdapter myAdapter = new journalAdapter(this);
        Bundle bundle = getIntent().getExtras().getBundle(LOGINID);
        userID = bundle.getString("userID");
        Log.i("JournalActivity",userID);

        journal_entry fragment = new journal_entry(userID);

        fragTrans.replace(R.id.journalFrame, fragment);
        fragTrans.commit();

        myListView = findViewById(R.id.listView);
        myListView.setAdapter (myAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Intent intent = new Intent(JournalActivity.this, MainActivity.class);
                Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);
            }
        });
        DatabaseHelper dbHelper = new DatabaseHelper(this); //View is parent
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //ContentValues values = new ContentValues();
        String query = "SELECT * FROM Journal";
        Cursor myCursor = db.rawQuery(query,null);

        myCursor.moveToFirst();
        while(!myCursor.isAfterLast()){
            String date = myCursor.getString(myCursor.getColumnIndex("Date"));
            myEntries.add(date);
        }
        myCursor.close();

    }
}