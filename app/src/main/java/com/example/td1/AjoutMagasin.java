package com.example.td1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AjoutMagasin extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ajout_magasin);
    Toolbar toolbar = findViewById(R.id.toolbar2);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Boutton de retour vers l'activité parente
  }

  public void addMagasin(View view) {
    EditText champ = (EditText) findViewById(R.id.editMagasin);
    if (champ.getText().toString().length() != 0) {
      Intent retour = new Intent();
      retour.putExtra("nomMagasin", champ.getText().toString());
      setResult(1, retour);
      finish();
    }
  }
}
