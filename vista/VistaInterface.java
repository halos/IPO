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

    /** Métodos de _critBusq **/

    /**
     * Método para obtener los criterios de búsqueda de las notas
     * @return Criterios de búsqueda de las notas
     */
    public CamposNota getCriteriosBusqueda();

    /** Métodos de _detNota **/

    /**
     * Método para obtener los campos de la nota que se muestra en los detalles
     * @return Campos actuales de la nota
     */
    public CamposNota getCamposNotaDetalles();

    /**
     * Método para añadir un observador al pulsado del botón de marcar como no
     * leída
     * @param al Observador del pulsado del botón de marcar como no leído
     */
    public void addMarcarNoLeidaButtonListener(ActionListener al);

    /**
     * Método para añadir un listener cuando la nota cambie
     * @param al Listener que es notificado al cambiar la nota
     */
    public void addNotaCambiadaListener(ActionListener al);

    /** Métodos de _resBusq **/

    /**
     * Método para refrescar los datos de la tabla
     * @param datos Lista de notas con los datos actualizados
     */
    public void refrescarDatosResBusqueda(List<Nota> datos);

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
