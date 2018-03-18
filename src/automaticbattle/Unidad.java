/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

import Micelaneous.decisionIA;
import Micelaneous.Atributos;
import Micelaneous.Elemento;
import Micelaneous.TipoArma;
import Micelaneous.TipoEquipo;
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
            return 1.0;
    }
    
    public double getEfectividadArmas(Unidad U){
        double coef=1.0;
        for(Equipable Eq: equipo)
            if(Eq instanceof Arma){
                if(((Arma)Eq).getTipoArma()==TipoArma.EspadaUnaMano || ((Arma)Eq).getTipoArma()==TipoArma.Daga ||
                        ((Arma)Eq).getTipoArma()==TipoArma.HachaUnaMano)
                    coef*= U.getResistenciaelemento(((Arma) Eq).getElementoAtaque()) * U.getResistenciaArma(((Arma) Eq).getTipoArma());
                else
                    return U.getResistenciaelemento(((Arma) Eq).getElementoAtaque()) * U.getResistenciaArma(((Arma) Eq).getTipoArma());
            }
                
        return coef;
    }
    
    public double getResistenciaArma(TipoArma TA){
        double coef=1.0;
        for(Equipable E: equipo)
            coef*= E.getCoeficienteResistencia(TA);
        return coef;
    }
    
    public double getResistenciaelemento(Elemento E){
        double coef=1.0;
        for(Equipable Eq: equipo)
            coef*= Eq.getCoeficienteResistencia(E);
        return coef;
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
    
    public void renombrar(String nombre){
        this.nombre = nombre;
    }
    
    public void apellido(String apellido){
        this.nombre += apellido;
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
    
    public Equipable equipar(Equipable E){
        Equipable ret = puedeEquipar(E);
        if(ret==null)
            equipo.add(E);
        return ret;
    }
    
    public Equipable puedeEquipar(Equipable E){
        TipoEquipo TE = E.getTipo();
        Equipable ret;
        switch(TE){
            case Escudo:
                ret = tieneEquipado(TipoEquipo.Escudo);
                if(ret==null){
                    ret = tieneEquipadoDosManos();
                    if(ret==null)
                        ret = tieneDosArmasUnaMano();   
                }
                return ret;
            case Consumible:
            case Joyeria:
                return null;
            case Arma:
                switch(((Arma)E).getTipoArma()){
                    case EspadaUnaMano:
                    case HachaUnaMano:
                    case Daga:
                        ret = tieneEquipado(TipoEquipo.Arma);
                        if(ret!=null){
                            ret = tieneEquipadoDosManos();
                            if(ret==null){
                                ret = tieneEquipado(TipoEquipo.Escudo);   
                                if(ret==null)
                                    ret = tieneDosArmasUnaMano();
                            }
                        }
                        return ret;
                }
            default:
                return tieneEquipado(TE);
        }
    }
    
    public Equipable tieneEquipado(TipoEquipo TE){
        for(Equipable E : equipo)
            if(E.getTipo()==TE)
                return E;
        return null;
    }
    
    public Equipable tieneEquipadoDosManos(){
        for(Equipable equipado: equipo)
            if(equipado instanceof Arma){
                 if(((Arma)equipado).getTipoArma()==TipoArma.EspadaUnaMano ||
                     ((Arma)equipado).getTipoArma()==TipoArma.HachaUnaMano || ((Arma)equipado).getTipoArma()==TipoArma.Daga)
                     return null;
                 else
                     return equipado;
            }
                
        return null;
    }

    public Equipable tieneDosArmasUnaMano(){
        Equipable otro = null;
        for(Equipable equipado: equipo)
            if(equipado instanceof Arma && (((Arma)equipado).getTipoArma()==TipoArma.EspadaUnaMano ||
                    ((Arma)equipado).getTipoArma()==TipoArma.HachaUnaMano || ((Arma)equipado).getTipoArma()==TipoArma.Daga)){
                if(otro==null)
                    otro=equipado;
                else
                    return equipado;
            }
        return null;
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
