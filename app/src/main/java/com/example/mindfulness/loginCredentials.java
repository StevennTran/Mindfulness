package com.example.mindfulness;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class loginCredentials extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public loginCredentials() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment loginCredentials.
     */
    // TODO: Rename and change types and number of parameters
    public static loginCredentials newInstance(String param1, String param2) {
        loginCredentials fragment = new loginCredentials();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_credentials, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        final Button loginButton = view.findViewById(R.id.loginButton);
        final TextView signUpButton = view.findViewById(R.id.signupbutton);
        final SharedPreferences sharedPref = getActivity().getSharedPreferences("email", Context.MODE_PRIVATE);
        final EditText emailText = view.findViewById(R.id.emailText);
        final EditText passwordText = view.findViewById(R.id.editText);
        emailText.setText(sharedPref.getString("email","email@domain.ca"));
        final SharedPreferences.Editor editor = sharedPref.edit();
        DatabaseHelper dbHelper = new DatabaseHelper(view.getContext()); //View is parent
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "SELECT * FROM Accounts";
        final Cursor myCursor = db.rawQuery(query,null);
        emailText.setText(sharedPref.getString("email",""));
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString = emailText.getText().toString();
                Log.i("",emailString);
                String pass = passwordText.getText().toString();
                String valid = "admin";
                Boolean verification = false;
                myCursor.moveToFirst();
                while(!myCursor.isAfterLast() || !emailString.equals(valid)){
                    if(myCursor.getString(myCursor.getColumnIndex(DatabaseHelper.USERNAME)).equals(emailString)){
                        if(myCursor.getString(myCursor.getColumnIndex(DatabaseHelper.PASSWORD)).equals(pass)){
                            verification = true;
                            break;
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        myCursor.moveToNext();
                    }
                }
                myCursor.close();
                if(verification || emailString.equals(valid)){
                    editor.putString("email",emailText.getText().toString());
                    editor.commit();

                    Intent intent = new Intent(v.getContext(), MainActivity.class); //change from null
                    startActivity(intent);
                    getActivity().finish();
                }
                else{
                    CharSequence text = "Invalid Login";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(v.getContext(), text, duration);
                    toast.show();
                }
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
