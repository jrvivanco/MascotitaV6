package org.jrvivanco.mascotita.fragment;

import java.util.ArrayList;

import org.jrvivanco.mascotita.adapter.MascotaAdaptador;
import org.jrvivanco.mascotita.pojo.Mascota;

/**
 * Created by jrvivanco on 22/12/2016.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRecyclerView(MascotaAdaptador adaptador);
}
