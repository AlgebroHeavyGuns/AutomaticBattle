/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IAs;

import Micelaneous.Accion;
import Micelaneous.decisionIA;
import automaticbattle.Controlador;
import automaticbattle.Unidad;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author Algebro
 */
public abstract class BasicIA implements decisionIA{

    Controlador control = Controlador.getInstance();
    
    @Override
    public Seleccion tomarDecision(Unidad U) {
        Seleccion accion = calcularHabilidad(U);
        if(accion == null)
            accion = calcularAtaque(U);
        if(accion == null)
            accion = calcularMovimiento(U);
        if(accion == null){
            System.out.println("Ninguna accion elegida");
            accion = new Seleccion();
            accion.decision=Accion.IDLE;
        }
        return accion;
    }
    
    abstract Seleccion calcularAtaque(Unidad U);
    abstract Seleccion calcularMovimiento(Unidad U);
    abstract Seleccion calcularHabilidad(Unidad U);
    
    
    
    
    
    /*
    Seleccion randomMov(Unidad U){
        Seleccion accion = new Seleccion();
        accion.decision = Accion.Desplazamiento;
        int minX,minY,maxX,maxY;
        if(U.getPosX()>U.getDistanciaMovimiento())
            minX = -U.getDistanciaMovimiento();
        else
            minX = -U.getPosX();
        if(control.combateActual.getTablero().getTAM_X()-U.getPosX()-1>U.getDistanciaMovimiento())
            maxX = U.getDistanciaMovimiento();
        else
            maxX = control.combateActual.getTablero().getTAM_X()-U.getPosX()-1;
        if(U.getPosY()>U.getDistanciaMovimiento())
            minY = -U.getDistanciaMovimiento();
        else
            minY = -U.getPosY();
        if(control.combateActual.getTablero().getTAM_Y()-U.getPosY()-1>U.getDistanciaMovimiento())
            maxY = U.getDistanciaMovimiento();
        else
            maxY = control.combateActual.getTablero().getTAM_Y()-U.getPosY()-1;
        
        accion.movX = ((int)(Math.random()*(maxX-minX+1))+minX);
        accion.movY = ((int)(Math.random()*(maxY-minY+1))+minY);
        while(accion.movX == accion.movY && accion.movX==0)
            if(Math.random()>0.5)
                accion.movX = ((int)(Math.random()*(maxX-minX+1))+minX);
            else
                accion.movY = ((int)(Math.random()*(maxY-minY+1))+minY);
        System.out.println("IA MOV : " + accion.movX + "," + accion.movY);
        while(control.calculaDistancia(accion.movX, accion.movY, 0, 0) > U.getDistanciaMovimiento())
            if(Math.random()>0.5)
                accion.movX-= accion.movX * 1/Math.abs(accion.movX);
            else
                accion.movY-= accion.movY * 1/Math.abs(accion.movY);
        
        return accion;
    }
    */
}
