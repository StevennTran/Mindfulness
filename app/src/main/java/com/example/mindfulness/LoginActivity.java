package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        final Button loginButton = findViewById(R.id.loginButton);
        final TextView signUpButton = findViewById(R.id.signupbutton);
        final SharedPreferences sharedPref = getSharedPreferences("email", Context.MODE_PRIVATE);
        final EditText emailText = findViewById(R.id.emailText);

        emailText.setText(sharedPref.getString("email","email@domain.ca"));
        final SharedPreferences.Editor editor = sharedPref.edit();

        emailText.setText(sharedPref.getString("email",""));
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("email",emailText.getText().toString());
                editor.commit();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class); //change from null
                startActivity(intent);

            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

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