/*
 * CriteriosBusquedaPanel.java
 *
 * Created on 21-ago-2010, 20:45:54
 */

package vista.PanelesPrincipal;

import modelo.CamposNota;
import modelo.NombreCamposNota;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase que genera y gestiona el panel en el que se introducen los criterios de
 * búsqueda de las notas
 * @author Javier Rascón Mesa
 */
public class CriteriosBusquedaPanel extends javax.swing.JPanel {

    /* Atributos */

    /**
     * Calendario para poder obtener el día actual de la semana
     */
    Calendar c;

    /* Métodos */

    /**
     * Constructor
     */
    public CriteriosBusquedaPanel() {
        c = new GregorianCalendar();
        initComponents();
        
    }

    /**
     * Método apra obtener los criterios de búsqueda de la nota
     * @return Campos que definen las búsqueda
     */
    public CamposNota getCriteriosBusqueda(){

        CamposNota criteriosCN = new CamposNota();

        criteriosCN.añadirCampo(NombreCamposNota.DESTINATARIO, _destinatarioBusquedaCB.getSelectedItem());
        criteriosCN.añadirCampo(NombreCamposNota.PRIORIDAD, _prioridadBusquedaCB.getSelectedItem());
        criteriosCN.añadirCampo(NombreCamposNota.FECHA, _fechaBusquedaFTF.getText());
        criteriosCN.añadirCampo(NombreCamposNota.ASUNTO, _textoBusquedaTF.getText());
        criteriosCN.añadirCampo(NombreCamposNota.CUERPO, _textoBusquedaTF.getText());

        return criteriosCN;

    }

    /**
     * Método para añadir listeners que notifiquen el cambio de criterios de
     * búsqueda
     * @param al Listener que será notificado al cambiar algún criterio de
     * buśqueda
     */
    public void addCriteriosBusquedaCambiadosListener(final ActionListener al){
        _textoBusquedaTF.addKeyListener(new KeyListener() {

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
        _fechaBusquedaFTF.addKeyListener(new KeyListener() {

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
        _destinatarioBusquedaCB.addActionListener(al);
        _prioridadBusquedaCB.addActionListener(al);

        al.actionPerformed(null);
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

        _destinatarioLabel = new javax.swing.JLabel();
        _destinatarioBusquedaCB = new javax.swing.JComboBox();
        _prioridadLabel = new javax.swing.JLabel();
        _prioridadBusquedaCB = new javax.swing.JComboBox();
        _textoLabel = new javax.swing.JLabel();
        _textoBusquedaTF = new javax.swing.JTextField();
        _fechaLabel = new javax.swing.JLabel();
        _fechaBusquedaFTF = new javax.swing.JFormattedTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios de búsqueda"));
        setLayout(new java.awt.GridBagLayout());

        _destinatarioLabel.setText("Destinatario"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(_destinatarioLabel, gridBagConstraints);

        _destinatarioBusquedaCB.setModel(new javax.swing.DefaultComboBoxModel(modelo.Destinatario.values()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(_destinatarioBusquedaCB, gridBagConstraints);

        _prioridadLabel.setText("Prioridad"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(_prioridadLabel, gridBagConstraints);

        _prioridadBusquedaCB.setModel(new javax.swing.DefaultComboBoxModel(modelo.Prioridades.values()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(_prioridadBusquedaCB, gridBagConstraints);

        _textoLabel.setText("Texto / Asunto"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(_textoLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(_textoBusquedaTF, gridBagConstraints);

        _fechaLabel.setText("Fecha"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(_fechaLabel, gridBagConstraints);

        _fechaBusquedaFTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        _fechaBusquedaFTF.setText(c.get(Calendar.DAY_OF_MONTH)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR));
        _fechaBusquedaFTF.setPreferredSize(new java.awt.Dimension(90, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(_fechaBusquedaFTF, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox _destinatarioBusquedaCB;
    private javax.swing.JLabel _destinatarioLabel;
    private javax.swing.JFormattedTextField _fechaBusquedaFTF;
    private javax.swing.JLabel _fechaLabel;
    private javax.swing.JComboBox _prioridadBusquedaCB;
    private javax.swing.JLabel _prioridadLabel;
    private javax.swing.JTextField _textoBusquedaTF;
    private javax.swing.JLabel _textoLabel;
    // End of variables declaration//GEN-END:variables

}