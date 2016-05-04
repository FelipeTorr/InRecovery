package com.sinapsis.inrecovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Glosario extends AppCompatActivity {
    int adiccion;
    boolean isglosario;
    int contador=0;
    int k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glosario);
        adiccion=getIntent().getIntExtra("Adiccion",0);
        isglosario=getIntent().getBooleanExtra("IsGlosario",false);
        //elementos pantalla
        TextView titulo=(TextView)findViewById(R.id.tituloactividad);
        final ViewFlipper flipper1=(ViewFlipper)findViewById(R.id.tituloflipper);
        final ViewFlipper flipper2=(ViewFlipper)findViewById(R.id.contenidoflipper);
        Button saltar=(Button) findViewById(R.id.saltar);
        Button siguiente=(Button) findViewById(R.id.siguiente);

        if (isglosario){
            titulo.setText(getResources().getText(R.string.glosario));
            flipper1.showNext();
            for (k=0;k<10;k++){
                flipper2.showNext();
            }

            //click al boton saltar
            saltar.setOnClickListener(
                    new Button.OnClickListener() {
                        public void onClick(View v) {
                            Glosario.this.finish();;
                        }
                    }
            );
            //Evento  click al botón siguiente
            siguiente.setOnClickListener(
                    new Button.OnClickListener() {
                        public void onClick(View v) {
                            flipper1.showNext();
                            flipper2.showNext();
                            contador++;
                            if (contador>=8){
                                contador=0;
                            flipper1.showNext();
                                for (k=0;k<10;k++){
                                    flipper2.showNext();
                                }
                            }
                        }
                    }
            );
        }
        //Mostrar Extracto de TBLNC
        else{
            titulo.setText(getResources().getText(R.string.adiccion));
            //click al boton saltar
            saltar.setOnClickListener(
                    new Button.OnClickListener() {
                        public void onClick(View v) {
                            Intent i=new Intent(Glosario.this,ResumenHerramientas.class);
                            startActivity(i);
                        }
                    }
            );
            //Evento  click al botón siguiente
            siguiente.setOnClickListener(
                    new Button.OnClickListener() {
                        public void onClick(View v) {
                            contador++;
                            if (contador>=10){
                                Intent i=new Intent(Glosario.this,ResumenHerramientas.class);
                                startActivity(i);
                            }
                            flipper2.showNext();


                        }
                    }
            );
        }




    }
}
