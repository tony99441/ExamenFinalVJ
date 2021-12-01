package com.example.finalvjbrionesquiroz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LibroDetalleActivity extends AppCompatActivity {

    ImageView image_libro;
    EditText nombre, vistas, fecha;
    private  Libro libro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro_detalle);

        image_libro = findViewById(R.id.image_libroDetalle);
        nombre = findViewById(R.id.nameLibroDetalle);
        vistas = findViewById(R.id.vistaLibroDetalle);
        fecha = findViewById(R.id.FechadeEstrenoDetalle);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/peliculas/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service service = retrofit.create(Service.class);
        Call<Libro> getDetalle = service.getLibrosDetalle();

        getDetalle.enqueue(new Callback<Libro>() {
            @Override
            public void onResponse(Call<Libro> call, Response<Libro> response) {
                libro = response.body();

                String im = "https://upn.lumenes.tk/peliculas/" + libro.getUrl_imagen();
                Picasso.get()
                        .load(im)
                        .into(image_libro);
                nombre.setText(libro.getNombre());
                vistas.setText(libro.getVistas());
                fecha.setText(libro.getFecha_de_estreno());
            }

            @Override
            public void onFailure(Call<Libro> call, Throwable t) {

            }
        });
        findViewById(R.id.location_libro).setOnClickListener(view -> {

            String Posicion1 = String.valueOf(libro.getTienda_1());
            String Posicion2 = String.valueOf(libro.getTienda_2());

            Intent intent = new Intent(this, MapsActivity.class);
            intent.putExtra("1", Posicion1);
            intent.putExtra("2",Posicion2);

            startActivity(intent);
        });

    }
}