package com.example.jokeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * when this launches, a new joke will automatically be generated.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
