/*
 * ModeloInterface.java
 */

package Modelo;

import java.io.IOException;
import java.util.List;

/**
 * Estrategia para la definicion del modelo de la aplicacion.
 * @author Andrés Jesús Ibáñez Expósito.
 */
public interface ModeloInterface {

    /* - Metodos ----------------------------------------------------------- */

    /**
     * Crea una nueva nota.
     * @param nota la nueva nota a ser creada
     */
    public void nuevaNota (Nota nota);

    /**
     * Busca entre todas las notas según unos criterios dados.
     * @param criterios Criterios de búsqueda definidos
     * @return Lista de notas que cumplen los criterios especificados
     */
    public List<Nota> buscar (CamposNota criterios);

    /**
     * Elimina la última nota añadida.
     */
    public void eliminarUltimaNota();

    /**
     * Almacena en soporte persistente todas las notas.
     */
    public void guardar() throws IOException;

    /**
     * Modifica el contenido de una nota determinada
     * @param campos Campos que van a sufrir modificación
     * @param nota Nota que va a ser modificada
     */
    public void ModificarNota(CamposNota campos, Nota nota);

    /**
     * Marcar una nota como leída.
     * @param n Nota que va a ser marcada
     */
    public void marcarLeida(Nota n);
    /**
     * Marcar una nota como no leída.
     * @param n Nota que va a ser marcada.
     */
    public void marcarNoLeida(Nota n);
}
