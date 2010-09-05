
package Vista.TableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Modelo.CamposNota;
import Modelo.NombreCamposNota;
import Modelo.Nota;

/**
 * Modelo de tabla para la búsqueda de las notas
 * @author Javier Rascón Mesa
 */
public class ResultadosBusquedaTableModel extends AbstractTableModel{


    /* Atributos */

    /**
     * Nombre de las columnas de las tablas
     */
    public String[] _nombreColumnas= {
        NombreCamposNota.PRIORIDAD.toString(),
        NombreCamposNota.DESTINATARIO.toString(),
        NombreCamposNota.ASUNTO.toString(),
        NombreCamposNota.FECHA.toString(),
        NombreCamposNota.CUERPO.toString()};

    /**
     * Matriz que almacena los datos de la tabla
     */
    public Object[][] _datosTabla = {};

    /* Métodos */

    /**
     * Constructor
     */
    public ResultadosBusquedaTableModel(){
        
        super();

    }

    /**
     * Método para obtener el número de filas de la tabla
     * @return Número de filas de la tabla
     */
    @Override
    public int getRowCount() {

        return _datosTabla.length;
    }

    /**
     * Método para  obtener el número de columnas de la tabla
     * @return Número de columnas de la tabla
     */
    @Override
    public int getColumnCount() {

        return _nombreColumnas.length;
    }

    /**
     * Método para obtener el obbjeto en la columna y fila deseada
     * @param rowIndex Fila del objeto
     * @param columnIndex Columna del objeto
     * @return Objeto indicado por el numero de fila y columna
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if(((rowIndex>=0 && rowIndex<getRowCount()))&&
                ((columnIndex>=0)&& (columnIndex<getColumnCount()))){
                return _datosTabla[rowIndex][columnIndex];
        }
        return "";
    }

    /**
     * Método para obtener el nombre de una columna
     * @param column Posición de la columna
     * @return Nombre de la columna
     */
    @Override
    public String getColumnName(int column){

        if (column >=0 && column < getColumnCount())
            return _nombreColumnas[column];

        return "";
    }

    /**
     * Método para obtener el tipo de la columna
     * @param columnIndex Posición de la columna
     * @return Tipo de la columna
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Object o = getValueAt(0, columnIndex);
        try{
            return o.getClass();
        }catch(NullPointerException npe){
            return Object.class;
        }
    }



    /**
     * Método para comprobar si la celda es editable
     * @param rowIndex Posición de la fila de la celta
     * @param columnIndex Posición de la columna d ela celda
     * @return Booleano indicando si la celda es editable
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        
        return false;
    }

    /**
     * Método para obtener la nota de una fila
     * @param rowIndex Fila de la nota
     * @return Nota de la fila indicada
     */
    public Nota getNotaAt(int rowIndex){
        
        return (Nota) _datosTabla[rowIndex][getColumnCount()];
    }

    /**
     * Método para refrescar los datos de la tabla
     * @param datos Lista de notas con los datos actualizados
     */
    public void refrescarDatos(List<Nota> datos){

        Boolean leida;
        _datosTabla=new Object[datos.size()][];

        //Reserva memoria para todas las filas
        for (int i=0;i<datos.size();i++){
            _datosTabla[i]=new Object[getColumnCount()+1];
        }

        //para cada nota
        int fila=0;
        for (Nota n: datos){

            CamposNota c = n.getCamposNota();
            leida = (Boolean) c.getValueOf(NombreCamposNota.LEIDA);

            String texto;

            //para todos los campos de la nota
            for (NombreCamposNota m: c.getKeys()){
                //buscar su columna
                for (int columna = 0; columna < _nombreColumnas.length; columna++) {
                    if(getColumnName(columna).equals(m.toString())){
                        texto = c.getValueOf(m).toString();

                        if(!leida)
                            texto = "<html><b>"+texto+"</b></html>";

                        _datosTabla[fila][columna++]= texto;
                    }

                }

            }

            fila++;
            
        }
        
        fireTableDataChanged();
    }

}