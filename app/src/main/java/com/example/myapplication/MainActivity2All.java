package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2All extends Activity {

    private EditText usernameField,passwordField;
    private TextView status,status2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2all);

        usernameField = (EditText)findViewById(R.id.editText1);
        passwordField = (EditText)findViewById(R.id.editText2);
        status = (TextView)findViewById(R.id.textView3);
        status2 = (TextView)findViewById(R.id.textView4);
       // status = (TextView)findViewById(R.id.textView6);
       // role = (TextView)findViewById(R.id.textView7);
       // method = (TextView)findViewById(R.id.textView9);
    }





    public void insertPost(View view){
       // String username = usernameField.getText().toString();
       // String password = passwordField.getText().toString();
       // new SigninActivity2All(this,status).execute(username,password);

        Intent i=new Intent(this,Login.class);
        startActivity(i);
    }

    public void selectPost(View view){
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        new SigninActivity2Select(this,status2).execute(username,password);
    }
}
