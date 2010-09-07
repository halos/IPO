/*
 * OrdenMarcarNoLeida.java
 */

package controlador.undo;

import controlador.ControladorInterface;
import javax.swing.undo.AbstractUndoableEdit;
import modelo.ModeloInterface;
import modelo.Nota;
import vista.VistaInterface;

/**
 * Orden que representa la acción de marcar una nota como leida
 * @author Andrés Jesús Ibáñez Expósito
 */
public class OrdenMarcarNoLeida extends AbstractUndoableEdit{
    /* - Atributos ---------------------------------------------------*/

    /**
     * Receptor de la orden. Modelo de la aplicación
     */
    private ModeloInterface receptor;

    /**
     * Emisor de la orden. Vista de la aplicación
     */
    private VistaInterface emisor;

    /**
     * Controlador de la aplicación. Necesario para notificar cambios
     */
    private ControladorInterface controlador;

    /**
     * Nota a marcar como no leida.
     */
    Nota nota;




    /* - Métodos -------------------------------------------------------*/

    /**
     * Constructor de clase. Inicializa los atributos a los valores facilitados
     * @param receptor modelo de la aplicación. Receptor de la orden
     * @param emisor vista de la aplicación. Emisor de la orden
     * @param controlador Controlador de la aplicación
     * @param nota Nota a marcar
     */
    public OrdenMarcarNoLeida(ModeloInterface receptor, VistaInterface emisor,
            ControladorInterface controlador, Nota nota) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.controlador = controlador;
        this.nota = nota;
    }

    /**
     * Ejecuta la orden de marcar como no leida sobre la nota en cuestión
     * <p>
     * Una vez hecho, se añade la orden a la pila de órdenes
     */
    public void ejecutar(){
        receptor.marcarNoLeida(nota);
        PilaDeshacer.addEdit(this);
    }

    /**
     * Deshace la orden. Vuelve a marcar como leida la nota
     * <p>
     * Informa al controlador de los cambios, obligándole a realizar una búsqueda
     */
    @Override
    public void undo(){
        super.undo();
        receptor.marcarLeida(nota);
        controlador.busquedaSolicitada();
    }

    /**
     * Rehace la orden. Vuelve a marcar como no leida la nota
     * <p>
     * Informa al controlador de los cambios, obligándole a realizar una búsqueda
     */
    @Override
    public void redo(){
        super.redo();
        receptor.marcarNoLeida(nota);
        controlador.busquedaSolicitada();
    }

    /**
     * Devuelve el nombre de la orden para su presentación en la pila de órdenes
     * @return Cadena de caracteres. Identificador de la orden
     */
    @Override
    public String getPresentationName(){
        return "Marcar nota como no leida";
    }


}
