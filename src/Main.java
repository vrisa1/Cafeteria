import Modulo.productos.bebidas.Infusion;
import Modulo.productos.bebidas.Leche;
import Modulo.usuarios.Cliente;
import Modulo.usuarios.Usuario;
import Modulo.genericas.ContenedorMapa;

public class Main {
    public static void main(String[] args) {

        ContenedorMapa<String, Usuario> usuarios = new ContenedorMapa<>();
        Usuario uno = new Cliente("1","primero","1234");

        usuarios.agregar(uno.getId(),uno);

        //System.out.println(usuarios.listar());
        Leche leche = Leche.VACA;
        System.out.println(leche);

    }
}