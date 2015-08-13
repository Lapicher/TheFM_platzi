package com.example.lapicher.thefm;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lapicher.thefm.ui.HypedArtistsFragment;


public class MainActivity extends ActionBarActivity {

    // recomendacion para debuguear.
    //public static final String LOG_TAG=HypedArtistsFragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            Conectar fragmento con actividad
         */
        getSupportFragmentManager().beginTransaction()
                // se añade un fragmento dentro de nuestro contenedor principal
                .add(R.id.main_container,new HypedArtistsFragment())
                //.add( se puede agregar otro fragmento siguiendo utilizando el Add)
                .commit();
    }
}
