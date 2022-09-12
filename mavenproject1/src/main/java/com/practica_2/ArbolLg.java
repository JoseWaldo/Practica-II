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
        
        while(i < longitudHilera - 2) {
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
    
    public void imprimirHilera() {
        String hilera = "";
        hilera = "(" + this.primero.retornaDato() + "(";
        NodoLG p = this.primero.retornaLiga();
        Pila pila = new Pila();
        
        while(p != null) {
            
            try {
                
                if(p.retornaLiga() != null) {
                    if(p.retornaSw() == 1 && p.retornaLiga().retornaSw() == 0) {
                        pila.apilar(p);
                        p = (NodoLG) p.retornaDato();
                        hilera += p.retornaDato() + "(";
                        p = p.retornaLiga();
                    }

                    else if(p.retornaSw() == 0 && p.retornaLiga().retornaSw() == 1) {
                        hilera += p.retornaDato();
                        p = p.retornaLiga();
                        pila.apilar(p);
                        p = (NodoLG) p.retornaDato();
                        hilera += "," + p.retornaDato() + "(";
                        p = p.retornaLiga();
                    }

                    else if(p.retornaSw() == 0 && p.retornaLiga().retornaSw() == 0) {
                        hilera += p.retornaDato() + ",";
                        p = p.retornaLiga();
                    }
                    
                    else if(p.retornaSw() == 1 && p.retornaLiga() != null) {
                        hilera += ",";
                        p = (NodoLG) p.retornaDato();
                    }
                } else {
                    if(p.retornaSw() == 0 && p.retornaLiga() == null && !pila.esVacia()) {
                        hilera += p.retornaDato() + ")";
                        p = (NodoLG) pila.desapilar();
                    }

                    else if(p.retornaSw() == 1 && p.retornaLiga() == null && !pila.esVacia()) {
                        hilera += ")";
                        p = (NodoLG) pila.desapilar();
                    }

                    else if(p.retornaSw() == 1 && p.retornaLiga() == null && pila.esVacia()) {
                        break;
                    }
                }

            } catch (Exception e) {
                System.err.println("Se ha generado un error de tipo: " + e.getMessage());
            }
        }
        
        hilera += "))";
        
        System.out.println(hilera);
    }
    
    public String imprimir() {
        
        String escritura = "(" + this.primero.retornaDato();
        Pila pila = new Pila();
        NodoLG nodo = this.primero;
        
        while(nodo != null) {
            if(nodo.retornaSw() == 0 && nodo.retornaLiga() != null && nodo.retornaLiga().retornaSw() == 0) {
                escritura += nodo.retornaDato() + ",";
                nodo = nodo.retornaLiga();
            }
            else if(nodo.retornaSw() == 1 && nodo.retornaLiga() != null && nodo.retornaLiga().retornaSw() == 1) {
                escritura += nodo.retornaDato();
                nodo = nodo.retornaLiga();
            }
            else if(nodo.retornaSw() == 1) {
                pila.apilar(nodo);
                nodo = (NodoLG) nodo.retornaDato();
                escritura += "(" + nodo.retornaDato();
            }
            while(nodo == null && !pila.esVacia()) {
                nodo = (NodoLG) pila.desapilar();
                nodo = nodo.retornaLiga();
                escritura += ")";
            }
        }
        
        escritura += "))";
        
        return escritura;
    }
    
    public int altura() {
        
        int altura = 2;
        int alturaMax = 0;
        Pila pila = new Pila();
        
        if(this.primero.retornaLiga() == null) {
            return 1;
        }
        
        NodoLG p = this.primero.retornaLiga();
        
        while(p != null) {
           
            if(p.retornaSw() == 1) {
                pila.apilar(p);
                p = (NodoLG) p.retornaDato();
                altura++;
            }
            
            else if(p.retornaLiga() != null) {
                if(p.retornaSw() == 0 && p.retornaLiga().retornaSw() == 0) {
                    p = p.retornaLiga();
                }
                else if(p.retornaSw() == 0 && p.retornaLiga().retornaSw() == 1) {
                    p = p.retornaLiga();
                }
            }
            
            else if(p.retornaLiga() == null && !pila.esVacia()) {
                
                if(altura > alturaMax) {
                    alturaMax = altura;
                    altura--;
                    p = (NodoLG) pila.desapilar();
                    if(p.retornaLiga() == null && !pila.esVacia()) {
                        p = (NodoLG)pila.desapilar();
                        altura--;
                    }
                    p = p.retornaLiga();
                } else {
                    altura--;
                    p = (NodoLG) pila.desapilar();
                    if(p.retornaLiga() == null && !pila.esVacia()) {
                        p = (NodoLG)pila.desapilar();
                        altura--;
                    }
                    p = p.retornaLiga();
                }
            }
        }
        
        return alturaMax;
    }
  
    public int grado() {
        Pila pila = new Pila();
        Pila pilaRecorrido = new Pila();
        NodoLG nodo = this.primero;
        int gradoMayor = 0;
        
        while(nodo != null) {
            
            if(nodo.retornaSw() == 0) {
                //recorrido += p.retornaDato();
                nodo = nodo.retornaLiga();
            }
            else if(nodo.retornaSw() == 1) {
                pila.apilar(nodo);
                pilaRecorrido.apilar(nodo);
                nodo = (NodoLG) nodo.retornaDato();
            }
            
            while(nodo == null && !pilaRecorrido.esVacia()) {
                nodo = (NodoLG) pilaRecorrido.desapilar();
                nodo = nodo.retornaLiga();
            }
            
        }
        
        while(!pila.esVacia()) {
            nodo = (NodoLG) pila.desapilar();
            nodo = (NodoLG) nodo.retornaDato();
            
            int grado = -1;
            
            while(nodo != null) {
                nodo = nodo.retornaLiga();
                grado++;
            }
            if(grado > gradoMayor) {
                gradoMayor = grado;
            }
        }
        return gradoMayor;
    }
    
    public int numHojas() {
        
        Pila pila = new Pila();
        Pila pilaRecorrido = new Pila();
        NodoLG nodo = this.primero.retornaLiga();
        
        while(nodo != null) {
            
            if(nodo.retornaSw() == 0) {
                //recorrido += p.retornaDato();
                nodo = nodo.retornaLiga();
            }
            else if(nodo.retornaSw() == 1) {
                pila.apilar(nodo);
                pilaRecorrido.apilar(nodo);
                nodo = (NodoLG) nodo.retornaDato();
            }
            
            while(nodo == null && !pilaRecorrido.esVacia()) {
                nodo = (NodoLG) pilaRecorrido.desapilar();
                nodo = nodo.retornaLiga();
            }
            
        }
        
        int hojas = 0;
        
        while(!pila.esVacia()) {
            nodo = (NodoLG) pila.desapilar();
            nodo = (NodoLG) nodo.retornaDato();
            nodo = nodo.retornaLiga();
            
            while(nodo != null) {
                if(nodo.retornaSw() == 0) {
                    hojas++;
                    nodo = nodo.retornaLiga();
                } else if(nodo.retornaSw() == 1) {
                    nodo = nodo.retornaLiga();
                }
            }
        }
        
        nodo = this.primero.retornaLiga();
        
        while(nodo != null) {
            if(nodo.retornaSw() == 0) {
                hojas++;
                nodo = nodo.retornaLiga();
            } else if(nodo.retornaSw() == 1) {
                nodo = nodo.retornaLiga();
            }
        }
        
        return hojas;
    }
    
    public int gradoRegistro(String registro) {
        Pila pila = new Pila();
        Pila pilaRecorrido = new Pila();
        NodoLG nodo = this.primero.retornaLiga();
        
        while(nodo != null) {
            
            if(nodo.retornaSw() == 0) {
                //recorrido += p.retornaDato();
                nodo = nodo.retornaLiga();
            }
            else if(nodo.retornaSw() == 1) {
                pila.apilar(nodo);
                pilaRecorrido.apilar(nodo);
                nodo = (NodoLG) nodo.retornaDato();
            }
            
            while(nodo == null && !pilaRecorrido.esVacia()) {
                nodo = (NodoLG) pilaRecorrido.desapilar();
                nodo = nodo.retornaLiga();
            }
            
        }
        
        int grado = 0;
        
        while(!pila.esVacia()) {
            nodo = (NodoLG)pila.desapilar();
            nodo = (NodoLG) nodo.retornaDato();
            if(nodo.retornaDato().equals(registro)) {
                nodo = nodo.retornaLiga();
                while(nodo != null) {
                    grado++;
                    nodo = nodo.retornaLiga();
                }
                return grado;
            }
        }        
        return grado;
    }
    
    public int nivelRegistro(String registro) {
        int altura = 2;
        int alturaMax = 0;
        Pila pila = new Pila();
        
        if(this.primero.retornaLiga() == null) {
            return 1;
        }
        
        NodoLG p = this.primero.retornaLiga();
        
        while(p != null){
            if(p.retornaDato().equals(registro)) {
                return altura;
            }
            if(p.retornaSw() == 1) {
                pila.apilar(p);
                p = (NodoLG) p.retornaDato();
                altura++;
            }
            
            else if(p.retornaLiga() != null){
                if(p.retornaSw() == 0 && p.retornaLiga().retornaSw() == 0) {
                    p = p.retornaLiga();
                }
                else if(p.retornaSw() == 0 && p.retornaLiga().retornaSw() == 1) {
                    p = p.retornaLiga();
                }
            }
            
            else if(p.retornaLiga() == null && !pila.esVacia()) {
                if(altura > alturaMax) {
                    alturaMax = altura;
                    altura--;
                    p = (NodoLG) pila.desapilar();
                    p = p.retornaLiga();
                }
                else {
                    p = (NodoLG) pila.desapilar();
                    p = p.retornaLiga();
                }
            }
            
        }
        
        return alturaMax;
    }
    
    public String ancestros(String registro) {
        Pila pila = new Pila();
        Pila pilaRecorrido = new Pila();
        NodoLG nodo = this.primero;
        String ancestros = "";
        
        while(nodo != null) {
            
            if(nodo.retornaSw() == 0) {
                nodo = nodo.retornaLiga();
            }
            else if(nodo.retornaSw() == 1) {
                pila.apilar(nodo);
                pilaRecorrido.apilar(nodo);
                nodo = (NodoLG) nodo.retornaDato();
            }
            
            while(nodo == null && !pilaRecorrido.esVacia()) {
                nodo = (NodoLG) pilaRecorrido.desapilar();
                nodo = nodo.retornaLiga();
            }
            
        }
        
        nodo = this.primero;
        
        while(nodo != null) {
            if(nodo.retornaDato().equals(registro)) {
                ancestros = (String) this.primero.retornaDato();
                while(!pila.esVacia()) {
                    nodo = (NodoLG) pila.desapilar();
                    nodo = (NodoLG) nodo.retornaDato();
                    ancestros = ancestros + nodo.retornaDato();
                }
                return ancestros;
            }
            
            nodo = nodo.retornaLiga();
            if(nodo != null) {
                if(nodo.retornaSw() == 0) {
                    if(nodo.retornaLiga() == null && !pilaRecorrido.esVacia()) {
                        nodo = (NodoLG) pilaRecorrido.desapilar();
                    }
                }
            
                else if(nodo.retornaSw() == 1) {
                    pilaRecorrido.apilar(nodo);
                    nodo = (NodoLG) nodo.retornaDato();
                }
            }
            
        }
        
        return ancestros;
    }
    
    public String recorrerArbol() {
        String recorrido = "";
        Pila pila = new Pila();
        NodoLG p = this.primero;
        while(p != null) {
            
            if(p.retornaSw() == 0) {
                recorrido += p.retornaDato();
                p = p.retornaLiga();
            }
            else if(p.retornaSw() == 1) {
                pila.apilar(p);
                p = (NodoLG) p.retornaDato();
            }
            
            while(p == null && !pila.esVacia()) {
                p = (NodoLG) pila.desapilar();
                p = p.retornaLiga();
            }
            
        }
        return recorrido;
    }
    
}
