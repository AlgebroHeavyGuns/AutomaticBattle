/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Micelaneous;

/**
 *
 * @author Algebro
 */
public class EfectividadTipo {
    private TipoUnidad unidad;
    private double efectividad;

    public EfectividadTipo(TipoUnidad unidad, double efectividad) {
        this.unidad = unidad;
        this.efectividad = efectividad;
    }

    
    public TipoUnidad getUnidad() {
        return unidad;
    }

    public double getEfectividad() {
        return efectividad;
    }

    public void setUnidad(TipoUnidad unidad) {
        this.unidad = unidad;
    }

    public void setEfectividad(double efectividad) {
        this.efectividad = efectividad;
    }
    
    
    
    
}
