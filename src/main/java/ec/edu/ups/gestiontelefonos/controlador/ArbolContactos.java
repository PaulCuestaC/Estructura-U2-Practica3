/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.gestiontelefonos.controlador;

import ec.edu.ups.gestiontelefonos.modelo.Contacto;
import ec.edu.ups.gestiontelefonos.modelo.Nodo;
import java.util.LinkedList;
import java.util.Queue;
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

            return buscarContactoR(nodo.getLeft(), nombre);

        } else if (nombre.compareTo(nodo.getContacto().getNombre()) > 0) {

            return buscarContactoR(nodo.getRight(), nombre);

        } else {
            if (nombre.compareTo(nodo.getContacto().getNombre()) == 0) {

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

    public int obtenerAltura(Nodo nodo) {
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

    public int menu() {
        try{
        System.out.println("Ingrese la opcion que desea: ");
        System.out.println("1.- Agregar Contacto");
        System.out.println("2.- Buscar Contacto");
        System.out.println("3.- Eliminar Contacto");
        System.out.println("4.- Agregar Correo");
        System.out.println("5.- Agregar una red social");
        System.out.println("6.- Imprimir el arbol segun el recorrido");
        System.out.println("7.- Obtener el numero total de contactos");
        System.out.println("8.- Obtener el numero de niveles del arbol");
        System.out.println("9.- Salir");
        System.out.println("**********************************");
        int op1 = sc.nextInt();
        sc.nextLine();
        return op1;
        }catch(Exception ex){
        System.out.println(ex);
    }
        return 0;
    }

    public int subMenu() {
        try{
        System.out.println("Ingrese la opcion que desea: ");
        System.out.println("1.- Preorder");
        System.out.println("2.- Inorder");
        System.out.println("3.- Postorder");
        System.out.println("4.- Anchura");

        int op1 = sc.nextInt();
        sc.nextLine();
        return op1;
        
    
        }catch(Exception ex){
        System.out.println(ex);
    }
        return 0;
    }

    public void insertCompleto() {
try{
        System.out.println("Ingrese el nombre del Contacto: ");
        String nombre = sc.next();
        System.out.println("Ingrese el numero del Contacto: ");
        String telefono = sc.next();

        insert(new Contacto(nombre, telefono));
    }catch(Exception ex){
        System.out.println(ex);
    }
    }

    public void buscarCompleto() {
        try{
        System.out.println("Ingrese el nombre del Contacto a buscar: ");
        String nombre = sc.next();
        if (buscarContacto(nombre) == null) {
            System.out.println("El contacto no existe");
            System.out.println("¿Desea crear un nuevo contacto?");
            System.out.println("1 = No" + " " + "2 = Si");
            int op = sc.nextInt();
            if (op == 2) {

                System.out.println("Ingrese el número del contacto: ");
                String numero = sc.next();

                insert(new Contacto(nombre, numero));
            } else {
                System.out.println("Gracias");
            }
        } else {
            System.out.println(buscarContacto(nombre).getContacto());

        }
        }catch(Exception ex){
        System.out.println(ex);
    }
    }

    public void eliminarCompleto() {
        
        System.out.println("Ingrese el nombre del Contacto a eliminar: ");
        String nombre = sc.next();
        System.out.println(buscarContacto(nombre).getContacto());
        if(buscarContacto(nombre).getContacto()==null){
            System.out.println("Ese contacto no existe");
        }else{
        System.out.println("¿Esta seguro de querer eliminarlo?");
        System.out.println("1 = No" + " " + "2 = Si");
        int op = sc.nextInt();
        if (op == 2) {
            eliminarContactoR(nombre);
        } else {
            System.out.println("El Contacto " + buscarContacto(nombre) + " no ha sido eliminado");
        }
        }
    }

    public void agregarCorreo() {
        try{
        System.out.println("Ingrese el nombre del Contacto a agregar correo: ");
        String nombre = sc.next();
        Contacto contacto = buscarContacto(nombre).getContacto();
        System.out.println(contacto.toString());
        System.out.println("¿Este es el contacto correcto?");
        System.out.println("1 = No" + " " + "2 = Si");
        int op = sc.nextInt();
        if (op == 2) {
            System.out.println("Ingrese el correo: ");
            String correo = sc.next();
            contacto.ingresarCorreo(correo);
        } else {
            System.out.println("¿Desea Continuar?");
            System.out.println("1 = No" + " " + "2 = Si");
            int op2 = sc.nextInt();
            if (op2 == 2) {
                System.out.println("Ingrese el nombre del Contacto a agregar correo: ");
                String nombre2 = sc.next();
                Contacto contacto2 = buscarContacto(nombre2).getContacto();
                System.out.println(contacto2.toString());
                System.out.println("¿Este es el contacto correcto?");
                System.out.println("1 = No" + " " + "2 = Si");
                int op3 = sc.nextInt();
                if (op3 == 2) {
                    String correo = sc.next();
                    contacto.ingresarCorreo(correo);
                }
            } else {

            }
        }
}catch(Exception ex){
        System.out.println(ex);
    }
    }

    public void agregarRed() {
        try{
        System.out.println("Ingrese el nombre del Contacto a agregar red social: ");
        String nombre = sc.next();
        Contacto contacto = buscarContacto(nombre).getContacto();
        System.out.println(contacto.toString());
        System.out.println("¿Este es el contacto correcto?");
        System.out.println("1 = No" + " " + "2 = Si");
        int op = sc.nextInt();
        if (op == 2) {
            System.out.println("Ingrese la red social: ");
            String red = sc.next();
            System.out.println("Ingrese el link: ");
            String link = sc.next();
            contacto.ingresarRedSocial(red, link);
        } else {
            System.out.println("¿Desea Continuar?");
            System.out.println("1 = No" + " " + "2 = Si");
            int op2 = sc.nextInt();
            if (op2 == 2) {
                System.out.println("Ingrese el nombre del Contacto a agregar red social: ");
                String nombre2 = sc.next();
                Contacto contacto2 = buscarContacto(nombre2).getContacto();
                System.out.println(contacto2.toString());
                System.out.println("¿Este es el contacto correcto?");
                System.out.println("1 = No" + " " + "2 = Si");
                int op3 = sc.nextInt();
                if (op3 == 2) {
                    System.out.println("Ingrese la red social: ");
                    String red = sc.next();
                    System.out.println("Ingrese el link: ");
                    String link = sc.next();
                    contacto.ingresarRedSocial(red, link);
                }
            } else {

            }
        }
}catch(Exception ex){
        System.out.println(ex);
    }
    }
     public void inorderRecursivo(Nodo nodo) {
        if (nodo != null) {
            inorderRecursivo(nodo.getLeft());
            System.out.print(nodo.getContacto() + " - ");
            inorderRecursivo(nodo.getRight());

        }
    }
     public Nodo getRaiz() {
        return raiz;
    }
     public void postORderRecursivo(Nodo nodo) {
        if (nodo != null) {
            inorderRecursivo(nodo.getLeft());

            inorderRecursivo(nodo.getRight());
            System.out.print(nodo.getContacto() + " - ");

        }
    }
      Queue<Nodo> cola = new LinkedList<>();

    public void anchura(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        cola.clear();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Nodo nodo = cola.remove();
            System.out.print(nodo.getContacto() + " ");
            if (nodo.getLeft()!= null) {
                cola.add(nodo.getLeft());
            }
            if (nodo.getRight()!= null) {
                cola.add(nodo.getRight());
            }
        }

    }
    public int pesoArbol(Nodo nodo) {
        if (nodo != null) {
            return 1 + pesoArbol(nodo.getLeft()) + pesoArbol(nodo.getRight());
        }
        return 0;
    }
    
}
