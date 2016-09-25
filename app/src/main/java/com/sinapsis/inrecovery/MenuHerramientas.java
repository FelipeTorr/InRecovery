package com.sinapsis.inrecovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuHerramientas extends AppCompatActivity {
    boolean soynuevo;
    int adiccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_herramientas);
        soynuevo=getIntent().getBooleanExtra("Soynuevo",false);
        TextView titulo=(TextView)findViewById(R.id.titulo_menuadicciones);
        if (soynuevo==true){
           titulo.setText(getResources().getString(R.string.soyadicto));
        }
        else
        {
            titulo.setText(getResources().getString(R.string.herramientasrecuperacion));
        }
    }
    public void Herramienta_click(View view){
        if (soynuevo==true){
            //Diagnosticos
        switch(view.getId()) {

            case R.id.imagen_adiccion0:
            case R.id.adiccion0:
                adiccion=0;
                break;
            case R.id.imagen_adiccion1:
            case R.id.adiccion1:
                adiccion=1;
                break;
            case R.id.imagen_adiccion2:
            case R.id.adiccion2:
                adiccion=2;
                break;
            case R.id.imagen_adiccion3:
            case R.id.adiccion3:
                adiccion=3;
                break;
            case R.id.imagen_adiccion4:
            case R.id.adiccion4:
                adiccion=4;
                break;

    }
            Intent i=new Intent(MenuHerramientas.this,Diagnostico.class);
            i.putExtra("Adiccion",adiccion);
            startActivity(i);
        }
            //Herramientas
            else{
            switch(view.getId()) {

                case R.id.imagen_adiccion0:
                case R.id.adiccion0:
                    adiccion=0;
                    break;
                case R.id.imagen_adiccion1:
                case R.id.adiccion1:
                    adiccion=1;
                    break;
                case R.id.imagen_adiccion2:
                case R.id.adiccion2:
                    adiccion=2;
                    break;
                case R.id.imagen_adiccion3:
                case R.id.adiccion3:
                    adiccion=3;
                    break;
                case R.id.imagen_adiccion4:
                case R.id.adiccion4:
                    adiccion=4;
                    break;

            }
            Intent i=new Intent(MenuHerramientas.this,Herramientas.class);
            i.putExtra("Adiccion",adiccion);
            startActivity(i);
    }
}
}

