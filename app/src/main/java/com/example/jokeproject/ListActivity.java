package com.example.jokeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String jokeOne = getIntent().getStringExtra("joke1");
        String jokeTwo = getIntent().getStringExtra("joke2");
        String jokeThree = getIntent().getStringExtra("joke3");
        String jokeFour = getIntent().getStringExtra("joke4");
        String jokeFive = getIntent().getStringExtra("joke5");
        TextView listOne = (TextView) findViewById(R.id.jokeList1);
        listOne.setText(jokeOne);
        TextView listTwo = (TextView) findViewById(R.id.jokeList2);
        listTwo.setText(jokeTwo);
        TextView listThree = (TextView) findViewById(R.id.jokeList3);
        listThree.setText(jokeThree);
        TextView listFour = (TextView) findViewById(R.id.jokeList4);
        listFour.setText(jokeFour);
        TextView listFive = (TextView) findViewById(R.id.jokeList5);
        listFive.setText(jokeFive);

    }
}
