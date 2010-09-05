
package Vista;

import Controlador.ControladorInterface;
import Modelo.CamposNota;
import Modelo.ModeloInterface;
import Modelo.Nota;
import java.awt.event.*;
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

    /*---- Métodos ----*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        new PrincipalFrame().setVisible(true);
//        new EliminarDestinatarioDialog().setVisible(true);
//        new ModificarDestinatarioDialog().setVisible(true);
        new Vista(null, null);

    }

    /**
     * Constructor de ls vista
     * @param modelo Modelo de la aplicación
     * @param controlador Controlador de la aplicación
     */
    public Vista(ModeloInterface modelo, ControladorInterface controlador) {

        _modelo = modelo;
        _controlador = controlador;

        _principalF = new PrincipalFrame();

        _principalF.addNuevaNotaButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                mostrarNuevaNotaDialog();
            }
        });

        //------------Código de prueba-------------------------

        addEditableStateChangedListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                setEditableDetallesNota(!getEditableStatus());
            }
        });

        this.mostrarGUI();
        //-----------------------------------------------------


        

    }

    /**** PrincipalFrame ****/
    //<editor-fold defaultstate="collapsed" desc="métodos">

    /**
     * Método para que la vista muestre su interfaz gráfica
     */
    public void mostrarGUI(){

        _principalF.setLocationRelativeTo(null);
        _principalF.setVisible(true);
    }

    /** Métodos de _botSup **/

    /**
     * Método para añadir un nuevo observador de la pulsación del botón nueva
     * nota para abrir el diálogo correspondiente
     * @param al Observador de la pulsación del botón nueva nota
     */
    public void addNuevaNotaButtonListener(ActionListener al){
        _principalF.addNuevaNotaButtonListener(al);
    }

    /**
     * Método para añadir un nuevo observador de la pulsación del botón deshacer
     * @param al Observador de la pulsación del botón deshacer
     */
    public void addUndoButtonListener(ActionListener al){
        _principalF.addUndoButtonListener(al);
    }

    /**
     * Método para añadir un nuevo observador de la pulsación del botón rehacer
     * @param al Observador de la pulsación del botón rehacer
     */
    public void addRedoButtonListener(ActionListener al){
        _principalF.addRedoButtonListener(al);
    }

    /** Métodos de _critBusq **/

    /**
     * Método para obtener los criterios de búsqueda de las notas
     * @return Criterios de búsqueda de las notas
     */
    public CamposNota getCriteriosBusqueda(){

        return _principalF.getCriteriosBusqueda();

    }

    /**
     * Método para añadir listeners que notifiquen el cambio de criterios de
     * búsqueda
     * @param al Listener que será notificado al cambiar algún criterio de
     * buśqueda
     */
    public void addCriteriosBusquedaCambiadosListener(ActionListener al){
        _principalF.addCriteriosBusquedaCambiadosListener(al);
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

    /**
     * Método para añadir un observador al pulsado del botón de marcar como no
     * leída
     * @param al Observador del pulsado del botón de marcar como no leído
     */
    public void addMarcarNoLeidaButtonListener(ActionListener al){
        _principalF.addMarcarNoLeidaButtonListener(al);
    }

    /**
     * Método para añadir un observador al cambio de estado del checkbox
     * <tt>_editableCheckBox</tt>
     * @param al Observador del cambio de estado del checkbox
     * <tt>_editableCheckBox</tt>
     */
    public void addEditableStateChangedListener(ItemListener il){
        _principalF.addEditableStateChangedListener(il);
    }

    /**
     * Método para añadir un listener cuando la nota vista en los detalles
     * cambie
     * @param al Listener que es notificado al cambiar la nota
     */
    public void addNotaCambiadaListener(ActionListener al){
        _principalF.addNotaCambiadaListener(al);
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

    /**
     * Método para añadir un observador que sea notificado de que se ha hecho
     * click sobre la tabla
     * @param ml obsevador que será notificado de que se ha hecho click sobre la
     * tabla
     */
    public void addClickTablaListener(MouseListener ml){
        _principalF.addClickTablaListener(ml);
    }

    //</editor-fold>

    /**** NuevaNotaDialog ****/
    //<editor-fold defaultstate="collapsed" desc="métodos">

    /**
     * Método para mostrar el frame para crear una nueva nota
     */
    public void mostrarNuevaNotaDialog(){

        _nuevaNotaD = new NuevaNotaDialog();
        _nuevaNotaD.setLocationRelativeTo(null);
        _nuevaNotaD.setVisible(true);

        //listeners
        _nuevaNotaD.addCloseListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                _nuevaNotaD.dispose();
            }
        });

        _nuevaNotaD.addNuevaNotaListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                _nuevaNotaD.setVisible(false);
            }
        });

    }

    /**
     * Método para obtener los valores de la nueva nota
     * @return Objeto con los valores de los campos de la nueva nota
     */
    public CamposNota getCamposNotaNuevaNota(){

        return _nuevaNotaD.getCamposNota();

    }

    /**
     * Método para añadir un nuevo observador al pulsado del botón de añadir una
     * nueva nota
     * @param al Listener al que avisar al pulsar el botón de nueva nota
     */
    public void addNuevaNotaListener(ActionListener al){
        _nuevaNotaD.addNuevaNotaListener(al);
    }

    // </editor-fold>

}
