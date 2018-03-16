/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import IAs.deciaBasicIA;
import Micelaneous.Atributos;
import Micelaneous.TipoUnidad;
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
        return lista;
    }
    
    /*
    
    Atributos(int vida, int energia, int fuerza, int intelecto, 
            int armadura, int blindaje, int velocidad, int agilidad, int visibilidad)
    */
    static class PatricioGuerrero extends Unidad{
        public PatricioGuerrero() {
            super("Patricio Guerrero", "CharacterHumanMale.png", "Todo o nada.", TipoUnidad.Humano, 
                    new Atributos(150,90,9,5,4,4,4,3,4));
            this.setIAAsociada(new deciaBasicIA());
        }


        @Override
        public void efectoTurnoUnidadEnemiga(Unidad U) {
            this.modVidaActual((int)(this.getVida()*0.01)+1);
        }

        @Override
        public void efectoInicioEnfrentamiento() {
            System.out.println(this.getNombre() + " grita : " + "\"¡Todo o nada!\"");
        }
        
        @Override
        public Unidad getCopia() {
            return new PatricioGuerrero();
        }
    
    }
    
    
}
