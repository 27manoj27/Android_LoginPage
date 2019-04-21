package com.example.newproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextreg_name;
    EditText mTextuserName;
    EditText mTextPassword;
    EditText mTextPhone;
    RadioGroup mradioG;
    RadioButton mradioSex;
    Button mButtonRegister;
    TextView mTextret_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        mTextreg_name = (EditText)findViewById(R.id.name_reg);
        mTextPassword = (EditText)findViewById(R.id.password);
                mButtonRegister = (Button)findViewById(R.id.submit);
        mTextuserName = (EditText)findViewById(R.id.userName);
                mradioG =(RadioGroup) findViewById(R.id.Rgroup);
                mTextPhone = (EditText) findViewById(R.id.phone);
                mTextret_login =(TextView) findViewById(R.id.ret_login);
        /*mTextViewLogin = (TextView)findViewById(R.id.login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(register.this,MainActivity.class);
                startActivity(LoginIntent);
            }
        });*/

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextuserName.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                //String cnf_pwd = mTextCnfPassword.getText().toString().trim();
                if ((mTextuserName.getText().toString().trim().equals(""))) {
                    mTextuserName.setError("Email is Required!");
                } else {

                    //if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user, pwd);
                    if (val > 0) {
                        Toast.makeText(register.this, "You have registered", Toast.LENGTH_SHORT).show();
                        //Intent moveToLogin = new Intent(register.this,MainActivity.class);
                        //startActivity(moveToLogin);
                    } else {
                        Toast.makeText(register.this, "Registeration Error", Toast.LENGTH_SHORT).show();
                    }

                }
               /* else{
                    Toast.makeText(register.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }*/
            }
        });
        mTextret_login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent LoginPage;
                LoginPage=new Intent(register.this, MainActivity.class);
                startActivity(LoginPage);
            }
        });
    }
}