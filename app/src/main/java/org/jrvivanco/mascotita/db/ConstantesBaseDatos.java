package org.jrvivanco.mascotita.db;

/**
 * Created by jrvivanco on 22/12/2016.
 */
public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotita";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PETS           = "mascota";
    public static final String TABLE_PETS_ID        = "id";
    public static final String TABLE_PETS_NOMBRE    = "nombre";
    public static final String TABLE_PETS_FOTO      = "foto";

    public static final String TABLE_LIKES_PETS = "likes";
    public static final String TABLE_LIKES_PETS_ID = "id";
    public static final String TABLE_LIKES_PETS_ID_MASCOTA = "id_mascota";
    public static final String TABLE_LIKES_PETS_NUMERO_LIKES = "num_likes";
}
