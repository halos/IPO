/*
 * ObservadorPilaDeshacer.java
 */

package Controlador.Undo;

/**
 * Observador de los cambios que se producen en la pila de ordenes para
 * deshacer/rehacer.
 * @author Francisco de Asis Conde Rodriguez.
 */
public interface ObservadorPilaDeshacer {

    /* - Metodos ----------------------------------------------------------- */

    /**
     * Metodo para notificar que se ha producido un cambio en la pila de
     * ordenes para deshacer/rehacer.
     * <p>
     * Los observadores concretos deben implementar este metodo para
     * responder adecuadamente a esos cambios.
     */
    public void pilaDeshacerCambiada();
}
