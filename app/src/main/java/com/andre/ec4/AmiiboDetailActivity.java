package com.andre.ec4;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.andre.ec4.db.AmiiboDatabase;
import com.andre.ec4.entity.FavoriteAmiibo;
import com.andre.ec4.model.Amiibo;
import com.squareup.picasso.Picasso;

public class AmiiboDetailActivity extends AppCompatActivity {
    private ImageView imageViewDetail;
    private TextView textViewName;
    private TextView textViewAmiiboSeries;
    private TextView textViewCharacter;
    private TextView textViewTail;
    private TextView textViewType;
    private Button btnAddToFavorites;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amiibo_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageViewDetail = findViewById(R.id.imageViewDetail);
        textViewName = findViewById(R.id.textViewName);
        textViewAmiiboSeries = findViewById(R.id.textViewAmiiboSeries);
        textViewCharacter = findViewById(R.id.textViewCharacter);
        textViewTail = findViewById(R.id.textViewTail);
        textViewType = findViewById(R.id.textViewType);

        btnAddToFavorites = findViewById(R.id.btnAddToFavorites);
        btnAddToFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddToFavorites.setText("Ver en Favoritos");

                Amiibo amiibo = getIntent().getParcelableExtra("amiibo");

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        FavoriteAmiibo favoriteAmiibo = new FavoriteAmiibo();
                        favoriteAmiibo.setName(amiibo.getName());
                        favoriteAmiibo.setAmiiboSeries(amiibo.getAmiiboSeries());
                        favoriteAmiibo.setCharacter(amiibo.getCharacter());

                        AmiiboDatabase.getInstance(AmiiboDetailActivity.this)
                                .favoriteAmiiboDao()
                                .insert(favoriteAmiibo);
                    }
                });

                Intent intent = new Intent(AmiiboDetailActivity.this, AmiiboFavoritesActivity.class);
                intent.putExtra("favoriteAmiibo", amiibo);
                startActivity(intent);
            }
        });

        Amiibo amiibo = getIntent().getParcelableExtra("amiibo");

        if (amiibo != null) {
            textViewName.setText(amiibo.getName());
            textViewAmiiboSeries.setText(amiibo.getAmiiboSeries());
            textViewCharacter.setText(amiibo.getCharacter());
            textViewTail.setText(amiibo.getTail());
            textViewType.setText(amiibo.getType());

            Picasso.get().load(amiibo.getImage()).into(imageViewDetail);
        } else {
            // Datos de Amiibo no encontrados en el intent
        }
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
