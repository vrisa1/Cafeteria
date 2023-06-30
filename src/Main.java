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

        //cafe.crearAdmin();
        //InterfazAdmin interfazAdmin = new InterfazAdmin(cafe);


        /*

        //CARGAR ARCHIVO DE COMIDAS

        Comida c1 = new Comida("Medialuna salada",300,true,"Medialuna salada",false);
        Comida c2 = new Comida("Tostado",900,true,"En pan de miga, de jamon y queso",false);
        Comida c3 = new Comida("Budin de limon",850,true,"Porcion de budin de limon y amapola",false);
        Comida c4 = new Comida("Medialuna JyQ",850,true,"Medialuna dulce rellena con jamon y queso",false);
        Comida c5 = new Comida("Alfajor de chocolate",680,true,"Alfajor relleno con dulce de leche y bañado en chocolate",false);
        Comida c6 = new Comida("Budin de zanahoria",850,true,"Porcion de budin de zanahoria",false);
        Comida c7 = new Comida("Chocotorta",1300,true,"Porcion de chocotorta cubierta con ganache de chocolate",false);
        Comida c8 = new Comida("Pizza muzzarella",1900,true,"Con salsa de tomate, muzzarella, aceitunas y oregano",true);
        Comida c9 = new Comida("Alfajor de maicena",680,true,"Alfajor de maicena relleno con  dulce de leche",false);
        Comida c10 = new Comida("Pizza capresse",3500,true,"Con salsa de tomate, muzzarella, ajo, rodajas de tomate,albahaca y aceite de oliva",true);
        Comida c11 = new Comida("Pizza especial",3700,true,"Con salsa de tomate, muzzarella, jamon, morron, aceitunas y oregano",true);
        Comida c12 = new Comida("Toston de palta",1500,true,"En pan de campo, con aceite de oliva, queso crema, palta y huevo a la plancha",false);
        Comida c13 = new Comida("Hamburguesa",2500,true,"En pan de papa, con lechuga, tomate y huevo, acompañada de papas fritas",false);
        Comida c14 = new Comida("Crumble de manzana",1400,true,"Porcion de crumble de manzana",false);
        Comida c15 = new Comida("Lemon pie",1500,true,"Porcion de lemon pie cubierto con merengue italiano",false);
        Comida c16 = new Comida("Muffin",650,true,"Muffin de vainilla y frutos rojos",false);
        Comida c17 = new Comida("Medialuna dulce",300,true,"Medialuna dulce",false);
        Comida c18 = new Comida("Roll de canela",680,true,"Roll de canela con glaseado de limon",false);
        Comida c19 = new Comida("Cookie",680,true,"Galleta de avena y chocolate semiamargo",false);
        Comida c20 = new Comida("Brownie",1200,true,"Brownie con nueces",false);
        Comida c21 = new Comida("Tostadas",650,true,"En pan de campo, con mermelada, queso crema y dulce de leche",false);

        Contenedor<Producto> comidas = new Contenedor<>();
        comidas.agregarProducto(c1);
        comidas.agregarProducto(c2);
        comidas.agregarProducto(c3);
        comidas.agregarProducto(c4);
        comidas.agregarProducto(c5);
        comidas.agregarProducto(c6);
        comidas.agregarProducto(c7);
        comidas.agregarProducto(c8);
        comidas.agregarProducto(c9);
        comidas.agregarProducto(c10);
        comidas.agregarProducto(c11);
        comidas.agregarProducto(c12);
        comidas.agregarProducto(c13);
        comidas.agregarProducto(c14);
        comidas.agregarProducto(c15);
        comidas.agregarProducto(c16);
        comidas.agregarProducto(c17);
        comidas.agregarProducto(c18);
        comidas.agregarProducto(c19);
        comidas.agregarProducto(c20);
        comidas.agregarProducto(c21);

        ControladorArchivosObjetos.grabar("Comida.dat", comidas);


        //CARGAR ARCHIVO DE INFUSIONES

        Infusion i1 = new Infusion("Licuado de banana",880,true,"Licuado de banana con leche",360,"Frio",null);
        Infusion i2 = new Infusion("Frapuccino tramontana",1200,true,"Cafe frio con leche, crema y helado de tramontana",360,"Frio",null);
        Infusion i3 = new Infusion("Milkshake de frutilla",1100,true,"Batido de helado y leche",360,"Frio",null);
        Infusion i4 = new Infusion("Lagrima",580,true,"1/3 cafe, 2/3 leche",200,"Caliente",null);
        Infusion i5 = new Infusion("Moka",1090,true,"Cafe cortado con salsa de chocolate y crema",280,"Caliente",null);
        Infusion i6 = new Infusion("Frapuccino chocolate",1200,true,"Cafe frio con leche, crema, salsa de chocolate y chocolate rallado",360,"Frio",null);
        Infusion i7 = new Infusion("Matcha latte",880,true,"Te matcha, con leche",360,"Caliente",null);
        Infusion i8 = new Infusion("Cortado",580,true,"1/2 cafe, 1/2 leche",125,"Caliente",null);
        Infusion i9 = new Infusion("Submarino",780,true,"Leche con chocolate",280,"Caliente",null);
        Infusion i10 = new Infusion("Chai latte",880,true,"Te especiado, con leche",360,"Caliente",null);
        Infusion i11 = new Infusion("Capuccino",780,true,"Cafe con leche, chocolate y canela",200,"Caliente",null);
        Infusion i12 = new Infusion("Iced latte",580,true,"Cafe con leche y hielo",200,"Frio",null);
        Infusion i13 = new Infusion("Frapuccino dulce de leche",1200,true,"Cafe frio con leche, crema y dulce de leche",360,"Frio",null);
        Infusion i14 = new Infusion("Cafe con leche",580,true,"2/3 cafe, 1/3 leche",180,"Caliente",null);

        Contenedor<Producto> infusiones = new Contenedor<>();
        infusiones.agregarProducto(i1);
        infusiones.agregarProducto(i2);
        infusiones.agregarProducto(i3);
        infusiones.agregarProducto(i4);
        infusiones.agregarProducto(i5);
        infusiones.agregarProducto(i6);
        infusiones.agregarProducto(i7);
        infusiones.agregarProducto(i8);
        infusiones.agregarProducto(i9);
        infusiones.agregarProducto(i10);
        infusiones.agregarProducto(i11);
        infusiones.agregarProducto(i12);
        infusiones.agregarProducto(i13);
        infusiones.agregarProducto(i14);

        ControladorArchivosObjetos.grabar("Infusion.dat",infusiones);

        //envasadas
        BebidaEnvasada b1 = new BebidaEnvasada("Patagonia Amber Lager",940,true,"Cerveza roja",730,true,"Patagonia");
        BebidaEnvasada b2 = new BebidaEnvasada("Sprite",630,true,"Gaseosa pequeña, sabor lima-limon",500,true,"Coca-cola");
        BebidaEnvasada b3 = new BebidaEnvasada("Levite de pomelo",630,true,"Agua saborizada sabor pomelo",500,false,"Levite");
        BebidaEnvasada b4 = new BebidaEnvasada("Agua",600,true,"Agua sin gas",500,false,"Villavicencio");
        BebidaEnvasada b5 = new BebidaEnvasada("Levite de manzana",630,true,"Agua saborizada sabor manzana",500,false,"Levite");
        BebidaEnvasada b6 = new BebidaEnvasada("Patagonia Porter",940,true,"Cerveza negra",730,true,"Patagonia");
        BebidaEnvasada b7 = new BebidaEnvasada("Corona",820,true,"Cerveza rubia",710,true,"Corona");
        BebidaEnvasada b8 = new BebidaEnvasada("Paso de los toros",630,true,"Gaseosa pequeña, sabor pomelo",500,true,"Pepsi");
        BebidaEnvasada b9 = new BebidaEnvasada("Agua gasificada",600,true,"Agua con gas",500,true,"Villavicencio");
        BebidaEnvasada b10 = new BebidaEnvasada("Fanta",630,true,"Gaseosa pequeña, sabor naranja",500,true,"Coca-cola");
        BebidaEnvasada b11 = new BebidaEnvasada("Levite de naranja",630,true,"Agua saborizada sabor naranja",500,false,"Levite");
        BebidaEnvasada b12 = new BebidaEnvasada("Coca-cola",630,true,"Gaseosa pequeña, clasica",500,true,"Coca-cola");

        Contenedor<Producto> bebidas = new Contenedor<>();
        bebidas.agregarProducto(b1);
        bebidas.agregarProducto(b2);
        bebidas.agregarProducto(b3);
        bebidas.agregarProducto(b4);
        bebidas.agregarProducto(b5);
        bebidas.agregarProducto(b6);
        bebidas.agregarProducto(b7);
        bebidas.agregarProducto(b8);
        bebidas.agregarProducto(b9);
        bebidas.agregarProducto(b10);
        bebidas.agregarProducto(b11);
        bebidas.agregarProducto(b12);

        ControladorArchivosObjetos.grabar("BebidaEnvasada.dat",bebidas);
        
         */





    }
}