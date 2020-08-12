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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class registration_c extends AppCompatActivity {

    private EditText fname;
    private EditText lname;
    private EditText address;
    private EditText contact;
    private EditText userid;
    private EditText password;
    private Spinner sq_que;
    private EditText sq_ans;
    private Button Register;
    private TextView Info;


    //private int counter=5;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
try {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_registration_c);

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


    fname = (EditText) findViewById(R.id.editText4);
    password = (EditText) findViewById(R.id.editText5);
    lname = (EditText) findViewById(R.id.editText6);
    address = (EditText) findViewById(R.id.editText7);
    userid = (EditText) findViewById(R.id.editText9);
    contact = (EditText) findViewById(R.id.editText8);
    sq_ans = (EditText) findViewById(R.id.sec_ans);
    sq_que = (Spinner) findViewById(R.id.questions);
    Info = (TextView) findViewById(R.id.info);

    ArrayList<String> al=new ArrayList<>();
    al.add("");
    al.add("Favourite Cuisine?");
    al.add("School Name?");
    al.add("Nickname?");
    ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,al);
    ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    sq_que.setAdapter(ad);
    sq_que.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                                         @Override
                                         public void onItemSelected(AdapterView<?> parent, View view, int position, long id ) {
                                             String sec_q = parent.getItemAtPosition(position).toString();
                                             Toast.makeText(parent.getContext(),"selected " +sec_q,Toast.LENGTH_LONG).show();}
                                         public void onNothingSelected(AdapterView<?> parent){}
                                     });

    Register = (Button) findViewById(R.id.register);

    Register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Intent intent = new Intent(registration_c.this, Home.class);
            //startActivity(intent);

            validate(fname.getText().toString(), lname.getText().toString(), address.getText().toString(), contact.getText().toString(), userid.getText().toString(), password.getText().toString(), sq_que.getSelectedItem().toString(), sq_ans.getText().toString());

        }
    });
}catch(Exception e){e.printStackTrace();}
    }
        private void validate(String fName, String lName, String Address, String Contact, String uid,String pwd, String sq_qstn, String sq_ansr){

            new SigninActivity2Register_insert(this,Info).execute(fName,lName,Address, Contact, uid, pwd, sq_qstn, sq_ansr);
            //Info.setText("valid 2222");
        }



}