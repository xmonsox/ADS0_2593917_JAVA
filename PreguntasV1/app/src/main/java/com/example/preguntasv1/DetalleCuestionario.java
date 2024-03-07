package com.example.preguntasv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
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

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DetalleCuestionario extends AppCompatActivity {
    TextView mostrar_nombre;
    LinearLayout linearResumen;
    LinearLayout linearPreguntas;
    Config config;
    String id_usuario;
    Integer conteo_correctas = 0;
    Integer conteo_incorrectas = 0;
    TextView preguntas;
    TextView correctas;
    TextView incorrectas;
    Integer variable;
    String id_cuestionario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cuestionario);
        config = new Config(getApplicationContext());
        linearResumen = findViewById(R.id.linearResumen);
        linearPreguntas = findViewById(R.id.linearPreguntas);


        SharedPreferences archivo = getSharedPreferences("app-preguntas", MODE_PRIVATE);
        id_usuario = archivo.getString("id_usuario", null);

        Bundle datos = getIntent().getExtras();
        id_cuestionario = datos.getString("id");

        mostrar_nombre= findViewById(R.id.mostrar_nombre);
        mostrar_nombre.setText(archivo.getString("nombres", ""));

        Date fecha_actual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
        String fechaFormateada = sdf.format(fecha_actual);

        TextView fecha_inicio = new TextView(getApplicationContext());
        fecha_inicio.setText("Fecha Inicio: " + fechaFormateada);
        fecha_inicio.setTextColor(Color.parseColor("#000000"));
        linearResumen.addView(fecha_inicio);

        ExtraerDetalleCuestionario();
    }
    public void ExtraerDetalleCuestionario(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = config.getEndpoint("API-Preguntas/getDetalleCuestionario.php?id_cuestionario="+id_cuestionario);
        JsonObjectRequest solicitud =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println(response.toString());


                getDetalleCuestionarios(response);
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
    public void getDetalleCuestionarios(JSONObject data){
        try {
            JSONArray arreglo = data.getJSONArray("respuesta");

            //etq_clients.setText("");
            for (int i=0;i<arreglo.length();i++){

                JSONObject detalleCues = arreglo.getJSONObject(i);
                JSONObject pregunt = detalleCues.getJSONObject("pregunta");
                JSONArray opci = detalleCues.optJSONArray("opciones");


                String id =  pregunt.getString("id");
                String descripcion =  pregunt.getString("descripcion");
                String status = pregunt.getString("estado");
                String respuest = pregunt.getString("respuesta");


                //System.out.println("Estado : "+status);
                //System.out.println("Respuesta "+respuest);

                CardView cardView = new CardView(getApplicationContext());
                LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                cardParams.setMargins(0, 0, 0, 16); // Aumentar el margen inferior para separación entre tarjetas
                cardView.setLayoutParams(cardParams);
                cardView.setCardBackgroundColor(getResources().getColor(android.R.color.white)); // Color de fondo
                cardView.setRadius(8); // Radio de las esquinas
                cardView.setCardElevation(20); // Elevación

                LinearLayout innerLayout = new LinearLayout(getApplicationContext());
                innerLayout.setOrientation(LinearLayout.VERTICAL);
                innerLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                innerLayout.setPadding(16, 16, 16, 16);


                variable = arreglo.length();
                preguntas = new TextView(getApplicationContext());
                correctas = new TextView(getApplicationContext());
                incorrectas = new TextView(getApplicationContext());
                TextView preguntas_opciones = new TextView(getApplicationContext());


                preguntas.setTextColor(Color.rgb(0,0,0));
                preguntas_opciones.setTextColor(Color.rgb(0, 0, 0));
                preguntas_opciones.setTextSize(18); // Tamaño del texto de la pregunta
                preguntas_opciones.setText("Pregunta: " + i + "\n" + descripcion + "\n");


                //System.out.println( id +" "+descripcion);


                innerLayout.addView(preguntas_opciones);


                for (int j = 0; j < opci.length() ; j++) {
                    JSONObject obje = opci.getJSONObject(j);
                    String descr =  obje.getString("descripcion");

                    //String id_op = obje.getString("id");

                    TextView opci_1 = new TextView(getApplicationContext());
                    opci_1.setTextColor(Color.rgb(0, 0, 0));
                    opci_1.setText("- " + descr);
                    opci_1.setTextSize(15); // Tamaño del texto de la opción
                    opci_1.setTypeface(null, Typeface.ITALIC); // Establecer estilo de letra
                    opci_1.setPadding(0, 0, 0, 8); // Agregar un pequeño espacio inferior entre las opciones


                    System.out.println("Descr " + descr + " " + respuest);

                    if (status.equalsIgnoreCase("OK") && descr.equalsIgnoreCase(respuest)){

                        opci_1.setTextColor(Color.rgb(0,255,0));
                        correctas.setTextColor(Color.BLACK);
                        conteo_correctas +=1;

                        //System.out.println("Entre a verde "+ respuest);

                    } else if (status.equalsIgnoreCase("ERROR") && descr.equalsIgnoreCase(respuest)) {

                        opci_1.setTextColor(Color.rgb(255,0,0));
                        incorrectas.setTextColor(Color.rgb(255,0,0));
                        conteo_incorrectas+=1;

                        //System.out.println("Entre a rojo "+ respuest);

                    }

                    innerLayout.addView(opci_1);
                }
                cardView.addView(innerLayout);
                linearPreguntas.addView(cardView);
            }
            preguntas.append("Preguntas: "  + variable);
            correctas.append("Correctas: "  + conteo_correctas);
            incorrectas.append("Incorrectas: " + conteo_incorrectas);

            linearResumen.addView(preguntas);
            linearResumen.addView(correctas);
            linearResumen.addView(incorrectas);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public void backView(View vista){
        Intent intencion = new Intent(getApplicationContext(), Resumen.class);
        startActivity(intencion);
        finish();
    }
}