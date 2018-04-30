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
public class Estadisticas {
    
    ArrayList<Unidad> uno, dos;
    int saludInicialUno=0;
    int saludInicialDos=0;
    int danoRecibidoUno=0;
    int danoRecibidoDos=0;
    int danoEfectuadoUno=0;
    int danoEfectuadoDos=0;
    int curacionUno=0;
    int curacionDos=0;

    public Estadisticas(ArrayList<Unidad> uno, ArrayList<Unidad> dos) {
        this.uno = uno;
        for(Unidad U:uno)
            saludInicialUno+=U.getVida();
        this.dos = dos;
        for(Unidad U:dos)
            saludInicialDos+=U.getVida();        
    }
    
    public void haHeridoUnidad(Unidad actor, Unidad objetivo, int herida){
        if(dos.contains(objetivo)){
            danoRecibidoDos +=herida;
            if(actor!=objetivo)
                danoEfectuadoUno += herida;
        }else{
            danoRecibidoUno +=herida;
            if(actor!=objetivo)
                danoEfectuadoDos += herida;
        }
    }
    
    public void curadoUnidad(Unidad actor, int cura){
        if(uno.contains(actor))
            curacionUno+=cura;
        else
            curacionDos+=cura;
    }

    public int getSaludInicialUno() {
        return saludInicialUno;
    }

    public int getSaludInicialDos() {
        return saludInicialDos;
    }

    
    
    
    public int getCuracionUno() {
        return curacionUno;
    }

    public int getCuracionDos() {
        return curacionDos;
    }

    
    public int getDanoRecibidoUno() {
        return danoRecibidoUno;
    }

    public int getDanoRecibidoDos() {
        return danoRecibidoDos;
    }

    public int getDanoEfectuadoUno() {
        return danoEfectuadoUno;
    }

    public int getDanoEfectuadoDos() {
        return danoEfectuadoDos;
    }
    
    
    
}
