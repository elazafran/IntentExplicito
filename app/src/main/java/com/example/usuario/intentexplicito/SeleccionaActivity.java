package com.example.usuario.intentexplicito;

import android.app.ListActivity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 *
 * Extendemos de ListActivity para utilizar los valores por defecto de android y
 * el identificador de la vista que hemos puesto en el xml el onCreate no lo necesitamos
 *
 * para controlar el evento utilizamos la implementación de ListView.OnItemClickListener y sus metodos correspondientes
 *
 */
public class SeleccionaActivity extends ListActivity implements ListView.OnItemClickListener{
    private String [] provincias = {"Córdoba","Sevilla","Huelva","Almería","Jaen","Granada","Malaga","Cádiz"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciona);



        //utlizamos el listview de android por eso esa forma de llamarlo
        ListView lv = (ListView) findViewById(android.R.id.list);

        //le pasamos los datos en el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.fila,provincias);
        setListAdapter(adapter);

        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();

        //preparamos la respuesta y hay dos maneras de comunicarse, es un diccionario, clave valor
        //primer item es la clave
        //utilizamos el metodo estatcio de string para convertir
        intent.putExtra("PROVINCIA",provincias[position]);

        //utilizamos las constantes por defecto del sistema android
        setResult(RESULT_OK,intent);

        //ahora solo queda hacer un finish par a terminar y avisar a la app
        finish();
    }

}
