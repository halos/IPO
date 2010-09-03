
/*
 * NuevoDestinatarioDialog.java
 *
 * Created on 19-ago-2010, 12:08:18
 */

package Vista;

import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Clase que se encarga de generar y gestionar el diálogo para añadir nuevos
 * destinatarios
 * @author Javier Rascón Mesa
 */
public class NuevoDestinatarioDialog extends javax.swing.JDialog {

    /*---- Atributos ----*/

    /**
     * Lista con los observadores para el cerrado del diálogo
     */
    LinkedList<ActionListener> _llClose;

    /*---- Métodos ----*/

    /**
     * Constructor
     */
    public NuevoDestinatarioDialog() {
        initComponents();
    }

    /**
     * Método para obtener el nombre del nuevo destinatario
     * @return Cadena con el nombre del nuevo destinatario
     */
    public String getNombreNuevoDestinatario(){
        return _nombreNueDestTF.getText();
    }

    /**
     * Método para añadir el listener para el cerrado del diálogo
     * @param al Listener al que avisar al cerrar el diálogo
     */
    public void addCloseListener(ActionListener al){
        _llClose.add(al);
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

        _aceptarButton = new javax.swing.JButton();
        _cancelarButton = new javax.swing.JButton();
        _nombreNueDestLabel = new javax.swing.JLabel();
        _nombreNueDestTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo destinatario");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        _aceptarButton.setText("Aceptar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 16, 5);
        getContentPane().add(_aceptarButton, gridBagConstraints);

        _cancelarButton.setText("Cancelar");
        _cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _cancelarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 16, 5);
        getContentPane().add(_cancelarButton, gridBagConstraints);

        _nombreNueDestLabel.setText("Nombre destinatario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(_nombreNueDestLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 32);
        getContentPane().add(_nombreNueDestTF, gridBagConstraints);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-475)/2, (screenSize.height-188)/2, 475, 188);
    }// </editor-fold>//GEN-END:initComponents

    private void _cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__cancelarButtonActionPerformed
        for(ActionListener al: _llClose){
            al.actionPerformed(evt);
        }
    }//GEN-LAST:event__cancelarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _aceptarButton;
    private javax.swing.JButton _cancelarButton;
    private javax.swing.JLabel _nombreNueDestLabel;
    private javax.swing.JTextField _nombreNueDestTF;
    // End of variables declaration//GEN-END:variables

}
