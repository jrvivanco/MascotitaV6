package org.jrvivanco.mascotita.pojo;

/**
 * Created by jrvivanco on 16/12/2016.
 */
public class Perfil {
    private int foto;
    private int rating;

    public Perfil(int foto, int rating){
        this.foto = foto;
        this.rating = rating;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
