package Modulo.Excepciones;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ContraseñaIncorrectaException
 * Excepción lanzada al ingresar una contraseña no válida al iniciar sesión.
 */
public class ContraseñaIncorrectaException extends Exception{
    private String msg;
    private String usuario;
    private String fecha;

    /**
     * Constructor de la excepción. Guarda el usuario y la fecha del login fallido.
     * @param msg - Mensaje de error mostrado al usuario.
     * @param usuario - Usuario de la cuenta a la que se intentó ingresar.
     */
    public ContraseñaIncorrectaException(String msg, String usuario){
        this.msg = msg;
        this.usuario = usuario;
        this.fecha = setFecha();
    }

    /**
     * Método que almacena la fecha en que se lanzó la excepción.
     * @return fecha - Funciona como el setter de fecha para automatizar el registro.
     */
    private String setFecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(new Date());
    }

    /**
     * Al atrapar esta excepción, se mostrará el mensaje que este método retorna.
     * @return mensaje de error: String.
     */
    @Override
    public String getMessage() {
        return msg + "\n" + "Usuario: " + usuario + "\nFecha: " + fecha;
    }
}
