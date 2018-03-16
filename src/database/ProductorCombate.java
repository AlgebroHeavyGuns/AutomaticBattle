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
            
        
        }
        
        return null;
    }
    
    
    private static class CombateInicial extends CombateInfo{
    
        public CombateInicial() {
            super("Primera toma de contacto", 9, 9);
            Unidad U = Database.getInstance().getUnidadEnemiga("Espíritu dragón");//("Jabalí inútil");
            enemigos.add(U);
            T.insertaUnidad(U, 3, 4);
            //U = U.getCopia();
            //enemigos.add(U);
            //T.insertaUnidad(U, 3, 5);
        }
    
    
    
    }
    
    public static class CombateInfo{
        public ArrayList<Unidad> enemigos;
        public Tablero T;
        public String nombre;
        
        public CombateInfo(String nombre, int tamx, int tamy){
            T=new Tablero(tamx, tamy);
            this.nombre = nombre;
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
        
        
    }
    
    public static ProductorCombate getInstance() {
        return ProductorCombateHolder.INSTANCE;
    }
    
    private static class ProductorCombateHolder {

        private static final ProductorCombate INSTANCE = new ProductorCombate();
    }
}
