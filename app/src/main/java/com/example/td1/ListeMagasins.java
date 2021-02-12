package com.example.td1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Gravity;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class ListeMagasins extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_magasins);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Boutton de retour vers l'activité parente

    }

    public void onClickAjout(View view) {
        Intent ajoutActivity = new Intent(this, AjoutMagasin.class);
        startActivityForResult(ajoutActivity,1);
        onActivityResult(1,1,ajoutActivity); //Request code de 1 pour créer, 2 pour modifier
    }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);
    try{
      String nomMagasin = intent.getStringExtra("nomMagasin");
      if(!(nomMagasin == null)){
        Toast toast;
        if(requestCode == 1) {
          toast = Toast.makeText(this, "Vous avez ajouter :  " + nomMagasin, Toast.LENGTH_SHORT);
        }else {
          toast = Toast.makeText(this, "Vous avez modifier :  " + nomMagasin, Toast.LENGTH_SHORT);
        }
        toast.setGravity(Gravity.CENTER, 0, -100);
        toast.show();
      }
    }catch (NullPointerException e){
      e.printStackTrace();
    }



  }
}
