/**
 * RedoMenuItem.java
 */

package controlador.undo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Item de menu rehacer.
 * <p>
 * Es un item de menu ya programado para rehacer la orden que ocupa el tope
 * de la pila de ordenes para rehacer. Es un observador de la pila, con lo
 * que si no hay ninguna orden para rehacer, esta desactivado y si hay
 * alguna orden muestra el nombre de esta, lo que permite rehacer no a ciegas.
 * <p>
 * Su atajo de teclado es <tt>Command + Mayusculas + z</tt>.
 * <p>
 * Para usarlo solo es necesario ejecutar la orden:
 * <p>
 * <tt>menu.add(new RedoMenuItem());</tt>
 * <p>
 * donde <tt>menu</tt> es un <tt>JMenuItem</tt> que representa al menu
 * <tt>Edicion</tt> de la aplicacion.
 * @author Francisco de Asis Conde Rodriguez.
 */
public class RedoMenuItem extends JMenuItem implements ObservadorPilaDeshacer {

    /* - Metodos ----------------------------------------------------------- */

    public RedoMenuItem() {

        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                KeyEvent.SHIFT_DOWN_MASK |
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PilaDeshacer.redo();
            }
        });
        
        PilaDeshacer.registrarObservadorPilaDeshacer(this);
    }

    @Override
    public void pilaDeshacerCambiada() {
        
        setEnabled(PilaDeshacer.puedeRehacer());
        setText(PilaDeshacer.nombreRehacer());
    }

}
