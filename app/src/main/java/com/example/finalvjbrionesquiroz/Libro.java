package com.example.finalvjbrionesquiroz;

import java.util.Date;

public class Libro {

    String nombre;
    int vistas;
    String fecha_de_estreno;
    String tienda_1;
    String tienda_2;
    String tienda_3;
    String imagen;
    String url_imagen;

    public Libro() {
    }

    public Libro(String nombre, int vistas, String fecha_de_estreno, String tienda_1, String tienda_2, String tienda_3, String imagen, String url_imagen) {
        this.nombre = nombre;
        this.vistas = vistas;
        this.fecha_de_estreno = fecha_de_estreno;
        this.tienda_1 = tienda_1;
        this.tienda_2 = tienda_2;
        this.tienda_3 = tienda_3;
        this.imagen = imagen;
        this.url_imagen = url_imagen;
    }

    public Libro(String nombre, int vistas, String fecha_de_estreno, String tienda_1, String tienda_2, String tienda_3, String imagen) {
        this.nombre = nombre;
        this.vistas = vistas;
        this.fecha_de_estreno = fecha_de_estreno;
        this.tienda_1 = tienda_1;
        this.tienda_2 = tienda_2;
        this.tienda_3 = tienda_3;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVistas() {
        return vistas;
    }

    public void setVistas(int vistas) {
        this.vistas = vistas;
    }

    public String getFecha_de_estreno() {
        return fecha_de_estreno;
    }

    public void setFecha_de_estreno(String fecha_de_estreno) {
        this.fecha_de_estreno = fecha_de_estreno;
    }

    public String getTienda_1() {
        return tienda_1;
    }

    public void setTienda_1(String tienda_1) {
        this.tienda_1 = tienda_1;
    }

    public String getTienda_2() {
        return tienda_2;
    }

    public void setTienda_2(String tienda_2) {
        this.tienda_2 = tienda_2;
    }

    public String getTienda_3() {
        return tienda_3;
    }

    public void setTienda_3(String tienda_3) {
        this.tienda_3 = tienda_3;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
}
