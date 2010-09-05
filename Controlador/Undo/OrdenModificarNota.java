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
    private ModeloInterface receptor;

    /**
     * Emisor de la orden. Vista de la aplicación
     */
    private VistaInterface emisor;

    /**
     * Controlador de la aplicación. A él se le informa de los cambios
     */
    private ControladorInterface controlador;

    /**
     * Referencia a la nota a modificar
     */
    private Nota notaAModificar;

    /**
     * Campos de la nota que serán modificados
     */
    private CamposNota camposModificados;

    /**
     * Campos de la nota antes del cambio, por si hubiera que deshacer.
     */
    private CamposNota camposSinModificar;


    /* - Métodos ------------------------------------------------------*/

    public OrdenModificarNota(ModeloInterface aReceptor, VistaInterface aEmisor,
            ControladorInterface aControlador, Nota aNotaAModificar,
            CamposNota aCamposModificados){
        receptor=aReceptor;
        emisor=aEmisor;
        controlador=aControlador;
        notaAModificar=aNotaAModificar;
        camposModificados=aCamposModificados;
        camposSinModificar= (CamposNota)aNotaAModificar.getCamposNota().clone();
    }

    /**
     * Ejecuta la orden de modificar la nota. Cambia el valor de los campos originales
     * por los proporcionados por la vista <p>
     *
     * Una vez hecho se añade a la pila de órdenes
     */
    public void ejecutar(){
        receptor.ModificarNota(camposModificados, notaAModificar);
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
        receptor.ModificarNota(camposSinModificar, notaAModificar);
        controlador.busquedaSolicitada();
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
        receptor.ModificarNota(camposModificados, notaAModificar);
        controlador.busquedaSolicitada();
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
