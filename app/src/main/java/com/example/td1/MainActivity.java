package com.example.td1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onClickMagasins(View view) {
    startActivity(new Intent(this, ListeMagasins.class));
  }

  public void onClickProduit(View view) {
    startActivity(new Intent(this, ListeProduit.class));
  }
}
