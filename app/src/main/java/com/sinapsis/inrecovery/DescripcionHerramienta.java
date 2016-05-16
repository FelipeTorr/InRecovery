package com.sinapsis.inrecovery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescripcionHerramienta extends AppCompatActivity {
    String titulo;
    String enlace;
    String descripcion;
    int imagen;
    int adiccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_herramienta);
        titulo=getIntent().getStringExtra("Titulo");
        enlace=getIntent().getStringExtra("Enlace");
        descripcion=getIntent().getStringExtra("Descripcion");
        adiccion=getIntent().getIntExtra("Adiccion",0);
        imagen=getIntent().getIntExtra("Imagen",R.drawable.test);
        //elementos de pantalla
        TextView titulotxt=(TextView)findViewById(R.id.titulo);
        TextView enlacetxt=(TextView)findViewById(R.id.enlace);
        TextView descripciontxt=(TextView)findViewById(R.id.descripcion);
        ImageView image=(ImageView)findViewById(R.id.imagen_herramienta);

        titulotxt.setText(titulo);
        enlacetxt.setText(enlace);
        descripciontxt.setText(descripcion);
        image.setImageDrawable(getResources().getDrawable(imagen));
    }
}
