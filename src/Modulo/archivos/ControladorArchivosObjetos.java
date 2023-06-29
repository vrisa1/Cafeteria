package Modulo.archivos;

import Modulo.productos.Producto;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

public class ControladorArchivosObjetos { //Para manipular los archivos de productos

    //CARGAR ARCHIVOS-----------------------------------------------------------------------------------------

    public static void grabar(HashSet<Producto> productos, String nombreArchivo){
        //String nombreArchivo = nombreClase.toLowerCase() + ".dat";
        FileOutputStream salidaBinario = null;
        ObjectOutputStream salidaObjetos = null;
        try{
            salidaBinario = new FileOutputStream(nombreArchivo);
            salidaObjetos = new ObjectOutputStream(salidaBinario);
            Producto aux;
            Iterator<Producto> it = productos.iterator();
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

    //LEER ARCHIVOS-------------------------------------------------------------------------------------------

    public static HashSet<Producto> leer(String nombreArchivo) {
        //String nombreArchivo = nombreClase.toLowerCase() + ".dat";
        HashSet<Producto> productos = new HashSet<>();
        FileInputStream entradaBinario = null;
        ObjectInputStream entradaObjetos = null;
        try{
            entradaBinario = new FileInputStream(nombreArchivo);
            entradaObjetos = new ObjectInputStream(entradaBinario);
            while(true){
                Producto aux = (Producto) entradaObjetos.readObject();
                productos.add(aux);
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
        return productos;
    }

}