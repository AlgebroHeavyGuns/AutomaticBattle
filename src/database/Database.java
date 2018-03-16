/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import automaticbattle.Equipable;
import automaticbattle.Unidad;
import java.util.ArrayList;
import Micelaneous.decisionIA;
import java.util.Iterator;

/**
 *
 * @author Algebro
 */
public final class Database {
    
    private ArrayList<Unidad> unidadesEnemigas;
    private ArrayList<Unidad> unidadesAliadas;
    private ArrayList<Equipable> equipos;
    private ArrayList<decisionIA> IAs;
    
    
    private Database() {
    }
    
    public void inicia(){
        iniciaEquipos();
        iniciaIAs();
        iniciaUnidades();
    }
    
    private void iniciaEquipos(){
        equipos = new ArrayList<>();
        
    }
    
    private void iniciaUnidades(){
        unidadesEnemigas = new ArrayList<>();
        unidadesAliadas = new ArrayList<>();
        unidadesEnemigas.addAll(ProductorUnidadesA.getUnidades());
        unidadesAliadas.addAll(ProductorUnidadesB.getUnidades());
        
    }
    
    private void iniciaIAs(){
        IAs = new ArrayList<>();
    }
    
    private Unidad getUnidad(String nombre, ArrayList<Unidad> lista){
        Unidad U = null;
        Iterator<Unidad> it = lista.iterator();
        boolean encontrado = false;
        while(it.hasNext()&& !encontrado){
            U=it.next();
            encontrado= U.getNombre().equalsIgnoreCase(nombre);
        }
        if(encontrado)
            return U.getCopia();
        else
            return null;
    }
    
    public Unidad getUnidadEnemiga(String nombre){
        return getUnidad(nombre, unidadesEnemigas);
    }
    
    public Unidad getUnidadAliada(String nombre){
        return getUnidad(nombre, unidadesAliadas);
    }
    
    
    
    public static Database getInstance() {
        return DatabaseHolder.INSTANCE;
    }
    
    private static class DatabaseHolder {

        private static final Database INSTANCE = new Database();
    }
}
