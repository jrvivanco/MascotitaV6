package org.jrvivanco.mascotita.pojo;

/**
 * Created by jrvivanco on 16/12/2016.
 */
public class Mascota {

    private String id;
    private String nombre;
    private String foto;
    private int rating;

    public Mascota(String foto, String nombre, int rating)
    {
        this.nombre = nombre;
        this.foto = foto;
        this.rating = rating;
    }

    public Mascota(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
