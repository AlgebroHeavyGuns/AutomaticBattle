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
        
        public JeroGuerrero() {
            super("Jero Guerrero", "CharacterHumanMale.png", "Todo o nada.", TipoUnidad.Humano, 
                    new Atributos(180,90,8,5,5,5,4,3,6));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }



        @Override
        public void efectoTurnoPropio(){
            int heal = this.getVidaInicial() - this.getVida();
            if(this.getVidaInicial()>this.getVida()*2)
                heal *= 0.125;
            else
                heal *= 0.2;
            if(heal > 0){
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se curó " + heal + " puntos de salud.");
                Controlador.getInstance().apCurarUnidad(this, heal);
            }
        }

        @Override
        public void efectoInicioEnfrentamiento() {
            if(Math.random()>0.4)
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " grita : " + "\"¡Todo o nada!\"\n"
                        + "Y aumentó su fuerza un 25% (" + this.getFuerza() + " a " + this.modFuerza((int)(this.getFuerza()*0.25)) + ")");
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
                    new Atributos(170,120,5,6,6,4,5,3,7));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }


        @Override
        public void efectoTurnoUnidadAliada(Unidad U) {
            if(U!=this){
                int vida = (int)(9+this.getFuerza()*(Math.random()*0.25+0.15));
                if(U.getVidaInicial()-U.getVida() < vida)
                    vida = U.getVidaInicial()-U.getVida();
                if(vida > 0){
                    Controlador.getInstance().combateActual.panel.insertarInfo(
                            this.getNombre() + " curó  a " + U.getNombre() + " " + vida + " puntos de salud.");
                    Controlador.getInstance().apCurarUnidad(U, vida);
                }
            }
        }
        
        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            int vida = 0; //Al atacar puede aumentar su vida maxima.
            if(tirada>0.8)
                vida = (int)(8+(objetivo.getVida()*0.035));
            else if(!acierto)
                vida = (int)((this.getArmadura()+this.getBlindaje())*0.25);
            if(getVidaInicial()-getVida() > vida)
                vida *= 1.25;
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
                    new Atributos(125,120,9,5,3,3,7,4,7));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }

        
        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            if(this.getAlcance()>1){
                int dano = (int)(objetivo.getVida()*0.05 + 0.35*(this.getFuerza()+this.getIntelecto()));
                if(tirada>0.6){
                    Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " realizó " + dano + " de daño extra al rival!");
                    Controlador.getInstance().apHerirUnidad(this, objetivo, dano);
                }
            }else if(tirada > 0.55){
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
                    new Atributos(220,85,5,4,8,7,4,3,5));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }


        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            int dano = (int)(this.getArmadura()*0.6);
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
