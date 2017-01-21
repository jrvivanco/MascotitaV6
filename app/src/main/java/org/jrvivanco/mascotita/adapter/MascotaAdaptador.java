package org.jrvivanco.mascotita.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.jrvivanco.mascotita.R;
import org.jrvivanco.mascotita.db.ConstructorMascota;
import org.jrvivanco.mascotita.pojo.Mascota;
import java.util.ArrayList;

/**
 * Created by jrvivanco on 22/12/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    private ArrayList<Mascota> item;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> item, Activity activity){
        this.item = item;
        this.activity = activity;
    }

    public MascotaAdaptador(ArrayList<Mascota> item){
        this.item = item;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Infla el layout y lo pasa al ViewHolder para que obtenda cada elemento
        //Se asocia layout al recycler
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_web, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        //Asocia cada elemento de la lista con cada view
        final Mascota mascota = item.get(position);
        //mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());

        Picasso.with(activity)
                .load(mascota.getFoto())
                .placeholder(R.drawable.mi_foto)
                .into(mascotaViewHolder.imgFoto);

        mascotaViewHolder.tvRaitingCV.setText(Integer.toString(mascota.getRating()));
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    //Clase ViewHolder para asociar objetos al view
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        //Declarar elementos del cardview
        private ImageView imgFoto;
        private TextView tvRaitingCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvRaitingCV = (TextView) itemView.findViewById(R.id.tvRaitingCV);
        }
    }
}
