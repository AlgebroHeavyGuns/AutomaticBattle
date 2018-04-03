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
        return lista;
    }
    
    static class JabaliFurioso extends Unidad{
        public JabaliFurioso() {
            super("Jabalí furioso", "WildBoar1.png", "Es muy cerdaco.", TipoUnidad.Bestia, 
                    new Atributos(110,120,3,3,6,3,5,4,5));          
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(Database.getInstance().getEquipo("Dentadura fuerte"));
        }
        

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
                    new Atributos(350,130,4,4,8,6,4,4,7));             
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(Database.getInstance().getEquipo("Dentadura fuerte"));
        }
        

        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            if(rabia<35)    
                rabia+= (int)(tirada*6);
            else
                rabia=35;
            Controlador.getInstance().apHerirUnidad(this, objetivo, rabia);
            Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " hace " + rabia + " de daño adicional a " + objetivo.getNombre());
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
                    new Atributos(370,100,7,7,9,6,6,4,5));             
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(Database.getInstance().getEquipo("Dentadura fuerte"));
        }
        

        @Override
        public Unidad getCopia() {
            return new SaurioAstado();
        }
    
    }    
    
    static class SaurioCrestado extends Unidad{

        
        public SaurioCrestado() {
            super("Saurio crestado", "dino4.png", "Que no asado...", TipoUnidad.Reptil, 
                    new Atributos(240,120,8,7,8,6,7,4,6));             
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(Database.getInstance().getEquipo("Glándula venenosa"));
            this.equipar(Database.getInstance().getEquipo("Dentadura fuerte"));
        }

        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            int cura = (int)(10*(tirada+0.3));
            if(this.getVidaInicial()-this.getVida() > cura)
                cura*=1.5;
            if(cura > 0){
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se curó " + cura + " de salud.");
                Controlador.getInstance().apCurarUnidad(this, cura);
            }
        }

        @Override
        public Unidad getCopia() {
            return new SaurioCrestado();
        }
    
    }    
    
    
    static class SaurioGigante extends Unidad{

        
        public SaurioGigante() {
            super("Saurio gigante", "dino2.png", ".", TipoUnidad.Reptil, 
                    new Atributos(1250,200,16,10,14,10,8,3,8));             
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(Database.getInstance().getEquipo("Dentadura fuerte"));
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
    
}
