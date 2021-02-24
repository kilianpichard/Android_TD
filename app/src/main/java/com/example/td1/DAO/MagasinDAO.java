package com.example.td1.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.td1.Entity.Magasin;

@Dao
public interface MagasinDAO {

  @Insert
  public void insertMagasin(Magasin m);

  @Update
  public abstract void updateMagasin(Magasin m);

  @Delete
  public abstract void deleteMagasin(Magasin m);
}
