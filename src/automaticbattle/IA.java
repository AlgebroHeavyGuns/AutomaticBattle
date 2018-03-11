/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

import Micelaneous.Accion;

/**
 *
 * @author Algebro
 */
public interface IA {
    
    
    Seleccion tomarDecision(Unidad U);
    
    
    
    public class Seleccion{
        public Accion decision=Accion.IDLE;
        public Unidad U=null;
        //public Habilidad H=null;
        //public Objeto O=null;
        public int movX=0;
        public int movY=0;
    }
  
}
