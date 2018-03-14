/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

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
        combateActual = new Combate("Prueba", new ArrayList<>(), new ArrayList<>(), new Tablero(7,7));
    }
    
    
    public static Controlador getInstance() {
        return ControladorHolder.INSTANCE;
    }
    
    private static class ControladorHolder {

        private static final Controlador INSTANCE = new Controlador();
    }
}
