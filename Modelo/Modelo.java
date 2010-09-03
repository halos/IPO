/*
 * Modelo.java
 */

package Modelo;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementacion concreta de la estrategia <tt>ModeloInterface</tt>.
 * @author Francisco de Asis Conde Rodriguez.
 */
public class Modelo implements ModeloInterface {

    /* - Atributos ----------------------------------------------------------- */

    private List<Nota> notas;



    /* - Metodos ----------------------------------------------------------- */
    public Modelo() {
        notas = new LinkedList<Nota>();
    }

    /**
     * Añade una nueva nota al modelo
     * @param nota
     */
    public void añadirNota(Nota nota){
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
}