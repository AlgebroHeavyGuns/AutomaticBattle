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
public class randomBasicIA extends BasicIA{
    
    
    @Override
    Seleccion calcularAtaque(Unidad U) {
        return randomAtaque(U);
    }

    @Override
    Seleccion calcularMovimiento(Unidad U) {
        return randomMovimiento(U);
    }
    
    decisionIA.Seleccion randomAtaque(Unidad U){
        decisionIA.Seleccion accion = new decisionIA.Seleccion();
        ArrayList<Unidad> casos = new ArrayList<>();
        accion.decision = Accion.Atacar;
        int alc = U.getAlcance();
        if(alc > U.getVisibilidad())
            alc=U.getVisibilidad();
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
    
    decisionIA.Seleccion randomMovimiento(Unidad U){
        decisionIA.Seleccion accion = new decisionIA.Seleccion();
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

}
