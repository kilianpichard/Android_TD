package com.example.td1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AjoutMagasin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_magasin);
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
