package com.example.reciborisitas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "nombre_archivo_shared_preferences"; // Nombre del archivo de preferencias compartidas
    private static final String SESION_INICIADA_KEY = "sesion_iniciada"; // Clave para el estado de la sesión

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // Inflar el diseño de la actividad Splash

        if (sesionIniciada()) {
            iniciarPaginaInicio();
        } else {
            iniciarInicioSesion();
        }
    }

    private boolean sesionIniciada() {
        // Recupera el estado de la sesión desde SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(SESION_INICIADA_KEY, false); // Devuelve true si la sesión está iniciada, false de lo contrario
    }

    private void guardarEstadoSesion(boolean sesionIniciada) {
        // Guarda el estado de la sesión en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(SESION_INICIADA_KEY, sesionIniciada);
        editor.apply();
    }

    private void iniciarPaginaInicio() {
        // Inicia la página de inicio
        Intent intent = new Intent(this, PaginaInicioActivity.class);
        startActivity(intent);
        finish();
    }

    private void iniciarInicioSesion() {
        // Inicia la pantalla de inicio de sesión
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
        finish();
    }
}
