/*
 * ControladorInterface.java
 */

package controlador;

import controlador.undo.ObservadorPilaDeshacer;
import java.util.List;
import modelo.Nota;

/**
 * Estrategia para la definicion del controlador de la aplicacion.
 * @author Andrés Jesús Ibáñez Expósito
 */
public interface ControladorInterface {


    /* - Metodos ----------------------------------------------------------- */

    /**
     * Crea una orden para introducir una nueva nota en el sistema
     */
    public void nuevaNota();
    
    /**
     * Crea una orden para modificar una nota ya existente
     * @param nota la nota que será modificada
     */
    public void modificarNota(Nota nota);

    /**
     * Crea una orden para marcar como leida una nota
     * @param nota la nota a marcar como leida
     */
    public void marcarLeida(Nota nota);

    /**
     * Crea una orden para marcar una nota como no leida
     * @param nota la nota a marcar como no leida
     */
    public void marcarNoLeida(Nota nota);

    /**
     * solicita una búsqueda al modelo con los criterios que facilite la vista
     */
    public void busquedaSolicitada();


    /**
     * Registra un nuevo observador de los cambios de la búsqueda para que éste sea
     * notificado de los cambios
     * @param observador Observador a añadir a la lista
     */
    public void registrarObservadorResultadoBusqueda(ObservadorResultadoBusqueda observador);

    /**
     * Elimina un observador ya registrado en la lista para que deje de recibir
     * notificaciones de cambios
     * @param observador Observador a eliminar
     */
    public void eliminarObservadorResultadoBusqueda(ObservadorResultadoBusqueda observador);

    /**
     * @return Lista de notas que resultan de la búsqueda realizada
     */
    public List<Nota> getResBusqueda();

    
}
