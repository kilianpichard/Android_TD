package com.example.td1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.td1.Entity.Magasin;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class AjoutProduit extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_product);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
    }



    public void addProduct(View view) {
        EditText name = (EditText) findViewById(R.id.edit_productName);
        EditText qte = (EditText) findViewById(R.id.edit_qte);

        if(name.getText().toString().length() > 0 && qte.getText().toString().length() >0){

            new AsyncTask<Void, Void, String>() {
                @SuppressLint("StaticFieldLeak")
                @Override
                protected String doInBackground(Void... voids) {
                    try {
                        String productName = name.getText().toString();
                        String productQte = qte.getText().toString();

                        HttpURLConnection conn = null;
                        URL site = new
                                URL("https://dev-restandroid.users.info.unicaen.fr/iut/produits");
                        conn = (HttpURLConnection) site.openConnection();
                        conn.setRequestMethod("POST"); //LJ: ok
                        conn.setDoOutput(true);
                        conn.setRequestProperty("Content-Type", "application/json; utf-8"); //LJ: ok
                        OutputStream fluxOut = conn.getOutputStream();
                        PrintWriter writer = new PrintWriter(fluxOut, true);
                        writer.println("{\"_id\":1,\"categorie\":null,\"nom\":\""+ productName+"\",\"code\":"+ productQte +"}"); //LJ: ok
                        System.out.println(conn.getResponseMessage().toString());//LJ: ok mais insuffisant. Il faut répupérer la réponse ! (id du produit ajouté...)
                        fluxOut.close();
                        conn.disconnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return "";
                }

            }.execute();

            final Intent retour = new Intent(AjoutProduit.this, ListeProduit.class);
            setResult(MainActivity.RESULT_OK, retour);
            finish(); //LJ: attention, n'attend pas la fin de la requête pour retourner à la liste...
        }



    }
}
