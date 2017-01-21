package org.jrvivanco.mascotita;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.jrvivanco.mascotita.adapter.PageAdapter;
import org.jrvivanco.mascotita.fragment.PerfilFragment;
import org.jrvivanco.mascotita.fragment.RecyclerViewFragment;
import org.jrvivanco.mascotita.restApi.ConstantesRestApi;
import org.jrvivanco.mascotita.restApi.IEndPointsApi;
import org.jrvivanco.mascotita.restApi.adapter.RestApiAdapter;
import org.jrvivanco.mascotita.restApi.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.barraSub);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(v, "Mi FloatingActionButton haciendo una accion",Snackbar.LENGTH_LONG).setAction("Accion", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.menuActionContacto:
                Intent intent1 = new Intent(MainActivity.this, ContactoActivity.class);
                startActivity(intent1);
                break;
            case R.id.menuActionAcercaDe:
                Intent intent2 = new Intent(MainActivity.this, AcercaDeActivity.class);
                startActivity(intent2);
                break;
            case R.id.menuActionFavorito:
                Intent intent3 = new Intent(MainActivity.this, FavoritosActivity.class);
                startActivity(intent3);
                break;
            case R.id.menuConfigurarCuenta:
                Intent intent4 = new Intent(MainActivity.this, ConfigurarCuenta.class);
                startActivity(intent4);
                break;
            case R.id.mnuRecibirNotificacion:
                // Get token
                String token = FirebaseInstanceId.getInstance().getToken();
                enviarTokenRegistroServidor(token);

                // Log and toast
                //String msg = getString(R.string.msg_token_fmt, token);
                Log.d("MENU Token: ", token);
                //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_mascotas);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }

    private void enviarTokenRegistroServidor(String token){
        Log.d("TOKEN", "Token a enviar: " + token);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        IEndPointsApi endpoints = restApiAdapter.establecerConexionMiRestAPI();
        Call<UsuarioResponse> usuarioResponseCall = endpoints.registrarUsuario(token, ConstantesRestApi.ID_USERNAME);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                Log.d("Id_dispositivo", usuarioResponse.getId_dispositivo());
                Log.d("Id_usuario_instagram", usuarioResponse.getId_usuario_instagram());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }
 }
