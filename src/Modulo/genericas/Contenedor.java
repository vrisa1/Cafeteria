package Modulo.genericas;

import Modulo.archivos.ControladorArchivosObjetos;
import Modulo.productos.Producto;
import Modulo.productos.bebidas.Infusion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Esta clase implementa un HashSet generico.
 * Utilizada para contenedor de productos.
 * @param <T> - Indentificador generico
 */
public class Contenedor<T> {

    //ATRIBUTOS--------------------------------------------------------------------------------------------------

    HashSet<T> productos;

    //CONSTRUCTOR------------------------------------------------------------------------------------------------

    public Contenedor() {
        this.productos = new HashSet<>();
    }

    //METODOS COLECCION------------------------------------------------------------------------------------------

    /**
     * Agrega un elemento en el HashSet.
     * @param nuevo - Elemento generico a agregar.
     * @return true - Si el set no tenia el elemento.
     */
    public boolean agregarProducto (T nuevo){
        return productos.add(nuevo);
    }

    /**
     * Elimina un elemento.
     * @param elemento - Elemento a eliminar.
     * @return true - Si el set contenia el elemento.
     */
    public boolean quitarProducto (T elemento){
        return productos.remove(elemento);
    }

    /**
     * Lee la informacion de los elementos del HashSet.
     * @return La informacion leida en forma de String.
     */
    public String listar(){
        String lista="";
        Iterator<T> it = productos.iterator();
        while (it.hasNext()){
            lista = lista.concat(it.next().toString());
        }
        return lista;
    }


    /**
     * Cuenta la cantidad de elementos que hay en el HashSet.
     * @return El contador con la cantidad de elementos.
     */
    public int contar(){
        return productos.size();
    }

    /**
     *
     * @return El iterador del HashSet.
     */
    public Iterator<T> iterar(){
        return productos.iterator();
    }


}
