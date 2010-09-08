/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 * Tipos de prioridades
 * @author Javier Rascón Mesa
 */
public enum Prioridades {

    NORMAL("Normal"),
    
    URGENTE("Urgente")
    
    ;

    /*---- Atributos ----*/

    /**
     * Nombre que verá el usuario del nivel de proridad
     */
    String nombre;

    /*---- Métodos ----*/

    /**
     * Constructor
     * @param nombre Nombre de la prioridad
     */
    private Prioridades(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el nombre de la prioridad
     * @return Nombre de la prioridad
     */
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    



}
