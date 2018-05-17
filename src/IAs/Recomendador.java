/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IAs;

import automaticbattle.Equipable;
import automaticbattle.Unidad;
import database.Database;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public class Recomendador {
    
    ArrayList<Equipable> equipos;
    
    private Recomendador() {
        equipos = Database.getInstance().getEquipos(99);
    }
    
    public static Recomendador getInstance() {
        return RecomendadorHolder.INSTANCE;
    }
    
    public Equipable recomendarEquipo(Unidad U, int costeMaximo){
        Equipable E=null;
        if(!puedeEquiparAlgunObjeto(U, costeMaximo))
            return null;

        switch(U.getNombre()){
            case "Teodora Cazadora":
                E = getEquipoCazadora(U,costeMaximo);
        }
            
        if(E==null)
            E = equipoAleatorio(U,costeMaximo);
        return E;
    }
    
    private Equipable equipoAleatorio(Unidad U, int dinero){
        Equipable E = equipos.get((int)(Math.random()*equipos.size()));
        while(!factible(U,E,dinero))
            E = equipos.get((int)(Math.random()*equipos.size()));
        return E;
    }
    
    public boolean puedeEquiparAlgunObjeto(Unidad U, int dinero){
        for(Equipable E : equipos)
            if(factible(U,E,dinero))
                return true;
        return false;
    }
    
    private boolean factible(Unidad U, Equipable E, int dinero){
        return E.getCoste()<=dinero && E.puedeEquiparseA(U.getTipo()) && U.puedeEquipar(E)==null;
    }
    
    private Equipable getEquipoCazadora(Unidad U, int coste){
        Equipable E = Database.getInstance().getEquipo("Arco mediano");
        if(factible(U,E,coste))
            return E;
        E = Database.getInstance().getEquipo("Casco de batalla");
        if(factible(U,E,coste))
            return E;
        E = Database.getInstance().getEquipo("Guantes de batalla");
        if(factible(U,E,coste))
            return E;
        E = Database.getInstance().getEquipo("Anillo de Coraje");
        if(factible(U,E,coste))
            return E;
        return null;
    }
    
    private static class RecomendadorHolder {

        private static final Recomendador INSTANCE = new Recomendador();
    }
}
