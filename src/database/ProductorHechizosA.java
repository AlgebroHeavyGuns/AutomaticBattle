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
public class ProductorHechizosA {
    static ArrayList<Habilidad> getHabilidades(){
        ArrayList<Habilidad> lista = new ArrayList<>();
        lista.add(new SanacionMenor());
        return lista;
    }
    
    static class SanacionMenor extends Habilidad{

        public SanacionMenor() {
            super("Sanación menor", "Sana", 45, 0, 5, TipoHabilidad.ALIADO);
        }
        
        private int getSanacion(Unidad lanzador, Unidad objetivo){
            return (int) (objetivo.getVidaInicial()*0.125 + lanzador.getIntelecto());
        }

        @Override
        public boolean tieneEfecto(Unidad lanzador, Unidad objetivo) {
            return objetivo.getVidaInicial() >= 
                    objetivo.getVida()+(int)(getSanacion(lanzador,objetivo)*0.5);
        }
        
        @Override
        public void realizarEfecto(Unidad lanzador, Unidad receptor) {
            int sana = getSanacion(lanzador,receptor);
            int diferencia = receptor.getVidaInicial() - receptor.getVida();
            if(sana > diferencia)
                sana = diferencia;
            if(lanzador!=receptor)
                Controlador.getInstance().apMostrarMensaje(
                            lanzador.getNombre() + " curó a " + receptor.getNombre() + " " + sana + " puntos de salud.");
            else
                Controlador.getInstance().apMostrarMensaje(
                            lanzador.getNombre() + " se curó " + sana + " puntos de salud.");
            Controlador.getInstance().apCurarUnidad(receptor, sana);
        }

        @Override
        public Habilidad getCopia() {
            return new SanacionMenor();
        }

    }
    
    
    static class DisparoCertero extends Habilidad{

        public DisparoCertero() {
            super("Disparo certero", "Hace mucho daño", 75, 0, 8, TipoHabilidad.ENEMIGO);
        }
        
        private int getDano(Unidad lanzador, Unidad objetivo){
            return (int) (40 + objetivo.getVidaInicial()*0.135 + 
                    lanzador.getFuerza()) - 2*objetivo.getBlindaje();
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
            return new DisparoCertero();
        }

    }
    
    
}
