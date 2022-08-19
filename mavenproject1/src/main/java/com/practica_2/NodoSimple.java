/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica_2;

/**
 *
 * @author JoseW
 */
public class NodoSimple {

    // --------------ATRIBUTOS--------------
    private Object dato;
    private NodoSimple liga;

    // --------------CONSTRUCTOR--------------
    public NodoSimple(Object dato) {
        this.dato = dato;
    }

    // --------------GETTERS--------------
    public Object retornarDato() {
        return dato;
    }

    public void cambiarDato(Object dato) {
        this.dato = dato;
    }

    // --------------SETTERS--------------
    public NodoSimple retornarLiga() {
        return liga;
    }

    public void cambiarLiga(NodoSimple liga) {
        this.liga = liga;
    }

}
