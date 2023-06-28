import Modulo.archivos.ControladorArchivosObjetos;
import Modulo.productos.Producto;
import Modulo.productos.bebidas.BebidaEnvasada;
import Modulo.productos.bebidas.Infusion;
import Modulo.productos.bebidas.Leche;
import Modulo.productos.comidas.Comida;
import Modulo.usuarios.Usuario;
import Modulo.genericas.ContenedorMapa;

import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        /*ContenedorMapa<String, Usuario> usuarios = new ContenedorMapa<>();
        Usuario uno = new Cliente("1","primero","1234");

        usuarios.agregar(uno.getId(),uno);

        //System.out.println(usuarios.listar());
        Leche leche = Leche.VACA;
        System.out.println(leche);*/



        HashSet<Producto> menu = new HashSet<>();
        menu = ControladorArchivosObjetos.leer("bebidaenvasada.dat");
        Iterator<Producto> it = menu.iterator();
        while(it.hasNext()){
            Producto aux = (BebidaEnvasada) it.next();
            System.out.println(aux.toString());
        }



    }
}