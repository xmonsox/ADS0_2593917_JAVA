package com.example.preguntasv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
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

public class MainActivity extends AppCompatActivity {

    EditText campo_correo;
    EditText campo_contrasenia;
    //LinearLayout linear;
    Config config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //linear = findViewById(R.id.linearview);
        campo_correo = findViewById(R.id.campo_correo);
        campo_contrasenia = findViewById(R.id.campo_contrasenia);
        config = new Config(getApplicationContext());

        validarSesion();
    }

    public void validarIngreso(View view){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = config.getEndpoint("API-Preguntas/validarIngreso.php");
        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK");
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean("status")){
                        String id_usuario = jsonObject.getJSONObject("user").getString("id_usuario");
                        String nombres = jsonObject.getJSONObject("user").getString("nombres");
                        cambiarActivity(id_usuario, nombres);
                    }


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
                params.put("correo", campo_correo.getText().toString());
                params.put("password", campo_contrasenia.getText().toString());

                return params;
            }
        };

        queue.add(solicitud);
    }

    public void cambiarActivity(String id_usuario, String nombres) {
        //abriendo el archivo de persistencia y almacenar datos de usuario
        SharedPreferences archivo = getSharedPreferences("app-preguntas", MODE_PRIVATE);

        SharedPreferences.Editor editor = archivo.edit();

        editor.putString("id_usuario", id_usuario);
        editor.putString("nombres", nombres);

        editor.commit();


        Intent intencion = new Intent(getApplicationContext(), Resumen.class);
        startActivity(intencion);
        finish();
    }

    public void validarSesion(){
        SharedPreferences archivo = getSharedPreferences("app-preguntas", MODE_PRIVATE);
        String id_user = archivo.getString("id_usuario", null);
        String names = archivo.getString("nombres", null);

        if(id_user != null && names != null){
            Intent intencion = new Intent(getApplicationContext(), Resumen.class);
            startActivity(intencion);
            finish();
        }
    }
}