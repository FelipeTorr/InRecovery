package com.sinapsis.inrecovery;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class Seleccion extends AppCompatActivity {
    public int adiccion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        Spinner adicciones=(Spinner) findViewById(R.id.adicciones);
        final ImageView imagen=(ImageView)findViewById(R.id.imagenseleccion);
        // Crear adaptador para spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.adicciones));
        adicciones.setAdapter(dataAdapter);
        //Accion al seleccionar un item
        adicciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                // Cambiar imagen según la adicción seleccionada
                switch(pos){
                    case 0:
                    adiccion=0;
                        imagen.setImageResource(R.drawable.cara1);
                        break;
                    case 1:
                        adiccion=1;
                        imagen.setImageResource(R.drawable.cara2);
                        break;
                    case 2:
                        adiccion=2;
                        imagen.setImageResource(R.drawable.cara3);
                        break;
                    case 3:
                        adiccion=3;
                        imagen.setImageResource(R.drawable.cara4);
                        break;
                    case 4:
                        adiccion=4;
                        imagen.setImageResource(R.drawable.cara5);
                        break;

                }

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }




        }
