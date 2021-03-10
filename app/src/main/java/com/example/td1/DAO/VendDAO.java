package com.example.td1.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.td1.Entity.Vend;

@Dao
public interface VendDAO {

    @Insert
    public void insertVend(Vend v);

    @Update
    public abstract void updateVend(Vend v);

    @Delete
    public abstract void deleteVend(Vend v);
}
