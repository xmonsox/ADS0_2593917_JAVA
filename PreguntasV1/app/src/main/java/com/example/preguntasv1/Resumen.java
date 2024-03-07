package com.example.preguntasv1;

import static android.view.ViewGroup.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.preguntasv1.utils.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Resumen extends AppCompatActivity {

    TextView user;
    TextView nombresitos;
    Config config;
    LinearLayout linear;
    String id_usuario;
    String names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        config = new Config(getApplicationContext());
        nombresitos = findViewById(R.id.text_name);

        SharedPreferences archivo = getSharedPreferences("app-preguntas", MODE_PRIVATE);
        id_usuario = archivo.getString("id_usuario", null);
        names = archivo.getString("nombres", null);
        linear = findViewById(R.id.linearview);
       nombresitos.setText(archivo.getString("nombres", ""));
       read();
    }
    public void read(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = config.getEndpoint("API-Preguntas/getCuestionarios.php?id_usuario="+id_usuario);
        JsonObjectRequest solicitud =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println(response.toString());

                getCuestionarios(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor responde con un error:");
                System.out.println(error.getMessage());
            }
        });

        queue.add(solicitud);
    }
    public void getCuestionarios(JSONObject data){
        try {
            JSONArray arreglo = data.getJSONArray("cuestionarios");
            //etq_clients.setText("");
            for (int i = 0; i < arreglo.length(); i++) {
                JSONObject cuest = arreglo.getJSONObject(i);
                String id = cuest.getString("id");
                String fecha_inicio = cuest.getString("fecha_inicio");
                String num_preguntas = cuest.getString("cant_preguntas");
                String num_ok = cuest.getString("cant_ok");
                String num_error = cuest.getString("cant_error");

                // Crear la CardView
                CardView cardView = new CardView(getApplicationContext());
                LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                cardParams.setMargins(0, 0, 0, 32); // Aumentar el margen inferior para separación
                cardView.setLayoutParams(cardParams);
                cardView.setCardBackgroundColor(getResources().getColor(android.R.color.white)); // Color de fondo
                cardView.setRadius(8); // Radio de las esquinas
                cardView.setCardElevation(20); // Elevación

                // Crear el LinearLayout interno para el contenido de la tarjeta
                LinearLayout innerLayout = new LinearLayout(getApplicationContext());
                innerLayout.setOrientation(LinearLayout.VERTICAL);
                innerLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                innerLayout.setPadding(16, 16, 16, 16);

                // Crear el TextView dentro de la CardView
                TextView tarjeta = new TextView(getApplicationContext());
                tarjeta.setTextColor(Color.rgb(0, 0, 0));
                //tarjeta.setBackgroundResource(R.drawable.border);
                tarjeta.setPadding(16, 16, 16, 16);
                tarjeta.setText("Número: " + id + "\n" + " Fecha Inicio: " + fecha_inicio + "\n" + " N° Preguntas " + num_preguntas + "\n" + " N° OK: " + num_ok + "\n" + "N° Error: " + num_error);

                // Crear el Button dentro de la CardView
                Button detalle = new Button(getApplicationContext());
                detalle.setText("Detalles");
                //detalle.setBackgroundColor(getColor(R.color.morado_claro));
                detalle.setBackgroundColor(Color.parseColor("#BA68C8"));
                LinearLayout.LayoutParams detalleParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                detalleParams.gravity = Gravity.CENTER;
                detalle.setLayoutParams(detalleParams);

                detalle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intencion = new Intent(getApplicationContext(), DetalleCuestionario.class);
                        intencion.putExtra("id", id);
                        startActivity(intencion);
                    }
                });

                // Agregar el TextView y el Button al LinearLayout interno
                innerLayout.addView(tarjeta);
                innerLayout.addView(detalle);

                // Agregar el LinearLayout interno a la CardView
                cardView.addView(innerLayout);

                // Agregar la CardView al LinearLayout contenedor
                linear.addView(cardView);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void cerrarSesion(View vista){
        SharedPreferences archivo = getSharedPreferences("app-preguntas", MODE_PRIVATE);
        SharedPreferences.Editor editor = archivo.edit();

        editor.clear();
        editor.clear();

        editor.commit();
        Intent intencion = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intencion);
        finish();
    }
    public void newCuestionario(View vista){
        //abriendo el archivo de persistencia y almacenar datos de usuario
        SharedPreferences archivo = getSharedPreferences("app-preguntas", MODE_PRIVATE);

        SharedPreferences.Editor editor = archivo.edit();

        editor.putString("id_usuario", id_usuario);
        editor.putString("nombres", names);

        editor.commit();


        Intent intencion = new Intent(getApplicationContext(), NewCuest.class);
        startActivity(intencion);
        finish();
    }

}