
/*
 * NuevaNotaDialog.java
 *
 * Created on 19-ago-2010, 11:51:10
 */

package Vista;

import Modelo.CamposNota;

/**
 * clase que se encarga de generar y gestionar el diálogo para crear una nueva
 * nota
 * @author Javier Rascón Mesa
 */
public class NuevaNotaDialog extends javax.swing.JDialog {

    /* Atributos */



    /* Métodos */

    /**
     * Constructor
     */
    public NuevaNotaDialog() {
        initComponents();
    }

    /**
     * Método para obtener los campos de la nota
     * @return Campos de la nota actualizados
     */
    public CamposNota getCamposNota(){

        CamposNota cn = new CamposNota();

        return cn;

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

        _destLabel = new javax.swing.JLabel();
        _prioridadLabel = new javax.swing.JLabel();
        _asuntoLabel = new javax.swing.JLabel();
        _destinatarioCB = new javax.swing.JComboBox();
        _prioridadCB = new javax.swing.JComboBox();
        _asuntoTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        _textoNotaTA = new javax.swing.JTextArea();
        _aceptarButton = new javax.swing.JButton();
        _cancelarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva nota");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        _destLabel.setText("Destinatario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(_destLabel, gridBagConstraints);

        _prioridadLabel.setText("Prioridad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(_prioridadLabel, gridBagConstraints);

        _asuntoLabel.setText("Asunto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(_asuntoLabel, gridBagConstraints);

        _destinatarioCB.setModel(new javax.swing.DefaultComboBoxModel(Modelo.Destinastarios.values()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(_destinatarioCB, gridBagConstraints);

        _prioridadCB.setModel(new javax.swing.DefaultComboBoxModel(Modelo.Prioridades.values()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(_prioridadCB, gridBagConstraints);

        _asuntoTF.setMinimumSize(new java.awt.Dimension(100, 18));
        _asuntoTF.setPreferredSize(new java.awt.Dimension(100, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(_asuntoTF, gridBagConstraints);

        _textoNotaTA.setColumns(20);
        _textoNotaTA.setRows(5);
        jScrollPane1.setViewportView(_textoNotaTA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        _aceptarButton.setText("Aceptar");
        _aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _aceptarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 9, 5);
        getContentPane().add(_aceptarButton, gridBagConstraints);

        _cancelarButton.setText("Cancelar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 9, 5);
        getContentPane().add(_cancelarButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__aceptarButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event__aceptarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _aceptarButton;
    private javax.swing.JLabel _asuntoLabel;
    private javax.swing.JTextField _asuntoTF;
    private javax.swing.JButton _cancelarButton;
    private javax.swing.JLabel _destLabel;
    private javax.swing.JComboBox _destinatarioCB;
    private javax.swing.JComboBox _prioridadCB;
    private javax.swing.JLabel _prioridadLabel;
    private javax.swing.JTextArea _textoNotaTA;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
