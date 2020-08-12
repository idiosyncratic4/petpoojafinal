package com.example.myapplication;

import android.content.Context;
import android.content.Intent;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SigninActivity2Login extends AsyncTask {
    private TextView statusField;
    private Context context;
    //private int counter=5;
    String responseStorage = ""; //storage of the response

    @Override
    protected Object doInBackground(Object[] objects) {

        try {
            //this.statusField.setText("Inserted Successfully");
            String username = (String) objects[0];
            String password = (String) objects[1];

            String link = "http://10.0.2.2:80/f123/login.php";
            String data = URLEncoder.encode("username", "UTF-8") + "=" +
                    URLEncoder.encode(username, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                    URLEncoder.encode(password, "UTF-8");

            URL url = new URL(link);
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.write(data);
            wr.flush();

            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                break;
            }

            responseStorage = sb.toString();
        } catch (Exception e) {
            responseStorage = "Exception: " + e.getMessage();
        }
        return responseStorage;
    }


    //flag 0 means get and 1 means post.(By default it is get.)
    public SigninActivity2Login(Context context, TextView statusField) {
        this.context = context;
        this.statusField = statusField;

    }

    protected void onPreExecute() {
        this.statusField.setText("wait...");
    }


    //protected String doInBackground(String... arg0) {


    //}

    @Override
    protected void onPostExecute(Object result) {
        // this.statusField.setText("def"+result.toString()+"gh");
        this.statusField.setText(result.toString());
        if (this.statusField.getText().equals(" found")) {
            this.statusField.setText("valid User".toString());
            Intent i = new Intent(this.context, home_c.class);
            i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
            this.context.startActivity(i);
        } else {
            // this.statusField.setText("Invalid User".toString());
            //counter--;
            statusField.setText("Wrong attempt ,Please try again...");
         /*  if(counter == 0)
            {
                context.setEnabled(false);
            } */

        }
    }
}