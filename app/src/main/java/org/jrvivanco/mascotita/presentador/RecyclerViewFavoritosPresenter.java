package org.jrvivanco.mascotita.presentador;

import android.content.Context;

import java.util.ArrayList;

import org.jrvivanco.mascotita.db.ConstructorMascota;
import org.jrvivanco.mascotita.db.MascotasFavoritas;
import org.jrvivanco.mascotita.fragment.IRecyclerViewFragmentView;
import org.jrvivanco.mascotita.pojo.Mascota;

/**
 * Created by jrvivanco on 22/12/2016.
 */
public class RecyclerViewFavoritosPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private MascotasFavoritas mascotasFavoritas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFavoritosPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        mascotasFavoritas = new MascotasFavoritas(context);
        mascotas = mascotasFavoritas.obtenerDatos();
        mostrarMascotasRecyclerView();
    }

    @Override
    public void mostrarMascotasRecyclerView() {
        iRecyclerViewFragmentView.inicializarAdaptadorRecyclerView(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }

    public void obtenerInfoUsuario(String user_id) {
    }
}
