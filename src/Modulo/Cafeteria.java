package Modulo;

import Modulo.Excepciones.ContraseñaIncorrectaException;
import Modulo.Excepciones.UsuarioNoExisteException;
import Modulo.Excepciones.UsuarioYaExisteException;
import Modulo.InterfazGrafica.InterfazAdmin;
import Modulo.genericas.ContenedorMapa;

import Modulo.usuarios.Usuario;

import java.util.Iterator;
import java.util.Map;

public class Cafeteria {

    private ContenedorMapa<String, Usuario> usuarios;
    private int cantidadUsuarios; /// se usa?

    public Cafeteria() {
        this.usuarios = new ContenedorMapa<>();
        this.cantidadUsuarios=0;
    }

    public boolean CrearUsuario(String nombre,String cont,String mail) throws UsuarioYaExisteException {
        boolean agregado = false;
        if(usuarios.buscar(nombre)==null){
            Usuario nuevo = new Usuario(nombre,cont,mail);
            //cantidadUsuarios++;
           usuarios.agregar(nuevo.getNombreDeUsuario(),nuevo);
            agregado = true;
        }else {
            throw new UsuarioYaExisteException("Usuario ya Existe");
        }
       return agregado; /// sacar retornos?
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

    public boolean modificarUsuario(String usuario,String mail,String cont){
        boolean modif= false;
        if(usuarios.buscar(usuario)!=null){
            Usuario aux = usuarios.buscar(usuario);
            aux.setMail(mail);
            aux.setContraseña(cont);
            modif = true;
        }
        return modif;
    }

    public String mostrar(){
        return usuarios.listar();
    }

    public String eliminarUsuario(String usuario) throws UsuarioNoExisteException {
        String eliminado="";
        if(!usuarios.quitar(usuario)){
            throw new UsuarioNoExisteException("Usuario no Existe");
        }else{
            eliminado= "Eliminado con éxito";
        }
        return eliminado;
    }

}
