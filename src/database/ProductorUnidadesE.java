/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import IAs.*;
import Micelaneous.Atributos;
import Micelaneous.TipoUnidad;
import automaticbattle.Controlador;
import automaticbattle.Unidad;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public class ProductorUnidadesE {
    
    static ArrayList<Unidad> getUnidades(){
        ArrayList<Unidad> lista = new ArrayList<>();
        lista.add(new LeonAlado());
        return lista;
    }
    
    
    static class LeonAlado extends Unidad{
        
        public LeonAlado() {
            super("León alado", "felino1.png", "Es un pájaro, es un avión; es un león.", TipoUnidad.Bestia, 
                    new Atributos(100,120,8,4,4,2,5,5,6));
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(new ProductorEquiposA.DentaduraFuerte());
        }


        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            int vida = (int)(0.5*(this.getArmadura()+this.getBlindaje()));
            Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se curó " + vida + " de salud.");
        }

        @Override
        public int getDistanciaMovimiento() {
            return 2;
        }
        
        @Override
        public Unidad getCopia() {
            return new LeonAlado();
        }
    
    }
    
}
