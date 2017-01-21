package org.jrvivanco.mascotita.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import org.jrvivanco.mascotita.db.ConstructorMascota;
import org.jrvivanco.mascotita.pojo.Mascota;
import org.jrvivanco.mascotita.restApi.IEndPointsApi;
import org.jrvivanco.mascotita.restApi.adapter.RestApiAdapter;
import org.jrvivanco.mascotita.restApi.model.MascotaMediaRecentResponse;
import org.jrvivanco.mascotita.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jrvivanco on 07/01/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascota constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;

        //Consulta de usuarios que aceptaron invitacion sandbox
        mascotas = new ArrayList<Mascota>();
        obtenerInfoUsuario("4393478762"); //id juravica2016
        //obtenerMascotasBaseDatos();

    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascota(context);
        mascotas = constructorMascotas.obtenerDatosMascota();
        mostrarMascotasRecyclerView();
    }

    @Override
    public void mostrarMascotasRecyclerView() {
        iRecyclerViewFragmentView.inicializarAdaptadorRecyclerView(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }

    @Override
    public void obtenerInfoUsuario(String user_id) {
        //Ejecuta conexion a servidor
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        //Se construye gson que indica la forma de deserializar
        Gson gson = restApiAdapter.construyeGsonDeserializadorMascotaMediaRecent();
        IEndPointsApi iEndPointsApi = restApiAdapter.establecerConexionRestApiInstagram(gson);
        //Ejecucion de metodo endpoint de webservice
        Call<MascotaMediaRecentResponse> mascotaMediaRecentResponseCall = iEndPointsApi.getUsersSearch(user_id);
        //Controlar resultado de respuesta
        mascotaMediaRecentResponseCall.enqueue(new Callback<MascotaMediaRecentResponse>() {
            @Override
            public void onResponse(Call<MascotaMediaRecentResponse> call, Response<MascotaMediaRecentResponse> response) {
                //Para cuando la peticion trae datos
                MascotaMediaRecentResponse mascotaMediaRecentResponse = response.body();
                //Se agrega a arreglo de datos de usuarios
                mascotas.addAll(mascotaMediaRecentResponse.getMascotas());
                mostrarMascotasRecyclerView();
            }

            @Override
            public void onFailure(Call<MascotaMediaRecentResponse> call, Throwable t) {
                //Cuando la peticion falla
                Toast.makeText(context, "Algo fallo al consultar datos recientes", Toast.LENGTH_SHORT).show();
                Log.e("FALLO CONSULTA IMAGEN ", t.toString());
            }
        });
    }

}
