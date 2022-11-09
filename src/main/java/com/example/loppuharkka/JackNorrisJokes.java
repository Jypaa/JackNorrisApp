package com.example.loppuharkka;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

public class JackNorrisJokes extends AppCompatActivity {
    private String joke1;
    private String mUrl = "https://api.chucknorris.io/jokes/random";
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jacknorrisjokes);
        mQueue = Volley.newRequestQueue(this);

        if(savedInstanceState != null){
            joke1 = savedInstanceState.getString("joke");
            TextView Joke = findViewById(R.id.NimiView);
            Joke.setText(joke1);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("joke" ,joke1);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    public void fetchJOke(View view) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, mUrl, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                        parseJsonAndUpdateUI(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        TextView Joke = (TextView) findViewById(R.id.NimiView);
                        Joke.setText(R.string.epäonnistuminen);
                    }
                });
        mQueue.add(jsonObjectRequest);

    }
    public void parseJsonAndUpdateUI(JSONObject jokeObject){

        TextView Joke = (TextView) findViewById(R.id.NimiView);
        try {
            String joke = jokeObject.getString("value");
            Joke.setText( joke );
            joke1 = joke;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
