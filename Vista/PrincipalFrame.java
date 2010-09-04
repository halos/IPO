
/*
 * PrincipalFrame.java
 *
 * Created on 17-ago-2010, 12:08:23
 */

package Vista;

import Modelo.CamposNota;
import Modelo.Nota;
import Vista.PanelesPrincipal.*;
import java.awt.event.*;
import java.util.List;

/**
 *
 * @author halos
 */
public class PrincipalFrame extends javax.swing.JFrame {

    /*---- Atributos ----*/

    private BotonesSuperioresPanel _botSup;
    private CriteriosBusquedaPanel _critBusq;
    private DetallesNotaPanel _detNota;
    private ResultadosBusquedaPanel _resBusq;

    /*---- Métodos ----*/

    /**
     * Constructor
     */
    public PrincipalFrame() {

        initComponents();

        _botSup = (BotonesSuperioresPanel) botSupPanel;
        _critBusq = (CriteriosBusquedaPanel) critBusqPanel;
        _detNota = (DetallesNotaPanel) detNotaPanel;
        _resBusq = (ResultadosBusquedaPanel) resBusqPanel;
    }

    /** Métodos de _botSup **/
    //<editor-fold defaultstate="collapsed" desc="métodos">

    /**
     * Método para añadir un nuevo observador de la pulsación del botón nueva
     * nota
     * @param al Observador de la pulsación del botón nueva nota
     */
    public void addNuevaNotaButtonListener(ActionListener al){
        _botSup.addNuevaNotaButtonListener(al);
    }

    /**
     * Método para añadir un nuevo observador de la pulsación del botón deshacer
     * @param al Observador de la pulsación del botón deshacer
     */
    public void addUndoButtonListener(ActionListener al){
        _botSup.addUndoButtonListener(al);
    }

    /**
     * Método para añadir un nuevo observador de la pulsación del botón rehacer
     * @param al Observador de la pulsación del botón rehacer
     */
    public void addRedoButtonListener(ActionListener al){
        _botSup.addRedoButtonListener(al);
    }

    /**
     * Método para añadir un nuevo observador de la pulsación del botón nuevo
     * destinatario
     * @param al Observador de la pulsación del botón nuevo destinatario
     */
    public void addNuevoDestinatarioButtonListener(ActionListener al){
        _botSup.addNuevoDestinatarioButtonListener(al);
    }

    /**
     * Método para añadir un nuevo observador de la pulsación del botón
     * modificar destinatario
     * @param al Observador de la pulsación del botón modificar destinatario
     */
    public void addModificarDestinatarioButtonListener(ActionListener al){
       _botSup.addModificarDestinatarioButtonListener(al);
    }

    /**
     * Método para añadir un nuevo observador de la pulsación del botón eliminar
     * destinatario
     * @param al Observador de la pulsación del botón eliminar destinatario
     */
    public void addEliminarDestinatarioButtonListener(ActionListener al){
        _botSup.addEliminarDestinatarioButtonListener(al);
    }

    //</editor-fold>

    /** Métodos de _critBusq **/
    //<editor-fold defaultstate="collapsed" desc="métodos">

    /**
     * Método para obtener los criterios de búsqueda de las notas
     * @return Criterios de búsqueda de las notas
     */
    public CamposNota getCriteriosBusqueda(){

        return _critBusq.getCriteriosBusqueda();

    }

    /**
     * Método para añadir listeners que notifiquen el cambio de criterios de
     * búsqueda
     * @param al Listener que será notificado al cambiar algún criterio de
     * buśqueda
     */
    public void addCriteriosBusquedaCambiadosListener(ActionListener al){
        _critBusq.addCriteriosBusquedaCambiadosListener(al);
    }

    //</editor-fold>

    /** Métodos de _detNota **/
    //<editor-fold defaultstate="collapsed" desc="métodos">
    
    /**
     * Método para ver el estado en que se encuentra el <tt>CheckBox</tt> que
     * indica si una nota es editableCheckBox
     * @return Estado de chequedo del <tt>CheckBox</tt> editableCheckBox
     */
    public boolean getEditableStatus(){
        return _detNota.getEditableStatus();
    }

    /**
     * Método para cambiar el estado de "editable" de los de talles de la nota
     * @param editable Estado que se quiere establecer a los campos de la nota
     */
    public void setEditableDetallesNota(boolean editable){
        _detNota.setEditableDetallesNota(editable);
    }

    /**
     * Método para obtener los campos de la nota
     * @return Campos actuales de la nota
     */
    public CamposNota getCamposNota(){
        return _detNota.getCamposNota();
    }

    /**
     * Método para establecer los los campos de la nota
     * @param cn Campos para establecer en la nota que se muestra
     */
    public void setCamposNota(CamposNota cn){
        _detNota.setCamposNota(cn);
    }

    /**
     * Método para añadir un observador al pulsado del botón de marcar como no
     * leída
     * @param al Observador del pulsado del botón de marcar como no leído
     */
    public void addMarcarNoLeidaButtonListener(ActionListener al){
        _detNota.addMarcarNoLeidaButtonListener(al);
    }

    /**
     * Método para añadir un observador al cambio de estado del checkbox
     * <tt>_editableCheckBox</tt>
     * @param al Observador del cambio de estado del checkbox
     * <tt>_editableCheckBox</tt>
     */
    public void addEditableStateChangedListener(ItemListener il){
        _detNota.addEditableStateChangedListener(il);
    }

    /**
     * Método para añadir un listener cuando la nota cambie
     * @param al Listener que es notificado al cambiar la nota
     */
    public void addNotaCambiadaListener(ActionListener al){
        _detNota.addNotaCambiadaListener(al);
    }

    //</editor-fold>

    /** Métodos de _resBusq **/
    //<editor-fold defaultstate="collapsed" desc="métodos">

    /**
     * Método para obtener la nota de la fila seleccionada
     * @return Nota de la fila seleccionada
     */
    public Nota getSelectedNota(){
        return _resBusq.getSelectedNota();
    }

    /**
     * Método para refrescar los datos de la tabla
     * @param datos Lista de notas con los datos actualizados
     */
    public void refrescarDatosResBusqueda(List<Nota> datos){
        _resBusq.refrescarDatos(datos);
    }

    /**
     * Método para añadir un observador que sea notificado de que se ha hecho
     * click sobre la tabla
     * @param ml obsevador que será notificado de que se ha hecho click sobre la
     * tabla
     */
    public void addClickTablaListener(MouseListener ml){
        _resBusq.addClickTablaListener(ml);
    }

    //</editor-fold>


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        botSupPanel = new javax.swing.JPanel();
        critBusqPanel = new javax.swing.JPanel();
        resBusqPanel = new javax.swing.JPanel();
        detNotaPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NotaFUA!"); // NOI18N
        setMinimumSize(new java.awt.Dimension(544, 131));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        botSupPanel.setBorder(null);
        botSupPanel.setLayout(null);
        botSupPanel = new BotonesSuperioresPanel();
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(botSupPanel, gridBagConstraints);

        critBusqPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        critBusqPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        critBusqPanel.setLayout(null);
        critBusqPanel = new CriteriosBusquedaPanel();
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(critBusqPanel, gridBagConstraints);

        resBusqPanel.setBorder(null);
        resBusqPanel.setLayout(null);
        resBusqPanel = new ResultadosBusquedaPanel();
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(resBusqPanel, gridBagConstraints);

        detNotaPanel.setBorder(null);
        detNotaPanel.setLayout(null);
        detNotaPanel = new DetallesNotaPanel();
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(detNotaPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botSupPanel;
    private javax.swing.JPanel critBusqPanel;
    private javax.swing.JPanel detNotaPanel;
    private javax.swing.JPanel resBusqPanel;
    // End of variables declaration//GEN-END:variables

}
