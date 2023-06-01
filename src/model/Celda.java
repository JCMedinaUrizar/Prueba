/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Oscar
 */
public class Celda<T> {

    //Atributos
    private T contenidoCelda;

    //Constructor
    public Celda(T contenidoCelda) {
        this.contenidoCelda = contenidoCelda;
    }

    //Metodos Get y Set
    public T getContenidoCelda() {
        return contenidoCelda;
    }

    public void setContenidoCelda(T contenidoCelda) {
        this.contenidoCelda = contenidoCelda;
    }

    
}
