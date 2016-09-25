package com.sinapsis.inrecovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        ImageView imagen_addiccion=(ImageView)findViewById(R.id.imagen_adiccion);

        titulotxt.setText(titulo);
        enlacetxt.setText(enlace);
        descripciontxt.setText(descripcion);
        image.setImageDrawable(getResources().getDrawable(imagen));
        switch (adiccion){
            case 0:
            imagen_addiccion.setImageDrawable(getResources().getDrawable(R.drawable.icono_drogas));
                break;
            case 1:
                imagen_addiccion.setImageDrawable(getResources().getDrawable(R.drawable.icono_trabajo));
                break;
            case 2:
                imagen_addiccion.setImageDrawable(getResources().getDrawable(R.drawable.icono_deudas));
                break;
            case 3:
                imagen_addiccion.setImageDrawable(getResources().getDrawable(R.drawable.icono_neurosis));
                break;
            case 4:
                imagen_addiccion.setImageDrawable(getResources().getDrawable(R.drawable.icono_sexoyamor));
                break;

        }
    }
    public void Button_Click(View view){
        switch(view.getId()) {
            case R.id.lo_hice:
                Intent i=new Intent(DescripcionHerramienta.this,Feedback.class);
                startActivity(i);
                break;
            case R.id.regresar:
                this.finish();
        }

    }
}
