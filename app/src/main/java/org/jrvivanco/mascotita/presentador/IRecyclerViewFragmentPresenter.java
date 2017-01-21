package org.jrvivanco.mascotita.presentador;

/**
 * Created by jrvivanco on 22/12/2016.
 */
public interface IRecyclerViewFragmentPresenter {

    public void obtenerMascotasBaseDatos();

    public void mostrarMascotasRecyclerView();

    public void obtenerInfoUsuario(String username);
}
