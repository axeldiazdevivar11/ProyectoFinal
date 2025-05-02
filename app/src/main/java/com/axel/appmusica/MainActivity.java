package com.axel.appmusica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Lista de canciones de rock
    List<String> cancionesRock = new ArrayList<>(Arrays.asList(
            "Bohemian Rhapsody", "Stairway to Heaven", "Smells Like Teen Spirit",
            "Sweet Child O' Mine", "Hotel California"
    ));

    EditText editTextBuscar;
    Button buttonBuscar;
    Button buttonMisResenas; // Nuevo botón
    TextView textViewResultado;
    RatingBar ratingBar;
    EditText editTextResena;
    Button buttonGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar vistas
        editTextBuscar = findViewById(R.id.edit_text_buscar);
        buttonBuscar = findViewById(R.id.button_buscar);
        textViewResultado = findViewById(R.id.text_view_resultado);
        ratingBar = findViewById(R.id.rating_bar);
        editTextResena = findViewById(R.id.edit_text_resena);
        buttonGuardar = findViewById(R.id.button_guardar);
        buttonMisResenas = findViewById(R.id.button_mis_resenas); // Inicializar nuevo botón

        // Buscar canción
        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = editTextBuscar.getText().toString().trim();

                if (cancionesRock.contains(query)) {
                    textViewResultado.setText("Canción encontrada: " + query);

                    // Ir a PublicarResenaActivity con el título de la canción
                    Intent intent = new Intent(MainActivity.this, PublicarResenaActivity.class);
                    intent.putExtra("titulo_cancion", query);
                    startActivity(intent);
                } else {
                    textViewResultado.setText("Canción no encontrada");
                    Toast.makeText(MainActivity.this, "No se encontró esa canción de rock", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Guardar reseña
        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reseña = editTextResena.getText().toString();
                float calificacion = ratingBar.getRating();

                if (reseña.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Escribe una reseña primero", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Reseña guardada: " + calificacion + "★", Toast.LENGTH_SHORT).show();
                    editTextResena.setText("");
                    ratingBar.setRating(0);
                }
            }
        });

        // Ir a pantalla Mis Reseñas
        buttonMisResenas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MisResenasActivity.class);
                startActivity(intent);
            }
        });
    }
}
