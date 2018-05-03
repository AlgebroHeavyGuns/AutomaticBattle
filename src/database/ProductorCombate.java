/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import automaticbattle.Combate;
import automaticbattle.Escenografia;
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
            case 3:
                return new IncursionSelva2();
            case 4:
                return new IncursionSelva3();
            case 5:
                return new TerritorioVikingo1();
            case 6:
                return new TerritorioVikingo2();
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
            case 3:
                return IncursionSelva2.PRESUPUESTO;
            case 4:
                return IncursionSelva3.PRESUPUESTO;
            case 5:
                return TerritorioVikingo1.PRESUPUESTO;
            case 6:
                return TerritorioVikingo2.PRESUPUESTO;
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
            case 3:
                return IncursionSelva2.MAXPERSONAJES;
            case 4:
                return IncursionSelva3.MAXPERSONAJES;
            case 5:
                return TerritorioVikingo1.MAXPERSONAJES;
            case 6:
                return TerritorioVikingo2.MAXPERSONAJES;
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
            case 3:
                return IncursionSelva2.MINPERSONAJES;
            case 4:
                return IncursionSelva3.MINPERSONAJES;    
            case 5:
                return TerritorioVikingo1.MINPERSONAJES;
            case 6:
                return TerritorioVikingo2.MINPERSONAJES;
            case 11:
                return CombateDragon.MINPERSONAJES;
        
        }
        
        return -1;
    }
    
    private static class CombateInicial extends CombateInfo{
    
        static final int PRESUPUESTO= 1400;
        static final int MAXPERSONAJES = 2;
        static final int MINPERSONAJES = 1;
        
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
            U = Database.getInstance().getEscenografia("Árbol simple");
            T.insertaUnidad(U, 5, 3);
            U = U.getCopia();   T.insertaUnidad(U, 2, 5);
            U = U.getCopia();   T.insertaUnidad(U, 2, 1);            
            U = U.getCopia();   T.insertaUnidad(U, 4, 6);
            U = Database.getInstance().getEscenografia("Roca mediana");
            T.insertaUnidad(U, 5, 2);
        }

    }
    
    
    private static class CombateInicial2 extends CombateInfo{
    
        static final int PRESUPUESTO= 1300;
        static final int MAXPERSONAJES = 2;
        static final int MINPERSONAJES = 1;
        
        public CombateInicial2() {
            super("Segunda toma de contacto", "mapa.png",  9, 9);
            Unidad U = Database.getInstance().getUnidadEnemiga("Oso rabioso");
            enemigos.add(U);
            T.insertaUnidad(U, 7, 4);
            U = Database.getInstance().getEscenografia("Árbol simple");
            T.insertaUnidad(U, 5, 2);
            U = U.getCopia();   T.insertaUnidad(U, 2, 6);
            U = U.getCopia();   T.insertaUnidad(U, 3, 1);            
            U = U.getCopia();   T.insertaUnidad(U, 4, 5);
            U = Database.getInstance().getEscenografia("Roca mediana");
            T.insertaUnidad(U, 5, 3);
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
            U = Database.getInstance().getEscenografia("Árbol selvático");
            T.insertaUnidad(U, 2, 2);
            U = U.getCopia();   T.insertaUnidad(U, 0, 0);
            U = U.getCopia();   T.insertaUnidad(U, 1, 8);
            U = U.getCopia();   T.insertaUnidad(U, 2, 3);
            U = U.getCopia();   T.insertaUnidad(U, 2, 5);
            U = U.getCopia();   T.insertaUnidad(U, 2, 6);
            U = U.getCopia();   T.insertaUnidad(U, 3, 8);
            U = U.getCopia();   T.insertaUnidad(U, 4, 1);
            U = U.getCopia();   T.insertaUnidad(U, 4, 3);
            U = U.getCopia();   T.insertaUnidad(U, 4, 4);
            U = U.getCopia();   T.insertaUnidad(U, 5, 6);
            U = U.getCopia();   T.insertaUnidad(U, 5, 7);
            U = U.getCopia();   T.insertaUnidad(U, 6, 1);
            U = U.getCopia();   T.insertaUnidad(U, 6, 2);
            U = U.getCopia();   T.insertaUnidad(U, 6, 4);
            U = U.getCopia();   T.insertaUnidad(U, 6, 5);
            U = U.getCopia();   T.insertaUnidad(U, 7, 2);
            U = U.getCopia();   T.insertaUnidad(U, 8, 5); 
            U = U.getCopia();   T.insertaUnidad(U, 8, 7);  
        }
    }
        
    private static class IncursionSelva2 extends CombateInfo{
    
        static final int PRESUPUESTO= 2600;
        static final int MAXPERSONAJES = 3;
        static final int MINPERSONAJES = 2;
        
        public IncursionSelva2() {
            super("Incursión en la Selva 2", "selva1.png", 9, 9);
            Unidad U = Database.getInstance().getUnidadEnemiga("Saurio astado");
            enemigos.add(U);
            T.insertaUnidad(U, 8, 3);
            U = U.getCopia();
            enemigos.add(U);
            T.insertaUnidad(U, 7, 4);
            U = Database.getInstance().getUnidadEnemiga("Saurio crestado");
            enemigos.add(U);
            T.insertaUnidad(U, 6, 7);
            U = U.getCopia();
            enemigos.add(U);
            T.insertaUnidad(U, 7, 1);
            U = Database.getInstance().getEscenografia("Árbol selvático");
            T.insertaUnidad(U, 2, 2);
            U = U.getCopia();   T.insertaUnidad(U, 8, 8);
            U = U.getCopia();   T.insertaUnidad(U, 1, 0);
            U = U.getCopia();   T.insertaUnidad(U, 2, 1);
            U = U.getCopia();   T.insertaUnidad(U, 3, 0);
            U = U.getCopia();   T.insertaUnidad(U, 3, 6);
            U = U.getCopia();   T.insertaUnidad(U, 4, 4);
            U = U.getCopia();   T.insertaUnidad(U, 4, 5);
            U = U.getCopia();   T.insertaUnidad(U, 5, 3);            
            U = U.getCopia();   T.insertaUnidad(U, 6, 5);
            U = U.getCopia();   T.insertaUnidad(U, 7, 3);

        }
    
    }
    
    
    private static class IncursionSelva3 extends CombateInfo{
    
        static final int PRESUPUESTO= 3500;
        static final int MAXPERSONAJES = 3;
        static final int MINPERSONAJES = 3;
        
        public IncursionSelva3() {
            super("Incursión en la Selva 3", "selva1.png", 9, 9);
            Unidad U = Database.getInstance().getUnidadEnemiga("Saurio gigante");
            enemigos.add(U);
            T.insertaUnidad(U, 8, 4);
            U = Database.getInstance().getUnidadEnemiga("Saurio crestado");
            enemigos.add(U);
            T.insertaUnidad(U, 7, 2);
            U = U.getCopia();
            enemigos.add(U);
            T.insertaUnidad(U, 6, 5);
            U = Database.getInstance().getEscenografia("Árbol selvático");
            T.insertaUnidad(U, 1, 0);
            U = U.getCopia();   T.insertaUnidad(U, 2, 1);
            U = U.getCopia();   T.insertaUnidad(U, 2, 7);
            U = U.getCopia();   T.insertaUnidad(U, 4, 5);
            U = U.getCopia();   T.insertaUnidad(U, 5, 2);
            U = U.getCopia();   T.insertaUnidad(U, 6, 4);
            U = U.getCopia();   T.insertaUnidad(U, 8, 5);
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
    
    
    private static class TerritorioVikingo1 extends CombateInfo{
    
        static final int PRESUPUESTO= 2000;
        static final int MAXPERSONAJES = 2;
        static final int MINPERSONAJES = 2;
        
        public TerritorioVikingo1() {
            super("Territorio Vikingo 1", "molino.png",  9, 9);
            Unidad U = Database.getInstance().getUnidadEnemiga("Guardián Vikingo");
            U.apellido("1");
            enemigos.add(U);
            T.insertaUnidad(U, 7, 2);
            U = U.getCopia();
            U.apellido("2");
            enemigos.add(U);
            T.insertaUnidad(U, 6, 6);
            U = Database.getInstance().getEscenografia("Árbol seco");
            T.insertaUnidad(U, 5, 3);
            U = U.getCopia();   T.insertaUnidad(U, 2, 5);
            U = U.getCopia();   T.insertaUnidad(U, 3, 1); 
            U = U.getCopia();   T.insertaUnidad(U, 4, 4);
            U = U.getCopia();   T.insertaUnidad(U, 4, 6);
            U = U.getCopia();   T.insertaUnidad(U, 7, 0);
            U = Database.getInstance().getEscenografia("Roca mediana");
            T.insertaUnidad(U, 5, 2);
            U = U.getCopia();   T.insertaUnidad(U, 0, 1);
            U = U.getCopia();   T.insertaUnidad(U, 1, 7);
            U = U.getCopia();   T.insertaUnidad(U, 8, 3);
            U = U.getCopia();   T.insertaUnidad(U, 7, 4);
        }

    }
    
    
    private static class TerritorioVikingo2 extends CombateInfo{
    
        static final int PRESUPUESTO= 2300;
        static final int MAXPERSONAJES = 2;
        static final int MINPERSONAJES = 2;
        
        public TerritorioVikingo2() {
            super("Territorio Vikingo 2", "molino.png",  9, 9);
            Unidad U = Database.getInstance().getUnidadEnemiga("Guardián Vikingo");
            enemigos.add(U);
            T.insertaUnidad(U, 6, 3);
            U = Database.getInstance().getUnidadEnemiga("Rhyno de combate");
            enemigos.add(U);
            T.insertaUnidad(U, 7, 4);
            U = Database.getInstance().getEscenografia("Árbol seco");
            T.insertaUnidad(U, 6, 5);
            U = U.getCopia();   T.insertaUnidad(U, 1, 3);
            U = U.getCopia();   T.insertaUnidad(U, 2, 6);
            U = U.getCopia();   T.insertaUnidad(U, 3, 2); 
            U = U.getCopia();   T.insertaUnidad(U, 4, 6);
            U = U.getCopia();   T.insertaUnidad(U, 4, 7);
            U = U.getCopia();   T.insertaUnidad(U, 7, 1);
            U = Database.getInstance().getEscenografia("Roca mediana");
            T.insertaUnidad(U, 5, 2);
            U = U.getCopia();   T.insertaUnidad(U, 0, 1);
            U = U.getCopia();   T.insertaUnidad(U, 1, 7);
            U = U.getCopia();   T.insertaUnidad(U, 8, 2);
            U = U.getCopia();   T.insertaUnidad(U, 7, 5);
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
