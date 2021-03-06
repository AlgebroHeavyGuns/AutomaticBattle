/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Micelaneous;

/**
 *
 * @author Algebro
 */
public class Atributos {
    private int vida;
    private int energia;
    private int fuerza;
    private int intelecto;
    private int armadura;
    private int blindaje;
    private int velocidad;
    private int agilidad;
    private int visibilidad;

    public Atributos(){
        setAll(0,0,1,1,0,0,1,1,2);
    }
    
    public Atributos(int vida, int armadura, int blindaje){
        setAll(vida,0,1,1,armadura,blindaje,1,1,2);
    }
    
    public Atributos(int vida, int energia, int fuerza, int intelecto, 
            int armadura, int blindaje, int velocidad, int agilidad, int visibilidad) {
        setAll(vida,energia,fuerza,intelecto,armadura,blindaje,velocidad,agilidad,visibilidad);
    }

    public Atributos suma(Atributos otro){
        this.vida+=otro.getVida();
        this.energia += otro.getEnergia();
        this.fuerza += otro.getFuerza();
        this.intelecto += otro.getIntelecto();
        this.armadura += otro.getArmadura();
        this.blindaje += otro.getBlindaje();
        this.velocidad += otro.getVelocidad();
        this.agilidad += otro.getAgilidad();
        this.visibilidad += otro.getVisibilidad();
        return this;
    }
    
    public final Atributos setAll(int vida, int energia, int fuerza, int intelecto, 
            int armadura, int blindaje, int velocidad, int agilidad, int visibilidad) {
        this.vida = vida;
        this.energia = energia;
        this.fuerza = fuerza;
        this.intelecto = intelecto;
        this.armadura = armadura;
        this.blindaje = blindaje;
        this.velocidad = velocidad;
        this.agilidad = agilidad;
        this.visibilidad = visibilidad;
        return this;
    }
    
    public int getVida() {
        return vida;
    }

    public int getEnergia() {
        return energia;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getIntelecto() {
        return intelecto;
    }

    public int getArmadura() {
        return armadura;
    }

    public int getBlindaje() {
        return blindaje;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public int getVisibilidad() {
        return visibilidad;
    }
    
    public int modVida(int mod) {
        vida+=mod;
        return vida;
    }

    public int modEnergia(int mod) {
        energia+=mod;
        return energia;
    }

    public int modFuerza(int mod) {
        fuerza+=mod;
        return fuerza;
    }

    public int modIntelecto(int mod) {
        intelecto+=mod;
        return intelecto;
    }

    public int modArmadura(int mod) {
        armadura+=mod;
        return armadura;
    }

    public int modBlindaje(int mod) {
        blindaje+=mod;
        return blindaje;
    }

    public int modVelocidad(int mod) {
        velocidad+=mod;
        return velocidad;
    }

    public int modAgilidad(int mod) {
        agilidad+=mod;
        return agilidad;
    }

    public int modVisibilidad(int mod) {
        visibilidad+=mod;
        return visibilidad;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setIntelecto(int intelecto) {
        this.intelecto = intelecto;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public void setBlindaje(int blindaje) {
        this.blindaje = blindaje;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public void setVisibilidad(int visibilidad) {
        this.visibilidad = visibilidad;
    }
    
    
    
    
}
