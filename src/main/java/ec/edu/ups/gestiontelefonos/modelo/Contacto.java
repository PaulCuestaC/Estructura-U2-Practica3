/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.gestiontelefonos.modelo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author ESTUDIANTE
 */
public class Contacto {

    private String nombre;
    private String numero;
    LinkedList<String> correos;
    Map<String, String> redes;

    public Contacto(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
        this.correos = new LinkedList<>();
        this.redes = new HashMap<>();
    }

    public void ingresarCorreo(String correo) {
        correos.add(correo);
    }

    public void ingresarRedSocial(String redSocial, String link) {
        redes.put(redSocial, link);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LinkedList<String> getCorreos() {
        return correos;
    }

    public void setCorreos(LinkedList<String> correos) {
        this.correos = correos;
    }

    public Map<String, String> getRedes() {
        return redes;
    }

    public void setRedes(Map<String, String> redes) {
        this.redes = redes;
    }


    public void imprimir() {
        System.out.println("  correos: ");
        for (String correo : correos) {
            System.out.println("      " + correo);
        }
        System.out.println("  redes sociales: ");
        for (Map.Entry<String, String> entry : redes.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println("      " + key + ": " + val);
        }

    }

    @Override
    public String toString() {
        return "CONTACTO: Nombre: " + nombre + " Telefono: " + numero + " Correos: " + correos + " Redes Sociales: " + redes + "\n";
    }

}

