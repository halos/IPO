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
    String _nombre;

    /*/
     * Valor de prioridad de una nota
     * Cuanto más alto más prioridad tiene la nota
     */
    int _valor;

    /* Métodos */

    private Prioridades(String nombre, int valor) {
        this._nombre = nombre;
        this._valor = valor;
    }

    public String getNombre() {
        return this._nombre;
    }

    public int getValor() {
        return _valor;
    }

    @Override
    public String toString() {
        return this._nombre;
    }

    



}
