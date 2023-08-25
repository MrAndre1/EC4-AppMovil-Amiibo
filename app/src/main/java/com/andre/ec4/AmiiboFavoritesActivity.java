package com.andre.ec4;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andre.ec4.adapter.AmiiboFavoritesAdapter;
import com.andre.ec4.db.AmiiboDatabase;
import com.andre.ec4.entity.FavoriteAmiibo;

import java.util.List;

public class AmiiboFavoritesActivity extends AppCompatActivity {
    private RecyclerView recyclerViewFavorites;
    private AmiiboFavoritesAdapter amiiboFavoritesAdapter;
    private List<FavoriteAmiibo> favoriteAmiibos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amiibo_favorites);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerViewFavorites = findViewById(R.id.recyclerViewFavorites);
        recyclerViewFavorites.setLayoutManager(new LinearLayoutManager(this));

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                favoriteAmiibos = AmiiboDatabase.getInstance(AmiiboFavoritesActivity.this)
                        .favoriteAmiiboDao()
                        .getAllFavorites();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        amiiboFavoritesAdapter = new AmiiboFavoritesAdapter(favoriteAmiibos);
                        recyclerViewFavorites.setAdapter(amiiboFavoritesAdapter);
                    }
                });
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
