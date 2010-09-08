
package vista;

/**
 * Clase para la configuración de los iconos
 * @author Javier Rascón Mesa
 */
public class Icons {

    /*---- Atributos ----*/

    /**
     * Ruta de la imagen de "Deshacer"
     */
    private static String _undoPath = "img/undo.png";

    /**
     * Ruta de la iimagen de "Rehacer"
     */
    private static String _redoPath = "img/redo.png";

    /**
     * Ruta de la imagen de "Nueva nota"
     */
    private static String _newNotePath = "img/new-note.png";

    /*---- Métodos ----*/

    /**
     * Método para obtener la ruta del icono de deshacer
     * @return Ruta del icono para deshacer
     */
    public static String getIconUndo(){
        return _undoPath;
    }

    /**
     * Método para obtener la ruta del icono de rehacer
     * @return Ruta del icono para rehacer
     */
    public static String getIconRedo(){
        return _redoPath;
    }

    /**
     * Método para obtener la ruta del icono de nueva nota
     * @return Ruta del icono para crear una nueva nota
     */
    public static String getIconNewNote(){
        return _newNotePath;
    }

}
