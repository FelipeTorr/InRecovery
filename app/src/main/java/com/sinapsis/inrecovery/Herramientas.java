package com.sinapsis.inrecovery;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Herramientas extends AppCompatActivity {
    int adiccion;
    int categoria;
    int puntaje_anterior;
    //banderas
    boolean[] sies=new boolean[10];
    boolean[] noes=new boolean[10];

    //para elementos de pantalla
    LinearLayout lista_especifica;
    ViewGroup layout;
    LayoutInflater inflater;
    TextView puntos;
    ImageView avatar;
    //Usuario, en este caso parap ruebas se crea aqui
    Usuario usuario=new Usuario("nombredelusuario",1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herramientas);
        adiccion=getIntent().getIntExtra("Adiccion",0);
        //FaceDetector fd=new FaceDetector()
        //Elementos de la pantalla
        inflater = LayoutInflater.from(Herramientas.this);
        layout = (ViewGroup)findViewById(R.id.layout_herramientas);
        puntos=(TextView)findViewById(R.id.puntos_herramientas);
        avatar=(ImageView)findViewById(R.id.avatar_herramientas);
        puntaje_anterior=usuario.puntaje;
        /***Listas**/
        /*lista_principal = (ListView) findViewById(R.id.lista_herramientas);
        ArrayList<Herramienta_Item> datos = new ArrayList<Herramienta_Item>();
        datos.add(new Herramienta_Item(R.string.herramientas1,R.string.herramientas1, R.drawable.icono_reunion, R.color.background4));
        datos.add(new Herramienta_Item(R.string.herramientas2,R.string.herramientas2, R.drawable.icono_padrinazgo, R.color.background2));
        datos.add(new Herramienta_Item(R.string.herramientas3,R.string.herramientas3, R.drawable.icono_lectura, R.color.background4));
        datos.add(new Herramienta_Item(R.string.herramientas4,R.string.herramientas4, R.drawable.icono_servicio, R.color.background2));

        //Listas Especificas
        final LayoutInflater inflater = LayoutInflater.from(Herramientas.this);

        //Adaptador para la lista de categorias
        lista_principal.setAdapter(new AdaptadorLista(this, R.layout.herramienta_item, datos){
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
        lista_principal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                LinearLayout lista_especifica;
                ViewGroup layout = (ViewGroup)findViewById(R.id.contenedor_herramientas);
                switch (posicion){
                    case 0:
                    lista_especifica=(LinearLayout) inflater.inflate(R.layout.lista_categoria, null, false);
                    layout.addView(lista_especifica);
                    ListView lista_categoria=(ListView)findViewById(R.id.lista_especifica);
                        ArrayList<Herramienta_Item> datos0 = new ArrayList<Herramienta_Item>();
                        datos0.add(new Herramienta_Item(R.string.hdrogas1t,R.string.hdrogas1e,R.string.hdrogas1d, R.drawable.icono_drogas, R.color.background3));
                        datos0.add(new Herramienta_Item(R.string.hdrogas2t,R.string.hdrogas2e,R.string.hdrogas2d, R.drawable.icono_padrinazgo, R.color.background3));
                        datos0.add(new Herramienta_Item(R.string.hdrogas3t,R.string.hdrogas3e,R.string.hdrogas3d, R.drawable.icono_lectura, R.color.background3));
                        datos0.add(new Herramienta_Item(R.string.hdrogas4t,R.string.hdrogas4e,R.string.hdrogas4d, R.drawable.icono_servicio, R.color.background3));
                        datos0.add(new Herramienta_Item(R.string.hdrogas5t,R.string.hdrogas5e,R.string.hdrogas5d, R.drawable.icono_servicio, R.color.background3));

                        //Adaptador para la lisa
                        assert lista_categoria != null;
                        lista_categoria.setAdapter(new AdaptadorLista(Herramientas.this, R.layout.herramienta_item, datos0){
                            @Override
                            public void onEntrada(Object entrada, View view) {
                                TextView texto_superior_entrada = (TextView) view.findViewById(R.id.titulo_herramienta);
                                texto_superior_entrada.setText(getResources().getString(((Herramienta_Item) entrada).titulo));
                                ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imagen_herramienta);
                                imagen_entrada.setImageResource(((Herramienta_Item) entrada).idImagen);
                                imagen_entrada.setBackgroundColor(((Herramienta_Item)entrada).background);
                                texto_superior_entrada.setBackgroundColor(((Herramienta_Item)entrada).background);
                                //view.setBackgroundColor(((Herramienta_Item)entrada).background);

                            }});

                        lista_categoria.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> pariente0, View view0, int posicion0, long id0) {
                                Herramienta_Item elegido = (Herramienta_Item) pariente0.getItemAtPosition(posicion0);
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



                break;
                }


            }
        });*/
        //Asignación del layout a mostrar y con addView() se muestra.
        lista_especifica=(LinearLayout) inflater.inflate(R.layout.menu_principal_herramientas, null, false);
        layout.addView(lista_especifica);

    }

    //Menu de Categorias
    public void Categoria_click(View view){

        Toast toast = Toast.makeText(Herramientas.this, "Seleccionado algo", Toast.LENGTH_SHORT);
        toast.show();
        switch (adiccion){
            case 0:
                switch (view.getId()){
                    case R.id.categoria1:
                        lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas1_drogas, null, false);
                        categoria=1;
                        toast = Toast.makeText(Herramientas.this, "Seleccionado reuniones", Toast.LENGTH_SHORT);
                        toast.show();
                        break;

                    case R.id.categoria2:
                        lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas2_drogas, null, false);
                        categoria=2;
                        toast = Toast.makeText(Herramientas.this, "Seleccionado pasos", Toast.LENGTH_SHORT);
                        toast.show();
                        break;

                    case R.id.categoria3:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas3_drogas, null, false);
                        categoria=3;
                        break;

                    case R.id.categoria4:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas4_drogas, null, false);
                        categoria=4;
                        break;
                }

                break;
            case 1:
                switch (view.getId()){
                    case R.id.categoria1:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas1_trabajo, null, false);
                        categoria=1;
                        break;

                    case R.id.categoria2:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas2_trabajo, null, false);
                        categoria=2;
                        break;

                    case R.id.categoria3:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas3_trabajo, null, false);
                        categoria=3;
                        break;

                    case R.id.categoria4:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas4_trabajo, null, false);
                        categoria=4;
                        break;
                }
                break;
            case 2:
                switch (view.getId()){
                    case R.id.categoria1:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas1_deudas, null, false);
                        categoria=1;
                        break;

                    case R.id.categoria2:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas2_deudas, null, false);
                        categoria=2;
                        break;

                    case R.id.categoria3:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas3_deudas, null, false);
                        categoria=3;
                        break;

                    case R.id.categoria4:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas4_deudas, null, false);
                        categoria=4;
                        break;
                }

                break;
            case 3:
                switch (view.getId()){
                    case R.id.categoria1:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas1_neurosis, null, false);
                        categoria=1;
                        break;

                    case R.id.categoria2:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas2_neurosis, null, false);
                        categoria=2;
                        break;

                    case R.id.categoria3:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas3_neurosis, null, false);
                        categoria=3;
                        break;

                    case R.id.categoria4:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas4_neurosis, null, false);
                        categoria=4;
                        break;
                }

                break;
            case 4:
                switch (view.getId()){
                    case R.id.categoria1:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas1_sexoyamor, null, false);
                        categoria=1;
                        break;

                    case R.id.categoria2:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas2_sexoyamor, null, false);
                        categoria=2;
                        break;

                    case R.id.categoria3:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas3_sexoyamor, null, false);
                        categoria=3;
                        break;

                    case R.id.categoria4:
                        //lista_especifica=(LinearLayout) inflater.inflate(R.layout.herramientas4_sexoyamor, null, false);
                        categoria=4;
                        break;
                }

                break;
        }
        layout.removeAllViews();
        layout.clearDisappearingChildren();
        layout.addView(lista_especifica);
        layout.recomputeViewAttributes(lista_especifica);
    }

    public void RespuestaHerramienta_Click(View view){

        switch (view.getId()){
            case R.id.si1:
                if (sies[0]==false){
                usuario.setAdiccion_pref(adiccion);
                usuario.SumarPunto(categoria);
                sies[0]=true;
                noes[0]=true;}
                break;
            case R.id.no1:
                if (noes[0]==false) {
                    Toast toast = Toast.makeText(Herramientas.this, "Seleccionado No1", Toast.LENGTH_SHORT);
                    toast.show();
                    sies[0]=true;
                    noes[0] = true;
                }
                break;
            case R.id.si2:
                if (sies[1]==false){
                    usuario.setAdiccion_pref(adiccion);
                    usuario.SumarPunto(categoria);
                    sies[1]=true;
                    noes[1]=true;}

                break;
            case R.id.no2:
                if (noes[1]==false) {
                    Toast toast = Toast.makeText(Herramientas.this, "Seleccionado No2", Toast.LENGTH_SHORT);
                    toast.show();
                    sies[1]=true;
                    noes[1] = true;
                }
                break;
            case R.id.si3:
                if (sies[2]==false){
                    usuario.setAdiccion_pref(adiccion);
                    usuario.SumarPunto(categoria);
                    sies[2]=true;
                    noes[2]=true;}

                break;
            case R.id.no3:
                if (noes[2]==false) {
                    Toast toast = Toast.makeText(Herramientas.this, "Seleccionado No3", Toast.LENGTH_SHORT);
                    toast.show();
                    sies[2]=true;
                    noes[2] = true;
                }
                break;
            case R.id.si4:
                if (sies[3]==false){
                    usuario.setAdiccion_pref(adiccion);
                    usuario.SumarPunto(categoria);
                    sies[3]=true;
                    noes[3]=true;}

                break;
            case R.id.no4:
                if (noes[3]==false) {
                    Toast toast = Toast.makeText(Herramientas.this, "Seleccionado No4", Toast.LENGTH_SHORT);
                    toast.show();
                    sies[3]=true;
                    noes[3] = true;
                }
                break;
            case R.id.si5:
                if (sies[4]==false){
                    usuario.setAdiccion_pref(adiccion);
                    usuario.SumarPunto(categoria);
                    sies[4]=true;
                    noes[4]=true;}

                break;
            case R.id.no5:
                if (noes[4]==false) {
                    Toast toast = Toast.makeText(Herramientas.this, "Seleccionado No5", Toast.LENGTH_SHORT);
                    toast.show();
                    sies[4]=true;
                    noes[4] = true;
                }
                break;
            case R.id.si6:
                if (sies[5]==false){
                    usuario.setAdiccion_pref(adiccion);
                    usuario.SumarPunto(categoria);
                    sies[5]=true;
                    noes[5]=true;}

                break;
            case R.id.no6:
                if (noes[5]==false) {
                    Toast toast = Toast.makeText(Herramientas.this, "Seleccionado No6", Toast.LENGTH_SHORT);
                    toast.show();
                    sies[5]=true;
                    noes[5] = true;
                }
                break;
        }
        puntos.setText(Integer.toString(usuario.puntaje));
        if (usuario.puntaje-puntaje_anterior==1){
          avatar.setImageResource(R.drawable.cara1);
        }
        else if(usuario.puntaje-puntaje_anterior==2){
            avatar.setImageResource(R.drawable.cara2);
        }
        else if(usuario.puntaje-puntaje_anterior==3){
            avatar.setImageResource(R.drawable.cara3);
        }
        else if(usuario.puntaje-puntaje_anterior==4){
            avatar.setImageResource(R.drawable.cara3);
        }

    }
    }



