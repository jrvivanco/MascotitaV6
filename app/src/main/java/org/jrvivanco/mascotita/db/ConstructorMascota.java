package org.jrvivanco.mascotita.db;

import android.content.ContentValues;
import android.content.Context;
import java.util.ArrayList;
import org.jrvivanco.mascotita.R;
import org.jrvivanco.mascotita.pojo.Mascota;

/**
 * Created by jrvivanco on 22/12/2016.
 */
public class ConstructorMascota {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascota(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        if(db.estaVacio()){
            insertarMascotas(db);
        }
        return db.obtenerTodasLasMascotas();
    }

    public ArrayList<Mascota> obtenerDatosMascota()
    {
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Ashera");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.ashera);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Maine Coon");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.maine_coon);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Persa");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.persa);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Ragdoll");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.ragdoll);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Ruso Azul");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.ruso_azul);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Siames");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.siames);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Siberiano");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.siberiano);
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PETS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PETS_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}
