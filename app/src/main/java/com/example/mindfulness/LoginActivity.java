package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button loginButton = findViewById(R.id.loginButton);

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

                Intent intent = new Intent(LoginActivity.this, null);
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

    protected void onDestory(){
        super.onDestroy();

    }
}
