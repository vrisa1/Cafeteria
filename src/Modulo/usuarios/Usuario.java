package Modulo.usuarios;

public abstract class Usuario {
    private String id;
    private String nombreDeUsuario;
    private String contraseña;
    private boolean administrador;


    public Usuario(String id, String nombreDeUsuario, String contraseña) {
        this.id = id;
        this.nombreDeUsuario = nombreDeUsuario;
        this.contraseña = contraseña;
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

    //metodo crear usuario
}
