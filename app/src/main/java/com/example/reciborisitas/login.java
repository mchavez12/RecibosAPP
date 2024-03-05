package com.example.reciborisitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.log_in);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();


                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(login.this, "Por favor, ingresa tu correo electrónico y contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                    iniciarPaginaInicio();
                }
            }
        });
    }

    private void iniciarPaginaInicio() {

        Intent intent = new Intent(login.this, PaginaInicioActivity.class);
        startActivity(intent);
        finish();
    }

    public void onSignUpClick(View view) {
        // Este método se llamará cuando se haga clic en el TextView "Regístrate aquí"
        // Aquí puedes iniciar la actividad de registro
        Intent intent = new Intent(this, RegistroActivity.class); // Reemplaza "RegistroActivity" con el nombre de tu actividad de registro
        startActivity(intent);
    }

}
