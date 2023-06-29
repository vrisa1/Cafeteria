import Modulo.archivos.ControladorArchivosObjetos;
import Modulo.Cafeteria;
import Modulo.Excepciones.ProductoNoDisponibleException;
import Modulo.InterfazGrafica.InterfazAdmin;
import Modulo.InterfazGrafica.Login;
import Modulo.compras.Compra;
import Modulo.compras.MetodosDePago;
import Modulo.json.JsonUtiles;
import Modulo.productos.Producto;
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

import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {


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

    }
}