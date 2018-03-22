/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import IAs.*;
import Micelaneous.Atributos;
import Micelaneous.TipoUnidad;
import automaticbattle.Controlador;
import automaticbattle.Unidad;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public class ProductorUnidadesD {
    
    static ArrayList<Unidad> getUnidades(){
        ArrayList<Unidad> lista = new ArrayList<>();
        lista.add(new PatricioGuerrero());
        lista.add(new JoaquinPaladin());
        lista.add(new TeodoraCazadora());
        lista.add(new AuroraLuchadora());
        return lista;
    }
    
    /*
    
    Atributos(int vida, int energia, int fuerza, int intelecto, 
            int armadura, int blindaje, int velocidad, int agilidad, int visibilidad)
    */
    
    
            
    static class PatricioGuerrero extends Unidad{
        private int vidaInicial;
        
        public PatricioGuerrero() {
            super("Patricio Guerrero", "CharacterHumanMale.png", "Todo o nada.", TipoUnidad.Humano, 
                    new Atributos(165,90,10,5,6,5,4,3,6));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }



        @Override
        public void efectoTurnoPropio(){
            int heal = vidaInicial - this.getVida();
            heal *= 0.15;
            if(heal > 0){
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se curó " + heal + " puntos de salud.");
                Controlador.getInstance().apCurarUnidad(this, heal);
            }
        }

        @Override
        public void efectoInicioEnfrentamiento() {
            vidaInicial=this.getVida();
            if(Math.random()>0.4)
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " grita : " + "\"¡Todo o nada!\"\n"
                        + "Y aumentó su fuerza un 15% (" + this.getFuerza() + " a " + this.modFuerza((int)(this.getFuerza()*0.15)) + ")");
            else
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se concentra,y aumenta \n"
                        + "en 2 su velocidad (" + this.getVelocidad() + " a " + this.modVelocidad(2) + ")");
            
        }
        
        @Override
        public Unidad getCopia() {
            return new PatricioGuerrero();
        }
    
    }
    
    static class JoaquinPaladin extends Unidad{
        
        public JoaquinPaladin() {
            super("Joaquín Paladín", "CharacterBloodElfMale.png", "No sin mi equipo.", TipoUnidad.Humano, 
                    new Atributos(200,120,8,6,5,5,5,3,7));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }


        @Override
        public void efectoTurnoUnidadAliada(Unidad U) {
            if(U!=this){
                int vida = (int)(this.getFuerza()*(Math.random()*0.21+0.4));
                Controlador.getInstance().combateActual.panel.insertarInfo(
                        this.getNombre() + " curó  a " + U.getNombre() + " " + vida + " puntos de salud.");
                Controlador.getInstance().apCurarUnidad(U, vida);
            }
        }
        
        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            int vida = 0;
            if(tirada>0.85)
                vida = (int)((objetivo.getVida()*0.1));
            else if(!acierto)
                vida = (int)((this.getArmadura()+this.getBlindaje())*0.6);
            if(vida > 0){
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se curó " + vida + " de salud.");
                Controlador.getInstance().apCurarUnidad(this, vida);
            }
        }
        
        @Override
        public Unidad getCopia() {
            return new JoaquinPaladin();
        }
    
    }
    
    //
    
    static class TeodoraCazadora extends Unidad{
        
        public TeodoraCazadora() {
            super("Teodora Cazadora", "CharacterNightElfFemale.png", "Un susurro, una lágrima, un cadaver.", TipoUnidad.Elfo, 
                    new Atributos(110,110,10,4,3,3,6,4,7));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }

        
        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            if(this.getAlcance()>1){
                int dano = (int)(objetivo.getVida()*0.1 + 0.5*(this.getFuerza()+this.getIntelecto()));
                if(tirada<0.25){
                    Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " realizó " + dano + " de daño extra al rival!");
                    Controlador.getInstance().apHerirUnidad(this, objetivo, dano);
                }
            }else if(tirada < 0.3){
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " bajó la armadura de " + objetivo.getNombre()
                        + "\nen 1 (" + objetivo.getArmadura() + " a " + objetivo.modArmadura(-1) + ")");
            }
        }
        
        @Override
        public Unidad getCopia() {
            return new TeodoraCazadora();
        }
    
    }
    
    
    static class AuroraLuchadora extends Unidad{
        
        public AuroraLuchadora() {
            super("Aurora luchadora", "CharacterDwarfFemale.png", "Un susurro, una lágrima, un cadaver.", TipoUnidad.Humano, 
                    new Atributos(220,80,6,4,9,8,4,3,5));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }

        
        
        @Override
        public Unidad getCopia() {
            return new AuroraLuchadora();
        }
    
    }
    
}
