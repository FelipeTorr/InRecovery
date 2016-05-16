package com.sinapsis.inrecovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultadoPositivo extends AppCompatActivity {
    int adiccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_positivo);
        //Obtener el parámetro de la activity anterior
        adiccion=getIntent().getIntExtra("Adiccion",0);
        //Elementos de la pantalla
        TextView texto=(TextView) findViewById(R.id.soyadicto);
        switch(adiccion){
            case 0:
                texto.setText(getResources().getText(R.string.adicto0));
                break;
            case 1:
                texto.setText(getResources().getText(R.string.adicto1));
                break;
            case 2:
                texto.setText(getResources().getText(R.string.adicto2));
                break;
            case 3:
                texto.setText(getResources().getText(R.string.adicto3));
                break;
            case 4:
                texto.setText(getResources().getText(R.string.adicto4));
                break;
        }
    }
    public void Button_Click(View v) {
        Intent i;
        switch(v.getId()){
            case R.id.siquiero:
                i=new Intent(ResultadoPositivo.this,Herramientas.class);
                i.putExtra("Adiccion",adiccion);
                startActivity(i);
                break;
            case R.id.denuevo:
                i=new Intent(ResultadoPositivo.this,Diagnostico.class);
                i.putExtra("Adiccion",adiccion);
                startActivity(i);
                break;
            case R.id.noquiero:
                i=new Intent(ResultadoPositivo.this,Seleccion.class);
                i.putExtra("Adiccion",adiccion);
                startActivity(i);
                break;
        }
    }
}
