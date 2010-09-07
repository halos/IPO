/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import modelo.CamposNota;
import modelo.Nota;
import java.awt.event.*;
import java.util.List;

/**
 *
 * @author Javier Rascón Mesa
 */
public interface VistaInterface {

    /* Metodos */

     /**** Principal ****/
    //<editor-fold defaultstate="collapsed" desc="métodos">

    /**
     * Método para que la vista muestre su interfaz gráfica
     */
    public void mostrarGUI();

    /** Métodos de _botSup **/

    /**
     * Método para añadir un nuevo observador de la pulsación del botón nueva
     * nota
     * @param al Observador de la pulsación del botón nueva nota
     */
    public void addNuevaNotaButtonListener(ActionListener al);

    /**
     * Método para añadir un nuevo observador de la pulsación del botón deshacer
     * @param al Observador de la pulsación del botón deshacer
     */
    public void addUndoButtonListener(ActionListener al);

    /**
     * Método para añadir un nuevo observador de la pulsación del botón rehacer
     * @param al Observador de la pulsación del botón rehacer
     */
    public void addRedoButtonListener(ActionListener al);

    /** Métodos de _critBusq **/

    /**
     * Método para obtener los criterios de búsqueda de las notas
     * @return Criterios de búsqueda de las notas
     */
    public CamposNota getCriteriosBusqueda();

    /**
     * Método para añadir listeners que notifiquen el cambio de criterios de
     * búsqueda
     * @param al Listener que será notificado al cambiar algún criterio de
     * buśqueda
     */
    public void addCriteriosBusquedaCambiadosListener(ActionListener al);

    /** Métodos de _detNota **/

    /**
     * Método para ver el estado en que se encuentra el <tt>CheckBox</tt> que
     * indica si una nota es editableCheckBox
     * @return Estado de chequedo del <tt>CheckBox</tt> editableCheckBox
     */
    public boolean getEditableStatus();

    /**
     * Método para cambiar el estado de "editable" de los de talles de la nota
     * @param editable Estado que se quiere establecer a los campos de la nota
     */
    public void setEditableDetallesNota(boolean editable);

    /**
     * Método para obtener los campos de la nota que se muestra en los detalles
     * @return Campos actuales de la nota
     */
    public CamposNota getCamposNotaDetalles();

     /**
     * Método para establecer los los campos de la nota
     * @param cn Campos para establecer en la nota que se muestra
     */
    public void setCamposNotaDetalles(CamposNota cn);

    /**
     * Método para añadir un observador al pulsado del botón de marcar como no
     * leída
     * @param al Observador del pulsado del botón de marcar como no leído
     */
    public void addMarcarNoLeidaButtonListener(ActionListener al);

    /**
     * Método para añadir un observador al cambio de estado del checkbox
     * <tt>_editableCheckBox</tt>
     * @param al Observador del cambio de estado del checkbox
     * <tt>_editableCheckBox</tt>
     */
    public void addEditableStateChangedListener(ItemListener il);

    /**
     * Método para añadir un listener cuando la nota cambie
     * @param al Listener que es notificado al cambiar la nota
     */
    public void addNotaCambiadaListener(ActionListener al);

    /** Métodos de _resBusq **/

    /**
     * Método para obtener la nota de la fila seleccionada
     * @return Nota de la fila seleccionada
     */
    public Nota getSelectedNota();

    /**
     * Método para refrescar los datos de la tabla
     * @param datos Lista de notas con los datos actualizados
     */
    public void refrescarDatosResBusqueda(List<Nota> datos);

    /**
     * Método para añadir un observador que sea notificado de que se ha hecho
     * click sobre la tabla
     * @param ml obsevador que será notificado de que se ha hecho click sobre la
     * tabla
     */
    public void addClickTablaListener(MouseListener ml);

    //</editor-fold>

    /**** Nueva Nota ****/
    //<editor-fold defaultstate="collapsed" desc="métodos">

    /**
     * Método para mostrar el frame para crear una nueva nota
     */
    public void mostrarNuevaNotaDialog();

    /**
     * Método para obtener los valores de la nueva nota
     * @return Objeto con los valores de los campos de la nueva nota
     */
    public CamposNota getCamposNotaNuevaNota();

    /**
     * Método para añadir un nuevo observador al pulsado del botón de añadir una
     * nueva nota
     * @param al Listener al que avisar al pulsar el botón de nueva nota
     */
    public void addNuevaNotaListener(ActionListener al);

    // </editor-fold>



}
