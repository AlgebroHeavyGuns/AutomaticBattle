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
        lista.add(new JeroGuerrero());
        lista.add(new MartinPaladin());
        lista.add(new TeodoraCazadora());
        lista.add(new AuroraLuchadora());
        return lista;
    }
    
    /*
    
    Atributos(int vida, int energia, int fuerza, int intelecto, 
            int armadura, int blindaje, int velocidad, int agilidad, int visibilidad)
    */
    
    
            
    static class JeroGuerrero extends Unidad{
        private int vidaInicial;
        
        public JeroGuerrero() {
            super("Jero Guerrero", "CharacterHumanMale.png", "Todo o nada.", TipoUnidad.Humano, 
                    new Atributos(175,90,9,5,5,5,4,3,6));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }



        @Override
        public void efectoTurnoPropio(){
            int heal = vidaInicial - this.getVida();
            heal *= 0.2;
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
                        + "Y aumentó su fuerza un 18% (" + this.getFuerza() + " a " + this.modFuerza((int)(this.getFuerza()*0.18)) + ")");
            else
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se concentra,y aumenta \n"
                        + "en 2 su velocidad (" + this.getVelocidad() + " a " + this.modVelocidad(2) + ")");
            
        }
        
        @Override
        public Unidad getCopia() {
            return new JeroGuerrero();
        }
    
    }
    
    static class MartinPaladin extends Unidad{
        
        public MartinPaladin() {
            super("Martín Paladín", "CharacterBloodElfMale.png", "No sin mi equipo.", TipoUnidad.Humano, 
                    new Atributos(190,120,7,6,5,5,5,3,7));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }


        @Override
        public void efectoTurnoUnidadAliada(Unidad U) {
            if(U!=this){
                int vida = (int)(this.getFuerza()*(Math.random()*0.11+0.25));
                Controlador.getInstance().combateActual.panel.insertarInfo(
                        this.getNombre() + " curó  a " + U.getNombre() + " " + vida + " puntos de salud.");
                Controlador.getInstance().apCurarUnidad(U, vida);
            }
        }
        
        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            int vida = 0;
            if(tirada>0.8)
                vida = (int)((objetivo.getVida()*0.05));
            else if(!acierto)
                vida = (int)((this.getArmadura()+this.getBlindaje())*0.35);
            if(vida > 0){
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se curó " + vida + " de salud.");
                Controlador.getInstance().apCurarUnidad(this, vida);
            }
        }
        
        @Override
        public Unidad getCopia() {
            return new MartinPaladin();
        }
    
    }
    
    //
    
    static class TeodoraCazadora extends Unidad{
        
        public TeodoraCazadora() {
            super("Teodora Cazadora", "CharacterNightElfFemale.png", "Un susurro, una lágrima, un cadaver.", TipoUnidad.Elfo, 
                    new Atributos(115,120,9,4,3,3,7,4,7));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }

        
        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            if(this.getAlcance()>1){
                int dano = (int)(objetivo.getVida()*0.1 + 0.2*(this.getFuerza()+this.getIntelecto()));
                if(tirada<0.35){
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
            super("Aurora Luchadora", "CharacterDwarfFemale.png", "Quiero ver al que dijo que la guerra\nes cosa de hombres.", TipoUnidad.Humano, 
                    new Atributos(240,80,5,4,8,7,4,3,5));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }


        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            int dano = (int)(this.getArmadura()*0.5);
            if(dano > 0){
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " realizó " + dano + " de daño extra al rival!");
                Controlador.getInstance().apHerirUnidad(this, objetivo, dano);
            }
        }
        
        @Override
        public Unidad getCopia() {
            return new AuroraLuchadora();
        }
    
    }
    
}
