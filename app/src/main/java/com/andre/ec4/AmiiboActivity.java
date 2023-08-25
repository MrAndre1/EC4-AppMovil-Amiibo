package com.andre.ec4;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andre.ec4.adapter.AmiiboAdapter;
import com.andre.ec4.interfaz.AmiiboApiService;
import com.andre.ec4.interfaz.AmiiboResponse;
import com.andre.ec4.model.Amiibo;
import com.andre.ec4.retrofit.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AmiiboActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AmiiboAdapter amiiboAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amiibo);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit application = (Retrofit) getApplication();
        AmiiboApiService apiService = application.getApiService();

        Call<AmiiboResponse> call = apiService.getAmiibos();
        call.enqueue(new Callback<AmiiboResponse>() {
            @Override
            public void onResponse(Call<AmiiboResponse> call, Response<AmiiboResponse> response) {
                if (response.isSuccessful()) {
                    List<Amiibo> amiibos = response.body().getAmiibo();
                    amiiboAdapter = new AmiiboAdapter(amiibos, AmiiboActivity.this);
                    recyclerView.setAdapter(amiiboAdapter);
                } else {
                    // Manejo de errores
                }
            }

            @Override
            public void onFailure(Call<AmiiboResponse> call, Throwable t) {
                // Manejo de errores de conexión
            }
        });
        toolbar.inflateMenu(R.menu.menu_amiibo_activity);
        MenuItem favoritesMenuItem = toolbar.getMenu().findItem(R.id.action_favorites);
        favoritesMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Lógica para manejar el clic en Favoritos
                // ...
                return true;
            }
        });

        MenuItem logoutMenuItem = toolbar.getMenu().findItem(R.id.action_logout);
        logoutMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Lógica para manejar el clic en Cerrar Sesión
                // ...
                return true;
            }
        });
    }
}
