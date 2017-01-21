package org.jrvivanco.mascotita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.jrvivanco.mascotita.pojo.Mail;

public class ContactoActivity extends AppCompatActivity {

    private Button botonEnviarCorreo;
    private EditText nombre, email, mensaje;
    private String user, pass, emailUsuario, nombreUsuario, mensajeUsuario;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarSub);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(ContactoActivity.this,"Mensaje de prueba",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        botonEnviarCorreo = (Button) findViewById(R.id.btn_EnviarMensaje);
        nombre = (EditText) findViewById(R.id.editNombre);
        email = (EditText) findViewById(R.id.editEmail);
        mensaje = (EditText) findViewById(R.id.editComentario);

        botonEnviarCorreo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nombreUsuario = nombre.getText().toString();
                emailUsuario = email.getText().toString();
                mensajeUsuario = mensaje.getText().toString();

                Intent sendEmail = new Intent(Intent.ACTION_SEND);
                sendEmail.setType("plain/text");
                sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{emailUsuario});
                sendEmail.putExtra(Intent.EXTRA_TEXT, mensajeUsuario);
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Mensaje enviado desde APP por " + nombreUsuario);
                startActivity(Intent.createChooser(sendEmail, "Elige una aplicación: "));
            }
        });
    }
}