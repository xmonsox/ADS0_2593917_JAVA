package com.example.pokemos;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorNombres extends RecyclerView.Adapter<AdaptadorNombres.ViewHolder> {

    private List<String> nombresPokemon;
    private List<String> urlPokemon;
    private List<String> contador;
    private Context contexto;

    public AdaptadorNombres(Context contexto) {
        this.contexto = contexto;
        this.nombresPokemon = new ArrayList<>(); //Inicializo la lista de nombres de los pokemones
        this.urlPokemon = new ArrayList<>(); // Inicialice la lista
        this.contador = new ArrayList<>();
    }

    //Metodo para agregar un nuevo nombre al adaptador
    public void agregarNombrePokemon(String numero,String nombre, String url) {
        nombresPokemon.add(nombre); //lo agrego a la lista
        urlPokemon.add(url);
        contador.add(numero);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nombres, parent, false);
        return new ViewHolder(vista);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String nombrePokemon = nombresPokemon.get(position);
        String contN = contador.get(position);
        System.out.println("Yo" + contN);
        holder.name_pokemon.setText(nombrePokemon);
        holder.numeroC.setText(contN);

        // Set click listener on ImageView (assuming it's present in item_nombres.xml)
        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombresPokemon.get(position);
                String url = urlPokemon.get(position); // Access corresponding URL

                Intent intencion = new Intent(contexto, DetallePokemon.class);
                intencion.putExtra("name", nombre);
                intencion.putExtra("url", url);
                contexto.startActivity(intencion); // Start activity using context

                Toast.makeText(contexto, "Se hizo clic en " + nombre, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return nombresPokemon.size();
    }

    public void clear() {
        nombresPokemon.clear();
        urlPokemon.clear();
        contador.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name_pokemon;
        ImageView imagen;
        TextView numeroC;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_pokemon = itemView.findViewById(R.id.name_pokemon);
            numeroC = itemView.findViewById(R.id.cont);
            imagen = itemView.findViewById(R.id.imagen);
        }
    }
}
