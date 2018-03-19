/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

import Micelaneous.decisionIA;
import database.Database;
import database.ProductorCombate;
import database.ProductorCombate.CombateInfo;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public class Controlador {
    
    public static String GAME_NAME = "Automatic Battle";
    public static String ICON_ADDRES = "/icons/icon180.png";
    
    public Combate combateActual = null;
    
    
    private Controlador() {
    }
    
    public void iniciaCombate(int i, ArrayList<Unidad> aliadas){
        CombateInfo CI = ProductorCombate.getInstance().getCombateNivel(i);
        int col = 0, fil=0;
        int incr;
        if(aliadas.size()<4){
            col=4/aliadas.size();
            incr=3;
        }else if(aliadas.size()<10){
            col=1;
            incr=2;
        }else
            incr=1;
        for(Unidad U: aliadas){
            if(col>8){
                col-=9;
                fil++;
            }
            CI.getTablero().insertaUnidad(U, fil, col);
            col+=incr;
        }
        combateActual = new Combate(CI.getNombre(), aliadas, CI.getEnemigos(), CI.getTablero());
    }
    
    public boolean comprobarAccion(Unidad U, decisionIA.Seleccion decision){
        boolean can = true;
        switch(decision.decision){
            case Desplazamiento:
                can = calculaDistancia(decision.movX,decision.movY,0,0)<= U.getDistanciaMovimiento();
                if(!can)
                    System.err.println("Distancia movimiento no permitida");
                decision.movX += U.getPosX();
                decision.movY += U.getPosY();
                can = can && this.combateActual.getTablero().ocupada(decision.movX, decision.movY)==null;
                break;
            case Atacar:
                if(U==decision.U)
                    can = false;
                else{
                    can = calculaDistancia(U.getPosX(),U.getPosY(),decision.U.getPosX(), U.getPosY()) <= U.getAlcance();
                    if(!can)
                        System.err.println("Distancia ataque no permitida");
                }
                break;
            case Habilidad:
            case Objeto:
            case IDLE:
        }
        return can;
    }
    
    
    
    public int calculaDistancia(int x1, int y1, int x2, int y2){
        return (int)(Math.sqrt((x2-x1)*(x2-x1))) + (int)(Math.sqrt((y2-y1)*(y2-y1)));
    }   
    
    
    public boolean posicionValidaNoOcupada(int x, int y){
        return combateActual.getTablero().coordenadasValidas(x, y) && combateActual.getTablero().ocupada(x, y)==null;
    }
    
    public ArrayList<Unidad> getUnidadesEnVision(Unidad U){
        ArrayList<Unidad> unidades = new ArrayList<>();
        unidades.addAll(getAliadasEnVision(U));
        unidades.addAll(getEnemigasEnVision(U));
        return unidades; 
    }
    
    public ArrayList<Unidad> getAliadasEnVision(Unidad U){
        ArrayList<Unidad> unidades = new ArrayList<>();
        
        int vision = U.getVisibilidad();
        for(Unidad otra: combateActual.getAliadas(U))
            if(vision >= calculaDistancia(otra.getPosX(),otra.getPosY(), U.getPosX(),U.getPosY()))
                unidades.add(otra);
        
        return unidades;
    }
    
    public ArrayList<Unidad> getEnemigasEnVision(Unidad U){
        ArrayList<Unidad> unidades = new ArrayList<>();
        
        int vision = U.getVisibilidad();
        for(Unidad otra: combateActual.getEnemigas(U))
            if(vision >= calculaDistancia(otra.getPosX(),otra.getPosY(), U.getPosX(),U.getPosY()))
                unidades.add(otra);
        
        
        return unidades;
    }
    
    public ArrayList<Unidad> getEnemigasEnAlcance(Unidad U){
        ArrayList<Unidad> unidades = new ArrayList<>();
        
        int alcance = U.getAlcance();
        if(U.getAlcance() > U.getVisibilidad())
            alcance = U.getVisibilidad();
        for(Unidad otra: combateActual.getEnemigas(U))
            if(alcance >= calculaDistancia(otra.getPosX(),otra.getPosY(), U.getPosX(),U.getPosY()))
                unidades.add(otra);
        
        
        return unidades;
    }
    
    public static Controlador getInstance() {
        return ControladorHolder.INSTANCE;
    }
    
    private static class ControladorHolder {

        private static final Controlador INSTANCE = new Controlador();
    }
}
