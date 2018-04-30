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
        lista.add(new MarinaAsesina());
        return lista;
    }
    
    /*
    
    Atributos(int vida, int energia, int fuerza, int intelecto, 
            int armadura, int blindaje, int velocidad, int agilidad, int visibilidad)
    */
    
    
            
    static class JeroGuerrero extends Unidad{
        
        public JeroGuerrero() {
            super("Jero Guerrero", "CharacterHumanMale.png", "Todo o nada.", TipoUnidad.Humano, 
                    new Atributos(220,90,7,5,6,5,4,3,6));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }


        @Override
        public void efectoTurnoPropio(){
            int heal = this.getVidaInicial() - this.getVida();
            if(this.getVidaInicial()>this.getVida()*2)
                heal *= 0.08;
            else
                heal *= 0.125;
            if(heal > 0){
                Controlador.getInstance().apMostrarMensaje(this.getNombre() + " se curó " + heal + " puntos de salud.");
                Controlador.getInstance().apCurarUnidad(this, heal);
            }
        }

        @Override
        public void efectoInicioEnfrentamiento() {
            if(Math.random()>0.4)
                Controlador.getInstance().apMostrarMensaje(this.getNombre() + " grita : " + "\"¡Todo o nada!\"\n"
                        + "Y aumentó su fuerza un 20% (" + this.getFuerza() + " a " + this.modFuerza((int)(this.getFuerza()*0.2)) + ")");
            else
                Controlador.getInstance().apMostrarMensaje(this.getNombre() + " se concentra,y aumenta \n"
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
                    new Atributos(175,130,5,6,6,4,5,3,7));
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.aprender(new ProductorHechizosA.SanacionMenor());
        }
        
        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            int vida = 0; //Al atacar puede aumentar su vida maxima.
            if(acierto)
                vida = (int)(this.getFuerza()*0.65);
            if(vida > 0){
                Controlador.getInstance().apMostrarMensaje(this.getNombre() + " se curó " + vida + " de salud.");
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
                    new Atributos(130,120,9,5,3,3,7,4,7));
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.aprender(new ProductorHechizosA.DisparoCertero());
        }

        
        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            if(this.getAlcance()>1){
                int dano = (int)(10 + objetivo.getVida()*0.01 + 0.4*(this.getFuerza()+this.getIntelecto()));
                if(tirada>0.6){
                    Controlador.getInstance().apMostrarMensaje(this.getNombre() + " realizó " + dano + " de daño extra al rival!");
                    Controlador.getInstance().apHerirUnidad(this, objetivo, dano);
                }
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
                    new Atributos(230,90,4,4,8,7,3,3,5));
            this.setIAAsociada(new searchAndDestroyBasicIA());
        }



        @Override
        public void efectoDesplazarse() {
            Controlador.getInstance().apMostrarMensaje(this.getNombre() + " aumento en 10 su salud (" + this.modVidaActual(10) + ").");
        }
        
        
        @Override
        public Unidad getCopia() {
            return new AuroraLuchadora();
        }
    
    }
    
    static class MarinaAsesina extends Unidad{
        
        public MarinaAsesina() {
            super("Marina Asesina", "CharacterHumanFemale.png", "Para cuando me vean ya será tarde.", TipoUnidad.Humano, 
                    new Atributos(120,110,11,6,3,2,5,5,5));
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.aprender(new ProductorHechizosD.DardoVenenoso());
        }
        

        @Override
        public void efectoUnidadEnemigaMuere(Unidad victima, Unidad asesino) {
            int sanacion = victima.getFuerza() + victima.getArmadura();
            if(asesino==this)
                sanacion*=1.2;
            Controlador.getInstance().apMostrarMensaje(this.getNombre() + " dice : " + "\"¡Uno menos!\"\n");
            Controlador.getInstance().apMostrarMensaje(this.getNombre() + " se curó " + sanacion + " de salud.");
            Controlador.getInstance().apCurarUnidad(this, sanacion);
        }

        /*EFECTO ANTIGUO
        
        @Override
        public void efectoTurnoPropio() {
            ArrayList<Unidad> enemigas = Controlador.getInstance().getEnemigasADistancia(this, 2);
            if(!enemigas.isEmpty()){
                Controlador.getInstance().apMostrarMensaje(this.getNombre() + " susurra \"Yo me ocupo\"");
                int dano,sana=0;
                for(Unidad rival : enemigas){
                    dano = (int)(getFuerza()*1.25 - 0.75*rival.getArmadura());
                    sana += dano;
                    Controlador.getInstance().apMostrarMensaje(this.getNombre() + " realizó " + dano + " a " + rival.getNombre());
                    Controlador.getInstance().apHerirUnidad(this, rival, dano);
                }
                sana *= 0.15;
                if(this.getVidaInicial() < this.getVida()+sana)
                    sana = this.getVidaInicial() - this.getVida();
                if(sana > 0){
                    Controlador.getInstance().apMostrarMensaje(this.getNombre() + " se sanó " + sana + " de salud");
                    Controlador.getInstance().apCurarUnidad(this, sana);
                }
            }
        } 
        
        */


        
        @Override
        public Unidad getCopia() {
            return new MarinaAsesina();
        }
    
    }
    
}
