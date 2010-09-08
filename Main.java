
import controlador.Controlador;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Modelo;


/**
 *
 * @author Javier Rascón Mesa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Modelo m = new Modelo();
            Controlador c = new Controlador(m);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
