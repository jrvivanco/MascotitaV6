package org.jrvivanco.mascotita.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import org.jrvivanco.mascotita.R;
import org.jrvivanco.mascotita.pojo.Perfil;

/**
 * Created by jrvivanco on 16/12/2016.
 */
public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.perfilViewHolder> {

    private ArrayList<Perfil> item;

    public PerfilAdaptador(ArrayList<Perfil> item){
        this.item = item;
    }

    @Override
    public perfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil,parent,false);
        perfilViewHolder perfil = new perfilViewHolder(v);
        return perfil;
    }

    @Override
    public void onBindViewHolder(perfilViewHolder holder, int position) {
        holder.foto.setImageResource(item.get(position).getFoto());
        holder.rating.setText(String.valueOf(item.get(position).getRating()));
    }

    @Override
    public int getItemCount() {
        return this.item.size();
    }

    public class perfilViewHolder extends RecyclerView.ViewHolder{
        ImageView foto;
        TextView rating;

        public perfilViewHolder(View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.iv_fotoPerfil);
            rating = (TextView) itemView.findViewById(R.id.tv_Rating);
        }
    }
}
