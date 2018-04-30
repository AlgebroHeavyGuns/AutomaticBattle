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

        return lista;
    }
    
    static class SanacionMenor extends Habilidad{

        public SanacionMenor() {
            super("Sanación menor", "Sana", 30, 0, 5, TipoHabilidad.ALIADO);
        }
        
        private int getSanacion(Unidad lanzador, Unidad objetivo){
            return (int) (objetivo.getVidaInicial()*0.1 + lanzador.getIntelecto());
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
            Controlador.getInstance().apMostrarMensaje(
                            lanzador.getNombre() + " curó a " + receptor.getNombre() + " " + sana + " puntos de salud.");
            Controlador.getInstance().apCurarUnidad(receptor, sana);
        }


    }
    
}
