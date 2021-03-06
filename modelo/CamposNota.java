
package modelo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Almacena un grupo de campos de nota y sus valores
 * @author Andres Jesus Ibañez Exposito Y Javier Rascón Mesa
 */
public class CamposNota implements Serializable {


    /* - Atributos ----------------------- */

    /**
     * Conjunto de atributos de la nota
     */
    private Map<NombreCamposNota, Object> mapa;

    /* - Métodos -----------------------*/


    /**
     * Constructor de la clase CamposNota.
     * Crea un mapa de Object cuya clave es el nombre de los campos
     */
    public CamposNota() {
        mapa = new LinkedHashMap<NombreCamposNota, Object>();
    }

    /**
     * Inserta un campo en el mapa.
     * Si la clave ya existe no se hace nada.
     * @param key nombre del campo a insertar
     * @param value valor del campo a insertar
     */
    public void añadirCampo(NombreCamposNota key, Object value){
        if (!mapa.containsKey(key)){
            mapa.put(key, value);
        }
    }

    /**
     * Modifica un campo existente.
     * @param key Nombre del campo a modificar
     * @param value Nuevo valor deseado para el campo
     */
    public void modificarCampo(NombreCamposNota key, Object value){
        if (mapa.containsKey(key))
            mapa.put(key, value);
    }

    /**
     * Obtiene el valor de un campo determinado.
     * @param key Nombre del campo del que se quiere recuperar el valor
     * @return Objeto de la clase CamposNota cuya clave es key
     */
    public Object getValueOf(NombreCamposNota key){
        return mapa.get(key);
    }

    /**
     * @return El nombre de los campos de una nota
     */
    public Set<NombreCamposNota>getKeys(){
        return mapa.keySet();
    }

    /**
     * Crea una copia de la clase
     * @return Copia de la clase CamposNota
     */
    @Override
    public Object clone(){
        CamposNota aux = new CamposNota();
        for(NombreCamposNota n: this.getKeys()){
            aux.añadirCampo(n, this.getValueOf(n));
        }
        return aux;
    }


    /**
     * Comprueba si los criterios pasados coinciden con los existentes
     * @param criterios Criterios que se compararán con los existentes
     * @return true sí los criterios coinciden y false en otro caso
     */
    public boolean coincide (CamposNota criterios){
        boolean flag=true;

        if(criterios.getKeys().size()==0){
            return true;
        }

        for (NombreCamposNota n:getKeys()){
            
            if (criterios.mapa.containsKey(n.PRIORIDAD))
                    if(criterios.getValueOf(n.PRIORIDAD)==this.getValueOf(n.PRIORIDAD)){
                        flag=true;
                    }
                    else{
                        return false;
                    }

            if (criterios.mapa.containsKey(n.DESTINATARIO))
                    if(criterios.getValueOf(n.DESTINATARIO)==this.getValueOf(n.DESTINATARIO)){
                        flag=true;
                    }
                    else{
                        return false;
                    }

            if (criterios.mapa.containsKey(n.ASUNTO))
                if(this.getValueOf(n.ASUNTO).toString().toLowerCase().contains(
                    criterios.getValueOf(n.ASUNTO).toString().toLowerCase())){
                        flag=true;
                    }
                    else{
                        if(this.getValueOf(n.CUERPO).toString().toLowerCase().contains(
                            criterios.getValueOf(n.CUERPO).toString().toLowerCase())){
                            flag = true;
                        }
                        else{
                            return false;
                        }
                    }

            if (criterios.mapa.containsKey(n.FECHA))
                if(criterios.getValueOf(n.FECHA).toString().toLowerCase().contains(
                    this.getValueOf(n.FECHA).toString().toLowerCase())){
                    flag = true;
                }
                else{
                    return false;
                }
            
        }

        return flag;
    }


}
