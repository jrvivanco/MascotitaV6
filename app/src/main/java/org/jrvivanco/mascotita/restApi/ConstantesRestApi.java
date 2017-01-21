package org.jrvivanco.mascotita.restApi;

/**
 * Created by jrvivanco on 07/01/2017.
 * Clase que maneja las constantes para conexion
 * de servicios web
 */

public final class ConstantesRestApi {

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String KEY_ACCESS_TOKEN = "access_token=";
    public static final String ACCESS_TOKEN = "4393478762.0e27517.16ce49021ccd486eb4f0c37e8cc142c7";
    public static final String USERS = "users/";
    public static final String MEDIA_SEARCH = "/media/recent/";
    public static final String TAG_ACCESS_TOKEN = KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static String ID_USER = "";
    public static String ID_USERNAME = "juravica2016";


    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + TAG_ACCESS_TOKEN;

    public static final String KEY_GET_RECENT_MEDIA_AMIGOS = "users/{usuario}/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_AMIGOS = KEY_GET_RECENT_MEDIA_AMIGOS + TAG_ACCESS_TOKEN;

    public static final String KEY_SEARCH_USER = "users/search";


//Para obtener los usuarios que me siguen.....
    public static final String MI_API_ROOT_URL = "https://calm-headland-74792.herokuapp.com/";
    public static final String MI_API_KEY_REGISTRO_USUARIO = "registrar-usuario/";
    public static final String KEY_LIKE_FOTO = "https://api.instagram.com/v1/media/{idFoto}/likes";
}
