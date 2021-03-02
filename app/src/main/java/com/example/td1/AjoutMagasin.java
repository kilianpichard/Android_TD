package com.example.td1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.td1.Entity.Magasin;

import java.util.Arrays;

public class AjoutMagasin extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ajout_magasin);
    Toolbar toolbar = findViewById(R.id.toolbar2);
    setSupportActionBar(toolbar);
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
        Database db = Database.db(getApplicationContext());
        Thread test = new Thread(){
          public void run(){

          }
        };
        test.start();

        if (champ.getText().toString().length() != 0) {
          Thread t = new Thread(){
            public void run(){
              db.magasinDAO().insertMagasin(new Magasin(champ.getText().toString())); //LJ: ok pour ajout
            }
          };
          t.start();
        }
        if (champ.getText().toString().length() != 0) {
          retour.putExtra("nomMagasin", champ.getText().toString());
          setResult(MainActivity.RESULT_OK, retour);
          finish();
        }
      }
    });
  }

}
