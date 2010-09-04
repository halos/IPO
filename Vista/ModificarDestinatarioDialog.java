
/*
 * ModificarDestinatarioDialog.java
 *
 * Created on 19-ago-2010, 12:19:42
 */

package Vista;

import Modelo.Destinastarios;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.LinkedList;

/**
 * Clase qeu se encarga de generar y gestionar el diálogo para modificar los
 * destinatarios de las notas
 * @author Javier Rascón Mesa
 */
public class ModificarDestinatarioDialog extends javax.swing.JDialog {

    /* Atributos */

    Destinastarios[] _dests;

    /* Métodos */

    /**
     * Constructor
     */
    public ModificarDestinatarioDialog() {

        _dests = Destinastarios.values();

        initComponents();
    }

    public Destinastarios getSelectedDestinatario(){

        return _dests[_destCB.getSelectedIndex()];

    }

    /***
     * Método para obtener el nuevo nombre del destinatario
     * @return <tt>String</tt> con el nombre del destinatario
     */
    public String getNewName(){
        
        return _destCB.getSelectedItem().toString();

    }

    /**
     * Método para añadir el listener para el cerrado del diálogo
     * @param al Listener al que avisar al cerrar el diálogo
     */
    public void addCloseListener(ActionListener al){
        _cancelarButton.addActionListener(al);
    }

    /**
     * Método para añadir el listener para la modificación de un desti natario
     * @param al Listener al que avisar al pulsar el boton de modificar el
     * destinatario
     */
    public void addModDestinatarioListener(ActionListener al){
        _aceptarButton.addActionListener(al);
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
        _destCB = new javax.swing.JComboBox();
        _aceptarButton = new javax.swing.JButton();
        _cancelarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        _destinatarioLabel.setText("Destinatario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(_destinatarioLabel, gridBagConstraints);

        _destCB.setEditable(true);
        _destCB.setModel(new javax.swing.DefaultComboBoxModel(Destinastarios.values()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(_destCB, gridBagConstraints);

        _aceptarButton.setText("Aceptar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 16, 5);
        getContentPane().add(_aceptarButton, gridBagConstraints);

        _cancelarButton.setText("Cancelar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 16, 5);
        getContentPane().add(_cancelarButton, gridBagConstraints);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-375)/2, (screenSize.height-224)/2, 375, 224);
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarDestinatarioDialog dialog =
                        new ModificarDestinatarioDialog();

                dialog.addWindowListener((WindowListener) new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _aceptarButton;
    private javax.swing.JButton _cancelarButton;
    private javax.swing.JComboBox _destCB;
    private javax.swing.JLabel _destinatarioLabel;
    // End of variables declaration//GEN-END:variables

}
