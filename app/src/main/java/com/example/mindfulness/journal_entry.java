package com.example.mindfulness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link journal_entry#newInstance} factory method to
 * create an instance of this fragment.
 */
public class journal_entry extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int userID;

    public Button submitButton;
    public EditText textA1;
    public EditText textA2;
    public EditText textA3;
    public ListView myListView;
    public JournalActivity.journalAdapter myAdapter;
    public ArrayList<String> myEntries;

    public journal_entry(int userID, ListView temp, JournalActivity.journalAdapter adapt, ArrayList<String> entries) {
        this.userID = userID;
        myListView = temp;
        myAdapter = adapt;
        myEntries = entries;
        Log.i("JOURNAL ENTRY", Integer.toString(userID));
    }

    // TODO: Rename and change types and number of parameters
    public static journal_entry newInstance(int userID, ListView temp, JournalActivity.journalAdapter adapt, ArrayList<String> entries) {
        journal_entry fragment = new journal_entry(userID, temp, adapt, entries);

        Bundle args = new Bundle();
        args.putInt("UserID", userID);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_journal_entry, container, false);
    }



    @Override
    public void onViewCreated(View view, Bundle SavedInstance)
    {
        textA1 = view.findViewById(R.id.editTextA1);
        textA2 = view.findViewById(R.id.editTextA2);
        textA3 = view.findViewById(R.id.editTextA3);
        submitButton = view.findViewById(R.id.button_writeJournal);
        myListView = view.findViewById(R.id.listView);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("submitButton", "Submit Button Clicked");
                DatabaseHelper dbHelper = new DatabaseHelper(v.getContext()); //View is parent
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String editTextA1 = textA1.getText().toString();
                String editTextA2 = textA2.getText().toString();
                String editTextA3 = textA3.getText().toString();
                ContentValues values = new ContentValues();
                values.put("UserID",userID);
                String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                values.put("Date",date);
                values.put("TextOne",editTextA1);
                values.put("TextTwo",editTextA2);
                values.put("TextThree",editTextA3);

                db.insert("Journal","NullPlaceHolder",values);
                textA1.setText("");
                textA2.setText("");
                textA3.setText("");


                myEntries.add(date);
                myEntries.add(editTextA1);
                myEntries.add(editTextA2);
                myEntries.add(editTextA3);
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}