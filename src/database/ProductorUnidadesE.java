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
        lista.add(new GuilleTigre());
        return lista;
    }
    
    
    static class LeonAlado extends Unidad{
        
        public LeonAlado() {
            super("León alado", "felino1.png", "Es un pájaro, es un avión; es un león.", TipoUnidad.Bestia, 
                    new Atributos(135,120,9,4,4,2,5,5,6));
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(new ProductorEquiposA.DentaduraFuerte());
        }


        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            int vida = (int)(this.getArmadura()+this.getBlindaje());
            int maxSana = this.getVidaInicial()-this.getVida();
            if(vida > maxSana)
                vida = maxSana;
            if(vida > 0){
                Controlador.getInstance().apCurarUnidad(this, vida);
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se curó " + vida + " de salud.");
            }
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
    static class GuilleTigre extends Unidad{
        
        public GuilleTigre() {
            super("Guille el Tigre", "Beast11.png", "Te mira, piensa, te mata.", TipoUnidad.Bestia, 
                    new Atributos(100,100,11,5,3,3,6,4,5));
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(new ProductorEquiposA.DentaduraFuerte());
        }


        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            int vida = (int)(1.5*this.getFuerza()) - objetivo.getBlindaje();
            int maxSana = this.getVidaInicial()-this.getVida();
            if(vida > maxSana)
                vida = maxSana;
            if(vida > 0){
                Controlador.getInstance().apCurarUnidad(this, vida);
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se curó " + vida + " de salud.");
            }
            if(tirada > 0.6){
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " aumentó su fuerza de " + 
                        this.getFuerza() + " a " + this.modFuerza(1));
            }
        }
        
        @Override
        public Unidad getCopia() {
            return new GuilleTigre();
        }
    
    }    
}
