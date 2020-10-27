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

        final Button loginButton = findViewById(R.id.loginButton);
        final TextView signUpButton = findViewById(R.id.signupbutton);
        final SharedPreferences sharedPref = getSharedPreferences("email", Context.MODE_PRIVATE);
        final EditText emailText = findViewById(R.id.emailText);
        final EditText passwordText = findViewById(R.id.editText);

        emailText.setText(sharedPref.getString("email","email@domain.ca"));
        final SharedPreferences.Editor editor = sharedPref.edit();

        emailText.setText(sharedPref.getString("email",""));
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String emailString = emailText.getText().toString();
                Log.i("",emailString);
                String pass = passwordText.getText().toString();
                String valid = "admin";
                if(emailString.equals(valid)){
                    editor.putString("email",emailText.getText().toString());
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class); //change from null
                    startActivity(intent);
                    finish();
                }
                else{
                    CharSequence text = "Invalid Login";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(LoginActivity.this , text, duration);
                    toast.show();
                }
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