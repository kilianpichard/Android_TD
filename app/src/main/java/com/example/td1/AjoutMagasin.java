package com.example.td1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    EditText champ = (EditText) findViewById(R.id.editMagasin);
    TextView text = (TextView) findViewById(R.id.textView);
    Button send = (Button) findViewById(R.id.send);
    final Intent intentP = getIntent();
    final Intent retour = new Intent(AjoutMagasin.this, ListeMagasins.class);
    if (intentP.getStringExtra("text") != null && intentP.getStringExtra("nomMagasin") != null) {
      text.setText(intentP.getStringExtra("text"));
      champ.setText(intentP.getStringExtra("nomMagasin"));
    }

    send.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (champ.getText().toString().length() != 0) {
          retour.putExtra("nomMagasin", champ.getText().toString());
          setResult(MainActivity.RESULT_OK, retour);
          finish();
        }
      }
    });
  }

}
