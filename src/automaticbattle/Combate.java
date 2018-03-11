/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author Algebro
 */
public class Combate {
    private String nombre;
    private ArrayList<Unidad> equipoUno;
    private ArrayList<Unidad> equipoDos;
    private Queue<Unidad> colaTurno;
    
    private ArrayList<Unidad> aliadas;
    private ArrayList<Unidad> enemigas;
    
    public void nextTurn(){
        Unidad unidad = colaTurno.poll();

        if(equipoUno.contains(unidad)){
            aliadas=equipoUno;
            enemigas=equipoDos;
        }else{
            aliadas=equipoDos;
            enemigas=equipoUno;
        }
        
        unidad.efectoTurnoPropio();
        for(Unidad U:aliadas)
            if(U != unidad)
                U.efectoTurnoUnidadAliada(unidad);
        for(Unidad U:enemigas)
            U.efectoTurnoUnidadEnemiga(unidad);
        
        IA.Seleccion decision = unidad.getIAAsociada().tomarDecision(unidad);
        
        activarEfectosDecision(unidad,decision);
        realizarAccion(unidad, decision);
        
        colaTurno.add(unidad);
    }
    
    public void activarEfectosDecision(Unidad unidad, IA.Seleccion decision){
        switch(decision.decision){
            case Desplazamiento:
                unidad.efectoDesplazarse();
                for(Unidad U:aliadas)
                    if(U != unidad)
                        U.efectoUnidadAliadaMueve(U, unidad.getPosX(), unidad.getPosY(), decision.movX, decision.movY);
                for(Unidad U:enemigas)
                    U.efectoUnidadEnemigaMueve(U,  unidad.getPosX(), unidad.getPosY(), decision.movX, decision.movY);
                break;
            case Atacar:
                unidad.efectoAtacar(decision.U);
                for(Unidad U:aliadas)
                    if(U != unidad)
                    U.efectoUnidadAliadaAtaca(unidad, decision.U);
                for(Unidad U:enemigas)
                    U.efectoUnidadEnemigaAtaca(unidad, decision.U); 
                break;
            case Habilidad:
            case Objeto:
                throw new UnsupportedOperationException("Not supported yet."); 
            case IDLE:
                unidad.efectoNoHacerNada();
                for(Unidad U:aliadas)
                    if(U != unidad)
                        U.efectoUnidadAliadaNoHaceNada(unidad);
                for(Unidad U:enemigas)
                    U.efectoUnidadEnemigaNoHaceNada(unidad);
        }
    }
    
    
    private void realizarAccion(Unidad actor, IA.Seleccion decision){
        switch(decision.decision){
            case Desplazamiento:
            case Atacar:
            case Habilidad:
            case Objeto:
            case IDLE:
               throw new UnsupportedOperationException("Not supported yet."); 
        }
    }

    
}
