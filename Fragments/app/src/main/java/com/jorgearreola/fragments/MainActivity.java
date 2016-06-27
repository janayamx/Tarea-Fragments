package com.jorgearreola.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity
        implements FragmentListado.AmigosListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentListado frgListado =
                (FragmentListado)getSupportFragmentManager()
                        .findFragmentById(R.id.FrgListado);

        frgListado.setAmigosListener(this);
    }

    @Override
    public void onAmigoSeleccionado(Amigo c) {
        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById(R.id.FrgDetalle) != null);

        if(hayDetalle) {
            ((FragmentDetalle)getSupportFragmentManager()
                    .findFragmentById(R.id.FrgDetalle)).mostrarNombre(c.getNombre());

            ((FragmentDetalle)getSupportFragmentManager()
                    .findFragmentById(R.id.FrgDetalle)).mostrarTwitter(c.getTwitter());
            ((FragmentDetalle)getSupportFragmentManager()
                    .findFragmentById(R.id.FrgDetalle)).mostrarTelefono(c.getTelefono());

        }
        else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, c.getNombre());
            i.putExtra(DetalleActivity.EXTRA_TEXT1, c.getTwitter());
            i.putExtra(DetalleActivity.EXTRA_TEXT2, c.getTelefono());
            startActivity(i);
        }
    }
}
