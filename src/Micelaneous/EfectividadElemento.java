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
public class EfectividadElemento {
    private Elemento elemento;
    private double efectividad;

    public EfectividadElemento(Elemento elemento, double efectividad) {
        this.elemento = elemento;
        this.efectividad = efectividad;
    }

    
    public Elemento getElemento() {
        return elemento;
    }

    public double getEfectividad() {
        return efectividad;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public void setEfectividad(double efectividad) {
        this.efectividad = efectividad;
    }
    
    
    
}
