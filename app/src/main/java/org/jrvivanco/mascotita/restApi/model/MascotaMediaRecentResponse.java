package org.jrvivanco.mascotita.restApi.model;

import org.jrvivanco.mascotita.pojo.Mascota;
import org.jrvivanco.mascotita.pojo.Usuario;

import java.util.ArrayList;

/**
 * Created by jrvivanco on 07/01/2017.
 */

public class MascotaMediaRecentResponse {
    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }


}
