package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class toolBar extends AppCompatActivity {

    String snackMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public boolean onCreateOptionsMenu (Menu m){
        getMenuInflater().inflate(R.menu.toolbar_menu, m );
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_logout:

                break;
            case R.id.action_aboutUs:
                //Start an activity…


                break;

            case R.id.action_Licence:
                Log.d("Tool bar", "Option 3 selected");
                //int duration = Toast.LENGTH_SHORT; //= Toast.LENGTH_LONG if Off

                //Toast toast = Toast.makeText(TestToolbar.this , "Version 1.0 by Quinn Brimley", duration); //this is the ListActivity
                //toast.show(); //display your message box
                break;


        }
        return true;
    }
}