package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class MainView extends AppCompatActivity {
    private String heading, body;
    TextView tvResult;
    private final String apikey = "60d5e3c29b1815f4de7fb85449a3cc8e";
    private final String apicall = "https://api.openweathermap.org/data/2.5/weather?lat=49.94155350960486&lon=-119.39562100901018&appid=" + apikey;
    DecimalFormat df = new DecimalFormat("#.##");
    DB_Helper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageButton settingsButton, nourish, grill, chef, dessert;
        super.onCreate(savedInstanceState);
        DB = new DB_Helper(this);
        setContentView(R.layout.activity_main_view);
        TextView titleView = (TextView) findViewById(R.id.textView);
        settingsButton = (ImageButton) findViewById(R.id.imageButton5);
        nourish = (ImageButton) findViewById(R.id.Settings);
        grill = (ImageButton) findViewById(R.id.imageButton0);
        chef = (ImageButton) findViewById(R.id.imageButton3);
        dessert = (ImageButton) findViewById(R.id.imagebutton);
        RatingBar stars = (RatingBar) findViewById(R.id.ratingBar);
        TextView weather = (TextView) findViewById(R.id.textView15);

        Date currentTime = Calendar.getInstance().getTime();
        titleView.setText(currentTime.toString());


        StringRequest stringRequest = new StringRequest(Request.Method.POST, apicall, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String output = "";
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray jsonArray =  jsonResponse.getJSONArray("weather");
                    JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
                    JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                    String description = jsonObjectWeather.getString("description");
                    double temp = jsonObjectMain.getDouble("feels_like") - 273.15;
                    weather.setText("Current Weather: " + description + "\n Temp: " + df.format(temp) + "°C");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Weather Unavailable", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);



        Intent rating  = getIntent();
        Bundle bundle = rating.getExtras();

        stars.setRating(DB.avgreview());
        if (rating.hasExtra("review")) {

            Float review = bundle.getFloat("review");
            heading = bundle.getString("title");
            body = bundle.getString("comment");
            stars.setRating(review);
        }

        Intent intentSettings = new Intent(this, my_reviews.class);
        Bundle bundle2 = new Bundle();
        settingsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // IF YOU ARE WORKING ON THE PREVIOUS PAGE, USE THIS TO GET THE INFORMATION
                bundle2.putFloat("review", stars.getRating());
                bundle2.putString("title", heading);
                bundle2.putString("comment", body);
                intentSettings.putExtras(bundle2);
                startActivity(intentSettings);
            }
        });

        Intent nourished = new Intent(this, departmental_reviews.class);
        nourish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(nourished);
            }
        });

        Intent grilled = new Intent(this, departmental_reviews.class);
        grill.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(grilled);
            }
        });

        Intent chefed = new Intent(this, departmental_reviews.class);
        chef.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(chefed);
            }
        });

        Intent desserted = new Intent(this, departmental_reviews.class);
        dessert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(desserted);
            }
        });
    }
}