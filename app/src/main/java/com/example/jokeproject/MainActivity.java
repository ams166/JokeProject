package com.example.jokeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * when this launches, a new joke will automatically be generated to fill the top part of the screen
 */
public class MainActivity extends AppCompatActivity {
    //"Add" button should initially be invisible
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button addToListButton = findViewById(R.id.addToList);
        addToListButton.setVisibility(View.INVISIBLE);
        //Add code to get a new joke immediately when launched
        //This code is for when a user gets a new joke
        Button getNewJoke = findViewById(R.id.getNewJoke);
        getNewJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add code to get a new joke immediately
            }
        });

        //This code is for when a user wants to add the joke to a good/bad list
        final RadioGroup categorizeJokeGroup = findViewById(R.id.categorizeJoke);
        RadioButton addToSad = findViewById(R.id.addToSadLad);
        RadioButton addToRad = findViewById(R.id.addToRadDad);
        categorizeJokeGroup.setOnCheckedChangeListener((unused, checkedId) -> {
            if (checkedId == addToRad.getId()) {
                addToListButton.setVisibility(View.VISIBLE);
            }
            if (checkedId == addToSad.getId()) {
                addToListButton.setVisibility(View.VISIBLE);
            }
            // checkedId is the R.id constant of the currently checked RadioButton
        });
        addToListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add code for adding current joke to a list
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
                //Intent intent = new Intent(MainActivity.this, ListActivity.class);
                //intent.putExtra("type", "rad");
                //startActivity(intent);
            }
        });
        goToSadList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to switch to ListActivity
                //Intent intent = new Intent(MainActivity.this, ListActivity.class);
                //intent.putExtra("type", "sad");
                //startActivity(intent);
            }
        });
    }
}
