package org.jrvivanco.mascotita.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import org.jrvivanco.mascotita.R;
import org.jrvivanco.mascotita.adapter.PerfilAdaptador;
import org.jrvivanco.mascotita.adapter.PerfilMascotaAdaptador;
import org.jrvivanco.mascotita.pojo.Perfil;
import org.jrvivanco.mascotita.pojo.Mascota;
import org.jrvivanco.mascotita.presentador.IPerfilFragmentPresenter;
import org.jrvivanco.mascotita.presentador.PerfilFragmentPresenter;
/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilFragmentView {

    private ArrayList<Perfil> datos;

    private ArrayList<Mascota> fotosMascotas;
    private RecyclerView listafotosMascotas;
    private View view;
    private IPerfilFragmentPresenter iPerfilFragmentPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

     /*   //ReciclerView
        datos = new ArrayList<Perfil>();
        datos.add(new Perfil(R.drawable.ashera,15));
        datos.add(new Perfil(R.drawable.ashera,12));
        datos.add(new Perfil(R.drawable.ashera,7));
        datos.add(new Perfil(R.drawable.ashera,9));
        datos.add(new Perfil(R.drawable.ashera,5));
        datos.add(new Perfil(R.drawable.ashera,11));
        datos.add(new Perfil(R.drawable.ashera,24));
        datos.add(new Perfil(R.drawable.ashera,8));
        datos.add(new Perfil(R.drawable.ashera,6));
        datos.add(new Perfil(R.drawable.ashera,1));
        datos.add(new Perfil(R.drawable.ashera,3));
        datos.add(new Perfil(R.drawable.ashera,17));
        datos.add(new Perfil(R.drawable.ashera,4));
        datos.add(new Perfil(R.drawable.ashera,30));
        datos.add(new Perfil(R.drawable.ashera,22));

        RecyclerView reciclador = (RecyclerView) v.findViewById(R.id.rv_gridPerfil);
        GridLayoutManager gridPerfil = new GridLayoutManager(getActivity(), 3);
        gridPerfil.setOrientation(GridLayoutManager.VERTICAL);
        reciclador.setLayoutManager(gridPerfil);
        PerfilAdaptador recyclerAdapter = new PerfilAdaptador(datos);
        reciclador.setAdapter(recyclerAdapter);
*/
        listafotosMascotas = (RecyclerView) v.findViewById(R.id.rv_gridPerfil);

        iPerfilFragmentPresenter = new PerfilFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void generarGridLayout(int columnas) {
        //Se define forma de presentar RecyvlerView
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), columnas);
        //Se pasa layout a objeto RecyclerView
        listafotosMascotas.setLayoutManager(gridLayoutManager);
    }

    @Override
    public PerfilMascotaAdaptador crearPerfilMascotaAdaptador(ArrayList<Mascota> mascotas) {
        //Paso de lista de mascotas
        PerfilMascotaAdaptador perfilMascotaAdaptador = new PerfilMascotaAdaptador(mascotas, getActivity());
        return perfilMascotaAdaptador;
    }

    @Override
    public void inicializarPerfilMascotaAdaptadorRV(PerfilMascotaAdaptador adaptador) {
        //Setear adaptador al RecyclerView
        listafotosMascotas.setAdapter(adaptador);
    }

}