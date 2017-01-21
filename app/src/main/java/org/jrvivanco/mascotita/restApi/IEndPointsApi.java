package org.jrvivanco.mascotita.restApi;

import org.jrvivanco.mascotita.restApi.model.MascotaMediaRecentResponse;
import org.jrvivanco.mascotita.restApi.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

 /**
 * Created by jrvivanco on 07/01/2017.
 * Definir metodos que recibiran las peticiones al web service
 */

public interface IEndPointsApi {

    //Busqueda de usuarios por username
    @GET(ConstantesRestApi.USERS + "{user_id}" + ConstantesRestApi.MEDIA_SEARCH + "?" + ConstantesRestApi.KEY_ACCESS_TOKEN + ConstantesRestApi.ACCESS_TOKEN)
    //@GET("users/search?q=user_id&access_token=access_token")
     Call<MascotaMediaRecentResponse> getUsersSearch(@Path("user_id") String user_id);

     @FormUrlEncoded
     @POST(ConstantesRestApi.MI_API_KEY_REGISTRO_USUARIO)
     Call<UsuarioResponse> registrarUsuario(@Field("id_dispositivo") String id_dispositivo, @Field("id_usuario_instagram") String id_usuario_instagram);

 }
