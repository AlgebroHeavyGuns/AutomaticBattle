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
import java.util.PriorityQueue;
import javafx.util.Pair;

/**
 *
 * @author Algebro
 */
public class searchAndDestroyBasicIA extends BasicIA{

    static PrimeroMasCercano primeroMasCercano = new PrimeroMasCercano();
    static PrimeroMasDebil primeroMasDebil = new PrimeroMasDebil();
    static PrimeroMasDebilitado primeroMasDebilitado = new PrimeroMasDebilitado();
    
    @Override
    Seleccion calcularAtaque(Unidad U) {
        primeroMasDebil.ref = U;
        return priorizaCalcularAtaque(U, primeroMasDebil);
    }

    Seleccion priorizaCalcularAtaque(Unidad U, Comparator C){
        Seleccion eleccion = new Seleccion();
        eleccion.decision = Accion.Atacar;
        ArrayList<Unidad> enemigas = Controlador.getInstance().getEnemigasEnAlcance(U);
        if(!enemigas.isEmpty()){
            enemigas.sort(C);
            eleccion.U = enemigas.get(0);
        }
        else
            return null;
        return eleccion;
    }
    
    Seleccion calcularMovimiento(Unidad U) {
        Seleccion accion = new Seleccion();
        accion.decision = Accion.Desplazamiento;
        if(U.getDistanciaMovimiento()==0)
            return null;
        
        int vX=0,vY=0;
        
        ArrayList<Unidad> enemigas = Controlador.getInstance().getEnemigasEnVision(U);
        ArrayList<Pair<Integer,Integer> > ruta = new ArrayList<>();
        if(enemigas.isEmpty()){
            System.out.println("No hay enemigos en rango (" + U.getNombre() + ")");
            ruta = calculaRuta(U, Controlador.getInstance().combateActual.getTablero().getTAM_X()/2,
                    Controlador.getInstance().combateActual.getTablero().getTAM_Y()/2);
            if(ruta.isEmpty())
                ruta = calculaRuta(U, Controlador.getInstance().combateActual.getTablero().getTAM_X()/2+1,
                                    Controlador.getInstance().combateActual.getTablero().getTAM_Y()/2);
            if(ruta.isEmpty())
                System.out.println("No se puede ir al centro.");
        }else{
            primeroMasCercano.ref = U;
            enemigas.sort(primeroMasCercano);
            Unidad enemigo;
            for(int i=0;i<enemigas.size() && ruta.isEmpty();i++){
                enemigo = enemigas.get(i);
                ruta = calculaRuta(U, enemigo.getPosX(), enemigo.getPosY());
            }
        }
        if(ruta.isEmpty()){
            System.out.println("No hay ruta");
            accion.decision = Accion.IDLE;
        }else{
            Pair<Integer,Integer> variacion;
            int mov = Math.min(U.getDistanciaMovimiento(), ruta.size());
            variacion = ruta.get(mov-1);
            vX += variacion.getKey()-U.getPosX();
            vY += variacion.getValue()-U.getPosY();
                
        }
        
        accion.movX=vX;
        accion.movY=vY;
        
        return accion;  
    }

   
    
    ArrayList<Pair<Integer, Integer> > calculaRuta(Unidad usuario, int objX, int objY){
        ArrayList<Pair<Integer, Integer> > ruta = new ArrayList<>();
        ArrayList<Pair<Integer, Integer> > camino = new ArrayList<>();
        int posX = usuario.getPosX(), posY= usuario.getPosY();
        int maximaDistancia;
        //maximaDistancia = usuario.getVisibilidad()+usuario.getAlcance();
        maximaDistancia = (int)(Controlador.getInstance().calculaDistancia(usuario.getPosX(), usuario.getPosY(),
                objX, objY)*1.5);
        maximaDistancia = Math.max(maximaDistancia, usuario.getVisibilidad());
        siguienteNodo(posX-1,posY, camino, ruta, objX, objY, maximaDistancia);
        siguienteNodo(posX+1,posY, camino, ruta, objX, objY, maximaDistancia);
        siguienteNodo(posX,posY-1, camino, ruta, objX, objY, maximaDistancia);
        siguienteNodo(posX,posY+1, camino, ruta, objX, objY, maximaDistancia);
        return ruta;
    } 
    
    
    boolean siguienteNodo(int posX, int posY, ArrayList<Pair<Integer,Integer> > camino,
            ArrayList<Pair<Integer,Integer> > solucion, int objX, int objY, int maximo){
        if(!Controlador.getInstance().posicionValidaNoOcupada(posX, posY))
            return false;
        if(camino.size() >= maximo || (!solucion.isEmpty() && camino.size()>=solucion.size()))
            return false;
        
        camino.add(new Pair<>(posX,posY));
        if(Controlador.getInstance().calculaDistancia(posX, posY, objX, objY)==1){
            if(mejorCamino(camino,solucion)){
                solucion.clear();
                solucion.addAll(camino);
                camino.remove(camino.size()-1);
                return true;
            }
            camino.remove(camino.size()-1);
            return false;
        }
        if(posX-posY > 0){
            //System.out.println("Arriba");
            siguienteNodo(posX-1,posY, camino, solucion, objX, objY, maximo);
            //System.out.println("Abajo");
            siguienteNodo(posX+1,posY, camino, solucion, objX, objY, maximo);
        }else{
            //System.out.println("Abajo");
            siguienteNodo(posX+1,posY, camino, solucion, objX, objY, maximo);
            //System.out.println("Arriba");
            siguienteNodo(posX-1,posY, camino, solucion, objX, objY, maximo);
        }
        //System.out.println("Izquierda");
        siguienteNodo(posX,posY-1, camino, solucion, objX, objY, maximo);
        //System.out.println("Derecha");
        siguienteNodo(posX,posY+1, camino, solucion, objX, objY, maximo);
        

        camino.remove(camino.size()-1);
        return false;
    }
    
    boolean mejorCamino(ArrayList<Pair<Integer,Integer> > camino,
            ArrayList<Pair<Integer,Integer> > solucion){
        return solucion.isEmpty() || camino.size()<solucion.size();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
 /*   
    private ArrayList<Pair<Integer, Integer> > calculaRutaN(Unidad usuario, int pasos, int objX, int objY){
        ArrayList<Pair<Integer,Integer> > ruta = new ArrayList<>();
        Comparator C = new Comparator<Pair<Integer,Integer> > () {
            Pair<Integer,Integer> ref = new Pair<>(objX,objY);
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return Controlador.getInstance().calculaDistancia(ref.getKey(), ref.getValue(), o1.getKey(), o1.getValue()) -
                        Controlador.getInstance().calculaDistancia(ref.getKey(), ref.getValue(), o2.getKey(), o2.getValue());
            }
        };
        
        PriorityQueue<Pair<Integer,Integer> > abiertos = new PriorityQueue<>(C);
        abiertos.add(new Pair<>(usuario.getPosX(), usuario.getPosY()));
        Pair<Integer, Integer> nodo;
        while(!abiertos.isEmpty() && ruta.size()<pasos){
            nodo = abiertos.poll();
            if(Controlador.getInstance().calculaDistancia(nodo.getKey(), nodo.getValue(), objX, objY)==1){
                ruta.add(nodo);
                abiertos.clear();
            }
            else{
                for(int i=-1;i<=1;i++)
                    for(int j=-1;j<=1;j++)
                        if(Math.abs(i)!=Math.abs(j) && Controlador.getInstance().posicionValidaNoOcupada(nodo.getKey()+i, nodo.getValue()+j))
                            abiertos.add(new Pair<>(nodo.getKey()+i,nodo.getValue()+j));
                if(nodo.getKey()!= usuario.getPosX() || nodo.getValue() != usuario.getPosY())
                    ruta.add(nodo);
            }
        }
        
        
        return ruta;
    }
    
    
*//*  
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

    static class PrimeroMasDebilitado implements Comparator<Unidad>{
        
        public Unidad ref=null;
        
        ///NEGATIVO SI EL PRIMER ARGUMENTO ES MENOR QUE EL SEGUNDO 
        @Override
        public int compare(Unidad o1, Unidad o2) {
            return o1.getVida() - o2.getVida();
        }
    }
    
    static class PrimeroMasDebil implements Comparator<Unidad>{
        
        public Unidad ref=null;
        
        ///NEGATIVO SI EL PRIMER ARGUMENTO ES MENOR QUE EL SEGUNDO 
        @Override
        public int compare(Unidad o1, Unidad o2) {
            return f(o1) - f(o2);
        }
        
        public int f(Unidad U){
            return U.getVida()+U.getArmadura()*5+U.getBlindaje()*2+U.getFuerza()*15;
        }
    }
    
}
