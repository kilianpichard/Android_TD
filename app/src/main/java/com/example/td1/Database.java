package com.example.td1;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.td1.DAO.MagasinDAO;
import com.example.td1.Entity.Magasin;

@androidx.room.Database(version = 1, entities = {Magasin.class})
public abstract class Database extends RoomDatabase {

 abstract public MagasinDAO magasinDAO();

  public static Database db(Context context){
    return Room.databaseBuilder(context, Database.class, "Listes.db")
      .fallbackToDestructiveMigration()
      .build();
  }
}
