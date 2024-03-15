package com.example.pokemos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetallePokemon extends AppCompatActivity {
    String name;
    TextView name_po;
    TextView altura_t;
    TextView peso_t;
    RecyclerView cardImagenes;
    RecyclerView cardInformacion;
    String url_recibo;

    List<Habilidades> listFoto = new ArrayList<>();
    List<InfoHabilidades> listaInfo = new ArrayList<>();
    AdaptadorDetalle adaptador = new AdaptadorDetalle(listFoto);
    AdaptadorInfoHabilidad adaptador_info = new AdaptadorInfoHabilidad(listaInfo);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pokemon);

        cardImagenes = findViewById(R.id.cardImagenes);
        cardInformacion = findViewById(R.id.cardInfo);
        altura_t = findViewById(R.id.altura);
        peso_t = findViewById(R.id.peso);



        name_po = findViewById(R.id.name);

        Bundle datos = getIntent().getExtras();
        name = datos.getString("name");
        url_recibo = datos.getString("url");

        System.out.println("url " + url_recibo);

        name_po.setText(name);
        cargarDatos(url_recibo);
    }
    private void cargarDatos(String url_recibida) {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = url_recibida;

        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println("el server responde ok");
                        try {
                            Integer altura = Integer.valueOf(response.getString("height"));
                            Integer peso = Integer.valueOf(response.getString("weight"));

                            altura_t.setText(altura.toString());
                            peso_t.setText(peso.toString());

                            cargarFotos(response);
                            cargarInfo(response);

                        }catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        queue.add(solicitud);
    }
    public void cargarFotos(JSONObject datos){
        try {
            /*JSONArray abilities = datos.getJSONArray("abilities");*/
            JSONObject sprities = datos.getJSONObject("sprites");
            this.listFoto.add(new Habilidades(sprities.getString("back_default")));
            this.listFoto.add(new Habilidades(sprities.getString("back_shiny")));
            this.listFoto.add(new Habilidades(sprities.getString("front_default")));
            this.listFoto.add(new Habilidades(sprities.getString("front_shiny")));




             this.adaptador = new AdaptadorDetalle(this.listFoto);
                cardImagenes.setAdapter(adaptador);
                cardImagenes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                cardImagenes.setLayoutManager(layoutManager);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void cargarInfo(JSONObject datos){
        try {
            /*JSONArray abilities = datos.getJSONArray("abilities");*/
            JSONArray abilities_p = datos.getJSONArray("abilities");
            for (int i = 0; i < abilities_p.length(); i++) {
                JSONObject pokemon = abilities_p.getJSONObject(i);
                JSONObject info = pokemon.getJSONObject("ability");
                String name = info.getString("name");

                this.listaInfo.add(new InfoHabilidades(name));
            }

            this.adaptador_info = new AdaptadorInfoHabilidad(this.listaInfo);
            cardInformacion.setAdapter(adaptador_info);
            cardInformacion.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            //LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            //cardInformacion.setLayoutManager(layoutManager);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}