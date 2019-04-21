package com.example.newproject1;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity<userName> extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;
    TextView mTextViewSkip;
    SharedPreferences sharedpre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);


            db = new DatabaseHelper(this);
            mTextUsername = (EditText) findViewById(R.id.userName);
            mTextPassword = (EditText) findViewById(R.id.password);
            mButtonLogin = (Button) findViewById(R.id.login);
            mTextViewRegister = (TextView) findViewById(R.id.register);
            mTextViewSkip = (TextView) findViewById(R.id.skip);

            mTextViewRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent registerIntent;
                    registerIntent = new Intent(MainActivity.this, register.class);
                    startActivity(registerIntent);
                }
            });

            mButtonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String user = mTextUsername.getText().toString().trim();
                    String pwd = mTextPassword.getText().toString().trim();
                    boolean res = db.checkUser(user, pwd);


                    if (res) {
                        Intent HomePage;
                        HomePage = new Intent(MainActivity.this, Profile.class);
                        startActivity(HomePage);

                        SharedPreferences sharedpre = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = sharedpre.edit();
                        editor.putString("username", mTextUsername.getText().toString());
                        editor.putString("password", mTextPassword.getText().toString());
                        editor.apply();
                        editor.commit();
                    } else {
                        Toast.makeText(MainActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                    }

                }

            });



        mTextViewSkip.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent HomePage;
                HomePage=new Intent(MainActivity.this, Skip.class);
                startActivity(HomePage);
            }
        });
       /* public void mButtonLogin(View view)

        {
            SharedPreferences sharePre = getSharedPreferences("user", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharePre.edit();
            editor.putString("user", mTextUsername.getText().toString());
            editor.putString("Password", mTextPassword.getText().toString());
            editor.apply();
            editor.commit();
        }*/
    }
    }

