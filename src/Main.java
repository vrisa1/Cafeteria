import Modulo.Cafeteria;
import Modulo.InterfazGrafica.CrearUsuario;
import Modulo.InterfazGrafica.Login;

public class Main {
    public static void main(String[] args) {

        Cafeteria cafeteria = new Cafeteria();

        cafeteria.crearAdmin();

        //CrearUsuario crearUsuario = new CrearUsuario(cafeteria);



        Login login = new Login(cafeteria);
        //InterfazAdmin interfazAdmin= new InterfazAdmin();




    }
}