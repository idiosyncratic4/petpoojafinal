package com.example.myapplication;

import android.content.Context;
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

public class SigninActivity2All extends AsyncTask {
    private TextView statusField;
    private Context context;
    String responseStorage = null; //storage of the response
    @Override
    protected Object doInBackground(Object[] objects) {

        try{
            //this.statusField.setText("Inserted Successfulm4");
            String username = (String)objects[0];
            String password = (String)objects[1];

            String link="http://10.0.2.2:80/f123/insert.php";
            String data  = URLEncoder.encode("username", "UTF-8") + "=" +
                    URLEncoder.encode(username, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                    URLEncoder.encode(password, "UTF-8");

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
    public SigninActivity2All(Context context,TextView statusField) {
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
        this.statusField.setText("Inserted Successfully"+result);

    }

}
