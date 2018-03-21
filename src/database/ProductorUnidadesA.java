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
        lista.add(new EspirituDragon());
        return lista;
    }
    
    static class JabaliFurioso extends Unidad{
        public JabaliFurioso() {
            super("Jabalí furioso", "WildBoar1.png", "Es muy cerdaco.", TipoUnidad.Bestia, 
                    new Atributos(170,120,5,3,7,3,5,4,5));          
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(Database.getInstance().getEquipo("Dentadura fuerte"));
        }
        

        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            int cura = (int)(this.getFuerza()*(tirada));
            if(cura>0){
                Controlador.getInstance().apCurarUnidad(this, cura);
                Controlador.getInstance().combateActual.panel.insertarInfo(this.getNombre() + " se curó " + cura + " de salud.");
            }
        }
        

        @Override
        public void efectoUnidadAtacada(Unidad atacante, double prob, int danio) {
            final double COE = 0.6;
            if(this.getVida() < 1){
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
                    new Atributos(400,120,8,4,10,7,4,4,7));             
            this.setIAAsociada(new searchAndDestroyBasicIA());
            this.equipar(Database.getInstance().getEquipo("Dentadura fuerte"));
        }
        

        @Override
        public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto) {
            if(rabia<22)    
                rabia+= (int)(tirada*5);
            else
                rabia=22;
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
                    new Atributos(550,400,20,15,10,10,8,2,8));
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
    
}
