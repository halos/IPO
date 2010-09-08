/*
 * Controlador.java
 */

package controlador;

import controlador.undo.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import modelo.CamposNota;
import modelo.ModeloInterface;
import modelo.Nota;
import vista.Vista;
import vista.VistaInterface;

/**
 * Implementacion concreta de la estrategia <tt>ControladorInterface</tt>.
 * @author Andrés Jesús Ibáñez Expósito.
 */
public class Controlador implements ControladorInterface {

    /* - Atributos --------------------------------------------------------- */
    
    /**
     * Modelo de la aplicacion. Sobre este modelo trabaja el controlador.
     */
    private ModeloInterface modelo;

    /**
     * Vista de la aplicacion. Sobre esta vista trabaja el controlador.
     */
    private VistaInterface vista;

    /*
     * Lista de notas, que son el resultado de la busqueda con los criterios actuales.
     *
     */
    private List<Nota> resBusqueda = new LinkedList<Nota>();

    /*
     * Lista de observadores del controlador.
     *
     */

    private List<ObservadorResultadoBusqueda> observadores;



    /* - Metodos ----------------------------------------------------------- */
    
    /**
     * Constructor de la clase controlador
     * @param modelo Instancia del modelo sobre el que va a trabajar el controlador
     */
    public Controlador(ModeloInterface modelo) {
        observadores=new ArrayList<ObservadorResultadoBusqueda>();
        this.modelo = modelo;
        vista = new Vista(modelo, this);
        vista.mostrarGUI();
    }

    /**
     * Solicita una búsqueda al modelo con los datos facilitados por la vista <p>
     * una vez realizada notifica a los observadores que ha habido cambios
     */
    public void busquedaSolicitada() {
        resBusqueda=modelo.buscar(vista.getCriteriosBusqueda());
        notificarResultadoBusquedaCambiado();
    }

    /**
     * Registra un nuevo observador de los cambios de la búsqueda para que éste sea
     * notificado de los cambios
     * @param observador Observador a añadir a la lista
     */
    public void registrarObservadorResultadoBusqueda(ObservadorResultadoBusqueda observador) {
        observadores.add(observador);
        observador.resultadoBusquedaCambiado();
    }

    /**
     * Elimina un observador ya registrado en la lista para que deje de recibir
     * notificaciones de cambios
     * @param observador Observador a eliminar
     */
    public void eliminarObservadorResultadoBusqueda(ObservadorResultadoBusqueda observador) {
        observadores.remove(observador);
    }

    /**
     * Notifica a los observadores que la búsqueda ha cambiado <p>
     * Se llama a este método cada vez que se cambian los criterios
     * o se modifica una nota de la lista
     */
    private void notificarResultadoBusquedaCambiado(){
        for (ObservadorResultadoBusqueda o: observadores)
            o.resultadoBusquedaCambiado();
    }

    /**
     * Crea una orden para introducir una nueva nota en el sistema
     */
    public void nuevaNota() {
        CamposNota cNuevaNota = vista.getCamposNotaNuevaNota();
        (new OrdenNuevaNota(modelo, this, cNuevaNota)).ejecutar();
        this.busquedaSolicitada();
    }

    /**
     * Crea una orden para modificar una nota ya existente
     * @param nota la nota que será modificada
     */
    public void modificarNota(Nota nota) {
        CamposNota cNotaModificados = vista.getCamposNotaDetalles();
        (new OrdenModificarNota(modelo, vista, this, nota, cNotaModificados)).ejecutar();
        this.busquedaSolicitada();
    }

    /**
     * Crea una orden para marcar como leida una nota.
     * Tras hacerlo, el controlador actualiza su lista de búsqueda
     * @param nota Nota a marcar como leida
     */
    public void marcarLeida(Nota nota) {
        (new OrdenMarcarLeida(modelo, vista, this, nota)).ejecutar();
        this.busquedaSolicitada();
    }

    /**
     * Crea una orden para marcar como no leida una nota.
     * Tras hacerlo, el controlador actualiza su lista de búsqueda
     * @param nota Nota a marcar como no leida
     */
    public void marcarNoLeida(Nota nota) {
        (new OrdenMarcarNoLeida(modelo, vista, this, nota)).ejecutar();
        this.busquedaSolicitada();
    }

    /**
     * Devuelve la lista de notas que resultan al realizar la búsqueda
     * @return Lista de notas que resultan de la búsqueda
     */
    public List<Nota> getResBusqueda() {
        return resBusqueda;
    }
    
    
}
