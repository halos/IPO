/*
 * Archivo de documentacion del paquete: cgiundo.
 */

/**
 * Proporciona las clases necesarias para implementar de forma sencilla el
 * mecanismo de deshacer/rehacer.
 * <p>
 * Incluye la pila de ordenes: <tt>PilaDeshacer</tt>, un observador para los
 * cambios producidos en dicha pila: <tt>ObservadorPilaDeshacer</tt> y dos items
 * de menus preprogramados para invocar que se deshaga/rehaga la ultima orden:
 * <tt>UndoMenuItem</tt> y <tt>RedoMenuItem</tt> respectivamente.
 * <p>
 * La forma de usar este paquete es:
 * <ol>
 * <li><b>Proporcionar al usuario la capacidad de actuar sobre la pila.</b>
 * <p>
 * Construir un <tt>JMenu</tt> etiquetado <tt>Edicion</tt> y añadirle una
 * instancia de las dos ultimas clases.<p>
 * <pre>
 * {@code
 * JMenuBar menuBar = new JMenuBar();
 *
 * JMenu menu = new JMenu("Edicion");
 * menu.add(new UndoMenuItem());
 * menu.add(new RedoMenuItem());
 * 
 * menuBar.add(menu);
 * }</pre>
 * <li><b>Generar nuevas ordenes que se puedan usar en la pila.</b>
 * <p>
 * Cada orden que se quiera usar debe ser una clase que especialice a la
 * clase <tt>AbstractUndoableEdit</tt>. En dicha clase se deben redefinir
 * los metodos <tt>undo</tt>, <tt>redo</tt> y <tt>getPresentationName</tt>, y
 * ademas definir un nuevo metodo llamado <tt>ejecutar</tt>.
 * <p>
 * En el constructor de la orden se deben preparar todos los datos que la
 * orden necesite para ejecutarse y deshacerse. Eso incluye el receptor de la
 * orden y los parametros necesarios.
 * <p>
 * En el metodo <tt>ejecutar</tt> se debe terminar con una instruccion para
 * que la propia orden se incluya a si misma dentro de la pila:<p>
 * <pre>
 * {@code
 * public void ejecutar() {
 *
 *     // Instrucciones que ejecutan la orden
 *
 *     PilaDeshacer.addEdit(this);
 * }
 * }</pre>
 * En el metodo <tt>undo</tt> justo al principio se debe invocar al metodo
 * <tt>undo</tt> de la superclase: <tt>AbstractUndoableEdit</tt> para que el
 * estado de la pila se mantenga correctamente.
 * <pre>
 * {@code
 * public void undo() {
 *
 *     super.undo();
 *
 *     // Instrucciones que deshacen la orden.
 * }
 * }</pre>
 * De igual forma en el metodo <tt>redo</tt> justo al principio se debe invocar
 * al metodo <tt>redo</tt> de la superclase: <tt>AbstractUndoableEdit</tt> para
 * que el estado de la pila se mantenga correctamente.
 * <pre>
 * {@code
 * public void redo() {
 *
 *     super.redo();
 *
 *     // Instrucciones que rehacen la orden.
 * }
 * }</pre>
 * El metodo <tt>getPresentationName</tt> debe devolver una cadena de caracteres
 * que describa a la orden que se va a deshacer/rehacer. Por ejemplo:
 * <pre>
 * {@code
 * public String getPresentationName() {
 *
 *     return "editar archivo";
 * }
 * }</pre>
 * da como resultado que si esa orden es el tope de la pila, en el item de menu
 * que se proporciona con este paquete aparezca el texto:
 * <tt>Deshacer editar archivo</tt>, lo que facilita mucho la tarea de explorar
 * la interfaz de la aplicacion.
 * </ol>
 */
package Controlador.Undo;

