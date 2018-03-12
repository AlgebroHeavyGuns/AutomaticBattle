/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import automaticbattle.Equipable;
import automaticbattle.Unidad;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public final class Database {
    
    private ArrayList<Unidad> unidades;
    private ArrayList<Equipable> equipos;
    
    private Database() {
        iniciaEquipos();
        iniciaUnidades();
    }
    
    private void iniciaEquipos(){
    
    }
    
    private void iniciaUnidades(){
    
    }
    
    
    
    
    
    
    public static Database getInstance() {
        return DatabaseHolder.INSTANCE;
    }
    
    private static class DatabaseHolder {

        private static final Database INSTANCE = new Database();
    }
}
