package com.example.pokemos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorInfoHabilidad extends RecyclerView.Adapter< AdaptadorInfoHabilidad.ViewHolder > {

    List<InfoHabilidades> listaInfo;

    public AdaptadorInfoHabilidad(List<InfoHabilidades> listaInfo){
        this.listaInfo = listaInfo;
    }

    @NonNull
    @Override
    public AdaptadorInfoHabilidad.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info_hablidad, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorInfoHabilidad.ViewHolder holder, int position) {
        InfoHabilidades temporal = this.listaInfo.get(position);
        holder.mostrarInfoDatos(temporal);
    }

    @Override
    public int getItemCount() {
        return listaInfo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView info_habilidad ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            info_habilidad = itemView.findViewById(R.id.habilidades);

        }
        public void mostrarInfoDatos(InfoHabilidades datos){
            info_habilidad.setText(datos.getName());
        }


    }

}
