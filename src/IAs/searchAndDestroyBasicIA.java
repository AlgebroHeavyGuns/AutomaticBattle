/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IAs;

import Micelaneous.Accion;
import automaticbattle.Controlador;
import automaticbattle.Unidad;
import java.util.ArrayList;
import java.util.Comparator;
import javafx.util.Pair;

/**
 *
 * @author Algebro
 */
public class searchAndDestroyBasicIA extends BasicIA{

    static PrimeroMasCercano primeroMasCercano = new PrimeroMasCercano();
    
    @Override
    Seleccion calcularAtaque(Unidad U) {
        Seleccion eleccion = new Seleccion();
        eleccion.decision = Accion.Atacar;
        ArrayList<Unidad> enemigas = Controlador.getInstance().getEnemigasEnAlcance(U);
        if(!enemigas.isEmpty()){
            primeroMasCercano.ref = U;
            enemigas.sort(primeroMasCercano);
            eleccion.U = enemigas.get(0);
        }
        else
            return null;
        return eleccion;
    }

    /*
    ABIERTOS := [INICIAL] //inicialización 
CERRADOS := [] 
f'(INICIAL) := h'(INICIAL) 
repetir 
si ABIERTOS = [] entonces FALLO 
si no // quedan nodos 
extraer MEJORNODO de ABIERTOS con f' mí­nima 
// cola de prioridad 
mover MEJORNODO de ABIERTOS a CERRADOS 
si MEJORNODO contiene estado_objetivo entonces 
SOLUCION_ENCONTRADA := TRUE 
si no 
generar SUCESORES de MEJORNODO 
para cada SUCESOR hacer TRATAR_SUCESOR 
hasta SOLUCION_ENCONTRADA o FALLO
    */
    
    
    Seleccion calcularMovimiento(Unidad U) {
        Seleccion accion = new Seleccion();
        accion.decision = Accion.Desplazamiento;

        ArrayList<Pair<Integer,Integer> > ruta = new ArrayList<>();
        
        
        return accion;  
    }
    
    
 /*   
    @Override
    Seleccion calcularMovimiento(Unidad U) {
        Seleccion eleccion = new Seleccion();
        eleccion.decision = Accion.Desplazamiento;
        int vX,vY,total;
        
        ArrayList<Unidad> enemigas = Controlador.getInstance().getEnemigasEnVision(U);
        if(!enemigas.isEmpty()){
            primeroMasCercano.ref = U;
            enemigas.sort(primeroMasCercano);
            vX = enemigas.get(0).getPosX()-U.getPosX();
            vY = enemigas.get(0).getPosY()-U.getPosY();
            total = Math.abs(vX) + Math.abs(vY);
        }
        else{
            //Va al centro del mapa a buscar enemigos
            if(U.getPosX() > Controlador.getInstance().combateActual.getTablero().getTAM_X()/2)
                vX = -U.getPosX();
            else
                vX = Controlador.getInstance().combateActual.getTablero().getTAM_X()-1;
            if(U.getPosY() > Controlador.getInstance().combateActual.getTablero().getTAM_Y()/2)
                vY = -U.getPosY();
            else
                vY = Controlador.getInstance().combateActual.getTablero().getTAM_Y()-1;
            total = Math.abs(vX) + Math.abs(vY);

        }
        if(vX==vY){
            if(U.getPosX()<U.getPosY())
                vX-= vX/Math.abs(vX);
            else
                vY-= vY/Math.abs(vY);
            total--;
        }
        vX = (int) Math.round(U.getDistanciaMovimiento()*(double)vX/total);
        vY = (int) Math.round(U.getDistanciaMovimiento()*(double)vY/total);
        if((Math.abs(vX)+Math.abs(vY)) > U.getDistanciaMovimiento()){
            if(U.getPosX()<U.getPosY())
                vX-= vX/Math.abs(vX);
            else
                vY-= vY/Math.abs(vY);
        }  
        if(Controlador.getInstance().combateActual.getTablero().ocupada(U.getPosX()+vX, U.getPosY()+vY)!=null){
            if(enemigas.isEmpty()){
                int aux=vX; vX = vY; vY=aux;
                if(Controlador.getInstance().combateActual.getTablero().ocupada(U.getPosX()+vX, U.getPosY()+vY)!=null)
                    return null;
            }else if(U.getDistanciaMovimiento()==1){
                int aux=vX; vX = vY; vY=aux;
                if(Math.abs(enemigas.get(0).getPosX()-U.getPosX()) > 0)
                    vX*= (enemigas.get(0).getPosX()-U.getPosX())/Math.abs(enemigas.get(0).getPosX()-U.getPosX());
                if(Math.abs(enemigas.get(0).getPosY()-U.getPosY()) > 0 )
                    vY*= (enemigas.get(0).getPosY()-U.getPosY())/Math.abs(enemigas.get(0).getPosY()-U.getPosY());
                if(Controlador.getInstance().combateActual.getTablero().ocupada(U.getPosX()+vX, U.getPosY()+vY)!=null)
                    return null;
            }else{
                int auxX=vX, auxY=vY;
                if(vX>1)
                    auxX-=1;
                else if(vX<-1)
                    auxX+=1;
                else if(vY>=1)
                    auxY-=1;
                else if(vY<=1)
                    auxY+=1;
                if(Controlador.getInstance().combateActual.getTablero().ocupada(U.getPosX()+auxX, U.getPosY()+auxY)!=null){
                    int aux=vX;  vX = vY; vY=aux;
                    if(Math.abs(enemigas.get(0).getPosX()-U.getPosX()) > 0)
                        vX*= (enemigas.get(0).getPosX()-U.getPosX())/Math.abs(enemigas.get(0).getPosX()-U.getPosX());
                    if(Math.abs(enemigas.get(0).getPosY()-U.getPosY()) > 0 )
                        vY*= (enemigas.get(0).getPosY()-U.getPosY())/Math.abs(enemigas.get(0).getPosY()-U.getPosY());
                    if(Controlador.getInstance().combateActual.getTablero().ocupada(U.getPosX()+vX, U.getPosY()+vY)!=null)
                        return null;
                }else{
                    vX=auxX; vY=auxY;
                }
            }
        }
        eleccion.movX=vX;
        eleccion.movY=vY;
        return eleccion;    
    }
*/    
    
    static class PrimeroMasCercano implements Comparator<Unidad>{
        
        public Unidad ref=null;
        
        ///NEGATIVO SI EL PRIMER ARGUMENTO ES MENOR QUE EL SEGUNDO 
        @Override
        public int compare(Unidad o1, Unidad o2) {
            return Controlador.getInstance().calculaDistancia(o1.getPosX(), o1.getPosY(), ref.getPosX(), ref.getPosY()) 
                    - Controlador.getInstance().calculaDistancia(o2.getPosX(), o2.getPosY(), ref.getPosX(), ref.getPosY());
        }

}
    
}
