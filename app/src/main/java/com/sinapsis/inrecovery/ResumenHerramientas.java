package com.sinapsis.inrecovery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ResumenHerramientas extends AppCompatActivity {
    int adiccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_herramientas);
        adiccion=getIntent().getIntExtra("Adiccion",0);
        switch(adiccion){


        }
    }
}
