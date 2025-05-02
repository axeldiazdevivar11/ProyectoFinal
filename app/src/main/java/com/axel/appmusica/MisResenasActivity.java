package com.axel.appmusica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MisResenasActivity extends AppCompatActivity {

    ListView listViewResenas;
    Button buttonVolverInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_resenas);

        listViewResenas = findViewById(R.id.list_view_resenas);
        buttonVolverInicio = findViewById(R.id.button_volver_inicio);

        // Crear el adaptador y setearlo al ListView
        ResenaAdapter adapter = new ResenaAdapter(this, ResenaStorage.resenas);
        listViewResenas.setAdapter(adapter);

        // Botón volver a inicio
        buttonVolverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MisResenasActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
