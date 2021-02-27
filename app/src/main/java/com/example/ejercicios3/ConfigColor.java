package com.example.ejercicios3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class ConfigColor extends AppCompatActivity {
    private Button blancoBoton;
    private Button azulBoton;
    private Button grisBoton;
    private ConstraintLayout colorFondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_color);

        blancoBoton = findViewById(R.id.blancoBoton);
        azulBoton = findViewById(R.id.azulBoton);
        grisBoton = findViewById(R.id.grisBoton);
        colorFondo = findViewById(R.id.colorFondo);

        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);
        blancoBoton.setOnClickListener(
                v -> {
                 String blancoColor = "#FFFFFF";
                 String grisLetra = "#32343A";
                 preferences.edit().putString("color", blancoColor).apply();
                 finish();
                }
        );
        azulBoton.setOnClickListener(
                v -> {
                String azulColor = "#0390AB";
                preferences.edit().putString("color", azulColor).apply();
                finish();
                }
        );
        grisBoton.setOnClickListener(
                v -> {
                String grisColor = "#32343A";
                preferences.edit().putString("color", grisColor).apply();
                finish();
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);
        String color = preferences.getString("color", "#ffffff");
        colorFondo.setBackgroundColor(Color.parseColor(color));
    }
}