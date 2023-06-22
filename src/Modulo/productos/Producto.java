package Modulo.productos;

public abstract class Producto {
    private String nombre;
    private double precio;
    private boolean disponible;
    private int cantidadVendidos;
    private String descripcion;

    public Producto(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.cantidadVendidos = cantidadVendidos;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", disponible=" + disponible +
                ", cantidadVendidos=" + cantidadVendidos +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
