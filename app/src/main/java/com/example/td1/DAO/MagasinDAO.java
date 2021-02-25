package com.example.td1.DAO;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.td1.Entity.Magasin;

import java.util.List;

@Dao
public interface MagasinDAO {

  @Insert
  void insertMagasin(Magasin m);

  @Update
  void updateMagasin(Magasin m);

  @Delete
  void deleteMagasin(Magasin m);

  @Query("select * from Magasin")
  Cursor getAll();
}
