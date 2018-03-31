/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Micelaneous.Atributos;
import Micelaneous.EfectividadElemento;
import Micelaneous.EfectividadTipo;
import Micelaneous.Elemento;
import Micelaneous.TipoArma;
import Micelaneous.TipoUnidad;
import automaticbattle.Arma;
import automaticbattle.Equipable;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public class ProductorEquiposA {
    
    static ArrayList<Equipable> getEquipos(){
        ArrayList<Equipable> lista = new ArrayList<>();
        lista.add(new AlmaDeDragon());
        lista.add(new DentaduraFuerte());
        lista.add(new GlandulaVenenosa());
        return lista;
    }
    
    static class AlmaDeDragon extends Arma{
        public AlmaDeDragon(){
            super("Alma de dragón", "Dragon4.png", 0, -1, new Atributos(200,150,8,5,3,3,0,0,0), TipoArma.BallestaGrande, Elemento.Fuego, 4);
            this.getResistenciaElemento().add(new EfectividadElemento(Elemento.Fuego, 0.5));
            this.getResistenciaElemento().add(new EfectividadElemento(Elemento.Agua, 1.2));
            this.getResistenciaElemento().add(new EfectividadElemento(Elemento.Luz, 1.1));
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Bestia, 1.2));
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Humano, 1.3));
        }

        @Override
        public Equipable getCopia() {
            return new AlmaDeDragon();
        }

        
    }
    
    static class DentaduraFuerte extends Arma{

        public DentaduraFuerte() {
            super("Dentadura fuerte", "dientes.png", 0, -1, new Atributos(50,10,8,0,0,0,0,0,0), TipoArma.Daga, Elemento.Comun, 1);
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Humano, 1.2));
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Elfo, 1.25));
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Bestia, 1.2));
        }

        @Override
        public Equipable getCopia() {
            return new DentaduraFuerte();
        }
    
    }

    
    
        static class GlandulaVenenosa extends Arma{

        public GlandulaVenenosa() {
            super("Glándula venenosa", "glandulavenenosa.png", 0, -1, new Atributos(20,10,3,0,1,1,1,0,0), TipoArma.Daga, Elemento.Comun, 3);
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Humano, 1.1));
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Elfo, 1.1));
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Bestia, 1.1));
            this.getEfectividades().add(new EfectividadTipo(TipoUnidad.Gigante, 1.1));
        }

        @Override
        public Equipable getCopia() {
            return new GlandulaVenenosa();
        }
    
    }
}
