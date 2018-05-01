/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Micelaneous.Atributos;
import Micelaneous.EfectividadArma;
import Micelaneous.EfectividadElemento;
import Micelaneous.EfectividadTipo;
import Micelaneous.Elemento;
import Micelaneous.TipoArma;
import Micelaneous.TipoEquipo;
import Micelaneous.TipoUnidad;
import automaticbattle.Arma;
import automaticbattle.Equipable;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public class ProductorEquiposI {
    
    static ArrayList<Equipable> getEquipos(){
        ArrayList<Equipable> lista = new ArrayList<>();
        lista.add(new CorazaDeHierroParaBestias());
        return lista;
    }
    
    static class CorazaDeHierroParaBestias extends Equipable{

        public CorazaDeHierroParaBestias() {
            super("Cor. de hierro para Bestias", "chest3.png", 575, 0, new Atributos(135,0,2,1,6,3,1,1,0), TipoEquipo.Coraza);
            this.getResistenciaElemento().add(new EfectividadElemento(Elemento.Comun, 0.9));
        }

        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU==TipoUnidad.Bestia;
        }
        
        @Override
        public Equipable getCopia() {
            return new CorazaDeHierroParaBestias();
        }
    
    }
    
}
