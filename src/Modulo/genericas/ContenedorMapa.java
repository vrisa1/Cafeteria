package Modulo.genericas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Esta clase implementa un Hash Map generico.
 * Utilizada para contenedor de compras y usuarios.
 * @param <K> - Clave generica.
 * @param <V> - Valor generico.
 */
public class ContenedorMapa<K,V> {

    HashMap<K,V> elementos;

    public ContenedorMapa() {
        this.elementos = new HashMap<K, V>();
    }

    public boolean agregar (K clave,V valor){
        return elementos.put(clave,valor) !=null;
    }

    public boolean quitar (K clave){
        return elementos.remove(clave) != null;
    }

    public int contar(){
        return elementos.size();
    }

    public String listar(){
        String lista="";
        Iterator<Map.Entry<K,V>> it =elementos.entrySet().iterator();
        while (it.hasNext()){
            lista = lista.concat(it.next().getValue().toString());
        }
        return lista;
    }

    public Iterator<Map.Entry<K,V>> iterar(){
            return elementos.entrySet().iterator();
    }

    public V buscar(K clave){
        return elementos.get(clave);
    }

}


