package com.axel.appmusica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Asegúrate de que esta sea la actividad correcta

        // Encuentra los elementos de la interfaz
        EditText editTextEmail = findViewById(R.id.edit_text_email);
        EditText editTextPassword = findViewById(R.id.edit_text_password);
        Button buttonLogin = findViewById(R.id.button_login);

        // Definir los datos de correo y contraseña predefinidos
        String validEmail = "usuario@ejemplo.com";
        String validPassword = "contraseña123";

        // Configurar el botón de login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos introducidos por el usuario
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                // Verificar si los datos son correctos
                if (email.equals(validEmail) && password.equals(validPassword)) {
                    // Si los datos son correctos, mostrar mensaje y proceder a la siguiente actividad
                    Toast.makeText(LoginActivity.this, "Login exitoso", Toast.LENGTH_SHORT).show();

                    // Crear un Intent para iniciar MainActivity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);  // Iniciar la actividad de inicio
                    finish();  // Cerrar la actividad de login para que el usuario no regrese con el botón atrás
                } else {
                    // Si los datos son incorrectos, mostrar mensaje de error
                    Toast.makeText(LoginActivity.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
