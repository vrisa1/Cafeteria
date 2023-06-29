
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

import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Cafeteria cafe = new Cafeteria();

        cafe.cargarMenu();

        System.out.println("\n" + cafe.mostrarMenu());


    }
}