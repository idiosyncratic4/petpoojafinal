package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class launcher extends AppCompatActivity {

    private Spinner loginas;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_launcher);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            loginas = (Spinner) findViewById(R.id.spinner);
            txt = (TextView) findViewById(R.id.textView);
            ArrayList<String> al = new ArrayList<>();
            al.add("");
            al.add("CUSTOMER");
            al.add("ADMIN");
            al.add("DELIVERY_PERSON");
            ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, al);
            ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            loginas.setAdapter(ad);
            loginas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String login = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "selected as " + login, Toast.LENGTH_LONG).show();
                    if (login.equals("CUSTOMER")) {
                        Intent intent = new Intent(launcher.this, Login.class);
                        startActivity(intent);
                    } else if (login.equals("ADMIN")) {
                        Intent intent = new Intent(launcher.this, Login_a.class);
                        startActivity(intent);
                    } else if(login.equals("DELIVERY_PERSON")){

                        Intent intent = new Intent(launcher.this, Login_d.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(parent.getContext(), "--select--" , Toast.LENGTH_LONG).show();
                    }
                }

                public void onNothingSelected(AdapterView<?> parent) {
                }

            });


        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */
        } catch(Exception e){e.printStackTrace();}
    }
}