package com.example.td1.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.td1.Entity.Contient;

@Dao
public interface ContientDAO {

  @Insert
  public void insertContient(Contient c);

  @Update
  public abstract void updateContient(Contient c);

  @Delete
  public  abstract void deleteContient(Contient c);
}
