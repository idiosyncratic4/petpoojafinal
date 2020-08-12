package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class menu_s extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button view_cart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu_f);
        /*    Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            FloatingActionButton fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }); */

            btn1= (Button)findViewById(R.id.btn1);
            btn2= (Button)findViewById(R.id.btn2);
            btn3= (Button)findViewById(R.id.btn3);
            btn4= (Button)findViewById(R.id.btn4);
            btn5= (Button)findViewById(R.id.btn5);
            view_cart= (Button)findViewById(R.id.view_cart);

            view_cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(menu_s.this, cart_s.class);
                    startActivity(intent);

                    // Info.setText("It's working...");
                }
            });

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = getApplicationContext();
                    CharSequence text = "Successfully added to cart";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    // Intent intent = new Intent(menu_f.this,cart_ff.class);
                    //  startActivity(intent);
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = getApplicationContext();
                    CharSequence text = "Successfully added to cart";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    // Intent intent = new Intent(menu_f.this,cart_ff.class);
                    //  startActivity(intent);
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = getApplicationContext();
                    CharSequence text = "Successfully added to cart";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    // Intent intent = new Intent(menu_f.this,cart_ff.class);
                    //  startActivity(intent);
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = getApplicationContext();
                    CharSequence text = "Successfully added to cart";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    // Intent intent = new Intent(menu_f.this,cart_ff.class);
                    //  startActivity(intent);
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = getApplicationContext();
                    CharSequence text = "Successfully added to cart";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    // Intent intent = new Intent(menu_f.this,cart_ff.class);
                    //  startActivity(intent);
                }
            });
        }catch(Exception e){e.printStackTrace();}
    }

}
