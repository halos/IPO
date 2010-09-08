/*
 * Modelo.java
 */

package modelo;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementacion concreta de la estrategia <tt>ModeloInterface</tt>.
 * @author Andrés Jesús Ibáñez Expósito
 */
public class Modelo implements ModeloInterface {

    /* - Atributos ----------------------------------------------------------- */

    private List<Nota> notas;



    /* - Metodos ----------------------------------------------------------- */
    /**
     * Constructor de la clase. Carga en memoria las notas previamente
     * guardadas
     */
    public Modelo() throws ClassNotFoundException {
        File fichero=new File("notas.fua");
        notas = new LinkedList<Nota>();

        if (fichero.exists()){
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream("notas.fua"));
                try {
                    Object aux;
                    while ((aux = ois.readObject()) != null) {
                        if (aux instanceof Nota) {
                            notas.add((Nota) aux);
                        }
                    }
                } catch (java.io.EOFException eof) {
                }
                ois.close();
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            try {
                fichero.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Crea una nueva nota.
     * @param nota la nueva nota a ser creada
     */
    public void nuevaNota(Nota nota) {
        notas.add(nota);
    }

    public List<Nota> buscar(CamposNota criterios){
        List<Nota> res = new LinkedList<Nota>();
        for(Nota m: notas){
            if (m.coincide(criterios))
                res.add(m);   
        }
        return res;
    }

    /**
     * Elimina la última nota añadida.
     */
    public void eliminarUltimaNota() {
        notas.remove(notas.size()-1);
    }

    public void guardar() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("notas.fua"));
        for (Nota n: notas){
            oos.writeObject(n);
        }
        oos.close();
    }

    /**
     * Modifica el contenido de una nota determinada
     * @param campos Campos que van a sufrir modificación
     * @param nota Nota que va a ser modificada
     */
    public void ModificarNota(CamposNota campos, Nota nota) {
        nota.modificarNota(campos);
    }

    /**
     * Marcar una nota como leída.
     * @param n Nota que va a ser marcada
     */
    public void marcarLeida(Nota n) {
        n.marcarLeida();
    }

    /**
     * Marcar una nota como no leída.
     * @param n Nota que va a ser marcada
     */
    public void marcarNoLeida(Nota n) {
        n.marcarNoLeida();
    }
}