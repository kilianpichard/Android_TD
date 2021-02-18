package com.example.td1.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Magasin {
  @PrimaryKey
  private int _id;
  private String nom;
}
