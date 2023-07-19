/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.ups.gestiontelefonos;

import ec.edu.ups.gestiontelefonos.controlador.ArbolContactos;
import ec.edu.ups.gestiontelefonos.modelo.Contacto;

/**
 *
 * @author ESTUDIANTE
 */
public class GestionTelefonos {
    
    public static void main(String[] args) {
        ArbolContactos arbol = new ArbolContactos();
        
        Contacto c1 = new Contacto("Juan", "12345");
        Contacto c2 = new Contacto("Maria", "12345");
        Contacto c3 = new Contacto("Pedro", "12345");
        Contacto c4 = new Contacto("Pablo", "12345");
        
        arbol.insert(c1);
        arbol.insert(c2);
        arbol.insert(c3);
        arbol.insert(c4);
        arbol.insert(new Contacto("Julina", "44857"));
        arbol.insert(new Contacto("Jhon", "35483749"));
        arbol.insert(new Contacto("Jhonn","325255"));
        arbol.preOrder();
        arbol.eliminarContactoR("Juan");
        System.out.println(" ");
        arbol.preOrder();
    }
}
