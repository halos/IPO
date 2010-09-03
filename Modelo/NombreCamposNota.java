
package Modelo;

/**
 * Define el nombre de los campos que tiene una nueva <tt>nota</tt>
 * @author Andres Jesus Ibañez Exposito
 */
public enum NombreCamposNota {

    /**
     * Nombre del campo que contiene a quién va dirigida la nota
     */
    DESTINATARIO ("Destinatario"),
    
    /**
     * Nombre del campo que contiene el una breve descripción de la nota
     */
    ASUNTO ("Asunto"),

    /**
     * Nombre del campo que contiene la prioridad de la nota
     */
    PRIORIDAD ("Prioridad"),

    /**
     * Nombre del campo que contiene la fecha en que fue creada la nota
     */
    FECHA("Fecha"),

    /**
     * Contenido de la nota
     */
    TEXTO("Texto");

    /* - Atributos -----------------------------------*/



     String nombre;




    /* - Métodos ----------------------------------------*/

     private NombreCamposNota(String nombre) {
         this.nombre=nombre;
    }

    /**
     * Método que devuelve el nombre de las etiquetas
     */
    @Override
    public String toString() {
        return nombre;
    }

    /**
     * Método para obeter el nombre del campo
     * @return Nombre del campo
     */
    public String getNombre() {
        return nombre;
    }






}
