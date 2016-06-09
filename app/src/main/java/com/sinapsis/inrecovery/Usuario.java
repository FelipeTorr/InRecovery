package com.sinapsis.inrecovery;

/**
 * Created by FELIPE on 18/04/2016.
 */
public class Usuario {
    public int adiccion_usuario;
    public String nombre;
    public String contrasena;
    public int edad;
    public int puntaje;
    public int dias_sin_adiccion;
    public int dias_usando_app;
	public int adiccion_pref;
	public int[] progreso;

    public Usuario (String nombre, int edad){
        this.edad=edad;
        this.nombre=nombre;
        this.puntaje=0;
        this.dias_sin_adiccion=0;
        this.dias_usando_app=0;
		this.progreso=new int[4];
		progreso[0]=0;
		progreso[1]=0;
		progreso[2]=0;
		progreso[3]=0;
    }
    public Usuario (String nombre,String contrasena, int edad){
        this.edad=edad;
        this.contrasena=contrasena;
        this.nombre=nombre;
        this.puntaje=0;
        this.dias_sin_adiccion=0;
        this.dias_usando_app=0;
    }

	public void setAdiccion_pref(int adiccion) {
        this.adiccion_pref=adiccion;
    }
	
    public void setDias_usando_app(int dias_usando_app) {
        this.dias_usando_app = dias_usando_app;
    }

    public void setDias_sin_adiccion(int dias_sin_adiccion) {
        this.dias_sin_adiccion = dias_sin_adiccion;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
	
	public void SumarPunto(int categoria) {
        this.puntaje++;
		this.progreso[categoria]++;
    }
}
