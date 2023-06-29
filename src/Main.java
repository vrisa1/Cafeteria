

import Modulo.archivos.ControladorArchivosObjetos;
import Modulo.productos.Producto;
import Modulo.productos.bebidas.Bebida;
import Modulo.productos.bebidas.BebidaEnvasada;
import Modulo.productos.bebidas.Infusion;
import Modulo.productos.bebidas.Leche;
import Modulo.productos.comidas.Comida;
import Modulo.Cafeteria;


import Modulo.usuarios.Usuario;
import Modulo.genericas.ContenedorMapa;

import Modulo.Cafeteria;
import Modulo.InterfazGrafica.CrearUsuario;
import Modulo.InterfazGrafica.Login;


import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {


       /* Cafeteria cafeteria = new Cafeteria();

        cafeteria.crearAdmin();



        try {
            cafeteria.CrearUsuario("aa","1234","");

            int ingreso = cafeteria.login("aa","1234");
            System.out.println(ingreso);
        }catch (Exception e){

        }*/


        /*

        //CARGAR ARCHIVO DE BEBIDAS ENVASADAS

        BebidaEnvasada b1 = new BebidaEnvasada("Patagonia Amber Lager",940,true,0,"Cerveza roja",0,730,true,"Patagonia");
        BebidaEnvasada b2 = new BebidaEnvasada("Sprite",630,true,0,"Gaseosa pequeña, sabor lima-limon",0,500,true,"Coca-cola");
        BebidaEnvasada b3 = new BebidaEnvasada("Levite de pomelo",630,true,0,"Agua saborizada sabor pomelo",0,500,false,"Levite");
        BebidaEnvasada b4 = new BebidaEnvasada("Agua",600,true,0,"Agua sin gas",0,500,false,"Villavicencio");
        BebidaEnvasada b5 = new BebidaEnvasada("Levite de manzana",630,true,0,"Agua saborizada sabor manzana",0,500,false,"Levite");
        BebidaEnvasada b6 = new BebidaEnvasada("Patagonia Porter",940,true,0,"Cerveza negra",0,730,true,"Patagonia");
        BebidaEnvasada b7 = new BebidaEnvasada("Corona",820,true,0,"Cerveza rubia",0,710,true,"Corona");
        BebidaEnvasada b8 = new BebidaEnvasada("Paso de los toros",630,true,0,"Gaseosa pequeña, sabor pomelo",0,500,true,"Pepsi");
        BebidaEnvasada b9 = new BebidaEnvasada("Agua gasificada",600,true,0,"Agua con gas",0,500,true,"Villavicencio");
        BebidaEnvasada b10 = new BebidaEnvasada("Fanta",630,true,0,"Gaseosa pequeña, sabor naranja",0,500,true,"Coca-cola");
        BebidaEnvasada b11 = new BebidaEnvasada("Levite de naranja",630,true,0,"Agua saborizada sabor naranja",0,500,false,"Levite");
        BebidaEnvasada b12 = new BebidaEnvasada("Coca-cola",630,true,0,"Gaseosa pequeña, clasica",0,500,true,"Coca-cola");

        HashSet<Producto> bebidas = new HashSet<>();
        bebidas.add(b1);
        bebidas.add(b2);
        bebidas.add(b3);
        bebidas.add(b4);
        bebidas.add(b5);
        bebidas.add(b6);
        bebidas.add(b7);
        bebidas.add(b8);
        bebidas.add(b9);
        bebidas.add(b10);
        bebidas.add(b11);
        bebidas.add(b12);

        //CrearUsuario crearUsuario = new CrearUsuario(cafeteria);


        ControladorArchivosObjetos.grabar(bebidas,"BebidaEnvasada.dat");

         */


        /*

        Login login = new Login(cafeteria);
        //InterfazAdmin interfazAdmin= new InterfazAdmin();


        //CARGAR ARCHIVO DE COMIDAS

        Comida c1 = new Comida("Medialuna salada",300,true,0,"Medialuna salada",0,false);
        Comida c2 = new Comida("Tostado",900,true,0,"En pan de miga, de jamon y queso",0,false);
        Comida c3 = new Comida("Budin de limon",850,true,0,"Porcion de budin de limon y amapola",0,false);
        Comida c4 = new Comida("Medialuna JyQ",850,true,0,"Medialuna dulce rellena con jamon y queso",0,false);
        Comida c5 = new Comida("Alfajor de chocolate",680,true,0,"Alfajor relleno con dulce de leche y bañado en chocolate",0,false);
        Comida c6 = new Comida("Budin de zanahoria",850,true,0,"Porcion de budin de zanahoria",0,false);
        Comida c7 = new Comida("Chocotorta",1300,true,0,"Porcion de chocotorta cubierta con ganache de chocolate",0,false);
        Comida c8 = new Comida("Pizza muzzarella",1900,true,0,"Con salsa de tomate, muzzarella, aceitunas y oregano",0,true);
        Comida c9 = new Comida("Alfajor de maicena",680,true,0,"Alfajor de maicena relleno con  dulce de leche",0,false);
        Comida c10 = new Comida("Pizza capresse",3500,true,0,"Con salsa de tomate, muzzarella, ajo, rodajas de tomate,albahaca y aceite de oliva",0,true);
        Comida c11 = new Comida("Pizza especial",3700,true,0,"Con salsa de tomate, muzzarella, jamon, morron, aceitunas y oregano",0,true);
        Comida c12 = new Comida("Toston de palta",1500,true,0,"En pan de campo, con aceite de oliva, queso crema, palta y huevo a la plancha",0,false);
        Comida c13 = new Comida("Hamburguesa",2500,true,0,"En pan de papa, con lechuga, tomate y huevo, acompañada de papas fritas",0,false);
        Comida c14 = new Comida("Crumble de manzana",1400,true,0,"Porcion de crumble de manzana",0,false);
        Comida c15 = new Comida("Lemon pie",1500,true,0,"Porcion de lemon pie cubierto con merengue italiano",0,false);
        Comida c16 = new Comida("Muffin",650,true,0,"Muffin de vainilla y frutos rojos",0,false);
        Comida c17 = new Comida("Medialuna dulce",300,true,0,"Medialuna dulce",0,false);
        Comida c18 = new Comida("Roll de canela",680,true,0,"Roll de canela con glaseado de limon",0,false);
        Comida c19 = new Comida("Cookie",680,true,0,"Galleta de avena y chocolate semiamargo",0,false);
        Comida c20 = new Comida("Brownie",1200,true,0,"Brownie con nueces",0,false);
        Comida c21 = new Comida("Tostadas",650,true,0,"En pan de campo, con mermelada, queso crema y dulce de leche",0,false);

        HashSet<Producto> comidas = new HashSet<>();
        comidas.add(c1);
        comidas.add(c2);
        comidas.add(c3);
        comidas.add(c4);
        comidas.add(c5);
        comidas.add(c6);
        comidas.add(c7);
        comidas.add(c8);
        comidas.add(c9);
        comidas.add(c10);
        comidas.add(c11);
        comidas.add(c12);
        comidas.add(c13);
        comidas.add(c14);
        comidas.add(c15);
        comidas.add(c16);
        comidas.add(c17);
        comidas.add(c18);
        comidas.add(c19);
        comidas.add(c20);
        comidas.add(c21);

        ControladorArchivosObjetos.grabar(comidas,"Comida.dat");

         */

        /*

        //CARGAR ARCHIVO DE INFUSIONES

        Infusion i1 = new Infusion("Cafe",530,true,0,"Cafe negro",0,60,"Caliente",null);
        Infusion i2 = new Infusion("Frapuccino tramontana",1200,true,0,"Cafe frio con leche, crema y helado de tramontana",0,360,"Frio",null);
        Infusion i3 = new Infusion("Te",580,true,0,"Te negro en saquito",0,280,"Caliente",null);
        Infusion i4 = new Infusion("Lagrima",580,true,0,"1/3 cafe, 2/3 leche",0,200,"Caliente",null);
        Infusion i5 = new Infusion("Moka",1090,true,0,"Cafe cortado con salsa de chocolate y crema",0,280,"Caliente",null);
        Infusion i6 = new Infusion("Frapuccino chocolate",1200,true,0,"Cafe frio con leche, crema, salsa de chocolate y chocolate rallado",0,360,"Frio",null);
        Infusion i7 = new Infusion("Matcha latte",880,true,0,"Te matcha, con leche",0,360,"Caliente",null);
        Infusion i8 = new Infusion("Cortado",580,true,0,"1/2 cafe, 1/2 leche",0,125,"Caliente",null);
        Infusion i9 = new Infusion("Submarino",780,true,0,"Leche con chocolate",0,280,"Caliente",null);
        Infusion i10 = new Infusion("Chai latte",880,true,0,"Te especiado, con leche",0,360,"Caliente",null);
        Infusion i11 = new Infusion("Capuccino",780,true,0,"Cafe con leche, chocolate y canela",0,200,"Caliente",null);
        Infusion i12 = new Infusion("Limonada",800,true,0,"Con menta y jengibre",0,360,"Frio",null);
        Infusion i13 = new Infusion("Frapuccino dulce de leche",1200,true,0,"Cafe frio con leche, crema y dulce de leche",0,360,"Frio",null);
        Infusion i14 = new Infusion("Cafe con leche",580,true,0,"2/3 cafe, 1/3 leche",0,180,"Caliente",null);

        HashSet<Producto> infusiones = new HashSet<>();
        infusiones.add(i1);
        infusiones.add(i2);
        infusiones.add(i3);
        infusiones.add(i4);
        infusiones.add(i5);
        infusiones.add(i6);
        infusiones.add(i7);
        infusiones.add(i8);
        infusiones.add(i9);
        infusiones.add(i10);
        infusiones.add(i11);
        infusiones.add(i12);
        infusiones.add(i13);
        infusiones.add(i14);

        ControladorArchivosObjetos.grabar(infusiones,"Infusion.dat");

         */


        Class<?> classType = Infusion.class;
        mostrarMenu("Infusion.dat",classType);

    }
    public static <T> void mostrarMenu(String nombreArchivo, Class<T> classType){
        HashSet<Producto> menu = new HashSet<>();
        menu = ControladorArchivosObjetos.leer(nombreArchivo);
        Iterator<Producto> it = menu.iterator();
        while(it.hasNext()){
            T aux = classType.cast(it.next());
            System.out.println(aux.toString());
        }
    }
}