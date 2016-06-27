package com.jorgearreola.fragments;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

    public static final String EXTRA_TEXTO =
            "net.sgoliver.android.com.jarreola.fragments.EXTRA_TEXTO";
    public static final String EXTRA_TEXT1 =
            "net.sgoliver.android.com.jarreola.fragments.EXTRA_TEXT1";
    public static final String EXTRA_TEXT2 =
            "net.sgoliver.android.com.jarreola.fragments.EXTRA_TEXT2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        FragmentDetalle detalle =
                (FragmentDetalle)getSupportFragmentManager()
                        .findFragmentById(R.id.FrgDetalle);

        detalle.mostrarNombre(getIntent().getStringExtra(EXTRA_TEXTO));
        detalle.mostrarTwitter(getIntent().getStringExtra(EXTRA_TEXT1));
        detalle.mostrarTelefono(getIntent().getStringExtra(EXTRA_TEXT2));
    }
}
