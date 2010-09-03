
package Vista;

import Controlador.ControladorInterface;
import Modelo.CamposNota;
import Modelo.ModeloInterface;
import Modelo.Nota;
import java.util.List;

/**
 * 
 * @author Javier Rascón Mesa
 */
public class Vista implements VistaInterface{

    /*---- Atributos ----*/

    ModeloInterface _modelo;
    ControladorInterface _controlador;

    PrincipalFrame _principalF;
    NuevaNotaDialog _nuevaNotaD;
    NuevoDestinatarioDialog _nuevoDestinatarioD;
    ModificarDestinatarioDialog _modificarDestinatarioD;
    EliminarDestinatarioDialog _eliminarDestinatarioD;

    /*---- Métodos ----*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        new PrincipalFrame().setVisible(true);
        new EliminarDestinatarioDialog().setVisible(true);
//        new ModificarDestinatarioDialog().setVisible(true);

    }

    /**
     * Constructor de ls vista
     * @param modelo Modelo de la aplicación
     * @param controlador Controlador de la aplicación
     */
    public Vista(ModeloInterface modelo, ControladorInterface controlador) {

        _modelo = modelo;
        _controlador = controlador;
    }

    /**** PrincipalFrame ****/
    //<editor-fold defaultstate="collapsed" desc="métodos">

    /**
     * Método para que la vista muestre su interfaz gráfica
     */
    public void mostrarGUI(){
        _principalF = new PrincipalFrame();
        _principalF.setVisible(true);
    }

    /** Métodos de _botSup **/



    /** Métodos de _critBusq **/

    /**
     * Método para obtener los criterios de búsqueda de las notas
     * @return Criterios de búsqueda de las notas
     */
    public CamposNota getCriteriosBusqueda(){

        return _principalF.getCriteriosBusqueda();

    }

    /** Métodos de _detNota **/

    /**
     * Método para ver el estado en que se encuentra el <tt>CheckBox</tt> que
     * indica si una nota es editableCheckBox
     * @return Estado de chequedo del <tt>CheckBox</tt> editableCheckBox
     */
    public boolean getEditableStatus(){
        return _principalF.getEditableStatus();
    }

    /**
     * Método para cambiar el estado de "editable" de los de talles de la nota
     * @param editable Estado que se quiere establecer a los campos de la nota
     */
    public void setEditableDetallesNota(boolean editable){
        _principalF.setEditableDetallesNota(editable);
    }

    /**
     * Método para obtener los campos de la nota que se muestra en los detalles
     * @return Campos actuales de la nota
     */
    public CamposNota getCamposNotaDetalles(){
        return _principalF.getCamposNota();
    }

     /**
     * Método para establecer los los campos de la nota
     * @param cn Campos para establecer en la nota que se muestra
     */
    public void setCamposNotaDetalles(CamposNota cn){
        _principalF.setCamposNota(cn);
    }

    /** Métodos de _resBusq **/

    /**
     * Método para obtener la nota de la fila seleccionada
     * @return Nota de la fila seleccionada
     */
    public Nota getSelectedNota(){
        return _principalF.getSelectedNota();
    }

    /**
     * Método para refrescar los datos de la tabla
     * @param datos Lista de notas con los datos actualizados
     */
    public void refrescarDatosResBusqueda(List<Nota> datos){
        _principalF.refrescarDatosResBusqueda(datos);
    }
    //</editor-fold>

    /**** NuevaNotaDialog ****/
    //<editor-fold defaultstate="collapsed" desc="métodos">

    /**
     * Método para mostrar el frame para crear una nueva nota
     */
    public void mostrarNuevaNotaDialog(){

        _nuevaNotaD = new NuevaNotaDialog();
        _nuevaNotaD.setVisible(true);

    }

    /**
     * Método para obtener los valores de la nueva nota
     * @return Objeto con los valores de los campos de la nueva nota
     */
    public CamposNota getCamposNotaNuevaNota(){

        return _nuevaNotaD.getCamposNota();

    }
    // </editor-fold>

    /**** NuevoDestinatarioDialog ****/
    //<editor-fold defaultstate="collapsed" desc="métodos">

    /**
     * Método para mostrar el frame para añadir un nuevo destinatario
     */
    public void mostrarNuevoDestinatario(){

        _nuevoDestinatarioD = new NuevoDestinatarioDialog();
        _nuevoDestinatarioD.setVisible(true);

    }
    //</editor-fold>

    /**** ModificarDestinatarioDialog ****/
    //<editor-fold defaultstate="collapsed" desc="métodos">

    /**
     * Método para mostrar el frame para modificar un destinatario
     */
    public void mostrarModificarDestinatarioDialog(){

        _modificarDestinatarioD = new ModificarDestinatarioDialog();
        _modificarDestinatarioD.setVisible(true);

    }
    //</editor-fold>

    /**** EliminarDestinatarioDialog ****/
    //<editor-fold defaultstate="collapsed" desc="métodos">

    /**
     * Método para mostrar el frame para eliminar un destinatario
     */
    public void mostrarEliminarDestinatarioDialog(){

        _eliminarDestinatarioD = new EliminarDestinatarioDialog();
        _eliminarDestinatarioD.setVisible(true);

    }

    //</editor-fold>

    public void resultadosBusquedaCambiados() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CamposNota getCamposNotaSeleccionada() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setNotaDetalles(Nota n) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

}
