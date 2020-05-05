package com.example.jokeproject;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GetJoke extends AppCompatActivity {
    //list of rad jokes
    private List<String> radJokes = new ArrayList<>();
    //list of sad jokes
    private List<String> sadJokes = new ArrayList<>();

    GetJoke() {
        for (int i = 0; i < 5; i++) {
            radJokes.add(0, " ");
            sadJokes.add(0, " ");
        }
    }
    public void addToRad(String toAdd) {
        if (toAdd == null) {
            radJokes.add(0, " ");
        }
        radJokes.add(0, toAdd);
    }

    public String getFromRadList(int index) {
        if (index < 0 || index >= 5) {
            return " ";
        }
        return radJokes.get(index);
    }

    public void addToSad(String toAdd) {
        if (toAdd == null) {
            sadJokes.add(0, " ");
        }
        sadJokes.add(0, toAdd);
    }

    public String getFromSadList(int index) {
        if (index < 0 || index >= 5) {
            return " ";
        }
        return sadJokes.get(index);
    }
}
