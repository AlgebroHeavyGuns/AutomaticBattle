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
public class deciaBasicIA implements decisionIA{

    Controlador control = Controlador.getInstance();
    
    @Override
    public Seleccion tomarDecision(Unidad U) {
        
        Seleccion accion = randomAtaque(U);
        if(accion == null)
            accion = randomMovimiento(U);
        return accion;
    }
    
    Seleccion randomAtaque(Unidad U){
        Seleccion accion = new Seleccion();
        ArrayList<Unidad> casos = new ArrayList<>();
        accion.decision = Accion.Atacar;
        int alc = U.getAlcance();
        for(int i=-alc;i<=alc;i++)
            for(int j=-alc+Math.abs(i);j<=alc-Math.abs(i);j++)
                if(Controlador.getInstance().combateActual.getTablero().coordenadasValidas(U.getPosX()+i,U.getPosY()+j)){
                    Unidad obj =  Controlador.getInstance().combateActual.getTablero().ocupada(U.getPosX()+i,U.getPosY()+j);
                    if(obj != null && Controlador.getInstance().combateActual.getEnemigas().contains( obj ))
                        casos.add(obj);
                }
                        
        
        if(casos.isEmpty())
            return null;
        accion.U = casos.get((int)(casos.size()*Math.random()));
        return accion;
    }
    
    Seleccion randomMovimiento(Unidad U){
        Seleccion accion = new Seleccion();
        ArrayList<Pair<Integer,Integer> > casos = new ArrayList<>();
        accion.decision = Accion.Desplazamiento;
        int desp = U.getDistanciaMovimiento();
        for(int i=-desp;i<=desp;i++)
            for(int j=-desp+Math.abs(i);j<=desp-Math.abs(i);j++)
                if(i!=0||j!=0)
                    if(Controlador.getInstance().combateActual.getTablero().coordenadasValidas(U.getPosX()+i,U.getPosY()+j) &&
                        Controlador.getInstance().combateActual.getTablero().ocupada(U.getPosX()+i,U.getPosY()+j) == null )
                        casos.add(new Pair<>(i,j));
        
        if(casos.isEmpty())
            return null;
        Pair<Integer,Integer> par = casos.get((int)(casos.size()*Math.random()));
        accion.movX = par.getKey();
        accion.movY = par.getValue();
        return accion;
        
    }
    
    
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
