/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica_2;

/**
 *
 * @author JoseW
 */
public class LSL {

    // --------------ATRIBUTOS--------------
    private NodoSimple primero;
    private NodoSimple ultimo;

    // --------------CONSTRUCTOR--------------
    // Constructor que se inicializa con nodos primero y último
    // Siendo iguales a nulo
    public LSL() {
        this.primero = null;
        this.ultimo = null;
    }

    // --------------GETTERS--------------
    // Getters de los nodos primero y último
    public NodoSimple retonarPrimerNodo() {
        return primero;
    }

    public NodoSimple retornarUltimoNodo() {
        return ultimo;
    }

    // --------------METODOS DE LA CLASE--------------
    // Insertar: simplemente agrega un elemento luego del último
    public void insertar(NodoSimple nodo) {
        if(nodo == null) {
            System.out.println("No es posible insertar un nodo nulo");
            return;
        }
        if (this.esVacia()) {
            this.primero = nodo;
            this.ultimo = this.primero;
        } else {
            this.ultimo.cambiarLiga(nodo);
            this.ultimo = nodo;
        }
    }
    
    //Insertar elemento al principio de la lista
    public void insertarAlInicio(NodoSimple nodo) {
        if(nodo == null) {
            System.out.println("No es posible insertar un nodo nulo");
            return;
        }
        if (this.esVacia()) {
            this.primero = nodo;
            this.ultimo = this.primero;
        } else {
            NodoSimple aux = this.primero;
            this.primero = nodo;
            nodo.cambiarLiga(aux);
        }
    }
    
    // Elimina el último nodo de la lista
    public void eliminarUltimoNodo() {
        NodoSimple antUltimo = this.anterior(this.ultimo);
        if (!this.esVacia()) {
            if (antUltimo != null) {
                antUltimo.cambiarLiga(null);
            }
            this.ultimo = antUltimo;
        }
    }

    // Elimina un nodo solo si el dato enviado como parametro se encuentra 
    // en la lista.
    public void eliminarNodo(Object dato) {
        NodoSimple datoAntEncontrado = null;
        boolean datoEncontrado = this.buscarDato(dato, datoAntEncontrado);
        if (datoEncontrado) {
            if (datoAntEncontrado == null) {
                //datoAntEncontrado.cambiarLiga(this.primero.retornarLiga());
                this.primero = this.ultimo;
            } else {
                datoAntEncontrado.cambiarLiga(datoAntEncontrado.retornarLiga().retornarLiga());
            }
        }
        System.out.println("No se puede eliminar el dato");
    }

    // Elimina el primer nodo de la lista.
    public void eliminarPrimerNodo() {
        if (!this.esVacia()) {
            this.primero = this.primero.retornarLiga();
        }
    }

    // Busca el dato que se le envia como parametro, en el otro parametro
    // se ingresa un parametro de tipo NodoSimple pero siendo nulo, 
    // con el fin de que retorne en el, el nodo anterior donde se encuentra
    // el dato buscado, ademas, se envia un booleano como respuesta de si 
    // se encontró el dato.
    public boolean buscarDato(Object dato, NodoSimple nodoResAnt) {
        NodoSimple nodoIndex = this.primero;
        while (!this.finDeRecorrido(nodoIndex)) {
            if (nodoIndex.retornarDato().equals(dato)) {
                nodoResAnt = this.anterior(nodoIndex);
                return true;
            }
            nodoIndex = nodoIndex.retornarLiga();
        }
        return false;
    }

    // Simplemente retorna el nodo anterior al que se envio por parametro
    public NodoSimple anterior(NodoSimple nodo) {
        NodoSimple nodoIndex = this.primero;
        NodoSimple antIndex = null;
        while (!this.finDeRecorrido(nodoIndex)) {
            if (nodoIndex.retornarDato().equals(nodo.retornarDato())) {
                return antIndex;
            }
            antIndex = nodoIndex;
            nodoIndex = nodoIndex.retornarLiga();
        }
        return null;
    }

    // Retorna verdadero si la lista está vacia
    public boolean esVacia() {
        return primero == ultimo && primero == null;
    }

    // Retorna una respuesta de si el nodo indice es igual a nulo
    public boolean finDeRecorrido(NodoSimple nodoIndex) {
        return nodoIndex == null;
    }

    // Imprime los datos y las ligas de la lista
    public void imprimir() {

        if (this.esVacia()) {
            System.out.println("No hay datos que imprimir");
            return;
        }

        NodoSimple nodoIndex = this.primero;
        while (!this.finDeRecorrido(nodoIndex)) {
            System.out.println("--------------------");
            System.out.println("Dato: " + nodoIndex.retornarDato());
            System.out.println("Liga: " + nodoIndex.retornarLiga());
            System.out.println("--------------------");
            nodoIndex = nodoIndex.retornarLiga();
        }
    }
}
