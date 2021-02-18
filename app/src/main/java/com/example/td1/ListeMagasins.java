package com.example.td1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListeMagasins extends Fragment {

  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_liste_magasins, container, false);
    final Intent intent = new Intent(getActivity(), AjoutMagasin.class);
    final ListView listeMagasins = (ListView) view.findViewById(R.id.listMagasins);
    listeMagasins.setOnItemClickListener((parent, view1, position, id) -> {
      intent.putExtra("nomMagasin", listeMagasins.getItemAtPosition(position).toString());
      intent.putExtra("text", "Changer " + listeMagasins.getItemAtPosition(position).toString() + " en :");
      startActivityForResult(intent, 1);
      onActivityResult(2, 1, intent);
    });
    FloatingActionButton add =  view.findViewById(R.id.add);
    add.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        intent.putExtra("nomMagasin","");
        intent.putExtra("text", "Ajouter un Magasin");
        startActivityForResult(intent, 1);
        onActivityResult(2, 1, intent);
      }
    });
    return view;
  }

  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);
    try {
      String nomMagasin = intent.getStringExtra("nomMagasin");
      if (!(nomMagasin == null)) {
        Toast toast;
        if (requestCode == 1) {
          toast = Toast.makeText(getActivity(), "Vous avez ajouter :  " + nomMagasin, Toast.LENGTH_SHORT);
        } else {
          toast = Toast.makeText(getActivity(), "Vous avez modifier :  " + nomMagasin, Toast.LENGTH_SHORT);
        }
        toast.setGravity(Gravity.CENTER, 0, -100);
        toast.show();
      }
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }
}
