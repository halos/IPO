/*
 * Destinatario.java
 */

package modelo;

/**
 * Jefes de Javier. Son los destinatarios de las notas.
 * @author Andrés Jesús Ibáñez Expósito
 */
public enum Destinatario {

    /**
     * Sara es una jefa de Javier. Es quien recibe más notas
     */
    SARA("Sara"),
    /**
     * Jesús es un jefe de Javier.
     */
    JESUS("Jesús"),
    /**
     * M_Jesús es otra jefa de Javier. Es la becaria que recibe todo el spam
     */
    M_JESUS("Mª Jesús");


    /* ATRIBUTOS ---------------------------------------------------------------*/
    /**
     * nombre visibie que se le da a la constante
     */
    private String nombre;


    /* MÉTODOS ----------------------------------------------------------------- */


/**
 * Constructor de los jefes
 * @param nombre El nombre del tio
 * @param sueldo
 */
    private Destinatario(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Nombre del campo que hace la llamada.
     */
    @Override
    public String toString() {

        return nombre;
    }

}
