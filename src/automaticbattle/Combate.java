/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

import GUI.CombatePanel;
import Micelaneous.decisionIA;
import Micelaneous.Accion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

/**
 *
 * @author Algebro
 */
public final class Combate {
    private String nombre;
    private ArrayList<Unidad> equipoUno;
    private ArrayList<Unidad> equipoDos;
    private ArrayList<Unidad> colaTurno;
    
    private ArrayList<Unidad> aliadas;
    private ArrayList<Unidad> enemigas;
    private Tablero tablero;
    
    public CombatePanel panel;
    
    public Combate(String nombre, ArrayList<Unidad> uno, ArrayList<Unidad> dos, Tablero tablero){
        this.nombre = nombre;
        this.equipoUno = uno;
        this.equipoDos = dos;
        this.tablero = tablero;
    }
    
    public void rellenaCola(){
        colaTurno = new ArrayList<>();
        colaTurno.addAll(equipoUno);
        colaTurno.addAll(equipoDos);
        Collections.shuffle(colaTurno);
        
    }
    
    public void iniciaCombate(){
        rellenaCola();
        for(Unidad U:equipoDos)
            U.fijaActual();
        for(Unidad U:equipoUno){
            U.fijaActual();
            U.efectoInicioEnfrentamiento();
        }
        for(Unidad U:equipoDos)
            U.efectoInicioEnfrentamiento();
    }
    
    public void nextTurn(){
        Unidad unidad = colaTurno.remove(0);
        

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
        
        decisionIA.Seleccion decision = unidad.getIAAsociada().tomarDecision(unidad);
        
        if(!Controlador.getInstance().comprobarAccion(unidad,decision))
            decision.decision=Accion.IDLE;
        
        activarEfectosDecision(unidad,decision);
        realizarAccion(unidad, decision);
        colaTurno.add(unidad);
        comprobarMuertos();
    }
    
    public void activarEfectosDecision(Unidad unidad, decisionIA.Seleccion decision){
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
    
    
    private void realizarAccion(Unidad actor, decisionIA.Seleccion decision){
        switch(decision.decision){
            case Desplazamiento:
                tablero.swap(actor, decision.movX, decision.movY);
                actor.MoverA(decision.movX, decision.movY);
                panel.insertarInfo(actor.getNombre() + " desplazado.");
                break;
            case Atacar:
                double probAcierto = 1-0.08*decision.U.getAgilidad();
                double tirada = Math.random();
                actor.efectoAtacar(decision.U,tirada,tirada<=probAcierto);
                if(tirada<=probAcierto){
                    int danio = 2*actor.getFuerza()-decision.U.getArmadura();
                    danio *= actor.getEfectividadAtaque(decision.U);
                    if(danio > 0){
                        decision.U.efectoUnidadAtacada(actor, tirada, danio);
                        decision.U.modVidaActual(-danio);
                        panel.insertarInfo(actor.getNombre() + " atacó a "  + decision.U.getNombre() + "\nrealizó " + danio + " de daño."
                                + "Vida restante : " + decision.U.getVida());
                    }else
                        panel.insertarInfo(actor.getNombre() + " atacó a "  + decision.U.getNombre() + " pero no le causó daño");
                }else
                    panel.insertarInfo(actor.getNombre() + " atacó a "  + decision.U.getNombre() + " pero falló");
                break;     
            case Habilidad:
            case Objeto:
                throw new UnsupportedOperationException("Not supported yet.");
            case IDLE: 
        }
    }
    
    void comprobarMuertos(){
        ArrayList<Unidad> copia = new ArrayList<>(aliadas);
        for(Unidad U: copia)
            if(U.getVida() < 0)
                eliminarUnidad(U,aliadas);
        copia = new ArrayList<>(enemigas);
        for(Unidad U: copia)
            if(U.getVida() < 0)
                eliminarUnidad(U,enemigas);  
    }
    
    private void eliminarUnidad(Unidad U, ArrayList<Unidad> lista){
        lista.remove(U);
        colaTurno.remove(U);
        tablero.eliminaUnidad(U);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Unidad> getEquipoUno() {
        return equipoUno;
    }

    public ArrayList<Unidad> getEquipoDos() {
        return equipoDos;
    }

    public ArrayList<Unidad> getColaTurno() {
        return colaTurno;
    }

    public ArrayList<Unidad> getAliadas() {
        return aliadas;
    }

    public ArrayList<Unidad> getEnemigas() {
        return enemigas;
    }

    public Tablero getTablero() {
        return tablero;
    }

    
    
    
}
