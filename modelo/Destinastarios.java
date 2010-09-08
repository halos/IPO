/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Javier Rascón Mesa
 */
public enum Destinastarios {

    JAVIER("Javier"),

    ANDRES("Andrés");

    /* Atributos */

    /**
     * Nombre del destinatario
     */
    String nombre;

    /* Métodos */

    private Destinastarios(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }



}
