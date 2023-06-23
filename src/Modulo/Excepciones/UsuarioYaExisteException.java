package Modulo.Excepciones;

public class UsuarioYaExisteException extends Exception{

    public UsuarioYaExisteException(String msg){
        super(msg);
    }
}
