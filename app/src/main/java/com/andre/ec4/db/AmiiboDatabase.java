package com.andre.ec4.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.andre.ec4.dao.FavoriteAmiiboDao;
import com.andre.ec4.entity.FavoriteAmiibo;

@Database(entities = {FavoriteAmiibo.class}, version = 1)
public abstract class AmiiboDatabase extends RoomDatabase {

    public abstract FavoriteAmiiboDao favoriteAmiiboDao();

    private static AmiiboDatabase instance;

    public static synchronized AmiiboDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AmiiboDatabase.class, "amiibo_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
