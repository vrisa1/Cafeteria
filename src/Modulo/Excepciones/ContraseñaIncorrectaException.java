package Modulo.Excepciones;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContraseñaIncorrectaException extends Exception{

    private String msg;
    private String usuario;
    private String fecha;
    public ContraseñaIncorrectaException(String msg, String usuario){
        this.msg = msg;
        this.usuario = usuario;
        this.fecha = setFecha();
    }

    private String setFecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(new Date());
    }

    @Override
    public String getMessage() {
        return msg + "\n" + "Usuario: " + usuario + "\nFecha: " + fecha;
    }
}
