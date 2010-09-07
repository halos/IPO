
package vista;

import controlador.ControladorInterface;
import controlador.ObservadorResultadoBusqueda;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.CamposNota;
import modelo.ModeloInterface;
import modelo.Nota;
import java.awt.event.*;

/**
 * 
 * @author Javier Rascón Mesa
 */
public class Vista implements VistaInterface, ObservadorResultadoBusqueda{

    /*---- Atributos ----*/

    ModeloInterface _modelo;
    ControladorInterface _controlador;

    PrincipalFrame _principalF;
    NuevaNotaDialog _nuevaNotaD;

    /*---- Métodos ----*/

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

        //avisar al controlador de que se ha creado una nueva nota
        _nuevaNotaD.addNuevaNotaListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                _controlador.nuevaNota();
            }
        });

        //para guardar los cambios el cerrar la ventana
        _principalF.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e)
            {
                try {
                    _modelo.guardar();
                } catch (IOException ex) {
                    Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }
        });

        _principalF.addCriteriosBusquedaCambiadosListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                _controlador.busquedaSolicitada();
            }
        });

        _principalF.addClickTablaListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseReleased(MouseEvent e) {
                
                Nota n = _principalF.getSelectedNota();
                
                _controlador.marcarLeida(n);
                _principalF.setCamposNota(n.getCamposNota());
            }

            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        _principalF.addMarcarNoLeidaButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                _controlador.marcarNoLeida(_principalF.getSelectedNota());
            }
        });

        _principalF.addNotaCambiadaListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                Nota n = _principalF.getSelectedNota();

                _controlador.modificarNota(n);
            }
        });

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
     * Método para obtener los campos de la nota que se muestra en los detalles
     * @return Campos actuales de la nota
     */
    public CamposNota getCamposNotaDetalles(){
        return _principalF.getCamposNota();
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

    // </editor-fold>

    /**** ObservadorResultadoBusqueda ****/
    //<editor-fold defaultstate="collapsed" desc="métodos">

    public void resultadoBusquedaCambiado() {

        _principalF.refrescarDatosResBusqueda(_controlador.getResBusqueda());
    }

    //</editor-fold>
    

}
