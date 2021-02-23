package com.example.td1.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Magasin {
  @PrimaryKey
  private int _id;

  private String nom;

  public int get_id() {
    return _id;
  }

  public void set_id(int _id) {
    this._id = _id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }
}
