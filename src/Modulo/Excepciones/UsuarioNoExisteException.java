package Modulo.Excepciones;

/**
 * UsuarioNoExisteException
 * Excepción lanzada al intentar iniciar sesión con un nombre de usuario no válido.
 */
public class UsuarioNoExisteException extends Exception{

    private String msg;
    private String usuario;

    /**
     * Constructor de la excepción.
     * Almacena los datos ingresados durante el intento fallido de login.
     * @param msg - Mensaje de error enviado al lanzarse la excepción.
     * @param usuario - Usuario de la cuenta a la que se intentó ingresar.
     */
    public UsuarioNoExisteException(String msg, String usuario){
        this.msg = msg;
        this.usuario = usuario;
    }

    /**
     * Al atrapar esta excepción, se mostrará el mensaje que este método retorna.
     * @return mensaje de error: String.
     */
    @Override
    public String getMessage() {
        return msg + ": " + usuario;
    }

}
