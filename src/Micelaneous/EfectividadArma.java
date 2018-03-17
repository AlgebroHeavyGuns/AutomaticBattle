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
public class EfectividadArma {
    private TipoArma arma;
    private double efectividad;

    public EfectividadArma(TipoArma arma, double efectividad) {
        this.arma = arma;
        this.efectividad = efectividad;
    }

    
    
    public TipoArma getArma() {
        return arma;
    }

    public double getEfectividad() {
        return efectividad;
    }

    public void setArma(TipoArma arma) {
        this.arma = arma;
    }

    public void setEfectividad(double efectividad) {
        this.efectividad = efectividad;
    }
    
    
}
