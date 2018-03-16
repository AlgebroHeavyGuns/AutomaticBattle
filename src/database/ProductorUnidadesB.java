/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import IAs.deciaBasicIA;
import Micelaneous.Atributos;
import Micelaneous.TipoUnidad;
import automaticbattle.Controlador;
import automaticbattle.Unidad;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public class ProductorUnidadesB {
    
    static ArrayList<Unidad> getUnidades(){
        ArrayList<Unidad> lista = new ArrayList<>();
        lista.add(new PatricioGuerrero());
        lista.add(new JoaquinPaladin());
        return lista;
    }
    
    /*
    
    Atributos(int vida, int energia, int fuerza, int intelecto, 
            int armadura, int blindaje, int velocidad, int agilidad, int visibilidad)
    */
    
    
            
    static class PatricioGuerrero extends Unidad{
        private int vidaInicial;
        
        public PatricioGuerrero() {
            super("Patricio Guerrero", "CharacterHumanMale.png", "Todo o nada.", TipoUnidad.Humano, 
                    new Atributos(140,90,9,5,4,4,4,3,4));
            this.setIAAsociada(new deciaBasicIA());
        }


        @Override
        public void efectoTurnoUnidadEnemiga(Unidad U) {
            int heal = vidaInicial - this.getVida();
            if(heal > 0){
                heal = (int)(heal*0.05) + 1;
                this.modVidaActual(heal);
            }
        }

        @Override
        public void efectoInicioEnfrentamiento() {
            vidaInicial=this.getVida();
            Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " grita : " + "\"¡Todo o nada!\"");
        }
        
        @Override
        public Unidad getCopia() {
            return new PatricioGuerrero();
        }
    
    }
    
    static class JoaquinPaladin extends Unidad{
        
        public JoaquinPaladin() {
            super("Joaquin Paladin", "CharacterBloodElfMale.png", "Todo o nada.", TipoUnidad.Humano, 
                    new Atributos(140,90,9,5,4,4,4,3,4));
            this.setIAAsociada(new deciaBasicIA());
        }

        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            if(acierto && tirada>0.85){
                this.modVidaActual((int)(objetivo.getVida()*0.1));
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se curó " + (int)(objetivo.getVida()*0.1) + " de salud.");
            }
            else if(!acierto){
                this.modVidaActual(this.getArmadura()+this.getBlindaje());
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se curó " + (this.getArmadura()+this.getBlindaje()) + " de salud.");
            }
        }
        
        @Override
        public Unidad getCopia() {
            return new JoaquinPaladin();
        }
    
    }
}
