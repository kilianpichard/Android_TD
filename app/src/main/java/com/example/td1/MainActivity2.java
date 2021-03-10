package com.example.td1;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        afficherPage(this.getCurrentFocus());
    }


    public void afficherPage(View view) {
        try {
            URL url = new URL("https://dev-restandroid.users.info.unicaen.fr/iut/produits");

            new AsyncTask<Void, Void, String>() {
                @SuppressLint("StaticFieldLeak")
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
                    try {
                        TextView test = findViewById(R.id.textView4);
                        JSONArray jsonObj = new JSONArray(s);
                        Produit ps[] = new Produit[jsonObj.length()];
                        for (int i = 0; i < jsonObj.length(); i++) {
                            Produit p = new Produit(jsonObj.getJSONObject(i).getString("categorie"), jsonObj.getJSONObject(i).getString("nom"));
                            ps[i] = p;
                        }
                        final List<Produit> produits = Arrays.asList(ps);
                        test.setText(produits.get(1).toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    WebView t = findViewById(R.id.web);
                    t.loadData(s, "text/html; charset=UTF-8", null);

                }

            }.execute();
        } catch (IOException e) {
        }
        ;
    }
}
