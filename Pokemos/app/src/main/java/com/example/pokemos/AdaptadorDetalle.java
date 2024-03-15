package com.example.pokemos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorDetalle extends RecyclerView.Adapter< AdaptadorDetalle.ViewHolder > {

    List<Habilidades> listaFoto;

    public AdaptadorDetalle(List<Habilidades> lista){
        this.listaFoto = lista;
    }

    @NonNull
    @Override
    public AdaptadorDetalle.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imagenes_pokemon, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDetalle.ViewHolder holder, int position) {
        Habilidades temporal = this.listaFoto.get(position);
        holder.mostrarDatos(temporal);
    }

    @Override
    public int getItemCount() {
        return listaFoto.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageList);

        }
        public void mostrarDatos(Habilidades datos){
            Picasso.get()
                    .load(datos.getUrlPokemon())
                    .resize(700, 700)  // Ajusta el tamaño de la imagen
                    .centerCrop()  // Realiza un recorte centrado si es necesario
                    .into(img);

        }


    }

}
