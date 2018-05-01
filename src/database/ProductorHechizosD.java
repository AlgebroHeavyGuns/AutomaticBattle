/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Micelaneous.TipoHabilidad;
import automaticbattle.Controlador;
import automaticbattle.Escenografia;
import automaticbattle.Habilidad;
import automaticbattle.Unidad;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public class ProductorHechizosD {
    static ArrayList<Habilidad> getHabilidades(){
        ArrayList<Habilidad> lista = new ArrayList<>();
        lista.add(new DardoVenenoso());
        return lista;
    }
    
    static class DardoVenenoso extends Habilidad{

        public DardoVenenoso() {
            super("Dardo venenoso", "Hace daño segun la vida maxima", 65, 0, 4, TipoHabilidad.ENEMIGO);
        }
        
        private int getDano(Unidad lanzador, Unidad objetivo){
            return (int) (15 + objetivo.getVidaInicial()*0.07 + 
                    lanzador.getIntelecto() + lanzador.getFuerza()) - objetivo.getBlindaje();
        }

        @Override
        public boolean tieneEfecto(Unidad lanzador, Unidad objetivo) {
            return getDano(lanzador,objetivo) > 10;
        }
        
        @Override
        public void realizarEfecto(Unidad lanzador, Unidad receptor) {
            int dano = this.getDano(lanzador, receptor);
            Controlador.getInstance().apMostrarMensaje(
                            lanzador.getNombre() + " hizo a " + receptor.getNombre() + " " + dano + " puntos de daño.");
            Controlador.getInstance().apHerirUnidad(lanzador, receptor, dano);
        }

        @Override
        public Habilidad getCopia() {
           return new DardoVenenoso();
        }

    }
    
    static class Embiste extends Habilidad{

        public Embiste() {
            super("Embiste", "Hace daño segun la vida maxima y a si mismo.", 35, 0, 1, TipoHabilidad.ENEMIGO);
        }
        
        private int getDano(Unidad lanzador, Unidad objetivo){
            return (int) (lanzador.getVida()*0.15 +
                    objetivo.getVidaInicial()*0.1) - 2*objetivo.getBlindaje();
        }

        @Override
        public boolean tieneEfecto(Unidad lanzador, Unidad objetivo) {
            return getDano(lanzador,objetivo) > 5;
        }
        
        @Override
        public void realizarEfecto(Unidad lanzador, Unidad receptor) {
            int dano = this.getDano(lanzador, receptor);
            
            Controlador.getInstance().apMostrarMensaje(
                            lanzador.getNombre() + " hizo a " + receptor.getNombre() + " " + dano + " puntos de daño.");
            Controlador.getInstance().apHerirUnidad(lanzador, receptor, dano);
            dano = (int)(dano*0.1);
            if(dano>0){
                Controlador.getInstance().apHerirUnidad(lanzador, lanzador, dano);
                Controlador.getInstance().apMostrarMensaje(
                            lanzador.getNombre() + " se hizo " + dano + " de daño a sí mismo.");
            }
        }

        @Override
        public Habilidad getCopia() {
           return new Embiste();
        }

    }
    
}
