package com.example.ejercicios3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculoNota extends AppCompatActivity {

    private ConstraintLayout colorFondoB;
    private EditText parcialUno;
    private EditText parcialDos;
    private EditText quiz;
    private EditText ejercicio;
    private EditText parcialProyectoUno;
    private EditText parcialProyectoDos;
    private TextView nombreUsuario;
    private Button botonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculo_nota);
        parcialUno = findViewById(R.id.parcialUno);
        parcialDos = findViewById(R.id.parcialDos);
        colorFondoB = findViewById(R.id.colorFondoB);
        botonCalcular = findViewById(R.id.botonCalcular);
        quiz = findViewById(R.id.quiz);
        ejercicio = findViewById(R.id.parcialProyectoDos);
        parcialProyectoUno = findViewById(R.id.parcialDos);
        parcialProyectoDos = findViewById(R.id.parcialProyectoDos);
        nombreUsuario = findViewById(R.id.nombreUsuario);
        //
        String nombreEs = getIntent().getExtras().getString("nombre");
        nombreUsuario.setText(nombreEs);
        //
        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);
        //
        botonCalcular.setOnClickListener(
                v-> {
               obtenerNotas();
               finish();
                }
        );
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);
        String color = preferences.getString("color", "#ffffff");
        colorFondoB.setBackgroundColor(Color.parseColor(color));
    }
    protected void obtenerNotas () {
        Intent i = new Intent(this, Resultado.class);
        i.putExtra("nombreEs", nombreUsuario.getText());

        String parcialUnoEs = parcialUno.getText().toString();
        Float notaParcialUno = Float.parseFloat(parcialUnoEs);
        i.putExtra("notaParcialUno",notaParcialUno);

        String parcialDosEs = parcialDos.getText().toString();
        Float notaParcialDos = Float.parseFloat(parcialDosEs);
        i.putExtra("notaParcialDos",notaParcialDos);


        String quizEs = quiz.getText().toString();
        Float notaQuiz = Float.parseFloat(quizEs);
        i.putExtra("notaQuiz", notaQuiz);

        String ejercicioEs = quiz.getText().toString();
        Float notaEjercicio = Float.parseFloat(ejercicioEs);
        i.putExtra("notaEjercicio", notaEjercicio);

        String parcialProyectoUnoEs = parcialProyectoUno.getText().toString();
        Float notaParcialProyectoUno = Float.parseFloat(parcialProyectoUnoEs);
        i.putExtra("notaParcialProyectoUno", notaParcialProyectoUno);

        String parcialProyectoDosEs = parcialProyectoDos.getText().toString();
        Float notaParcialProyectoDos = Float.parseFloat(parcialProyectoDosEs);
        i.putExtra("notaParcialProyectoDos", notaParcialProyectoDos);

        startActivity(i);
    }
}
