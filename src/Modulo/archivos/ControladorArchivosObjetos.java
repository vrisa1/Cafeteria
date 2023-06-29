package Modulo.archivos;

import Modulo.genericas.Contenedor;
import Modulo.genericas.ContenedorMapa;
import Modulo.productos.Producto;
import Modulo.usuarios.Usuario;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

public class ControladorArchivosObjetos { //Para manipular los archivos de productos

    //CARGAR ARCHIVOS-----------------------------------------------------------------------------------------

    public static void grabar(String nombreArchivo, Contenedor<Producto> productos){
        //String nombreArchivo = nombreClase.toLowerCase() + ".dat";
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

    public static void grabar(String nombreArchivo, ContenedorMapa<String, Usuario> usuarios){
        FileOutputStream salidaBinario = null;
        ObjectOutputStream salidaObjetos = null;
        try{
            salidaBinario = new FileOutputStream(nombreArchivo);
            salidaObjetos = new ObjectOutputStream(salidaBinario);
            //Usuario aux;
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

    public static void leer(String nombreArchivo, Contenedor<Producto> productos) {
        //String nombreArchivo = nombreClase.toLowerCase() + ".dat";
        //HashSet<Producto> productos = new HashSet<>();
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