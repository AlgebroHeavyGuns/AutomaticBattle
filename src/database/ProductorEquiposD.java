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
        return lista;
    }
    
    
    static class CorazaDeBatalla extends Equipable{

        public CorazaDeBatalla() {
            super("Coraza de batalla", "chest.png", 275, 0, new Atributos(50,0,0,0,4,2,0,0,0), TipoEquipo.Coraza);
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
            super("Coraza de guerra", "chest2.png", 550, 1, new Atributos(90,0,1,0,6,3,-1,0,0), TipoEquipo.Coraza);
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
            super("Casco de batalla", "casco.png", 100, 0, new Atributos(30,0,0,0,1,1,0,0,1), TipoEquipo.Casco);
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.Arco, 0.85));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.BallestaGrande, 0.9));
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
    
    static class HachaGranLeñador extends Arma{

        public HachaGranLeñador() {
            super("Hacha de Gran leñador", "axe.png", 500, 1, new Atributos(40,10,8,0,1,0,-1,0,1), TipoArma.HachaDosManos, Elemento.Comun, 1);
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
    
    static class HachaDeBatalla extends Arma{

        public HachaDeBatalla() {
            super("Hacha de batalla", "axe2.png", 275, 3, new Atributos(25,10,5,0,0,0,0,0,0), TipoArma.HachaUnaMano, Elemento.Comun, 1);
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.EspadaDosManos,0.925));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.HachaDosManos,0.925));
            this.getResistenciaArma().add(new EfectividadArma(TipoArma.Maza,0.925));
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
    
    
    static class ArcoMediano extends Arma{

        public ArcoMediano() {
            super("Arco mediano", "arco2.png", 425, 1, new Atributos(20,20,5,0,0,0,2,0,2), TipoArma.Arco, Elemento.Comun, 5);
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Bestia, 1.2));
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Aberracion, 1.25));
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Gigante, 1.5));
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Dragon, 0.9));
        }
        
        @Override
        public boolean puedeEquiparseA(TipoUnidad TU) {
            return TU!=TipoUnidad.Bestia;
        }

        @Override
        public Equipable getCopia() {
            return new ArcoMediano();
        }
    
    }
    
}
