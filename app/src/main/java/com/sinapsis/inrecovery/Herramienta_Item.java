package com.sinapsis.inrecovery;

import android.content.res.Resources;

/**
 * Created by Felipe on 5/10/2016.
 */


public class Herramienta_Item {
    public int titulo;
    public int descripcion;
    public int enlace;
    public boolean con_enlace;
    public int idImagen;
    public int background;


    public Herramienta_Item(int titulo, int enlace, int descripcion, int idImagen, int Background ){
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.con_enlace=true;
        this.enlace=enlace;
        this.idImagen=idImagen;
        this.background=Background;
    }


    public Herramienta_Item(int titulo, int descripcion, int idImagen,int Background){
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.con_enlace=false;
        this.enlace=R.string.vacio;
        this.idImagen=idImagen;
        this.background=Background;
    }


}
