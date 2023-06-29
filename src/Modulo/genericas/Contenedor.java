package Modulo.genericas;

import Modulo.archivos.ControladorArchivosObjetos;
import Modulo.productos.Producto;
import Modulo.productos.bebidas.Infusion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Contenedor<T> {

    HashSet<T> productos;

    public Contenedor() {
        this.productos = new HashSet<>();
    }

    public boolean agregarProducto (T nuevo){
        return productos.add(nuevo);
    }

    public boolean quitarProducto (T nuevo){
        return productos.remove(nuevo);
    }

    public String listar(){
        String lista="";
        Iterator<T> it = productos.iterator();
        while (it.hasNext()){
            lista = lista.concat(it.next().toString());
        }
        return lista;
    }

    public Iterator<T> iterar(){
        return productos.iterator();
    }
}
