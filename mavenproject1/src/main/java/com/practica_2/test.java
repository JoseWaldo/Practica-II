/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.practica_2;

/**
 *
 * @author JoseW
 */
public class test {

    public static void main(String[] args) {
        NodoLG nodo1 = new NodoLG("a");
        NodoLG nodo2 = new NodoLG("b");
        NodoLG nodo3 = new NodoLG("c");
        NodoLG nodo4 = new NodoLG("d");

        nodo1.cambiarLiga(nodo2);
        nodo2.cambiarLiga(nodo3);
        nodo3.cambiarLiga(nodo4);

        NodoLG nodoIndex = nodo1;
        while (nodoIndex != null) {
            System.out.println("--------------------");
            System.out.println("Sw: " + nodoIndex.retornaSw());
            System.out.println("Dato: " + nodoIndex.retornaDato());
            System.out.println("Liga: " + nodoIndex.retornaLiga());
            System.out.println("--------------------");
            nodoIndex = nodoIndex.retornaLiga();
        }

        Object obj1 = "adsasd";
        Object obj2 = "adsasde";
        if (obj1.equals(obj2)) {
            System.out.println("Los objetos son iguales");
        }

        NodoSimple nodoA = new NodoSimple("a1");
        NodoSimple nodoB = new NodoSimple("b1");
        NodoSimple nodoC = new NodoSimple("c1");
        NodoSimple nodoD = new NodoSimple("d1");

        LSL lista = new LSL();

        System.out.println("La lista es vacia? " + lista.esVacia());
        lista.insertar(nodoA);
        System.out.println("La lista es vacia? " + lista.esVacia());
        lista.insertar(nodoB);
        lista.insertar(nodoC);
        lista.insertar(nodoD);
        lista.imprimir();
        System.out.println("Primer nodo de la lista: " + lista.retonarPrimerNodo().retornarDato());
        System.out.println("Ultimo nodo de la lista: " + lista.retornarUltimoNodo().retornarDato());
        NodoSimple nodoAnt = lista.anterior(nodoD);
        System.out.println("El nodo anterior al nodoD es: " + nodoAnt.retornarDato());
        /*
        NodoSimple nodAntEncontrado = lista.buscarDato("b1");
        if (nodAntEncontrado != null) {
            System.out.println("El dato encontrado esta luego de: " + nodAntEncontrado.retornarDato());
        } else {
            System.out.println("El dato no está en la lista");
        }
         */
        System.out.println("-------ELIMINANDO EL PRIMER NODO-------");
        lista.eliminarPrimerNodo();
        lista.imprimir();
        System.out.println("-------ELIMINANDO EL ÚLTIMO NODO-------");
        lista.eliminarUltimoNodo();
        lista.imprimir();
        System.out.println("Ultimo nodo de la lista: " + lista.retornarUltimoNodo().retornarDato());
        System.out.println("-------ELIMINANDO EL NODO B-------");
        lista.eliminarNodo("b1");
        lista.imprimir();

        lista.insertarAlInicio(nodoB);
        lista.insertarAlInicio(nodoA);
        lista.imprimir();

        /*------------ PROBANDO LA CLASE PILA ------------*/
        System.out.println("");
        System.out.println("-------PILA-------");
        Pila pila = new Pila();
        pila.apilar("A");
        pila.apilar("B");
        pila.apilar("C");
        pila.apilar("D");
        System.out.println("El dato que está en el tope de la pila es: " + pila.tope());
        pila.desapilar();
        System.out.println("Luego de desapilar,\nEl dato que está en el tope de la pila es: " + pila.tope());

    }
}
