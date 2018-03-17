/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

import Micelaneous.Atributos;
import Micelaneous.EfectividadTipo;
import Micelaneous.Elemento;
import Micelaneous.TipoArma;
import Micelaneous.TipoEquipo;
import Micelaneous.TipoUnidad;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public abstract class Arma extends Equipable{

    private TipoArma tipoArma;
    private Elemento elementoAtaque;
    private int alcance;
    private ArrayList<EfectividadTipo> efectividades;
    
    public Arma(String nombre, String imagen, int coste, int nivelRequerido, 
            Atributos modificador, TipoArma tipo, Elemento elementoAtaque, int alcance) {
        super(nombre, imagen, coste, nivelRequerido, modificador, TipoEquipo.Arma);
        this.tipoArma = tipo;
        this.elementoAtaque = elementoAtaque;
        this.efectividades = new ArrayList<>();
        this.alcance = alcance;
    }

    public TipoArma getTipoArma() {
        return tipoArma;
    }

    public Elemento getElementoAtaque() {
        return elementoAtaque;
    }

    public ArrayList<EfectividadTipo> getEfectividades() {
        return efectividades;
    }

    public int getAlcance() {
        return alcance;
    }
    
    
    
    public double getCoeficienteEfectividad(TipoUnidad TU){
        for(EfectividadTipo ET : efectividades)
            if(ET.getUnidad() == TU)
                return ET.getEfectividad();
        return 1.0;
    }
    
    
    

    
}
