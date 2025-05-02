package com.axel.appmusica;

public class Resena {
    private String tituloCancion;
    private String reseña;
    private float calificacion;
    private int imagenCancion; // Aquí guardamos el ID de la imagen correspondiente

    // Constructor
    public Resena(String tituloCancion, String reseña, float calificacion, int imagenCancion) {
        this.tituloCancion = tituloCancion;
        this.reseña = reseña;
        this.calificacion = calificacion;
        this.imagenCancion = imagenCancion;
    }

    // Getters y Setters
    public String getTituloCancion() {
        return tituloCancion;
    }

    public void setTituloCancion(String tituloCancion) {
        this.tituloCancion = tituloCancion;
    }

    public String getReseña() {
        return reseña;
    }

    public void setReseña(String reseña) {
        this.reseña = reseña;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public int getImagenCancion() {
        return imagenCancion;
    }

    public void setImagenCancion(int imagenCancion) {
        this.imagenCancion = imagenCancion;
    }
}
