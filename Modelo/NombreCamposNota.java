
package Modelo;

/**
 * Define el nombre de los campos que tiene una nueva <tt>nota</tt>
 * @author Andres Jesus Ibañez Exposito
 */
public enum NombreCamposNota {

    /**
     * Nombre del campo que declara si una nota es urgente o no
     */
    PRIORIDAD ("Prioridad"),

    /**
     * Nombre del campo que contiene a quién va dirigida la nota
     */
    DESTINATARIO ("Destinatario"),

    /**
     * Nombre dele campo que contiene el una breve descripción de la nota
     */
    ASUNTO ("Asunto"),

    /**
     * Nombre del campo que contiene la fecha de recepción de la nota
     */
    FECHA ("Fecha"),

    /**
     * Nombre del campo que contiene el cuerpo principal de la nota
     */
    CUERPO ("Cuerpo"),

    /**
     * Nombre del campo que indica si una nota está leída o no
     */
    LEIDA ("Leida");

    /* - Atributos -----------------------------------*/

    private String _nombre;




    /* - Métodos ----------------------------------------*/

    /**
     * Constructor de la clase
     * @param nombre Nombre del campo enumerado
     */
    private NombreCamposNota(String nombre) {
         this._nombre=nombre;
    }

    /**
     * @return Nombre del campo que hace la llamada.
     */
    @Override
    public String toString() {
        return _nombre;
    }






}
