package Modulo.usuarios;

import java.util.Objects;

public class Usuario {
    private String id;
    private String nombreDeUsuario;
    private String contraseña;
    private boolean administrador;


    public Usuario(String id, String nombreDeUsuario, String contraseña, boolean administrador) {
        this.id = id;
        this.nombreDeUsuario = nombreDeUsuario;
        this.contraseña = contraseña;
        this.administrador = administrador;
    }

    public Usuario() {
        this.id = "";
        this.contraseña = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombreDeUsuario='" + nombreDeUsuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
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

    //metodo crear usuario
}
