package com.example.usuario.intentexplicito;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 *
 * La idea es comunicarnos con otro activity y que interacione con el usuario y selecione algo para recoger este dato de vuleta a la actividad
 *
 */

public class MainActivity extends AppCompatActivity {

    public static final int SELECCIONE_PROVINCIA=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pulsado(View v){
        Intent intent = new Intent(this, SeleccionaActivity.class);
        startActivityForResult(intent,SELECCIONE_PROVINCIA);
    }

    //buscamos este metodo generate o extender de activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView tvFila = (TextView) findViewById(R.id.tvProvincia);

        if(requestCode == SELECCIONE_PROVINCIA){

          if(resultCode==RESULT_OK){
              //usamos este metodo pq ya sabemos que guarda una cadena de caracteres
              tvFila.setText(data.getStringExtra("PROVINCIA"));
          }

        }
    }
}
