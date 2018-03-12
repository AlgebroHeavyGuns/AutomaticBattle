/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

import Micelaneous.Atributos;
import Micelaneous.EfectividadArma;
import Micelaneous.EfectividadElemento;
import Micelaneous.Elemento;
import Micelaneous.TipoArma;
import Micelaneous.TipoEquipo;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public class Equipable {
    private String nombre;
    private String imagen;
    private int coste;
    private int nivelRequerido;
    private Atributos modificador;
    private TipoEquipo tipo;
    private ArrayList<EfectividadElemento> resistenciaElemento;
    private ArrayList<EfectividadArma> resistenciaArma;

    public Equipable(String nombre, String imagen, int coste, int nivelRequerido, Atributos modificador, TipoEquipo tipo) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.coste = coste;
        this.nivelRequerido = nivelRequerido;
        this.modificador = modificador;
        this.tipo = tipo;
        resistenciaElemento = new ArrayList<>();
        resistenciaArma = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public int getCoste() {
        return coste;
    }

    public int getNivelRequerido() {
        return nivelRequerido;
    }

    public Atributos getModificador() {
        return modificador;
    }

    public TipoEquipo getTipo() {
        return tipo;
    }

    public ArrayList<EfectividadElemento> getResistenciaElemento() {
        return resistenciaElemento;
    }

    public ArrayList<EfectividadArma> getResistenciaArma() {
        return resistenciaArma;
    }
    
    
    public double getCoeficienteResistencia(TipoArma TA){
        for(EfectividadArma EA : this.resistenciaArma)
            if(EA.getArma()==TA)
                return EA.getEfectividad();
        return 1.0;
                
    }
    
    public double getCoeficienteResistencia(Elemento E){
        for(EfectividadElemento EE : this.resistenciaElemento)
            if(EE.getElemento()==E)
                return EE.getEfectividad();
        return 1.0;
    }
    
    
    
    
    
    
}
