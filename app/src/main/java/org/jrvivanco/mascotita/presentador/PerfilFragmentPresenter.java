package org.jrvivanco.mascotita.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.google.gson.Gson;
import org.jrvivanco.mascotita.pojo.Mascota;
import org.jrvivanco.mascotita.restApi.ConstantesRestApi;
import org.jrvivanco.mascotita.restApi.IEndPointsApi;
import org.jrvivanco.mascotita.restApi.adapter.RestApiAdapter;
import org.jrvivanco.mascotita.restApi.model.MascotaMediaRecentResponse;
import org.jrvivanco.mascotita.fragment.IPerfilFragmentView;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jrvivanco on 07/01/2017.
 */

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {

    private IPerfilFragmentView iPerfilFragmentView;
    private Context context;
    private ArrayList<Mascota> mascotas;

    public PerfilFragmentPresenter(IPerfilFragmentView iPerfilFragmentView, Context context) {
        this.iPerfilFragmentView = iPerfilFragmentView;
        this.context = context;

        mascotas = new ArrayList<Mascota>();
        if (!ConstantesRestApi.ID_USER.isEmpty()){
            obtenerImagenesMascota(ConstantesRestApi.ID_USER);
        }

    }

    @Override
    public void mostrarMascotasRV() {
        iPerfilFragmentView.inicializarPerfilMascotaAdaptadorRV(iPerfilFragmentView.crearPerfilMascotaAdaptador(mascotas));
        iPerfilFragmentView.generarGridLayout(3);
    }

    @Override
    public void obtenerImagenesMascota(String id_user) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.construyeGsonDeserializadorMascotaMediaRecent();
        IEndPointsApi iEndPointsApi = restApiAdapter.establecerConexionRestApiInstagram(gson);

        Call<MascotaMediaRecentResponse> mascotaMediaRecentResponseCall = iEndPointsApi.getUsersSearch(id_user);
        //Controlar resultado de respuesta

        mascotaMediaRecentResponseCall.enqueue(new Callback<MascotaMediaRecentResponse>() {
            @Override
            public void onResponse(Call<MascotaMediaRecentResponse> call, Response<MascotaMediaRecentResponse> response) {
                Log.i(">>>", "ID_USER " + ConstantesRestApi.ID_USER);
                //Log.i(">>>", "MENSAJE 1");
                //Para cuando la peticion trae datos
                MascotaMediaRecentResponse mascotaMediaRecentResponse = response.body();
                //Log.i(">>>", "MENSAJE 2");
                //Se agrega a arreglo de datos de usuarios
                mascotas.addAll(mascotaMediaRecentResponse.getMascotas());
                //Log.i(">>>", "MENSAJE 3");
                mostrarMascotasRV();
                //Log.i(">>>", "MENSAJE 4");
            }

            @Override
            public void onFailure(Call<MascotaMediaRecentResponse> call, Throwable t) {
                //Cuando la peticion falla
                Toast.makeText(context, "Algo fallo al consultar datos recientes", Toast.LENGTH_SHORT).show();
                Log.e("FALLO CONSULTA IMAGEN ", t.toString());
            }
        });
        //Log.i(">>>", "MENSAJE 5");

    }
}
