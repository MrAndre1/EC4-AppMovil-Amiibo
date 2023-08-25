package com.andre.ec4.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andre.ec4.R;
import com.andre.ec4.entity.FavoriteAmiibo;

import java.util.List;

public class AmiiboFavoritesAdapter extends RecyclerView.Adapter<AmiiboFavoritesAdapter.ViewHolder> {
    private List<FavoriteAmiibo> favoriteAmiibos;

    public AmiiboFavoritesAdapter(List<FavoriteAmiibo> favoriteAmiibos) {
        this.favoriteAmiibos = favoriteAmiibos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_amiibo_favorite, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FavoriteAmiibo favoriteAmiibo = favoriteAmiibos.get(position);
        holder.bind(favoriteAmiibo);
    }

    @Override
    public int getItemCount() {
        return favoriteAmiibos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewAmiiboSeries;
        private TextView textViewCharacter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewAmiiboSeries = itemView.findViewById(R.id.textViewAmiiboSeries);
            textViewCharacter = itemView.findViewById(R.id.textViewCharacter);
        }

        public void bind(FavoriteAmiibo favoriteAmiibo) {
            textViewName.setText(favoriteAmiibo.getName());
            textViewAmiiboSeries.setText(favoriteAmiibo.getAmiiboSeries());
            textViewCharacter.setText(favoriteAmiibo.getCharacter());
        }
    }
}

