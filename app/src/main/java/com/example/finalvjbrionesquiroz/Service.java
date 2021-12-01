package com.example.finalvjbrionesquiroz;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Service {

    @POST("N00017665")
    Call<Void> postCrearLibro(@Body Libro libro);

    @GET("N00017665")
    Call<List<Libro>> getLibros();

    @GET("N00017665")
    Call<Libro> getLibrosDetalle();

}
