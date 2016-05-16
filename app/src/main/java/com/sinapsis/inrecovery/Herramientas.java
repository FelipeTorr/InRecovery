package com.sinapsis.inrecovery;

import android.content.Intent;
import android.media.FaceDetector;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Herramientas extends AppCompatActivity {
    int adiccion;
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herramientas);
        adiccion=getIntent().getIntExtra("Adiccion",0);
        //FaceDetector fd=new FaceDetector()
        //Elementos de la pantalla
        lista = (ListView) findViewById(R.id.lista_herramientas);
        ArrayList<Herramienta_Item> datos = new ArrayList<Herramienta_Item>();
        datos.add(new Herramienta_Item(R.string.herramientas1,R.string.herramientas1, R.drawable.icono_reunion, R.color.background4));
        datos.add(new Herramienta_Item(R.string.herramientas2,R.string.herramientas2, R.drawable.icono_padrinazgo, R.color.background2));
        datos.add(new Herramienta_Item(R.string.herramientas3,R.string.herramientas3, R.drawable.icono_lectura, R.color.background4));
        datos.add(new Herramienta_Item(R.string.herramientas4,R.string.herramientas4, R.drawable.icono_servicio, R.color.background2));

        //Adaptador para la lisa
        lista.setAdapter(new AdaptadorLista(this, R.layout.herramienta_item, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                TextView texto_superior_entrada = (TextView) view.findViewById(R.id.titulo_herramienta);
                texto_superior_entrada.setText(getResources().getString(((Herramienta_Item) entrada).titulo));
                ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imagen_herramienta);
                imagen_entrada.setImageResource(((Herramienta_Item) entrada).idImagen);
                imagen_entrada.setBackgroundColor(((Herramienta_Item)entrada).background);
                texto_superior_entrada.setBackgroundColor(((Herramienta_Item)entrada).background);
                view.setBackgroundColor(((Herramienta_Item)entrada).background);

            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Herramienta_Item elegido = (Herramienta_Item) pariente.getItemAtPosition(posicion);

                //CharSequence texto = "Seleccionado: " + elegido.descripcion;
                //Toast toast = Toast.makeText(Herramientas.this, texto, Toast.LENGTH_LONG);
                //toast.show();
                Intent i=new Intent(Herramientas.this,DescripcionHerramienta.class);
                i.putExtra("Adiccion",adiccion);
                i.putExtra("Titulo",getResources().getString(elegido.titulo));
                i.putExtra("Descripcion",getResources().getString(elegido.descripcion));
                i.putExtra("Imagen",elegido.idImagen);
                i.putExtra("Enlace",getResources().getString(elegido.enlace));
                startActivity(i);
            }
        });
    }
    }


