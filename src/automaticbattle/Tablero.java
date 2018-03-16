/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

/**
 *
 * @author Algebro
 */
public class Tablero {
    private final int TAM_X;
    private final int TAM_Y;
    private Unidad unidades[][];
    
    public Tablero(int tamx, int tamy){
        TAM_X = tamx;
        TAM_Y = tamy;
        unidades = new Unidad[TAM_X][TAM_Y];
        clear();
    }
    
    public void insertaUnidad(Unidad U, int x, int y){
        assertValidas(x,y);
        U.MoverA(x, y);
        unidades[x][y]=U;
    }
    
    private void assertValidas(int x, int y){
        assert coordenadasValidas(x,y) : "Coordenadas inválidas (" + x + "," + y + ")";
    }
    
    public final void clear(){
        for(int i=0;i<TAM_X;i++)
            for(int j=0;j<TAM_Y;j++)
                unidades[i][j]=null;
    }
    
    public boolean coordenadasValidas(int x, int y){
        return x>-1 && x<TAM_X && y>-1 && y<TAM_Y;
    }
    
    public Unidad ocupada(int x, int y){
        assertValidas(x,y);
        return unidades[x][y];
    }

    public int getTAM_X() {
        return TAM_X;
    }

    public int getTAM_Y() {
        return TAM_Y;
    }

    public Unidad[][] getUnidades() {
        return unidades;
    }
    
    
    
    
    public void swap (Unidad U, int x1, int y1){
        assertValidas(x1,y1);
        if(U==null)
            unidades[x1][y1]=null;
        else{
            unidades[U.getPosX()][U.getPosY()]=null;
            unidades[x1][y1]=U;
        }
    }
    
    public void swap(int x1,int y1, int x2, int y2){
        assertValidas(x1,y1);
        assertValidas(x2,y2);
        Unidad aux = unidades[x1][y1];
        if(aux!=null)
            aux.MoverA(x2, y2);
        unidades[x1][y1] = unidades[x2][y2];
        unidades[x2][y2] = aux;
        if(unidades[x1][y1]!=null)
            unidades[x1][y1].MoverA(x1, y1);
    }
    
    
}
