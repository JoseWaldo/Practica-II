/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica_2;

/**
 *
 * @author JoseW
 */
public class ArbolLg {

    // --------------ATRIBUTOS--------------
    private NodoLG primero;
    private NodoLG ultimo;
    
    // --------------CONSTRUCTOR--------------
    public ArbolLg() {
        this.primero = null;
        this.ultimo = null;
    }
    
    // --------------GETTERS--------------
    public NodoLG retornarPrimero() {
        return this.primero;
    }

    public NodoLG retornarUltimo() {
        return this.ultimo;
    }

    // --------------MÉTODOS--------------
    public void construirArbol(String hilera) {
        
        int longitudHilera = hilera.length();
        Pila pila = new Pila();
        NodoLG p = new NodoLG(null);
        this.ultimo = p;
        this.primero = p;
        
        this.primero.cambiarDato(hilera.charAt(1) + "");
        this.primero.cambiarSw(0);
         
        int i = 3;
        
        while(i < longitudHilera) {
            if((hilera.charAt(i) + "").equals(",")) {
                i++;
                continue;
            }
            
            NodoLG x = new NodoLG(null);
            this.ultimo.cambiarLiga(x);
            
           if((hilera.charAt(i) + "").equals(")")) {
               i++;
           } else {
               
                if((hilera.charAt(i + 1) + "").equals("(")) {
                    this.ultimo = x;
                    NodoLG q = new NodoLG(null);
                    this.ultimo.cambiarSw(1);
                    this.ultimo.cambiarDato(q);
                    pila.apilar(this.ultimo);
                    this.ultimo = q;
                    q.cambiarSw(0);
                    q.cambiarDato(hilera.charAt(i) + "");
                    i += 2;
                }
                
                else if((hilera.charAt(i + 1) + "").equals(",")) {
                    x.cambiarDato(hilera.charAt(i) + "");
                    x.cambiarSw(0);
                    this.ultimo = x;
                    i += 2;
                }
                
                else if((hilera.charAt(i + 1) + "").equals(")")) {
                    x.cambiarDato(hilera.charAt(i) + "");
                    x.cambiarSw(0);
                    i++;
                    
                    while(i < longitudHilera && ((hilera.charAt(i) + "").equals(")")) && !pila.esVacia()) {
                        this.ultimo = (NodoLG)pila.desapilar();
                        i++;
                    }   
                }   
                
           }
            
        }
    }
    
    
}
