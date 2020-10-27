package com.example.mindfulness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText registerEmail = findViewById(R.id.emailSignUpText);
        final EditText registerPassword = findViewById(R.id.signUpPassword);
        Button signUpButton = findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = false;
                if(registerEmail.getText().toString().contains("@")){
                    check = true;
                    Log.i("Register","valid email");
                    if(registerPassword.getText().toString().length() == 0){
                        CharSequence text = "Please type in a password";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(RegisterActivity.this , text, duration);
                        toast.show();
                    }
                    else{
                        Log.i("Register","Valid registerd account");
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();

                    }
                }
                else{
                    CharSequence text = "Invalid Email";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(RegisterActivity.this , text, duration);
                    toast.show();
                }

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
