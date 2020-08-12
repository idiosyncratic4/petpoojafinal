package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login_d extends AppCompatActivity {

    private EditText Name;
    private EditText password;
    private Button Login;
    private TextView Info;
    private Button regist;

    //private int counter=5;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        // try {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_d);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
               }
            });
            */


        Name = (EditText)findViewById(R.id.userid);
        password = (EditText)findViewById(R.id.pwd);
        Login = (Button)findViewById(R.id.login);
        Info = (TextView)findViewById(R.id.txt);
        regist = (Button)findViewById(R.id.register);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), password.getText().toString());
            }
        });

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_d.this, Registration_d.class);
                startActivity(intent);

                //Info.setText("It's working...");
            }
        });

    }
    private void validate(String uid,String pwd) {

        new SigninActivity2Login_d(this, Info).execute(uid, pwd);
        //Info.setText("valid 2222");
    }
}


