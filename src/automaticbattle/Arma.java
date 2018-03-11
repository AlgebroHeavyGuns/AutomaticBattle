/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

import Micelaneous.Atributo;
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
public class Arma extends Equipable{

    private TipoArma tipoArma;
    private Elemento elementoAtaque;
    private ArrayList<EfectividadTipo> efectividades;
    
    public Arma(String nombre, String imagen, int coste, int nivelRequerido, 
            Atributo modificador, TipoArma tipo, Elemento elementoAtaque) {
        super(nombre, imagen, coste, nivelRequerido, modificador, TipoEquipo.Arma);
        tipoArma = tipo;
        this.elementoAtaque = elementoAtaque;
        efectividades = new ArrayList<>();
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
    
    public double getCoeficienteEfectividad(TipoUnidad TU){
        for(EfectividadTipo ET : efectividades)
            if(ET.getUnidad() == TU)
                return ET.getEfectividad();
        return 1.0;
    }
    
    
    

    
}
