package com.andre.ec4.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andre.ec4.AmiiboDetailActivity;
import com.andre.ec4.R;
import com.andre.ec4.model.Amiibo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AmiiboAdapter extends RecyclerView.Adapter<AmiiboAdapter.AmiiboViewHolder> {
    private List<Amiibo> amiibos;
    private Context context;
    public AmiiboAdapter(List<Amiibo> amiibos, Context context) {
        this.amiibos = amiibos;
        this.context = context;
    }

    @NonNull
    @Override
    public AmiiboViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_amiibo, parent, false);
        return new AmiiboViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AmiiboViewHolder holder, int position) {
        Amiibo amiibo = amiibos.get(position);
        holder.bind(amiibo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Amiibo clickedAmiibo = new Amiibo(amiibo);

                Intent intent = new Intent(context, AmiiboDetailActivity.class);
                intent.putExtra("amiibo", clickedAmiibo);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return amiibos.size();
    }

    static class AmiiboViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView amiiboSeriesTextView;
        private TextView nameTextView;
        private TextView characterTextView;

        public AmiiboViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            amiiboSeriesTextView = itemView.findViewById(R.id.amiiboSeriesTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            characterTextView = itemView.findViewById(R.id.characterTextView);
        }

        public void bind(Amiibo amiibo) {
            amiiboSeriesTextView.setText(amiibo.getAmiiboSeries());
            nameTextView.setText(amiibo.getName());
            characterTextView.setText(amiibo.getCharacter());
            Picasso.get().load(amiibo.getImage()).into(imageView);
        }
    }
}
