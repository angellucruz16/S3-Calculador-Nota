package com.example.ejercicios3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button configurarColor;
    private TextView nombreEstudiante;
    private TextView continuarBoton;
    private ConstraintLayout fondoColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurarColor = findViewById(R.id.configurarColor);
        nombreEstudiante = findViewById(R.id.nombreEstudiante);
        continuarBoton = findViewById(R.id.continuarBoton);
        fondoColor = findViewById(R.id.colorFondoB);
        nombreEstudiante = findViewById(R.id.nombreEstudiante);

        configurarColor.setOnClickListener(
          v -> {
              Intent i = new Intent (this, ConfigColor.class);
              startActivity(i);
          }
        );
        continuarBoton.setOnClickListener(
                v -> {
                    String nombre = nombreEstudiante.getText().toString();
                   if(nombre == null || nombre.isEmpty()) {
                       Toast.makeText(this, "Escriba su nombre", Toast.LENGTH_SHORT).show();
                   } else {
                        Intent i = new Intent(this, CalculoNota.class);
                        i.putExtra("nombre", nombre);
                        startActivity(i);
                    }
                }
        );
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);
        String color = preferences.getString("color" , "#ffffff");
        fondoColor.setBackgroundColor(Color.parseColor(color));

    }
}