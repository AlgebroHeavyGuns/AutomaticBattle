/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

import Micelaneous.TipoHabilidad;

/**
 *
 * @author Algebro
 */
public abstract class Habilidad {
    private String nombre;
    private String descripcion;
    private int costeEnergia;
    private int costeVida;
    private int rango;
    private TipoHabilidad tipo;

    public Habilidad(String nombre, String descripcion, int costeEnergia, int costeVida, int rango, TipoHabilidad tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costeEnergia = costeEnergia;
        this.costeVida = costeVida;
        this.rango = rango;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }



    public int getCosteEnergia() {
        return costeEnergia;
    }

    public int getCosteVida() {
        return costeVida;
    }

    public int getRango() {
        return rango;
    }

    public TipoHabilidad getTipo() {
        return tipo;
    }
    
    public boolean puedeUtilizar(Unidad lanzador){
        return lanzador.getVida()>this.getCosteVida() && lanzador.getEnergia() >= this.getCosteEnergia();
    }
    public boolean tieneEfecto(Unidad lanzador, Unidad objetivo){
        return true;
    }
    public abstract void realizarEfecto(Unidad lanzador, Unidad receptor);
    public abstract Habilidad getCopia();
}
