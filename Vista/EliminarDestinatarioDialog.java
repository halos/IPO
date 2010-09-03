
/*
 * EliminarDestinatarioDialog.java
 *
 * Created on 19-ago-2010, 12:27:31
 */

package Vista;

import Modelo.Destinastarios;
import Vista.TableModels.EliminarDestinatariosTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 * Clase que se encarga de generar y gestionar el diálogo para la eliminación
 * de destinatarios
 * @author Javier Rascón Mesa
 */
public class EliminarDestinatarioDialog extends javax.swing.JDialog {

    /* Atributos */

    /**
     * Atributo para almacenar los datos que se muestran en la tabla
     */
    EliminarDestinatariosTableModel _datosTabla;

    /* Métodos */

    /**
     * Constructor
     */
    public EliminarDestinatarioDialog() {

        _datosTabla = new EliminarDestinatariosTableModel();

        initComponents();

        //Ancho de la columna del checkbox
        TableColumn tc = _destinatariosTable.getColumnModel().getColumn(0);
        int width = 80;
        tc.setPreferredWidth(width);
        tc.setMinWidth(width);
        tc.setMaxWidth(width);

        class ListenerClickTabla implements MouseListener{

            JTable tabla;

            ListenerClickTabla(JTable tabla){
                this.tabla = tabla;
            }

            private void accionRealizada(){

                int fila = tabla.getSelectedRow();
                int col = tabla.getSelectedColumn();
                if(col==0){
                    _datosTabla.cambiarEstadoChecked(fila);
                }
            }

            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseReleased(MouseEvent e) {
                this.accionRealizada();
            }

            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
        }

        _destinatariosTable.addMouseListener(new ListenerClickTabla(_destinatariosTable));

    }

    /**
     * Método para obtener los destinatarios que se han señalado para ser
     * eliminados
     * @return Lista con los destinatarios que se desean eliminar
     */
    public List<Destinastarios> getDestinatarios2Eliminar(){

        return _datosTabla.getSelected();

    }

    /**
     * Método para refrescar los datos de la tabla
     * @param datos Lista de los destinatarios con los datos actualizados
     */
    public void refrescarDatos(List<Destinastarios> datos){
        _datosTabla.refrescarDatos(datos);
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

        _borrarSelecionadosButton = new javax.swing.JButton();
        _cancelarButton = new javax.swing.JButton();
        _destinatariosScrollPane = new javax.swing.JScrollPane();
        _destinatariosTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(614, 220));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        _borrarSelecionadosButton.setText("Borrar seleccionados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 9, 20, 9);
        getContentPane().add(_borrarSelecionadosButton, gridBagConstraints);

        _cancelarButton.setText("Cancelar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(16, 5, 16, 5);
        getContentPane().add(_cancelarButton, gridBagConstraints);

        _destinatariosScrollPane.setPreferredSize(new java.awt.Dimension(452, 128));

        _destinatariosTable.setModel(_datosTabla);
        _destinatariosScrollPane.setViewportView(_destinatariosTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 12, 4, 12);
        getContentPane().add(_destinatariosScrollPane, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _borrarSelecionadosButton;
    private javax.swing.JButton _cancelarButton;
    private javax.swing.JScrollPane _destinatariosScrollPane;
    private javax.swing.JTable _destinatariosTable;
    // End of variables declaration//GEN-END:variables

}
