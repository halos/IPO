/*
 * OrdenNuevaNota.java
 */

package controlador.undo;

import controlador.ControladorInterface;
import javax.swing.undo.AbstractUndoableEdit;
import modelo.CamposNota;
import modelo.ModeloInterface;
import modelo.Nota;

/**
 * Orden que representa la accíon de crear una nueva nota
 * @author Andrés Jesús Ibáñez Expósito
 */
public class OrdenNuevaNota extends AbstractUndoableEdit {

    /* - Atributos ------------------------------------------------------*/

    /**
     * receptor de la orden. Modelo de la aplicación
     */
    private ModeloInterface receptor;

    /**
     * Controlador de la aplicación. Recibe notificación de los cambios
     */
    private ControladorInterface controlador;

    /**
     * Referencia a la nota creada. Se guarda por si fuera necesario rehacer
     */
    private Nota notaCreada;

    /* - Métodos ---------------------------------------------------------*/

    /**
     * Constructor de la clase. Inicializa los atributos con los valores pasados
     * por parámetro
     * @param aReceptor Modelo de la aplicación. Receptor de la orden
     * @param aEmisor Vista de la aplicación. Emisor de la orden
     * @param aControlador Controlador de la aplicación
     * @param cNuevaNota Campos de la nota que será creada
     */
    public OrdenNuevaNota (ModeloInterface aReceptor,
            ControladorInterface aControlador, CamposNota cNuevaNota){
        receptor=aReceptor;
        notaCreada=new Nota(cNuevaNota);
        controlador= aControlador;
    }

    /**
     * Ejecuta la orden de crear una nota. Se incluye la nota creada en el
     * constructor al receptor (modelo)
     * <p>
     * Una vez añadida, añade la orden a la pila de órdenes
     */
    public void ejecutar(){
        receptor.nuevaNota(notaCreada);
        PilaDeshacer.addEdit(this);
    }

    /**
     * Deshace la orden. Elimina la última nota añadida al modelo <p>
     *
     * Se informa al controlador de los cambios para que actualice la lista de
     * búsqueda
     */
    @Override
    public void undo(){
        super.undo();
        receptor.eliminarUltimaNota();
        controlador.busquedaSolicitada();
    }

    /**
     * Rehace la orden previamente deshecha. Vuelve a añadir la nota al modelo<p>
     *
     * Se informa al controlador de los cambios para que actualice la lista de
     * búsqueda
     */
    @Override
    public void redo(){
        super.redo();
        receptor.nuevaNota(notaCreada);
        controlador.busquedaSolicitada();
    }

    /**
     * Devuelve el nombre de la orden para su presentación en la pila de
     * órdenes.
     * @return Cadena de caracteres. Identificador de la orden
     */
    @Override
    public String getPresentationName(){
        return "Nueva nota";
    }
}
