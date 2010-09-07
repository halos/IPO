/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import modelo.CamposNota;

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

    // </editor-fold>



}
