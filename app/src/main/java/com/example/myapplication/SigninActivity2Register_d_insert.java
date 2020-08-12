package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SigninActivity2Register_d_insert extends AsyncTask {
    private TextView statusField;
    private Context context;
    String responseStorage = null; //storage of the response
    @Override
    protected Object doInBackground(Object[] objects) {

        try{
            //this.statusField.setText("Inserted Successfulm4");
            String fname = (String)objects[0];
            String lname = (String)objects[1];
            String address = (String)objects[2];
            String contact = (String)objects[3];
            String username = (String)objects[4];
            String password = (String)objects[5];
            String sec_q = (String)objects[6];
            String sec_a = (String)objects[7];


            String link="http://10.0.2.2:80/f123/insert_regist_d.php";
            String data  = URLEncoder.encode("fname", "UTF-8") + "=" +
                    URLEncoder.encode(fname, "UTF-8");
            data += "&" + URLEncoder.encode("lname", "UTF-8") + "=" +
                    URLEncoder.encode(lname, "UTF-8");
            data += "&" + URLEncoder.encode("address", "UTF-8") + "=" +
                    URLEncoder.encode(address, "UTF-8");
            data += "&" + URLEncoder.encode("contact", "UTF-8") + "=" +
                    URLEncoder.encode(contact, "UTF-8");
            data += "&" + URLEncoder.encode("username", "UTF-8") + "=" +
                    URLEncoder.encode(username, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                    URLEncoder.encode(password, "UTF-8");
            data += "&" + URLEncoder.encode("sec_q", "UTF-8") + "=" +
                    URLEncoder.encode(sec_q, "UTF-8");
            data += "&" + URLEncoder.encode("sec_a", "UTF-8") + "=" +
                    URLEncoder.encode(sec_a, "UTF-8");

            URL url = new URL(link);
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.write( data );
            wr.flush();

            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null) {
                sb.append(line);
                break;
            }

            responseStorage=sb.toString();
        } catch(Exception e){
            responseStorage="Exception: " + e.getMessage();
        }
        return responseStorage;
    }



    //flag 0 means get and 1 means post.(By default it is get.)
    public SigninActivity2Register_d_insert(Context context,TextView statusField) {
        this.context = context;
        this.statusField = statusField;

    }

    protected void onPreExecute(){
        this.statusField.setText("wait...");
    }
    //protected String doInBackground(String... arg0) {

    //}

    @Override
    protected void onPostExecute(Object result){
       //this.statusField.setText("def"+result.toString()+"gh");
         this.statusField.setText(result.toString());
       if(this.statusField.getText().equals(" Inserted_Successfully  "))
        {
           // this.statusField.setText("valid User".toString());
            Intent i=new Intent(this.context,Home_d.class);
            i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
            this.context.startActivity(i);
        }
      else {
           // this.statusField.setText("Invalid User".toString());
           //counter--;
           statusField.setText("Not Registered Yet...Please Try Again!!");
         /*  if(counter == 0)
            {
                context.setEnabled(false);
            } */

       }
        }

    }

