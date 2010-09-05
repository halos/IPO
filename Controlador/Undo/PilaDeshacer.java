/* 
 * PilaDeshacer.java
 */

package Controlador.Undo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

/**
 * Pila de ordenes para deshacer/rehacer.
 * @author Francisco de Asis Conde Rodriguez.
 */
public class PilaDeshacer {

    /* - Variables de clase ------------------------------------------------ */

    /**
     * Singleton que permite un acceso sencillo a la pila y que garantiza
     * que solo hay una instancia de esta clase.
     */
    private static PilaDeshacer _singleton = new PilaDeshacer();

    /* - Atributos --------------------------------------------------------- */

    /**
     * La propia pila de ordenes para deshacer/rehacer.
     */
    private UndoManager _stack = new UndoManager();

    /**
     * Lista de observadores interesados en ser notificados cada vez que se
     * produzca un cambio en la pila.
     */
    private List<ObservadorPilaDeshacer> _stackListeners =
                                       new ArrayList<ObservadorPilaDeshacer>();
    
    /* - Metodos ----------------------------------------------------------- */
    
    private PilaDeshacer() {
    }

    /**
     * Añade una nueva orden a la pila.
     * @param edit Nueva orden que se añade a la pila.
     */
    public static void addEdit(UndoableEdit edit) {

        _singleton._stack.addEdit(edit);
        _singleton.notificarPilaDeshacerCambiada();
    }

    /**
     * Deshace la ultima orden introducida en la pila si la pila no esta
     * vacia. En caso contrario no hace nada.
     * <p>
     * La orden deshecha pasa a ocupar la primera posicion en la pila de
     * ordenes para rehacer.
     */
    public static void undo() {

        _singleton._stack.undo();
        _singleton.notificarPilaDeshacerCambiada();
    }

    /**
     * Rehace la ultima orden introducida en la pila de ordenes para rehacer
     * si no esta vacia. En caso contrario no hace nada.
     * <p>
     * La orden rehecha pasa a ocupar la primera posicion en la pila de
     * ordenes para deshacer.
     */
    public static void redo() {

        _singleton._stack.redo();
        _singleton.notificarPilaDeshacerCambiada();
    }

    /**
     * Notifica a los observadores de los cambios en la pila que esta ha
     * cambiado.
     * <p>
     * Se llama cada vez que se añade una nueva orden a la pila, y cada vez
     * que se rehace o deshace una orden.
     */
    private void notificarPilaDeshacerCambiada() {

        for (ObservadorPilaDeshacer l:_stackListeners) {

            l.pilaDeshacerCambiada();
        }
    }

    /**
     * Registra un nuevo observador de los cambios en la pila, de forma que
     * cada vez que se produzca uno, el observador sera notificado.
     * <p>
     * Al registrar al observador se le notifica.
     * @param listener El nuevo observador para la pila.
     */
    public static void registrarObservadorPilaDeshacer(ObservadorPilaDeshacer listener) {

        _singleton._stackListeners.add(listener);
        listener.pilaDeshacerCambiada();
    }

    /**
     * Elimina un observador ya registrado con la pila, de forma que tras la
     * ejecucion del metodo el observador deja de recibir notificaciones de
     * los cambios.
     * @param listener El observador que se quiere eliminar.
     */
    public static void eliminarObservadorPilaDeshacer(ObservadorPilaDeshacer listener) {

        _singleton._stackListeners.remove(listener);
    }

    /**
     * Consultor del estado de la pila de ordenes para deshacer.
     * @return <tt>true</tt> si en la pila quedan ordenes pendientes de
     * deshacerse y <tt>false</tt> si la pila esta vacia.
     */
    public static boolean puedeDeshacer() {

        return _singleton._stack.canUndo();
    }

    /**
     * Consultor del estado de la pila de ordenes para rehacer.
     * @return <tt>true</tt> si en la pila quedan ordenes pendientes de
     * rehacerse y <tt>false</tt> si la pila esta vacia.
     */
    public static boolean puedeRehacer() {

        return _singleton._stack.canRedo();
    }

    /**
     * Consultor del nombre de la orden que ocupa el tope de la pila de ordenes
     * para deshacer.
     * @return el nombre completo de la orden que ocupa el tope de la pila
     * de ordenes para deshacer.
     * <p>
     * Si la pila esta vacia se devuelve la cadena vacia.
     * <p>
     * Es muy util para implementar deshacer no a ciegas.
     */
    public static String nombreDeshacer() {

        return _singleton._stack.getUndoPresentationName();
    }
    
    /**
     * Consultor del nombre de la orden que ocupa el tope de la pila de ordenes
     * para rehacer.
     * @return el nombre completo de la orden que ocupa el tope de la pila
     * de ordenes para rehacer.
     * <p>
     * Si la pila esta vacia se devuelve la cadena vacia.
     * <p>
     * Es muy util para implementar rehacer no a ciegas.
     */
    public static String nombreRehacer() {
        
        return _singleton._stack.getRedoPresentationName();
    }

}
