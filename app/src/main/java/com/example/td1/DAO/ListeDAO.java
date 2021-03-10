package com.example.td1.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.td1.Entity.Liste;

@Dao
public interface ListeDAO {

    @Insert
    public void insertListe(Liste l);

    @Update
    public abstract void updateListe(Liste l);

    @Delete
    public abstract void deleteListe(Liste l);
}
