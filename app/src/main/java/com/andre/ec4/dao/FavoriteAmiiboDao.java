package com.andre.ec4.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.andre.ec4.entity.FavoriteAmiibo;

import java.util.List;

@Dao
public interface FavoriteAmiiboDao {

    @Insert
    void insert(FavoriteAmiibo favoriteAmiibo);

    @Query("SELECT * FROM favorite_amiibos")
    List<FavoriteAmiibo> getAllFavorites();
}
