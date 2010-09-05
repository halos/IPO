/*
 * OrdenMarcarNoLeida.java
 */

package Controlador.Undo;

import Controlador.ControladorInterface;
import javax.swing.undo.AbstractUndoableEdit;
import Modelo.ModeloInterface;
import Modelo.Nota;
import Vista.VistaInterface;

/**
 * Orden que representa la acción de marcar una _nota como leida
 * @author Andrés Jesús Ibáñez Expósito
 */
public class OrdenMarcarNoLeida extends AbstractUndoableEdit{
    /* - Atributos ---------------------------------------------------*/

    /**
     * Receptor de la orden. Modelo de la aplicación
     */
    private ModeloInterface _receptor;

    /**
     * Emisor de la orden. Vista de la aplicación
     */
    private VistaInterface _emisor;

    /**
     * Controlador de la aplicación. Necesario para notificar cambios
     */
    private ControladorInterface _controlador;

    /**
     * Nota a marcar como no leida.
     */
    Nota _nota;




    /* - Métodos -------------------------------------------------------*/

    /**
     * Constructor de clase. Inicializa los atributos a los valores facilitados
     * @param receptor modelo de la aplicación. Receptor de la orden
     * @param emisor vista de la aplicación. Emisor de la orden
     * @param controlador Controlador de la aplicación
     * @param _nota Nota a marcar
     */
    public OrdenMarcarNoLeida(ModeloInterface receptor, VistaInterface emisor,
            ControladorInterface controlador, Nota nota) {
        this._receptor = receptor;
        this._emisor = emisor;
        this._controlador = controlador;
        this._nota = nota;
    }

    /**
     * Ejecuta la orden de marcar como no leida sobre la _nota en cuestión
     * <p>
     * Una vez hecho, se añade la orden a la pila de órdenes
     */
    public void ejecutar(){
        _receptor.marcarNoLeida(_nota);
        PilaDeshacer.addEdit(this);
    }

    /**
     * Deshace la orden. Vuelve a marcar como leida la _nota
     * <p>
     * Informa al controlador de los cambios, obligándole a realizar una búsqueda
     */
    @Override
    public void undo(){
        super.undo();
        _receptor.marcarLeida(_nota);
        _controlador.busquedaSolicitada();
    }

    /**
     * Rehace la orden. Vuelve a marcar como no leida la _nota
     * <p>
     * Informa al controlador de los cambios, obligándole a realizar una búsqueda
     */
    @Override
    public void redo(){
        super.redo();
        _receptor.marcarNoLeida(_nota);
        _controlador.busquedaSolicitada();
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
