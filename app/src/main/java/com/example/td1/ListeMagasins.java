package com.example.td1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class ListeMagasins extends Fragment {

  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_liste_magasins, container, false);
    //  final Intent intent = new Intent(ListeMagasins, AjoutMagasin.class);
    final ListView listeMagasins = (ListView) view.findViewById(R.id.listMagasins);
  /*  listeMagasins.setOnItemClickListener((parent, view1, position, id) -> {
      intent.putExtra("nomMagasin", listeMagasins.getItemAtPosition(position).toString());
      intent.putExtra("text", "Changer " + listeMagasins.getItemAtPosition(position).toString() + " en :");
      startActivityForResult(intent, 1);
      onActivityResult(2, 1, intent);
    });*/
    return view;
  }

    public void onClickAjout (View view){
      Intent ajoutActivity = new Intent(getActivity(), AjoutMagasin.class);
      ajoutActivity.putExtra("nomMagasin", "");
      ajoutActivity.putExtra("text", "Ajouter un Magasin");
      startActivityForResult(ajoutActivity, 1);
      onActivityResult(1, 1, ajoutActivity);
    }

  /*public void onActivityResult(int requestCode, int resultCode, Bundle intent) {
    super.onActivityResult(requestCode, resultCode, intent);
    try {
      String nomMagasin = bundle.getStringExtra("nomMagasin");
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


  }*/
}
