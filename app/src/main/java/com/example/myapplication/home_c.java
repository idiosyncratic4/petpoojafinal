package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.widget.Button;

public class home_c extends AppCompatActivity {


    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

      try {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_c);
       /* Toolbar toolbar = findViewById(R.id.toolbar);
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

          btn1= (Button)findViewById(R.id.button1);
          btn2= (Button)findViewById(R.id.button2);
          btn3= (Button)findViewById(R.id.button3);
          btn4= (Button)findViewById(R.id.button4);


          btn1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(home_c.this, menu_m.class);
                  startActivity(intent);
              }
          });
          btn2.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(home_c.this, menu_s.class);
                  startActivity(intent);

                  // Info.setText("It's working...");
              }
          });
          btn3.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(home_c.this, menu_sb.class);
                  startActivity(intent);

                  // Info.setText("It's working...");
              }
          });
          btn4.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(home_c.this, menu_f.class);
                  startActivity(intent);

                  // Info.setText("It's working...");
              }
          });

      }catch(Exception e){e.printStackTrace();}

    }

}
