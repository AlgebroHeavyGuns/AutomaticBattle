/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import automaticbattle.Combate;
import automaticbattle.Tablero;
import automaticbattle.Unidad;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public class ProductorCombate {
    
    private ProductorCombate() {}
    
    
    
    public CombateInfo getCombateNivel(int i){
        switch(i){
            case 0:
                return new CombateInicial();
            case 1:
                return new CombateInicial2();
            case 2:
                return new IncursionSelva1();
            case 11:
                return new CombateDragon();
        
        }
        
        return null;
    }
    
    public int getPresupuestocombateNivel(int i){
        switch(i){
            case 0:
                return CombateInicial.PRESUPUESTO;
            case 1:
                return CombateInicial2.PRESUPUESTO;
            case 2:
                return IncursionSelva1.PRESUPUESTO;
            case 11:
                return CombateDragon.PRESUPUESTO;
        
        }
        
        return -1;
    }
    
    public int getPersonajesMaximosNivel(int i){
        switch(i){
            case 0:
                return CombateInicial.MAXPERSONAJES;
            case 1:
                return CombateInicial2.MAXPERSONAJES;
            case 2:
                return IncursionSelva1.MAXPERSONAJES;
            case 11:
                return CombateDragon.MAXPERSONAJES;
        
        }
        
        return -1;
    }
    
    public int getPersonajesMinimosNivel(int i){
        switch(i){
            case 0:
                return CombateInicial.MINPERSONAJES;
            case 1:
                return CombateInicial2.MINPERSONAJES;
            case 2:
                return IncursionSelva1.MINPERSONAJES;
            case 11:
                return CombateDragon.MINPERSONAJES;
        
        }
        
        return -1;
    }
    
    private static class CombateInicial extends CombateInfo{
    
        static final int PRESUPUESTO= 1300;
        static final int MAXPERSONAJES = 2;
        static final int MINPERSONAJES = 2;
        
        public CombateInicial() {
            super("Primera toma de contacto", "mapa.png",  9, 9);
            Unidad U = Database.getInstance().getUnidadEnemiga("Jabalí furioso");
            U.apellido("1");
            enemigos.add(U);
            T.insertaUnidad(U, 6, 2);
            U = U.getCopia();
            U.apellido("2");
            enemigos.add(U);
            T.insertaUnidad(U, 6, 6);
        }

    }
    
    
    private static class CombateInicial2 extends CombateInfo{
    
        static final int PRESUPUESTO= 1100;
        static final int MAXPERSONAJES = 2;
        static final int MINPERSONAJES = 2;
        
        public CombateInicial2() {
            super("Segunda toma de contacto", "mapa.png",  9, 9);
            Unidad U = Database.getInstance().getUnidadEnemiga("Oso rabioso");
            enemigos.add(U);
            T.insertaUnidad(U, 7, 4);
        }
    
    }
    
    private static class IncursionSelva1 extends CombateInfo{
    
        static final int PRESUPUESTO= 2000;
        static final int MAXPERSONAJES = 3;
        static final int MINPERSONAJES = 2;
        
        public IncursionSelva1() {
            super("Incursión en la Selva 1", "selva1.png", 9, 9);
            Unidad U = Database.getInstance().getUnidadEnemiga("Saurio astado");
            enemigos.add(U);
            T.insertaUnidad(U, 8, 3);
            U = Database.getInstance().getUnidadEnemiga("Saurio crestado");
            enemigos.add(U);
            T.insertaUnidad(U, 7, 6);
        }
    
    }
    
    private static class CombateDragon extends CombateInfo{
    
        static final int PRESUPUESTO= 6000;
        static final int MAXPERSONAJES = 5;
        static final int MINPERSONAJES = 3;
        
        public CombateDragon() {
            super("Dragon desencadenado", "libro.png", 12, 9);
            Unidad U = Database.getInstance().getUnidadEnemiga("Espíritu dragón");
            enemigos.add(U);
            T.insertaUnidad(U, 11, 4);
        }
    
    
    
    }
    
    public abstract static class CombateInfo{
        public ArrayList<Unidad> enemigos;
        public Tablero T;
        public String nombre;
        public String imagen;
        
        public CombateInfo(String nombre, String imagen, int tamx, int tamy){
            T=new Tablero(tamx, tamy);
            this.nombre = nombre;
            this.imagen = imagen;
            this.enemigos = new ArrayList<>();
        }

        public ArrayList<Unidad> getEnemigos() {
            return enemigos;
        }

        public void setEnemigos(ArrayList<Unidad> enemigos) {
            this.enemigos = enemigos;
        }

        public Tablero getTablero() {
            return T;
        }

        public void setTablero(Tablero T) {
            this.T = T;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getImagen() {
            return imagen;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }

          
    }
    
    public static ProductorCombate getInstance() {
        return ProductorCombateHolder.INSTANCE;
    }
    
    private static class ProductorCombateHolder {

        private static final ProductorCombate INSTANCE = new ProductorCombate();
    }
}
