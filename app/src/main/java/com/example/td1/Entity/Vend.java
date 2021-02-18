package com.example.td1.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"_id","id_produit","id_magasin"})
public class Vend {

  private int _id;
  private int id_produit;
  private int id_magasin;

  private float prix;
  private String unite;
  private String rayon;
  private String promotion;

}
