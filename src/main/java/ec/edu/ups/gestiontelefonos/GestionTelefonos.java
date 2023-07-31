/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.ups.gestiontelefonos;

import ec.edu.ups.gestiontelefonos.controlador.ArbolContactos;

/**
 *
 * @author ESTUDIANTE
 */
public class GestionTelefonos {

    public static void main(String[] args) {
        ArbolContactos arbol = new ArbolContactos();
        int op1 = 0;

        while (op1 != 9) {
            System.out.println("**********************************");
            op1 = arbol.menu();
            if (op1 < 10) {
                switch (op1) {
                    case 1:
                        arbol.insertCompleto();

                        break;
                    case 2:

                        arbol.buscarCompleto();
                        break;
                    case 3:
                        arbol.eliminarCompleto();

                        break;
                    case 4:
                        arbol.agregarCorreo();
                        break;
                    case 5:
                        arbol.agregarRed();
                        break;
                    case 6:
                        int op = arbol.subMenu();
                        if (op == 1) {
                            arbol.preOrder();
                            break;
                        } else if (op == 2) {
                            arbol.inorderRecursivo(arbol.getRaiz());
                            break;
                        } else if (op == 3) {
                            arbol.postORderRecursivo(arbol.getRaiz());
                            break;
                        } else if (op == 4) {
                            arbol.anchura(arbol.getRaiz());
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        int peso = arbol.pesoArbol(arbol.getRaiz());
                        System.out.println(peso);
                        break;
                    case 8:
                        int altura = arbol.obtenerAltura(arbol.getRaiz());
                        System.out.println(altura);
                        break;
                }

            } else {
                System.out.println("Opcion Incorrecta");
            }
        }
    }

}
