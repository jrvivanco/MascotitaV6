package org.jrvivanco.mascotita.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jrvivanco.mascotita.restApi.ConstantesRestApi;
import org.jrvivanco.mascotita.restApi.IEndPointsApi;
import org.jrvivanco.mascotita.restApi.deserializador.MascotaDeserializador;
import org.jrvivanco.mascotita.restApi.model.MascotaMediaRecentResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jrvivanco on 07/01/2017.
 */

public class RestApiAdapter {


    //Inicializa objeto para conectarse al web service
    public IEndPointsApi establecerConexionRestApiInstagram(Gson gson){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …
        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                //.client(httpClient.build())
                .build();

        return retrofit.create(IEndPointsApi.class);
    }

    public Gson construyeGsonDeserializadorMascotaMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaMediaRecentResponse.class, new MascotaDeserializador());
        return gsonBuilder.create();
    }

    public IEndPointsApi establecerConexionMiRestAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.MI_API_ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IEndPointsApi.class);
    }

 }
