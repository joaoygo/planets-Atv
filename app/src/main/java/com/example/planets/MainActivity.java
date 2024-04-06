package com.example.planets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv_planets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_planets = findViewById(R.id.lv_planets);

        ListItemPlanetsAdapterActivity adapter = new ListItemPlanetsAdapterActivity(this);

        lv_planets.setAdapter(adapter);


    }
}