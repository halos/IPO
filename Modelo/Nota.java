/*
 * Clase Nota
 */

package Modelo;

/**
 * Notas que contienen información almacenada para comunicar a los jefes
 * @author Andres Jesus Ibañez Exposito
 */
public class Nota {

    /* - Atributos --------------------------------------*/

        private CamposNota campos;




    /* - Metodos ---------------------------------------*/

    public Nota(CamposNota campos) {
        this.campos = (CamposNota) campos.clone();
    }

    /**
     * Modificar un campo existente
     */


    /**
     *  Comparacion de campos
     */

    public boolean coincide(CamposNota criterios){


        return campos.coincide(criterios);
    }

    public CamposNota getCamposNota(){
        return campos;
    }

}
