/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Javier Rascón Mesa
 */
public enum Prioridades {

    NORMAL("Normal",1),
    
    URGENTE("Urgente",5)
    
    ;

    /* Atributos */

    /**
     * Nombre que verá el usuario del nivel de proridad
     */
    String nombre;

    /*/
     * Valor de prioridad de una nota
     * Cuanto más alto más prioridad tiene la nota
     */
    int valor;

    /* Métodos */

    private Prioridades(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    



}
