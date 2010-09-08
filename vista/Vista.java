/**
 * Vista.java
 */

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
 * Implementacion concreta de la estrategia <tt>VistaInterface</tt>.
 * @author Javier Rascón Mesa
 */
public class Vista implements VistaInterface, ObservadorResultadoBusqueda{

    /*---- Atributos ----*/

    /**
     * Modelo de la aplicacion. Sobre este modelo trabaja el controlador.
     */
    ModeloInterface _modelo;

    /**
     * Vista de la aplicacion. Sobre esta vista trabaja el controlador.
     */
    ControladorInterface _controlador;

    /**
     * Ventana principal de la aplicación
     */
    PrincipalFrame _principalF;

    /**
     * Diálogo de la nueva nota
     */
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

        //mostrar el diálogo de la nueva nota
        _principalF.addNuevaNotaButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                mostrarNuevaNotaDialog();
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

        //avisar de que los criterios de búsqueda han cambiado
        _principalF.addCriteriosBusquedaCambiadosListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                _controlador.busquedaSolicitada();
            }
        });

        //avisar de que se ha pulsado una nota en la tabla
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

        //avisar de que se ha pulsado el botón de marcar nota como no leida
        _principalF.addMarcarNoLeidaButtonListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                _controlador.marcarNoLeida(_principalF.getNotaDetalles());
            }
        });

        //avisar de que se ha cambiado una nota
        _principalF.addNotaCambiadaListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                Nota n = _principalF.getNotaDetalles();
                
                _controlador.modificarNota(n);
            }
        });

        _controlador.registrarObservadorResultadoBusqueda(this);

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

        //avisar al controlador de que se ha creado una nueva nota
        _nuevaNotaD.addNuevaNotaListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                _nuevaNotaD.setVisible(false);
                _controlador.nuevaNota();
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
