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

/**
 *
 * @author Algebro
 */
public final class Database {
    
    private ArrayList<Unidad> unidades;
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
        unidades = new ArrayList<>();
        unidades.addAll(ProductorUnidadesA.getUnidades());
        
    }
    
    private void iniciaIAs(){
        IAs = new ArrayList<>();
    }
    
    public Unidad getUnidad(int i){
        return unidades.get(i).getCopia();
    }
    
    
    
    public static Database getInstance() {
        return DatabaseHolder.INSTANCE;
    }
    
    private static class DatabaseHolder {

        private static final Database INSTANCE = new Database();
    }
}
