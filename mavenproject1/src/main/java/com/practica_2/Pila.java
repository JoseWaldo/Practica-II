/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica_2;

/**
 *
 * @author JoseW
 */
public class Pila {

    // --------------ATRIBUTOS--------------
    private LSL listaDeElementos;

    // --------------CONSTRUCTOR--------------
    // Inicializa una pila vacia
    public Pila() {
        listaDeElementos = new LSL();
    }

    // --------------MÉTODOS--------------
    
    // Apilar, agrega un elemento al principio de la pila 
    public void apilar(Object dato) {
        NodoSimple nodo = new NodoSimple(dato);
        listaDeElementos.insertarAlInicio(nodo);
    }
    
    // Desapilar, retorna el dato que se encuentra en el tope de la pila,
    // y luego lo remueve.
    public Object desapilar() {
        if (this.esVacia()) {
            System.out.println("No es posible desapilar, ya que no hay datos");
            return null;
        }
        NodoSimple primerNodo = this.listaDeElementos.retonarPrimerNodo();
        this.listaDeElementos.eliminarPrimerNodo();
        if(primerNodo != null){
            return primerNodo.retornarDato();
        }
        return null;
    }

    // Muestra cual dato se encuentra en el tope de la pila sin eliminarlo.
    public Object tope() {
        if (this.esVacia()) {
            System.out.println("Lista vacia, no hay elementos que mostrar");
            return null;
        }
        return this.listaDeElementos.retonarPrimerNodo().retornarDato();
    }
    
    public boolean esVacia() {
        return this.listaDeElementos.retonarPrimerNodo() == null;
    }
}
