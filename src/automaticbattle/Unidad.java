/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

import Micelaneous.decisionIA;
import Micelaneous.Atributos;
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
    private Atributos base;  //atributos por defecto de la unidad (sin equipo)
    private Atributos actual;//atributos que la unidad acumula  durante el combate
    private ArrayList<Equipable> equipo;
    private decisionIA IAAsociada;
    private int posX=-1;
    private int posY=-1;

    public Unidad(String nombre, String imagen, String descripcion, TipoUnidad tipo, Atributos base) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.base = base;
        this.equipo = new ArrayList<>();
        this.actual = null;
    }
    
    
    private Atributos sumaAtributosEquipo(){
        Atributos atributo = new Atributos();
        
        for(Equipable E : equipo)
            atributo.suma(E.getModificador());
        
        return atributo;
    }
    
    public double getEfectividadAtaque(Unidad rival){
        double efect=99999;
        boolean arma = false;
        for(Equipable E: equipo)
            if(E instanceof Arma){
                efect= Math.min(((Arma)E).getCoeficienteEfectividad(rival.getTipo()), efect);
                arma = true;
            }
        if(arma)
            return efect;
        else
            return 1;
    }
    
    public double getResistenciaAtaque(Unidad rival){
        double efect=99999;
        boolean arma = false;
        for(Equipable E: equipo)
            if(E instanceof Arma){
                efect= Math.min(((Arma)E).getCoeficienteEfectividad(rival.getTipo()), efect);
                arma = true;
            }
        if(arma)
            return efect;
        else
            return 1;
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

    public Atributos getActual() {
        return actual;
    }

    public ArrayList<Equipable> getEquipo() {
        return equipo;
    }

    public Atributos getBase() {
        return base;
    }

    public decisionIA getIAAsociada() {
        return IAAsociada;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    
    public int getAlcance(){
        for(Equipable E : this.equipo)
            if(E instanceof Arma)
                if(((Arma)E).getAlcance() > 1)
                    return ((Arma)E).getAlcance();
        return 1;
    }
    
    public int getDistanciaMovimiento(){
        return 1;
    }
    
    public void MoverA(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public void setIAAsociada(decisionIA IAAsociada) {
        this.IAAsociada = IAAsociada;
    }
    
    
    public int modVidaActual(int mod) {
         return actual.modVida(mod);
    }

    public int modEnergia(int mod) {
        return actual.modEnergia(mod);
    }

    public int modFuerza(int mod) {
        return actual.modFuerza(mod);
    }

    public int modIntelecto(int mod) {
        return actual.modIntelecto(mod);
    }

    public int modArmadura(int mod) {
        return actual.modArmadura(mod);
    }

    public int modBlindaje(int mod) {
        return actual.modBlindaje(mod);
    }

    public int modVelocidad(int mod) {
        return actual.modVelocidad(mod);
    }

    public int modAgilidad(int mod) {
        return actual.modAgilidad(mod);
    }

    public int modVisibilidad(int mod) {
        return actual.modVisibilidad(mod);
    }
    
    public int getVida() {
        return actual.getVida();
    }

    public int getEnergia() {
        return actual.getEnergia();
    }

    public int getFuerza() {
        return actual.getFuerza();
    }

    public int getIntelecto() {
        return actual.getIntelecto();
    }

    public int getArmadura() {
        return actual.getArmadura();
    }

    public int getBlindaje() {
        return actual.getBlindaje();
    }

    public int getVelocidad() {
        return actual.getVelocidad();
    }

    public int getAgilidad() {
        return actual.getAgilidad();
    }

    public int getVisibilidad() {
        return actual.getVisibilidad();
    }
    
    public abstract Unidad getCopia();
    
    //TURNO
    public void efectoInicioEnfrentamiento(){}
    public void efectoTurnoPropio(){}
    public void efectoTurnoUnidadAliada(Unidad U){}
    public void efectoTurnoUnidadEnemiga(Unidad U){}
    
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
    public void efectoDesplazarse(){}
    public void efectoAtacar(Unidad objetivo, double tirada, boolean acierto){}
    public void efectoUsarHabilidad(Unidad objetivo, int idHabilidad){} //sustituir por Habilidad
    public void efectoUsarObjeto(Unidad objetivo, int idObj){}//sustituir por Objeto
    public void efectoNoHacerNada(){}
    
    //OTROS
    public void efectoUnidadAliadaMuere(Unidad victima, Unidad asesino){}
    public void efectoUnidadEnemigaMuere(Unidad victima, Unidad asesino){}
    public void efectoMatarUnidad(Unidad victima){}
    public void efectoUnidadAtacada(Unidad atacante, double prob, int danio){}
    
    
    
    
}
