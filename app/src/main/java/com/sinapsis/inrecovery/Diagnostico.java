package com.sinapsis.inrecovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

public class Diagnostico extends AppCompatActivity {
    int adiccion;
    byte[] sies=new byte[30];
    byte[] noes=new byte[30];
    int si=0;
    int no=0;
    int total;
    int j;
    ScrollView scroll;
    boolean bandera=false; //bandera para que no se repita la pantalla de admisión rápida.
	boolean banderafinal=false; //bandera para saber si se respondio la ultima pregunta.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico);
        //Obtener el parámetro de la activity anterior
        adiccion=getIntent().getIntExtra("Adiccion",0);
        //Elementos de la pantalla
        TextView titulo=(TextView)findViewById(R.id.diagnostico);
        TextView enlace=(TextView)findViewById(R.id.enlace_diagnostico);
        TextView numero=(TextView)findViewById(R.id.n_preguntas);
        LinearLayout cabecera=(LinearLayout)findViewById(R.id.cabecera_diagnostico);
        LinearLayout conteo=(LinearLayout)findViewById(R.id.conteo);
        scroll=(ScrollView) findViewById(R.id.scrolldiagnostico);
        //Layout dinámico según la adicción
        ViewGroup layout = (ViewGroup) findViewById(R.id.contenedor_diagnostico);
        LayoutInflater inflater = LayoutInflater.from(Diagnostico.this);
        LinearLayout layoutdiagnostico;
        switch (adiccion){
            case 0:
                titulo.setText(getText(R.string.diagnostico0));
                enlace.setText(getText(R.string.enlace_diagnostico0));
                numero.setText(getText(R.string.nresp0));
                cabecera.setBackgroundColor(getResources().getColor(R.color.colornarc_anon));
                conteo.setBackgroundColor(getResources().getColor(R.color.colornarc_anon2));
                layoutdiagnostico= (LinearLayout) inflater.inflate(R.layout.diagnostico_drogas, null, false);
                layout.addView(layoutdiagnostico);
                break;
            case 1:
                titulo.setText(getText(R.string.diagnostico1));
                titulo.setTextColor(getResources().getColor(R.color.colorGris3));
                enlace.setText(getText(R.string.enlace_diagnostico1));
                enlace.setTextColor(getResources().getColor(R.color.colorGris3));
                numero.setText(getText(R.string.nresp1));
                numero.setTextColor(getResources().getColor(R.color.colorGris3));
                cabecera.setBackgroundColor(getResources().getColor(R.color.colortrab_anon));
                conteo.setBackgroundColor(getResources().getColor(R.color.colortrab_anon2));
                layoutdiagnostico = (LinearLayout) inflater.inflate(R.layout.diagnostico_trabajo, null, false);
                layout.addView(layoutdiagnostico);
                break;
            case 2:
                titulo.setText(getText(R.string.diagnostico2));
                enlace.setText(getText(R.string.enlace_diagnostico2));
                numero.setText(getText(R.string.nresp2));
                cabecera.setBackgroundColor(getResources().getColor(R.color.colordeud_anon));
                conteo.setBackgroundColor(getResources().getColor(R.color.colordeud_anon2));
                layoutdiagnostico = (LinearLayout) inflater.inflate(R.layout.diagnostico_deudas, null, false);
                layout.addView(layoutdiagnostico);
                break;
            case 3:
                titulo.setText(getText(R.string.diagnostico3));
                enlace.setText(getText(R.string.enlace_diagnostico3));
                numero.setText(getText(R.string.nresp3));
                cabecera.setBackgroundColor(getResources().getColor(R.color.colorneur_anon));
                conteo.setBackgroundColor(getResources().getColor(R.color.colorneur_anon2));
                 layoutdiagnostico = (LinearLayout) inflater.inflate(R.layout.diagnostico_neurosis, null, false);
                layout.addView(layoutdiagnostico);
                break;
            case 4:
                titulo.setText(getText(R.string.diagnostico4));
                enlace.setText(getText(R.string.enlace_diagnostico4));
                numero.setText(getText(R.string.nresp4));
                cabecera.setBackgroundColor(getResources().getColor(R.color.colorsex_anon));
                conteo.setBackgroundColor(getResources().getColor(R.color.colorsex_anon2));
                layoutdiagnostico = (LinearLayout) inflater.inflate(R.layout.diagnostico_sexoyamor, null, false);
                layout.addView(layoutdiagnostico);
                break;

        }
    }
    public void ImageClick(View view) {
    int y;
    int maxY;
        maxY=scroll.getBottom()*3;
        y=scroll.getScrollY();
        if ((y+100)<maxY) {
            scroll.setScrollY(y + 100);
        }

    }
    public void RadioButtonClick(View view) {
        //Elementos a cambiar en pantalla
        TextView n_no=(TextView)findViewById(R.id.n_no);
        TextView n_si=(TextView)findViewById(R.id.n_si);
        // Comprobar si se ha seleccionado
        boolean checked = ((RadioButton) view).isChecked();
        // Acciones segun cual es el botón seleccionado
        switch(view.getId()) {
            case R.id.si1:
                if (checked){
                    sies[0]=1;
                    noes[0]=0;}
                break;
            case R.id.no1:
                if (checked){
                    sies[0]=0;
                    noes[0]=1;}
                break;
            case R.id.si2:
                if (checked){
                    sies[1]=1;
                    noes[1]=0;}
                break;
            case R.id.no2:
                if (checked){
                    sies[1]=0;
                    noes[1]=1;}
                break;
            case R.id.si3:
                if (checked){
                    sies[2]=1;
                    noes[2]=0;}
                break;
            case R.id.no3:
                if (checked){
                    sies[2]=0;
                    noes[2]=1;}
                break;
            case R.id.si4:
                if (checked){
                    sies[3]=1;
                    noes[3]=0;}
                break;
            case R.id.no4:
                if (checked){
                    sies[3]=0;
                    noes[3]=1;}
                break;
            case R.id.si5:
                if (checked){
                    sies[4]=1;
                    noes[4]=0;}
                break;
            case R.id.no5:
                if (checked){
                    sies[4]=0;
                    noes[4]=1;}
                break;
            case R.id.si6:
                if (checked){
                    sies[5]=1;
                    noes[5]=0;}
                break;
            case R.id.no6:
                if (checked){
                    sies[5]=0;
                    noes[5]=1;}
                break;
            case R.id.si7:
                if (checked){
                    sies[6]=1;
                    noes[6]=0;}
                break;
            case R.id.no7:
                if (checked){
                    sies[6]=0;
                    noes[6]=1;}
                break;
            case R.id.si8:
                if (checked){
                    sies[7]=1;
                    noes[7]=0;}
                break;
            case R.id.no8:
                if (checked){
                    sies[7]=0;
                    noes[7]=1;}
                break;
            case R.id.si9:
                if (checked){
                    sies[8]=1;
                    noes[8]=0;}
                break;
            case R.id.no9:
                if (checked){
                    sies[8]=0;
                    noes[8]=1;}
                break;
            case R.id.si10:
                if (checked){
                    sies[9]=1;
                    noes[9]=0;}
                break;
            case R.id.no10:
                if (checked){
                    sies[9]=0;
                    noes[9]=1;}
                break;
            case R.id.si11:
                if (checked){
                    sies[10]=1;
                    noes[10]=0;}
                break;
            case R.id.no11:
                if (checked){
                    sies[10]=0;
                    noes[10]=1;}
                break;
            case R.id.si12:
                if (checked){
                    sies[11]=1;
                    noes[11]=0;}
                break;
            case R.id.no12:
                if (checked){
                    sies[11]=0;
                    noes[11]=1;}
                break;
            case R.id.si13:
                if (checked){
                    sies[12]=1;
                    noes[12]=0;}
                break;
            case R.id.no13:
                if (checked){
                    sies[12]=0;
                    noes[12]=1;}
                break;
            case R.id.si14:
                if (checked){
                    sies[13]=1;
                    noes[13]=0;}
                break;
            case R.id.no14:
                if (checked){
                    sies[13]=0;
                    noes[13]=1;}
                break;
            case R.id.si15:
                if (checked){
                    sies[14]=1;
                    noes[14]=0;}
                break;
            case R.id.no15:
                if (checked){
                    sies[14]=0;
                    noes[14]=1;}
                break;
            case R.id.si16:
                if (checked){
                    sies[15]=1;
                    noes[15]=0;}
                break;
            case R.id.no16:
                if (checked){
                    sies[15]=0;
                    noes[15]=1;}
                break;
            case R.id.si17:
                if (checked){
                    sies[16]=1;
                    noes[16]=0;}
                break;
            case R.id.no17:
                if (checked){
                    sies[16]=0;
                    noes[16]=1;}
                break;
            case R.id.si18:
                if (checked){
                    sies[17]=1;
                    noes[17]=0;}
                break;
            case R.id.no18:
                if (checked){
                    sies[17]=0;
                    noes[17]=1;}
                break;
            case R.id.si19:
                if (checked){
                    sies[18]=1;
                    noes[18]=0;}
                break;
            case R.id.no19:
                if (checked){
                    sies[18]=0;
                    noes[18]=1;}
                break;
            case R.id.si20:
                if (checked){
                    sies[19]=1;
                    noes[19]=0;}
                break;
            case R.id.no20:
                if (checked){
                    sies[19]=0;
                    noes[19]=1;
                    banderafinal=true;}
                break;
            case R.id.si21:
                if (checked){
                    sies[20]=1;
                    noes[20]=0;
                    banderafinal=true;}
                break;
            case R.id.no21:
                if (checked){
                    sies[20]=0;
                    noes[20]=1;}
                break;
            case R.id.si22:
                if (checked){
                    sies[21]=1;
                    noes[21]=0;}
                break;
            case R.id.no22:
                if (checked){
                    sies[21]=0;
                    noes[21]=1;}
                break;
            case R.id.si23:
                if (checked){
                    sies[22]=1;
                    noes[22]=0;}
                break;
            case R.id.no23:
                if (checked){
                    sies[22]=0;
                    noes[22]=1;}
                break;
            case R.id.si24:
                if (checked){
                    sies[23]=1;
                    noes[23]=0;}
                break;
            case R.id.no24:
                if (checked){
                    sies[23]=0;
                    noes[23]=1;}
                break;
            case R.id.si25:
                if (checked){
                    sies[24]=1;
                    noes[24]=0;}
                break;
            case R.id.no25:
                if (checked){
                    sies[24]=0;
                    noes[24]=1;}
                break;
            case R.id.si26:
                if (checked){
                    sies[25]=1;
                    noes[25]=0;}
                break;
            case R.id.no26:
                if (checked){
                    sies[25]=0;
                    noes[25]=1;}
                break;
            case R.id.si27:
                if (checked){
                    sies[26]=1;
                    noes[26]=0;}
                break;
            case R.id.no27:
                if (checked){
                    sies[26]=0;
                    noes[26]=1;}
                break;
            case R.id.si28:
                if (checked){
                    sies[27]=1;
                    noes[27]=0;}
                break;
            case R.id.no28:
                if (checked){
                    sies[27]=0;
                    noes[27]=1;}
                break;
            case R.id.si29:
                if (checked){
                    sies[28]=1;
                    noes[28]=0;
                    banderafinal=true;}
                break;
            case R.id.no29:
                if (checked){
                    sies[28]=0;
                    noes[28]=1;
                    banderafinal=true;}
                break;
            case R.id.si30:
                if (checked){
                    sies[29]=1;
                    noes[29]=0;
					banderafinal=true;
					}
                break;
            case R.id.no30:
                if (checked){
                    sies[29]=0;
                    noes[29]=1;
					banderafinal=true;}
                break;
        }
        si=0;
        no=0;
        for(j=0;j<30;j++){
            si=si+sies[j];
            no=no+noes[j];
        }
        total=si+no;
        try{
            n_no.setText(Integer.toString(no));
            n_si.setText(Integer.toString(si));}
        catch (NullPointerException ignored){

        }
        //Pantalla de admitir la adicción
            if (si==2 && !bandera){
                //codigo aqui//
                bandera=true;
            }
		if (banderafinal==true){
        switch(adiccion){
            case 0:
                if (total>=29) {
                    if (si > 9) {
                        //Resultado positivo
                        Intent i = new Intent(Diagnostico.this, ResultadoPositivo.class);
                        i.putExtra("Adiccion", adiccion);
                        startActivity(i);
                    } else {
                        //Resultado negativo
                        Intent i = new Intent(Diagnostico.this, ResultadoNegativo.class);
                        i.putExtra("Adiccion", adiccion);
                        startActivity(i);
                    }
                }
				else{
				//Toast de que falta contestar 29-total preguntas.
				}
                break;
            case 1:
                if (total>=20) {
                    if (si > 3) {
                        //Resultado positivo
                        Intent i = new Intent(Diagnostico.this, ResultadoPositivo.class);
                        i.putExtra("Adiccion", adiccion);
                        startActivity(i);
                    } else {
                        //Resultado negativo
                        Intent i = new Intent(Diagnostico.this, ResultadoNegativo.class);
                        i.putExtra("Adiccion", adiccion);
                        startActivity(i);
                    }
                }
				else{
				//Toast de que falta contestar 29-total preguntas.
				}
                break;
            case 2:
                if (total>=15) {
                    if (si > 7) {
                        //Resultado positivo
                        Intent i = new Intent(Diagnostico.this, ResultadoPositivo.class);
                        i.putExtra("Adiccion", adiccion);
                        startActivity(i);
                    } else {
                        //Resultado negativo
                        Intent i = new Intent(Diagnostico.this, ResultadoNegativo.class);
                        i.putExtra("Adiccion", adiccion);
                        startActivity(i);
                    }
                }
				else{
				//Toast de que falta contestar 29-total preguntas.
				}
                break;
            case 3:
                if (total>=24) {
                    if (si > 3) {
                        //Resultado positivo
                        Intent i = new Intent(Diagnostico.this, ResultadoPositivo.class);
                        i.putExtra("Adiccion", adiccion);
                        startActivity(i);
                    } else {
                        //Resultado negativo
                        Intent i = new Intent(Diagnostico.this, ResultadoNegativo.class);
                        i.putExtra("Adiccion", adiccion);
                        startActivity(i);
                    }
                }
				else{
				//Toast de que falta contestar 29-total preguntas.
				}
                break;
            case 4:
                if (total>=30) {
                    if (si > 9) {
                        //Resultado positivo
                        Intent i = new Intent(Diagnostico.this, ResultadoPositivo.class);
                        i.putExtra("Adiccion", adiccion);
                        startActivity(i);
                    } else {
                        //Resultado negativo
                        Intent i = new Intent(Diagnostico.this, ResultadoNegativo.class);
                        i.putExtra("Adiccion", adiccion);
                        startActivity(i);
                    }
                }
				else{
				//Toast de que falta contestar 29-total preguntas.
				}
                break;
        }

    }
	}
}
