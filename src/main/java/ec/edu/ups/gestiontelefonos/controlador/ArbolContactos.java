/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.gestiontelefonos.controlador;

import ec.edu.ups.gestiontelefonos.modelo.Contacto;
import ec.edu.ups.gestiontelefonos.modelo.Nodo;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTE
 */
public class ArbolContactos {

    private Nodo raiz;
    Scanner sc = new Scanner(System.in);

    public ArbolContactos() {
        this.raiz = null;
    }

    public void insert(Contacto contacto) {
        if (raiz == null) {
            raiz = new Nodo(contacto);
        } else {
            insertRecursivo(raiz, contacto);
        }
    }

    private void insertRecursivo(Nodo nodo, Contacto contacto) {
        if (contacto.getNombre().compareTo(nodo.getContacto().getNombre()) < 0) {
            if (nodo.getLeft() == null) {
                nodo.setLeft(nodo);
            } else {
                insertRecursivo(nodo.getLeft(), contacto);
            }
        } else if (contacto.getNombre().compareTo(nodo.getContacto().getNombre()) > 0) {
            if (nodo.getRight() == null) {
                nodo.setRight(nodo);
            } else {
                insertRecursivo(nodo.getRight(), contacto);
            }

        } else {
            System.out.println("¿Desea actualizar el numero?");
            System.out.println("1 = Si");
            System.out.println("2 = No");
            int scanner = sc.nextInt();
            if (scanner == 1) {
                nodo.setContacto(contacto);
            }
        }

    }

    public boolean setEquilibradi() {
        return verificarBalance(raiz);
    }

    private boolean verificarBalance(Nodo node) {
        if (node == null) {
            return true;
        } else {

            int alturaIzquierda = obtenerAltura(node.getLeft());
            int alturaDerecha = obtenerAltura(node.getRight());
            int diferencia = Math.abs(alturaIzquierda - alturaDerecha);

            if (diferencia > 1) {
                return false;
            }
            return verificarBalance(node.getLeft()) && verificarBalance(node.getRight());
        }
    }

    private int obtenerAltura(Nodo nodo) {
        if (nodo == null) {
            return 1;
        }
        int alturaIzquierda = obtenerAltura(nodo.getLeft());
        int alturaDerecha = obtenerAltura(nodo.getRight());

        return Math.max(alturaIzquierda, alturaDerecha + 1);

    }
}
