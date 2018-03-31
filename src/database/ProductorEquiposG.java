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
public class ProductorEquiposG {
    
    static ArrayList<Equipable> getEquipos(){
        ArrayList<Equipable> lista = new ArrayList<>();
        lista.add(new HachaGranLeñador());
        lista.add(new EspadaColosal());
        lista.add(new HachaDeBatalla());
        lista.add(new EspadaLigera());
        lista.add(new ArcoMediano());
        return lista;
    }
    
    
    static class HachaGranLeñador extends Arma{

        public HachaGranLeñador() {
            super("Hacha de Gran leñador", "axe.png", 400, 1, new Atributos(55,10,10,0,1,0,-1,0,1), TipoArma.HachaDosManos, Elemento.Comun, 1);
        }
        
        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU!=TipoUnidad.Bestia;
        }
        
        @Override
        public Equipable getCopia() {
            return new HachaGranLeñador();
        }
    
    }
    
    
    static class EspadaColosal extends Arma{

        public EspadaColosal() {
            super("Espada colosal", "espada.png", 675, 3, new Atributos(60,15,16,0,2,1,-1,0,1), TipoArma.EspadaDosManos, Elemento.Comun, 1);
        }
        
        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU!=TipoUnidad.Bestia;
        }
        
        @Override
        public Equipable getCopia() {
            return new EspadaColosal();
        }
    
    }
    
    static class HachaDeBatalla extends Arma{

        public HachaDeBatalla() {
            super("Hacha de batalla", "axe2.png", 225, 3, new Atributos(35,10,5,0,0,0,0,0,0), TipoArma.HachaUnaMano, Elemento.Comun, 1);
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.EspadaDosManos,0.9));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.HachaDosManos,0.9));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.Maza,0.9));
        }

        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU!=TipoUnidad.Bestia;
        }

        
        
        @Override
        public Equipable getCopia() {
            return new HachaDeBatalla();
        }
    
    }
    
    static class EspadaLigera extends Arma{

        public EspadaLigera() {
            super("Espada ligera", "espada2.png", 200, 3, new Atributos(20,15,6,0,0,0,1,0,0), TipoArma.EspadaUnaMano, Elemento.Comun, 1);
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Bestia,1.1));
        }

        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU!=TipoUnidad.Bestia;
        }

        
        
        @Override
        public Equipable getCopia() {
            return new EspadaLigera();
        }
    
    }
    
    static class ArcoMediano extends Arma{

        public ArcoMediano() {
            super("Arco mediano", "arco2.png", 425, 1, new Atributos(25,20,8,1,1,0,2,0,1), TipoArma.Arco, Elemento.Comun, 6);
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Bestia, 1.2));
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Aberracion, 1.3));
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Gigante, 1.5));
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Dragon, 0.9));
        }
        
        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU==TipoUnidad.Elfo;
        }

        @Override
        public Equipable getCopia() {
            return new ArcoMediano();
        }
    
    }
    
}
