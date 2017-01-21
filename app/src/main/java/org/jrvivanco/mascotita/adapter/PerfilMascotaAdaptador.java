package org.jrvivanco.mascotita.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import org.jrvivanco.mascotita.R;
import org.jrvivanco.mascotita.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by jrvivanco on 07/01/2017.
 */

public class PerfilMascotaAdaptador extends RecyclerView.Adapter<PerfilMascotaAdaptador.PerfilMascotaViewHolder>{

    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public PerfilMascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public PerfilMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Infla el layout y lo pasa al ViewHolder para que obtenda cada elemento
        //Se asocia layout al recycler
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_foto_mascota, parent, false);
        return new PerfilMascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PerfilMascotaViewHolder perfilMascotaViewHolder, int position) {
        //Asocia cada elemento de la lista con cada view
        final Mascota mascota = mascotas.get(position);
        //perfilMascotaViewHolder.imgFotoMascota.setImageResource(mascota.getFoto());

        Picasso.with(activity)
                .load(mascota.getFoto())
                .placeholder(R.drawable.mi_foto)
                .into(perfilMascotaViewHolder.imgFotoMascota);

        perfilMascotaViewHolder.tvRaitingMascota.setText(Integer.toString(mascota.getRating()));
    }

    @Override
    public int getItemCount() {
        Log.i("Recuperando imagenes", "getItemCount: SE CAE");
        return mascotas.size();
    }

    //Clase ViewHolder para asociar objetos al view
    public static class PerfilMascotaViewHolder extends RecyclerView.ViewHolder {

        //Declarar elementos del vardview
        private ImageView imgFotoMascota;
        private TextView tvRaitingMascota;

        public PerfilMascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoMascota = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            tvRaitingMascota = (TextView) itemView.findViewById(R.id.tvRaitingMascota);
        }
    }
}
