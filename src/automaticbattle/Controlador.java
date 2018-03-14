/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

import Micelaneous.decisionIA;
import database.Database;
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
    
    public void iniciaCombate(){
        Tablero T = new Tablero(7,7);
        
        Unidad U =Database.getInstance().getUnidad(0);
        ArrayList<Unidad> listaUno = new ArrayList<>();
        listaUno.add(U);
        
        U.MoverA(1, 2);
        T.insertaUnidad(U, 1, 2);
        
        combateActual = new Combate("Prueba", listaUno, new ArrayList<>(), T);
    }
    
    public boolean comprobarAccion(Unidad U, decisionIA.Seleccion decision){
        boolean can = true;
        switch(decision.decision){
            case Desplazamiento:
                can = calculaDistancia(decision.movX,decision.movY,0,0)<= U.getDistanciaMovimiento();
                decision.movX += U.getPosX();
                decision.movY += U.getPosY();
                can = can && this.combateActual.getTablero().ocupada(decision.movX, decision.movY)==null;
                break;
            case Atacar:
                if(U==decision.U)
                    can = false;
                else
                    can = calculaDistancia(U.getPosX(),U.getPosY(),decision.U.getPosX(), U.getPosY()) <= U.getAlcance();
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
    
    
    
    public static Controlador getInstance() {
        return ControladorHolder.INSTANCE;
    }
    
    private static class ControladorHolder {

        private static final Controlador INSTANCE = new Controlador();
    }
}
