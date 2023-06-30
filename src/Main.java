

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

        Infusion i1 = new Infusion("Cafe",530,true,"Cafe negro",60,"Caliente",Leche.NINGUNA);
        Infusion i2 = new Infusion("Frapuccino tramontana",1200,true,"Cafe frio con leche, crema y helado de tramontana",360,"Frio",null);
        Infusion i3 = new Infusion("Te",580,true,"Te negro en saquito",280,"Caliente",Leche.NINGUNA);
        Infusion i4 = new Infusion("Lagrima",580,true,"1/3 cafe, 2/3 leche",200,"Caliente",null);
        Infusion i5 = new Infusion("Moka",1090,true,"Cafe cortado con salsa de chocolate y crema",280,"Caliente",null);
        Infusion i6 = new Infusion("Frapuccino chocolate",1200,true,"Cafe frio con leche, crema, salsa de chocolate y chocolate rallado",360,"Frio",null);
        Infusion i7 = new Infusion("Matcha latte",880,true,"Te matcha, con leche",360,"Caliente",null);
        Infusion i8 = new Infusion("Cortado",580,true,"1/2 cafe, 1/2 leche",125,"Caliente",null);
        Infusion i9 = new Infusion("Submarino",780,true,"Leche con chocolate",280,"Caliente",null);
        Infusion i10 = new Infusion("Chai latte",880,true,"Te especiado, con leche",360,"Caliente",null);
        Infusion i11 = new Infusion("Capuccino",780,true,"Cafe con leche, chocolate y canela",200,"Caliente",null);
        Infusion i12 = new Infusion("Limonada",800,true,"Con menta y jengibre",360,"Frio",Leche.NINGUNA);
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
        
         */


    }
}