package Modulo.archivos;

import Modulo.productos.Producto;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

public class ControladorArchivosObjetos { //Para manipular los archivos de productos

    //CARGAR ARCHIVOS-----------------------------------------------------------------------------------------

    public static void grabar(HashSet<Producto> productos, String nombreClase) throws IOException {
        String nombreArchivo = nombreClase + ".dat";
        FileOutputStream salidaBinario = new FileOutputStream(nombreArchivo);
        ObjectOutputStream salidaObjetos = new ObjectOutputStream(salidaBinario);
        Producto aux;
        Iterator<Producto> it = productos.iterator();
        while(it.hasNext()){
            aux = it.next();
            salidaObjetos.writeObject(aux);
        }
        /* No es necesario hacer las validaciones de stream!=null porque si no se instancia correctamente,
        se lanza la excepción y el método termina de ejecutarse */
        salidaBinario.close();
        salidaObjetos.close();
    }

    //LEER ARCHIVOS-------------------------------------------------------------------------------------------

    /*
    REVISAR BLOQUES CATCH
    */

    public static HashSet<Producto> leer(String nombreClase) throws  ClassNotFoundException, IOException{
        String nombreArchivo = nombreClase + ".dat";
        HashSet<Producto> productos = new HashSet<>();
        FileInputStream entradaBinario = new FileInputStream(nombreArchivo);
        ObjectInputStream entradaObjetos = new ObjectInputStream(entradaBinario);
        //entradaBinario = new FileInputStream(nombreArchivo);
        //entradaObjetos = new ObjectInputStream(entradaBinario);
        while(true){
            Producto aux = (Producto) entradaObjetos.readObject();
            productos.add(aux);
        }
        if(entradaBinario!=null){
            entradaBinario.close();
        }
        if(entradaObjetos!=null){
            entradaObjetos.close();
        }
        return productos;
    }

}
