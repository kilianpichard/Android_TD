package com.example.td1.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Magasin {

    @PrimaryKey(autoGenerate = true)
    private int _id;

    private String nom;

    public Magasin(String nom) {
        this.nom = nom;
    }

    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNom() {
        return this.nom;
    }
}
