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
public class ProductorEquiposB {
    
    static ArrayList<Equipable> getEquipos(){
        ArrayList<Equipable> lista = new ArrayList<>();
        lista.add(new CorazaDeBatalla());
        lista.add(new HachaGranLeñador());
        return lista;
    }
    
    
    static class CorazaDeBatalla extends Equipable{

        public CorazaDeBatalla() {
            super("Coraza de batalla", "chest.png", 300, 0, new Atributos(40,10,0,0,4,2,0,0,0), TipoEquipo.Coraza);
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.EspadaUnaMano, 0.85));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.EspadaDosManos, 0.85));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.HachaUnaMano, 0.9));
        }

        @Override
        public Equipable getCopia() {
            return new CorazaDeBatalla();
        }
    
    }
    
    static class HachaGranLeñador extends Arma{

        public HachaGranLeñador() {
            super("Hacha de Gran leñador", "axe.png", 450, 1, new Atributos(30,10,6,0,1,0,0,0,1), TipoArma.Hacha, Elemento.Comun, 1);
        }

        @Override
        public Equipable getCopia() {
            return new HachaGranLeñador();
        }
    
    }
    
}
