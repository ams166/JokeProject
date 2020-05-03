package com.example.jokeproject;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;




import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class GetJoke extends AppCompatActivity {
    //array of jokes for Rad Dad Joke List
    private String[] radJokes = new String[] {"", "", "", "", ""};
    //index of last radJokes added
    private int indexOfLastRad = -1;
    //array of jokes for Sad Lad Joke List
    private String[] sadJokes = new String[] {"", "", "", "", ""};
    //index of last sadJokes added
    private int indexOfLastSad = -1;
    /**
    private JSONObject theJoke;
    private String funnyBit;
    private int status;
    private String id;
    public JSONObject getTheJoke() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://icanhazdadjoke.com/";
        JsonObjectRequest jokeRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject json;
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
     **/

    /**
     *
     * @param toAdd Joke to add to List
     */
    public void addToRad(String toAdd) {

        if (toAdd == null) {
            return;
        }
        if (indexOfLastRad <= 3) {
            indexOfLastRad++;
            radJokes[indexOfLastRad] = toAdd;
            return;
        }
        indexOfLastRad = (indexOfLastRad + 1) % 5;
        radJokes[indexOfLastRad] = toAdd;
        return;
    }

    public void addToSad(String toAdd) {

        if (toAdd == null) {
            return;
        }
        if (indexOfLastSad <= 3) {
            indexOfLastSad++;
            radJokes[indexOfLastSad] = toAdd;
            return;
        }
        indexOfLastSad = (indexOfLastSad + 1) % 5;
        sadJokes[indexOfLastSad] = toAdd;
        return;
    }

    public String getFromRadList(int index) {
        return radJokes[index];
    }

    public String getFromSadList(int index) {
        return sadJokes[index];
    }

}
