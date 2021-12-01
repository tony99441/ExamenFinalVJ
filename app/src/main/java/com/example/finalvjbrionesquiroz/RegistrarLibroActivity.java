package com.example.finalvjbrionesquiroz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrarLibroActivity extends AppCompatActivity {

    ImageView imageLIBRO;
    EditText nombreLibro;
    EditText vistasLibro;
    EditText fechaLibro;
    EditText tienda1;
    EditText tienda2;
    EditText tienda3;
    Uri imageUri;
    String imagenString;
    Button seleccionarImagen;
    Button registrarLibro, btnTomarFotoCamara;
    private static final int PICK_IMAGE = 11;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_libro);

        imageLIBRO = findViewById(R.id.imageLIBRO);
        nombreLibro = findViewById(R.id.nombreLibro);
        vistasLibro = findViewById(R.id.VistasLibro);
        fechaLibro = findViewById(R.id.FechaEstreno);
        tienda1 = findViewById(R.id.Tienda1);
        tienda2 = findViewById(R.id.Tienda2);
        tienda3 = findViewById(R.id.Tienda3);
        seleccionarImagen = findViewById(R.id.imagenBT);
        registrarLibro = findViewById(R.id.registrarLibrito);
        btnTomarFotoCamara = findViewById(R.id.btnTomarFoto);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/peliculas/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);

        registrarLibro.setOnClickListener(v -> {

            String nombre = nombreLibro.getEditableText().toString().trim();
            String vista = vistasLibro.getEditableText().toString().trim();
            String fecha = fechaLibro.getEditableText().toString().trim();
            String tienda1Libro = tienda1.getEditableText().toString().trim();
            String tienda2Libro =tienda2.getEditableText().toString().trim();
            String tienda3Libro = tienda3.getEditableText().toString().trim();


            Libro libro = new Libro(nombre,Integer.parseInt(vista),fecha,tienda1Libro, tienda2Libro,tienda3Libro, imagenString);


            Call<Void> entre = service.postCrearLibro(libro);
            entre.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    String respuesta = String.valueOf(response.code());
                    if (respuesta.equals("200")) {
                        Toast.makeText(getApplicationContext(), "Librito creado ;)", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    } else {
                        Toast.makeText(getApplicationContext(), " :( ", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });

        seleccionarImagen.setOnClickListener(v -> cargarImagen());
        btnTomarFotoCamara.setOnClickListener(v -> CargarImgCamara());

    }
    private void cargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE);
    }
    private void CargarImgCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent, 101);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE  ) {
            imageUri = data.getData();
            imageLIBRO.setImageURI(imageUri);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                byte[] image = outputStream.toByteArray();
                String encodedString = Base64.encodeToString(image, Base64.DEFAULT);
                imagenString = encodedString;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }





    }
}