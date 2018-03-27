/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticbattle;

import Micelaneous.Atributos;
import Micelaneous.TipoUnidad;

/**
 *
 * @author Algebro
 */
public abstract class Escenografia extends Unidad{

    public Escenografia(String nombre, String imagen, String descripcion) {
        super(nombre, imagen, descripcion, TipoUnidad.Escenografia, new Atributos());
    }


    
    
}
