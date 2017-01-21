package org.jrvivanco.mascotita.fragment;

import org.jrvivanco.mascotita.adapter.MascotaAdaptador;
import org.jrvivanco.mascotita.adapter.PerfilMascotaAdaptador;
import org.jrvivanco.mascotita.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by jrvivanco on 07/01/2017.
 */

public interface IPerfilFragmentView {

    public void generarGridLayout(int columnas);

    public PerfilMascotaAdaptador crearPerfilMascotaAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarPerfilMascotaAdaptadorRV(PerfilMascotaAdaptador adaptador);

}
