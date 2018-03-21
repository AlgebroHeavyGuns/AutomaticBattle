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
public class ProductorEquiposD {
    
    static ArrayList<Equipable> getEquipos(){
        ArrayList<Equipable> lista = new ArrayList<>();
        lista.add(new CorazaDeBatalla());
        lista.add(new CorazaDeGuerra());
        lista.add(new CascoDeBatalla());
        lista.add(new GuantesDeBatalla());
        return lista;
    }
    
    
    static class CorazaDeBatalla extends Equipable{

        public CorazaDeBatalla() {
            super("Coraza de batalla", "chest.png", 325, 0, new Atributos(75,0,0,0,6,3,0,0,0), TipoEquipo.Coraza);
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.EspadaUnaMano, 0.9));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.EspadaDosManos, 0.9));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.Daga, 0.9));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.HachaUnaMano, 0.9));
        }

        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU!=TipoUnidad.Bestia;
        }
        
        @Override
        public Equipable getCopia() {
            return new CorazaDeBatalla();
        }
    
    }
    
    static class CorazaDeGuerra extends Equipable{

        public CorazaDeGuerra() {
            super("Coraza de guerra", "chest2.png", 550, 1, new Atributos(140,0,1,0,9,5,-1,0,0), TipoEquipo.Coraza);
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.EspadaUnaMano, 0.85));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.EspadaDosManos, 0.85));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.Daga, 0.85));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.HachaUnaMano, 0.85));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.HachaDosManos, 0.95));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.Maza, 0.95));
        }

        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU!=TipoUnidad.Bestia;
        }
        
        @Override
        public Equipable getCopia() {
            return new CorazaDeGuerra();
        }
    
    }
    
    static class CascoDeBatalla extends Equipable{

        public CascoDeBatalla() {
            super("Casco de batalla", "casco.png", 200, 0, new Atributos(40,0,0,0,3,2,0,0,1), TipoEquipo.Casco);
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.Arco, 0.9));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.BallestaGrande, 0.95));
        }
        
        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU!=TipoUnidad.Bestia;
        }
        
        @Override
        public Equipable getCopia() {
            return new CascoDeBatalla();
        }
    
    }
    
    
    static class GuantesDeBatalla extends Equipable{

        public GuantesDeBatalla() {
            super("Guantes de batalla", "guante.png", 150, 0, new Atributos(30,10,1,0,2,1,0,0,0), TipoEquipo.Guantes);
        }
        
        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU!=TipoUnidad.Bestia;
        }
        
        @Override
        public Equipable getCopia() {
            return new GuantesDeBatalla();
        }
    
    } 
}
