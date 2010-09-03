/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Modelo.CamposNota;

/**
 *
 * @author Javier Rascón Mesa
 */
public interface VistaInterface {

    /* Metodos */

    /**
     * Método para mostrar la interfaz del usuario
     */
    public void mostrarGUI();

    /**
     * Método para mostrar el frame para crear una nueva nota
     */
    public void mostrarNuevaNotaDialog();

    /**
     * Método para mostrar el frame para añadir un nuevo destinatario
     */
    public void mostrarNuevoDestinatario();

    /**
     * Método para mostrar el frame para modificar un destinatario
     */
    public void mostrarModificarDestinatarioDialog();

    /**
     * Método para mostrar el frame para eliminar un destinatario
     */
    public void mostrarEliminarDestinatarioDialog();

    /**
     * Método para obtener los valores de la nueva nota
     * @return Objeto con los valores de los campos de la nueva nota
     */
    public CamposNota getCamposNotaNuevaNota();

    /**
     * Método para pedir los criterios de la búsqueda
     * @return Objeto con los criterios para buscar las notas
     */
    public CamposNota getCriteriosBusqueda();

    /**
     * Método para avisar a la vista de que los resultados de la búsqueda han
     * sido actualizados
     */
    public void resultadosBusquedaCambiados();    

    /**
     * Método para obtener los campos de la nota seleccionada
     * @return Objeto con los valores de la nota seleccioanda
     */
    public CamposNota getCamposNotaSeleccionada();

    /**
     * Método para establecer la nota que se muestra en la zona de detalles
     * @param n Nota que se mostrará en la zona de detalles
     */
    public void setNotaDetalles(Modelo.Nota n);


}
