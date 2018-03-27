/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import automaticbattle.Escenografia;
import automaticbattle.Unidad;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public class ProductorEscenografias {
    static ArrayList<Escenografia> getEscenografias(){
        ArrayList<Escenografia> lista = new ArrayList<>();
        lista.add(new ArbolSimple());
        lista.add(new ArbolSeco());
        lista.add(new ArbolDeshojado());
        lista.add(new ArbolSelvatico());
        lista.add(new RocaMediana());
        return lista;
    }
    
    static class ArbolSimple extends Escenografia{
        public ArbolSimple() {
            super("Árbol simple", "arbol1.png", "Es un simple árbol");
        }
        @Override
        public Unidad getCopia() {
            return new ArbolSimple();
        }
    }
    
    static class ArbolSeco extends Escenografia{
        public ArbolSeco() {
            super("Árbol seco", "arbol2.png", "Es un simple árbol, seco.");
        }
        @Override
        public Unidad getCopia() {
            return new ArbolSeco();
        }
    }
    
    static class ArbolDeshojado extends Escenografia{
        public ArbolDeshojado() {
            super("Árbol deshojado", "arbol3.png", "Es un árbol sin hojas.");
        }
        @Override
        public Unidad getCopia() {
            return new ArbolDeshojado();
        }
    }
       
    static class ArbolSelvatico extends Escenografia{
        public ArbolSelvatico() {
            super("Árbol selvático", "arbol4.png", "Árbol propio de la selva.");
        }
        @Override
        public Unidad getCopia() {
            return new ArbolSelvatico();
        }
    }
    
    static class RocaMediana extends Escenografia{
        public RocaMediana() {
            super("Roca mediana", "roca.png", "Parece cómoda... o no.");
        }
        @Override
        public Unidad getCopia() {
            return new RocaMediana();
        }
    }
}
