package org.jrvivanco.mascotita.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.jrvivanco.mascotita.pojo.Mascota;
import org.jrvivanco.mascotita.pojo.Usuario;
import org.jrvivanco.mascotita.restApi.JsonKeys;
import org.jrvivanco.mascotita.restApi.model.MascotaMediaRecentResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by jrvivanco on 07/01/2017.
 * Clase para deserializar data de busqueda de usuarios
 */

public class MascotaDeserializador implements JsonDeserializer<MascotaMediaRecentResponse>{
    @Override
    public MascotaMediaRecentResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaMediaRecentResponse mascotaMediaRecentResponse = gson.fromJson(json, MascotaMediaRecentResponse.class);
        JsonArray mascotaMediaRecentResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_SEARCH_ARRAY);

        //Se envia el arreglo de usuarios deserializado
        mascotaMediaRecentResponse.setMascotas(deserializarMascotasDeJson(mascotaMediaRecentResponseData));
        return mascotaMediaRecentResponse;
    }

    private ArrayList<Mascota> deserializarMascotasDeJson(JsonArray mascotaMediaRecentResponseData){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for (int i = 0; i < mascotaMediaRecentResponseData.size(); i++) {
            JsonObject mascotaResponseObject = mascotaMediaRecentResponseData.get(i).getAsJsonObject();

            JsonObject userJson     = mascotaResponseObject.getAsJsonObject(JsonKeys.USER);
            String id               = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto   = userJson.get(JsonKeys.USER_NAME).getAsString();

            JsonObject imageJson            = mascotaResponseObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson    = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlFoto                  = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = mascotaResponseObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(id);
            mascotaActual.setNombre(nombreCompleto);
            mascotaActual.setFoto(urlFoto);
            mascotaActual.setRating(likes);

            mascotas.add(mascotaActual);
        }

        return mascotas;
    }
}
