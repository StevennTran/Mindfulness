package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ConstraintLayout background = findViewById(R.id.background);
        AnimationDrawable animation = (AnimationDrawable) background.getBackground();

        animation.setEnterFadeDuration(0);
        animation.setExitFadeDuration(5000);

        animation.start();

        FragmentManager fragmentMan = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragmentMan.beginTransaction();

        loginCredentials fragment = new loginCredentials();

        fragTrans.replace(R.id.loginCred, fragment);
        fragTrans.commit();

    }

    protected void onResume(){
        super.onResume();

    }

    protected void onStart(){
        super.onStart();

    }


    protected void onPause() {
        super.onPause();

    }

    protected void onStop(){
        super.onStop();

    }

    protected void onDestroy(){
        super.onDestroy();

    }
}