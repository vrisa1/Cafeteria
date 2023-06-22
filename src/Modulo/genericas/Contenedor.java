package Modulo.genericas;

import java.util.HashSet;
import java.util.Iterator;

public class Contenedor<T> {

    HashSet<T> productos;

    public Contenedor() {
        this.productos = new HashSet<>();
    }

    public boolean agregarProducto (T nuevo){
        productos.add(nuevo);
        return true;
    }

    public boolean quitarProducto (T nuevo){
        productos.remove(nuevo);
        return true;
    }

    public String listar(){
        String lista="";
        Iterator<T> it =productos.iterator();
        while (it.hasNext()){
            lista = lista.concat(it.next().toString());
        }
        return lista;
    }
}
