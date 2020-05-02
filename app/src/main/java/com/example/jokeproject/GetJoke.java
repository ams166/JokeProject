package com.example.jokeproject;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;




import androidx.appcompat.app.AppCompatActivity;

public class GetJoke extends AppCompatActivity {
    private JSONObject theJoke;
    private String funnyBit;
    private int status;
    private String id;
    public JSONObject getTheJoke() {

        final TextView textView = (TextView) findViewById((R.id.text));
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://icanhazdadjoke.com/";
        JsonObjectRequest jokeRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                textView.setText("Response: " + response.toString());
                JSONObject json = new JSONObject();
                json = response;
                theJoke = json;



                theJoke = response;

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                theJoke = null;
                // need to handle this
            }

        });
        queue.add(jokeRequest);

        try {
            funnyBit = (String) theJoke.get("joke");
            status = (Integer) theJoke.get("status");
            id = (String) theJoke.get("id");
            return theJoke;
        } catch (Exception e){
            System.out.println("error occured getting joke check getTheJoke");
            return null;
        }


    }
    public String getFunnyBit() {
        return funnyBit;
    }
    public int getStatus() {
        return status;
    }
    public String getId() {
        return id;
    }




}
