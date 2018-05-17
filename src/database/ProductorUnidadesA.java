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
public class ProductorUnidadesA {
    
    static ArrayList<Unidad> getUnidades(){
        ArrayList<Unidad> lista = new ArrayList<>();
        lista.add(new JabaliFurioso());
        lista.add(new OsoRabioso());
        lista.add(new SaurioAstado());
        lista.add(new SaurioCrestado());
        lista.add(new SaurioGigante());
        lista.add(new EspirituDragon());
        lista.add(new GuardianVikingo());
        lista.add(new RhynoDeCombate());
        return lista;
    }
    
    static class JabaliFurioso extends Unidad{
        public JabaliFurioso() {
            super("Jabalí furioso", "WildBoar1.png", "Es muy cerdaco.", TipoUnidad.Bestia, 
                    new Atributos(110,120,3,3,6,3,5,4,5));          
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(Database.getInstance().getEquipo("Dentadura fuerte"));
        }
        
        /*efecto anterior
        
        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            int cura = (int)(this.getFuerza()*(0.25+tirada*1.25));
            if(this.getVidaInicial()-this.getVida() < cura)
                cura = this.getVidaInicial()-this.getVida();
            if(cura>0){
                Controlador.getInstance().apCurarUnidad(this, cura);
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se curó " + cura + " de salud.");
            }
        }
        */
        
     
        @Override
        public void efectoUnidadAtacada(Unidad atacante, double prob, int danio) {
            final double COE = 0.7;
            if(this.getVida() < 1 && Controlador.getInstance().calculaDistancia(this.getPosX(), this.getPosY(),
                    atacante.getPosX(), atacante.getPosY()) == 1){
                  Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " grita fuerte y devuelve \n"
                          + (int)(danio*COE) + " a " + atacante.getNombre() + " antes de morir");
                Controlador.getInstance().apHerirUnidad(this, atacante, ((int)(danio*COE)));            }
        }

        @Override
        public Unidad getCopia() {
            return new JabaliFurioso();
        }
    
    }
    
    
    static class OsoRabioso extends Unidad{
        
        int rabia = 0;
        
        public OsoRabioso() {
            super("Oso rabioso", "Beast4.png", "Es hermoso.", TipoUnidad.Bestia, 
                    new Atributos(330,130,4,4,8,5,4,4,7));             
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(new ProductorEquiposA.DentaduraFuerte());
        }
        

        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            if(rabia<60)    
                rabia+= 2+(int)(tirada*5);
            else
                rabia=60;
            int dano = rabia-objetivo.getArmadura();
            if(dano > 0){
                Controlador.getInstance().apHerirUnidad(this, objetivo, dano);
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " hace " +
                       dano + " de daño adicional a " + objetivo.getNombre());
            }else
                rabia += 0.65*this.getFuerza();
        }

        @Override
        public Unidad getCopia() {
            return new OsoRabioso();
        }
    
    }

    static class EspirituDragon extends Unidad{
        public EspirituDragon() {
            super("Espíritu dragón", "Dragon4.png", "Si lo ves, ya es tarde.", TipoUnidad.Dragon, 
                    new Atributos(650,400,25,15,15,15,8,2,9));
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(Database.getInstance().getEquipo("Alma de dragón"));
        }


        @Override
        public int getDistanciaMovimiento() {
            return 3;
        }
        
        @Override
        public Unidad getCopia() {
            return new EspirituDragon();
        }
    
    }

    static class SaurioAstado extends Unidad{

        
        public SaurioAstado() {
            super("Saurio astado", "dino3.png", "Que no asado...", TipoUnidad.Reptil, 
                    new Atributos(370,120,8,7,9,6,6,4,5));             
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(new ProductorEquiposA.DentaduraFuerte());
        }

        @Override
        public Unidad getCopia() {
            return new SaurioAstado();
        }
    
    }    
    
    static class SaurioCrestado extends Unidad{

        
        public SaurioCrestado() {
            super("Saurio crestado", "dino4.png", "Que no asado...", TipoUnidad.Reptil, 
                    new Atributos(245,150,7,7,7,6,7,4,6));             
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(new ProductorEquiposA.GlandulaVenenosa());
            this.equipar(new ProductorEquiposA.DentaduraFuerte());
            this.aprender(new ProductorHechizosD.DardoVenenoso());
        }

        @Override
        public Unidad getCopia() {
            return new SaurioCrestado();
        }
    
    }    
    
    
    static class SaurioGigante extends Unidad{

        
        public SaurioGigante() {
            super("Saurio gigante", "dino2.png", ".", TipoUnidad.Reptil, 
                    new Atributos(1400,200,16,10,13,10,8,3,8));             
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(new ProductorEquiposA.DentaduraFuerte());
        }

        @Override
        public int getDistanciaMovimiento() {
            return 2;
        }

        @Override
        public Unidad getCopia() {
            return new SaurioGigante();
        }
    
    }
    
        static class GuardianVikingo extends Unidad{

        
        public GuardianVikingo() {
            super("Guardián Vikingo", "Viking.png", "No conoce el miedo", TipoUnidad.Humano,   
                    new Atributos(130,120,9,5,4,3,7,4,7));
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(new ProductorEquiposD.CascoDeDestruccion());
            this.equipar(new ProductorEquiposD.CorazaDeGuerra());
            this.equipar(new ProductorEquiposG.HachaDeLeñador());
        }

        @Override
        public Unidad getCopia() {
            return new GuardianVikingo();
        }
    
    }
        
    static class RhynoDeCombate extends Unidad{

        
        public RhynoDeCombate() {
            super("Rhyno de combate", "Beast7.png", "Mejor huir...", TipoUnidad.Bestia, 
                    new Atributos(540,250,13,5,16,8,4,2,5));  
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.aprender(new ProductorHechizosD.Embiste());

        }
        

        @Override
        public void efectoTurnoPropio() {
            int sana = 20 + (int)(0.05*(this.getVidaInicial()-this.getVida()));
            if(this.getVidaInicial() < this.getVida()+sana)
                sana=this.getVidaInicial()-this.getVida();
            int maxSana = 10 + 15*Controlador.getInstance().combateActual.getEnemigas(this).size();
            if(sana > maxSana)
                sana= maxSana;

            if(sana > 0){
                Controlador.getInstance().apMostrarMensaje(this.getNombre() + " barritó, sanándose " + sana + " de salud");
                Controlador.getInstance().apCurarUnidad(this, sana);
            }
        }

        @Override
        public Unidad getCopia() {
            return new RhynoDeCombate();
        }
    
    } 
    
}
