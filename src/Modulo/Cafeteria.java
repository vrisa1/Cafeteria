package Modulo;

import Modulo.genericas.ContenedorMapa;

import Modulo.usuarios.Usuario;

import java.util.Iterator;
import java.util.Map;

public class Cafeteria {

    private ContenedorMapa<String, Usuario> usuarios;


    public Cafeteria() {
        this.usuarios = new ContenedorMapa<>();
    }

    public boolean AgregarUsuario(Usuario nuevo){
        usuarios.agregar(nuevo.getId(),nuevo);
        return true;
    }


    public void login(String usuario,String cont){
        Usuario encontrado = null;
        Usuario aux = new Usuario();
        aux.setNombreDeUsuario(usuario);
        Iterator<Map.Entry<String,Usuario>> it = usuarios.iterar();
        while (it.hasNext()){
                Usuario otroAux = it.next().getValue();
            if(otroAux.equals(aux)){
                encontrado = otroAux;
            }// else exception usuario inválido;
        }
        if(encontrado.getContraseña().equals(cont)){
            if(encontrado.isAdministrador()){
                //JFrame admin
            }else{
                //JFrame cliente
            }
        }//else exception contraseña incorrecta
        System.out.println(encontrado);
    }


}
