
/*
 * DetallesNotaPanel.java
 *
 * Created on 22-ago-2010, 18:03:04
 */

package Vista.PanelesPrincipal;

import Modelo.CamposNota;
import Modelo.Destinatario;
import Modelo.NombreCamposNota;
import Modelo.Prioridades;
import java.awt.event.*;

/**
 * Clase para generar y gestionar el panel que muestra los detalles de una nota
 * @author Javier Rascón Mesa
 */
public class DetallesNotaPanel extends javax.swing.JPanel {

    /*---- Atributos ----*/

    CamposNota _notaMostrada;

    Boolean _editable;

    /*---- Métodos ----*/

    /**
     * Constructor
     */
    public DetallesNotaPanel() {
        initComponents();
        _editable = false;
    }

    /**
     * Método para ver el estado en que se encuentra el <tt>CheckBox</tt> que 
     * indica si una nota es editableCheckBox
     * @return Estado de chequedo del <tt>CheckBox</tt> editableCheckBox
     */
    public boolean getEditableStatus(){
        return _editable;
    }

    /**
     * Método para cambiar el estado de "_editable" de los de talles de la nota
     * @param _editable Estado que se quiere establecer a los campos de la nota
     */
    public void setEditableDetallesNota(boolean editable){

        _editable = editable;

        _destinatarioDetallesCB.setEnabled(_editable);
        _prioridadDetallesCB.setEnabled(_editable);
        _fechaDetallesFTF.setEditable(_editable);
        _textoTA.setEditable(_editable);
        _asuntoTextField.setEditable(_editable);

    }

    /**
     * Método para obtener los campos de la nota
     * @return Campos actuales de la nota
     */
    public CamposNota getCamposNota(){

        return _notaMostrada;

    }

    /**
     * Método para establecer los los campos de la nota
     * @param cn Campos para establecer en la nota que se muestra
     */
    public void setCamposNota(CamposNota cn){

        _editable = false;
        setEditableDetallesNota(_editable);

        _notaMostrada = cn;

        //FECHA
        _fechaDetallesFTF.setText((String) cn.getValueOf(
                NombreCamposNota.FECHA));
        
        //TEXTO
        _textoTA.setText((String) cn.getValueOf(NombreCamposNota.CUERPO));

        //DESTINATARIO
        Destinatario d = (Destinatario) cn.getValueOf(
                NombreCamposNota.DESTINATARIO);

        for(int i=0;i<_destinatarioDetallesCB.getItemCount();i++)
            if(d.equals(_destinatarioDetallesCB.getItemAt(i)))
                _destinatarioDetallesCB.setSelectedIndex(i);

        //PRIORIDAD
        Prioridades p = (Prioridades) cn.getValueOf(NombreCamposNota.PRIORIDAD);

        for (int i = 0; i < _prioridadDetallesCB.getItemCount(); i++)
            if(p.equals(_prioridadDetallesCB.getItemAt(i)))
                _prioridadDetallesCB.setSelectedIndex(i);

        //ASUNTO
        _asuntoTextField.setText((String) cn.getValueOf(
                NombreCamposNota.ASUNTO));

    }

    /**
     * Método para añadir un observador al pulsado del botón de marcar como no
     * leída
     * @param al Observador del pulsado del botón de marcar como no leído
     */
    public void addMarcarNoLeidaButtonListener(ActionListener al){
        _marcarNoLeidaButton.addActionListener(al);
    }

    /**
     * Método para añadir un observador al cambio de estado del checkbox
     * <tt>_editableCheckBox</tt>
     * @param al Observador del cambio de estado del checkbox
     * <tt>_editableCheckBox</tt>
     */
    public void addEditableStateChangedListener(ItemListener il){
        _editableCheckBox.addItemListener(il);
    }

    /**
     * Método para añadir un listener cuando la nota cambie
     * @param al Listener que es notificado al cambiar la nota
     */
    public void addNotaCambiadaListener(final ActionListener al){
        _destinatarioDetallesCB.addActionListener(al);
        _prioridadDetallesCB.addActionListener(al);
        _asuntoTextField.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                al.actionPerformed(null);
            }

            public void keyPressed(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void keyReleased(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        _fechaDetallesFTF.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                al.actionPerformed(null);
            }

            public void keyPressed(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void keyReleased(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        _textoTA.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                al.actionPerformed(null);
            }

            public void keyPressed(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void keyReleased(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        _editableCheckBox = new javax.swing.JCheckBox();
        _destinatarioDetallesCB = new javax.swing.JComboBox();
        _prioridadDetallesCB = new javax.swing.JComboBox();
        _fechaDetallesLabel = new javax.swing.JLabel();
        _destinatarioDetallesLabel = new javax.swing.JLabel();
        _prioridadDetallesLabel = new javax.swing.JLabel();
        _marcarNoLeidaButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        _textoTA = new javax.swing.JTextArea();
        _fechaDetallesFTF = new javax.swing.JFormattedTextField();
        _asuntoLabel = new javax.swing.JLabel();
        _asuntoTextField = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles nota"));
        setLayout(new java.awt.GridBagLayout());

        _editableCheckBox.setText("Editable"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 5, 5);
        add(_editableCheckBox, gridBagConstraints);

        _destinatarioDetallesCB.setModel(new javax.swing.DefaultComboBoxModel(Modelo.Destinatario.values()));
        _destinatarioDetallesCB.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(_destinatarioDetallesCB, gridBagConstraints);

        _prioridadDetallesCB.setModel(new javax.swing.DefaultComboBoxModel(Modelo.Prioridades.values()));
        _prioridadDetallesCB.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(_prioridadDetallesCB, gridBagConstraints);

        _fechaDetallesLabel.setText("Fecha"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(_fechaDetallesLabel, gridBagConstraints);

        _destinatarioDetallesLabel.setText("Destinatario"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(_destinatarioDetallesLabel, gridBagConstraints);

        _prioridadDetallesLabel.setText("Prioridad"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(_prioridadDetallesLabel, gridBagConstraints);

        _marcarNoLeidaButton.setText("Marcar no leída"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(_marcarNoLeidaButton, gridBagConstraints);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(162, 77));

        _textoTA.setColumns(20);
        _textoTA.setEditable(false);
        _textoTA.setRows(5);
        _textoTA.setTabSize(4);
        _textoTA.setMinimumSize(new java.awt.Dimension(0, 0));
        _textoTA.setPreferredSize(new java.awt.Dimension(60, 75));
        jScrollPane3.setViewportView(_textoTA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jScrollPane3, gridBagConstraints);

        _fechaDetallesFTF.setEditable(false);
        _fechaDetallesFTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        _fechaDetallesFTF.setToolTipText(""); // NOI18N
        _fechaDetallesFTF.setPreferredSize(new java.awt.Dimension(90, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(_fechaDetallesFTF, gridBagConstraints);

        _asuntoLabel.setText("Asunto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(_asuntoLabel, gridBagConstraints);

        _asuntoTextField.setEditable(false);
        _asuntoTextField.setPreferredSize(new java.awt.Dimension(90, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(_asuntoTextField, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _asuntoLabel;
    private javax.swing.JTextField _asuntoTextField;
    private javax.swing.JComboBox _destinatarioDetallesCB;
    private javax.swing.JLabel _destinatarioDetallesLabel;
    private javax.swing.JCheckBox _editableCheckBox;
    private javax.swing.JFormattedTextField _fechaDetallesFTF;
    private javax.swing.JLabel _fechaDetallesLabel;
    private javax.swing.JButton _marcarNoLeidaButton;
    private javax.swing.JComboBox _prioridadDetallesCB;
    private javax.swing.JLabel _prioridadDetallesLabel;
    private javax.swing.JTextArea _textoTA;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

}
