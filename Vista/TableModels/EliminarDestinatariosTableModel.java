
package Vista.TableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Modelo.Destinastarios;
import java.util.LinkedList;
import javax.swing.JCheckBox;

/**
 * Modelo de tabla para la eliminación de destinatarios
 * @author Javier Rascón Mesa
 */
public class EliminarDestinatariosTableModel extends AbstractTableModel{


    /* Atributos */

    /**
     * Nombre de las columnas de las tablas
     * Columna 0: checkbox
     * Columna 1: Nombre del destinatario
     */
    public String[] _nombreColumnas = {"¿Eliminar?","Nombre"};

    /**
     * Matriz que almacena los datos de la tabla
     */
    public Object[][] _datosTabla = {};

    /* Métodos */

    /**
     * Constructor
     */
    public EliminarDestinatariosTableModel(){
        
        super();

        LinkedList llDest = new LinkedList();

        for (Destinastarios d: Destinastarios.values())
            llDest.add(d);

        this.refrescarDatos(llDest);
  
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
     * Método para obtener el objeto en la columna y fila deseada
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
     * Método para obtener el destinatario de una fila
     * @param rowIndex Fila del destinatario
     * @return Destinatario de la fila indicada
     */
    public Destinastarios getDestinatarioAt(int rowIndex){
        
        return (Destinastarios) _datosTabla[rowIndex][getColumnCount()];
    }

    /**
     * Método para refrescar los datos de la tabla
     * @param datos Lista de los destinatarios con los datos actualizados
     */
    public void refrescarDatos(List<Destinastarios> datos){

        _datosTabla=new Object[datos.size()][];

        //Reserva memoria para todas las filas
        for (int i=0;i<datos.size();i++){
            _datosTabla[i]=new Object[getColumnCount()+1];
        }

        //para cada destinatario
        int fila=0;
        for (Destinastarios d: datos){

            //para todos los campos del destinatario

            int columna=0;

            _datosTabla[fila][columna++]=new Boolean(false);

            _datosTabla[fila][columna++]=d.toString();

            _datosTabla[fila][columna++]=d;

            fila++;
            
        }
        
        fireTableDataChanged();
    }

    /**
     * Método apra obtener los destinatarios seleccionados
     * @return Lista con los destinatarios seleccionados
     */
    public List<Destinastarios> getSelected(){

        LinkedList llSel = new LinkedList();

        for (int i = 0; i < this.getRowCount(); i++){

            Boolean bcb = ((Boolean) _datosTabla[i][0]).booleanValue();

            if(bcb)
                llSel.add(_datosTabla[i][getColumnCount()]);

        }
            
        return llSel;

    }

    /**
     * Método para cambiar el estado de chequeo del checkbox.
     * @param row Fila que se desea cambiar
     */
    public void cambiarEstadoChecked(int row) {
        _datosTabla[row][0] = !((Boolean)_datosTabla[row][0]).booleanValue();
        fireTableDataChanged();
    }

}