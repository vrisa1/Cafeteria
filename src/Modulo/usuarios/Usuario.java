package Modulo.usuarios;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {

    //ATRIBUTOS----------------------------------------------------------------------------------------------------
    private String nombreDeUsuario;
    private String contraseña;
    private  String mail;
    private boolean administrador;

    //CONSTRUCTORES-----------------------------------------------------------------------------------------------

    public Usuario(String nombreDeUsuario, String contraseña, String mail) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.contraseña = contraseña;
        this.administrador = false;
        this.mail= mail;
    }

    public Usuario() {
        this.nombreDeUsuario = "";
        this.contraseña = "";
        this.administrador = false;
        this.mail = "";
    }

    //GETTERS Y SETTERS---------------------------------------------------------------------------------------------

    public String getMail() {
        return mail;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contrasenia) {
        this.contraseña = contrasenia;
    }

    //EQUALS Y TOSTRING--------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreDeUsuario='" + nombreDeUsuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", mail='" + mail + '\'' +
                ", administrador=" + administrador +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombreDeUsuario, usuario.nombreDeUsuario);
    }

    @Override
    public int hashCode() {
        return 1;
    }


}
