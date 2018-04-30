/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Micelaneous;

import Micelaneous.Accion;
import automaticbattle.Habilidad;
import automaticbattle.Unidad;

/**
 *
 * @author Algebro
 */
public interface decisionIA {
    
    
    Seleccion tomarDecision(Unidad U);
    
    
    
    public class Seleccion{
        public Accion decision=Accion.IDLE;
        public Unidad U=null;
        public Habilidad H=null;
        //public Objeto O=null;
        public int movX=0;
        public int movY=0;

        @Override
        public String toString() {
            return "Seleccion{" + "decision=" + decision + ", U=" + U + ", movX=" + movX + ", movY=" + movY + '}';
        }
        
        

    }
  
}
