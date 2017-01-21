package org.jrvivanco.mascotita.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import org.jrvivanco.mascotita.R;
import org.jrvivanco.mascotita.adapter.MascotaAdaptador;
import org.jrvivanco.mascotita.pojo.Mascota;
import org.jrvivanco.mascotita.presentador.IRecyclerViewFragmentPresenter;
import org.jrvivanco.mascotita.presentador.RecyclerViewFragmentPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private RecyclerView reciclador;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter recyclerAdapter;
    private IRecyclerViewFragmentPresenter presenter;

    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        reciclador = (RecyclerView) v.findViewById(R.id.rv_Reciclador);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(layoutManager);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        //recyclerAdapter = new MascotaAdaptador(mascotas);

        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRecyclerView(MascotaAdaptador adaptador) {
        reciclador.setAdapter(adaptador);
        //reciclador.setAdapter(recyclerAdapter);
    }


}
