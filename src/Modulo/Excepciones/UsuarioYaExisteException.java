package Modulo.Excepciones;

/**
 * UsuarioYaExisteException
 * Excepción lanzada al intentar crear una cuenta usando un nombre de usuario perteneciente a una cuenta distinta.
 */
public class UsuarioYaExisteException extends Exception{

    /**
     * Constructor de la excepción.
     * Llama a la superclase y envía el String recibido por parámetro,
     * el cual se mostrará al usuario al atrapar la excepción.
     * @param msg - Mensaje de error enviado al lanzarse la excepción.
     */
    public UsuarioYaExisteException(String msg){
        super(msg);
    }
}
