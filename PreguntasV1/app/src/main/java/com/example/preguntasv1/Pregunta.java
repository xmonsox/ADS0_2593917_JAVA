package com.example.preguntasv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.preguntasv1.utils.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Pregunta extends AppCompatActivity {
    Config config;
    String id_usuario;
    String names;
    String id_cuest;
    String desc;
    String estado;
    String fecha_inicio;
    String id_pregunta;
    String descripcion_opcion;
    LinearLayout linearDatos;
    TextView pregunt;
    Integer indice = 0;
    Integer contador = 1;
    Random rand = new Random();
    Integer respuestaSeleccionada = -1;
    Integer [] arreglo = new Integer[10];
    LinearLayout linearPregunt;
    TextView nombre_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        nombre_user = findViewById(R.id.nombre_user);
        linearDatos = findViewById(R.id.linearDatos);
        linearPregunt = findViewById(R.id.linearPregunt);
        pregunt = findViewById(R.id.pregunt);

        config = new Config(getApplicationContext());

        mostrarPreguntas(rand.nextInt(10) + 1);



        Bundle datos = getIntent().getExtras();
        id_usuario = datos.getString("id_user");
        names = datos.getString("name");

        //System.out.println("id " + id_usuario);
        nombre_user.setText(names);


        read();
    }
    public void read(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = config.getEndpoint("API-Preguntas/getFechaInicio.php?id_usuario="+id_usuario);
        JsonObjectRequest solicitud =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println(response.toString());

                getFechaInicio(response);
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
    public void getFechaInicio(JSONObject data){
        try {
            JSONObject datosCuestionario = data.getJSONObject("datos_cuestionario");
            String id_usuario = datosCuestionario.getString("id_usuario");
            fecha_inicio = datosCuestionario.getString("fecha_inicio");
            id_cuest = datosCuestionario.getString("id");

            System.out.println("id_usuario: " + id_usuario);
            System.out.println("fecha_inicio: " + fecha_inicio);
            System.out.println("id_cuest " +  id_cuest );

            TextView fecha_i = new TextView(getApplicationContext());
            fecha_i.setText("Fecha Inicio: " + fecha_inicio);
            fecha_i.setTextColor(Color.rgb(0, 0, 0));
            fecha_i.setTextSize(20); // Tamaño del texto de la pregunta*/
            linearDatos.addView(fecha_i);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public void generarRandom(View vista) {
        // Verificar si el arreglo aún no ha alcanzado una longitud de 10
        if (indice < 10) {
            for (int i = 0; i < arreglo.length; i++) {
                Integer id_aleatorio = rand.nextInt(10) + 1;
                boolean validar_id = true;
                for (int j = 0; j < arreglo.length; j++) {
                    System.out.println("id2 " + arreglo[j]);
                    if (id_aleatorio == arreglo[j]) {
                        validar_id = false;
                    }
                }
                if (validar_id) {
                    // Agregar el id_aleatorio al arreglo y aumentar el índice
                    mostrarPreguntas(id_aleatorio);
                    break;
                }
            }
        } else {
            System.out.println("El arreglo ya ha alcanzado una longitud de 10.");
            Intent intencion = new Intent(getApplicationContext(), Resumen.class);
            startActivity(intencion);
            // Aquí puedes manejar la situación en la que el arreglo ya tiene una longitud de 10
        }
        TextView cantP = new TextView(getApplicationContext());
        cantP.setText("Pregunta Actual: " + contador++);
        linearDatos.addView(cantP);
    }

    public void mostrarPreguntas(Integer numero){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = config.getEndpoint("API-Preguntas/getOtherCuestionario.php?id_pregunta="+ numero);
        JsonObjectRequest solicitud =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println(response.toString());
                arreglo[indice] = numero;
                indice++;
                getPreguntas(response);


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
    public void getPreguntas(JSONObject data) {
        //System.out.println("data " + data);
        try {
            JSONObject respuesta = data.getJSONObject("respuesta");
            JSONObject datosPregunta = respuesta.getJSONObject("pregunta");

            JSONArray opci = respuesta.optJSONArray("opciones");

            String descr = datosPregunta.getString("descripcion");
            id_pregunta = datosPregunta.getString("id");
            String id_correcta = datosPregunta.getString("id_correcta");
            String url = datosPregunta.getString("url_imagen");

            pregunt.setText(descr);

            RadioGroup radioGroup = findViewById(R.id.radio);
            radioGroup.removeAllViews();

            // Establecer el listener para detectar la respuesta seleccionada por el usuario
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    // Guardar el ID de la respuesta seleccionada
                    respuestaSeleccionada = checkedId;

                    System.out.println("respuesta seleccionada " + respuestaSeleccionada);

                    // Comparar la respuesta seleccionada por el usuario con el ID correcto
                    if (respuestaSeleccionada != -1 && respuestaSeleccionada == Integer.parseInt(id_correcta)) {
                        // La respuesta seleccionada por el usuario es correcta
                        // Realiza las acciones correspondientes

                        estado = "OK";
                        ExtraerDescripcion();

                        System.out.println("Respuesta correcta");
                    } else {
                        // La respuesta seleccionada por el usuario es incorrecta o no se ha seleccionado ninguna respuesta
                        // Realiza las acciones correspondientes
                        estado = "ERROR";
                        ExtraerDescripcion();
                        System.out.println("Respuesta incorrecta");
                    }
                }
            });

            for (int j = 0; j < opci.length(); j++) {
                JSONObject obje = opci.getJSONObject(j);

                descripcion_opcion = obje.getString("descripcion");
                String id_opcion = obje.getString("id");

                RadioButton radioButton = new RadioButton(getApplicationContext());
                radioButton.setId(Integer.parseInt(id_opcion)); // Establecer un ID para el RadioButton

                radioButton.setText(descripcion_opcion);
                radioButton.setTextColor(Color.rgb(0, 0, 0));
                radioButton.setTextSize(15);
                radioButton.setTypeface(null, Typeface.ITALIC);
                radioButton.setPadding(0, 0, 0, 8);

                // Agregar el RadioButton al RadioGroup
                radioGroup.addView(radioButton);

                // Seleccionar el primer RadioButton
                /*if (j == 0) {
                    radioButton.setChecked(true);
                    // Inicializar la respuesta seleccionada con la primera opción por defecto

                }*/
            }

            System.out.println("Pregunta " + descr);
            System.out.println("Id_pregunta " + id_pregunta);
            System.out.println("id_correcta " + id_correcta);
            System.out.println("Url " + url);



        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }



    public void ExtraerDescripcion(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = config.getEndpoint("API-Preguntas/getDescripcionRespuesta.php?id=" + respuestaSeleccionada);
        JsonObjectRequest solicitud =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println(response.toString());

                getDescResp(response);
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

    public void getDescResp(JSONObject data){
        try {
            JSONObject arreglo = data.getJSONObject("descripcion");

            desc = arreglo.getString("descripcion");

            System.out.println("Descripcion " + desc);
            insertRespuesta();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertRespuesta(){
        System.out.println("Dato a enviar" + desc);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = config.getEndpoint("API-Preguntas/InsertRespuestaCuest.php");
        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK");
                    JSONObject jsonObject = new JSONObject(response);
                    System.out.println("Este soy yo" + response);
                } catch (JSONException e) {
                    System.out.println("El servidor POST responde con un error:");
                    System.out.println(e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor POST responde con un error:");
                System.out.println(error.getMessage());
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                //params.put("id_respuesta", respuestaSeleccionada.toString());
                params.put("id_cuestionario", id_cuest.toString());
                params.put("id_pregunta", id_pregunta.toString());
                params.put("respuesta", desc);
                params.put("estado", estado);
                params.put("fecha", fecha_inicio);

                return params;
            }
        };
        queue.add(solicitud);

    }
}