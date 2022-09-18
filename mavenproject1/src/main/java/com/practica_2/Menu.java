/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica_2;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class Menu {
    
    public static void main(String[] args) {
    
        int opcion = -1;

        try {
            while (opcion != 1) {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Ingrese una opcion: \n"
                        + "1. Construir lista con base en una hilera.\n"
                ));
            }
        } catch (InputMismatchException e) {
            System.out.println("Usted a ingresado una opción invalida por favor ingrese nuevamente.");
        }

        switch (opcion) {
            case 1:
                String hilera = JOptionPane.showInputDialog(null, "Ingrese la hilera del arbol: ");
                int opcionInterna = -1;
                ArbolLg arbol = new ArbolLg();
                if (!arbol.validarHilera(hilera)) {
                    JOptionPane.showMessageDialog(null, "Hilera mal construida.");
                    opcionInterna = 0;
                }
                arbol.construirArbol(hilera);

                try {

                    while (opcionInterna != 0) {

                        opcionInterna = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Imprimir hilera.\n"
                                + "2. Imprimir la altura del árbol.\n"
                                + "3. Imprimir el grado del árbol.\n"
                                + "4. Imprimir el número de hojas del árbol.\n"
                                + "5. Imprimir el grado de un registro.\n"
                                + "6. Imprimir el nivel en el cual se halla el registro.\n"
                                + "7. Imprimir los ancestros de un registro.\n"
                                + "0. Salir del programa."));

                        switch (opcionInterna) {
                            case 1:
                                String impresion = arbol.imprimir();
                                JOptionPane.showMessageDialog(null, impresion);
                                break;
                            case 2:
                                int altura = arbol.altura();
                                JOptionPane.showMessageDialog(null, altura);
                                break;
                            case 3:
                                int grado = arbol.grado();
                                JOptionPane.showMessageDialog(null, grado);
                                break;
                            case 4:
                                int numeroHojas = arbol.numHojas();
                                JOptionPane.showMessageDialog(null, numeroHojas);
                                break;
                            case 5:
                                String Registro = JOptionPane.showInputDialog(null, "Ingrese el registro que desea conocer:");
                                int gradoRegistro = arbol.gradoRegistro(Registro);
                                JOptionPane.showMessageDialog(null, gradoRegistro);
                                break;
                            case 6:
                                String nivel = JOptionPane.showInputDialog(null, "Ingrese el registro que desea conocer:");
                                int nivelRegistro = arbol.nivelRegistro(nivel);
                                JOptionPane.showMessageDialog(null, nivelRegistro);
                                break;
                            case 7:
                                String registro = JOptionPane.showInputDialog(null, "Ingrese el registro que desea conocer: ");
                                String ancestrosRegistro = arbol.ancestros(registro);
                                JOptionPane.showMessageDialog(null, ancestrosRegistro);
                                break;

                            case 0:
                                System.exit(0);
                                break;
                        }

                    }
                } catch (InputMismatchException e) {

                }
        }
    
    }
}
