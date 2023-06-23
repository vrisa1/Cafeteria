package Modulo;

import Modulo.Excepciones.ContraseñaIncorrectaException;
import Modulo.Excepciones.UsuarioNoExisteException;
import Modulo.Excepciones.UsuarioYaExisteException;
import Modulo.genericas.ContenedorMapa;

import Modulo.usuarios.Usuario;

import java.util.Iterator;
import java.util.Map;

public class Cafeteria {

    private ContenedorMapa<String, Usuario> usuarios;
    private int cantidadUsuarios;

    public Cafeteria() {
        this.usuarios = new ContenedorMapa<>();
        this.cantidadUsuarios=0;
    }

    public boolean CrearUsuario(String nombre,String cont) throws UsuarioYaExisteException {
        boolean agregado = false;
        if(usuarios.buscar(nombre)==null){
            Usuario nuevo = new Usuario(nombre,cont);
            cantidadUsuarios++;
            nuevo.setId(String.valueOf(cantidadUsuarios));
            usuarios.agregar(nuevo.getNombreDeUsuario(),nuevo);
            agregado = true;
        }else {
            throw new UsuarioYaExisteException("Usuario ya Existe");
        }
       return agregado;
    }


    public int login(String usuario,String cont) throws UsuarioNoExisteException, ContraseñaIncorrectaException {
        Usuario encontrado = usuarios.buscar(usuario);
        int ingreso=0;

        if(encontrado!=null){
            if(encontrado.getContraseña().equals(cont)){
                if(encontrado.isAdministrador()){
                   ingreso =1; ///Ingreso admin
                }else{
                    ingreso=2;///Ingreso cliente
                }
            }else{
                throw new ContraseñaIncorrectaException("Contraseña Incorrecta");
            }
        }else{
            throw new UsuarioNoExisteException("Usuario Incorrecto");
        }
        return ingreso;
    }


}
