package com.example.finalvjbrionesquiroz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // btn Registrar Libros
        Button button = findViewById(R.id.btnRegistrarLibro);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrarLibroActivity.class);
                startActivity(intent);
            }
        });


        //btn Sincronizar Lista de Libros
        Button button1 = findViewById(R.id.btnSincronizarListaLibros);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SincronizarLibroActivity.class);
                startActivity(intent);
            }
        });

        // btn Mostrar Lista de Libros
        Button button2= findViewById(R.id.btnMostrarListaLibros);
       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), LibrosActivity.class);
               startActivity(intent);
           }
       });


    }
}