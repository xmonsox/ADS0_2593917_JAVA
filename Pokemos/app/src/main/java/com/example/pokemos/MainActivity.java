package com.example.pokemos;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    ImageView loading;
    String previus;
    Button siguiente;
    Button anterior;
    String next;
    int suma = 0;
    int contadorL = 0;

    LinearLayout LinearMayor;
    AdaptadorNombres adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearMayor = findViewById(R.id.LinearMayor);
        recycler = findViewById(R.id.recycler_pokemones);
        siguiente = findViewById(R.id.btnSiguiente);
        anterior = findViewById(R.id.btnAnterior);
        loading = findViewById(R.id.loading_pokemon);
        Glide.with(this)
                .asGif()
                .load(R.drawable.loading_pokeball)
                .into(loading);

        adaptador = new AdaptadorNombres(this);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(this));


        cargarDatos();
    }

    private void cargarDatos() {
        loading.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://pokeapi.co/api/v2/pokemon/?offset="+suma+"&limit=20";

        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        loading.setVisibility(View.GONE);
                        try {
                            previus = response.getString("previous");
                            next = response.getString("next");
                            JSONArray resultados = response.getJSONArray("results");
                            for (int i = 0; i < resultados.length(); i++) {
                                JSONObject pokemon = resultados.getJSONObject(i);
                                String nombre = pokemon.getString("name");
                                String url = pokemon.getString("url");
                                String numero = "00"+(suma+i+1);
                                System.out.println("Url Maurico " + url);


                                adaptador.agregarNombrePokemon(numero,nombre,url);
                            }
                            validar();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.GONE);
                        error.printStackTrace();
                    }
                });

        queue.add(solicitud);
    }
    public void siguiente(View vista){
        adaptador.clear();
        suma += 20; // Incrementar el offset para cargar los siguientes 20 pokémon
        cargarDatos();
        loading.setVisibility(View.VISIBLE);
    }

    public void anterior(View vista){
        if (suma >= 20) { // Verificar que el offset no sea menor que 20 para evitar valores negativos
            suma -= 20; // Decrementar el offset para cargar los 20 pokémon anteriores
            adaptador.clear();
            cargarDatos();
            loading.setVisibility(View.VISIBLE);
        }
    }
    public void validar(){
        if (previus.equalsIgnoreCase("null")){
            anterior.setEnabled(false);
        } else  {
            anterior.setEnabled(true);
        }
        if (next.equalsIgnoreCase("null")){
            siguiente.setEnabled(false);
        } else  {
            siguiente.setEnabled(true);
        }
    }


}