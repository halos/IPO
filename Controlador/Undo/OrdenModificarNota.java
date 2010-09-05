/*
 * OrdenModificarNota.java
 */

package Controlador.Undo;

import Controlador.ControladorInterface;
import javax.swing.undo.AbstractUndoableEdit;
import Modelo.CamposNota;
import Modelo.ModeloInterface;
import Modelo.Nota;
import Vista.VistaInterface;

/**
 * Orden que representa la acción de modificar los campos de una nota
 * @author Andrés Jesús Ibáñez Expósito
 */
public class OrdenModificarNota extends AbstractUndoableEdit {
    /* - Atributos --------------------------------------------------------*/

    /**
     * Receptor de la orden. Modelo de la aplicación
     */
    private ModeloInterface _receptor;

    /**
     * Emisor de la orden. Vista de la aplicación
     */
    private VistaInterface _emisor;

    /**
     * Controlador de la aplicación. A él se le informa de los cambios
     */
    private ControladorInterface _controlador;

    /**
     * Referencia a la nota a modificar
     */
    private Nota _notaAModificar;

    /**
     * Campos de la nota que serán modificados
     */
    private CamposNota _camposModificados;

    /**
     * Campos de la nota antes del cambio, por si hubiera que deshacer.
     */
    private CamposNota _camposSinModificar;


    /* - Métodos ------------------------------------------------------*/

    public OrdenModificarNota(ModeloInterface aReceptor, VistaInterface aEmisor,
            ControladorInterface aControlador, Nota aNotaAModificar,
            CamposNota aCamposModificados){
        _receptor=aReceptor;
        _emisor=aEmisor;
        _controlador=aControlador;
        _notaAModificar=aNotaAModificar;
        _camposModificados=aCamposModificados;
        _camposSinModificar= (CamposNota)aNotaAModificar.getCamposNota().clone();
    }

    /**
     * Ejecuta la orden de modificar la nota. Cambia el valor de los campos originales
     * por los proporcionados por la vista <p>
     *
     * Una vez hecho se añade a la pila de órdenes
     */
    public void ejecutar(){
        _receptor.ModificarNota(_camposModificados, _notaAModificar);
        PilaDeshacer.addEdit(this);
    }

    /**
     * Deshace la orden. Modifica la nota volviendo a darle el valor de los campos
     * antiguos<p>
     *
     * El controlador después realiza una nueva búsqueda para actualizarse
     */
    @Override
    public void undo(){
        super.undo();
        _receptor.ModificarNota(_camposSinModificar, _notaAModificar);
        _controlador.busquedaSolicitada();
    }

    /**
     * Rehace la orden. Vuelve a modificar la nota con los datos proporcionados
     * por la vista <p>
     *
     * El controlador después realiza una nueva búsqueda para actualizarse
     */
    @Override
    public void redo(){
        super.redo();
        _receptor.ModificarNota(_camposModificados, _notaAModificar);
        _controlador.busquedaSolicitada();
    }

    /**
     * Devuelve el nombre de la orden para su presentación en la pila de órdenes
     * @return Cadena de caracteres. Identificador de la orden
     */
    @Override
    public String getPresentationName(){
        return "Modificar nota";
    }

}
