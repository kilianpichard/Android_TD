package com.example.td1;

public class Produit {
    public String categorie;
    public String id;
    public String nom;
    public String code;
    public double prix;
    public int promotion; // en %
    public String emplacement;

    public Produit(String categorie, String nom, double prix, int promotion, String emplacement) {
        this.categorie = categorie;
        this.nom = nom;
        this.prix = prix;
        this.emplacement = emplacement;
        this.promotion = promotion;
    }

    public Produit(String categorie, String nom,String id,String code) {
        this.id = id;
        this.code = code;
        this.categorie = categorie;
        this.nom = nom;
        this.prix = 0;
        this.emplacement = "Emplacement Inconnu";
        this.promotion = 0;
    }
}
