package com.example.td1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListeProduit extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_liste_produits);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Boutton de retour vers l'activité parente

    final List<Produit> produits = Arrays.asList(
            new Produit("Boissons", "Pack 6 Bière", 12.99, 0, "Rayon Alcool"),
            new Produit("Condiments", "Huile d'olive 50cl", 5.79, 10, "Rayon Huile"),
            new Produit("Soins dentaire", "Dentifrice Colgate", 3.59, 20, "Rayon Hygiène"),
            new Produit("Pommes", "Pommes Golden (1kg)", 2.38, 0, "Rayon Fruits & Légumes")
    );
    ListView lv = (ListView) findViewById(R.id.listProduit);
   lv.setAdapter(new ArrayAdapter<Produit>(this, R.layout.produit_item,R.id.productName, produits) {
      @SuppressLint("DefaultLocale")
      @NonNull
      @Override
      public View getView ( int position, @Nullable View convertView, @NonNull ViewGroup parent
      ){
        View v = super.getView(position, convertView, parent);
        TextView productName = v.findViewById(R.id.productName);
        TextView productCat = v.findViewById(R.id.productCat);
        TextView productPrice = v.findViewById(R.id.productPrice);
        TextView productReduc = v.findViewById(R.id.productReduc);
        TextView productPlace = v.findViewById(R.id.productPlace);
        TextView productPricePromo = v.findViewById(R.id.productPriceProm);
        productName.setText(produits.get(position).nom);
        productCat.setText(produits.get(position).categorie);
        productPrice.setText(String.format("%.2f",produits.get(position).prix)+"€");
        productPricePromo.setText(String.format("%.2f",produits.get(position).prix*(1-produits.get(position).promotion*0.01))+"€");
        productReduc.setText("-"+String.valueOf(produits.get(position).promotion)+"%");
        productPlace.setText(produits.get(position).emplacement);


        if(produits.get(position).promotion==0){
          productReduc.setText("");
          productPrice.setText("");
        }else{
          productPrice.setPaintFlags(productPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        return v;
      }
    });


  }
}
