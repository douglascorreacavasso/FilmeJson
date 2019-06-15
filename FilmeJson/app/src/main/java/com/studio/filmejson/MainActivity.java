package com.studio.filmejson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by opet on 25/05/2019.
 *  Autores : Douglas / Emy
 */


public class MainActivity extends AppCompatActivity {

    private TextView json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        json = findViewById(R.id.jsonText);
    }

    public void downloadJson(View view){

        // Instanciando o RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://my-json-server.typicode.com/mustafahamandosh/JsonMovieFile/Movie";


        // Solicitando uma resposta de string do URL fornecido.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    json.setText(response);
                }},
                new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    json.setText("That didn't work!");

                }}
                );
        // Adicione o pedido ao RequestQueue.
        requestQueue.add(stringRequest);
    }

    public void downloadGson(View view){

        GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://my-json-server.typicode.com/mustafahamandosh/JsonMovieFile/Movie";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Movie movie  = gson.fromJson(response, Movie.class);
                json.setText(movie.toString());
            }},
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                json.setText("That didn't work!");
            }
        });

        requestQueue.add(stringRequest);
    }
}
