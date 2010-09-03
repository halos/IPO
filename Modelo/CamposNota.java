
package Modelo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Almacena un grupo de campos de nota y sus valores
 * @author Andres Jesus Ibañez Exposito
 */
public class CamposNota {

    /* - Atributos ----------------------- */

        private Map<NombreCamposNota, Object> mapa;

    /* - Métodos -----------------------*/
    public CamposNota() {
        mapa = new LinkedHashMap<NombreCamposNota, Object>();
    }

    public void añadirCampo(NombreCamposNota key, Object value){
        if (!mapa.containsKey(key)){
            mapa.put(key, value);
        }
    }

    public void modificarCampo(NombreCamposNota key, Object value){
        if (mapa.containsKey(key))
            mapa.put(key, value);
    }

    public Object getValueOf(NombreCamposNota key){
        return mapa.get(key);
    }

    public Set<NombreCamposNota>getKeys(){
        return mapa.keySet();
    }

    @Override
    protected Object clone(){
        CamposNota aux = new CamposNota();
        for(NombreCamposNota n: this.getKeys()){
            aux.añadirCampo(n, this.getValueOf(n));
        }
        return aux;
    }


    public boolean coincide (CamposNota criterios){


        for(NombreCamposNota n : criterios.getKeys()){
            if (!this.getValueOf(n).equals(criterios.getValueOf(n)))
                return false;
        }
        return true;
    }





}
