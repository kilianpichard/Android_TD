package com.example.td1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class EditProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        EditText name = (EditText) findViewById(R.id.edit_productName);
        name.setText(intent.getStringExtra("productName"));
        EditText code = (EditText) findViewById(R.id.edit_qte);
        code.setText(intent.getStringExtra("productCode"));

    }


    public void editProduct(View view) {
        Intent intent = getIntent();
        EditText name = (EditText) findViewById(R.id.edit_productName);
        EditText code = (EditText) findViewById(R.id.edit_qte);

        new AsyncTask<Void, Void, String>() {
            @SuppressLint("StaticFieldLeak")
            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL site = new
                            URL("https://dev-restandroid.users.info.unicaen.fr/iut/produits/"+ intent.getStringExtra("id")); //LJ:ok
                    HttpURLConnection conn = (HttpURLConnection) site.openConnection();
                    conn.setRequestMethod("PUT"); //LJ: OK
                    conn.setDoOutput(true);
                    conn.setRequestProperty("Content-Type","application/json; utf-8");
                    OutputStream fluxOut2 = conn.getOutputStream();
                    PrintWriter writer2 = new PrintWriter(fluxOut2,true);
                    writer2.println("{\"_id\":1,\"categorie\":null,\"nom\":\""+name.getText().toString()+"\",\"code\":"+code.getText().toString()+"}"); //LJ:ok
                    System.out.println(conn.getResponseMessage().toString()); //LJ: Ici aussi, il est préférable de récupérer le produit modifié (mais pas essentiel)
                    fluxOut2.close();
                    conn.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "";
            }

        }.execute();

        final Intent retour = new Intent(EditProduct.this, ListeProduit.class);
        setResult(MainActivity.RESULT_OK, retour);
        finish();
    }

    public void delProduct(View view) {
            Intent intent = getIntent();
            new AsyncTask<Void, Void, String>() {
                @SuppressLint("StaticFieldLeak")
                @Override
                protected String doInBackground(Void... voids) {
                    try {
                        URL site = new URL("https://dev-restandroid.users.info.unicaen.fr/iut/produits/"+ intent.getStringExtra("id")); //LJ: ok
                        HttpURLConnection conn = (HttpURLConnection) site.openConnection();
                        conn.setRequestMethod("DELETE"); //LJ: ok
                        conn.setDoOutput(true); //LJ: pour faire quoi ?
                        conn.setRequestProperty("Content-Type", "application/json; utf-8");
                        OutputStream fluxOut3 = conn.getOutputStream();
                        System.out.println(conn.getResponseMessage().toString()); //LJ: ok, récupérer le message de confirmation est un plus mais pas nécessaire
                        fluxOut3.close(); //LJ: sans rien envoyer ?
                        conn.disconnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return "";
                }

            }.execute();

            final Intent retour = new Intent(EditProduct.this, ListeProduit.class);
            setResult(MainActivity.RESULT_OK, retour);
            finish();
    }
}
