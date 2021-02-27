package com.example.ejercicios3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView notaFinal;
    private TextView estudiante;
    private Button calcularNuevo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        notaFinal = findViewById(R.id.notaFinal);
        estudiante = findViewById(R.id.estudiante);
        calcularNuevo = findViewById(R.id.calcularNuevo);

        String nombreEstudiante = getIntent().getExtras().getString("nombreEs");
        estudiante.setText(nombreEstudiante);

        Float notaParcialUno = getIntent().getExtras().getFloat("notaParcialUno");
       // Log.e("consola", String.valueOf(notaParcialUno));
        Float notaParcialDos = getIntent().getExtras().getFloat("notaParcialDos");
       // Log.e("consola2", String.valueOf(notaParcialDos));
        Float notaQuiz = getIntent().getExtras().getFloat("notaQuiz");
        Float notaEjercicio = getIntent().getExtras().getFloat("notaEjercicio");
        Float notaParcialProyectoUno = getIntent().getExtras().getFloat("notaParcialProyectoUno");
        Float notaParcialProyectoDos = getIntent().getExtras().getFloat("notaParcialProyectoDos");

        calculatePromedio(notaParcialUno,notaParcialDos, notaQuiz, notaEjercicio, notaParcialProyectoUno, notaParcialProyectoDos);


        calcularNuevo.setOnClickListener(
                v->{
                   finish();
                }
        );

    }
    private void calculatePromedio (Float parcialUno, Float parcialDos, Float quiz, Float ejercicio, Float parcialProyectoUno, Float parcialProyectoDos) {
        double sumatoria =  ((parcialUno*0.15) + (parcialDos* 0.15) + (quiz*0.15) + (ejercicio*0.05) + (parcialProyectoUno*0.25) + (parcialProyectoDos*0.25));
        //double promedio = sumatoria/6;
        double promedioRedondiado = Math.round(sumatoria*100)/100;
        Log.e("promedio", String.valueOf(promedioRedondiado));
        notaFinal.setText(""+ promedioRedondiado);

    }

}