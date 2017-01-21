package org.jrvivanco.mascotita;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import org.jrvivanco.mascotita.restApi.ConstantesRestApi;

public class ConfigurarCuenta extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

        //Habilitar que funcione la flecha de regreso
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnGuardarCuenta = (Button) findViewById(R.id.btnGuardarCuenta);
        btnGuardarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText txtNombreUsuario = (TextInputEditText) findViewById(R.id.txtNombreUsuario);
                String txtUsuario = txtNombreUsuario.getText().toString();
                String id_user;
                boolean flag = false;
                switch (txtUsuario.trim()){
                    case "juravica2016":
                        id_user = "4393478762";
                        flag = true;
                        break;
                    default:
                        id_user = "1780067551";
                        flag = false;
                        break;
                }

                if(flag){
                    Toast.makeText(ConfigurarCuenta.this, "Usuario "+ txtUsuario + " configurado.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ConfigurarCuenta.this, "Usuario no valido... ", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(ConfigurarCuenta.this, MainActivity.class);
                ConstantesRestApi.ID_USER = id_user;
                startActivity(intent);
                finish();
            }
        });

    }
}
