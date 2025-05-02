package com.axel.appmusica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PublicarResenaActivity extends AppCompatActivity {

    ImageView imageViewCancion;
    TextView textViewTitulo;
    RatingBar ratingBar;
    EditText editTextResena;
    Button buttonGuardarResena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_resena);

        // Inicializar las vistas
        imageViewCancion = findViewById(R.id.image_view_cancion);
        textViewTitulo = findViewById(R.id.text_view_titulo);
        ratingBar = findViewById(R.id.rating_bar);
        editTextResena = findViewById(R.id.edit_text_resena);
        buttonGuardarResena = findViewById(R.id.button_guardar_resena);

        // Obtener el título de la canción de la actividad anterior
        String tituloCancion = getIntent().getStringExtra("titulo_cancion");
        textViewTitulo.setText(tituloCancion);

        // Asignar la imagen correspondiente según la canción
        if (tituloCancion != null) {
            switch (tituloCancion) {
                case "Bohemian Rhapsody":
                    imageViewCancion.setImageResource(R.drawable.bohemian_rhapsody);
                    break;
                case "Stairway to Heaven":
                    imageViewCancion.setImageResource(R.drawable.stairway_to_heaven);
                    break;
                case "Smells Like Teen Spirit":
                    imageViewCancion.setImageResource(R.drawable.smells_like_teen_spirit);
                    break;
                case "Sweet Child O' Mine":
                    imageViewCancion.setImageResource(R.drawable.sweet_child);
                    break;
                case "Hotel California":
                    imageViewCancion.setImageResource(R.drawable.hotel_california);
                    break;
                default:
                    imageViewCancion.setImageResource(R.drawable.logo_musica); // Imagen por defecto
            }
        }

        // Guardar reseña y abrir pantalla de reseñas
        buttonGuardarResena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reseña = editTextResena.getText().toString();
                float calificacion = ratingBar.getRating();

                if (reseña.isEmpty()) {
                    Toast.makeText(PublicarResenaActivity.this, "Escribe una reseña primero", Toast.LENGTH_SHORT).show();
                } else {
                    // Crear el objeto Resena y agregarlo a la lista estática
                    ResenaStorage.resenas.add(new Resena(tituloCancion, reseña, calificacion, getImagenCancion(tituloCancion)));

                    // Mostrar mensaje
                    Toast.makeText(PublicarResenaActivity.this, "Reseña guardada", Toast.LENGTH_SHORT).show();

                    // Limpiar campos
                    editTextResena.setText("");
                    ratingBar.setRating(0);

                    // Ir a pantalla de Mis Reseñas
                    Intent intent = new Intent(PublicarResenaActivity.this, MisResenasActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    // Método para obtener el ID de la imagen según el título de la canción
    private int getImagenCancion(String tituloCancion) {
        switch (tituloCancion) {
            case "Bohemian Rhapsody":
                return R.drawable.bohemian_rhapsody;
            case "Stairway to Heaven":
                return R.drawable.stairway_to_heaven;
            case "Smells Like Teen Spirit":
                return R.drawable.smells_like_teen_spirit;
            case "Sweet Child O' Mine":
                return R.drawable.sweet_child;
            case "Hotel California":
                return R.drawable.hotel_california;
            default:
                return R.drawable.logo_musica; // Imagen por defecto
        }
    }
}
