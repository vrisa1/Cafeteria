

import Modulo.Excepciones.ContraseñaIncorrectaException;
import Modulo.InterfazGrafica.InterfazAdmin;
import Modulo.archivos.ControladorArchivosObjetos;
import Modulo.genericas.Contenedor;
import Modulo.productos.Producto;
import Modulo.productos.bebidas.Bebida;
import Modulo.productos.bebidas.BebidaEnvasada;
import Modulo.productos.bebidas.Infusion;
import Modulo.productos.bebidas.Leche;
import Modulo.productos.comidas.Comida;
import Modulo.Cafeteria;


import Modulo.usuarios.Usuario;
import Modulo.genericas.ContenedorMapa;

import java.text.SimpleDateFormat;
import java.util.*;

import Modulo.Cafeteria;
import Modulo.InterfazGrafica.CrearUsuario;
import Modulo.InterfazGrafica.Login;

public class Main {
    public static void main(String[] args) {

        //PRUEBAS ARCHIVOS PRODUCTOS
        Cafeteria cafe = new Cafeteria();
        cafe.cargarMenu();
        System.out.println("\n" + cafe.mostrarMenu());

        //PRUEBAS ARCHIVOS USUARIOS
        /*Usuario u1 = new Usuario("pepe","123","pepe@gmail.com");
        Usuario u2 = new Usuario("juan","456","juan@gmail.com");
        Usuario u3 = new Usuario("maria","789","maria@gmail.com");
        ContenedorMapa<String,Usuario> usuarios = new ContenedorMapa<>();
        usuarios.agregar(u1.getNombreDeUsuario(),u1);
        usuarios.agregar(u2.getNombreDeUsuario(),u2);
        usuarios.agregar(u3.getNombreDeUsuario(),u3);
        ControladorArchivosObjetos.grabar("usuarios.dat",usuarios);*/

        //ContenedorMapa<String,Usuario> usuarios = new ContenedorMapa<>();
        //ControladorArchivosObjetos.leer("usuarios.dat",usuarios);
        //System.out.println(usuarios.listar());


        cafe.crearAdmin();
        //InterfazAdmin interfazAdmin = new InterfazAdmin(cafe);
        Login login = new Login(cafe);

    }
}