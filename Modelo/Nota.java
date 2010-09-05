/*
 * Clase Nota
 */

package Modelo;

import java.io.Serializable;

/**
 * Notas que contienen información almacenada para comunicar a los jefes
 * @author Andres Jesus Ibañez Exposito
 */
public class Nota implements Serializable {

    /* - Atributos --------------------------------------*/

    /**
     * define el campo de la nota.
     */
    private CamposNota campos;

    /* - Metodos ---------------------------------------*/

    /**
     * Constructor de la clase Nota
     * @param campos Información para rellenar la nota con los campos necesarios
     */
    public Nota(CamposNota campos) {
        this.campos = (CamposNota) campos.clone();
    }

    /**
     * Modifica los campos de una nota
     * @param campos Campos que serán modificados
     */
    public void modificarNota(CamposNota campos){
        for (NombreCamposNota n:campos.getKeys()){
            this.getCamposNota().modificarCampo(n, campos.getValueOf(n));
        }
    }


    /**
     * Comprueba si los criterios definidos coinciden campo a campo
     * @param criterios Criterios de búsqueda a evaluar
     * @return boolean. True si coinciden, False en caso contrario
     */
    public boolean coincide(CamposNota criterios){
        return campos.coincide(criterios);
    }

    /**
     * Obtiene los campos de una nota
     * @return Los campos de la nota, recogidos en el atributo campos
     */
    public CamposNota getCamposNota(){
        return campos;
    }

    /**
     * Marca una nota como leída, pasando su campo leida a true
     */
    public void marcarLeida(){
        this.getCamposNota().modificarCampo(NombreCamposNota.LEIDA, true);
    }

    /**
     * Marca una nota como no leída, pasando su campo leida a false
     */
    public void marcarNoLeida(){
        this.getCamposNota().modificarCampo(NombreCamposNota.LEIDA, false);
    }


}
