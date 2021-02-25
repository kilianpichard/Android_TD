package com.example.td1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        afficherPage(this.getCurrentFocus());
    }


    public void afficherPage(View view){
        try {
            URL url = new URL("https://dev-restandroid.users.info.unicaen.fr/iut/");

            new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... voids) {
                    HttpURLConnection connection = null;
                    StringBuilder res = new StringBuilder();
                    String ligne;
                    try {
                        connection = (HttpURLConnection) url.openConnection();
                        connection.connect();
                        BufferedReader buff = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        while ((ligne = buff.readLine()) != null)
                            res.append(ligne);
                        buff.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return res.toString();
                }

                @Override
                protected void onPostExecute(String s) {
                    WebView t = findViewById(R.id.web);
                    t.loadData(s, "text/html; charset=UTF-8", null);
                }

            }.execute();
        }catch (IOException e){};
    }
}
