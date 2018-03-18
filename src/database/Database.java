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
    
    
    private Database() {
    }
    
    public void inicia(){
        iniciaEquipos();
        iniciaUnidades();
    }
    
    private void iniciaEquipos(){
        equipos = new ArrayList<>();
        equipos.addAll(ProductorEquiposA.getEquipos());
        equipos.addAll(ProductorEquiposD.getEquipos());
        equipos.addAll(ProductorEquiposG.getEquipos());
        equipos.addAll(ProductorEquiposI.getEquipos());
    }
    
    private void iniciaUnidades(){
        unidadesEnemigas = new ArrayList<>();
        unidadesAliadas = new ArrayList<>();
        unidadesEnemigas.addAll(ProductorUnidadesA.getUnidades());
        unidadesAliadas.addAll(ProductorUnidadesD.getUnidades());
        unidadesAliadas.addAll(ProductorUnidadesE.getUnidades());
        
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
    
    public Equipable getEquipo(String nombre){
        Equipable E= null;
        Iterator<Equipable> it = equipos.iterator();
        boolean encontrado = false;
        while(it.hasNext()&& !encontrado){
            E=it.next();
            encontrado= E.getNombre().equalsIgnoreCase(nombre);
        }
        if(encontrado)
            return E.getCopia();
        else
            return null;
    }

    public ArrayList<Unidad> getUnidadesAliadas() {
        return unidadesAliadas;
    }

    public ArrayList<Equipable> getEquipos(int levelMax) {
        ArrayList<Equipable> ret = new ArrayList<>();
        for(Equipable E : equipos)
            if(E.getNivelRequerido() > -1 && E.getNivelRequerido() <= levelMax)
                ret.add(E);
                
        return ret;
    }
    
    
    
    
    public static Database getInstance() {
        return DatabaseHolder.INSTANCE;
    }
    
    private static class DatabaseHolder {

        private static final Database INSTANCE = new Database();
    }
}
