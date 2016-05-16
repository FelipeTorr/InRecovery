package com.sinapsis.inrecovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Bienvenida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Coloca el contenido del layout en pantalla al crar la activity
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bienvenida);
        //Declaración de variables privadas
        Button nuevo=(Button) findViewById(R.id.nuevo);
        Button veterano=(Button) findViewById(R.id.veterano);
        //Evento click al botón nuevo
        nuevo.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i=new Intent(Bienvenida.this,Seleccion.class);
                        startActivity(i);
                    }
                }
        );
        //Evento  click al botón ya tengo cuenta
        veterano.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i=new Intent(Bienvenida.this,MenuHerramientas.class);
                        startActivity(i);
                    }
                }
        );
    }
    public void Mas_click(View v){
        Intent i=new Intent(Bienvenida.this,Herramientas.class);
        i.putExtra("Adiccion",1);
        startActivity(i);
    }

}
