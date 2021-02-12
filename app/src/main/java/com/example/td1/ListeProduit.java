package com.example.td1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
      new Produit("Boissons","Pack 6 Bière",12.99, 0,"Rayon Alcool"),
      new Produit("Condiments","Huile d'olive 50cl",5.79, 10,"Rayon Huile"),
      new Produit("Soins dentaire","Dentifrice Colgate",3.59, 20,"Rayon Hygiène"),
      new Produit("Pommes","Pommes Golden (1kg)",2.38, 0,"Rayon Fruits & Légumes")
    );

  }
}
