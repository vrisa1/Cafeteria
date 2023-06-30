import Modulo.Excepciones.ContraseñaIncorrectaException;
import Modulo.InterfazGrafica.InterfazAdmin;

import Modulo.archivos.ControladorArchivosObjetos;
import Modulo.Cafeteria;
import Modulo.Excepciones.ProductoNoDisponibleException;
import Modulo.InterfazGrafica.InterfazAdmin;
import Modulo.InterfazGrafica.Login;
import Modulo.compras.Compra;
import Modulo.compras.MetodosDePago;
import Modulo.json.JsonUtiles;
import Modulo.productos.Producto;
import Modulo.productos.bebidas.Bebida;
import Modulo.productos.bebidas.BebidaEnvasada;
import Modulo.productos.bebidas.Infusion;
import Modulo.productos.bebidas.Leche;
import Modulo.productos.comidas.Comida;
import Modulo.Cafeteria;
import Modulo.usuarios.Usuario;
import Modulo.genericas.ContenedorMapa;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
        //System.out.println("\n" + cafe.mostrarMenu());

        
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


        /*
        //COMPRAS
        Cafeteria cafeteria1 = new Cafeteria();
		try{
            cafeteria1.iniciarCompras();
        }
        catch (JSONException e) {
            System.out.println(e.getMessage());
        }


        Compra compra=new Compra(cafeteria1.getCantidadCompras());
        Producto infusion= new Infusion("Cafe con leche", 500, true, 0, "blablabla", 2, 150, "caliente", Leche.COCO);
        Producto envasada= new BebidaEnvasada("Gaseosa", 700, true, 0, "blablabla2", 1, 500, true, "Coca Cola");
        try {
            compra.agregarAlCarrito(infusion);
            compra.agregarAlCarrito(envasada);
        }
        catch (ProductoNoDisponibleException e){
            System.out.println(e.getMessage());
        }

        //hacer elegir al usuario el metodo para finalizar la compra
        cafeteria1.finalizarCompra(compra, MetodosDePago.CREDITO);

        System.out.println(cafeteria1.mostrarCompras());

        try{
            cafeteria1.guardarJsonCompras();
        }
        catch (JSONException e){
            System.out.println(e.getMessage());
        }

         */


        //InterfazAdmin aux=new InterfazAdmin();
        //Login aux1= new Login(new Cafeteria());


        cafe.crearAdmin();
        InterfazAdmin interfazAdmin = new InterfazAdmin(cafe);


    }
}