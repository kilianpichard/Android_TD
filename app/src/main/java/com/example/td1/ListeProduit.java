package com.example.td1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class ListeProduit extends Fragment {
    private List<Produit> produits = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_liste_produits, container, false);
        try {
            URL url = new URL("https://dev-restandroid.users.info.unicaen.fr/iut/produits");

            new AsyncTask<Void, Void, String>() { //LJ: cette asyncTask serait mieux dans le ViewModel du fragment....
                @SuppressLint("StaticFieldLeak")
                @Override
                protected String doInBackground(Void... voids) {
                    HttpURLConnection connection = null;
                    StringBuilder res = new StringBuilder();
                    String ligne;
                    try {
                        connection = (HttpURLConnection) url.openConnection();
                        connection.connect();
                        //LJ: pas de test de succès ?
                        BufferedReader buff = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        while ((ligne = buff.readLine()) != null)
                            res.append(ligne);
                        buff.close();
                        connection.disconnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return res.toString();
                }

                @Override
                protected void onPostExecute(String s) {//LJ: ok
                    try {
                        JSONArray jsonObj = new JSONArray(s);
                        Produit ps[] = new Produit[jsonObj.length()];
                        for (int i = 0; i < jsonObj.length(); i++) {
                            Produit p = new Produit(jsonObj.getJSONObject(i).getString("categorie"), jsonObj.getJSONObject(i).getString("nom"), jsonObj.getJSONObject(i).getString("_id"), jsonObj.getJSONObject(i).getString("code"));
                            ps[i] = p; //LJ: ok traduction JSON->Pojo
                        }
                        produits = Arrays.asList(ps);

                        final boolean[] selection = new boolean[produits.size()];
                        ListView lv = (ListView) view.findViewById(R.id.listProduit);

                        lv.setOnItemClickListener(
                                new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                                            Intent edit = new Intent(getActivity(), EditProduct.class);
                                            edit.putExtra("id",produits.get(position).id);
                                            edit.putExtra("productName",produits.get(position).nom);
                                        edit.putExtra("productCode",produits.get(position).code);
                                            startActivityForResult(edit, 1);

                                    }
                                }
                        );
                        lv.setAdapter(new ArrayAdapter<Produit>(getActivity(), R.layout.produit_item, R.id.productName, produits) { //LJ: ok afficahge
                            @SuppressLint("DefaultLocale")
                            @NonNull
                            @Override
                            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent
                            ) {
                                View v = super.getView(position, convertView, parent);
                                TextView productName = v.findViewById(R.id.productName);
                                TextView productCat = v.findViewById(R.id.productCat);
                                TextView productPrice = v.findViewById(R.id.productPrice);
                                TextView productReduc = v.findViewById(R.id.productReduc);
                                TextView productPlace = v.findViewById(R.id.productPlace);
                                TextView productPricePromo = v.findViewById(R.id.productPriceProm);
                                productName.setText(produits.get(position).nom);
                                productCat.setText(produits.get(position).categorie);
                                productPrice.setText(String.format("%.2f", produits.get(position).prix) + "€");
                                productPricePromo.setText(String.format("%.2f", produits.get(position).prix * (1 - produits.get(position).promotion * 0.01)) + "€");
                                productReduc.setText("-" + String.valueOf(produits.get(position).promotion) + "%");
                                productPlace.setText(produits.get(position).emplacement);


                                if (produits.get(position).promotion == 0) {
                                    productReduc.setText("");
                                    productPrice.setText("");
                                } else {
                                    productPrice.setPaintFlags(productPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                                    productPrice.setTextColor(Color.RED);
                                }
                                return v;
                            }
                        });

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }.execute();


            final Intent intent = new Intent(getActivity(), AjoutProduit.class);
            FloatingActionButton add = view.findViewById(R.id.addProduct);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent.putExtra("nomMagasin", "");
                    intent.putExtra("text", "Ajouter un Magasin");
                    startActivityForResult(intent, 1);
                }
            });
        } catch (IOException e) {
        }
        ;

        return view;
    }

}