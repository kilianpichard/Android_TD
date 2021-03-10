package com.example.td1.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contient {

    @PrimaryKey
    private int _id;

    private int id_produit;
    private int id_liste;
    private float quantite;
    private float achete;
}
