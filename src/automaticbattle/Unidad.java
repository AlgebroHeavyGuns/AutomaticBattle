/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

import Micelaneous.Atributo;
import Micelaneous.TipoUnidad;
import java.util.ArrayList;

/**
 *
 * @author Algebro
 */
public abstract class Unidad {
    private String nombre;
    private String imagen;
    private String descripcion;
    private String detalle;
    private TipoUnidad tipo;
    private Atributo base;  //atributos por defecto de la unidad (sin equipo)
    private Atributo actual;//atributos que la unidad acumula  durante el combate
    private ArrayList<Equipable> equipo;

    public Unidad(String nombre, String imagen, String descripcion, TipoUnidad tipo, Atributo base) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.base = base;
        this.equipo = new ArrayList<>();
        this.actual = null;
    }
    
    private Atributo sumaAtributosEquipo(){
        Atributo atributo = new Atributo();
        
        for(Equipable E : equipo)
            atributo.suma(E.getModificador());
        
        return atributo;
    }
    
    public void fijaActual(){
        actual = sumaAtributosEquipo().suma(base);
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public String getDetalle(){
        return detalle;
    }

    public TipoUnidad getTipo() {
        return tipo;
    }

    public Atributo getActual() {
        return actual;
    }

    public ArrayList<Equipable> getEquipo() {
        return equipo;
    }
    
    
    public abstract Unidad getCopia();
    
    //TURNO
    public void efectoInicioEnfrentamiento(){}
    public void efectoInicioTurnoPropio(){}
    public void efectoInicioTurnoContrario(){}
    public void efectoFinTurnoPropio(){}
    public void efectoFinTurnoContrario(){}
    
    //ACCIONES
    public void efectoUnidadAliadaMueve(Unidad U, int origenX, int origenY, int destinoX, int destinoY){}
    public void efectoUnidadEnemigaMueve(Unidad U, int origenX, int origenY, int destinoX, int destinoY){}
    public void efectoUnidadAliadaAtaca(Unidad atacante, Unidad defensor){}
    public void efectoUnidadEnemigaAtaca(Unidad atacante, Unidad defensor){}
    public void efectoUnidadAliadaUsaHabilidad(Unidad U, int idHabilidad){} //sustituir por Habilidad
    public void efectoUnidadEnemigaUsaHabilidad(Unidad U, int idHabilidad){}//sustituir por Habilidad
    public void efectoUnidadAliadaUsaObjeto(Unidad U, int idObj){}//sustituir por Objeto
    public void efectoUnidadEnemigaUsaObjeto(Unidad U, int idObj){}//sustituir por Objeto
    public void efectoUnidadAliadaNoHaceNada(Unidad U){}
    public void efectoUnidadEnemigaNoHaceNada(Unidad U){}
    public void efectoMover(){}
    public void efectoAtacar(Unidad objetivo){}
    public void efectoUsarHabilidad(Unidad objetivo, int idHabilidad){} //sustituir por Habilidad
    public void efectoUsarObjeto(Unidad objetivo, int idObj){}//sustituir por Objeto
    public void efectoNoHacerNada(){}
    
    //OTROS
    public void efectoUnidadAliadaMuere(Unidad victima, Unidad asesino){}
    public void efectoUnidadEnemigaMuere(Unidad victima, Unidad asesino){}
    public void efectoMatarUnidad(Unidad victima){}
    
    
    
    
}
