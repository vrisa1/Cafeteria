import Modulo.Cafeteria;
import Modulo.productos.bebidas.Leche;
import Modulo.usuarios.Usuario;
import Modulo.genericas.ContenedorMapa;

public class Main {
    public static void main(String[] args) {

        Cafeteria cafeteria = new Cafeteria();



        try {
            cafeteria.CrearUsuario("aa","1234");

            int ingreso = cafeteria.login("aa","1234");
            System.out.println(ingreso);
        }catch (Exception e){

        }







    }
}