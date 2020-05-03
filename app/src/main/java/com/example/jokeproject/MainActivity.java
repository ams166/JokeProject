package com.example.jokeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * when this launches, a new joke will automatically be generated to fill the top part of the screen
 */
public class MainActivity extends AppCompatActivity {
    //request queue for api
    private RequestQueue queue;

    //currentJoke
    private String currentJoke;

    //variable being weird
    private int checkedRadioButton;
    //"Add" button should initially be invisible
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize queue for this activity
        queue = Volley.newRequestQueue(this);

        //Make "add to list" button invisible
        final Button addToListButton = findViewById(R.id.addToList);
        addToListButton.setVisibility(View.INVISIBLE);

        //the GetJoke class to work with the whole time
        GetJoke jokesFunctionality = new GetJoke();

        //Add code to get a new joke immediately when launched
        this.getTheJoke();
        TextView mainJokeText = (TextView) findViewById(R.id.jokeText);
        mainJokeText.setText(currentJoke);
        //This code is for when a user gets a new joke
        Button getNewJoke = findViewById(R.id.getNewJoke);
        getNewJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add code to ge a new joke immediately
                getTheJoke();
                TextView mainJokeText = (TextView) findViewById(R.id.jokeText);
                mainJokeText.setText(currentJoke);
            }
        });

        //This code is for when a user wants to add the joke to a good/bad list
        final RadioGroup categorizeJokeGroup = findViewById(R.id.categorizeJoke);
        RadioButton addToSad = findViewById(R.id.addToSadLad);
        RadioButton addToRad = findViewById(R.id.addToRadDad);
        categorizeJokeGroup.setOnCheckedChangeListener((unused, checkedId) -> {
            if (checkedId == addToRad.getId()) {
                addToListButton.setVisibility(View.VISIBLE);
                checkedRadioButton = checkedId;
            }
            if (checkedId == addToSad.getId()) {
                addToListButton.setVisibility(View.VISIBLE);
                checkedRadioButton = checkedId;
            }
            // checkedId is the R.id constant of the currently checked RadioButton
        });
        addToListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add code for adding current joke to a list (Done?)
                if (checkedRadioButton == addToRad.getId()) {
                    jokesFunctionality.addToRad(currentJoke);
                }
                if (checkedRadioButton == addToSad.getId()) {
                    jokesFunctionality.addToSad(currentJoke);
                }
                //make itself invisible
                addToListButton.setVisibility(View.INVISIBLE);
            }
        });

        //this code is for when the user wants to see a list of the good or bad jokes
        Button goToRadList = findViewById(R.id.goToRadDad);
        Button goToSadList = findViewById(R.id.goToSadLad);
        goToRadList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //an intent to switch to ListActivity
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("type", "rad");
                intent.putExtra("joke1", jokesFunctionality.getFromRadList(0));
                intent.putExtra("joke2", jokesFunctionality.getFromRadList(1));
                intent.putExtra("joke3", jokesFunctionality.getFromRadList(2));
                intent.putExtra("joke4", jokesFunctionality.getFromRadList(3));
                intent.putExtra("joke5", jokesFunctionality.getFromRadList(4));
                startActivity(intent);
            }
        });
        goToSadList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to switch to ListActivity
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("type", "sad");
                intent.putExtra("joke1", jokesFunctionality.getFromSadList(0));
                intent.putExtra("joke2", jokesFunctionality.getFromSadList(1));
                intent.putExtra("joke3", jokesFunctionality.getFromSadList(2));
                intent.putExtra("joke4", jokesFunctionality.getFromSadList(3));
                intent.putExtra("joke5", jokesFunctionality.getFromSadList(4));
                startActivity(intent);
            }
        });
    }
    //sets currentJoke to a new joke
    public void getTheJoke() {
        String url = "https://icanhazdadjoke.com/";
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,url,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    currentJoke = response.getString("joke");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {

            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
        };
        queue.add(req);
    }
}
