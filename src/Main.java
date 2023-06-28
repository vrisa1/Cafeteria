
import Modulo.archivos.ControladorArchivosObjetos;
import Modulo.productos.Producto;
import Modulo.productos.bebidas.BebidaEnvasada;
import Modulo.productos.bebidas.Infusion;
import Modulo.productos.bebidas.Leche;
import Modulo.productos.comidas.Comida;
import Modulo.Cafeteria;


import Modulo.usuarios.Usuario;
import Modulo.genericas.ContenedorMapa;

import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {


        Cafeteria cafeteria = new Cafeteria();



        try {
            cafeteria.CrearUsuario("aa","1234");

            int ingreso = cafeteria.login("aa","1234");
            System.out.println(ingreso);
        }catch (Exception e){

        }






        HashSet<Producto> menu = new HashSet<>();
        menu = ControladorArchivosObjetos.leer("bebidaenvasada.dat");
        Iterator<Producto> it = menu.iterator();
        while(it.hasNext()){
            Producto aux = (BebidaEnvasada) it.next();
            System.out.println(aux.toString());
        }


    }
}