
/*
 * BotonesSuperioresPanel.java
 *
 * Created on 21-ago-2010, 20:29:24
 */

package Vista.PanelesPrincipal;

import Vista.Icons;
import javax.swing.ImageIcon;

/**
 * Clase que genera y gestiona el panel que presenta los botones que se encuentran
 * en la parte superior de la pantalla principal
 * @author Javier Rascón Mesa
 */
public class BotonesSuperioresPanel extends javax.swing.JPanel {

    /**
     * Constructor
     */
    public BotonesSuperioresPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _nuevaNotaButton = new javax.swing.JButton();
        _undoButton = new javax.swing.JButton();
        _redoButton = new javax.swing.JButton();
        _nuevoDestButton = new javax.swing.JButton();
        _modDestButton = new javax.swing.JButton();
        _eliminarDestButton = new javax.swing.JButton();

        setBorder(null);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        _nuevaNotaButton.setIcon(new ImageIcon(Icons.getIconNewNote()));
        _nuevaNotaButton.setToolTipText("Nueva nota");
        add(_nuevaNotaButton);

        _undoButton.setIcon(new ImageIcon(Icons.getIconUndo()));
        _undoButton.setToolTipText("Deshacer");
        add(_undoButton);

        _redoButton.setIcon(new ImageIcon(Icons.getIconRedo()));
        _redoButton.setToolTipText("Rehacer");
        add(_redoButton);

        _nuevoDestButton.setIcon(new ImageIcon(Icons.getIconAddDest()));
        _nuevoDestButton.setToolTipText("Nuevo destinatario");
        add(_nuevoDestButton);

        _modDestButton.setIcon(new ImageIcon(Icons.getIconEditDest()));
        _modDestButton.setToolTipText("Modificar destinatario");
        add(_modDestButton);

        _eliminarDestButton.setIcon(new ImageIcon(Icons.getIconDeleteDest()));
        _eliminarDestButton.setToolTipText("Eliminar destinatario");
        add(_eliminarDestButton);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _eliminarDestButton;
    private javax.swing.JButton _modDestButton;
    private javax.swing.JButton _nuevaNotaButton;
    private javax.swing.JButton _nuevoDestButton;
    private javax.swing.JButton _redoButton;
    private javax.swing.JButton _undoButton;
    // End of variables declaration//GEN-END:variables

}
