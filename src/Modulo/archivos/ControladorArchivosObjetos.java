package Modulo.archivos;

import Modulo.genericas.Contenedor;
import Modulo.genericas.ContenedorMapa;
import Modulo.productos.Producto;
import Modulo.usuarios.Usuario;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

/**
 * Esta clase permite leer y escribir archivos mediante el uso de flujos binarios y de objetos.
 * Utiliza métodos estáticos, los cuales pueden invocarse sin necesidad de instanciar la clase.
 * Tanto el método grabar como el método leer aplican polimorfismo, ya que según los parámetros
 * que reciban leerán o guardarán un tipo distinto de objeto.
 * Una variante trabaja con un Contenedor y la otra con un ContenedorMapa (otras clases, cada una
 * con un tipo distinto de colección).
 * Las excepciones lanzadas por las instancias de tipo InputStream y OutputStream son atrapadas
 * dentro de los métodos.
 */
public class ControladorArchivosObjetos { //Para manipular los archivos de productos

    //CARGAR ARCHIVOS-----------------------------------------------------------------------------------------

    /**
     * Esta version del método grabar trabaja con un Contenedor, el cual almacena productos en
     * un HashSet.
     * Utiliza un Iterator para recorrer la colección y así poder acceder a todas las instancias
     * y escribirlas en el archivo.
     * @param nombreArchivo - String que guarda el nombre del archivo que se quiere escribir.
     * @param productos - Clase contenedora cuyo contenido se quiere guardar en el archivo.
     */
    public static void grabar(String nombreArchivo, Contenedor<Producto> productos){
        FileOutputStream salidaBinario = null;
        ObjectOutputStream salidaObjetos = null;
        try{
            salidaBinario = new FileOutputStream(nombreArchivo);
            salidaObjetos = new ObjectOutputStream(salidaBinario);
            Producto aux;
            Iterator<Producto> it = productos.iterar();
            while(it.hasNext()){
                aux = it.next();
                salidaObjetos.writeObject(aux);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(salidaBinario != null){
                    salidaBinario.close();
                }
                if(salidaObjetos != null){
                    salidaObjetos.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Esta version del método grabar trabaja con un ContenedorMapa, el cual almacena usuarios en
     * un HashMap, utilizando como clave un String.
     * Usa un Iterator perteneciente al contenedor para recorrer la colección y así poder
     * acceder a todas las instancias y escribirlas en el archivo.
     * @param nombreArchivo - String que guarda el nombre del archivo que se quiere escribir.
     * @param usuarios - Clase contenedora cuyo contenido se quiere guardar en el archivo.
     */
    public static void grabar(String nombreArchivo, ContenedorMapa<String, Usuario> usuarios){
        FileOutputStream salidaBinario = null;
        ObjectOutputStream salidaObjetos = null;
        try{
            salidaBinario = new FileOutputStream(nombreArchivo);
            salidaObjetos = new ObjectOutputStream(salidaBinario);
            Iterator<Map.Entry<String, Usuario>> it = usuarios.iterar();
            while(it.hasNext()){
                Usuario aux = (Usuario) it.next().getValue();
                salidaObjetos.writeObject(aux);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(salidaBinario != null){
                    salidaBinario.close();
                }
                if(salidaObjetos != null){
                    salidaObjetos.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    //LEER ARCHIVOS-------------------------------------------------------------------------------------------

    /**
     * Esta versión del método leer trabaja con un Contenedor, el cual almacena productos en
     * un HashSet. Los datos leídos del archivo se almacenan en este contenedor.
     * EOFException - Al llegar al final del archivo dentro del bucle while(true),
     * InputStream lanza una excepción de este tipo. Esta se atrapa dentro del método
     * usando un bloque catch. No es necesario darle comportamiento, ya que solo se usa
     * para que no se detenga la ejecución del programa.
     * @param nombreArchivo - String que guarda el nombre del archivo que se quiere leer.
     * @param productos - Clase contenedora en la que se almacenarán los datos leídos del archivo.
     */
    public static void leer(String nombreArchivo, Contenedor<Producto> productos) {
        FileInputStream entradaBinario = null;
        ObjectInputStream entradaObjetos = null;
        try{
            entradaBinario = new FileInputStream(nombreArchivo);
            entradaObjetos = new ObjectInputStream(entradaBinario);
            while(true){
                Producto aux = (Producto) entradaObjetos.readObject();
                productos.agregarProducto(aux);
            }
        }
        catch(EOFException e){
            /* Atrapa la excepcion al llegar al final del archivo,
            ya que no se conoce el tamaño y no hay condicion de corte */
        }
        catch(FileNotFoundException e){
            //
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(entradaBinario!=null){
                    entradaBinario.close();
                }
                if(entradaObjetos!=null){
                    entradaObjetos.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     *  Esta versión del método leer trabaja con un ContenedorMapa, el cual almacena usuarios en
     *  un HashMap, utilizando como clave un String. Los datos leídos del archivo se almacenan
     *  en este contenedor.
     * EOFException - Al llegar al final del archivo dentro del bucle while(true),
     * InputStream lanza una excepción de este tipo. Esta se atrapa dentro del método
     * usando un bloque catch. No es necesario darle comportamiento, ya que solo se usa
     * para que no se detenga la ejecución del programa.
     * @param nombreArchivo - String que guarda el nombre del archivo que se quiere leer.
     * @param usuarios - Clase contenedora en la que se almacenarán los datos leídos del archivo.
     */
    public static void leer(String nombreArchivo, ContenedorMapa<String,Usuario> usuarios){
        FileInputStream entradaBinario = null;
        ObjectInputStream entradaObjetos = null;
        try{
            entradaBinario = new FileInputStream(nombreArchivo);
            entradaObjetos = new ObjectInputStream(entradaBinario);
            while(true){
                Usuario aux = (Usuario) entradaObjetos.readObject();
                String key = aux.getNombreDeUsuario();
                usuarios.agregar(key,aux);
            }
        }
        catch(EOFException e){
            /* Atrapa la excepcion al llegar al final del archivo,
            ya que no se conoce el tamaño y no hay condicion de corte */
        }
        catch(FileNotFoundException e){
            //
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(entradaBinario != null){
                    entradaBinario.close();
                }
                if(entradaObjetos != null){
                    entradaObjetos.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

}