package org.jrvivanco.mascotita.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.jrvivanco.mascotita.R;

/**
 * Created by jrvivanco on 22/12/2016.
 */
public class mascotaViewHolder extends RecyclerView.ViewHolder {

    TextView nombre;
    ImageView foto;
    TextView rating;
    ImageButton btnLike;

    public mascotaViewHolder(View itemView) {
        super(itemView);
        nombre = (TextView) itemView.findViewById(R.id.tv_Nombre);
        foto = (ImageView) itemView.findViewById(R.id.iv_Mascota);
        rating = (TextView) itemView.findViewById(R.id.tv_Rating);
        btnLike = (ImageButton) itemView.findViewById(R.id.ibtn_HuesoBlanco);
    }
}
