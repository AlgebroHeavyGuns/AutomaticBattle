/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

/**
 *
 * @author Algebro
 */
public class Controlador {
    
    public Combate combateActual = null;
    
    private Controlador() {
    }
    
    public void iniciaCombate(){
    
    }
    
    
    public static Controlador getInstance() {
        return ControladorHolder.INSTANCE;
    }
    
    private static class ControladorHolder {

        private static final Controlador INSTANCE = new Controlador();
    }
}
