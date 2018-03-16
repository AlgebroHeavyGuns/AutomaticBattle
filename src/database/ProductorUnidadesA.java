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
public class ProductorUnidadesA {
    
    static ArrayList<Unidad> getUnidades(){
        ArrayList<Unidad> lista = new ArrayList<>();
        lista.add(new JabaliInutil());
        lista.add(new EspirituDragon());
        return lista;
    }
    
    static class JabaliInutil extends Unidad{
        public JabaliInutil() {
            super("Jabalí inútil", "WildBoar1.png", "Es muy cerdaco.", TipoUnidad.Bestia, 
                    new Atributos(100,100,10,1,5,3,3,4,4));
            this.setIAAsociada(new deciaBasicIA());
        }

        @Override
        public Unidad getCopia() {
            return new JabaliInutil();
        }
    
    }

    static class EspirituDragon extends Unidad{
        public EspirituDragon() {
            super("Espíritu dragón", "Dragon4.png", "Si lo ves, ya es tarde.", TipoUnidad.Dragon, 
                    new Atributos(400,400,15,10,6,5,5,3,7));
            this.setIAAsociada(new deciaBasicIA());
        }


        @Override
        public int getDistanciaMovimiento() {
            return 3;
        }
        
        @Override
        public Unidad getCopia() {
            return new EspirituDragon();
        }
    
    }    
    
}
