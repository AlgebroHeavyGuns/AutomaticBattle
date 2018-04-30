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
        lista.add(new CascoDeDestruccion());
        lista.add(new GuantesDeBatalla());
        lista.add(new PantalonesDeBatalla());
        lista.add(new AnilloDeVitalidad());
        return lista;
    }
    
    
    static class CorazaDeBatalla extends Equipable{

        public CorazaDeBatalla() {
            super("Coraza de batalla", "chest.png", 350, 0, new Atributos(100,0,0,0,5,3,0,0,0), TipoEquipo.Coraza);
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
            super("Coraza de guerra", "chest2.png", 600, 1, new Atributos(160,0,1,0,9,5,-1,0,0), TipoEquipo.Coraza);
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
            super("Casco de batalla", "casco.png", 150, 0, new Atributos(30,0,0,0,2,2,1,0,1), TipoEquipo.Casco);
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
    
    static class CascoDeDestruccion extends Equipable{

        public CascoDeDestruccion() {
            super("Casco de destrucción", "casco2.png", 400, 0, new Atributos(70,10,2,0,4,2,1,0,1), TipoEquipo.Casco);
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.Arco, 0.8));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.BallestaGrande, 0.85));
        }
        
        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU!=TipoUnidad.Bestia && TU!=TipoUnidad.Reptil;
        }
        
        @Override
        public Equipable getCopia() {
            return new CascoDeDestruccion();
        }
    
    }

    
    static class GuantesDeBatalla extends Equipable{

        public GuantesDeBatalla() {
            super("Guantes de batalla", "guante.png", 100, 0, new Atributos(20,10,1,0,1,0,0,0,0), TipoEquipo.Guantes);
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
    
    static class PantalonesDeBatalla extends Equipable{

        public PantalonesDeBatalla() {
            super("Pantalones de batalla", "pants.png", 225, 0, new Atributos(50,10,0,0,3,2,1,0,0), TipoEquipo.Pantalon);
        }

        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU!=TipoUnidad.Bestia;
        }
        
        @Override
        public Equipable getCopia() {
            return new PantalonesDeBatalla();
        }
    
    }
    
    static class AnilloDeVitalidad extends Equipable{

        public AnilloDeVitalidad() {
            super("AnilloDeVitalidad", "anillo1.png", 75, 0, new Atributos(30,0,0,0,0,0,0,0,0), TipoEquipo.Joyeria);
        }
        
        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU!=TipoUnidad.Bestia && TU!=TipoUnidad.Reptil;
        }
        
        @Override
        public Equipable getCopia() {
            return new AnilloDeVitalidad();
        }
    
    }
    
}
