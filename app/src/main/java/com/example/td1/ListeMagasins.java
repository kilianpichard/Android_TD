package com.example.td1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ListeMagasins extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_liste_magasins);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Boutton de retour vers l'activité parente
  }

  public void onClickModify(View view){
    final Intent intent = new Intent(ListeMagasins.this, AjoutMagasin.class);
    final ListView listeMagasins =(ListView)findViewById(R.id.listMagasins);
    listeMagasins.setOnItemClickListener((parent, view1, position, id) -> {
      intent.putExtra("nomMagasin",listeMagasins.getItemAtPosition(position).toString());
      intent.putExtra("text","Changer "+listeMagasins.getItemAtPosition(position).toString()+" en :");
      startActivityForResult(intent,2);
      onActivityResult(1,1,intent);
    });
  }
  public void onClickAjout(View view) {
    Intent ajoutActivity = new Intent(this, AjoutMagasin.class);
    startActivityForResult(ajoutActivity, 1);
    onActivityResult(1, 1, ajoutActivity); //Request code de 1 pour créer, 2 pour modifier
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);
    try {
      String nomMagasin = intent.getStringExtra("nomMagasin");
      if (!(nomMagasin == null)) {
        Toast toast;
        if (requestCode == 1) {
          toast = Toast.makeText(this, "Vous avez ajouter :  " + nomMagasin, Toast.LENGTH_SHORT);
        } else {
          toast = Toast.makeText(this, "Vous avez modifier :  " + nomMagasin, Toast.LENGTH_SHORT);
        }
        toast.setGravity(Gravity.CENTER, 0, -100);
        toast.show();
      }
    } catch (NullPointerException e) {
      e.printStackTrace();
    }


  }
}
