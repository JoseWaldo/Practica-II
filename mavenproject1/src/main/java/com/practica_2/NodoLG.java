/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica_2;

/**
 *
 * @author JoseW
 */
public class NodoLG {

    // --------------ATRIBUTOS--------------
    private int sw;
    private Object dato;
    private NodoLG liga;

    // --------------CONSTRUCTOR--------------
    public NodoLG(Object dato) {
        this.dato = dato;
        this.sw = 0;
    }

    // --------------GETTERS--------------
    public int retornaSw() {
        return this.sw;
    }

    public Object retornaDato() {
        return this.dato;
    }

    public NodoLG retornaLiga() {
        return this.liga;
    }

    // --------------SETTERS--------------
    public void cambiarSw(int sw) {
        this.sw = sw;
    }

    public void cambiarDato(Object dato) {
        this.dato = dato;
    }

    public void cambiarLiga(NodoLG liga) {
        this.liga = liga;
    }
}
