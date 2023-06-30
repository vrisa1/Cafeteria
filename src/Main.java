import Modulo.Cafeteria;
import Modulo.InterfazGrafica.Login;

public class Main {
    public static void main(String[] args) {
        
        Cafeteria cafe = new Cafeteria();
        cafe.iniciar();
        Login login = new Login(cafe);

    }
}