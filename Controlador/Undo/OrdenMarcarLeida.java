/*
 * OrdenMarcarLeida.java
 */

package Controlador.Undo;

import Controlador.ControladorInterface;
import javax.swing.undo.AbstractUndoableEdit;
import Modelo.ModeloInterface;
import Modelo.Nota;
import Vista.VistaInterface;

/**
 * Orden que representa la acción de marcar una nota como leida
 * @author Andrés Jesús Ibáñez Expósito
 */
public class OrdenMarcarLeida extends AbstractUndoableEdit{
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
     * Nota a marcar como leida.
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
    public OrdenMarcarLeida(ModeloInterface receptor, VistaInterface emisor,
            ControladorInterface controlador, Nota nota) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.controlador = controlador;
        this.nota = nota;
    }

    /**
     * Ejecuta la orden de marcar como leida sobre la nota en cuestión
     * <p>
     * Una vez hecho, se añade la orden a la pila de órdenes
     */
    public void ejecutar(){
        receptor.marcarLeida(nota);
        PilaDeshacer.addEdit(this);
    }

    /**
     * Deshace la orden. Vuelve a marcar como no leida la nota
     * <p>
     * Informa al controlador de los cambios, obligándole a realizar una búsqueda
     */
    @Override
    public void undo(){
        super.undo();
        receptor.marcarNoLeida(nota);
        controlador.busquedaSolicitada();
    }

    /**
     * Rehace la orden. Vuelve a marcar como leida la nota
     * <p>
     * Informa al controlador de los cambios, obligándole a realizar una búsqueda
     */
    @Override
    public void redo(){
        super.redo();
        receptor.marcarLeida(nota);
        controlador.busquedaSolicitada();
    }

    /**
     * Devuelve el nombre de la orden para su presentación en la pila de órdenes
     * @return Cadena de caracteres. Identificador de la orden
     */
    @Override
    public String getPresentationName(){
        return "Marcar nota como leida";
    }


}
