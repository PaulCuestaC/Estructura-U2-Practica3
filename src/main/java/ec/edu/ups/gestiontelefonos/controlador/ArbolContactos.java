/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.gestiontelefonos.controlador;

import ec.edu.ups.gestiontelefonos.modelo.Contacto;
import ec.edu.ups.gestiontelefonos.modelo.Nodo;
import java.util.Scanner;
import java.util.Stack;
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
                nodo.setLeft(new Nodo(contacto));
            } else {
                insertRecursivo(nodo.getLeft(), contacto);
            }
        } else if (contacto.getNombre().compareTo(nodo.getContacto().getNombre()) > 0) {
            if (nodo.getRight() == null) {
                nodo.setRight(new Nodo(contacto));
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
            } else {

            }
        }

    }

    public Nodo buscarContacto(String nombre) {
        raiz = buscarContactoR(raiz, nombre);
        return raiz;
    }

    public Nodo buscarContactoR(Nodo nodo, String nombre) {

        if (nodo == null) {
            return nodo;
        }
        if (nombre.compareTo(nodo.getContacto().getNombre()) < 0) {
            System.out.println(nodo.getContacto()+"1");
            return buscarContactoR(nodo.getLeft(), nombre);
            
        } else if (nombre.compareTo(nodo.getContacto().getNombre()) > 0) {
            System.out.println(nodo.getContacto()+"3");
           return buscarContactoR(nodo.getRight(), nombre);

        } else {
            if (nombre.compareTo(nodo.getContacto().getNombre()) == 0) {
                System.out.println(nodo.getContacto()+"2");
                return nodo;

            }

        }
//        return nodo;
        return null;
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

    public void eliminarContactoR(String nombre) {
        raiz = eliminarContacto(raiz, nombre);
    }

    public Nodo eliminarContacto(Nodo nodo, String nombre) {
        if (nodo == null) {
            return nodo;
        }
        if (nombre.compareTo(nodo.getContacto().getNombre()) < 0) {
            nodo.setLeft(eliminarContacto(nodo.getLeft(), nombre));

        } else if (nombre.compareTo(nodo.getContacto().getNombre()) > 0) {
            nodo.setRight(eliminarContacto(nodo.getRight(), nombre));

        } else {
            if (nodo.getLeft() == null) {
                return nodo.getRight();
            } else if (nodo.getRight() == null) {
                return nodo.getLeft();
            }
            if (nodo.getLeft() == null && nodo.getRight() == null) {
                return nodo;
            }

            Nodo susesor = encontrarMinimo(nodo.getRight());
            nodo.setContacto(susesor.getContacto());
            nodo.setRight(eliminarContacto(nodo.getRight(), susesor.getContacto().getNombre()));
        }
        return nodo;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getLeft() != null) {
            nodo = nodo.getLeft();
        }
        return nodo;
    }

    public void preOrder() {
        if (raiz == null) {
            return;
        }
        System.out.println("Ordenacion pre order: ");
        Stack<Nodo> stack = new Stack<>();
        stack.push(raiz);

        while (!stack.isEmpty()) {
            Nodo actual = stack.pop();

            System.out.print(actual.getContacto() + " - ");

            if (actual.getRight() != null) {
                stack.push(actual.getRight());
            }
            if (actual.getLeft() != null) {
                stack.push(actual.getLeft());
            }

        }
    }

}
