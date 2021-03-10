package com.example.td1.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Produit {
    @PrimaryKey
    private int _id;

    private int categorie;
    private String nom;
    private String code;
}
