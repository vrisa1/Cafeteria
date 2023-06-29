package Modulo.Excepciones;

public class UsuarioNoExisteException extends Exception{

    private String msg;
    private String usuario;

    public UsuarioNoExisteException(String msg, String usuario){
        this.msg = msg;
        this.usuario = usuario;
    }

    @Override
    public String getMessage() {
        return msg + ": " + usuario;
    }

}
