package com.example.td1.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.td1.Entity.Produit;

@Dao
public interface ProduitDAO {

  @Insert
  public void insertProduit(Produit p);

  @Update
  public abstract Produit updateProduit(Produit p,int id);

  @Delete
  public abstract void deleteProduit(int id);
}
