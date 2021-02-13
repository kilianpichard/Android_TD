package com.example.td1;

public class Produit {
  public String categorie;
  public String nom;
  public double prix;
  public int promotion; // en %
  public String emplacement;

  public Produit(String categorie, String nom, double prix, int promotion, String emplacement) {
    this.categorie = categorie;
    this.nom = nom;
    this.prix = prix;
    this.emplacement = emplacement;
    this.categorie = categorie;
    this.promotion = promotion;
  }

}
