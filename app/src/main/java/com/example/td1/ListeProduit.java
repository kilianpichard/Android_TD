package com.example.td1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.List;

public class ListeProduit extends Fragment {

  public View onCreateView(LayoutInflater inflater, ViewGroup container,

                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_liste_produits, container, false);
    final List<Produit> produits = Arrays.asList(
      new Produit("Boissons", "Pack 6 Bière", 12.99, 0, "Rayon Alcool"),
      new Produit("Condiments", "Huile d'olive 50cl", 5.79, 10, "Rayon Huile"),
      new Produit("Soins dentaire", "Dentifrice Colgate", 3.59, 20, "Rayon Hygiène"),
      new Produit("Pommes", "Pommes Golden (1kg)", 2.38, 0, "Rayon Fruits & Légumes")
    );
    final boolean[] selection = new boolean[produits.size()];
    ListView lv = (ListView) view.findViewById(R.id.listProduit);

    lv.setOnItemClickListener(
      new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          if (selection[position]) {
            view.setBackgroundColor(Color.WHITE);
          } else {
            view.setBackgroundColor(Color.LTGRAY);
          }
          selection[position] = !selection[position];
        }
      }
    );
    lv.setAdapter(new ArrayAdapter<Produit>(getActivity(), R.layout.produit_item, R.id.productName, produits) {
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
    return view;
  }
}
